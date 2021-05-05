package restaurant;

import java.sql.Connection;
import java.sql.Date;
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
					+ "ON restaurant_note.idNote = notes.id "
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
					+ "ON restaurant_note.idNote = notes.id "
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

}
