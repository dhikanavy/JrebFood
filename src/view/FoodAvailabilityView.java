package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Font;
import javax.swing.JButton;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;

public class FoodAvailabilityView extends View{
    private JButton btnBack,btnNewButton_1,btnNewButton_2;
    private JScrollPane scrollPane;
    private JList list;
	
	public FoodAvailabilityView() {
		super();
	}

	@Override
	public void initialize() {
		btnNewButton_1 = new JButton("Available");
        btnNewButton_1.setBounds(290, 24, 85, 21);
        
        btnNewButton_2 = new JButton("Unavailable");
        btnNewButton_2.setBounds(290, 55, 85, 21);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(21, 24, 231, 198);
        
        list = new JList();
        scrollPane.setViewportView(list);
        list.setFont(new Font("Tahoma", Font.PLAIN, 24));
        list.setModel(new AbstractListModel() {
        	String[] values = new String[] {"Mie Ayam", "Bakso", "Kwetiauw", "Nasi Goreng", "Nasi Hainan", "Nasi Bakar", "Nasi Kebuli"};
        	public int getSize() {
        		return values.length;
        	}
        	public Object getElementAt(int index) {
        		return values[index];
        	}
        });
        
        btnBack = new JButton("Back");
        btnBack.setBounds(290, 86, 85, 21);
	}

    @Override
    public void addComponent(){
    	getContentPane().setLayout(null);
        getContentPane().add(btnNewButton_1);
        getContentPane().add(btnNewButton_2);
        getContentPane().add(btnBack);
        getContentPane().add(scrollPane);
    }

    @Override
    public void addListener(){
        btnBack.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
                new ChefHomeView().showFrame();
                setVisible(false);
	        }
        });
    }
}