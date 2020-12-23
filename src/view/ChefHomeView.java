package view;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ChefHomeView extends View{
    private JLabel lblJrebfood;
    private JButton btnNewButton, btnNewButton_1, button;

	public ChefHomeView() {
		super();
	}

	@Override
	public void initialize() {
	lblJrebfood = new JLabel("Chef");
        lblJrebfood.setHorizontalAlignment(SwingConstants.CENTER);
        lblJrebfood.setFont(new Font("Calibri Light", Font.BOLD, 18));
        lblJrebfood.setBounds(128, 4, 177, 39);
        
        btnNewButton = new JButton("Menu");
        btnNewButton.setBounds(175, 53, 85, 21);
        
        btnNewButton_1 = new JButton("Food Availability");
        btnNewButton_1.setBounds(175, 84, 85, 21);
        
        button = new JButton("Prepare Order");
        button.setBounds(175, 115, 85, 21);		
	}

    @Override
    public void addComponent(){
    	getContentPane().setLayout(null);
        getContentPane().add(lblJrebfood);
        getContentPane().add(btnNewButton);
        getContentPane().add(btnNewButton_1);
        getContentPane().add(button);
    }

    @Override
    public void addListener(){
        btnNewButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
//                new chefmenu().frame();
//                setVisible(false);
	        }
        });

        btnNewButton_1.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
//                new foodavailability().setVisible(true);
//                setVisible(false);
	        }
        });

        button.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
//                new prepareorder().frame();
//                setVisible(false);
	        }
        });
    }
}
