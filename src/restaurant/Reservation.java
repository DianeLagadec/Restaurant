package restaurant;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class Reservation {
	
	private String name;
	private Date date;
	private Integer nbrReservation;
	private String lastName;
	private Time hour;
	private String phone;
	private String email;
	
	
	public Reservation(String name, String lastName, Date date, Integer nbrReservation, String phone, String email, Time hour) {
		this.name = name;
		this.date = date;
		this.lastName = lastName;
		this.nbrReservation = nbrReservation;
		this.phone = phone;
		this.email = email;
		this.hour = hour;
	}
	
	public String getName() {
		return name;
	}
	public String getLastName() {
		return lastName;
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
	public Time getHour() {
		return hour;
	}
	public Integer getNbrReservation() {
		return nbrReservation;
	}
	
	public static ArrayList<Reservation> getAllReservationsFroARestaurant(String name) {
		Integer id = Restaurant.getIdByName(name);
		try {
			Connection con = BDD.getConnection();
			
			String query = "SELECT * FROM restaurant_reservation "
							+ "INNER JOIN reservation "
							+ "ON restaurant_reservation.idReservation = reservation.id "
							+ "WHERE restaurant_reservation.idRestaurant ="+id;
			
	        Statement smt = con.createStatement();
	        ResultSet rs = smt.executeQuery(query);
	        
	        ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	        
	        while(rs.next()) {
	        	Reservation reservation = new Reservation(rs.getString("name"),
		        										   rs.getString("lastName"),	
		        										   rs.getDate("date"),
		        										   rs.getInt("nbrReservation"),
		        										   rs.getString("phone"),
		        										   rs.getString("email"),
		        										   rs.getTime("hour"));
	        	reservations.add(reservation);
	            
	        }
	        
	        return reservations;
		} catch (Exception e ){
			System.err.println(e.getMessage());
			throw new EmptyStackException();
			
		}
	} 
	
	public static Integer count(String name) {
		Integer id = Restaurant.getIdByName(name);
		Integer count = 0;
		
		try {
			Connection con = BDD.getConnection();
			
			String query = "SELECT count(*) AS count FROM restaurant_reservation "
					+ "INNER JOIN reservation "
					+ "ON restaurant_reservation.idReservation = reservation.id "
					+ "WHERE restaurant_reservation.idRestaurant ="+id;
				
	        Statement smt = con.createStatement();
	        ResultSet rs = smt.executeQuery(query);
	        
	        while(rs.next()) {
	        	count = rs.getInt("count");
	            
	        }
	        return count;
		} catch (Exception e ) {
			System.err.println(e.getMessage());
			throw new EmptyStackException();
			
		}
	}
	
	public static void bookReservation(Reservation reservation, Integer id) {
		Integer idInserted = 0;
		
		try {
			Connection con = BDD.getConnection();
			String query = "insert into reservation (name, lastName, nbrReservation, phone, email, date, hour)" + " values (?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			preparedStmt.setString(1, reservation.getName());
			preparedStmt.setString(2, reservation.getLastName());
			preparedStmt.setInt(3, reservation.getNbrReservation());
			preparedStmt.setString(4, reservation.getPhone());
			preparedStmt.setString(5, reservation.getEmail());
			preparedStmt.setDate(6, reservation.getDate());
			preparedStmt.setTime(7, reservation.getHour());
			
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
			String query = "insert into restaurant_reservation (idRestaurant, idReservation)" + " values (?, ?)";
			
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
