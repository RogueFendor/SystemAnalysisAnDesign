/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EV_BUSINESS.EV_CONTROL;

import EV_BUSINESS.EV_CONTROL.Sensor;
import EV_BUSINESS.EV_CONTROL.SystemAdvocate;

/**
 *
 * @author Anon
 */
public class SystemControl extends Thread {
    
    private boolean runControl =true;
    private SystemAdvocate systemAdvocate;
    private Thread t;
    protected int action;
    protected int[]multiplexer =new int [4];

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }
    public void setMultiplexer(int a,int b,int c,int d){
       this.multiplexer[0]=a;
       this.multiplexer[1]=b;
       this.multiplexer[2]=c;
       this.multiplexer[3]=d;
    }
    private Sensor sensor =null;
    
    public SystemControl(SystemAdvocate systemAdvocate){
      this.systemAdvocate = systemAdvocate;
      
    }
    public boolean isRunControl() {
        return runControl;
    }

    public void setRunControl(boolean runControl) {
        this.runControl = runControl;
    }
    
    /////////////////Sensor Thread Start ////////////////////////
    protected void sens_Start(Sensor sensor){
        this.sensor = sensor;
        start();
    }
    
    public void verify(String data){ 
      System.out.println("verifying this: "+data);
    }
    ///////////////// Sensor Thread End ///////////////////////
    
    public int provideAction(){
    return action;
    }
    public void run() {
        
        int ctr=0;
        String data="";
        
        while(this.runControl ==true){
            System.out.println("Inside the Control");
           if(ctr < 4){
             if(multiplexer[ctr]>0){   
               data = this.sensor.getData(ctr+1);
               System.out.println("ctr: "+ctr);
               System.out.println("Inside the Control multiplexer has value Sensor called:\n"+data);
              
             }
           }
           else{
              ctr= 0;
              if(multiplexer[ctr]>0){   
                 data = this.sensor.getData(ctr);
                   System.out.println("ctr: "+ctr);
                 System.out.println("Inside the Control multiplexer has value Sensor called "+data+"\n");
              }
           }
           ctr++;
           verify(data);
           try{
            Thread.sleep(500);
            this.setAction(ctr);
            this.systemAdvocate.initAction();
            this.runControl =false;
           }
           catch( InterruptedException e ){
               System.out.println("Exception sleepy is faulty:");
           }
          }
    }
    public void start(){
     System.out.println("Starting Sampling");
      if (t == null)
      {
         t = new Thread (this,"initAction");
         t.start ();
      }
    
   }
    
}
