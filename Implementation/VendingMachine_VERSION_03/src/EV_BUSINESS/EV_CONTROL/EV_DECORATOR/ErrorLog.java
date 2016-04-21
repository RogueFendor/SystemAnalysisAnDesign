/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EV_BUSINESS.EV_CONTROL.EV_DECORATOR;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anon
 */
public class ErrorLog extends Report {
    protected File errorFile;
    protected PrintWriter writer;
    protected FileWriter out;
    protected BufferedWriter bw;
    protected Scanner in;
    
    public ErrorLog(){
        errorFile = new File("sys.log");
       if(!errorFile.exists()) {
            try {
                errorFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(ErrorLog.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
    }
    @Override
    public void createReport(String [] report) {
        System.out.println(report[0]+" "+report[1]);
         try
         {
            out= new FileWriter(errorFile, true);
            bw = new BufferedWriter(out);
            writer = new PrintWriter(bw);
            writer.println("[*] "+report[0]+report[1]);
           
         } 
         catch (IOException e) {
            System.out.println("Error in sys.log "+e);
            
        }
         finally{
            try{
              writer.close();
              bw.close();
              out.close();
            }
            catch( Exception e){
                 System.out.println( e.getClass().getName() + ": " + e.getMessage() );
                 System.out.println("Error in errorLog");
            }
        
         }
    }

    @Override
    public String[] getReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
