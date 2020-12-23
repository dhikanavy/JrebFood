package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmployeeModel extends Model{
	private int id, roleId;
	private String name;
	private Date dob;
	private String email, password, status, licensePlate, position;

	public EmployeeModel() {
		this.tableName = "employees";
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}
	
	public EmployeeModel getEmployee(String queryEmail, String queryPassword) {
		String query = String.format("SELECT * FROM %s WHERE Email='%s'", tableName, queryEmail);
		ResultSet rs = con.executeQuery(query);
		
		try {
			if(rs.next()) {
				Integer id = rs.getInt("Id");
				Integer roleId = rs.getInt("RoleId");
				String name = rs.getString("Name");
				Date dob = rs.getDate("DOB");
				String email = rs.getString("Email");
				String password = rs.getString("Password");
				String status = rs.getString("Status");
				String licensePlate = rs.getString("LicensePlate");
				String position = rs.getString("Position");
				
				EmployeeModel employee = new EmployeeModel();
				employee.setId(id);
				employee.setRoleId(roleId);
				employee.setName(name);
				employee.setDob(dob);
				employee.setEmail(email);
				employee.setPassword(password);
				employee.setStatus(status);
				employee.setLicensePlate(licensePlate);
				employee.setPosition(position);
				
				return employee;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLicencePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
