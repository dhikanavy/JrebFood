package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CartModel extends Model{
	
	private Integer userId, foodId, quantity;

	public CartModel() {
		this.tableName = "carts";
	}

	@Override
	public void insert() {
		String query = String.format("INSERT INTO %s VALUES(?, ?, ?)", tableName);
		PreparedStatement ps = con.prepareStatement(query);
		
		try {
			ps.setInt(1, userId);
			ps.setInt(2, foodId);
			ps.setInt(3, quantity);
			
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
				Integer userId = rs.getInt("UserId");
				Integer foodId = rs.getInt("FoodId");
				Integer quantity = rs.getInt("Quantity");
				
				CartModel c = new CartModel();
				c.setUserId(userId);
				c.setFoodId(foodId);
				c.setQuantity(quantity);
				
				
				data.add(c);
			}
			
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<Model> getUserCart(int queryUserId) {
		ArrayList<Model> data = new ArrayList<>();
		
		String query = String.format("SELECT * FROM %s WHERE UserId=%d", tableName, queryUserId);
		ResultSet rs = con.executeQuery(query);
		
		try {
			while(rs.next()) {
				Integer userId = rs.getInt("UserId");
				Integer foodId = rs.getInt("FoodId");
				Integer quantity = rs.getInt("Quantity");
				
				CartModel c = new CartModel();
				c.setUserId(userId);
				c.setFoodId(foodId);
				c.setQuantity(quantity);
				
				
				data.add(c);
			}
			
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	

}
