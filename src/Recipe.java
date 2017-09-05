// Assignment #:
// Name: 
// StudentID:
// Lecture:
//  Description: The Recipe class describes attributes in a flight
//               and provides accessor and mutator methods for each
//               instance variables as well as toString method.

import java.text.NumberFormat;
import java.util.*;

public class Recipe
{
	private String recipeName;
	private String yield;
	private String cookTime;
	private ArrayList <Ingredient> ingredients;
	private int ingredientCount = 0;
	
	// Constructors
	public Recipe()
	{
		recipeName = "";
		yield = "";
		cookTime = "";
		ingredients = null;
	}
	public Recipe (String recipeName, String yield, String cookTime)
	{
		this.recipeName = recipeName;
		this.yield = yield;
		this.cookTime = cookTime;
	}

	// Getters
	// Return recipe name, yield, and cook time
	public String getRecipeName()
	{
		return recipeName;
	}
	public String getYield()
	{
		return yield;
	}
	public String getCookTime()
	{
		return cookTime;
	}


	// Setters:
	// Set recipe name, yield and time to cook  
	public void setRecipeName(String recipeName)
	{
		this.recipeName = recipeName;
	}

	public void setYield(String yield)
	{
		this.yield = yield;
	}

	public void setCookTime(String cookTime)
	{
		this.cookTime = cookTime;
	}

	public void setIngredients(ArrayList<Ingredient> ingredients) { this.ingredients = ingredients; }

	/*public int removeIngredient(String ingredientToRemove)
	{
		int IngredientRemoved = 0;	
		for (int i = 0; i < ingredients.size(); i ++)
		{
			if (ingredientToRemove.equals(ingredients.get(i)))
				ingredients.remove(i);
		}
		if (ingredient != null)
		{
			ingredients.add(ingredient);
			IngredientRemoved = 1;
		}
		return IngredientRemoved;
	}
	 */
	
	public void addIngredient(Ingredient ingredient1)
	{
		ingredients.add(ingredient1);
	}
	
	public int getNumOfIngredients()
	{
		return ingredients.size();
	}
	
	public String ingredientListToString()
	{
		String str = "";
		for (Ingredient ingredient1:ingredients)
			str += ingredient1.toString();
		return str;
	}
	
	public String toString()
	{
		NumberFormat money = NumberFormat.getCurrencyInstance();
		String str = recipeName + "\n" +
				"Yield: " + yield + "\n" +
				"Cooking Time:  " + cookTime + "\n\n";
		return str;
	}

} //end of Recipe class