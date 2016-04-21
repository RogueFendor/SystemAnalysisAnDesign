/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EV_GUI_ADVOCATE;
import EV_GUI.MainMenu;
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
            case 2: ;break;
        }
        
        return generic ;
    }
}
