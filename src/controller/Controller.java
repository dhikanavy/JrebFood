package controller;

import java.util.ArrayList;

import model.Model;
import view.View;

public abstract class Controller {

	public Controller() {
		// TODO Auto-generated constructor stub
	}
	
	
	public abstract View view();
	public abstract ArrayList<Model> getAll();

}
