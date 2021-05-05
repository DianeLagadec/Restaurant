package restaurant;


import java.awt.Dimension;
import java.awt.Font;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class RestaurantProfessional extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final JScrollPane scrollPane = new JScrollPane();
	private static final JScrollPane scrollPaneMessages = new JScrollPane();
	private static JLabel nbrResa, countResa, name, messageLabel, nbrMessage;
	
	public RestaurantProfessional() {
		setBounds(10,0,1480, 790);
		setLayout(null);

		Font font16 = new Font("Comic Sans MS", Font.BOLD, 16);
		nbrResa = new JLabel("Réservations : ");
    	nbrResa.setBounds(50, 150, 150,20);
    	nbrResa.setFont(font16);
    	add(nbrResa);
		scrollPane.setBounds(10,200,1450,180);
		scrollPane.setPreferredSize(new Dimension(1480,180));
		add(scrollPane);
		scrollPaneMessages.setBounds(10,460,1450,180);
		scrollPaneMessages.setPreferredSize(new Dimension(1480,180));
		add(scrollPaneMessages);
		countResa = new JLabel();
    	countResa.setBounds(170, 151, 150,20);
    	countResa.setFont(font16);
    	add(countResa);
    	messageLabel = new JLabel("Messages : ");
    	messageLabel.setBounds(50, 410, 150,30);
    	messageLabel.setFont(font16);
    	add(messageLabel);
    	nbrMessage = new JLabel();
    	nbrMessage.setBounds(150, 415, 150,20);
    	nbrMessage.setFont(font16);
    	add(nbrMessage);
    	name= new JLabel();
    	name.setBounds(50,50,400,40);
    	name.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
    	add(name);
    	
	}
	
	public static void update(Restaurant restaurant) {
		name.setText(restaurant.getName()+" : ");
	}
	

}
