package restaurant;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public abstract class Ingredient {
	
	private String ingredientName;
	private Integer ingredientOrigin;
	private Boolean ingredientSeasonal;
	private String ingredientType;
	
	public Ingredient(String name, String type, Integer origin, Boolean seasonal) {
		this.ingredientName = name;
		this.ingredientType = type;
		this.ingredientOrigin = origin;
		this.ingredientSeasonal = seasonal;
		
	}
	
	public void setIngredientName(String name) {
		ingredientName = name;
	}
	
	public void setIngredientOrigin(Integer distance) {
		ingredientOrigin = distance;
	}
	
	public void setIngredientSeasonal(Boolean seasonal) {
		ingredientSeasonal = seasonal;
	}
	
	public void setIngredientType(String type) {
		ingredientType = type;
	}
	
	public String getIngredientName() {
		return ingredientName;
	}
	
	public Integer getIngredientOrigin() {
		return ingredientOrigin;
	}
	
	public Boolean getIngredientSeasonal() {
		return ingredientSeasonal;
	}
	
	public String getIngredientType() {
		return ingredientType;
	}
	
public static List<Ingredient> getAll() {
		
		try {
			Connection con = BDD.getConnection();
			
			String query = "SELECT * FROM ingredient";
	        Statement smt = con.createStatement();
	        ResultSet rs = smt.executeQuery(query);
	        
	        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	        while(rs.next()) {
	        	if(rs.getString("ingredientType").equals("vegetable")) {
	        		ingredients.add(new Vegetable(rs.getString("name"),rs.getInt("origin"), rs.getBoolean("seasonal"), rs.getString("famille")));
	        	} else if (rs.getString("ingredientType").equals("meat")) {
	        		ingredients.add(new Meat(rs.getString("name"),rs.getInt("origin"), rs.getBoolean("seasonal"), rs.getString("type")));
	        	} else if (rs.getString("ingredientType").equals("startchyFood")) {
	        		ingredients.add(new StarchyFood(rs.getString("name"),rs.getInt("origin"), rs.getBoolean("seasonal"), rs.getString("groupColumn")));
	            
	        }}
	        return ingredients;
		} catch (Exception e ){
			System.err.println(e.getMessage());
			throw new EmptyStackException();
			
		}
		
	}
}
