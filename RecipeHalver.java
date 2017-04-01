/*import java.util.Scanner;

public class RecipeHalver 
{
	public static void main (String[] args)
	{
		int menu;
		double amount;
		String units;
		String ingredient;
		int size;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter number of ingredients in the recipe:");
		size = scan.nextInt();
		Recipe recipe= new Recipe();	// instantiate new recipe
		
		do
		{
			System.out.println("Options:");
			System.out.println("1. New Ingredient");
			System.out.println("2. Print Recipe");
			System.out.println("3. Halve Recipe");
			System.out.println("4. Quit");
			menu = scan.nextInt();
			
				switch(menu)
				{
				case 1:
					System.out.println("Program will ask for name of ingredient, amount, and units (grams, cups, teaspoons, etc...)");
					System.out.println("Enter name of ingredient:");
					ingredient = scan.nextLine();
					ingredient = scan.nextLine();
					System.out.println("Enter amount of ingredient (in decimals):");
					amount = scan.nextInt();
					System.out.println("Enter the units (grams, cups, teaspoons, etc...)");
					units = scan.nextLine();
					units = scan.nextLine();
					recipe.addIngredient(ingredient, amount, units);
					break;
					
				case 2:
					System.out.println(recipe.toString());
					break;
					
				case 3:
					recipe.halveRecipe();
					break;
					
				case 4:
					System.out.println("Program has quit");
					break;
					
				default:
					System.out.println("Invalid option");
				}
		}
		while (menu != 4);
	}
}
*/