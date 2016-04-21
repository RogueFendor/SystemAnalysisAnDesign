/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EV_BUSINESS.EV_OBSERVER;

import EV_BUSINESS.EV_CONTROL.EVSystem;
import EV_BUSINESS.EV_CONTROL.SystemAdvocate;
import EV_GUI_ADVOCATE.EsyVendingGUI;
import java.util.Observable;
import java.util.Observer;
import EV_BUSINESS.EV_VENDINGMACHINE.VendingMachine;

/**
 *
 * @author Anon
 */
public class EVOserver implements Observer{
   private ObservableVals ov;
   private EsyVendingGUI gui;
   private VendingMachine vm;
   
   public EVOserver(ObservableVals ov, EsyVendingGUI gui,VendingMachine vm )
   {
      this.ov = ov;
      this.gui = gui;
      this.vm = vm;
   }
    @Override
    public void update(Observable o, Object arg) {
        if (o == ov)
      { /*
           Need to implement the update method here 
           we have multiple values in the observableVals object
            + so we need to listen for a change in these values
            + find out which variable has changed
            + Act accordingly
          */
         // that the loginListener observer when user enters save we can access
          // the new data fields
          if(ov.isLoginListeneer()==true){
            if(vm.validateLogin(gui.login.getUsername(),gui.login.getPassword()) == true){
                System.out.println("evaluated to true");
               gui.MainMenu();
            
            }
            
            else{
               System.out.println(" evaluated to false?");
               gui.errorMessage("Invalid user or password");
            }
            ov.reset();
         }
         if(ov.isChangeLoginListener()==true){
            String arg1 = gui.changeLogin.getUsername();
            String arg2 = gui.changeLogin.getPassword();
            String arg3 = gui.changeLogin.getEmail();
            String arg4 = gui.changeLogin.getPhone();
            String tmp="";
            String [] n = {tmp,arg1,arg2,arg3,arg4};
            gui.changeLogin.dispose();
            vm.setLoginDetails(2,n);
            vm.testConfigs(1);
            ov.reset();
         }
         if(ov.isFirstSetUpListener()==true){
           vm.sendData(gui.machineSetup.getAll());
           vm.setUp();
           ov.reset();
         }
         if(ov.isSlotConfigListener()==true){
           int arg1 = gui.businessSetUp.getSlotID();
           double arg2 = gui.businessSetUp.getTempRange();
           String arg3 = gui.businessSetUp.getProductName();
           double arg4 = gui.businessSetUp.getPrice();
           int arg5 = gui.businessSetUp.getQuant();
           int arg6 = gui.businessSetUp.getCurrencyType();
          
           vm.setSlot(arg1,arg2,arg3,arg4,arg5,arg6);
          
           vm.updateConfig(gui.businessSetUp.getALL());
           vm.updateConfig(gui.businessSetUp.getALL());
           vm.testConfigs(2);
           ov.reset();
         }
         if(ov.isStartBusinessSetupListener()==true){
            gui.businessSetup();
            gui.businessSetUp.setAvailableProductNames(vm.getProducts());
            ov.reset();
         }
         if(ov.isStartChangeLoginListener()==true){
            gui.loginSetup();
            ov.reset();
         }
         if(ov.isStartFirstSetupListener()==true){
            gui.setUp();
            ov.reset();
         }
         if(ov.isStartLoginListener()==true){
            gui.login();
            ov.reset();
         }
         if(ov.isStartMainMenuListener()==true){
            gui.MainMenu();
            ov.reset();
         }
         if(ov.isStartReportListener()==true){
              SystemAdvocate sa = ( SystemAdvocate)gui.systemAdvocate;
             gui.incidents(sa.getIncidents());
         } 
         if(ov.isSimulationListenerMainMenu()==true){
             System.out.println("In Observer");
            gui.login();
            ov.reset();
         }
         if(ov.isGetSlotConfig()==true){
            if(vm.getSlot(gui.simulator.index).isIsUsed()==false){
             gui.simulator.setTextAreas("Slot "+gui.simulator.index+" is Empty:");
             gui.simulator.setTextFields("Empty", "Empty");
             ov.reset();
            }
            else{
                gui.simulator.setTextAreas(vm.getSlot(gui.simulator.index).toString());
                String[] tmp = vm.getSlot(gui.simulator.index).toString().split("\n");
                
                String []n1 = tmp[3].split(" ");
                String []n2 = tmp[4].split(" ");
                
                gui.simulator.setTextFields(n1[2],n2[2]+"0");
                ov.reset();
            }
         }
         if(ov.isImballance() ==true){
           SystemAdvocate sa = (SystemAdvocate) gui.systemAdvocate;
           sa.imballance(ov.getId());

         }
         if(ov.isReset()==true){
            SystemAdvocate sa = (SystemAdvocate) gui.systemAdvocate;
              sa.resetValueToOrigin(ov.getId());
         }
      }    
    }
}
