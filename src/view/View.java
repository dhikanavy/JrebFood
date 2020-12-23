package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public abstract class View extends JFrame {
	
//	protected int width;
//	protected int height;

	public View() {
		initialize();
		addComponent();
		addListener();
	}
	
	public void showFrame() {
		setLocationRelativeTo(null);
        setResizable(false);
        setSize(new Dimension(460, 300));
        getContentPane().setBackground(Color.WHITE);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setIconImage(new ImageIcon("assets/logopizza.png").getImage());
        setTitle("JrebFood");
        getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
	}
	
	public abstract void initialize();
	public abstract void addComponent();
	public abstract void addListener();

}