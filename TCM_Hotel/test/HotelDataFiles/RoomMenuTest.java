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
public class RoomMenuTest {
    
    public RoomMenuTest() {
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
    public void roomTitleStandardMatches(){
        ArrayList<RoomMenu> roomMenu = new ArrayList<RoomMenu>();
        roomMenu = RoomMenu.showMenu();

        String expectedResult = "Standard Room (1 Double size bed)";
        String realResult = roomMenu.get(0).getTitle();
        assertEquals(expectedResult, realResult);
    }

    @Test
    public void roomTitleDeluxeMatches() {
        ArrayList<RoomMenu> roomMenu = new ArrayList<RoomMenu>();
        roomMenu = RoomMenu.showMenu();

        String expectedResult = "Deluxe Room (1 King Size bed)";
        String realResult = roomMenu.get(1).getTitle();
        assertEquals(expectedResult, realResult);
    }
}
