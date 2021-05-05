package restaurant;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class Message {
	
	private String name;
	private String lastName;
	private String subject;
	private String comment;
	private String phone;
	private String email;
	private Date date;
	
	public Message(String name, String lastName, String subject, String comment, String phone, String email, Date date) {
		this.name = name;
		this.lastName = lastName;
		this.subject = subject;
		this.comment = comment;
		this.phone = phone;
		this.email = email;
		this.date = date;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public String getComment() {
		return comment;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Date getDate() {
		return date;
	}
	
	public static void addMessage(Message message, Integer id) {
		Integer idInserted = 0;
		
		try {
			Connection con = BDD.getConnection();
			String query = "insert into Message (name, lastName, subject, comment, phone, email, date)" + "values (?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			preparedStmt.setString(1, message.getName());
			preparedStmt.setString(2, message.getLastName());
			preparedStmt.setString(3, message.getSubject());
			preparedStmt.setString(4, message.getComment());
			preparedStmt.setString(5, message.getPhone());
			preparedStmt.setString(6, message.getEmail());
			preparedStmt.setDate(7, message.getDate());
			
			preparedStmt.execute();
			
			ResultSet rs = preparedStmt.getGeneratedKeys();
			if (rs.next()){
				idInserted = rs.getInt(1);
			}
			con.close();
		} catch (Exception e ){
			System.err.println(e.getMessage());
		}
		
		try {
			Connection con = BDD.getConnection();
			String query = "insert into restaurant_message (idRestaurant, idMessage)" + " values (?, ?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			preparedStmt.setInt(1, id);
			preparedStmt.setInt(2, idInserted);
			
			preparedStmt.execute();
			
			con.close();
		} catch (Exception e ){
			System.err.println(e.getMessage());
		}
	}
	
	public static ArrayList<Message> getAllMessages(String name) {
		Integer id = Restaurant.getIdByName(name);
		try {
			Connection con = BDD.getConnection();
			
			String query = "SELECT * FROM restaurant_message "
					+ "INNER JOIN Message "
					+ "ON restaurant_message.idMessage = Message.id "
					+ "WHERE restaurant_message.idRestaurant="+id;
	        Statement smt = con.createStatement();
	        ResultSet rs = smt.executeQuery(query);
	        ArrayList<Message> messages = new ArrayList<Message>();
	        while(rs.next()) {
	        	Message message = new Message(rs.getString("name"),
						   rs.getString("lastName"),	
						   rs.getString("subject"),
						   rs.getString("comment"),
						   rs.getString("phone"),
						   rs.getString("email"),
						   rs.getDate("date"));
	        messages.add(message);
	        }
	        	
	        return messages;
		} catch (Exception e ){
			System.err.println(e.getMessage());
			throw new EmptyStackException();
		}
	}
}
