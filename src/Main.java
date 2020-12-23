import java.awt.EventQueue;

import view.MainView;
import view.LoginView;

public class Main {
	
	public Main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// login window = new login();
					MainView home = new MainView();
					home.showFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) {
		new Main();
	}

}
