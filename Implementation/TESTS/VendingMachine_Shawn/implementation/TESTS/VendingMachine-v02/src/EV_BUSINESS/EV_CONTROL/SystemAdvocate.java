/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EV_BUSINESS.EV_CONTROL;

import EV_BUSINESS.EV_CONTROL.EVSystem;
import java.util.ArrayList;
import EV_BUSINESS.EV_VENDINGMACHINE.Slot;

/**
 *
 * @author Anon
 */
public class SystemAdvocate extends EVSystem implements Payment{
    
    
    private SystemControl systemControl;
    private Sensor sensor;
    private SensorHardware sensorHardware;
    private ArrayList<Integer> activeWeightSensors =new ArrayList<Integer>(); 
    private ArrayList<Integer> activeTemperatureSensrs =new ArrayList<Integer>();;
    private int acceleratorAddress;
    private int paymentHardwareAddress;
    private double currentPriceValue;

    public double getCurrentPriceValue() {
        return currentPriceValue;
    }

    public void setCurrentPriceValue(double currentPriceValue) {
        this.currentPriceValue = currentPriceValue;
    }

    private Slot[] slots = new  Slot[20];
    
    public SystemAdvocate(){
        super();
        this.acceleratorAddress = 42;
        this.paymentHardwareAddress=666;
    }
     public void setUpSystemControl(){  
        Slot tmp;
        int len = slots.length;
        for(int i=0;i<len;i++){
          tmp = new Slot();
          System.out.println("SA slot");
        slots[i]= tmp;
        }
        System.out.println("SA Test");
        reorder();
        
        this.sensor = new Sensor();
        this.sensorHardware = new SensorHardware(activeWeightSensors,activeTemperatureSensrs,acceleratorAddress,paymentHardwareAddress);
        this.sensor.setSensors(sensorHardware);
        this.systemControl  =new SystemControl(this);
        int a=0,b =0;
        if(this.activeWeightSensors.size()>0){
           a=1;
        }
        if(this.activeTemperatureSensrs.size()>0){
            b=1;
        }
        this.systemControl.setMultiplexer(a, b,1,1);
        this.systemControl.sens_Start(sensor);
     }
     
     public synchronized void initAction(){
     if(this.systemControl.isRunControl()==true)
        try {
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        determineAction();
        notify();
     }
     public  void determineAction(){
        if(this.systemControl.isRunControl()==false)
        try {
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        
        switch(this.systemControl.getAction()){
            case 1:this.testSync("case 1");
                   this.systemControl.setRunControl(true); 
                   /*reorder()*/break;
            case 2:this.testSync("case 2");
                    this.systemControl.setRunControl(true);
                   /*refund()*/break;
            case 3:this.testSync("case 3");
                    this.systemControl.setRunControl(true);
                   /*Dispense()*/break;
            case 4:this.testSync("case 4");
                   this.systemControl.setRunControl(true);
                   /*disableSlot()*/break;
            case 5:this.testSync("case 5");
                   this.systemControl.setRunControl(true);
                   /*errorMessage()*/break;
            case 6:this.testSync("case 6");
                   this.systemControl.setRunControl(true);
                   /*Something */break;
        
        }  
        this.systemControl.setRunControl(true);
        notify();
     }
     public void testSync(String n){
        System.out.println(n);
     }
     public void disableSlot(){
        
     }
    @Override
    public void Dispense(double p) {
        
       if(p < this.currentPriceValue){
           System.out.println(" Insufficient Fund ");
       }
       else if(p > this.currentPriceValue){
           System.out.println(" You have this change to take "  + (p - this.currentPriceValue));
      }
       else
           accept();
    }

    @Override
    public void refund() {
        
    }

    @Override
    public void accept() {
         System.out.println(" Thanks for shopping, please take your product ");
    }

    @Override
    public void sendData(String[] data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reorder() {
         ArrayList<String>slotData =new ArrayList<String>();
        database.dBopen();
        slotData= database.getMachineConfig();
        database.dBclose();
        int location = 0;
        int ctr=0;
        int len = slotData.size();
        for (int i=0;i<len;i++){
            String[] tmp = slotData.get(i).split(",");
            location = Integer.parseInt(tmp[0]);        
             if(tmp[1].equals("EMPTY")){
             }
            else{
              if(Double.parseDouble(tmp[4])>0){
                  System.out.println("Test what inside "+location+" "+ctr+"\n");
                this.activeTemperatureSensrs.add(ctr,location);
                this.activeWeightSensors.add(ctr,location);
                ctr++;
              }
            }
             System.out.println("Test "+ctr+"\n");
            
        }    
    }

    @Override
    public void errorMessage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validateLogin(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLoginDetails(int tableID, String[] n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listenConnect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getConfig() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setConfig(int tableID, String[] dbUpdate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Slot[] getSlots() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSlots(Slot[] slots) {
     
    }

    @Override
    public void updateConfig(String[] dbUpdate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
