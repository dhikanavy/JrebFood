package view;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView extends View{
	
	private JLabel lblJrebfood, lblNewLabel;
	private JButton btnLogin, btnRegister;

	public MainView() {
		super();
	}

	@Override
	public void initialize() {
		
        lblJrebfood = new JLabel("Welcome to JrebFood");
        lblJrebfood.setFont(new Font("Calibri Light", Font.BOLD, 18));
        lblJrebfood.setBounds(128, 4, 177, 39);
        
        btnLogin = new JButton("Login");
        btnLogin.setBounds(175, 52, 85, 21);
        
        lblNewLabel = new JLabel("Dont have an account?");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel.setBounds(155, 92, 132, 13);
        
        btnRegister = new JButton("Register");
        btnRegister.setBounds(175, 125, 85, 21);
        
	}
	
	@Override
	public void addComponent() {
		getContentPane().setLayout(null);
		getContentPane().add(lblJrebfood);
		getContentPane().add(btnLogin);
		getContentPane().add(lblNewLabel);
		getContentPane().add(btnRegister);
	}
	
	@Override
	public void addListener() {
		btnLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new LoginView().showFrame();
        		setVisible(false);
        	}
        });
		
		btnRegister.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new RegisterView().showFrame();
        		setVisible(false);
        	}
        });
	}
}
