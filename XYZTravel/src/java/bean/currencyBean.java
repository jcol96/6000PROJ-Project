package bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.xml.ws.WebServiceRef;
import webservice.Currency_Service;

/**
 *
 * @author cmpjcol1
 */
@Named(value = "currencyBean")
@SessionScoped
public class currencyBean implements Serializable {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/XYZTravel/currency.wsdl")
    private Currency_Service service;
    private String requestedService;
    private String parameterName;
    private double parameterValue;
    private String result;
    
    public currencyBean() {
    }
    
    public String getParameterName(){
        return parameterName;
    }
    public void setParameterName(String parameterName){
        this.parameterName = parameterName;
    }
    public double getParameterValue(){
        return parameterValue;
    }
    public void setParameterValue(double parameterValue){
        this.parameterValue = parameterValue;
    }
    
    public String getRequestedService() {
        return requestedService;
    }
    public void setRequestedService(String requestedService) {
        this.requestedService = requestedService;
    }
    public void goToInputPage(String service){
        if (service.equals("Currency")){
            this.requestedService = service;
            if(this.requestedService.equals("Currency")){
                FacesContext.getCurrentInstance()
                        .getApplication().getNavigationHandler()
                        .handleNavigation(FacesContext.getCurrentInstance(), null, "/currencyInput.xhtml");
            }
        }
    }
    public String getResult(){
        return result;
    }
    public void setResult(String result){
        this.result = result;
    }
    private String poundsToDollars(double pounds) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.Currency port = service.getCurrencyPort();
        return port.poundsToDollars(pounds);
    }
    
    public void callService(){
        if (requestedService.equals("Currency")){
            this.result = String.valueOf(this.poundsToDollars(this.parameterValue));
        }
        else {
            this.result = String.valueOf(this.poundsToDollars(this.parameterValue));
                }
        FacesContext.getCurrentInstance()
                .getApplication().getNavigationHandler()
                .handleNavigation(FacesContext.getCurrentInstance(), null, "/currencyOutput.xhtml");
    }

    private String dollarsToEuros(double dollars) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.Currency port = service.getCurrencyPort();
        return port.dollarsToEuros(dollars);
    }

    private String dollarsToNairas(double dollars) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.Currency port = service.getCurrencyPort();
        return port.dollarsToNairas(dollars);
    }

    private String dollarsToPounds(double dollars) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.Currency port = service.getCurrencyPort();
        return port.dollarsToPounds(dollars);
    }

    private String dollarsToRupees(double dollars) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.Currency port = service.getCurrencyPort();
        return port.dollarsToRupees(dollars);
    }

    private String eurosToDollars(double euros) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.Currency port = service.getCurrencyPort();
        return port.eurosToDollars(euros);
    }

    private String eurosToNairas(double euros) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.Currency port = service.getCurrencyPort();
        return port.eurosToNairas(euros);
    }

    private String eurosToPounds(double euros) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.Currency port = service.getCurrencyPort();
        return port.eurosToPounds(euros);
    }

    private String eurosToRupees(double euros) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.Currency port = service.getCurrencyPort();
        return port.eurosToRupees(euros);
    }

    private String nairasToDollars(double nairas) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.Currency port = service.getCurrencyPort();
        return port.nairasToDollars(nairas);
    }

    private String nairasToEuros(double nairas) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.Currency port = service.getCurrencyPort();
        return port.nairasToEuros(nairas);
    }

    private String nairasToPounds(double nairas) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.Currency port = service.getCurrencyPort();
        return port.nairasToPounds(nairas);
    }

    private String nairasToRupees(double nairas) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.Currency port = service.getCurrencyPort();
        return port.nairasToRupees(nairas);
    }

    private String poundsToEuros(double pounds) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.Currency port = service.getCurrencyPort();
        return port.poundsToEuros(pounds);
    }

    private String poundsToNairas(double pounds) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.Currency port = service.getCurrencyPort();
        return port.poundsToNairas(pounds);
    }

    private String poundsToRupees(double pounds) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.Currency port = service.getCurrencyPort();
        return port.poundsToRupees(pounds);
    }

    private String rupeesToDollars(double rupees) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.Currency port = service.getCurrencyPort();
        return port.rupeesToDollars(rupees);
    }

    private String rupeesToEuros(double rupees) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.Currency port = service.getCurrencyPort();
        return port.rupeesToEuros(rupees);
    }

    private String rupeesToNairas(double rupees) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.Currency port = service.getCurrencyPort();
        return port.rupeesToNairas(rupees);
    }

    private String rupeesToPounds(double rupees) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.Currency port = service.getCurrencyPort();
        return port.rupeesToPounds(rupees);
    }
}
