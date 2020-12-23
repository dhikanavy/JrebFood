package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FoodModel extends Model{
	private int id;
	private String name;
	private int price;
	private String desc, status;
	

	public FoodModel() {
		this.tableName = "foods";
	}


	@Override
	public void insert() {
		String query = String.format("INSERT INTO %s VALUES(null, ?, ?, ?, ?)", tableName);
		PreparedStatement ps = con.prepareStatement(query);
		
		try {
			ps.setString(1, name);
			ps.setInt(2, price);
			ps.setString(3, desc);
			ps.setString(4, status);
			
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
				Integer price = rs.getInt("Price");
				String desc = rs.getString("Description");
				String status = rs.getString("Status");
				
				FoodModel f = new FoodModel();
				f.setId(id);
				f.setName(name);
				f.setPrice(price);
				f.setDesc(desc);
				f.setStatus(status);
				
				data.add(f);
			}
			
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public FoodModel getFoodById(int queryId) {
		String query = String.format("SELECT * FROM %s WHERE Id='%s'", tableName, queryId);
		ResultSet rs = con.executeQuery(query);
		
		try {
			if(rs.next()) {
				Integer id = rs.getInt("Id");
				String name = rs.getString("Name");
				Integer price = rs.getInt("Price");
				String desc = rs.getString("Description");
				String status = rs.getString("Status");
				
				FoodModel f = new FoodModel();
				f.setId(id);
				f.setName(name);
				f.setPrice(price);
				f.setDesc(desc);
				f.setStatus(status);
				
				return f;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
}
