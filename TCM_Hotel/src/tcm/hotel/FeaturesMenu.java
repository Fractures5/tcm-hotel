/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcm.hotel;

import java.util.ArrayList;

/**
 * The purpose of this class is to create the menu of the extra features by adding information
 * about the extra features into an array list. This class is a child class and inherits
 * certain methods/variables/characteristics from the Parent class Products. This class contains the 
 * specific constructors for initializing data only for features, and it contains the static menu output methods, 
 * toString methods and the special abstract method which all help output the array list in a neat manner 
 * to show the features menu which is used in the guest menu class. 
 * @author Siddarath
 */
public class FeaturesMenu extends Products 
{
    /**
     * This is a default constructor.
     * It has no parameters and returns nothing.
     * @author Siddarath
     */
    public FeaturesMenu()
    {
    }
    
    /**
     * This is a constructor for the FeaturesMenu class which contains input for specific variables like
     * title, feature types and price that will be used in this class to initialize the FeaturesMenu objects
     * and create the array lists which shows the features menu. This constructor uses the super class (Products) 
     * to get the needed properties and behaviors in order to initialize the FeaturesMenu objects.
     * @param title the parameter represents the title of selection, in this case it would be the title of the extra feature selected.
     * @param featureType the parameter represents the enumerated type FeatureType which holds the different types of extra hotel features.
     * @param price the parameter in this constructor represents the price of the selected extra feature pass.
     * @author Siddarath
     */
    public FeaturesMenu(String title, ExtraFeatureTypes featureType, Double price)
    {
        super(title, featureType, price); // Calls the super class "Products" and inherits the specified characteristics.
    }
    
    /**
     * This method will essentially output the menu of the extra features to the user.
     * This static method showMenu will create an object of the FeaturesMenu class and assign it to values
     * that are details about the extra features the hotel provides. Then the method adds these assigned objects
     * to the array list and then it outputs the array list that stores the information about the extra features
     * along with the unique index number which the guest can refer when selecting an option from this menu.
     * @return features the array list which holds all the information about the extra features.
     * @author Siddarath
     */
    public static ArrayList<FeaturesMenu> showMenu()
    {
        FeaturesMenu spa = new FeaturesMenu("Spa pass" , ExtraFeatureTypes.SPA , 10.00);
        FeaturesMenu jacuzzi = new FeaturesMenu("Jacuzzi pass" , ExtraFeatureTypes.JACUZZI , 10.00);
        FeaturesMenu sauna = new FeaturesMenu("Sauna pass" , ExtraFeatureTypes.SAUNA , 10.00);
        FeaturesMenu gym = new FeaturesMenu("Gym pass" , ExtraFeatureTypes.GYM , 20.00);
        
        ArrayList<FeaturesMenu> features = new ArrayList<FeaturesMenu>(); // Creating the array list object.
        features.add(spa); // Stores details into the array list object.
        features.add(jacuzzi);
        features.add(sauna);
        features.add(gym);
        
        FeaturesMenu featuresTitle = new FeaturesMenu();
        featuresTitle.menuBanner(); // Calls the abstract method to display this menus specific banner.
        
        
        for (FeaturesMenu featureTypes: features)
        {
            System.out.println("(" +features.indexOf(featureTypes)+ ") - " +featureTypes); // Prints out the features menu formatted with its index number in the front.
        }
        
        return features;
    }
    
    /**
     * This toString method will return a string representation of the FeaturesMenu class object.
     * This method utilizes the "strong.format" skill to make the menu look more organized in a column
     * format that is spaced out, legible and appealing.
     * @return a string which outputs all the instances variable values for the FeaturesMenu class. 
     * @author Siddarath
     */
    public String toString()
    {
        String output = String.format("%-30s", "Title: " + this.getTitle()); // String.format is used to format the features menu in columns.
        output += String.format("%-30s", "Feature Type: " + this.getFeatureType());
        output += String.format("%-25s", "Price: $" + this.getPrice());
        
        return output;
    }

    /**
     * This is the abstract method inherited from the Products class. This method will
     * output a special banner graphic to make the menu more appealing.
     * @author Siddarath
     */
    @Override
    public void menuBanner() 
    {
        System.out.println("\n---------------------------------------------------------------------------------");
        System.out.println("                          Special Features Menu");
        System.out.println("---------------------------------------------------------------------------------");
    }
}
