/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelDataFiles;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author faari
 */
public class LocationMenuTest {
    
    public LocationMenuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void locationZeroAucklandMatches()
    {
        ArrayList<LocationMenu> locationsMenu = new ArrayList<LocationMenu>();
        locationsMenu = LocationMenu.showMenu();
        
        String expectedResult = "Auckland Hotel - 31 Starcent Ave                  ";
        String realResult = locationsMenu.get(0).getTitle();
        assertEquals(expectedResult, realResult); 
    }
    @Test
    public void locationOneRotoruaMatchs() {
        
        ArrayList<LocationMenu> locationsMenu = new ArrayList<LocationMenu>();
        locationsMenu = LocationMenu.showMenu();

        String expectedResult = "Rotorua Hotel - 17 Geyser Crescent                ";
        String realResult = locationsMenu.get(1).getTitle();
        assertEquals(expectedResult, realResult);
    }
}
