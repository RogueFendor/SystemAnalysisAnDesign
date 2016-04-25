/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EV_BUSINESS.EV_VENDINGMACHINE;

import EV_BUSINESS.EV_CONTROL.EVSystem;
import java.util.ArrayList;

public class VendingMachine extends EVSystem {
   
    private Slot[] slots = new  Slot[20];
    
    public VendingMachine(){
        super();
        Slot tmp;
        int len = this.slots.length;
        for(int i=0;i<len;i++){
          tmp = new Slot();
        slots[i]= tmp;
        }
        reorder();
        
    }
    public void startInterface(){
    
    }
    public void testConfigs(int i){
    database.dBopen();
       ArrayList<String> test =new ArrayList<String>();
        switch(i){
           case 1:
         
              test= database.getUsers();
           break;
           case 2:
              test= database.getMachineConfig();
           break;
           case 3:
              test= database.getIncidents();
           break;    
       }
        for( int j=0;j < test.size(); j++){
            System.out.println(test.get(j)+"\n");
        }
        database.dBclose();
    }
    public void setSlot(int slotID,double tempRange,String name,double price,int quantity,int currType){
        Product product = new Product(name,price,quantity,currType);
        slotID = slotID-1;
        slots[slotID].setIsUsed(true);
        slots[slotID].setProduct(product);
        slots[slotID].setTemperatureRange(tempRange);
        System.out.println(slots[slotID].isIsUsed());
        System.out.println(slots[slotID].getTemperatureRange());
        System.out.println(slots[slotID].getProduct().getName());
        System.out.println(slots[slotID].getProduct().getPrice());
        System.out.println(slots[slotID].getProduct().getQuantity());
        System.out.println(slots[slotID].getProduct().getCurrencyType());
        reorder();
    }
    public String[] getProducts(){
      String productName=""; 
      int len = slots.length;
      for(int i=0;i<len;i++){
          System.out.println("Test here: ");
          if(slots[i].isIsUsed()==true ){
            productName+=slots[i].getProduct().getName()+",";
          }
        }
      if(productName.isEmpty()){
       String tm2[] = {"No Products"};
       return tm2;
      }
      else{
        String []productNames=productName.split(",");
        return productNames;
      }
    }
    public void setUp(){
      
         // maybe some MQTT here well see
          database.dBopen();
          database.createDataBase();
          database.dBclose();     
          database.dBopen();
          int len = slots.length;
          String tmp2="";
          for(int i= 0; i<len;i++){
              tmp2=""+(i+1)+",EMPTY,0,0.0,0,0,0";
              String tm2 [] = tmp2.split(",");
             database.insertTable(tm2, 1);
          }
        database.dBclose();
        start();
        reorder();
    }
    public Slot getSlot(int i){
      return slots[i];
    }
    @Override
    public void reorder() {
        ArrayList<String>slotData =new ArrayList<String>();
        database.dBopen();
        slotData= database.getMachineConfig();
        database.dBclose();
        Product product =null;
        int location = 0;
        int len = slotData.size();
        for (int i=0;i<len;i++){
         String[] tmp = slotData.get(i).split(",");
            location = Integer.parseInt(tmp[0]); 
             if(tmp[1].equals("EMPTY")){
               slots[location-1].setIsUsed(false);
             }
            else{
              product = new Product(tmp[1],Double.parseDouble(tmp[3]),Integer.parseInt(tmp[2]),Integer.parseInt(tmp[6]));
              slots[location-1].setIsUsed(true);
              slots[location-1].setProduct(product);
              slots[location-1].setLocation(location);
              slots[location-1].setTemperatureRange(Double.parseDouble(tmp[4]));
            }
        }    
    }
    @Override
    public void errorMessage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public boolean validateLogin(String username, String password) {
        String tmp="";
        database.dBopen();
        tmp = database.getPassword(username, password);
        if(tmp.equals(password)){
            database.dBclose();
            return true;
        }
        else{
             database.dBclose();
            return false;
        }
    }
    @Override
    public void setLoginDetails(int tableID, String[]n) {
        database.dBopen();
        int id = database.getID("TECHNICIAN")+1;
        String tmp =""+id;
        n[0]=tmp;
        database.dBclose();
        database.dBopen();
        database.insertTable(n, tableID);
        database.dBclose();
    }

    @Override
    public void listenConnect() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getConfig() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setConfig(int tableID,String[] dbUpdate) {
       
         database.dBopen();
         database.insertTable(dbUpdate, tableID);
         database.dBclose();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendData(String [] data) {
       
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