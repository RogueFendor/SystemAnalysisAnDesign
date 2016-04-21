/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EV_GUI_ADVOCATE;

import EV_GUI_ADVOCATE.GUIFactory;
import EV_GUI.MainMenu;
import EV_GUI.MachineSetup;
import EV_GUI.Login;
import EV_GUI.ErrorReport;
import EV_GUI.ErrorDialog;
import EV_GUI.ChangeLogin;
import EV_GUI.BusinessSetUp;
import java.util.ArrayList;
import EV_BUSINESS.EV_OBSERVER.EVOserver;
import EV_BUSINESS.EV_CONTROL.EVSystem;
import EV_BUSINESS.EV_OBSERVER.ObservableVals;
import EV_GUI.Simulator;
import EV_BUSINESS.EV_CONTROL.SystemAdvocate;
import EV_BUSINESS.EV_VENDINGMACHINE.VendingMachine;

/**
 *
 * @author Anon
 */


public class EsyVendingGUI{

    /**
     * @param args the command line arguments
     */
    private ObservableVals ov = null;
    private EVOserver to = null;
    
    public MainMenu mainMenu;
    public ErrorDialog dialog;
    public Login login;
    public MachineSetup machineSetup;
    public ChangeLogin changeLogin;
    public BusinessSetUp businessSetUp;
    public ErrorReport incidents;
    public Simulator simulator;
    public GUIFactory factory = new GUIFactory();
    
    public EVSystem vm;
    public EVSystem systemAdvocate;
    
    
    public EsyVendingGUI(){
     setUpTheListeners();
    }
    
    public void setUpTheListeners(){
        System.out.println("Test here1");
          this.ov = new ObservableVals();
        System.out.println("Test here1");
        
        vm = new VendingMachine();
         System.out.println("Test here1");
          this.to = new EVOserver(ov,this, (VendingMachine) vm);
         
         System.out.println("Test here1");
          ov.addObserver(to);
         System.out.println("Test here1");
         
         System.out.println("Setting System control");
         systemAdvocate = new SystemAdvocate();
         this.to.setUpSystemControl((SystemAdvocate)systemAdvocate);
         ov.setStartSampling(true);
    }
    public void MainMenu(){
        /* Create and display the form */
        mainMenu= (MainMenu)factory.createGui(1);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               mainMenu.setVisible(true);
            }
        });
    }
    public void errorMessage(String errorMessage){
       
        /* Create and display the form */
        
        dialog = new ErrorDialog();
        dialog.setMessage(errorMessage);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dialog.setVisible(true);
            }
        });
    
    }
    public void login(){
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
         login = new Login(ov);
        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              login.setVisible(true);
            }
        });
        
    } 
    public void setUp(){
       /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MachineSetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MachineSetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MachineSetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MachineSetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
     machineSetup= new MachineSetup(ov);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               machineSetup.setVisible(true);
            }
        });
    }
    public void loginSetup(){
         /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChangeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
         changeLogin = new ChangeLogin(ov);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               changeLogin.setVisible(true);
            }
        });
    }
    public void businessSetup(){
        
       /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BusinessSetUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BusinessSetUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BusinessSetUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BusinessSetUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        // this hopefully wil be our ear to the events in class

            /**
             *
             */
         businessSetUp  = new BusinessSetUp(ov);
        System.out.println(businessSetUp.getCurrencyType());
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               businessSetUp.setVisible(true);
            }
        });
    
    }
    public void incidents(ArrayList<String> n){
        incidents  = new ErrorReport();
        incidents.setTable(n);
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               incidents.setVisible(true);
            }
        });
    
    }
    public void runSimulator(){
        
       simulator = new Simulator(ov);
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              simulator.setVisible(true);
            }
        });
    }
}
