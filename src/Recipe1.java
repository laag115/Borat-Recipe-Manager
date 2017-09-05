public class Recipe1
{
	int size;
	private int count;				// hold how many ingredients
	private String[] ingredient; 	// hold names of ingredients
	private double[] amount;		// hold amount of ingredients
	private String[] units;			// holds units (cups, grams, etc)
	
	public Recipe1 (int size)
	{
		ingredient = new String[size];
		amount = new double[size];
		units = new String[size];
	}
	
	public void addIngredient(String addedIngredient, double newAmount, String newUnits)
	{
/*			if (count == size)
			doubleCapacity();
		
		else
*/		{
			ingredient[count] = addedIngredient;
			amount[count] = newAmount;
			units[count] = newUnits;
			count++;
		}
	}
	
/*	private void doubleCapacity()
	{
		String[] ingredient1 = new String[size];
		double[] amount1 =  new double[size];
		String[] units1 = new String[size];
		
		ingredient1 = ingredient;
		amount1 = amount;
		units1 = units;
		
		ingredient = new String[size*2];
		amount = new double[size*2];
		units = new String[size*2];
		
		for (int i = 0; i < ingredient.length; i++)
		{
			ingredient[i] = ingredient1[i]; 
			amount[i] = amount1[i];
			units[i] = units1[i];
		}
	}
*/
	public void halveRecipe()
	{
		for (int i = 0; i < count; i++)
			amount[i] = amount[i]/2;
	}
	
	public String toString()
	{
		String recipe = "";
		for (int i = 0; i < count; i++)
		{
		recipe += ingredient[i] + " " + amount[i] + " " + units[i] + "\n";
		}
		return recipe;
	}	
}