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
public class ErrorReporter extends Report{

    public ErrorReporter(String [] report){
     this.report = report;
    }
    
    public ErrorReporter(){
    }
    
    
    public void setReport(String[] report) {
        this.report = report;
    }

    private String [] report;
    @Override
    public void createReport(String [] report) {
        this.setReport(report);
    }

    @Override
    public String[] getReport() {
        return this.report;
    }
    
}
