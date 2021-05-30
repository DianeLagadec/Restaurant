package restaurant;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.TreeSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	public static Restaurant getRestaurantByName(String name) {
		try {
			Connection con = BDD.getConnection();
			
			String query = "SELECT * FROM restaurant WHERE name='"+String.valueOf(name)+"' LIMIT 1";
	        Statement smt = con.createStatement();
	        ResultSet rs = smt.executeQuery(query);
	        Restaurant restaurants = new Restaurant();
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
	            restaurants=restaurant;
	        }
	        return restaurants;
		} catch (Exception e ){
			System.err.println(e.getMessage());
			throw new EmptyStackException();
			
		}
	}
	
	public static ArrayList<Restaurant> getRestaurantsWithArgs(String city, String diet, String label, String local, String doggy) {
		
		ArrayList<String> queryElements = new ArrayList<String>();
		
		if(city != "-") {
			queryElements.add("city='"+city+"'");
		}
		if(diet != "-") {
			queryElements.add("diet='"+diet+"'");
		}
		if(label != "-") {
			queryElements.add("label='"+label+"'");
		}
		if(local != "-") {
			queryElements.add(local == "Yes" ? "localProducts = 1" : "localProducts = 0");
		}
		if(doggy != "-") {
			queryElements.add(doggy == "Yes" ? "doggyBag = 1" : "doggyBag = 0");
		}
		
		String query = "SELECT * FROM restaurant";
		if (queryElements.size() == 1) {
			query += " WHERE "+queryElements.get(0);
		} else if (queryElements.size() > 1) {
			query += " WHERE ";
			for(int i = 0; i<queryElements.size(); i++) {
				if(i != queryElements.size()-1) {
					query+=queryElements.get(i)+" AND ";
				} else {
					query+=queryElements.get(i);
				}								
			}
		}
				
		try {
			Connection con = BDD.getConnection();
			
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
	
	
	public static ArrayList<String> getAllNames() {
		try {
			Connection con = BDD.getConnection();
			
			String query = "SELECT name FROM restaurant";
			
	        Statement smt = con.createStatement();
	        ResultSet rs = smt.executeQuery(query);
	        
	        ArrayList<String> names = new ArrayList<String>();
	        while(rs.next()) {
	        	names.add(rs.getString("name"));
	        }
	        	
	        return names;
		} catch (Exception e ){
			System.err.println(e.getMessage());
			throw new EmptyStackException();
			
		}
	}
	
	public static ArrayList<String> getAllCities() {
		try {
			Connection con = BDD.getConnection();
			
			String query = "SELECT city FROM restaurant";
			
	        Statement smt = con.createStatement();
	        ResultSet rs = smt.executeQuery(query);
	        
	        ArrayList<String> names = new ArrayList<String>();
	        while(rs.next()) {
	        	names.add(rs.getString("city"));
	        }
	        	
	        return names;
		} catch (Exception e ){
			System.err.println(e.getMessage());
			throw new EmptyStackException();
			
		}
	}
	
	public static ArrayList<String> getAllRegimes() {
		try {
			Connection con = BDD.getConnection();
			
			String query = "SELECT diet FROM restaurant";
			
	        Statement smt = con.createStatement();
	        ResultSet rs = smt.executeQuery(query);
	        
	        ArrayList<String> names = new ArrayList<String>();
	        while(rs.next()) {
	        	names.add(rs.getString("diet"));
	        }
	        	
	        return names;
		} catch (Exception e ){
			System.err.println(e.getMessage());
			throw new EmptyStackException();
			
		}
	}
	
	public static ArrayList<String> getAllLabels() {
		try {
			Connection con = BDD.getConnection();
			
			String query = "SELECT label FROM restaurant";
			
	        Statement smt = con.createStatement();
	        ResultSet rs = smt.executeQuery(query);
	        
	        ArrayList<String> names = new ArrayList<String>();
	        while(rs.next()) {
	        	names.add(rs.getString("label"));
	        }
	        	
	        return names;
		} catch (Exception e ){
			System.err.println(e.getMessage());
			throw new EmptyStackException();
			
		}
	}
	
	public static Integer getIdByName(String name) {
		try {
			Connection con = BDD.getConnection();
			
			String query = "SELECT id FROM restaurant WHERE name='"+String.valueOf(name)+"' LIMIT 1";
			
	        Statement smt = con.createStatement();
	        ResultSet rs = smt.executeQuery(query);
	        Integer id = 0;
	        while(rs.next()) {
	        	id = Integer.valueOf(rs.getInt("id"));
	        }
	        	
	        return id;
		} catch (Exception e ){
			System.err.println(e.getMessage());
			throw new EmptyStackException();
			
		}
	}
	
	public static void addRestaurant(Restaurant restaurant, Integer id) {
		
		try {
			Connection con = BDD.getConnection();
			String query = "insert into restaurant (name, adress, city, zipCode,  phone, mail, diet, localProducts, doggyBag, label)" + " values (?, ?, ?, ?,? ,? ,? ,?,?,?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			preparedStmt.setString(1, restaurant.getName());
			preparedStmt.setString(2, restaurant.getAdress());
			preparedStmt.setString(3, restaurant.getCity());
			preparedStmt.setString(4, restaurant.getZipCode());
			preparedStmt.setString(5, restaurant.getPhone());
			preparedStmt.setString(6, restaurant.getMail());
			preparedStmt.setString(7, restaurant.getDiet());
			preparedStmt.setBoolean(8, restaurant.getLocalProducts());
			preparedStmt.setBoolean(9, restaurant.getDoggyBag());
			preparedStmt.setString(10, restaurant.getLabel());
			
			
			preparedStmt.execute();
		
			con.close();
		} catch (Exception e ){
			System.err.println(e.getMessage());
		}
		
	}
}
