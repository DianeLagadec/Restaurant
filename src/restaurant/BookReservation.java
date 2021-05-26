package restaurant;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class BookReservation extends JPanel {

	private static final long serialVersionUID = 1L;
	private static TextField name, lastName, phone, email;
	private static JLabel title, nameLabel, lastNameLabel, phoneLabel, emailLabel, dateLabel, hourLabel, numberLabel, error;
	private static JButton send, cancel;
	private static Integer id;
	private static DefaultComboBoxModel<Integer> listNbrs;
	private static JComboBox<Integer> nbrResa;
	private static DefaultComboBoxModel<Integer> listDays;
	private static JComboBox<Integer> day;
	private static DefaultComboBoxModel<Integer> listMonths;
	private static JComboBox<Integer> month;
	private static DefaultComboBoxModel<Integer> listYears;
	private static JComboBox<Integer> year;
	private static DefaultComboBoxModel<String> listHours;
	private static JComboBox<String> hour;
	private static Set<Integer> resa;
	private static Set<Integer> daySet;
	private static Set<Integer> monthSet;
	private static Set<Integer> yearSet;
	private static Set<String> hourSet;

	public BookReservation () {
		
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
		
		lastNameLabel = new JLabel("Entrer votre prénom : ");
		lastNameLabel.setBounds(50,150,200,20);
		lastNameLabel.setFont(font14);
		add(lastNameLabel);
		
		phoneLabel = new JLabel("Entrer votre numéro de téléphone : ");
		phoneLabel.setBounds(50,200,250,20);
		phoneLabel.setFont(font14);
		add(phoneLabel);
		
		emailLabel = new JLabel("Entrer votre adresse email : ");
		emailLabel.setBounds(50,250,250,20);
		emailLabel.setFont(font14);
		add(emailLabel);
		
		dateLabel = new JLabel("Entrer la date (jour, mois, année) : ");
		dateLabel.setBounds(50,300,250,20);
		dateLabel.setFont(font14);
		add(dateLabel);
		
		hourLabel = new JLabel("Entrer l'heure : ");
		hourLabel.setBounds(50,350,250,20);
		hourLabel.setFont(font14);
		add(hourLabel);
		
		numberLabel = new JLabel("Entrer le nombre de personnes : ");
		numberLabel.setBounds(50,400,250,20);
		numberLabel.setFont(font14);
		add(numberLabel);
		
		name = new TextField();
		name.setBounds(300,100,250,20);
		add(name);
		
		lastName = new TextField();
		lastName.setBounds(300,150,250,20);
		add(lastName);
		
		phone = new TextField();
		phone.setBounds(300,200,250,20);
		add(phone);
		
		email = new TextField();
		email.setBounds(300,250,250,20);
		add(email);
		
		send = new JButton("Envoyer");
		send.setBounds(150,650,150,20);
		add(send);
		
		cancel = new JButton("Annuler");
		cancel.setBounds(350,650,150,20);
		add(cancel);
		
		error = new JLabel();
		error.setBounds(250,700,200,20);
		add(error).setVisible(false);
		
		
		
		nbrResa = new JComboBox<Integer>();
		resa = new TreeSet<Integer>();
		for (int i=1; i<=12; i++) {
			resa.add(i);
		}
		nbrResa.setBounds(300,400,150,30);
		listNbrs = new DefaultComboBoxModel<Integer>(); 
		listNbrs.addAll(resa);
		nbrResa.setModel(listNbrs);
		nbrResa.setSelectedIndex(0);
		add(nbrResa);
		
		day = new JComboBox<Integer>();
		daySet = new TreeSet<Integer>();
		for (int i=1; i<=31; i++) {
			daySet.add(i);
		}
		day.setBounds(300,300,100,30);
		listDays = new DefaultComboBoxModel<Integer>(); 
		listDays.addAll(daySet);
		day.setModel(listDays);
		day.setSelectedIndex(0);
		add(day);
		
		month = new JComboBox<Integer>();
		monthSet = new TreeSet<Integer>();
		for (int i=1; i<=12; i++) {
			monthSet.add(i);
		}
		month.setBounds(410,300,100,30);
		listMonths = new DefaultComboBoxModel<Integer>(); 
		listMonths.addAll(monthSet);
		month.setModel(listMonths);
		month.setSelectedIndex(0);
		add(month);
		
		year = new JComboBox<Integer>();
		yearSet = new TreeSet<Integer>();
		for (int i=2021; i<=2025; i++) {
			yearSet.add(i);
		}
		year.setBounds(520,300,100,30);
		listYears = new DefaultComboBoxModel<Integer>(); 
		listYears.addAll(yearSet);
		year.setModel(listYears);
		year.setSelectedIndex(0);
		add(year);
		
		hour = new JComboBox<String>();
		hourSet = new TreeSet<String>();
		hourSet.add("12:00:00");
		hourSet.add("12:15:00");
		hourSet.add("12:30:00");
		hourSet.add("12:45:00");
		hourSet.add("13:00:00");
		hourSet.add("13:15:00");
		hourSet.add("13:30:00");
		hourSet.add("13:45:00");
		hourSet.add("14:00:00");
		hourSet.add("14:15:00");
		hourSet.add("14:30:00");
		hourSet.add("18:30:00");
		hourSet.add("18:45:00");
		hourSet.add("19:00:00");
		hourSet.add("19:15:00");
		hourSet.add("19:30:00");
		hourSet.add("19:45:00");
		hourSet.add("20:00:00");
		hourSet.add("20:15:00");
		hourSet.add("20:30:00");
		hourSet.add("20:45:00");
		hourSet.add("21:00:00");
		hour.setBounds(300,350,150,30);
		listHours = new DefaultComboBoxModel<String>(); 
		listHours.addAll(hourSet);
		hour.setModel(listHours);
		hour.setSelectedIndex(0);
		add(hour);
		
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nameField = name.getText();
				String lastNameField = lastName.getText();
				String phoneField = phone.getText();
				String emailField = email.getText();
				
				if(!nameField.isBlank() && !lastNameField.isBlank() && !phoneField.isBlank() && !emailField.isBlank()) {
					error.setText("La reservation a été envoyée");
					error.setForeground(Color.GREEN);
					error.setVisible(true);
										
					Integer yearInt = Integer.parseInt(year.getSelectedItem().toString());
					Integer monthInt = Integer.parseInt(month.getSelectedItem().toString());
					Integer dayInt = Integer.parseInt(day.getSelectedItem().toString());
					
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd");
					LocalDate localDate = LocalDate.of(yearInt, monthInt, dayInt);
										
					LocalTime time = LocalTime.parse(hour.getSelectedItem().toString());
					
					Reservation reservation = new Reservation(nameField,lastNameField, Date.valueOf(dtf.format(localDate)), Integer.parseInt(nbrResa.getSelectedItem().toString()), phoneField, emailField, Time.valueOf(time));
					
					Reservation.bookReservation(reservation, id);
					App.setVisibilityRestaurantInfo();
					resetFields();
				//test
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
	public static void bookReservationForm(Restaurant restaurant) {
		title.setText("Vous allez reserver chez : "+restaurant.getName());
		id = Restaurant.getIdByName(restaurant.getName());
		
	}
	private static void resetFields() {
		name.setText("");
		lastName.setText("");
		phone.setText("");
		email.setText("");
		day.setSelectedIndex(0);
		month.setSelectedIndex(0);
		year.setSelectedIndex(0);
		hour.setSelectedIndex(0);
		nbrResa.setSelectedIndex(0);
		error.setVisible(false);
	}
	
	
}

