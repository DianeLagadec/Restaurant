package restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;


public class Vegetable extends Ingredient {
	private String family;
	
	public Vegetable(String name, Integer origin, Boolean seasonal, String family) {
		super(name, "Vegetables", origin, seasonal);
		this.family = family;
		
	}
	
	public void setFamily(String VegetableFamily) {
		family = VegetableFamily;
	}
	
	public String getFamily() {
		return family;
	}
	
	public static List<Vegetable> getAllVegetable() {
		
		try {
			Connection con = BDD.getConnection();
			
			String query = "SELECT * FROM Ingredient WHERE ingredientType='vegetable'";
	        Statement smt = con.createStatement();
	        ResultSet rs = smt.executeQuery(query);
	        
	        ArrayList<Vegetable> vegetables = new ArrayList<Vegetable>();
	        
	        while(rs.next()) {
	        	vegetables.add(new Vegetable(rs.getString("name"),rs.getInt("origin"), rs.getBoolean("seasonal"), rs.getString("famille")));
	            
	        }
	        return vegetables;
		} catch (Exception e ){
			System.err.println(e.getMessage());
		}
		throw new EmptyStackException();
	}
	
	public static void addVegetable(Vegetable vegetable) {
		try {
			Connection con = BDD.getConnection();
			String query = " insert into ingredient (name, origin, seasonal, famille, ingredientType)" + " values (?, ?, ?, ?, ?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, vegetable.getIngredientName());
			preparedStmt.setInt (2, vegetable.getIngredientOrigin());
			preparedStmt.setBoolean  (3, vegetable.getIngredientSeasonal());
			preparedStmt.setString  (4, vegetable.getFamily());
			preparedStmt.setString  (5, "vegetable");
			preparedStmt.execute();
			  
	        con.close();
		} catch (Exception e ){
			System.err.println(e.getMessage());
		}
		
	}

}
