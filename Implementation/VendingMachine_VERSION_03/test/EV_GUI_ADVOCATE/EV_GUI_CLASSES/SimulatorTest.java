/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EV_GUI_ADVOCATE.EV_GUI_CLASSES;

import EV_BUSINESS.EV_OBSERVER.ObservableVals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Toshiba
 */
public class SimulatorTest {
    
    public SimulatorTest() {
    }
    
    Simulator sim = new Simulator();
    
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
     * Test of getCurrentPrice method, of class Simulator.
     */
    @Test
    public void testGetCurrentPrice() {
        System.out.println("getCurrentPrice");
        Simulator instance = new Simulator();
        double expResult = 0.0;
        double result = instance.getCurrentPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentPrice method, of class Simulator.
     */
    @Test
    public void testSetCurrentPrice() {
        System.out.println("setCurrentPrice");
        double currentPrice = 0.0;
        Simulator instance = new Simulator();
        instance.setCurrentPrice(currentPrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSystemObserver method, of class Simulator.
     */
    @Test
    public void testSetSystemObserver() {
        System.out.println("setSystemObserver");
        ObservableVals systemObserver = null;
        Simulator instance = new Simulator();
        instance.setSystemObserver(systemObserver);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTextAreas method, of class Simulator.
     */
    @Test
    public void testSetTextAreas() {
        System.out.println("setTextAreas");
        String n = "";
        Simulator instance = new Simulator();
        instance.setTextAreas(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTextFields method, of class Simulator.
     */
    @Test
    public void testSetTextFields() {
        System.out.println("setTextFields");
        String n1 = "";
        String n2 = "";
        Simulator instance = new Simulator();
        instance.setTextFields(n1, n2);
        // TODO review the generated test code and remove the default call to fail.
        if (n1!="Milk")
        fail("The test case is a prototype.");
    }
      private void cent5ActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
         Simulator instance = new Simulator();
         
           //System.out.println("5 cents read,  Price remain " + this.getCurrentPrice() + " you pay " + (Double.parseDouble(this.cent5.getText().substring(0,1))/100));
    }                                     

    
}
