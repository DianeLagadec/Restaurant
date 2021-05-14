package restaurant;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class App {
	
	private static JMenu utils, adds, restaurant;
	private static JMenuItem quit, homeMenu, addIngredient, addPlat, addRestaurant, resto;
	public static Home home;
	public static RestaurantInfos restaurantInfos;
	public static RestaurantPanel restaurantPanel;
	public static RestaurantProfessional restaurantProfessional;
	public static SendMessage sendMessage;
	public static JFrame frame;
	public static BookReservation bookReservation;
	public static Notation notation;
	
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
        		bookReservation.setVisible(false);
        		notation.setVisible(false);
 		    }
 		});
		
		addIngredient = new JMenuItem(new AbstractAction("Add ingredient") {
			private static final long serialVersionUID = 1L;
        	public void actionPerformed(ActionEvent e) {
        		home.setVisible(false);
        		restaurantInfos.setVisible(false);
        		restaurantPanel.setVisible(false);
        		restaurantProfessional.setVisible(false);
        		sendMessage.setVisible(false);
        		bookReservation.setVisible(false);
        		notation.setVisible(false);
        		
 		    }
 		});
		
		addPlat = new JMenuItem(new AbstractAction("Add plat") {
			private static final long serialVersionUID = 1L;
        	public void actionPerformed(ActionEvent e) {
        		home.setVisible(false);
        		restaurantInfos.setVisible(false);
        		restaurantPanel.setVisible(false);
        		restaurantProfessional.setVisible(false);
        		sendMessage.setVisible(false);
        		bookReservation.setVisible(false);
        		notation.setVisible(false);
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
        		bookReservation.setVisible(false);
        		notation.setVisible(false);
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
        		bookReservation.setVisible(false);
        		notation.setVisible(false);
 		    }
 		});
		
		utils.add(homeMenu);
		utils.add(quit);
		adds.add(addIngredient);
		adds.add(addPlat);
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
		frame.setJMenuBar(initMenu());
		home = new Home();
		restaurantInfos = new RestaurantInfos();
		restaurantPanel = new RestaurantPanel();
		restaurantProfessional = new RestaurantProfessional();
		sendMessage = new SendMessage();
		bookReservation = new BookReservation();
		notation = new Notation();
		frame.add(home);
		frame.add(restaurantInfos).setVisible(false);
		frame.add(restaurantPanel).setVisible(false);
		frame.add(restaurantProfessional).setVisible(false);
		frame.add(sendMessage).setVisible(false);
		frame.add(bookReservation).setVisible(false);
		frame.add(notation).setVisible(false);
		
	}
	
	public static void setVisibilityRestaurantInfo() {
		home.setVisible(false);
		restaurantInfos.setVisible(true);
		restaurantPanel.setVisible(false);
		restaurantProfessional.setVisible(false);
		sendMessage.setVisible(false);
		bookReservation.setVisible(false);
		notation.setVisible(false);
		
	}
	
	public static void setVisibilityRestaurantProfessional() {
		home.setVisible(false);
		restaurantInfos.setVisible(false);
		restaurantPanel.setVisible(false);
		restaurantProfessional.setVisible(true);
		sendMessage.setVisible(false);
		bookReservation.setVisible(false);
		notation.setVisible(false);
	}
	
	public static void setVisibilityToSendMessage() {
		home.setVisible(false);
		restaurantInfos.setVisible(false);
		restaurantPanel.setVisible(false);
		restaurantProfessional.setVisible(false);
		sendMessage.setVisible(true);
		bookReservation.setVisible(false);
		notation.setVisible(false);
		
	}
	
	public static void setVisibilityToBookReservation() {
		home.setVisible(false);
		restaurantInfos.setVisible(false);
		restaurantPanel.setVisible(false);
		restaurantProfessional.setVisible(false);
		sendMessage.setVisible(false);
		bookReservation.setVisible(true);
		notation.setVisible(false);
		
	}
	
	public static void setVisibilityToNotation() {
		home.setVisible(false);
		restaurantInfos.setVisible(false);
		restaurantPanel.setVisible(false);
		restaurantProfessional.setVisible(false);
		sendMessage.setVisible(false);
		bookReservation.setVisible(false);
		notation.setVisible(true);
		
	}
	public static void main(String[] args) {
		frame = new JFrame();
		init();
		frame.setVisible(true);
	}
}
