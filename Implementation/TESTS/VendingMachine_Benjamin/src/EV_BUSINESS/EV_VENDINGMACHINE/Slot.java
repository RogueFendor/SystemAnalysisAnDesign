/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EV_BUSINESS.EV_VENDINGMACHINE;

import EV_BUSINESS.EV_VENDINGMACHINE.Product;

/**
 *
 * @author Anon
 */
public class Slot {
    
    private Product product;
    private int location;
    private double overAllWeight;
    private double temperatureRange;
    private double productWeight;

    

    public boolean isIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }
    private boolean isUsed;
    
    public Slot(){
      this.setIsUsed(false);
    }
    
    public Slot(Product product,int loc,double tempRange){
        this.product = product;
        this.location = loc;
        this.temperatureRange= tempRange;
        this.setOverAllWeight();
    }
    public double getOverAllWeight() {
        return overAllWeight;
    }

    public void setOverAllWeight() {
        this.overAllWeight = 2500;
        this.setProductWeight();
        
    }
    public double getProductWeight() {
        return productWeight;
    }

    public void setProductWeight() {
        this.productWeight = this.overAllWeight / this.product.getQuantity();
    }
    public Product getProduct() { 
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public double getTemperatureRange() {
        return temperatureRange;
    }

    public void setTemperatureRange(double temperatureRange) {
        this.temperatureRange = temperatureRange;
    }
    @Override
    public String toString(){
    
        String n = "Slot_location: "+this.location+"\n"+
                   "Overall Weight: "+   this.overAllWeight+"\n"+
                   "Temperature Range: "+   this.temperatureRange+"\n"+
                   "Product Name: "+   this.product.getName()+"\n"+
                   "Product Price: "+   this.product.getPrice()+"\n"+
                   "Currency Type: "+   this.product.getCurrencyType()+"\n"+
                   "Product Quantity: "+   this.product.getQuantity()+"\n"+
                   "Product weight: "+   this.productWeight+"\n";      
      return n;
    }
    
    
}
