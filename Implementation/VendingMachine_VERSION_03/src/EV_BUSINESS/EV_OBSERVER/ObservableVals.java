/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EV_BUSINESS.EV_OBSERVER;

import java.util.Observable;
/**
 *
 * @author Anon
 */
public class ObservableVals extends Observable {
    
    private boolean slotConfigListener = false;
    private boolean loginListeneer = false;
    private boolean changeLoginListener =false;
    private boolean firstSetUpListener=false;
    private boolean startBusinessSetupListener=false;
    private boolean startChangeLoginListener=false;
    private boolean startLoginListener=false;
    private boolean startFirstSetupListener=false;
    private boolean startMainMenuListener=false;
    private boolean startReportListener=false;
    private boolean simulationListenerMainMenu =false;
    private boolean getSlotConfig=false;
    private boolean imballance =false;
    private boolean re_set =false;
    private boolean insertMoney = false;

    public boolean isInsertMoney() {
        return insertMoney;
    }

    public void setInsertMoney(boolean insertMoney) {
        this.insertMoney = insertMoney;
         setChanged();
        notifyObservers();
    }
    private int id; 

    public boolean isReset() {
        return re_set;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReset(boolean reset) {
        this.re_set = reset;
         setChanged();
        notifyObservers();
    }
   
    
    public void reset(){
         this.slotConfigListener = false;
         this.loginListeneer = false;
         this.changeLoginListener =false;
         this.firstSetUpListener=false;
         this.startBusinessSetupListener=false;
         this.startChangeLoginListener=false;
         this.startLoginListener=false;
         this.startFirstSetupListener=false;
         this.startMainMenuListener=false;
         this.startReportListener=false;
         this.simulationListenerMainMenu =false;
         this.getSlotConfig =false;
         this.imballance =false;
         this.re_set = false;
    }

    public boolean isGetSlotConfig() {
        return getSlotConfig;
    }

    public void setGetSlotConfig(boolean getSlotConfig) {
        this.getSlotConfig = getSlotConfig;
           setChanged();
        notifyObservers();
    }
    public boolean isSimulationListenerMainMenu() {
        return simulationListenerMainMenu;
    }

    public void setSimulationListenerMainMenu(boolean simulationListenerMainMenu) {
        this.simulationListenerMainMenu = simulationListenerMainMenu;
          setChanged();
        notifyObservers();
    }
    public boolean isStartReportListener() {
        return startReportListener;
    }

    public void setStartReportListener(boolean startReportListener) {
        this.startReportListener = startReportListener;
         setChanged();
        notifyObservers();
    }

    public boolean isStartMainMenuListener() {
        return startMainMenuListener;
    }

    public void setStartMainMenuListener(boolean startMainMenuListener) {
        this.startMainMenuListener = startMainMenuListener;
         setChanged();
        notifyObservers();
    }

    public boolean isStartBusinessSetupListener() {
        return startBusinessSetupListener;
    }

    public void setStartBusinessSetupListener(boolean startBusinessSetupListener) {
        this.startBusinessSetupListener = startBusinessSetupListener;
         setChanged();
        notifyObservers();
    }

    public boolean isStartChangeLoginListener() {
        return startChangeLoginListener;
    }

    public void setStartChangeLoginListener(boolean startChangeLoginListener) {
        this.startChangeLoginListener = startChangeLoginListener;
         setChanged();
        notifyObservers();
    }

    public boolean isStartLoginListener() {
        return startLoginListener;
    }

    public void setStartLoginListener(boolean startLoginListener) {
        this.startLoginListener = startLoginListener;
         setChanged();
        notifyObservers();
    }

    public boolean isStartFirstSetupListener() {
        return startFirstSetupListener;
    }

    public void setStartFirstSetupListener(boolean startFirstSetupListener) {
        this.startFirstSetupListener = startFirstSetupListener;
         setChanged();
        notifyObservers();
    }

    public boolean isImballance() {
        return imballance;
    }

    public void setImballance(boolean imballance, int i) {
        this.imballance = imballance;
        this.id = i;
         setChanged();
        notifyObservers();
    }
    

    public boolean isSlotConfigListener() {
        return slotConfigListener;
    }

    public void setSlotConfigListener(boolean slotConfigListener) {
        this.slotConfigListener = slotConfigListener;
         setChanged();
        notifyObservers();
        
    }

    public boolean isChangeLoginListener() {
        return changeLoginListener;
    }

    public void setChangeLoginListener(boolean changeLoginListener) {
        this.changeLoginListener = changeLoginListener;
         setChanged();
        notifyObservers();
    }

    public boolean isLoginListeneer() {
        return loginListeneer;
    }

    public void setLoginListeneer(boolean loginListeneer) {
        this.loginListeneer = loginListeneer;
         setChanged();
        notifyObservers();
    }

    public boolean isFirstSetUpListener() {
        return firstSetUpListener;
    }

    public void setFirstSetUpListener(boolean firstSetUpListener) {
        this.firstSetUpListener = firstSetUpListener;
         setChanged();
        notifyObservers();
    }
    public ObservableVals(){
           
    }
    public boolean isBusinessSetUpObserver() {
        return slotConfigListener;
    }

    public void setBusinessSetUpObserver(boolean sysObserver) {
        this.slotConfigListener = slotConfigListener;
        setChanged();
        notifyObservers();
    }
}
