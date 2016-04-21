/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EV_BUSINESS.EV_CONTROL;

import EV_DATA_MANAGEMENT.DatabaseHelper;
import EV_BUSINESS.EV_VENDINGMACHINE.Slot;

/**
 *
 * @author Anon
 */
public abstract class EVSystem extends Thread{
    
    
     /**
     * 
     */
    protected final DatabaseHelper database;
    protected double overAllProductValue;

    
    /**
     * 
     */
    protected Server server;
    protected Thread t;
    
    protected Slot[] slots;

    public abstract Slot[] getSlots();
   
    public abstract void setSlots(Slot[] slots);
    
    public EVSystem(){
       this.database = new DatabaseHelper();
       this.server =null;
    }

     /**
     * @return
     */
    public double getOverAllProductValue() {
        return overAllProductValue;
    }

    public void setOverAllProductValue(double overAllProductValue) {
        this.overAllProductValue = overAllProductValue;
    }
    public void setUpDatabase() 
    {
        // TODO implement here
        database.dBopen();
    	database.createDataBase();
        database.dBclose();   	
    }

    /**
     */
    public void runServer() {
        /**
         *  We will have another observer here
         * Need to thread this here because server
         * Hijacks the main thread
         * 
         */
        
        this.server = new Server();
    }
    

    /**
     */
    public void reset() {
         int n;
         // TODO implement here
    	//DatabaseHelper database = new DatabaseHelper();
    	  database.dBopen();
          database.deleteAll();
    	  database.dBclose();
    	
    }
    public abstract void sendData(String [] data);
    
    public abstract void reorder();
 
    public abstract void errorMessage();

    
    public abstract boolean validateLogin(String username, String password);
       

   
    public abstract void setLoginDetails(int tableID,String[]n);

    
    public abstract void listenConnect();

   
    public abstract double getConfig();

    public abstract void updateConfig(String [] dbUpdate);
    
    public abstract void setConfig(int tableID,String[] dbUpdate);
    
    public void run() {
        
    System.out.println("Running server thread" );
    runServer();
    }
    public void start(){
        
      System.out.println("Starting server thread");
      if (t == null)
      {
         t = new Thread (this);
         t.start ();
      }
   }
      
}
  
 



   
