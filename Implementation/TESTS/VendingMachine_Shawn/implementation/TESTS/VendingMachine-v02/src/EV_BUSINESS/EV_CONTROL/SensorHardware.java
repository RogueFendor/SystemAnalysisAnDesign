/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EV_BUSINESS.EV_CONTROL;

import java.util.ArrayList;

/**
 *
 * @author Anon
 */
public class SensorHardware {
    
    private ArrayList<Integer> activeWeightSensors; 
    private ArrayList<Integer> activeTemperatureSensrs;
    private int acceleratorAddress;
    private int paymentHardwareAddress;
        

    public SensorHardware(ArrayList<Integer> activeWeightSensors, ArrayList<Integer> activeTemperatureSensrs, int acceleratorAddress, int paymentHardwareAddress) {
        this.activeWeightSensors = activeWeightSensors;
        this.activeTemperatureSensrs = activeTemperatureSensrs;
        this.acceleratorAddress = 666;
        this.paymentHardwareAddress=0; /*Not sure here yet*/
    }
    public String getCurrentWeigt(){
    String tmp ="";
      int len = this.activeWeightSensors.size();
      for(int i=0;i<len;i++){
         tmp+="Slot_"+i+"_"+this.activeWeightSensors.get(i).toString()+",";
      }
      return tmp;
    }
    public String getcurrentTemperature(){
       String tmp="";
       int len = this.activeTemperatureSensrs.size();
       for(int i=0;i<len;i++){
         tmp+="Slot_"+i+"_"+this.activeTemperatureSensrs.get(i).toString()+",";
      }
      return tmp;
    }
    public String pushData1(){
        String content1      = this.getCurrentWeigt();
        String topic1        = "activeWeightSensors";
      return topic1+"_"+content1;
    }
      public String pushData2(){
         String content2     = this.getcurrentTemperature();
         String topic2      = "activeTempSensors";
      return topic2+"_"+content2;
    }
      public String pushData3(){
        String content3      = ""+this.acceleratorAddress;
        String topic3      = "AccelData";
      return topic3+"_"+content3;
    }
      public String pushData4(){
       String content4      =""+this.paymentHardwareAddress;
       String topic4      = "PaymetHardware";
         return topic4+"_"+content4;
    }
}
