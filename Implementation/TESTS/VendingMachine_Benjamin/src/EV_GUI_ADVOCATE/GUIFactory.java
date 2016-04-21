/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EV_GUI_ADVOCATE;
import EV_GUI.BusinessSetUp;
import EV_GUI.ChangeLogin;
import EV_GUI.Login;
import EV_GUI.MachineSetup;
import EV_GUI.MainMenu;
import EV_GUI.Simulator;
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
        }
        
        return generic ;
    }
}
