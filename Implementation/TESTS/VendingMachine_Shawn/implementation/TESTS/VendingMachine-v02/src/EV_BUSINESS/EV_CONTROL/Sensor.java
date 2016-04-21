/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EV_BUSINESS.EV_CONTROL;

/**
 *
 * @author Anon
 */
public class Sensor extends Thread {
    private SensorHardware sensorHardware;
    Sensor(){
    
    }
    public void setSensors(SensorHardware sensHrdw){
        this.sensorHardware = sensHrdw;
        
    }
    public String getData(int i){
        String data="";
        switch(i){
            case 1:data = this.sensorHardware.pushData1();break;
            case 2:data = this.sensorHardware.pushData2();break;
            case 3:data = this.sensorHardware.pushData3();break;
            case 4:data = this.sensorHardware.pushData4();break;
        }
        return data;
    }
    
}
