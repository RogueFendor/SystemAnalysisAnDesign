/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EV_BUSINESS.EV_CONTROL;
import EV_BUSINESS.EV_CONTROL.EVSystem;
import EV_BUSINESS.EV_CONTROL.EV_DECORATOR.ErrorReporter;
import EV_BUSINESS.EV_CONTROL.EV_DECORATOR.IsTemperatureImballanceReport;
import EV_BUSINESS.EV_CONTROL.EV_DECORATOR.Report;
import java.util.ArrayList;
import EV_BUSINESS.EV_VENDINGMACHINE.Slot;
import EV_GUI.ErrorReport;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Anon
 */
public class SystemAdvocate extends EVSystem implements Payment{
    
    
    public SystemControl systemControl;
    private Sensor sensor;

    public String getPreviousVal() {
        return previousVal;
    }

    public void setPreviousVal(String previousVal) {
        this.previousVal = previousVal;
    }
    private double currentPriceValue;
    private String previousVal;
    private SensorHardware sensorHardware;
    private ArrayList<double []> activeWeightSensors =new ArrayList<double[]>(); 
    private ArrayList<double []> activeTemperatureSensrs =new ArrayList<double[]>();;
    private int acceleratorAddress;
    
    public void simulateTempImballance(){
        
       this.setPreviousVal(this.systemControl.getSimplifier2());
       String n = "Error In Data";
       this.systemControl.setSimplifier2(n);
    }
    public void resetValueToOrigin(int i){
       switch(i){
           case 1:  this.systemControl.setSimplifier1(this.getPreviousVal());break;
           case 2:  this.systemControl.setSimplifier2(this.getPreviousVal());break;
           case 3:  this.systemControl.setSimplifier3(this.getPreviousVal());break;
           case 4:  this.systemControl.setSimplifier4(this.getPreviousVal());break;
       }
    }

    /**
     *
     * @param i
     */
    public void imballance(int i){
       
       switch(i){
           case 1:  this.simulateWeightImballance();break;
           case 2:  this.simulateTempImballance();break;
           case 3:  this.simulateImpact();break;
           case 4:  this.simulateMoneyUpdate();break;
       }
    }
    public void simulateWeightImballance(){
        System.out.println(this.systemControl.getSimplifier1());
          this.setPreviousVal(this.systemControl.getSimplifier1());
          String n = "Error In Data";
          this.systemControl.setSimplifier1(n);
           System.out.println(this.systemControl.getSimplifier1());
    }
    public void simulateImpact(){
     this.setPreviousVal(this.systemControl.getSimplifier3());
       String n = "Error In Data";
       this.systemControl.setSimplifier3(n);
    }
    public void simulateMoneyUpdate(){
         this.setPreviousVal(this.systemControl.getSimplifier4());
         String n = "Error In Data";
         this.systemControl.setSimplifier4(n);
    }
    public double getCurrentPriceValue() {
        return currentPriceValue;
    }

    public void setCurrentPriceValue(double currentPriceValue) {
        this.currentPriceValue = currentPriceValue;
    }

    public double getFinancialStatus() {
        return financialStatus;
    }

    public void setFinancialStatus(double financialStatus) {
        this.database.dBopen();
       this.financialStatus = database.getFinanceStatus();
       this.database.dBclose();
    }
    private int paymentHardwareAddress;
    protected double financialStatus;

    private Slot[] slots = new  Slot[20];
    
    public SystemAdvocate(){
        super();
        this.acceleratorAddress = 42;
        this.paymentHardwareAddress=666;
        setUpSystemControl();
    }
    
