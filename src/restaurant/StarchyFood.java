package restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class StarchyFood extends Ingredient {
	
	private String starchyFoodGroup;
	
	public StarchyFood(String name, Integer origin, Boolean seasonal, String group) {
		super(name, "starchyFood", origin, seasonal);
		this.starchyFoodGroup = group;
		
	}
	
	public void setGroup(String group) {
		starchyFoodGroup = group;
	}
	
	public String getGroup() {
		return starchyFoodGroup;
	}
	
	public static List<StarchyFood> getAllStartchyFood() {
		
		try {
			Connection con = BDD.getConnection();
			
			String query = "SELECT * FROM Ingredient WHERE ingredientType='startchyFood'";
	        Statement smt = con.createStatement();
	        ResultSet rs = smt.executeQuery(query);
	        
	        ArrayList<StarchyFood> startchyFoods = new ArrayList<StarchyFood>();
	        
	        while(rs.next()) {
	        	startchyFoods.add(new StarchyFood(rs.getString("name"),rs.getInt("origin"), rs.getBoolean("seasonal"), rs.getString("groupColumn")));
	            
	        }
	        return startchyFoods;
		} catch (Exception e ){
			System.err.println(e.getMessage());
		}
		throw new EmptyStackException();
	}
	
	public static void addStartchyFood(StarchyFood startchyFood) {
		try {
			Connection con = BDD.getConnection();
			String query = " insert into ingredient (name, origin, seasonal, ingredientType, groupColumn)" + " values (?, ?, ?, ?, ?)";
			//System.out.println(startchyFood.getGroup());
			//System.out.println(startchyFood.getIngredientSeasonal());
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, startchyFood.getIngredientName());
			preparedStmt.setInt (2, startchyFood.getIngredientOrigin());
			preparedStmt.setBoolean  (3, startchyFood.getIngredientSeasonal());
			preparedStmt.setString  (4, "startchyFood");
			preparedStmt.setString  (5, startchyFood.getGroup());
			preparedStmt.execute();
			  
	        con.close();
		} catch (Exception e ){
			System.err.println(e.getMessage());
		}
		
	}}
