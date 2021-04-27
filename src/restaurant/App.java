package restaurant;

import javax.swing.JFrame;

public class App {
	
	public static JFrame frame;
	public static Home home;
	
	public static void init() {

		frame.setTitle("Restaurants");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(50, 50, 1500, 800);
		frame.setLayout(null);
		home = new Home();
		frame.add(home);
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		frame = new JFrame();
		init();
		frame.setVisible(true);
	}
}
