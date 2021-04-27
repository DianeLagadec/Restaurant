package restaurant;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Restaurant {
	
	private String name;
	private String adress;
	private String city;
	private String zipCode;
	private String label;
	private String mail;
	private String phone;
	private String diet;
	private Boolean doggyBag;
	private Boolean localProducts;
	
	public Restaurant(String name, String adress, String city, String zipCode, String mail, String phone, String label, String diet, Boolean doggyBag, Boolean localProducts) {
		this.name = name;
		this.adress = adress;
		this.city = city;
		this.zipCode = zipCode;
		this.label = label;
		this.mail = mail;
		this.phone = phone;
		this.diet = diet;
		this.doggyBag = doggyBag;
		this.localProducts = localProducts;	
	}	
		
	public Restaurant() {
		super();
	}
		
	public String getName() {
		return name;
	}
		
	public String getAdress() {
		return adress;
	}
		
	public String getCity() {
		return city;
	}
		
	public String getZipCode() {
		return zipCode;
	}
		
	public String getLabel() {
		return label;
	}
		
	public String getMail() {
		return mail;
	}
		
	public String getPhone() {
		return phone;
	}
		
	public String getDiet() {
		return diet;
	}
		
	public Boolean getDoggyBag() {
		return doggyBag;
	}
		
	public Boolean getLocalProducts() {
		return localProducts;
	}
	
	public static ArrayList<Restaurant> getAllRestaurants() {
		try {
			Connection con = BDD.getConnection();
			
			String query = "SELECT * FROM restaurant";
	        Statement smt = con.createStatement();
	        ResultSet rs = smt.executeQuery(query);
	        
	        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
	        while(rs.next()) {
	        	Restaurant restaurant = new Restaurant(rs.getString("name"),
	        										   rs.getString("adress"),	
	        										   rs.getString("city"),
	        										   rs.getString("zipCode"),
	        										   rs.getString("mail"),
	        										   rs.getString("phone"),
	        										   rs.getString("label"),
	        										   rs.getString("diet"),
	        										   rs.getBoolean("doggyBag"), 
	        										   rs.getBoolean("localProducts"));
	        	restaurants.add(restaurant);
	            
	        }
	        return restaurants;
		} catch (Exception e ){
			System.err.println(e.getMessage());
			throw new EmptyStackException();
			
		}
	}
	
}
