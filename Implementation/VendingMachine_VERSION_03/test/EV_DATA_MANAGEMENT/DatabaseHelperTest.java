/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EV_DATA_MANAGEMENT;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anon
 */
public class DatabaseHelperTest {
    
    public DatabaseHelperTest() {
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
     * Test of dBopen method, of class DatabaseHelper.
     */
    @Test
    public void testDBopen() {
        System.out.println("dBopen");
        DatabaseHelper instance = new DatabaseHelper();
        instance.dBopen();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dBclose method, of class DatabaseHelper.
     */
    @Test
    public void testDBclose() {
        System.out.println("dBclose");
        DatabaseHelper instance = new DatabaseHelper();
        instance.dBclose();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createDataBase method, of class DatabaseHelper.
     */
    @Test
    public void testCreateDataBase() {
        System.out.println("createDataBase");
        DatabaseHelper instance = new DatabaseHelper();
        instance.createDataBase();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertTable method, of class DatabaseHelper.
     */
    @Test
    public void testInsertTable() {
        System.out.println("insertTable");
        String[] n = null;
        int i = 0;
        DatabaseHelper instance = new DatabaseHelper();
        instance.insertTable(n, i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateTable method, of class DatabaseHelper.
     */
    @Test
    public void testUpdateTable() {
        System.out.println("updateTable");
        String[] n = null;
        DatabaseHelper instance = new DatabaseHelper();
        instance.updateTable(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAll method, of class DatabaseHelper.
     */
    @Test
    public void testDeleteAll() {
        System.out.println("deleteAll");
        DatabaseHelper instance = new DatabaseHelper();
        instance.deleteAll();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteTable method, of class DatabaseHelper.
     */
    @Test
    public void testDeleteTable() {
        System.out.println("deleteTable");
        int n = 0;
        DatabaseHelper instance = new DatabaseHelper();
        instance.deleteTable(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteFromTable method, of class DatabaseHelper.
     */
    @Test
    public void testDeleteFromTable() {
        System.out.println("deleteFromTable");
        String[] n = null;
        DatabaseHelper instance = new DatabaseHelper();
        instance.deleteFromTable(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsers method, of class DatabaseHelper.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        DatabaseHelper instance = new DatabaseHelper();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMachineConfig method, of class DatabaseHelper.
     */
    @Test
    public void testGetMachineConfig() {
        System.out.println("getMachineConfig");
        DatabaseHelper instance = new DatabaseHelper();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getMachineConfig();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getID method, of class DatabaseHelper.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        String tableName = "";
        DatabaseHelper instance = new DatabaseHelper();
        int expResult = 0;
        int result = instance.getID(tableName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class DatabaseHelper.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        String userName = "";
        String email = "";
        DatabaseHelper instance = new DatabaseHelper();
        String expResult = "";
        String result = instance.getPassword(userName, email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIncidents method, of class DatabaseHelper.
     */
    @Test
    public void testGetIncidents() {
        System.out.println("getIncidents");
        DatabaseHelper instance = new DatabaseHelper();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getIncidents();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFinanceStatus method, of class DatabaseHelper.
     */
    @Test
    public void testGetFinanceStatus() {
        System.out.println("getFinanceStatus");
        DatabaseHelper instance = new DatabaseHelper();
        double expResult = 0.0;
        double result = instance.getFinanceStatus();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
