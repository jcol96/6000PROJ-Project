package webservices;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "currency")
public class currency {
    
    @WebMethod(operationName = "poundsToDollars")
    // Set as string to display a full informative output
    public String poundsToDollars(@WebParam(name = "pounds") double pounds) {
        double rate = 1.41;
        double ans = rate * pounds;
        return "£" + pounds + " will get you $" + ans + " with the exhange rate of " + rate;
    }
    @WebMethod(operationName = "dollarsToPounds")
    public String dollarsToPounds(@WebParam(name = "dollars") double dollars) {
        double rate = 0.71;
        double ans = rate * dollars;
        return "$" + dollars + " will get you £" + ans + " with the change rate of " + rate;
    }
    @WebMethod(operationName = "nairasToEuros")
    public String nairasToEuros(@WebParam(name = "nairas") double nairas) {
        double rate = 0.0023;
        double ans = rate * nairas;
        return "₦" + nairas + " will get you €" + ans + " with the change rate of " + rate;
    }
    @WebMethod(operationName = "eurosToNairas")
    public String eurosToNairas(@WebParam(name = "euros") double euros) {
        double rate = 442.83;
        double ans = rate * euros;
        return "€" + euros + " will get you ₦" + ans + " with the change rate of " + rate; 
    }
    @WebMethod(operationName = "rupeesToDollars")
    public String rupeesToDollars(@WebParam(name = "rupees") double rupees) {
        double rate = 0.015;
        double ans = rate * rupees;
        return "₹" + rupees + " will get you $" + ans + " with the change rate of " + rate;
    }
    @WebMethod(operationName = "dollarsToRupees")
    public String dollarsToRupees(@WebParam(name = "dollars") double dollars) {
        double rate = 66.05;
        double ans = rate * dollars;
        return "$" + dollars + " will get you ₹" + ans + " with the change rate of " + rate;
    }
    @WebMethod(operationName = "poundsToEuros")
    public String poundsToEuros(@WebParam(name = "pounds") double pounds) {
        double rate = 1.14;
        double ans = rate * pounds;
        return "£" + pounds + " will get you €" + ans + " with the change rate of " + rate;
    }
    @WebMethod(operationName = "poundsToNairas")
    public String poundsToNairas(@WebParam(name = "pounds") double pounds) {
        double rate = 506.70;
        double ans = rate * pounds;
        return "£" + pounds + " will get you ₦" + ans + " with the change rate of " + rate;
    }
    @WebMethod(operationName = "poundsToRupees")
    public String poundsToRupees(@WebParam(name = "pounds") double pounds) {
        double rate = 92.99;
        double ans = rate * pounds;
        return "£" + pounds + " will get you ₹" + ans + " with the change rate of " + rate;
    }
    @WebMethod(operationName = "eurosToPounds")
    public String eurosToPounds(@WebParam(name = "euros") double euros) {
        double rate = 0.87;
        double ans = rate * euros;
        return "€" + euros + " will get you £" + ans + " with the change rate of " + rate;
    }
    @WebMethod(operationName = "eurosToDollars")
    public String eurosToDollars(@WebParam(name = "euros") double euros) {
        double rate = 1.23;
        double ans = rate * euros;
        return "€" + euros + " will get you $" + ans + " with the change rate of " + rate;
    }
    @WebMethod(operationName = "eurosToRupees")
    public String eurosToRupees(@WebParam(name = "euros") double euros) {
        double rate = 81.23;
        double ans = rate * euros;
        return "€" + euros + " will get you ₹" + ans + " with the change rate of " + rate;
    }
    @WebMethod(operationName = "dollarsToEuros")
    public String dollarsToEuros(@WebParam(name = "dollars") double dollars) {
        double rate = 0.81;
        double ans = rate * dollars;
        return "$" + dollars + " will get you €" + ans + " with the change rate of " + rate;
    }
    @WebMethod(operationName = "dollarsToNairas")
    public String dollarsToNairas(@WebParam(name = "dollars") double dollars) {
        double rate = 360.00;
        double ans = rate * dollars;
        return "$" + dollars + " will get you ₦" + ans + " with the change rate of " + rate;
    }
    @WebMethod(operationName = "nairasToPounds")
    public String nairasToPounds(@WebParam(name = "nairas") double nairas) {
        double rate = 0.0020;
        double ans = rate * nairas;
        return "₦" + nairas + " will get you £" + ans + " with the change rate of " + rate;
    }
    @WebMethod(operationName = "nairasToDollars")
    public String nairasToDollars(@WebParam(name = "nairas") double nairas) {
        double rate = 0.0028;
        double ans = rate * nairas;
        return "₦" + nairas + " will get you $" + ans + " with the change rate of " + rate;
    }
    @WebMethod(operationName = "nairasToRupees")
    public String nairasToRupees(@WebParam(name = "nairas") double nairas) {
        double rate = 0.21;
        double ans = rate * nairas;
        return "₦" + nairas + " will get you ₹" + ans + " with the change rate of " + rate;
    }
    @WebMethod(operationName = "rupeesToPounds")
    public String rupeesToPounds(@WebParam(name = "rupees") double rupees) {
        double rate = 0.011;
        double ans = rate * rupees;
        return "₹" + rupees + " will get you £" + ans + " with the change rate of " + rate;
    }
    @WebMethod(operationName = "rupeesToEuros")
    public String rupeesToEuros(@WebParam(name = "rupees") double rupees) {
        double rate = 0.012;
        double ans = rate * rupees;
        return "₹" + rupees + " will get you €" + ans + " with the change rate of " + rate;
    }
    @WebMethod(operationName = "rupeesToNairas")
    public String rupeesToNairas(@WebParam(name = "rupees") double rupees) {
        double rate = 5.45;
        double ans = rate * rupees;
        return "₹" + rupees + " will get you ₦" + ans + " with the change rate of " + rate;
    }
}
