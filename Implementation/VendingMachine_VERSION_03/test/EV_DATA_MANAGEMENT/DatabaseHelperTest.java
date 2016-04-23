/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EV_DATA_MANAGEMENT;

import java.sql.SQLException;
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
    public String [] tab1 =new String[4];
    public String [] tab2 =new String[4];
    public String [] tab3 =new String[4];
    public String [] tab4 =new String[4];
    public String [] tab5 =new String[4];
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
        //Testing insertion for the slots
        tab1=new String []{"SLOT_CONFIG","PRODUCT_NAME","NewProductName","1"};            
        tab2= new String[]{"SLOT_CONFIG","QUANTITY","20","1"};             
        tab3= new String[]{"SLOT_CONFIG","PRICE","2000","1"};             
        tab4= new String[]{"SLOT_CONFIG","TEMP_RANGE","230","1"};              
        tab5= new String[]{"SLOT_CONFIG","PRICE","23.90","1"};
                  
             
        
    }
    
    @After
    public void tearDown() {
    }

    
    /**
     * Test of dBopen method, of class DatabaseHelper. 
     * This test case checks does database open when invoked
     */
    @Test
    public void testDBopen() {
        System.out.println("dBopen");
        DatabaseHelper instance = new DatabaseHelper();
        instance.dBopen();
       if(instance.returnConnection() == null){
          fail("No connection could be established");
       }
       else{
      System.out.println("Connection Established");
       }
    }

    /**
     * Test of dBclose method, of class DatabaseHelper.
     */
    @Test
    public void testDBclose() {
        System.out.println("dBclose");
        DatabaseHelper instance = new DatabaseHelper();
        instance.dBclose();
        if(instance.returnConnection() == null){
            System.out.println("Connection Successfully closed");
        }
        else
        fail("Connection has not closed");
    }
    public void testDBcloseOnCrud(DatabaseHelper helper) {
        System.out.println("dBclose");
        DatabaseHelper instance = helper;
        instance.dBclose();
        if(instance.returnConnection() == null){
            System.out.println("Connection Successfully closed");
        }
        else
        fail("Connection has not closed");
    }

   
    /**
     * 
     * @param helper  
     * this method is used during the test to continously
     * check does db on any any CRUD (create,read,update,delete)
     */
    
    public void testDBConnection(DatabaseHelper helper ) {
        System.out.println("dBopen");
        DatabaseHelper instance = helper;
        instance.dBopen();
        if(instance.returnConnection() != null){
            System.out.println("Connection Successfully opened");
        }
        else
        fail("Connection has not opened");
    }
   
    /**
     * Test of updateTable method, of class DatabaseHelper.
     */
    @Test
    public void testUpdateTable() {
       
        
        System.out.println("insertTable");
        String[] n = null;
        int i = 0;
        DatabaseHelper instance = new DatabaseHelper();
        instance.dBopen();
        //Passing the instance to check
        testDBConnection(instance);
        instance.updateTable(tab1);
        instance.updateTable(tab2);
        instance.updateTable(tab3);
        instance.updateTable(tab4);
        instance.updateTable(tab5);
        
        if(instance.isStatus() == true){
            //we chech has an error occured in update 
            fail("Update Failed");
        }else{
            System.out.println("Update sucessful ");
            testDBcloseOnCrud(instance); 
        }
    }   
    /**
     * Test of getUsers method, of class DatabaseHelper.
     * this method checks does Database helper return a list of users
     * It is based on the fact users are exist  in database
     * 
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        DatabaseHelper instance = new DatabaseHelper();
        instance.dBopen();
        this.testDBConnection(instance);
       
        ArrayList<String> result = instance.getUsers();
        if(result.size()>0){
            System.out.println("Has returne user lists");
            this.testDBcloseOnCrud(instance);
        }
        else{
           fail("Returned nothing");
        }
    }

    

    /**
     * Test of getID method, of class DatabaseHelper
     * This method return the maximum ID value in a table
     * We assume that tables are populated and always contain at least one ID
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        String tableName1 = "SLOT_CONFIG";
         String tableName2 = "TECHNICIAN";
         String tableName3 = "INCIDENT";
         String tableName4 = "ACCOUNT";
         
        DatabaseHelper instance = new DatabaseHelper();
        this.testDBConnection(instance);
        int result = instance.getID(tableName1);
         if(result > 0){
            System.out.println("Success");
        }else{
        fail("Max id for SLOT_CONFIG is not greater than zero");
        }
        result = instance.getID(tableName2);
        if(result > 0){
            System.out.println("Success");
        }else{
        fail("Max id TECHNICIAN is not greater than zero");
        }
            
        result = instance.getID(tableName3);
         if(result > 0){
            System.out.println("Success");
        }else{
        fail("Max id INCIDENT is not greater than zero");
        }
        result = instance.getID(tableName4);
         if(result > 0){
            System.out.println("Success");
        }else{
        fail("Max id Account is not greater than zero");
        }
        this.testDBcloseOnCrud(instance);
    }
    
}
