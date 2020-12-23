package view;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import controller.EmployeeController;
import controller.UserController;
import model.EmployeeModel;
import model.UserModel;

//import view.chefhomepage;
//import view.driverhomepage;
//import view.managerhomepage;
//import view.usermenu;
//import view.userhomepage;

public class LoginView extends View{
	private JTextField tfemail, tfpassword;
	private JLabel lblJrebfood, lblEmail, lblPassword;
	private JButton btnLoginCustomer, btnLoginEmployee;

	
	public LoginView() {
		super();
	}

	@Override
	public void initialize() {
        lblJrebfood = new JLabel("JrebFood");
        lblJrebfood.setFont(new Font("Calibri Light", Font.BOLD, 10));
        lblJrebfood.setBounds(195, 10, 46, 13);
        
        
        btnLoginCustomer = new JButton("Login as Customer");
        btnLoginCustomer.setBounds(69, 182, 143, 21);
        
        
        lblEmail = new JLabel("Email");
        lblEmail.setBounds(10, 61, 46, 13);
        
        
        lblPassword = new JLabel("Password");
        lblPassword.setBounds(10, 84, 46, 13);
        
        
        tfemail = new JTextField();
        tfemail.setBounds(66, 58, 96, 19);
        
        tfemail.setColumns(10);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(66, 81, 96, 19);
        
        tfpassword.setColumns(10);
        
        btnLoginEmployee = new JButton("Login as Employee");
        btnLoginEmployee.setBounds(256, 181, 143, 23);
        
	}
	
	@Override
	public void addComponent() {
		getContentPane().setLayout(null);
		getContentPane().add(lblJrebfood);
		getContentPane().add(btnLoginCustomer);
		getContentPane().add(lblEmail);
		getContentPane().add(lblPassword);
		getContentPane().add(tfemail);
		getContentPane().add(tfpassword);
		getContentPane().add(btnLoginEmployee);
	}
	
	@Override
	public void addListener() {
		btnLoginCustomer.addActionListener(new ActionListener() {
			
			@Override
        	public void actionPerformed(ActionEvent e) {
        		String email = tfemail.getText();
        		String password = tfpassword.getText();
        		
        		UserModel u = UserController.getInstance().getUser(email, password);
        		if(u != null) {
        			JOptionPane.showMessageDialog(getContentPane(), String.format("Login Success"));
        			UserHomeView uhv = new UserHomeView(u);
        			uhv.showFrame();
        			setVisible(false);
        		}else {
        			JOptionPane.showMessageDialog(getContentPane(), "Login Failed : Wrong Email or Password!");
        		}
        		
        	}
        });
		
		btnLoginEmployee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String email = tfemail.getText();
        		String password = tfpassword.getText();
        		
        		EmployeeModel employee = EmployeeController.getInstance().getEmployee(email, password);
        		if(employee != null) {
        			JOptionPane.showMessageDialog(getContentPane(), String.format("Login Success"));
        			if(employee.getRoleId() == 1) {
        				new ManagerHomeView().showFrame();
        				setVisible(false);
        			}else if(employee.getRoleId() == 2) {
        				new ChefHomeView().showFrame();
        				setVisible(false);
        			}else {
        				new DriverHomeView().showFrame();
        				setVisible(false);
        			}
        		}else {
        			JOptionPane.showMessageDialog(getContentPane(), "Login Failed : Wrong Email or Password!");
        		}
			}
		});
	}
}
