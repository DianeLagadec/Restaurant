package restaurant;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class App {
	
	public static JFrame frame;
	public static Home home;
	public static RestaurantInfos restaurantInfos;
	public static RestaurantPanel restaurantPanel;
	private static JMenu utils, adds, restaurant;
	private static JMenuItem quit, homeMenu, addRestaurant, resto;
	public static RestaurantProfessional restaurantProfessional;
	public static SendMessage sendMessage;
	
	private static JMenuBar initMenu() {
		utils = new JMenu("Home");
		adds = new JMenu("Manage");
		restaurant = new JMenu("Restaurant");
		
		quit = new JMenuItem(new AbstractAction("Exit") {
			private static final long serialVersionUID = 1L;
			public void actionPerformed(ActionEvent e) {
        		System.exit(0);
 		    }
 		});
		
		homeMenu = new JMenuItem(new AbstractAction("Home") {
			private static final long serialVersionUID = 1L;
        	public void actionPerformed(ActionEvent e) {
        		home.setVisible(true);
        		restaurantInfos.setVisible(false);
        		restaurantPanel.setVisible(false);
        		restaurantProfessional.setVisible(false);
        		sendMessage.setVisible(false);
 		    }
 		});
		
		addRestaurant = new JMenuItem(new AbstractAction("Add restaurant") {
			private static final long serialVersionUID = 1L;
        	public void actionPerformed(ActionEvent e) {
        		home.setVisible(false);
        		restaurantInfos.setVisible(false);
        		restaurantPanel.setVisible(false);
        		restaurantProfessional.setVisible(false);
        		sendMessage.setVisible(false);
        	}
		});
		
		resto = new JMenuItem(new AbstractAction("Restaurant") {
			private static final long serialVersionUID = 1L;
        	public void actionPerformed(ActionEvent e) {
        		home.setVisible(false);
        		restaurantInfos.setVisible(false);
        		restaurantPanel.setVisible(true);
        		restaurantProfessional.setVisible(false);
        		sendMessage.setVisible(false);
 		    }
 		});
		
		utils.add(homeMenu);
		utils.add(quit);
		adds.add(addRestaurant);
		restaurant.add(resto);
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(utils);
		menuBar.add(adds);
		menuBar.add(restaurant);		
		return menuBar;
	}
		
	public static void init() {
		
		
		frame.setTitle("Restaurants");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(50, 50, 1500, 800);
		frame.setLayout(null);
		home = new Home();
		frame.add(home);
		restaurantInfos = new RestaurantInfos();
		restaurantPanel = new RestaurantPanel();
		restaurantProfessional = new RestaurantProfessional();
		sendMessage = new SendMessage();
		frame.add(restaurantInfos).setVisible(false);
		frame.add(restaurantInfos).setVisible(false);
		frame.add(restaurantPanel).setVisible(false);
		frame.add(restaurantProfessional).setVisible(false);
		frame.add(sendMessage).setVisible(false);
		frame.setJMenuBar(initMenu());
	}
	
	
	public static void setVisibilityRestaurantInfo() {
		home.setVisible(false);
		restaurantInfos.setVisible(true);
		restaurantPanel.setVisible(false);
		restaurantProfessional.setVisible(false);
		sendMessage.setVisible(false);
		
	}
	
	public static void setVisibilityRestaurantProfessional() {
		home.setVisible(false);
		restaurantInfos.setVisible(false);
		restaurantPanel.setVisible(false);
		restaurantProfessional.setVisible(true);
		sendMessage.setVisible(false);
	}
	
	public static void setVisibilityToSendMessage() {
		home.setVisible(false);
		restaurantInfos.setVisible(false);
		restaurantPanel.setVisible(false);
		restaurantProfessional.setVisible(false);
		sendMessage.setVisible(true);
	}
	
	public static void main(String[] args) {
		frame = new JFrame();
		init();
		frame.setVisible(true);
	}
}
