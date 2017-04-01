// Panel where user creates new recipes

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class NewRecipePanel extends JPanel
{	
	// panels
	private JPanel mainPanel = new JPanel(new GridLayout ( 2, 2 ));
	private JPanel leftPanel = new JPanel();
	private JPanel rightPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();

	// make a gridlayout for user input fields
	GridLayout grid = new GridLayout ( 10, 2 );

	// new empty recipe object to be filled by user
	private Recipe recipe1 = null;
	// new arraylist to hold user recipes
	private ArrayList <Recipe> recipeList = new ArrayList<Recipe>();
	// arraylist to hold all fields that take user input
	private ArrayList <JTextField> fieldList = new ArrayList<JTextField>(); 
	// make new ingredientspanel object to add checkboxes to
	private IngredientsPanel IngredientsPanel = new IngredientsPanel(recipeList); 

	// vars to hold ints parsed from user string input MIGHT BE USEFUL FOR YIELD PARSING NUMBERS OUT
	//private int recipeNumber;

	private static double airfarePrice;

	// vars that user will set the value of to create new recipe
	private String recipeName;
	private String yield;
	private String cookTime;

	// number of validrecipes
	private int validRecipes = 0;

	// labels and textboxes for user input
	private JLabel Alert = new JLabel();
	private JLabel placeholder0 = new JLabel();
	private JLabel recipeNameLabel = new JLabel ("Enter Recipe Name");
	private JTextField recipeNameField = new JTextField( );
	private JLabel yieldLabel = new JLabel("Enter Yield");
	private JTextField yieldField = new JTextField(" ");
	private JLabel cookTimeLabel = new JLabel("Enter Time to Cook");
	private JTextField cookTimeField = new JTextField(" ");

	// create jTextArea to hold the recipe information
	private JTextArea recipeInfo = new JTextArea(13, 20);

	// button to create a recipe   
	private JButton button1 = new JButton("Create a Recipe");

	//Constructor initializes components and organize them using certain layouts
	public NewRecipePanel(ArrayList <Recipe> recipeList, IngredientsPanel selectPanel)
	{
		// sets layout for leftPanel	 
		leftPanel.setLayout(grid); 
		this.recipeList = recipeList;
		this.IngredientsPanel = selectPanel;

		// add textfields to an arraylist
		fieldList.add(recipeNameField);
		fieldList.add(yieldField);
		fieldList.add(cookTimeField);

		// components organized into the gridLayout here
		// add alert on top of labels
		leftPanel.add (Alert);
		Alert.setForeground(Color.RED);
		// add labels and textfields for user input 
		leftPanel.add (placeholder0);
		leftPanel.add (recipeNameLabel);
		leftPanel.add (recipeNameField);
		leftPanel.add (yieldLabel);
		leftPanel.add (yieldField);
		leftPanel.add (cookTimeLabel);
		leftPanel.add (cookTimeField);


		// add button
		buttonPanel.add (button1);
		// add recipeinfo display
		rightPanel.add (recipeInfo);
		recipeInfo.setText("No Recipe");

		// organize all 3 panels in main panel, add mainpanel to frame
		mainPanel.add(leftPanel);
		mainPanel.add(rightPanel);
		mainPanel.add(buttonPanel);
		this.add(mainPanel);

		// add listener for when user clicks "Create a recipe"
		button1.addActionListener(new ButtonListener());
	}
	//ButtonListener is a listener class that listens to
	//see if the button "Create a recipe" is pushed.
	//When the event occurs, it adds a recipe using the information
	//entered by a user.
	//It also performs error checking.
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{       
			// DONT ALLOW USER TO MKE NEW FLIGHT WITHOUT NUMBERS IN NUMBER FIELD OR EMPTY BOXES        	 
			int isValidInput = 1;
			// error handling for user who leaves one of the boxes empty
			for (int i = 0; i < fieldList.size(); i ++)
				if (fieldList.get(i).getText().equals(""))
				{            	     
					isValidInput = 0;
					Alert.setText("Please enter all fields");
				}

			if (isValidInput == 1)
			{        
				Alert.setText("");
				// use recipe info entered by user to make a new recipe object
				recipeName = recipeNameField.getText();
				yield = yieldField.getText();
				cookTime = cookTimeField.getText();
				Recipe recipe1 = new Recipe(recipeName, yield, cookTime);
				// add recipe object into recipeList
				recipeList.add(recipe1);
				for (int i = 0; i <= validRecipes; i ++)
					System.out.print("Recipe list: " + recipeList.get(i).toString());

				// updates textarea to the recipe information
				if (validRecipes == 0)
					recipeInfo.setText(recipeList.get(0).toString());
				else
					recipeInfo.append(recipeList.get(validRecipes).toString());

				// add checkbox to ingredientspanel
				IngredientsPanel.addCheckBox(recipe1);
				validRecipes++;
				//for (int i = 0; i < validRecipes; i ++)
					//System.out.println("valid recipes in recipepanel: " + recipeList.get(i).toString());

			}

		} //end of actionPerformed method
	} //end of ButtonListener class

	public static double getAirfarePrice()
	{
		return airfarePrice;
	}
}