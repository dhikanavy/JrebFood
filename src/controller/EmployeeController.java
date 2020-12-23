package controller;

import java.sql.Date;
import java.util.ArrayList;

import model.EmployeeModel;
import model.Model;
import view.View;

public class EmployeeController extends Controller{
	
	private EmployeeModel employee;
	private static EmployeeController controller;

	private EmployeeController() {
		// TODO Auto-generated constructor stub
	}
	
	public static EmployeeController getInstance() {
		return controller = (controller == null) ? new EmployeeController() : controller;
	}

	@Override
	public View view() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Model> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public EmployeeModel getEmployee(String queryEmail, String queryPassword) {
		EmployeeModel employee = new EmployeeModel();
		employee = employee.getEmployee(queryEmail, queryPassword);
		
		if(employee != null && employee.getPassword().equals(queryPassword)) {
			return employee;
		}
		
		return null;
	}

}
