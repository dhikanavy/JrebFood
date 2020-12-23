package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;

public class FinancialSummaryView extends View{
	private JButton btnNewButton;
    private JLabel lblJrebfood;
    private JScrollPane scrollPane;
    private JList list;
	
	public FinancialSummaryView() {
		super();
	}

	@Override
	public void initialize() {
        lblJrebfood = new JLabel("Financial Summary");
        lblJrebfood.setFont(new Font("Calibri Light", Font.BOLD, 18));
        lblJrebfood.setBounds(145, 10, 177, 39);
        
        
        btnNewButton = new JButton("Back");
        btnNewButton.setBounds(310, 76, 85, 21);
        
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(67, 76, 198, 149);
        
        
        list = new JList();
        scrollPane.setViewportView(list);
        list.setModel(new AbstractListModel() {
        	String[] values = new String[] {"Summary_1", "Summary_2", "Summary_3", "Summary_4"};
        	public int getSize() {
        		return values.length;
        	}
        	public Object getElementAt(int index) {
        		return values[index];
        	}
        });		
	}

    @Override
    public void addComponent(){
    	getContentPane().setLayout(null);
        getContentPane().add(lblJrebfood);
        getContentPane().add(btnNewButton);
        getContentPane().add(scrollPane);
    }

    @Override
    public void addListener(){
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ManagerHomeView().showFrame();
                setVisible(false);
            }
        });
    }
}
