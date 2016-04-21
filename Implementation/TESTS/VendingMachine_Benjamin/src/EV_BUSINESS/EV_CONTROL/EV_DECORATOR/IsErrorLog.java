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
public class IsErrorLog extends ReportDecorator {
    
    private String [] report;
    public IsErrorLog(Report rep,String [] report) {
        super(rep);
        this.setReport(report);
    }
    
    public String[] getReport() {
        return report;
    }

    public void setReport(String[] report) {
        this.report = report;
    }
    public void createReport(){
       
    }
    
    
}
