package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import controller.FoodController;
import model.FoodModel;
import model.Model;
import model.UserModel;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;

public class UserMenuView extends View{

	protected UserModel u;
	protected JButton btnAddToCart, btnViewOrder;
	protected JButton btnBack;
	protected JScrollPane scrollPane;
	protected JList list;
	
	public UserMenuView(UserModel u) {
		super();
		this.u = u;
		loadMenu();
	}

	
	@Override
	public void initialize() {
		btnAddToCart = new JButton("Add to Cart");
        btnAddToCart.setBounds(290, 24, 134, 21);
        
        btnViewOrder = new JButton("View Order");
        btnViewOrder.setBounds(290, 55, 134, 21);
        
        
        btnBack = new JButton("Back");
        btnBack.setBounds(290, 86, 134, 21);
        
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(21, 24, 231, 198);
        
        
        list = new JList();
        scrollPane.setViewportView(list);
        list.setFont(new Font("Tahoma", Font.PLAIN, 14));
	}
	
	@Override
	public void addComponent() {
		getContentPane().setLayout(null);
		getContentPane().add(btnAddToCart);
		getContentPane().add(btnViewOrder);
		getContentPane().add(btnBack);
		getContentPane().add(scrollPane);
	}
	
	@Override
	public void addListener() {
		btnViewOrder.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println(u.getName());
        		new ViewOrderView(u).showFrame();
        		setVisible(false);
        	}
        });
		
		btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new UserHomeView(u).showFrame();
        		setVisible(false);
        	}
        });
	}
	
	public void loadMenu() {
		ArrayList<Model> foods = FoodController.getInstance().getAll();
		if(foods.size() != 0) {
			String[] values = new String[foods.size()];
			for(int i = 0; i < foods.size(); i++) {
				values[i] = ((FoodModel)foods.get(i)).getName() + " | Rp. " + ((FoodModel)foods.get(i)).getPrice();
			}
			
			list.setModel(new AbstractListModel() {
	        	public int getSize() {
	        		return values.length;
	        	}
	        	public Object getElementAt(int index) {
	        		return values[index];
	        	}
	        });
		}
	}
}
