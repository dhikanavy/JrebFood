package view;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TakeOrderView extends View{
    private JLabel lblJrebfood;
	private JButton btnNewButton, btnNewButton_1, button;

	public TakeOrderView() {
		super();
	}

	@Override
	public void initialize() {
        lblJrebfood = new JLabel("Active Order");
        lblJrebfood.setFont(new Font("Calibri Light", Font.BOLD, 18));
        lblJrebfood.setBounds(128, 4, 177, 39);
        
        btnNewButton = new JButton("Order to Restaurant");
        btnNewButton.setBounds(175, 53, 85, 21);
        
        btnNewButton_1 = new JButton("Deliver Order");
        btnNewButton_1.setBounds(175, 84, 85, 21);
        
        button = new JButton("Back");
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
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                new vieworderlist().frame();
                setVisible(false);
            }
        });
    }
}
