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
public interface Payment {
   public void Dispense(double p);
   public void refund();
   public void accept();
}
