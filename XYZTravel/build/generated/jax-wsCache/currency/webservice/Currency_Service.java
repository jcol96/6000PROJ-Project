
package webservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "currency", targetNamespace = "http://webservices/", wsdlLocation = "http://localhost:8080/XYZTravel/currency?WSDL")
public class Currency_Service
    extends Service
{

    private final static URL CURRENCY_WSDL_LOCATION;
    private final static WebServiceException CURRENCY_EXCEPTION;
    private final static QName CURRENCY_QNAME = new QName("http://webservices/", "currency");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/XYZTravel/currency?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CURRENCY_WSDL_LOCATION = url;
        CURRENCY_EXCEPTION = e;
    }

    public Currency_Service() {
        super(__getWsdlLocation(), CURRENCY_QNAME);
    }

    public Currency_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), CURRENCY_QNAME, features);
    }

    public Currency_Service(URL wsdlLocation) {
        super(wsdlLocation, CURRENCY_QNAME);
    }

    public Currency_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CURRENCY_QNAME, features);
    }

    public Currency_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Currency_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Currency
     */
    @WebEndpoint(name = "currencyPort")
    public Currency getCurrencyPort() {
        return super.getPort(new QName("http://webservices/", "currencyPort"), Currency.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Currency
     */
    @WebEndpoint(name = "currencyPort")
    public Currency getCurrencyPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservices/", "currencyPort"), Currency.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CURRENCY_EXCEPTION!= null) {
            throw CURRENCY_EXCEPTION;
        }
        return CURRENCY_WSDL_LOCATION;
    }

}