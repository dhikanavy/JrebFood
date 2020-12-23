package controller;

import java.util.ArrayList;

import model.FoodModel;
import model.Model;
import model.UserModel;
import view.View;

public class FoodController extends Controller{
	
	private FoodModel food = new FoodModel();
	private static FoodController controller;

	private FoodController() {
		// TODO Auto-generated constructor stub
	}
	
	public static FoodController getInstance() {
		return controller = (controller == null) ? new FoodController() : controller;
	}
	
	@Override
	public View view() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void insert(String name, int price, String desc, String status) {
		FoodModel f = new FoodModel();
		f.setName(name);
		f.setPrice(price);
		f.setDesc(desc);
		f.setStatus(status);
		
		f.insert();
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Model> getAll() {
		
		return food.getAll();
	}
	
	public FoodModel getFoodById(int queryId) {
		
		return food.getFoodById(queryId);
	}
}
