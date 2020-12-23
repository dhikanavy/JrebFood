package view;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;

public class EmployeeView extends View{
	
	private JButton btnNewButton, btnHire, btnFire;
    private JList list;
    private JScrollPane scrollPane;
    private JLabel lblJrebfood;
	
	public EmployeeView() {
		super();
	}

	@Override
	public void initialize() {
        lblJrebfood = new JLabel("Financial Summary");
        lblJrebfood.setFont(new Font("Calibri Light", Font.BOLD, 18));
        lblJrebfood.setBounds(145, 10, 177, 39);
        
        btnNewButton = new JButton("Back");
        btnNewButton.setBounds(310, 136, 85, 21);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(67, 76, 198, 149);
        
        list = new JList();
        scrollPane.setViewportView(list);
        list.setModel(new AbstractListModel() {
        	String[] values = new String[] {"Employee_1", "Employee_2", "Employee_3", "Employee_4"};
        	public int getSize() {
        		return values.length;
        	}
        	public Object getElementAt(int index) {
        		return values[index];
        	}
        });
        
        btnHire = new JButton("Hire");
        btnHire.setBounds(310, 74, 85, 21);
        
        btnFire = new JButton("Fire");
        btnFire.setBounds(310, 105, 85, 21);	
	}

    @Override
    public void addComponent(){
    	getContentPane().setLayout(null);
        getContentPane().add(lblJrebfood);
        getContentPane().add(btnNewButton);
        getContentPane().add(scrollPane);
        getContentPane().add(btnHire);
        getContentPane().add(btnFire);
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
