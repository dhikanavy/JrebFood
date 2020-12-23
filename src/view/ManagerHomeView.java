package view;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ManagerHomeView extends View{
    private JLabel lblJrebfood;
    private JButton btnFinancialSummary, btnEmployee;

	public ManagerHomeView() {
		super();
	}

	@Override
	public void initialize() {
        lblJrebfood = new JLabel("Manager");
        lblJrebfood.setHorizontalAlignment(SwingConstants.CENTER);
        lblJrebfood.setFont(new Font("Calibri Light", Font.BOLD, 18));
        lblJrebfood.setBounds(128, 4, 177, 39);
        
        btnFinancialSummary = new JButton("Financial Summary");
        btnFinancialSummary.setBounds(151, 54, 131, 21);
        
        btnEmployee = new JButton("Employee");
        btnEmployee.setBounds(151, 86, 131, 21);	
	}

        @Override
        public void addComponent(){
        	getContentPane().setLayout(null);
            getContentPane().add(lblJrebfood);
            getContentPane().add(btnFinancialSummary);
            getContentPane().add(btnEmployee);
        }

        @Override
        public void addListener(){
            btnFinancialSummary.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
//	                new financialsummary().frame();
//	                setVisible(false);
	            }
            });

            btnEmployee.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
//	                new employee().frame();
//	                setVisible(false);
	            }
            });
        }
}
