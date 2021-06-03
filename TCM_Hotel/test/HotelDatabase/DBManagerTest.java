/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
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

public class DBManagerTest {
    
    public DBManagerTest() {
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

    /**
     * Test of establishConnection method, of class DBManager.
     */
    @Test
    public void testEstablishConnection() {
        System.out.println("establishConnection");
        DBManager instance = new DBManager();
        instance.establishConnection();
    }

    
    /**
     * Test of getConnection method, of class DBManager.
     */
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        DBManager instance = new DBManager();
        Connection expResult = null;
        Connection result = instance.getConnection();
        assertEquals(expResult, result);
    }

    /**
     * Test of queryDB method, of class DBManager.
     */
    @Test
    public void testQueryDB() 
    {
        System.out.println("queryDB");
        String sql = "";
        DBManager instance = new DBManager();
        ResultSet expResult = null;
        ResultSet result = instance.queryDB(sql);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateDB method, of class DBManager.
     */
    @Test
    public void testUpdateDB() {
        System.out.println("updateDB");
        String sql = "";
        DBManager instance = new DBManager();
        instance.updateDB(sql);
    }

    /**
     * Test of closeConnnections method, of class DBManager.
     */
    @Test
    public void testCloseConnnections() {
        System.out.println("closeConnnections");
        DBManager instance = new DBManager();
        instance.closeConnnections();
    }
}
