package controller;

import java.util.ArrayList;

import model.Model;
import model.UserModel;
import view.View;

public class UserController extends Controller{
	
	private UserModel user;
	private static UserController controller;

	private UserController() {
		
	}
	
	public static UserController getInstance() {
		return controller = (controller == null) ? new UserController() : controller;
	}

	@Override
	public View view() {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(String name, String address, String email, String phoneNumber, String password) {
		UserModel u = new UserModel();
		u.setName(name);
		u.setAddress(address);
		u.setEmail(email);
		u.setPhoneNumber(phoneNumber);
		u.setPassword(password);
		
		u.insert();
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Model> getAll() {
		
		return user.getAll();
	}
	
	public UserModel getUser(String queryEmail, String queryPassword) {
		UserModel u = new UserModel();
		u = u.getUser(queryEmail);
		
		if(u != null && u.getPassword().equals(queryPassword)) {
			return u;
		}
		
		return null;
	}

}
