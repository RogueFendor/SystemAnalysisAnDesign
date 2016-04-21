/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EV_BUSINESS.EV_CONTROL.EV_DECORATOR;

/**
 *  sql = "INSERT INTO INCIDENT (ID,INCIDENT_DATE,TYPE,RESPONSE,FINANCIAL_STATE_PRE,FINANCIAL_STATE_POST) " +
          "VALUES ("+n[0]+",'"+n[1]+"',"+"'"+n[2]+"'"+","+"'"+n[3]+"'"+","+n[4]+","+n[5]+");";
 * @author Anon
 */
public class IsWeigthImballanceReport extends ReportDecorator {
    
   
    private String [] report;

    public IsWeigthImballanceReport(Report rep,String [] report) {
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
        super.createReport(report);
    }
}
