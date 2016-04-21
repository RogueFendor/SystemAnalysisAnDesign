/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EV_BUSINESS.EV_CONTROL;

import EV_BUSINESS.EV_CONTROL.EV_DECORATOR.ErrorLog;
import EV_BUSINESS.EV_CONTROL.EV_DECORATOR.IsErrorLog;
import EV_BUSINESS.EV_CONTROL.EV_DECORATOR.Report;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Anon
 */
public class SensorHardware {
    
    private ArrayList<double[]> activeWeightSensors; 
    private ArrayList<double[]> activeTemperatureSensrs;
    private int acceleratorAddress;
    private int paymentHardwareAddress;
   
        

    public SensorHardware(ArrayList<double[]> activeWeightSensors, ArrayList<double []> activeTemperatureSensrs, int acceleratorAddress, int paymentHardwareAddress) {
        this.activeWeightSensors = activeWeightSensors;
        this.activeTemperatureSensrs = activeTemperatureSensrs;
        this.acceleratorAddress = 333;
        this.paymentHardwareAddress=666; /*Not sure here yet*/
    }
    public String getCurrentWeigt(){
    String tmp ="";
    double [] sensorWeigthData = new double[2];
      int len = this.activeWeightSensors.size();
      for(int i=0;i<len;i++){
         sensorWeigthData = this.activeWeightSensors.get(i);
         tmp+=""+sensorWeigthData[0]+" "+sensorWeigthData[1]+",";
      }
      return tmp;
    }
    public String getcurrentTemperature(){
       String tmp="";
       double [] sensorTempData = new double[2];
       int len = this.activeTemperatureSensrs.size();
       for(int i=0;i<len;i++){
         sensorTempData = this.activeTemperatureSensrs.get(i);
         tmp+=""+sensorTempData[0]+" "+sensorTempData[1]+",";
      }
      return tmp;
    }
    public String pushData1(){
        String content1      = this.getCurrentWeigt();
        String topic1        = "activeWeightSensors";
        simulateErrorInSystem();
      return topic1+" "+content1;
    }
      public String pushData2(){
         String content2     = this.getcurrentTemperature();
         String topic2      = "activeTempSensors";
         simulateErrorInSystem();
      return topic2+" "+content2;
    }
      public String pushData3(){
        String content3      = ""+this.acceleratorAddress;
        String topic3      = "AccelData";
        simulateErrorInSystem();
      return topic3+" "+content3;
    }
      public String pushData4(){
       String content4      =""+this.paymentHardwareAddress;
       String topic4      = "PaymetHardware";
       simulateErrorInSystem(); 
       return topic4+" "+content4;
    }
    public void simulateErrorInSystem(){
      // System.out.println("Reporting the error");
       DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
       Date dateobj = new Date();
       String date = df.format(dateobj);
       String [] report = new String [2];
       report[0]=date;
       report[1]="Simulated Error [ **  KERNEL PANIC and what have you not ** ]\nException in thread \"CS4125\" SystemAnalysisAndDesign.Mc.Cabes Cyclomatic behaviour.Branch-OverflowError";
       Report errorLog = new IsErrorLog(new IsErrorLog(new ErrorLog(),report),report);
     // errorLog.createReport(report);
    }
}
