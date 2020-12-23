package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

import controller.FoodController;
import model.CartController;
import model.CartModel;
import model.FoodModel;
import model.Model;
import model.UserModel;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;

public class ViewOrderView extends View{

	protected UserModel u;
	protected JButton btnNewButton_1, btnNewButton_2, btnBack;
	protected JScrollPane scrollPane;
	protected JList list;
	
	public ViewOrderView(UserModel u) {
		super();
		this.u = u;
		loadCart();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@Override
	public void initialize() {
		btnNewButton_1 = new JButton("Checkout");
        btnNewButton_1.setBounds(290, 24, 85, 21);
        
        btnNewButton_2 = new JButton("Remove");
        btnNewButton_2.setBounds(290, 55, 85, 21);
        
        btnBack = new JButton("Back");
        
        btnBack.setBounds(290, 86, 85, 21);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(21, 24, 231, 198);
        
        list = new JList();
        scrollPane.setViewportView(list);
        list.setFont(new Font("Tahoma", Font.PLAIN, 24));
        
	}
	
	@Override
	public void addComponent() {
		getContentPane().setLayout(null);
		getContentPane().add(btnNewButton_1);
		getContentPane().add(btnNewButton_2);
		getContentPane().add(btnBack);
		getContentPane().add(scrollPane);
	}
	
	@Override
	public void addListener() {
		btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new UserHomeView(u).showFrame();
        		setVisible(false);
        	}
        });
	}
	
	public void loadCart() {
		ArrayList<Model> cart = CartController.getInstance().getUserCart(u.getId());
		if(cart.size() != 0) {
			String[] values = new String[cart.size()];
			for(int i = 0; i < cart.size(); i++) {
				CartModel tempCart = ((CartModel) cart.get(i));
				FoodModel tempFood = FoodController.getInstance().getFoodById(tempCart.getFoodId());
				values[i] = tempFood.getName() + " x" + tempCart.getQuantity() + " | Rp. " + tempFood.getPrice() * tempCart.getQuantity();
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