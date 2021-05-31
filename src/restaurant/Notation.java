package restaurant;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.TreeSet;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Notation extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private static TextField name;
	private static JLabel title, nameLabel, commentLabel, notelabel, error;
	private static JTextArea comment;
	private static JButton send, cancel;
	private static Integer id;
	private static DefaultComboBoxModel<Integer> listNbrs;
	private static JComboBox<Integer> nbretoile;
	private static Set<Integer> etoile;
	
	public Notation() {

		setBounds(10,0,1480, 790);
		setLayout(null);
		Font font16 = new Font("Comic Sans MS", Font.BOLD, 16);
		Font font14 = new Font("Comic Sans MS", Font.PLAIN, 14);
		title = new JLabel();
		title.setBounds(50,50,400,30);
		title.setFont(font16);
		add(title);
		
		nameLabel = new JLabel("Entrer votre nom : ");
		nameLabel.setBounds(50,100,200,20);
		nameLabel.setFont(font14);
		add(nameLabel);
		
		
		notelabel = new JLabel("Choisir un chiffre entre 1 et 5 en fonction de votre satisfaction :");
		notelabel.setBounds(50,200,800,20);
		notelabel.setFont(font14);
		add(notelabel);
		
		commentLabel = new JLabel("Ecrire votre commentaire : ");
		commentLabel.setBounds(50,400,250,20);
		commentLabel.setFont(font14);
		add(commentLabel);
		
		name = new TextField();
		name.setBounds(50,150,250,20);
		add(name);
		
		comment = new JTextArea(10, 600);
		comment.setBounds(50,430,600,200);
		add(comment);
		
		send = new JButton("Envoyer");
		send.setBounds(150,650,150,20);
		add(send);
		
		cancel = new JButton("Annuler");
		cancel.setBounds(350,650,150,20);
		add(cancel);
		
		error = new JLabel();
		error.setBounds(250,700,200,20);
		add(error).setVisible(false);
		
		nbretoile = new JComboBox<Integer>();
		etoile = new TreeSet<Integer>();
		for (int i=1; i<=5; i++) {
			etoile.add(i);
		}
		nbretoile.setBounds(50,250,150,30);
		listNbrs = new DefaultComboBoxModel<Integer>(); 
		listNbrs.addAll(etoile);
		nbretoile.setModel(listNbrs);
		nbretoile.setSelectedIndex(0);
		add(nbretoile);
		
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nameField = name.getText();
				String commentField = comment.getText();
				
				if(!nameField.isBlank() && !commentField.isEmpty()) {
					error.setText("Le commentaire a ete envoye");
					error.setForeground(Color.GREEN);
					error.setVisible(true);
					
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd");
					LocalDate localDate = LocalDate.now();
					
					Note note = new Note(nameField, Integer.parseInt(nbretoile.getSelectedItem().toString()), commentField, Date.valueOf(dtf.format(localDate)));
					
					Note.addNote(note, id);
					
					App.setVisibilityRestaurantInfo();
					resetFields();
				} else {
					error.setText("Un des champs n'est pas rempli");
					error.setForeground(Color.RED);
					error.setVisible(true);
				}
	    	}	
		});
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App.setVisibilityRestaurantInfo();
				resetFields();
	    	}	
		});

	}
	
	public static void NoteForm(Restaurant restaurant) {
		title.setText("Vous aller laisser une note a :  "+restaurant.getName());
		id = Restaurant.getIdByName(restaurant.getName());
		
	}
	
	private static void resetFields() {
		name.setText("");
		comment.setText("");
		error.setVisible(false);
	}

}
