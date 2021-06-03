/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelDriver;

import HotelDatabase.HotelProductDB;
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
public class TCMHotelAppTest {
    
    private TCMHotelApp hotelMain;
    
    public TCMHotelAppTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() 
    {
        hotelMain = new TCMHotelApp();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void dbConnection()
    {
        
    }

    /**
     * Test of main method, of class TCMHotelApp.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        TCMHotelApp.main(args);
    }
}
