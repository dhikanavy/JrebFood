package view;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import controller.UserController;

public class RegisterView extends View{
	private JLabel lblJrebfood, lblName, lblNewLabel, lblEmail, lblPassword, lblPhoneNumber;
	private JButton btnRegister;
	private JTextField tfRegisterName;
	private JTextField tfRegisterAddress;
	private JTextField tfRegisterEmail;
	private JTextField tfRegisterPassword;
	private JTextField tfRegisterPhoneNumber;

	
	public RegisterView() {
		super();
	}

	@Override
	public void initialize() {
        lblJrebfood = new JLabel("JrebFood");
        lblJrebfood.setFont(new Font("Calibri Light", Font.BOLD, 10));
        lblJrebfood.setBounds(195, 10, 46, 13);
        
        lblName = new JLabel("Name");
        lblName.setBounds(10, 55, 46, 13);
        
        lblNewLabel = new JLabel("Adress");
        lblNewLabel.setBounds(10, 78, 46, 13);
        
        lblEmail = new JLabel("Email");
        lblEmail.setBounds(10, 101, 46, 13);
        
        lblPassword = new JLabel("Password");
        lblPassword.setBounds(10, 124, 46, 13);
        
        lblPhoneNumber = new JLabel("Phone Number");
        lblPhoneNumber.setBounds(10, 147, 68, 13);
        
        tfRegisterName = new JTextField();
        tfRegisterName.setBounds(90, 52, 96, 19);
        tfRegisterName.setColumns(10);
        
        tfRegisterAddress = new JTextField();
        tfRegisterAddress.setBounds(90, 75, 96, 19);
        tfRegisterAddress.setColumns(10);
        
        tfRegisterEmail = new JTextField();
        tfRegisterEmail.setBounds(90, 98, 96, 19);
        tfRegisterEmail.setColumns(10);
        
        tfRegisterPassword = new JTextField();
        tfRegisterPassword.setBounds(90, 121, 96, 19);
        tfRegisterPassword.setColumns(10);
        
        tfRegisterPhoneNumber = new JTextField();
        tfRegisterPhoneNumber.setBounds(90, 144, 96, 19);
        tfRegisterPhoneNumber.setColumns(10);
        
        btnRegister = new JButton("Register");
        btnRegister.setBounds(180, 207, 85, 21);
	}
	
	@Override
	public void addComponent() {
		getContentPane().setLayout(null);
		getContentPane().add(lblJrebfood);
        getContentPane().add(lblName);
        getContentPane().add(lblNewLabel);
        getContentPane().add(lblEmail);
        getContentPane().add(lblPassword);
        getContentPane().add(lblPhoneNumber);
        getContentPane().add(tfRegisterName);
        getContentPane().add(tfRegisterAddress);
        getContentPane().add(tfRegisterEmail);
        getContentPane().add(tfRegisterPassword);
        getContentPane().add(tfRegisterPhoneNumber);
        getContentPane().add(btnRegister);
	}
	
	@Override
	public void addListener() {
		btnRegister.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String name = tfRegisterName.getText();
        		String address = tfRegisterAddress.getText();
        		String email = tfRegisterEmail.getText();
        		String password = tfRegisterPassword.getText();
        		String phoneNumber = tfRegisterPhoneNumber.getText();
        		
        		UserController.getInstance().insert(name, address, email, phoneNumber, password);
        		
        		new LoginView().setVisible(true);
        		setVisible(false);
        	}
        });
	}
}
