package restaurant;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.EmptyStackException;
public class Note {
	
	private String name;
	private Integer note;
	private String comment;
	private Date date;
	
	public Note(String name, Integer note, String comment, Date date) {
		this.name = name;
		this.note = note;
		this.comment = comment;
		this.date = date;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getNote() {
		return note;
	}
	
	public String getComment() {
		return comment;
	}
	
	public Date getDate() {
		return date;
	}
	
	public static ArrayList<Note> getNoteByRestaurantName(String name) {
		Integer id = Restaurant.getIdByName(name);
		try {
			Connection con = BDD.getConnection();
			
			String query = "SELECT * FROM restaurant_note "
					+ "INNER JOIN notes "
					+ "ON restaurant_note.idNote = Notes.id "
					+ "WHERE restaurant_note.idRestaurant ="+id;
			
	        Statement smt = con.createStatement();
	        ResultSet rs = smt.executeQuery(query);
	        
	        ArrayList<Note> notes = new ArrayList<Note>();
	        
	        while(rs.next()) {
	        	Note note = new Note(rs.getString("name"),
    								 rs.getInt("note"),
    								 rs.getString("comment"),
        							 rs.getDate("date"));
		        							
		        							
	        	notes.add(note);
	            
	        }
	        return notes;
		} catch (Exception e ){
			System.err.println(e.getMessage());
			throw new EmptyStackException();
			
		}
	}
	
	public static float getAverage(String name) {
		Integer id = Restaurant.getIdByName(name);
		Float average = 0.0f;
		try {
			Connection con = BDD.getConnection();
			
			String query = "SELECT AVG(note) AS average FROM restaurant_note "
					+ "INNER JOIN notes "
					+ "ON restaurant_note.idNote = Notes.id "
					+ "WHERE restaurant_note.idRestaurant ="+id;
			
			
			
	        Statement smt = con.createStatement();
	        ResultSet rs = smt.executeQuery(query);
	        
	        
	        while(rs.next()) {
	        	average = rs.getFloat("average");
	            
	        }
	        return average;
		} catch (Exception e ){
			System.err.println(e.getMessage());
			throw new EmptyStackException();
			
		}
	}
	
	public static void addNote(Note note, Integer id) {
		Integer idInserted = 0;
		
		try {
			Connection con = BDD.getConnection();
			String query = "insert into Notes (name, note, comment, date)" + " values (?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			preparedStmt.setString(1, note.getName());
			preparedStmt.setInt(2, note.getNote());
			preparedStmt.setString(3, note.getComment());
			preparedStmt.setDate(4, note.getDate());
			
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
			String query = "insert into restaurant_note (idRestaurant, idNote)" + " values (?, ?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			preparedStmt.setInt(1, id);
			preparedStmt.setInt(2, idInserted);
			
			preparedStmt.execute();
			
			con.close();
		} catch (Exception e ){
			System.err.println(e.getMessage());
		}
	}
}


