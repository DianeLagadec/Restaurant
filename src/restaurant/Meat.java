package restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Meat extends Ingredient {
	
	private String meatType;
	
	public Meat(String name, Integer origin, Boolean seasonal, String typeOfMeat) {
		super(name, "Meat", origin, seasonal);
		this.meatType = typeOfMeat;
		
	}
	
	public void setTypeOfMeat(String typeOfMeat) {
		meatType = typeOfMeat;
	}
	
	public String getTypeOfMeat() {
		return meatType;
	}
	
	public static List<Meat> getAllMeat() {
		
		try {
			Connection con = BDD.getConnection();
			
			String query = "SELECT * FROM Ingredient WHERE ingredientType='meat'";
	        Statement smt = con.createStatement();
	        ResultSet rs = smt.executeQuery(query);
	        
	        ArrayList<Meat> meats = new ArrayList<Meat>();
	        
	        while(rs.next()) {
	        	meats.add(new Meat(rs.getString("name"),rs.getInt("origin"), rs.getBoolean("seasonal"), rs.getString("type")));
	            
	        }
	        return meats;
		} catch (Exception e ){
			System.err.println(e.getMessage());
		}
		throw new EmptyStackException();
	}
	
	public static void addMeat(Meat meat) {
		try {
			Connection con = BDD.getConnection();
			String query = " insert into ingredient (name, origin, seasonal, type, ingredientType)" + " values (?, ?, ?, ?, ?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, meat.getIngredientName());
			preparedStmt.setInt (2, meat.getIngredientOrigin());
			preparedStmt.setBoolean  (3, meat.getIngredientSeasonal());
			preparedStmt.setString  (4, meat.getTypeOfMeat());
			preparedStmt.setString  (5, "meat");
			preparedStmt.execute();
			  
	        con.close();
		} catch (Exception e ){
			System.err.println(e.getMessage());
		}
		
	}
	
}