     public void setUpSystemControl(){  
        Slot tmp;
        int len = slots.length;
        for(int i=0;i<len;i++){
          tmp = new Slot();
        slots[i]= tmp;
        }
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
     public void initAction(String data){
         //if(this.systemControl.isRunControl()==true)
         this.systemControl.setRunControl(false);
            determineAction(data);
     }
     public  void determineAction(String sampleData){
        if(this.systemControl.isRunControl()==false) {
            switch(this.systemControl.getAction()){
                case 1:this.testSync("case 1");
                       this.systemControl.setRunControl(true); 
                       /*reorder()*/break;
                case 2: this.disableSlot(sampleData);
                        this.systemControl.setRunControl(true);
                        break;
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
        }
        this.systemControl.setRunControl(true);
     }
     public void testSync(String n){
        System.out.println(n);
     }
     public void disableSlot(String data){
       String [] faultConfig = new String[8];
       double [] tempMask = this.systemControl.getTemperatureMask();
       data = data.replace("activeTempSensors ","");
       data = data.replace(","," ");  
       String [] sampledTempVals = data.split(" ");
        int len = sampledTempVals.length;
        double [] sampledTemperatureData = new double[len];
       for (int i = 0;i<len;i++){
            sampledTemperatureData[i]= Double.parseDouble(sampledTempVals[i]);
            if(i%2==0){
               if(tempMask[i]!= sampledTemperatureData[i]){
              
                    faultConfig[0]="SLOT_CONFIG";
                    faultConfig[1]=""+i;
                    faultConfig[2]="FAULTY";
                    faultConfig[3]="0";
                    faultConfig[4]="0.0";
                    faultConfig[5]="0.0";
                    faultConfig[6]="0.0";
                    faultConfig[7]="0.0";
                this.updateConfig(faultConfig);
               }
            }
       }
       DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
       Date dateobj = new Date();
       String date = df.format(dateobj);
       String [] report = new String [6];
       this.database.dBopen();
       int maxID = database.getID("INCIDENT");
       this.database.dBclose();
       report[0]=""+maxID;
       report[1]=date;
       report[2]="Temperature Imballance";
       report[3]="Slot "+faultConfig[1]+" Disabled";
       this.database.dBopen();
       double finance = database.getFinanceStatus();
       this.database.dBclose();
       report[4]=""+this.getFinancialStatus();
       report[5]=""+finance;
       Report temperatureReport= new IsTemperatureImballanceReport (new IsTemperatureImballanceReport(new ErrorReporter(),report),report);  
        this.database.dBopen();
          database.insertTable(temperatureReport.getReport(), 3);
        this.database.dBclose();
     }
    @Override
    public void Dispense(double p) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void accept() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
             if(tmp[1].equals("EMPTY") || tmp[1].equals("FAULTY")){
             }
            else{
              if(Double.parseDouble(tmp[4])>0){
                double [] locationAndTemp= new double [2];
                double [] locationAndWeigth= new double [2];
                locationAndTemp[0]=(double)location;
                locationAndTemp[1]= Double.parseDouble(tmp[4]);
                locationAndWeigth[0]= location;
                locationAndWeigth[1]= 2500;
                this.activeTemperatureSensrs.add(ctr,locationAndTemp);
                this.activeWeightSensors.add(ctr,locationAndWeigth);
                ctr++;
              }
            }  
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
        
          
       
       String [] n1 ={"SLOT_CONFIG","PRODUCT_NAME",dbUpdate[2],dbUpdate[1]};
       String [] n2 ={"SLOT_CONFIG","QUANTITY",dbUpdate[3],dbUpdate[1]};
       String [] n3 ={"SLOT_CONFIG","TEMP_RANGE",dbUpdate[5],dbUpdate[1]};
       String [] n5 ={"SLOT_CONFIG","PRICE",dbUpdate[4],dbUpdate[1]};
       String [] n6 ={"SLOT_CONFIG","CURRENCY_ID",dbUpdate[7],dbUpdate[1]};
       String [] n7 ={"SLOT_CONFIG","TEMP",dbUpdate[6],dbUpdate[1]};
       
       database.dBopen();
       database.updateTable(n1);
       database.dBclose();
       
       database.dBopen();
       database.updateTable(n2);
       database.dBclose();
       
       database.dBopen();
       database.updateTable(n3);
       database.dBclose();
       
       database.dBopen();
       database.updateTable(n5);
       database.dBclose();
       
       database.dBopen();
       database.updateTable(n6);
       database.dBclose();
       
        database.dBopen();
       database.updateTable(n7);
       database.dBclose();
       reorder();
    }
    
    
}
