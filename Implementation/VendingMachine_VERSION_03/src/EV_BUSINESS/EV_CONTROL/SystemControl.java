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
    protected double [] TemperatureMask;
    protected double [] WeightMask;
    protected int AccelMask;

    public synchronized String getSimplifier1() {
        return simplifier1;
    }

    public synchronized void setSimplifier1(String simplifier1) {
        this.simplifier1 = simplifier1;
    }

    public synchronized String getSimplifier2() {
        return simplifier2;
    }

    public synchronized void setSimplifier2(String simplifier2) {
        this.simplifier2 = simplifier2;
    }
    protected int paymentHardwareMask;
    protected volatile static String simplifier1;
    protected volatile static String simplifier2;
    protected volatile static String simplifier3;
    protected volatile static String simplifier4;

    public int getAccelMask() {
        return AccelMask;
    }

    public void setAccelMask() {
        String data = this.sensor.getData(3);
         if(data.equals("")){
              this.setSimplifier3("");
        }
        else{
          this.setSimplifier3(data);
          String []tmp = data.split(" ");
          this.AccelMask = Integer.parseInt(tmp[1]) ;
          }
    }

    public synchronized String getSimplifier3() {
        return simplifier3;
    }

    public synchronized void setSimplifier3(String simplifier3) {
        this.simplifier3 = simplifier3;
    }

    public synchronized String getSimplifier4() {
        return simplifier4;
    }

    public synchronized void setSimplifier4(String simplifier4) {
        this.simplifier4 = simplifier4;
    }

    public int getPaymentHardwareMask() {
        return paymentHardwareMask;
    }

    public void setPaymentHardwareMask() {
        String data = this.sensor.getData(4);
         if(data.equals("")){
             this.setSimplifier4("");
        }
        else{
          this.setSimplifier4(data);
          String []tmp = data.split(" ");
          this.paymentHardwareMask = Integer.parseInt(tmp[1]);
        }
    }

    public int getAction() {
        return action;
    }

    public double[] getTemperatureMask() {
        return TemperatureMask;
    }

    public void setTemperatureMask() {
        String data = this.sensor.getData(2);
        if(data.equals("")){
          this.setSimplifier2("");
        }
        else{
            System.out.println("Test "+data);
            this.setSimplifier2(data);
            data = data.replace("activeTempSensors ","");
            data = data.replace(","," ");
            String [] doubleVals = data.split(" ");  
            int len = doubleVals.length;
            this.TemperatureMask= new double[len]; 
            for(int i=0;i<len ;i++){
                this.TemperatureMask[i] =Double.parseDouble(doubleVals[i]);
            }
        } 
    }

    public double[] getWeightMask() {
        
        return WeightMask;
    }

    public void setWeightMask() {
        String data = this.sensor.getData(1);
        if(data.equals("")){
            this.setSimplifier1("");
        }
        else{
            this.setSimplifier1(data);
            data = data.replace("activeWeightSensors ","");
            data = data.replace(","," ");
            String [] doubleVals = data.split(" "); 
            int len = doubleVals.length;
            this.WeightMask = new double[len];
            for(int i=0;i<len ;i++){
                this.WeightMask[i]=Double.parseDouble(doubleVals[i]);
            }
        }
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
        this.setPaymentHardwareMask();
        this.setTemperatureMask();
        this.setWeightMask();
        this.setAccelMask();
        start();
    }
    
    public void verify(String data,int ctr){ 
       switch(ctr){
           case 1: if(!data.equals(this.getSimplifier1())){
                System.out.println("test Data and strings {"+this.getSimplifier1()+"} {"+data+"}");
                       this.setAction(1);
                       this.runControl = false;
                    }
           break;
           case 2: if(!data.equals(this.getSimplifier2())){
                       System.out.println("test Data and strings {"+this.getSimplifier2()+"} {"+data+"}");
                      this.setAction(2);
                      this.runControl = false;
                    }
           break;
           case 3: if(!data.equals(this.getSimplifier3())){
                       System.out.println("test Data and strings {"+this.getSimplifier3()+"} {"+data+"}");
                      this.setAction(3);
                      this.runControl = false;
                    }
           break;
           case 4: if(!data.equals(this.getSimplifier4())){
                       System.out.println("test Data and strings {"+this.getSimplifier4()+"} {"+data+"}");
                      this.setAction(4);
                      this.runControl = false;
                    }
           break;
       }
    }
    ///////////////// Sensor Thread End ///////////////////////
    public int provideAction(){
       return action;
    }
    public void run() {
        
        int ctr=0;
        String data="";
        
        while(true){
            if(this.runControl == false){
              try{
                    this.systemAdvocate.initAction(this.getSimplifier2());
                    Thread.sleep(3000);
                    this.runControl =true;
              }
           catch( InterruptedException e ){
               System.out.println("Exception sleepy is faulty:");
           }
            
            
            }
           if(ctr < 4){
             if(multiplexer[ctr]>0){   
               data = this.sensor.getData(ctr+1);
             }
           }
           else{
              ctr= 0;
              if(multiplexer[ctr]>0){   
                 data = this.sensor.getData(ctr +1);
              }
           }
           verify(data,ctr+1);
           ctr++;
           try{
            Thread.sleep(2000);
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
