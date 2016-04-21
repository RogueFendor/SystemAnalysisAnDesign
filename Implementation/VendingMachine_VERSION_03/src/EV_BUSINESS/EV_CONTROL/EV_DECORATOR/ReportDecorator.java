/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EV_BUSINESS.EV_CONTROL.EV_DECORATOR;

/**
 *
 * @author Anon
 */
public class ReportDecorator extends Report {
    
    private Report rep;
    
    ReportDecorator(Report rep){
        this.rep = rep;
    }
    @Override
    public void createReport(String [] report) {
       this.rep.createReport(report);
    }

    @Override
    public String[] getReport() {
        return this.rep.getReport();
    }
}
