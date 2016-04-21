/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EV_GUI_ADVOCATE;
import EV_GUI_ADVOCATE.EV_GUI_CLASSES.BusinessSetUp;
import EV_GUI_ADVOCATE.EV_GUI_CLASSES.ChangeLogin;
import EV_GUI_ADVOCATE.EV_GUI_CLASSES.ErrorDialog;
import EV_GUI_ADVOCATE.EV_GUI_CLASSES.ErrorReport;
import EV_GUI_ADVOCATE.EV_GUI_CLASSES.Login;
import EV_GUI_ADVOCATE.EV_GUI_CLASSES.MachineSetup;
import EV_GUI_ADVOCATE.EV_GUI_CLASSES.MainMenu;
import EV_GUI_ADVOCATE.EV_GUI_CLASSES.Simulator;
import javax.swing.*;

/**
 *
 * @author Anon
 */
public class GUIFactory {
    
    GUIFactory(){
    
    }
    public JFrame createGui(int id){ 
        JFrame generic = null;
        switch(id){
            case 1: generic = new MainMenu();
            break;
            case 2: generic = new Login();
            break;
            case 3: generic = new MachineSetup();
            break;
            case 4: generic = new ChangeLogin();
            break;
            case 5: generic = new BusinessSetUp();
            break;
            case 6: generic = new Simulator();
            break;
            case 7: generic = new ErrorDialog();
            break;
            case 8: generic = new ErrorReport();
        }
        
        return generic ;
    }
}
