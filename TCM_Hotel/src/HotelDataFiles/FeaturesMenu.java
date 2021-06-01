/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelDataFiles;

import HotelEnums.ExtraFeatureTypes;
import java.util.ArrayList;

/**
 * The purpose of this class is to create the menu of the extra features by adding information
 * about the extra features into an array list. This class is a child class and inherits
 * certain methods/variables/characteristics from the Parent class Products. This class contains the 
 * specific constructors for initializing data only for features, and its array list is used
 * to show the feature types available menu which is used in the hotelFeaturesMenu GUI view and used to add
 * data into the guests booking cart.
 * @author Siddarath
 */
public class FeaturesMenu extends Products {
    
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
     * to the array list and is then used in the hotelFeaturesMenu view GUI to output the menu details and used to add
     * the selected features to the users booking cart.
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
        
        return features;
    }
}
