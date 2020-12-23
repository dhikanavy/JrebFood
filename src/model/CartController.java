package model;

import java.util.ArrayList;

import controller.Controller;
import controller.FoodController;
import view.View;

public class CartController extends Controller{
	
	private CartModel cart = new CartModel();
	private static CartController controller;

	private CartController() {
		// TODO Auto-generated constructor stub
	}
	
	public static CartController getInstance() {
		return controller = (controller == null) ? new CartController() : controller;
	}
	
	@Override
	public View view() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void insert(int userId, int foodId, int quantity) {
		CartModel c = new CartModel();
		c.setUserId(userId);
		c.setFoodId(foodId);
		c.setQuantity(quantity);
		
		c.insert();
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Model> getAll() {
		
		return cart.getAll();
	}
	
	public ArrayList<Model> getUserCart(int queryUserId) {
		
		return cart.getUserCart(queryUserId);
	}

}
