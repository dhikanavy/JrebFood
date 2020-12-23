package view;

import javax.swing.JLabel;

import model.UserModel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserHomeView extends View{
	
	protected UserModel u;
	protected JLabel lblJrebfood, lblUserName;
	protected JButton btnMenu,btnOrder;

	
	public UserHomeView(UserModel u) {
		super();
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.u = u;
		this.lblUserName.setText(u.getName());
	}

	@Override
	public void initialize() { 
        lblJrebfood = new JLabel("Welcome to JrebFood");
        lblJrebfood.setFont(new Font("Calibri Light", Font.BOLD, 18));
        lblJrebfood.setBounds(128, 4, 177, 39);
        
        btnMenu = new JButton("Menu");
        btnMenu.setBounds(128, 104, 85, 21);
        
        btnOrder = new JButton("Order");
        btnOrder.setBounds(223, 104, 85, 21);
        
        lblUserName = new JLabel("Name");
        lblUserName.setBounds(194, 49, 46, 14);
	}
	
	@Override
	public void addComponent() {
		getContentPane().setLayout(null);
		getContentPane().add(lblJrebfood);
		getContentPane().add(btnMenu);
		getContentPane().add(btnOrder);
		getContentPane().add(lblUserName);
	}
	
	@Override
	public void addListener() {
		btnMenu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new UserMenuView(u).showFrame();
        		setVisible(false);
        	}
        });
		
		btnOrder.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
//        		new vieworder().setVisible(true);
        		setVisible(false);
        	}
        });
	}
}
