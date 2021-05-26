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

public class Addrestaurant extends JPanel {
		
		private static final long serialVersionUID = 1L;
		private static TextField name, emailtext, teltext, adresse, villetext,labeltext, regimetext, zip;
		private static JLabel title, nameLabel, email, tel,adress, ville, doggylabel, label, locallabel, regime, zipcode, error ;
		private static JButton send, cancel;
		private static Integer id;
		private static DefaultComboBoxModel<Boolean> listDoggy;
		private static JComboBox<Boolean> doggy;
		private static DefaultComboBoxModel<Boolean> listLocals;
		private static JComboBox<Boolean> local;
		private static Set<Boolean> localSet, doggySet;
		
		public Addrestaurant() {

			setBounds(10,0,1480, 790);
			setLayout(null);
			Font font16 = new Font("Comic Sans MS", Font.BOLD, 16);
			Font font14 = new Font("Comic Sans MS", Font.PLAIN, 14);
			
			title = new JLabel("Ajout de votre restaurant :");
			title.setBounds(50,50,400,30);
			title.setFont(font16);
			add(title);
			
			nameLabel = new JLabel("Nom du restaurant : ");
			nameLabel.setBounds(50,100,200,20);
			nameLabel.setFont(font14);
			add(nameLabel);
			
			name = new TextField();
			name.setBounds(300,100,250,20);
			add(name);
			
			
			email = new JLabel("Email :");
			email.setBounds(50,150,200,20);
			email.setFont(font14);
			add(email);
			
			emailtext = new TextField();
			emailtext.setBounds(300,150,250,20);
			add(emailtext);
			
			tel = new JLabel("Numero de telephone : ");
			tel.setBounds(50,200,200,20);
			tel.setFont(font14);
			add(tel);
			
			teltext = new TextField();
			teltext.setBounds(300,200,250,20);
			add(teltext);
			
			adress = new JLabel("Adresse postale: ");
			adress.setBounds(50,250,200,20);
			adress.setFont(font14);
			add(adress);
			
			adresse = new TextField();
			adresse.setBounds(300,250,250,20);
			add(adresse);
			
			ville = new JLabel("Ville: ");
			ville.setBounds(50,300,200,20);
			ville.setFont(font14);
			add(ville);
			
			villetext = new TextField();
			villetext.setBounds(300,300,250,20);
			add(villetext);
			
			zipcode = new JLabel(" Code postal: ");
			zipcode.setBounds(50,350,200,20);
			zipcode.setFont(font14);
			add(zipcode);
			
			zip = new TextField();
			zip.setBounds(300,350,250,20);
			add(zip);
			
			label = new JLabel("Label  : ");
			label.setBounds(50,400,200,20);
			label.setFont(font14);
			add(label);
			
			labeltext = new TextField();
			labeltext.setBounds(300,400,250,20);
			add(labeltext);
			
			doggylabel = new JLabel("Présence de doggy Bag : ");
	    	doggylabel.setBounds(50, 450,200,20);
	    	doggylabel.setFont(font14);
	    	add(doggylabel);
			
			doggy = new JComboBox<Boolean>();
			doggy.setBounds(300,450,250,20);
			doggySet = new TreeSet<Boolean>();
			listDoggy = new DefaultComboBoxModel<Boolean>(); 
			doggySet.add(Boolean.TRUE);
			doggySet.add(Boolean.FALSE);
	    	listDoggy.addAll(doggySet);
	    	doggy.setModel(listDoggy);
	    	doggy.setSelectedIndex(0);
			add(doggy);
			
			regime = new JLabel("Régime alimentaire : ");
			regime.setBounds(50,500,200,20);
			regime.setFont(font14);
			add(regime);
			
			regimetext= new TextField();
			regimetext.setBounds(300,500,250,20);
			add(regimetext);
			
			locallabel = new JLabel("Nourriture locale : ");
	    	locallabel.setBounds(50, 550, 200,20);
	    	locallabel.setFont(font14);
	    	add(locallabel);
			
	    	local = new JComboBox<Boolean>();
	    	local.setBounds(300,550,250,20);
			localSet = new TreeSet<Boolean>();
	    	listLocals = new DefaultComboBoxModel<Boolean>(); 
	    	localSet.add(Boolean.TRUE);
	    	localSet.add(Boolean.FALSE);
	    	listLocals.addAll(localSet);
	    	local.setModel(listLocals);
	    	local.setSelectedIndex(0);
			add(local);
			
			send = new JButton("Ajouter");
			send.setBounds(150,650,150,20);
			add(send);
			
			cancel = new JButton("Annuler");
			cancel.setBounds(350,650,150,20);
			add(cancel);
			
			error = new JLabel();
			error.setBounds(250,700,200,20);
			add(error).setVisible(false);
			
			send.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String nameField = name.getText();
					String emailField = emailtext.getText();
					String telField = teltext.getText();
					String adresseField = adresse.getText();
					String villeField = villetext.getText();
					String labelField = labeltext.getText();
					String regimeField = regimetext.getText();
					String zipField = zip.getText();
					
					
					if(!nameField.isBlank() && !emailField.isEmpty() && !telField.isEmpty() &&  !adresseField.isEmpty() && !villeField.isEmpty() && !labelField.isEmpty() && !regimeField.isEmpty() && !zipField.isEmpty()) {
						error.setText("Le restaurant a ete ajouté");
						error.setForeground(Color.GREEN);
						error.setVisible(true);
						
						
						Restaurant restau = new Restaurant(nameField, adresseField, villeField, zipField, emailField, telField, labelField,regimeField,(Boolean)doggy.getSelectedItem(),(Boolean)local.getSelectedItem()  );
						
						Restaurant.addRestaurant(restau, id);
						
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
			title.setText("Vous aller laisser un commentaire à  "+restaurant.getName());
			id = Restaurant.getIdByName(restaurant.getName());
			
		}
		
		private static void resetFields() {
			name.setText("");
			emailtext.setText("");
			teltext.setText("");
			adresse.setText("");
			villetext.setText("");
			labeltext.setText("");
			regimetext.setText("");
			zip.setText("");
			error.setVisible(false);
		}

	}



