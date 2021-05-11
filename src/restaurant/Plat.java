package restaurant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class Plat {
	
	private String name;
	private Boolean seasonal;
	private Integer origin;
	private String family;
	private String type;
	private String ingredientType;
	private String group;
	
	public Plat(String name, Boolean seasonal, Integer origin, String family, String type, String ingredientType, String group) {
		this.name = name;
		this.seasonal = seasonal;
		this.origin = origin;
		this.family = family;
		this.type = type;
		this.ingredientType = ingredientType;
		this.group = group;
	}
	
	public String getName() {
		return name;
	}
	
	public Boolean getSeasonal() {
		return seasonal;
	}
	
	public Integer getOrigin() {
		return origin;
	}
	
	public String getFamily() {
		return family;
	}
	
	public String getType() {
		return type;
	}
	
	public String getIngredientType() {
		return ingredientType;
	}
	
	public String getGroup() {
		return group;
	}
	
	//coucou je test
	
	public static ArrayList<Plat> getAllPlatForARestaurant(String name) {
		Integer id = Restaurant.getIdByName(name);
		try {
			Connection con = BDD.getConnection();
			
			String query = "SELECT * "
					+ "FROM plat_ingredient "
					+ "INNER JOIN ingredient "
					+ "ON plat_ingredient.ingredientId = ingredient.id "
					+ "WHERE plat_ingredient.platId = "
					+ "(SELECT plat.id "
					+ "FROM plat "
					+ "INNER JOIN restaurant "
					+ "ON plat.id = restaurant.plat "
					+ "WHERE restaurant.id="+id+")";
			
	        Statement smt = con.createStatement();
	        ResultSet rs = smt.executeQuery(query);
	        
	        ArrayList<Plat> plats = new ArrayList<Plat>();
	        
	        while(rs.next()) {
	        	Plat plat = new Plat(rs.getString("name"),
									   rs.getBoolean("seasonal"),	
									   rs.getInt("origin"),
									   rs.getString("famille"),
									   rs.getString("type"),
									   rs.getString("ingredientType"),
									   rs.getString("groupColumn"));
	        	plats.add(plat);
	            
	        }
	        
	        return plats;
		} catch (Exception e ){
			System.err.println(e.getMessage());
			throw new EmptyStackException();
			
		}
		
	}
	
	public static String getPlatNameForARestaurant(String name) {

		Integer id = Restaurant.getIdByName(name);
		String platName = "";
		try {
			Connection con = BDD.getConnection();
			
			String query = "SELECT plat.name "
					+ "FROM plat "
					+ "INNER JOIN restaurant "
					+ "ON restaurant.plat = plat.id "
					+ "WHERE restaurant.id ="+id+" LIMIT 1";
			
	        Statement smt = con.createStatement();
	        ResultSet rs = smt.executeQuery(query);
	        
	        
	        while(rs.next()) {
	        	platName = rs.getString("name");
	            
	        }
	        
	        return platName;
		} catch (Exception e ){
			System.err.println(e.getMessage());
			throw new EmptyStackException();
			
		}
	}

}
