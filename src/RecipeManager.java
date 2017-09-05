// Initial method

import javax.swing.*;
import java.util.*;

public class RecipeManager extends JApplet
 {

   private int APPLET_WIDTH = 800, APPLET_HEIGHT = 300;

   private JTabbedPane tPane;
   private NewRecipePanel newRecipePanel;
   private IngredientsPanel ingredientsPanel;
   private ArrayList <Recipe> recipeList;

   //The method init initializes the Applet with a Pane with two tabs
   public void init()
    {
     //list of recipes to be used in every panel
     recipeList = new ArrayList <Recipe> ();

     //customer selection panel uses the list of flights
     ingredientsPanel = new IngredientsPanel(recipeList);

     newRecipePanel = new NewRecipePanel(recipeList, ingredientsPanel);

     //create a tabbed pane with two tabs
     tPane = new JTabbedPane();
     tPane.addTab("New Recipe", newRecipePanel);
     tPane.addTab("Ingredients", ingredientsPanel);

     getContentPane().add(tPane);
     setSize (APPLET_WIDTH, APPLET_HEIGHT); //set Applet size
    }
}