/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EV_BUSINESS;

import EV_DATA_MANAGEMENT.DatabaseHelper;
import java.util.*;
import java.sql.*;
public class NewClass {

  public static final DatabaseHelper helper =  new DatabaseHelper();

	public static void main (String [] args)throws SQLException{
            ArrayList<String> testList = new ArrayList<String>();
            
            String[] name={"0","Admin","Admin","Empty","Empty"};
            helper.dBopen();            
            helper.insertTable(name, 2);
            helper.dBclose();
          
           /*
             for(int i=0;i<testList.size();i++){
               System.out.println(testList.get(i));
             }
           */
          
        }
}
