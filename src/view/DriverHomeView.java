package view;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class DriverHomeView extends View{
    private JLabel lblJrebfood;
    private JButton btnNewButton, btnNewButton_1;

	public DriverHomeView() {
		super();
	}

	@Override
	public void initialize() {
        lblJrebfood = new JLabel("Driver");
        lblJrebfood.setHorizontalAlignment(SwingConstants.CENTER);
        lblJrebfood.setFont(new Font("Calibri Light", Font.BOLD, 18));
        lblJrebfood.setBounds(128, 4, 177, 39);
        
        btnNewButton = new JButton("Order List");
        btnNewButton.setBounds(153, 54, 130, 21);
        
        btnNewButton_1 = new JButton("Order History");
        btnNewButton_1.setBounds(153, 86, 130, 21);		
	}

    @Override
    public void addComponent(){
    	getContentPane().setLayout(null);
        getContentPane().add(lblJrebfood);
        getContentPane().add(btnNewButton);
        getContentPane().add(btnNewButton_1);
    }

    @Override
    public void addListener(){
	    btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		//                        new vieworderlist().setVisible(true);
		            setVisible(false);
		    }
	    });
	
	    btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		//                        new vieworderhistory().frame();
		            setVisible(false);
		    }
	    });
    }
}