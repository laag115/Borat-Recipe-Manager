// Assignment #: 6
//         Name: Luis Gomez
//    StudentID: 1210949750
//      Lecture: 8:35 AM MWF
//  Description: Allows user to calculate flight prices by clicking on a check box

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.text.NumberFormat;

public class IngredientsPanel extends JPanel
{
	/*************************************
	Instantiate variables and GUI elements
	*************************************/
	private ArrayList <Recipe> recipeList;
	private Recipe recipe1 = null;
	// panel that contains recipe and ingredient elements
	private JPanel mainPanel = new JPanel(new GridLayout(3,1));
    private JPanel recipePanel = new JPanel(new GridLayout(0,1));
    private JPanel addOrRemoveIngredientPanel = new JPanel(new GridLayout(2,3));
    private JPanel ingredientListPanel = new JPanel(new GridLayout(1,0));

	// list of buttons to hold recipes
	private ArrayList <JRadioButton> RecipeSelectionList = new ArrayList<JRadioButton>();
	private JRadioButton recipeSelectionButton = new JRadioButton();
	
	// MIGHT CAUSE PROBLEMS **********
	int currentSelectionIndex = -1;
	
	// for creating new ingredient
	Ingredient ingredient1 = null;
	
	private JLabel Add_Ingredient_Label = new JLabel("Type Ingredient to Add");
	private JTextField Add_Ingredient_Field = new JTextField("ex: .5 cups flour");
	private JButton Add_Ingredient_Button = new JButton ("Add Ingredient");
	private JLabel Remove_Ingredient_Label = new JLabel("Type Ingredient to Remove");
	private JTextField Remove_Ingredient_Field = new JTextField("");
	private JButton Remove_Ingredient_Button = new JButton("Remove Ingredient");
	private JTextArea IngredientsListArea = new JTextArea("Ingredients\n    ");
    String properFormatMessage =
            "Please follow proper ingredient format \n" +
                    "   Amount unit name \n" +
                    "Example: \n" +
                    "   .5 cups flour";

	public IngredientsPanel(ArrayList <Recipe> recipeList)
	{
		this.recipeList = recipeList;

		// organize components for purchase panel
		// add both panels to mainPanel
		mainPanel.add(recipePanel);
		mainPanel.add(addOrRemoveIngredientPanel);
		mainPanel.add(ingredientListPanel);


		addOrRemoveIngredientPanel.add(Add_Ingredient_Label);
		addOrRemoveIngredientPanel.add(Add_Ingredient_Field);
		addOrRemoveIngredientPanel.add(Add_Ingredient_Button);
		addOrRemoveIngredientPanel.add(Remove_Ingredient_Label);
		addOrRemoveIngredientPanel.add(Remove_Ingredient_Field);
		addOrRemoveIngredientPanel.add(Remove_Ingredient_Button);
		addOrRemoveIngredientPanel.add(IngredientsListArea);


		ingredientListPanel.add(IngredientsListArea);


		//add mainpanel to frame
		this.add(mainPanel);

	} //end of constructor

	 /********************
	 This method adds a new radio button every time a user creates a new recipe
	 *******************/
	public void addCheckBox(Recipe recipe1)
	{
		this.recipe1 = recipe1;
		recipeSelectionButton = new JRadioButton(recipe1.getRecipeName() + "   " + "Yield: " +
				recipe1.getYield() + "   " + "Time: " +recipe1.getCookTime());
		recipePanel.add(recipeSelectionButton);
		recipeList.add(recipe1);
		/*for (Recipe recipe:recipeList)
			System.out.println("RecipeList in radio buttons: " + recipe1.toString());*/
		// add recipe button to group
		RecipeSelectionList.add(recipeSelectionButton);
        ButtonGroup group = new ButtonGroup();
        for (JRadioButton button: RecipeSelectionList)
            group.add(button);
        
		recipeSelectionButton.addItemListener(new CheckBoxListener());
		Add_Ingredient_Button.addActionListener(new AddIngredientListener());
		
	}

	/*****************************************
     Radio buttons containing each recipe
	************************************/
	private class CheckBoxListener implements ItemListener
	{
		public void itemStateChanged(ItemEvent e)
		{
			IngredientsListArea.append("You clicked the RadioButton!");
			
			for (int i = 0; i < RecipeSelectionList.size(); i ++)
				if (RecipeSelectionList.get(i).isSelected())
					currentSelectionIndex = i;
			
			System.out.println(currentSelectionIndex);
		}
	}// end of radio button event listener class

    // when add ingredient button gets pushed,
    // parse users added ingredient into amount, units, and name
    //
    private class AddIngredientListener implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
        	/******************************
			 When Add Ingredient Button is clicked,
			 parse the ingredient, create a new ingredient object out of it
			 add the ingredient object to ingredient list, add the ingredient list to current recipe
			 ******************************/
            boolean newIngredient0isAlpha = false;
            if (Add_Ingredient_Field.getText().equals(null))
                IngredientsListArea.setText(properFormatMessage);
            
            else if(Add_Ingredient_Field.getText().equals("ex: .5 cups flour"))
            	IngredientsListArea.setText(properFormatMessage);
            		
            else
            {
                double ingredientAmount = 0;
                String newIngredientStr = Add_Ingredient_Field.getText().trim();
                String newIngredientStrArr[] = newIngredientStr.split(" ");
                String amountToParse = newIngredientStrArr[0];

                // TODO FIX ERROR CHECKING: Not checking if the first part of the string is alpha and displaying formatting message properly
                // checks if all characters entered are alpha ( we don't want that)
                for (int i = 0; i < amountToParse.length(); i ++)
                    newIngredient0isAlpha = amountToParse.matches("^.*[z-zA-Z].*$");
                // newIngredient0 is alpha return proper format message
                if (newIngredient0isAlpha)
                    IngredientsListArea.setText(properFormatMessage);

                // if its NOT alpha, make an ingredient object, add it to the list of the currently selected recipe
                else
                {
                	// create new ingredient
                    ingredientAmount = Double.parseDouble(newIngredientStrArr[0]);
                	String ingredientUnit = null;
                	String ingredientName = null;
                    ingredientUnit = newIngredientStrArr[1];
                    ingredientName = newIngredientStrArr[2];
                    ingredient1 = new Ingredient(ingredientAmount, ingredientUnit, ingredientName);
                    
                    // add ingredient to recipelist
                    recipeList.get(currentSelectionIndex).addIngredient(ingredient1);
                    
                    // display ingredients for current recipe
                    IngredientsListArea.setText("Ingredient added!\n");
                	
                    for (int i = 0; i < recipeList.get(currentSelectionIndex).getNumOfIngredients(); i ++)
                	{
                		IngredientsListArea.append(recipeList.get(currentSelectionIndex).ingredientListToString());
                	}
                }
            }
        }
    }

}