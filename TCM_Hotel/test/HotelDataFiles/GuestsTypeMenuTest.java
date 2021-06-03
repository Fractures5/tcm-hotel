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
public class GuestsTypeMenuTest {
    
    public GuestsTypeMenuTest() {
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
    public void guestsTypeAdultMatches() {
        ArrayList<GuestsTypeMenu> guestsTypeMenu = new ArrayList<GuestsTypeMenu>();
        guestsTypeMenu = GuestsTypeMenu.showMenu();

        String expectedResult = "Adult (18-64 yrs)";
        String realResult = guestsTypeMenu.get(0).getTitle();
        assertEquals(expectedResult, realResult);
    }

    @Test
    public void guestsTypeChildMatches() {
        ArrayList<GuestsTypeMenu> guestsTypeMenu = new ArrayList<GuestsTypeMenu>();
        guestsTypeMenu = GuestsTypeMenu.showMenu();

        String expectedResult = "Child (4-17 yrs)";
        String realResult = guestsTypeMenu.get(1).getTitle();
        assertEquals(expectedResult, realResult);
    }
    
}
