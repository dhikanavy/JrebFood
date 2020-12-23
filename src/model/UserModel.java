package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserModel extends Model{
	
	private Integer id;
	private String name;
	private String address;
	private String email;
	private String phoneNumber;
	private String password;

	public UserModel() {
		this.tableName = "users";
	}

	@Override
	public void insert() {
		String query = String.format("INSERT INTO %s VALUES(null, ?, ?, ?, ?, ?)", tableName);
		PreparedStatement ps = con.prepareStatement(query);
		
		try {
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setString(3, email);
			ps.setString(4, phoneNumber);
			ps.setString(5, password);
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Model> getAll() {
		ArrayList<Model> data = new ArrayList<>();
		
		String query = String.format("SELECT * FROM %s", tableName);
		ResultSet rs = con.executeQuery(query);
		
		try {
			while(rs.next()) {
				Integer id = rs.getInt("Id");
				String name = rs.getString("Name");
				String address = rs.getString("Address");
				String email = rs.getString("Email");
				String phoneNumber = rs.getString("PhoneNumber");
				String password = rs.getString("Password");
				
				UserModel u = new UserModel();
				u.setId(id);
				u.setName(name);
				u.setAddress(address);
				u.setEmail(email);
				u.setPhoneNumber(phoneNumber);
				u.setPassword(password);
				
				data.add(u);
			}
			
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public UserModel getUser(String queryEmail) {
		String query = String.format("SELECT * FROM %s WHERE Email='%s'", tableName, queryEmail);
		ResultSet rs = con.executeQuery(query);
		
		try {
			if(rs.next()) {
				Integer id = rs.getInt("Id");
				String name = rs.getString("Name");
				String address = rs.getString("Address");
				String email = rs.getString("Email");
				String phoneNumber = rs.getString("PhoneNumber");
				String password = rs.getString("Password");
				
				UserModel u = new UserModel();
				u.setId(id);
				u.setName(name);
				u.setAddress(address);
				u.setEmail(email);
				u.setPhoneNumber(phoneNumber);
				u.setPassword(password);
				
				return u;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
