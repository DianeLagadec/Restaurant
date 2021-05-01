package restaurant;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.Date;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SendMessage extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private static TextField name, lastName, phone, email, subject;
	private static JLabel title, nameLabel, lastNameLabel, phoneLabel, emailLabel, subjectLabel, commentLabel, error;
	private static JTextArea comment;
	private static JButton send, cancel;
	private static Integer id;
	
	
	public SendMessage() {

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
		
		subjectLabel = new JLabel("Entrer le sujet de votre message : ");
		subjectLabel.setBounds(50,300,250,20);
		subjectLabel.setFont(font14);
		add(subjectLabel);
		
		commentLabel = new JLabel("Entrer votre message : ");
		commentLabel.setBounds(50,350,250,20);
		commentLabel.setFont(font14);
		add(commentLabel);
		
		name = new TextField();
		name.setBounds(280,100,250,20);
		add(name);
		
		lastName = new TextField();
		lastName.setBounds(280,150,250,20);
		add(lastName);
		
		phone = new TextField();
		phone.setBounds(300,200,250,20);
		add(phone);
		
		email = new TextField();
		email.setBounds(300,250,250,20);
		add(email);
		
		subject = new TextField();
		subject.setBounds(300,300,250,20);
		add(subject);
		
		comment = new JTextArea(10, 600);
		comment.setBounds(50,400,600,200);
		add(comment);
		
		send = new JButton("Envoyer");
		send.setBounds(150,650,150,20);
		add(send);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(350,650,200,20);
		add(cancel);
		
		error = new JLabel();
		error.setBounds(250,700,200,20);
		add(error).setVisible(false);
		
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nameField = name.getText();
				String lastNameField = lastName.getText();
				String phoneField = phone.getText();
				String emailField = email.getText();
				String subjectField = subject.getText();
				String commentField = comment.getText();
				
				if(!nameField.isBlank() && !lastNameField.isBlank() && !phoneField.isBlank() && !emailField.isBlank() && !subjectField.isBlank() && !commentField.isEmpty()) {
					error.setText("Le message à été envoyé");
					error.setForeground(Color.GREEN);
					error.setVisible(true);
					
					//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd");
					//LocalDate localDate = LocalDate.now();
					
					//Message message = new Message(nameField,lastNameField, subjectField, commentField, phoneField, emailField, Date.valueOf(dtf.format(localDate)));
					
					//Message.addMessage(message, id);
					
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
	
	public static void sendMessageForm(Restaurant restaurant) {
		title.setText("Vous aller envoyer un message à : "+restaurant.getName());
		id = Restaurant.getIdByName(restaurant.getName());
		
	}
	
	private static void resetFields() {
		name.setText("");
		lastName.setText("");
		phone.setText("");
		email.setText("");
		subject.setText("");
		comment.setText("");
		error.setVisible(false);
	}


}
