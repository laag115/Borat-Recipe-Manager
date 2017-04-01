
public class Ingredient
{
	private double ingredientAmount;
	private String ingredientUnit;
	private String ingredientName;
	
	public Ingredient()
	{
		ingredientAmount = 0.0;
		ingredientUnit = "???";
		ingredientName = "???";
	}
	
	public Ingredient(double ingredientAmount, String ingredientUnit, String ingredientName)
	{
		this.ingredientAmount = ingredientAmount;
		this.ingredientUnit = ingredientUnit;
		this.ingredientName = ingredientName ;
	}
	
	public String toString()
	{
		String str = "" + ingredientAmount + ingredientUnit + ingredientName;
		return str;
	}
}
