package bean;

import entity.Bus;
import entity.Train;
import entity.Flight;
import entity.Users;
import entity.Booking;
import entity.Vehicles;
import java.io.IOException;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.*;

/**
 *
 * @author Josh
 */
@Named(value = "xyzBean")
@SessionScoped
public class xyzBean implements Serializable {

    @PersistenceContext(unitName = "XYZTravelPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    /**
     * Creates a new instance of xyzBean
     */
    public xyzBean() {
    }

    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    
    public List<Vehicles>getVehiclesList(){
        return em.createNamedQuery("Vehicles.findAll").getResultList();
    }
    public List<Vehicles>getVehiclesIdList(){
        return em.createNamedQuery("Vehicles.findByVehicleId").getResultList();
    }
    public List<Vehicles>getVehiclesBelfastList(){
        return em.createNamedQuery("Vehicles.findByBelfastLocation").getResultList();
    }
    public List<Vehicles>getVehiclesCardiffList(){
        return em.createNamedQuery("Vehicles.findByCardiffLocation").getResultList();
    }
    public List<Vehicles>getVehiclesEdinburghList(){
        return em.createNamedQuery("Vehicles.findByEdinburghLocation").getResultList();
    }
    public List<Vehicles>getVehiclesIsleofManList(){
        return em.createNamedQuery("Vehicles.findByIsleofManLocation").getResultList();
    }
    public List<Vehicles>getVehiclesLondonList(){
        return em.createNamedQuery("Vehicles.findByLondonLocation").getResultList();
    }
    public List<Vehicles>getVehiclesManchesterList(){
        return em.createNamedQuery("Vehicles.findByManchesterLocation").getResultList();
    }
    public List<Bus>getBusList(){
        return em.createNamedQuery("Bus.findAll").getResultList();
    }
    public List<Train>getTrainList(){
        return em.createNamedQuery("Train.findAll").getResultList();
    }
    public List<Flight>getFlightList(){
        return em.createNamedQuery("Flight.findAll").getResultList();
    }
     // update the database 
    public void updateEntity(Object object) {
        try {
            utx.begin();
            em.merge(object);
            utx.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private Integer inFlight = null;
    private Integer inTrain = null;
    private Integer inBus = null;
    private Integer inVehicle = null;
    private String inEmail = null;
    
    public Integer getInFlight(){
        return inFlight;
    }
    public void setInFlight(Integer inFlight){
        this.inFlight = inFlight;
    }
    public Integer getInTrain(){
        return inTrain;
    }
    public void setInTrain(Integer inTrain){
        this.inTrain = inTrain;
    }
    public Integer getInBus(){
        return inBus;
    }
    public void setInBus(Integer inBus){
        this.inBus = inBus;
    }
    public Integer getInVehicle(){
        return inVehicle;
    }
    public void setInVehicle(Integer inVehicle){
        this.inVehicle = inVehicle;
    }
    public String getInEmail(){
        return inEmail;
    }
    public void setInEmail(String inEmail){
        this.inEmail = inEmail;
    }
    public String completeBooking(){
         // if there is information entered in the booking form then excecute the next if statement
        if((this.inFlight!=null || this.inTrain!=null || this.inBus !=null || this.inVehicle!=null) && (this.inEmail!=null)){
            // if the vehicle number is correct
            if ((this.inVehicle >= 1101) && (this.inVehicle <= 1163) && (this.inFlight==null) && (this.inTrain==null) && (this.inBus==null)){
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String url="jdbc:mysql://mysql.cms.livjm.ac.uk:3306/cmpjcol1";
                    String username="cmpjcol1";
                    String password="password";
                    Connection con=DriverManager.getConnection(url, username, password);
                    Statement stm=con.createStatement();
                    
                    ResultSet rset=stm.executeQuery("SELECT vehicle_id FROM vehicles WHERE vehicle_id = " + inVehicle );
                    while (rset.next()) {
                        return "confirmbooking?faces-redirect=true";
                    }
                    rset.close();
                    con.close();
                }
                catch(Exception e) {
                    e.printStackTrace();
                    return "error?faces-redirect=true";
                }
            }
            // if the user only books flights  
            else if ((this.inTrain==null) && (this.inBus==null) && (this.inVehicle==null) && 
                    ((this.inFlight >= 5201001) && (this.inFlight <= 5101058)) || ((this.inFlight >= 5201001) && (this.inFlight <= 5201074)) || 
                    ((this.inFlight >= 5301001) && (this.inFlight <= 5301077)) || ((this.inFlight >= 5401001) && (this.inFlight <= 5401058)) || 
                    ((this.inFlight >= 5501001) && (this.inFlight <= 5501058))){
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String url="jdbc:mysql://mysql.cms.livjm.ac.uk:3306/cmpjcol1";
                    String username="cmpjcol1";
                    String password="password";
                    Connection con=DriverManager.getConnection(url, username, password);
                    Statement stm=con.createStatement();
                    
                    ResultSet rset=stm.executeQuery("SELECT flight_id FROM flight WHERE flight_id = " + inFlight );
                    while (rset.next()) {
                        return "confirmbooking?faces-redirect=true";
                    }
                    rset.close();
                    con.close();
                }
                catch(Exception e) {
                    e.printStackTrace();
                    return "error?faces-redirect=true";
                }
            }
            // if the user only books buses  
            else if (((this.inTrain==null) && (this.inFlight==null) && (this.inVehicle==null)) && 
                    ((this.inBus >= 10101) && (this.inBus <= 10213)) || ((this.inBus >= 10301) && (this.inBus <= 10413)) || 
                    ((this.inBus >= 10501) && (this.inBus <= 10613)) || ((this.inBus >= 10701) && (this.inBus <= 10813)) || 
                    ((this.inBus >= 10901) && (this.inBus <= 11013)) || ((this.inBus >= 11301) && (this.inBus <= 11413)) || 
                    ((this.inBus >= 11501) && (this.inBus <= 11613)) || ((this.inBus >= 11701) && (this.inBus <= 11813)) || 
                    ((this.inBus >= 11901) && (this.inBus <= 12013)) || ((this.inBus >= 12101) && (this.inBus <= 12250)) ||
                    ((this.inBus >= 12301) && (this.inBus <= 12450)) || ((this.inBus >= 12501) && (this.inBus <= 12638)) || 
                    ((this.inBus >= 12701) && (this.inBus <= 12838)) || ((this.inBus >= 12901) && (this.inBus <= 13038)) || 
                    ((this.inBus >= 13101) && (this.inBus <= 13238))){
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String url="jdbc:mysql://mysql.cms.livjm.ac.uk:3306/cmpjcol1";
                    String username="cmpjcol1";
                    String password="password";
                    Connection con=DriverManager.getConnection(url, username, password);
                    Statement stm=con.createStatement();
                    
                    ResultSet rset=stm.executeQuery("SELECT flight_id FROM flight WHERE flight_id = " + inFlight );
                    while (rset.next()) {
                        return "confirmbooking?faces-redirect=true";
                    }
                    rset.close();
                    con.close();
                }
                catch(Exception e) {
                    e.printStackTrace();
                    return "error?faces-redirect=true";
                }
            }
            // if the user only books a train  
            else if ((this.inBus==null) && (this.inFlight==null) && (this.inVehicle==null) && 
                    // liverpool
                    ((this.inTrain >= 2000001) && (this.inTrain <= 2000108)) || ((this.inTrain >= 2001001) && (this.inTrain <= 2001036)) || 
                    ((this.inTrain >= 2002001) && (this.inTrain <= 2002024)) || ((this.inTrain >= 2003001) && (this.inTrain <= 2003024)) || 
                    ((this.inTrain >= 2004001) && (this.inTrain <= 2004054)) || ((this.inTrain >= 2005001) && (this.inTrain <= 2005108)) || 
                    ((this.inTrain >= 2006001) && (this.inTrain <= 2006024)) || ((this.inTrain >= 2007001) && (this.inTrain <= 2007054)) || 
                    ((this.inTrain >= 2008001) && (this.inTrain <= 2008024)) || 
                    // manchester
                    ((this.inTrain >= 2100001) && (this.inTrain <= 2100108)) ||
                    ((this.inTrain >= 2101001) && (this.inTrain <= 2101036)) || ((this.inTrain >= 2102001) && (this.inTrain <= 2102024)) || 
                    ((this.inTrain >= 2103001) && (this.inTrain <= 2103024)) || ((this.inTrain >= 2104001) && (this.inTrain <= 2104054)) || 
                    ((this.inTrain >= 2105001) && (this.inTrain <= 2105108)) || ((this.inTrain >= 2106001) && (this.inTrain <= 2106036)) ||
                    ((this.inTrain >= 2107001) && (this.inTrain <= 2107054)) || ((this.inTrain >= 2108001) && (this.inTrain <= 2108024)) ||
                    // london
                    ((this.inTrain >= 2200001) && (this.inTrain <= 2200036)) ||
                    ((this.inTrain >= 2201001) && (this.inTrain <= 2201036)) || ((this.inTrain >= 2202001) && (this.inTrain <= 2202018)) || 
                    ((this.inTrain >= 2203001) && (this.inTrain <= 2203018)) || ((this.inTrain >= 2204001) && (this.inTrain <= 2204054)) || 
                    ((this.inTrain >= 2205001) && (this.inTrain <= 2205054)) || ((this.inTrain >= 2206001) && (this.inTrain <= 2206024)) ||
                    ((this.inTrain >= 2207001) && (this.inTrain <= 2207054)) || ((this.inTrain >= 2208001) && (this.inTrain <= 2208054)) ||
                    // glasgow
                    ((this.inTrain >= 2300001) && (this.inTrain <= 2300024)) ||
                    ((this.inTrain >= 2301001) && (this.inTrain <= 2301024)) || ((this.inTrain >= 2302001) && (this.inTrain <= 2302018)) || 
                    ((this.inTrain >= 2303001) && (this.inTrain <= 2303108)) || ((this.inTrain >= 2304001) && (this.inTrain <= 2304024)) || 
                    ((this.inTrain >= 2305001) && (this.inTrain <= 2305024)) || ((this.inTrain >= 2306001) && (this.inTrain <= 2306036)) ||
                    ((this.inTrain >= 2307001) && (this.inTrain <= 2307018)) || ((this.inTrain >= 2308001) && (this.inTrain <= 2308012)) ||
                    // edinburgh
                    ((this.inTrain >= 2400001) && (this.inTrain <= 2400024)) ||
                    ((this.inTrain >= 2401001) && (this.inTrain <= 2401024)) || ((this.inTrain >= 2402001) && (this.inTrain <= 2402018)) || 
                    ((this.inTrain >= 2403001) && (this.inTrain <= 2403108)) || ((this.inTrain >= 2404001) && (this.inTrain <= 2404036)) || 
                    ((this.inTrain >= 2405001) && (this.inTrain <= 2405024)) || ((this.inTrain >= 2406001) && (this.inTrain <= 2406054)) ||
                    ((this.inTrain >= 2407001) && (this.inTrain <= 2407018)) || ((this.inTrain >= 2408001) && (this.inTrain <= 2408012)) ||
                    // york
                    ((this.inTrain >= 2500001) && (this.inTrain <= 2500054)) ||
                    ((this.inTrain >= 2501001) && (this.inTrain <= 2501054)) || ((this.inTrain >= 2502001) && (this.inTrain <= 2502054)) || 
                    ((this.inTrain >= 2503001) && (this.inTrain <= 2503024)) || ((this.inTrain >= 2504001) && (this.inTrain <= 2504036)) || 
                    ((this.inTrain >= 2505001) && (this.inTrain <= 2505036)) || ((this.inTrain >= 2506001) && (this.inTrain <= 2506054)) ||
                    ((this.inTrain >= 2507001) && (this.inTrain <= 2507054)) || ((this.inTrain >= 2508001) && (this.inTrain <= 2508018)) ||
                    // chester
                    ((this.inTrain >= 2600001) && (this.inTrain <= 2600108)) ||
                    ((this.inTrain >= 2601001) && (this.inTrain <= 2601108)) || ((this.inTrain >= 2602001) && (this.inTrain <= 2602054)) || 
                    ((this.inTrain >= 2603001) && (this.inTrain <= 2603024)) || ((this.inTrain >= 2604001) && (this.inTrain <= 2604024)) || 
                    ((this.inTrain >= 2605001) && (this.inTrain <= 2605036)) || ((this.inTrain >= 2606001) && (this.inTrain <= 2606024)) ||
                    ((this.inTrain >= 2607001) && (this.inTrain <= 2607054)) || ((this.inTrain >= 2608001) && (this.inTrain <= 2608036)) ||
                    // newcastle
                    ((this.inTrain >= 2700001) && (this.inTrain <= 2700024)) ||
                    ((this.inTrain >= 2701001) && (this.inTrain <= 2701036)) || ((this.inTrain >= 2702001) && (this.inTrain <= 2702024)) || 
                    ((this.inTrain >= 2703001) && (this.inTrain <= 2703036)) || ((this.inTrain >= 2704001) && (this.inTrain <= 2704054)) || 
                    ((this.inTrain >= 2705001) && (this.inTrain <= 2705054)) || ((this.inTrain >= 2706001) && (this.inTrain <= 2706024)) ||
                    ((this.inTrain >= 2707001) && (this.inTrain <= 2707024)) || ((this.inTrain >= 2708001) && (this.inTrain <= 2708018)) ||
                    // birmingham
                    ((this.inTrain >= 2800001) && (this.inTrain <= 2800054)) ||
                    ((this.inTrain >= 2801001) && (this.inTrain <= 2801054)) || ((this.inTrain >= 2802001) && (this.inTrain <= 2802054)) || 
                    ((this.inTrain >= 2803001) && (this.inTrain <= 2803018)) || ((this.inTrain >= 2804001) && (this.inTrain <= 2804018)) || 
                    ((this.inTrain >= 2805001) && (this.inTrain <= 2805054)) || ((this.inTrain >= 2806001) && (this.inTrain <= 2806054)) ||
                    ((this.inTrain >= 2807001) && (this.inTrain <= 2807024)) || ((this.inTrain >= 2808001) && (this.inTrain <= 2808054)) ||
                    // cardiff
                    ((this.inTrain >= 2900001) && (this.inTrain <= 2900024)) ||
                    ((this.inTrain >= 2901001) && (this.inTrain <= 2901024)) || ((this.inTrain >= 2902001) && (this.inTrain <= 2902054)) || 
                    ((this.inTrain >= 2903001) && (this.inTrain <= 2903012)) || ((this.inTrain >= 2904001) && (this.inTrain <= 2904012)) || 
                    ((this.inTrain >= 2905001) && (this.inTrain <= 2905018)) || ((this.inTrain >= 2906001) && (this.inTrain <= 2906036)) ||
                    ((this.inTrain >= 2907001) && (this.inTrain <= 2907018)) || ((this.inTrain >= 2908001) && (this.inTrain <= 2908054))){
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String url="jdbc:mysql://mysql.cms.livjm.ac.uk:3306/cmpjcol1";
                    String username="cmpjcol1";
                    String password="password";
                    Connection con=DriverManager.getConnection(url, username, password);
                    Statement stm=con.createStatement();
                    
                    ResultSet rset=stm.executeQuery("SELECT train_id FROM train WHERE train_id = " + inTrain );
                    while (rset.next()) {
                        return "confirmbooking?faces-redirect=true";
                    }
                    rset.close();
                    con.close();
                }
                catch(Exception e) {
                    e.printStackTrace();
                    return "error?faces-redirect=true";
                }
            }
            // if the user books vehicle hire and a flight
            else if ((this.inVehicle >= 1101) && (this.inVehicle <= 1163) && (this.inTrain==null) && (this.inBus==null) && 
                    ((this.inFlight >= 5201001) && (this.inFlight <= 5101058)) || ((this.inFlight >= 5201001) && (this.inFlight <= 5201074)) || 
                    ((this.inFlight >= 5301001) && (this.inFlight <= 5301077)) || ((this.inFlight >= 5401001) && (this.inFlight <= 5401058)) || 
                    ((this.inFlight >= 5501001) && (this.inFlight <= 5501058))){
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String url="jdbc:mysql://mysql.cms.livjm.ac.uk:3306/cmpjcol1";
                    String username="cmpjcol1";
                    String password="password";
                    Connection con=DriverManager.getConnection(url, username, password);
                    Statement stm=con.createStatement();
                    
                    ResultSet rset=stm.executeQuery("SELECT vehicles.vehicle_id, flight.flight_id FROM vehicles INNER JOIN flight ON vehicles.vehicle_id = " + inVehicle + " AND flight.flight_id = " + inFlight);
                    while (rset.next()) {
                        return "confirmbooking?faces-redirect=true";
                    }
                    rset.close();
                    con.close();
                }
                catch(Exception e) {
                    e.printStackTrace();
                    return "error?faces-redirect=true";
                }
            }
            // if the user books a bus and vehicle hire
            else if ((this.inTrain==null) && (this.inFlight==null) && ((this.inVehicle >= 1101) && (this.inVehicle <= 1163)) && 
                    ((this.inBus >= 10101) && (this.inBus <= 10213)) || ((this.inBus >= 10301) && (this.inBus <= 10413)) || 
                    ((this.inBus >= 10501) && (this.inBus <= 10613)) || ((this.inBus >= 10701) && (this.inBus <= 10813)) || 
                    ((this.inBus >= 10901) && (this.inBus <= 11013)) || ((this.inBus >= 11301) && (this.inBus <= 11413)) || 
                    ((this.inBus >= 11501) && (this.inBus <= 11613)) || ((this.inBus >= 11701) && (this.inBus <= 11813)) || 
                    ((this.inBus >= 11901) && (this.inBus <= 12013)) || ((this.inBus >= 12101) && (this.inBus <= 12250)) ||
                    ((this.inBus >= 12301) && (this.inBus <= 12450)) || ((this.inBus >= 12501) && (this.inBus <= 12638)) || 
                    ((this.inBus >= 12701) && (this.inBus <= 12838)) || ((this.inBus >= 12901) && (this.inBus <= 13038)) || 
                    ((this.inBus >= 13101) && (this.inBus <= 13238))){
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String url="jdbc:mysql://mysql.cms.livjm.ac.uk:3306/cmpjcol1";
                    String username="cmpjcol1";
                    String password="password";
                    Connection con=DriverManager.getConnection(url, username, password);
                    Statement stm=con.createStatement();
                    
                    ResultSet rset=stm.executeQuery("SELECT vehicles.vehicle_id, bus.bus_id FROM vehicles INNER JOIN bus ON vehicles.vehicle_id = " + inVehicle + " AND bus.bus_id = " + inBus);
                    while (rset.next()) {
                        return "confirmbooking?faces-redirect=true";
                    }
                    rset.close();
                    con.close();
                }
                catch(Exception e) {
                    e.printStackTrace();
                    return "error?faces-redirect=true";
                }
            }
            // if the user books a train and vehicle hire
            else if ((this.inBus==null) && (this.inFlight==null) && (this.inVehicle >= 1101) && (this.inVehicle <= 1163) && 
                    // liverpool
                    ((this.inTrain >= 2000001) && (this.inTrain <= 2000108)) || ((this.inTrain >= 2001001) && (this.inTrain <= 2001036)) || 
                    ((this.inTrain >= 2002001) && (this.inTrain <= 2002024)) || ((this.inTrain >= 2003001) && (this.inTrain <= 2003024)) || 
                    ((this.inTrain >= 2004001) && (this.inTrain <= 2004054)) || ((this.inTrain >= 2005001) && (this.inTrain <= 2005108)) || 
                    ((this.inTrain >= 2006001) && (this.inTrain <= 2006024)) || ((this.inTrain >= 2007001) && (this.inTrain <= 2007054)) || 
                    ((this.inTrain >= 2008001) && (this.inTrain <= 2008024)) || 
                    // manchester
                    ((this.inTrain >= 2100001) && (this.inTrain <= 2100108)) ||
                    ((this.inTrain >= 2101001) && (this.inTrain <= 2101036)) || ((this.inTrain >= 2102001) && (this.inTrain <= 2102024)) || 
                    ((this.inTrain >= 2103001) && (this.inTrain <= 2103024)) || ((this.inTrain >= 2104001) && (this.inTrain <= 2104054)) || 
                    ((this.inTrain >= 2105001) && (this.inTrain <= 2105108)) || ((this.inTrain >= 2106001) && (this.inTrain <= 2106036)) ||
                    ((this.inTrain >= 2107001) && (this.inTrain <= 2107054)) || ((this.inTrain >= 2108001) && (this.inTrain <= 2108024)) ||
                    // london
                    ((this.inTrain >= 2200001) && (this.inTrain <= 2200036)) ||
                    ((this.inTrain >= 2201001) && (this.inTrain <= 2201036)) || ((this.inTrain >= 2202001) && (this.inTrain <= 2202018)) || 
                    ((this.inTrain >= 2203001) && (this.inTrain <= 2203018)) || ((this.inTrain >= 2204001) && (this.inTrain <= 2204054)) || 
                    ((this.inTrain >= 2205001) && (this.inTrain <= 2205054)) || ((this.inTrain >= 2206001) && (this.inTrain <= 2206024)) ||
                    ((this.inTrain >= 2207001) && (this.inTrain <= 2207054)) || ((this.inTrain >= 2208001) && (this.inTrain <= 2208054)) ||
                    // glasgow
                    ((this.inTrain >= 2300001) && (this.inTrain <= 2300024)) ||
                    ((this.inTrain >= 2301001) && (this.inTrain <= 2301024)) || ((this.inTrain >= 2302001) && (this.inTrain <= 2302018)) || 
                    ((this.inTrain >= 2303001) && (this.inTrain <= 2303108)) || ((this.inTrain >= 2304001) && (this.inTrain <= 2304024)) || 
                    ((this.inTrain >= 2305001) && (this.inTrain <= 2305024)) || ((this.inTrain >= 2306001) && (this.inTrain <= 2306036)) ||
                    ((this.inTrain >= 2307001) && (this.inTrain <= 2307018)) || ((this.inTrain >= 2308001) && (this.inTrain <= 2308012)) ||
                    // edinburgh
                    ((this.inTrain >= 2400001) && (this.inTrain <= 2400024)) ||
                    ((this.inTrain >= 2401001) && (this.inTrain <= 2401024)) || ((this.inTrain >= 2402001) && (this.inTrain <= 2402018)) || 
                    ((this.inTrain >= 2403001) && (this.inTrain <= 2403108)) || ((this.inTrain >= 2404001) && (this.inTrain <= 2404036)) || 
                    ((this.inTrain >= 2405001) && (this.inTrain <= 2405024)) || ((this.inTrain >= 2406001) && (this.inTrain <= 2406054)) ||
                    ((this.inTrain >= 2407001) && (this.inTrain <= 2407018)) || ((this.inTrain >= 2408001) && (this.inTrain <= 2408012)) ||
                    // york
                    ((this.inTrain >= 2500001) && (this.inTrain <= 2500054)) ||
                    ((this.inTrain >= 2501001) && (this.inTrain <= 2501054)) || ((this.inTrain >= 2502001) && (this.inTrain <= 2502054)) || 
                    ((this.inTrain >= 2503001) && (this.inTrain <= 2503024)) || ((this.inTrain >= 2504001) && (this.inTrain <= 2504036)) || 
                    ((this.inTrain >= 2505001) && (this.inTrain <= 2505036)) || ((this.inTrain >= 2506001) && (this.inTrain <= 2506054)) ||
                    ((this.inTrain >= 2507001) && (this.inTrain <= 2507054)) || ((this.inTrain >= 2508001) && (this.inTrain <= 2508018)) ||
                    // chester
                    ((this.inTrain >= 2600001) && (this.inTrain <= 2600108)) ||
                    ((this.inTrain >= 2601001) && (this.inTrain <= 2601108)) || ((this.inTrain >= 2602001) && (this.inTrain <= 2602054)) || 
                    ((this.inTrain >= 2603001) && (this.inTrain <= 2603024)) || ((this.inTrain >= 2604001) && (this.inTrain <= 2604024)) || 
                    ((this.inTrain >= 2605001) && (this.inTrain <= 2605036)) || ((this.inTrain >= 2606001) && (this.inTrain <= 2606024)) ||
                    ((this.inTrain >= 2607001) && (this.inTrain <= 2607054)) || ((this.inTrain >= 2608001) && (this.inTrain <= 2608036)) ||
                    // newcastle
                    ((this.inTrain >= 2700001) && (this.inTrain <= 2700024)) ||
                    ((this.inTrain >= 2701001) && (this.inTrain <= 2701036)) || ((this.inTrain >= 2702001) && (this.inTrain <= 2702024)) || 
                    ((this.inTrain >= 2703001) && (this.inTrain <= 2703036)) || ((this.inTrain >= 2704001) && (this.inTrain <= 2704054)) || 
                    ((this.inTrain >= 2705001) && (this.inTrain <= 2705054)) || ((this.inTrain >= 2706001) && (this.inTrain <= 2706024)) ||
                    ((this.inTrain >= 2707001) && (this.inTrain <= 2707024)) || ((this.inTrain >= 2708001) && (this.inTrain <= 2708018)) ||
                    // birmingham
                    ((this.inTrain >= 2800001) && (this.inTrain <= 2800054)) ||
                    ((this.inTrain >= 2801001) && (this.inTrain <= 2801054)) || ((this.inTrain >= 2802001) && (this.inTrain <= 2802054)) || 
                    ((this.inTrain >= 2803001) && (this.inTrain <= 2803018)) || ((this.inTrain >= 2804001) && (this.inTrain <= 2804018)) || 
                    ((this.inTrain >= 2805001) && (this.inTrain <= 2805054)) || ((this.inTrain >= 2806001) && (this.inTrain <= 2806054)) ||
                    ((this.inTrain >= 2807001) && (this.inTrain <= 2807024)) || ((this.inTrain >= 2808001) && (this.inTrain <= 2808054)) ||
                    // cardiff
                    ((this.inTrain >= 2900001) && (this.inTrain <= 2900024)) ||
                    ((this.inTrain >= 2901001) && (this.inTrain <= 2901024)) || ((this.inTrain >= 2902001) && (this.inTrain <= 2902054)) || 
                    ((this.inTrain >= 2903001) && (this.inTrain <= 2903012)) || ((this.inTrain >= 2904001) && (this.inTrain <= 2904012)) || 
                    ((this.inTrain >= 2905001) && (this.inTrain <= 2905018)) || ((this.inTrain >= 2906001) && (this.inTrain <= 2906036)) ||
                    ((this.inTrain >= 2907001) && (this.inTrain <= 2907018)) || ((this.inTrain >= 2908001) && (this.inTrain <= 2908054))){
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String url="jdbc:mysql://mysql.cms.livjm.ac.uk:3306/cmpjcol1";
                    String username="cmpjcol1";
                    String password="password";
                    Connection con=DriverManager.getConnection(url, username, password);
                    Statement stm=con.createStatement();
                    
                    ResultSet rset=stm.executeQuery("SELECT vehicle.vehicle_id, train.train_id FROM vehicle INNER JOIN train ON vehicle.vehicle_id = " + inVehicle + " AND train.train_id = " + inTrain);
                    while (rset.next()) {
                        return "confirmbooking?faces-redirect=true";
                    }
                    rset.close();
                    con.close();
                }
                catch(Exception e) {
                    e.printStackTrace();
                    return "error?faces-redirect=true";
                }
            }
            // if the user books a train and flight 
            else if ((this.inBus==null) && (this.inVehicle==null) && 
                    ((this.inFlight >= 5201001) && (this.inFlight <= 5101058)) || ((this.inFlight >= 5201001) && (this.inFlight <= 5201074)) || 
                    ((this.inFlight >= 5301001) && (this.inFlight <= 5301077)) || ((this.inFlight >= 5401001) && (this.inFlight <= 5401058)) || 
                    ((this.inFlight >= 5501001) && (this.inFlight <= 5501058)) && 
                    // liverpool
                    ((this.inTrain >= 2000001) && (this.inTrain <= 2000108)) || ((this.inTrain >= 2001001) && (this.inTrain <= 2001036)) || 
                    ((this.inTrain >= 2002001) && (this.inTrain <= 2002024)) || ((this.inTrain >= 2003001) && (this.inTrain <= 2003024)) || 
                    ((this.inTrain >= 2004001) && (this.inTrain <= 2004054)) || ((this.inTrain >= 2005001) && (this.inTrain <= 2005108)) || 
                    ((this.inTrain >= 2006001) && (this.inTrain <= 2006024)) || ((this.inTrain >= 2007001) && (this.inTrain <= 2007054)) || 
                    ((this.inTrain >= 2008001) && (this.inTrain <= 2008024)) || 
                    // manchester
                    ((this.inTrain >= 2100001) && (this.inTrain <= 2100108)) ||
                    ((this.inTrain >= 2101001) && (this.inTrain <= 2101036)) || ((this.inTrain >= 2102001) && (this.inTrain <= 2102024)) || 
                    ((this.inTrain >= 2103001) && (this.inTrain <= 2103024)) || ((this.inTrain >= 2104001) && (this.inTrain <= 2104054)) || 
                    ((this.inTrain >= 2105001) && (this.inTrain <= 2105108)) || ((this.inTrain >= 2106001) && (this.inTrain <= 2106036)) ||
                    ((this.inTrain >= 2107001) && (this.inTrain <= 2107054)) || ((this.inTrain >= 2108001) && (this.inTrain <= 2108024)) ||
                    // london
                    ((this.inTrain >= 2200001) && (this.inTrain <= 2200036)) ||
                    ((this.inTrain >= 2201001) && (this.inTrain <= 2201036)) || ((this.inTrain >= 2202001) && (this.inTrain <= 2202018)) || 
                    ((this.inTrain >= 2203001) && (this.inTrain <= 2203018)) || ((this.inTrain >= 2204001) && (this.inTrain <= 2204054)) || 
                    ((this.inTrain >= 2205001) && (this.inTrain <= 2205054)) || ((this.inTrain >= 2206001) && (this.inTrain <= 2206024)) ||
                    ((this.inTrain >= 2207001) && (this.inTrain <= 2207054)) || ((this.inTrain >= 2208001) && (this.inTrain <= 2208054)) ||
                    // glasgow
                    ((this.inTrain >= 2300001) && (this.inTrain <= 2300024)) ||
                    ((this.inTrain >= 2301001) && (this.inTrain <= 2301024)) || ((this.inTrain >= 2302001) && (this.inTrain <= 2302018)) || 
                    ((this.inTrain >= 2303001) && (this.inTrain <= 2303108)) || ((this.inTrain >= 2304001) && (this.inTrain <= 2304024)) || 
                    ((this.inTrain >= 2305001) && (this.inTrain <= 2305024)) || ((this.inTrain >= 2306001) && (this.inTrain <= 2306036)) ||
                    ((this.inTrain >= 2307001) && (this.inTrain <= 2307018)) || ((this.inTrain >= 2308001) && (this.inTrain <= 2308012)) ||
                    // edinburgh
                    ((this.inTrain >= 2400001) && (this.inTrain <= 2400024)) ||
                    ((this.inTrain >= 2401001) && (this.inTrain <= 2401024)) || ((this.inTrain >= 2402001) && (this.inTrain <= 2402018)) || 
                    ((this.inTrain >= 2403001) && (this.inTrain <= 2403108)) || ((this.inTrain >= 2404001) && (this.inTrain <= 2404036)) || 
                    ((this.inTrain >= 2405001) && (this.inTrain <= 2405024)) || ((this.inTrain >= 2406001) && (this.inTrain <= 2406054)) ||
                    ((this.inTrain >= 2407001) && (this.inTrain <= 2407018)) || ((this.inTrain >= 2408001) && (this.inTrain <= 2408012)) ||
                    // york
                    ((this.inTrain >= 2500001) && (this.inTrain <= 2500054)) ||
                    ((this.inTrain >= 2501001) && (this.inTrain <= 2501054)) || ((this.inTrain >= 2502001) && (this.inTrain <= 2502054)) || 
                    ((this.inTrain >= 2503001) && (this.inTrain <= 2503024)) || ((this.inTrain >= 2504001) && (this.inTrain <= 2504036)) || 
                    ((this.inTrain >= 2505001) && (this.inTrain <= 2505036)) || ((this.inTrain >= 2506001) && (this.inTrain <= 2506054)) ||
                    ((this.inTrain >= 2507001) && (this.inTrain <= 2507054)) || ((this.inTrain >= 2508001) && (this.inTrain <= 2508018)) ||
                    // chester
                    ((this.inTrain >= 2600001) && (this.inTrain <= 2600108)) ||
                    ((this.inTrain >= 2601001) && (this.inTrain <= 2601108)) || ((this.inTrain >= 2602001) && (this.inTrain <= 2602054)) || 
                    ((this.inTrain >= 2603001) && (this.inTrain <= 2603024)) || ((this.inTrain >= 2604001) && (this.inTrain <= 2604024)) || 
                    ((this.inTrain >= 2605001) && (this.inTrain <= 2605036)) || ((this.inTrain >= 2606001) && (this.inTrain <= 2606024)) ||
                    ((this.inTrain >= 2607001) && (this.inTrain <= 2607054)) || ((this.inTrain >= 2608001) && (this.inTrain <= 2608036)) ||
                    // newcastle
                    ((this.inTrain >= 2700001) && (this.inTrain <= 2700024)) ||
                    ((this.inTrain >= 2701001) && (this.inTrain <= 2701036)) || ((this.inTrain >= 2702001) && (this.inTrain <= 2702024)) || 
                    ((this.inTrain >= 2703001) && (this.inTrain <= 2703036)) || ((this.inTrain >= 2704001) && (this.inTrain <= 2704054)) || 
                    ((this.inTrain >= 2705001) && (this.inTrain <= 2705054)) || ((this.inTrain >= 2706001) && (this.inTrain <= 2706024)) ||
                    ((this.inTrain >= 2707001) && (this.inTrain <= 2707024)) || ((this.inTrain >= 2708001) && (this.inTrain <= 2708018)) ||
                    // birmingham
                    ((this.inTrain >= 2800001) && (this.inTrain <= 2800054)) ||
                    ((this.inTrain >= 2801001) && (this.inTrain <= 2801054)) || ((this.inTrain >= 2802001) && (this.inTrain <= 2802054)) || 
                    ((this.inTrain >= 2803001) && (this.inTrain <= 2803018)) || ((this.inTrain >= 2804001) && (this.inTrain <= 2804018)) || 
                    ((this.inTrain >= 2805001) && (this.inTrain <= 2805054)) || ((this.inTrain >= 2806001) && (this.inTrain <= 2806054)) ||
                    ((this.inTrain >= 2807001) && (this.inTrain <= 2807024)) || ((this.inTrain >= 2808001) && (this.inTrain <= 2808054)) ||
                    // cardiff
                    ((this.inTrain >= 2900001) && (this.inTrain <= 2900024)) ||
                    ((this.inTrain >= 2901001) && (this.inTrain <= 2901024)) || ((this.inTrain >= 2902001) && (this.inTrain <= 2902054)) || 
                    ((this.inTrain >= 2903001) && (this.inTrain <= 2903012)) || ((this.inTrain >= 2904001) && (this.inTrain <= 2904012)) || 
                    ((this.inTrain >= 2905001) && (this.inTrain <= 2905018)) || ((this.inTrain >= 2906001) && (this.inTrain <= 2906036)) ||
                    ((this.inTrain >= 2907001) && (this.inTrain <= 2907018)) || ((this.inTrain >= 2908001) && (this.inTrain <= 2908054))){
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String url="jdbc:mysql://mysql.cms.livjm.ac.uk:3306/cmpjcol1";
                    String username="cmpjcol1";
                    String password="password";
                    Connection con=DriverManager.getConnection(url, username, password);
                    Statement stm=con.createStatement();
                    
                    ResultSet rset=stm.executeQuery("SELECT train.train_id, flight.flight_id FROM train INNER JOIN flight ON train.train_id = " + inTrain + " AND flight.flight_id = " + inFlight);
                    while (rset.next()) {
                        return "confirmbooking?faces-redirect=true";
                    }
                    rset.close();
                    con.close();
                }
                catch(Exception e) {
                    e.printStackTrace();
                    return "error?faces-redirect=true";
                }
            }
            // if the user books flights and a bus
            else if ((this.inTrain==null) && (this.inVehicle==null) && 
                    ((this.inFlight >= 5201001) && (this.inFlight <= 5101058)) || ((this.inFlight >= 5201001) && (this.inFlight <= 5201074)) || 
                    ((this.inFlight >= 5301001) && (this.inFlight <= 5301077)) || ((this.inFlight >= 5401001) && (this.inFlight <= 5401058)) || 
                    ((this.inFlight >= 5501001) && (this.inFlight <= 5501058)) &&
                    ((this.inBus >= 10101) && (this.inBus <= 10213)) || ((this.inBus >= 10301) && (this.inBus <= 10413)) || 
                    ((this.inBus >= 10501) && (this.inBus <= 10613)) || ((this.inBus >= 10701) && (this.inBus <= 10813)) || 
                    ((this.inBus >= 10901) && (this.inBus <= 11013)) || ((this.inBus >= 11301) && (this.inBus <= 11413)) || 
                    ((this.inBus >= 11501) && (this.inBus <= 11613)) || ((this.inBus >= 11701) && (this.inBus <= 11813)) || 
                    ((this.inBus >= 11901) && (this.inBus <= 12013)) || ((this.inBus >= 12101) && (this.inBus <= 12250)) ||
                    ((this.inBus >= 12301) && (this.inBus <= 12450)) || ((this.inBus >= 12501) && (this.inBus <= 12638)) || 
                    ((this.inBus >= 12701) && (this.inBus <= 12838)) || ((this.inBus >= 12901) && (this.inBus <= 13038)) || 
                    ((this.inBus >= 13101) && (this.inBus <= 13238))){
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String url="jdbc:mysql://mysql.cms.livjm.ac.uk:3306/cmpjcol1";
                    String username="cmpjcol1";
                    String password="password";
                    Connection con=DriverManager.getConnection(url, username, password);
                    Statement stm=con.createStatement();
                    
                    ResultSet rset=stm.executeQuery("SELECT bus.bus_id, flight.flight_id FROM bus INNER JOIN flight ON bus.bus_id = " + inBus + " AND flight.flight_id = " + inFlight);
                    while (rset.next()) {
                        return "confirmbooking?faces-redirect=true";
                    }
                    rset.close();
                    con.close();
                }
                catch(Exception e) {
                    e.printStackTrace();
                    return "error?faces-redirect=true";
                }
            }
            // if the user books a train and bus
            else if ((this.inFlight==null) && (this.inVehicle==null) && 
                    ((this.inBus >= 10101) && (this.inBus <= 10213)) || ((this.inBus >= 10301) && (this.inBus <= 10413)) || 
                    ((this.inBus >= 10501) && (this.inBus <= 10613)) || ((this.inBus >= 10701) && (this.inBus <= 10813)) || 
                    ((this.inBus >= 10901) && (this.inBus <= 11013)) || ((this.inBus >= 11301) && (this.inBus <= 11413)) || 
                    ((this.inBus >= 11501) && (this.inBus <= 11613)) || ((this.inBus >= 11701) && (this.inBus <= 11813)) || 
                    ((this.inBus >= 11901) && (this.inBus <= 12013)) || ((this.inBus >= 12101) && (this.inBus <= 12250)) ||
                    ((this.inBus >= 12301) && (this.inBus <= 12450)) || ((this.inBus >= 12501) && (this.inBus <= 12638)) || 
                    ((this.inBus >= 12701) && (this.inBus <= 12838)) || ((this.inBus >= 12901) && (this.inBus <= 13038)) || 
                    ((this.inBus >= 13101) && (this.inBus <= 13238)) &&
                    // liverpool
                    ((this.inTrain >= 2000001) && (this.inTrain <= 2000108)) || ((this.inTrain >= 2001001) && (this.inTrain <= 2001036)) || 
                    ((this.inTrain >= 2002001) && (this.inTrain <= 2002024)) || ((this.inTrain >= 2003001) && (this.inTrain <= 2003024)) || 
                    ((this.inTrain >= 2004001) && (this.inTrain <= 2004054)) || ((this.inTrain >= 2005001) && (this.inTrain <= 2005108)) || 
                    ((this.inTrain >= 2006001) && (this.inTrain <= 2006024)) || ((this.inTrain >= 2007001) && (this.inTrain <= 2007054)) || 
                    ((this.inTrain >= 2008001) && (this.inTrain <= 2008024)) || 
                    // manchester
                    ((this.inTrain >= 2100001) && (this.inTrain <= 2100108)) ||
                    ((this.inTrain >= 2101001) && (this.inTrain <= 2101036)) || ((this.inTrain >= 2102001) && (this.inTrain <= 2102024)) || 
                    ((this.inTrain >= 2103001) && (this.inTrain <= 2103024)) || ((this.inTrain >= 2104001) && (this.inTrain <= 2104054)) || 
                    ((this.inTrain >= 2105001) && (this.inTrain <= 2105108)) || ((this.inTrain >= 2106001) && (this.inTrain <= 2106036)) ||
                    ((this.inTrain >= 2107001) && (this.inTrain <= 2107054)) || ((this.inTrain >= 2108001) && (this.inTrain <= 2108024)) ||
                    // london
                    ((this.inTrain >= 2200001) && (this.inTrain <= 2200036)) ||
                    ((this.inTrain >= 2201001) && (this.inTrain <= 2201036)) || ((this.inTrain >= 2202001) && (this.inTrain <= 2202018)) || 
                    ((this.inTrain >= 2203001) && (this.inTrain <= 2203018)) || ((this.inTrain >= 2204001) && (this.inTrain <= 2204054)) || 
                    ((this.inTrain >= 2205001) && (this.inTrain <= 2205054)) || ((this.inTrain >= 2206001) && (this.inTrain <= 2206024)) ||
                    ((this.inTrain >= 2207001) && (this.inTrain <= 2207054)) || ((this.inTrain >= 2208001) && (this.inTrain <= 2208054)) ||
                    // glasgow
                    ((this.inTrain >= 2300001) && (this.inTrain <= 2300024)) ||
                    ((this.inTrain >= 2301001) && (this.inTrain <= 2301024)) || ((this.inTrain >= 2302001) && (this.inTrain <= 2302018)) || 
                    ((this.inTrain >= 2303001) && (this.inTrain <= 2303108)) || ((this.inTrain >= 2304001) && (this.inTrain <= 2304024)) || 
                    ((this.inTrain >= 2305001) && (this.inTrain <= 2305024)) || ((this.inTrain >= 2306001) && (this.inTrain <= 2306036)) ||
                    ((this.inTrain >= 2307001) && (this.inTrain <= 2307018)) || ((this.inTrain >= 2308001) && (this.inTrain <= 2308012)) ||
                    // edinburgh
                    ((this.inTrain >= 2400001) && (this.inTrain <= 2400024)) ||
                    ((this.inTrain >= 2401001) && (this.inTrain <= 2401024)) || ((this.inTrain >= 2402001) && (this.inTrain <= 2402018)) || 
                    ((this.inTrain >= 2403001) && (this.inTrain <= 2403108)) || ((this.inTrain >= 2404001) && (this.inTrain <= 2404036)) || 
                    ((this.inTrain >= 2405001) && (this.inTrain <= 2405024)) || ((this.inTrain >= 2406001) && (this.inTrain <= 2406054)) ||
                    ((this.inTrain >= 2407001) && (this.inTrain <= 2407018)) || ((this.inTrain >= 2408001) && (this.inTrain <= 2408012)) ||
                    // york
                    ((this.inTrain >= 2500001) && (this.inTrain <= 2500054)) ||
                    ((this.inTrain >= 2501001) && (this.inTrain <= 2501054)) || ((this.inTrain >= 2502001) && (this.inTrain <= 2502054)) || 
                    ((this.inTrain >= 2503001) && (this.inTrain <= 2503024)) || ((this.inTrain >= 2504001) && (this.inTrain <= 2504036)) || 
                    ((this.inTrain >= 2505001) && (this.inTrain <= 2505036)) || ((this.inTrain >= 2506001) && (this.inTrain <= 2506054)) ||
                    ((this.inTrain >= 2507001) && (this.inTrain <= 2507054)) || ((this.inTrain >= 2508001) && (this.inTrain <= 2508018)) ||
                    // chester
                    ((this.inTrain >= 2600001) && (this.inTrain <= 2600108)) ||
                    ((this.inTrain >= 2601001) && (this.inTrain <= 2601108)) || ((this.inTrain >= 2602001) && (this.inTrain <= 2602054)) || 
                    ((this.inTrain >= 2603001) && (this.inTrain <= 2603024)) || ((this.inTrain >= 2604001) && (this.inTrain <= 2604024)) || 
                    ((this.inTrain >= 2605001) && (this.inTrain <= 2605036)) || ((this.inTrain >= 2606001) && (this.inTrain <= 2606024)) ||
                    ((this.inTrain >= 2607001) && (this.inTrain <= 2607054)) || ((this.inTrain >= 2608001) && (this.inTrain <= 2608036)) ||
                    // newcastle
                    ((this.inTrain >= 2700001) && (this.inTrain <= 2700024)) ||
                    ((this.inTrain >= 2701001) && (this.inTrain <= 2701036)) || ((this.inTrain >= 2702001) && (this.inTrain <= 2702024)) || 
                    ((this.inTrain >= 2703001) && (this.inTrain <= 2703036)) || ((this.inTrain >= 2704001) && (this.inTrain <= 2704054)) || 
                    ((this.inTrain >= 2705001) && (this.inTrain <= 2705054)) || ((this.inTrain >= 2706001) && (this.inTrain <= 2706024)) ||
                    ((this.inTrain >= 2707001) && (this.inTrain <= 2707024)) || ((this.inTrain >= 2708001) && (this.inTrain <= 2708018)) ||
                    // birmingham
                    ((this.inTrain >= 2800001) && (this.inTrain <= 2800054)) ||
                    ((this.inTrain >= 2801001) && (this.inTrain <= 2801054)) || ((this.inTrain >= 2802001) && (this.inTrain <= 2802054)) || 
                    ((this.inTrain >= 2803001) && (this.inTrain <= 2803018)) || ((this.inTrain >= 2804001) && (this.inTrain <= 2804018)) || 
                    ((this.inTrain >= 2805001) && (this.inTrain <= 2805054)) || ((this.inTrain >= 2806001) && (this.inTrain <= 2806054)) ||
                    ((this.inTrain >= 2807001) && (this.inTrain <= 2807024)) || ((this.inTrain >= 2808001) && (this.inTrain <= 2808054)) ||
                    // cardiff
                    ((this.inTrain >= 2900001) && (this.inTrain <= 2900024)) ||
                    ((this.inTrain >= 2901001) && (this.inTrain <= 2901024)) || ((this.inTrain >= 2902001) && (this.inTrain <= 2902054)) || 
                    ((this.inTrain >= 2903001) && (this.inTrain <= 2903012)) || ((this.inTrain >= 2904001) && (this.inTrain <= 2904012)) || 
                    ((this.inTrain >= 2905001) && (this.inTrain <= 2905018)) || ((this.inTrain >= 2906001) && (this.inTrain <= 2906036)) ||
                    ((this.inTrain >= 2907001) && (this.inTrain <= 2907018)) || ((this.inTrain >= 2908001) && (this.inTrain <= 2908054))){
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String url="jdbc:mysql://mysql.cms.livjm.ac.uk:3306/cmpjcol1";
                    String username="cmpjcol1";
                    String password="password";
                    Connection con=DriverManager.getConnection(url, username, password);
                    Statement stm=con.createStatement();
                   
                    ResultSet rset=stm.executeQuery("SELECT bus.bus_id, train.train_id FROM bus INNER JOIN train ON bus.bus_id = " + inBus + " AND train.train_id = " + inTrain);
                    while (rset.next()) {
                        return "confirmbooking?faces-redirect=true";
                    }
                    rset.close();
                    con.close();
                }
                catch(Exception e) {
                    e.printStackTrace();
                    return "error?faces-redirect=true";
                }
            }
            // if the user books flights , train and vehicle hire
            else if ((this.inTrain==null) && (this.inVehicle >= 1101) && (this.inVehicle <= 1163) && 
                    ((this.inFlight >= 5201001) && (this.inFlight <= 5101058)) || ((this.inFlight >= 5201001) && (this.inFlight <= 5201074)) || 
                    ((this.inFlight >= 5301001) && (this.inFlight <= 5301077)) || ((this.inFlight >= 5401001) && (this.inFlight <= 5401058)) || 
                    ((this.inFlight >= 5501001) && (this.inFlight <= 5501058)) &&
                    // liverpool
                    ((this.inTrain >= 2000001) && (this.inTrain <= 2000108)) || ((this.inTrain >= 2001001) && (this.inTrain <= 2001036)) || 
                    ((this.inTrain >= 2002001) && (this.inTrain <= 2002024)) || ((this.inTrain >= 2003001) && (this.inTrain <= 2003024)) || 
                    ((this.inTrain >= 2004001) && (this.inTrain <= 2004054)) || ((this.inTrain >= 2005001) && (this.inTrain <= 2005108)) || 
                    ((this.inTrain >= 2006001) && (this.inTrain <= 2006024)) || ((this.inTrain >= 2007001) && (this.inTrain <= 2007054)) || 
                    ((this.inTrain >= 2008001) && (this.inTrain <= 2008024)) || 
                    // manchester
                    ((this.inTrain >= 2100001) && (this.inTrain <= 2100108)) ||
                    ((this.inTrain >= 2101001) && (this.inTrain <= 2101036)) || ((this.inTrain >= 2102001) && (this.inTrain <= 2102024)) || 
                    ((this.inTrain >= 2103001) && (this.inTrain <= 2103024)) || ((this.inTrain >= 2104001) && (this.inTrain <= 2104054)) || 
                    ((this.inTrain >= 2105001) && (this.inTrain <= 2105108)) || ((this.inTrain >= 2106001) && (this.inTrain <= 2106036)) ||
                    ((this.inTrain >= 2107001) && (this.inTrain <= 2107054)) || ((this.inTrain >= 2108001) && (this.inTrain <= 2108024)) ||
                    // london
                    ((this.inTrain >= 2200001) && (this.inTrain <= 2200036)) ||
                    ((this.inTrain >= 2201001) && (this.inTrain <= 2201036)) || ((this.inTrain >= 2202001) && (this.inTrain <= 2202018)) || 
                    ((this.inTrain >= 2203001) && (this.inTrain <= 2203018)) || ((this.inTrain >= 2204001) && (this.inTrain <= 2204054)) || 
                    ((this.inTrain >= 2205001) && (this.inTrain <= 2205054)) || ((this.inTrain >= 2206001) && (this.inTrain <= 2206024)) ||
                    ((this.inTrain >= 2207001) && (this.inTrain <= 2207054)) || ((this.inTrain >= 2208001) && (this.inTrain <= 2208054)) ||
                    // glasgow
                    ((this.inTrain >= 2300001) && (this.inTrain <= 2300024)) ||
                    ((this.inTrain >= 2301001) && (this.inTrain <= 2301024)) || ((this.inTrain >= 2302001) && (this.inTrain <= 2302018)) || 
                    ((this.inTrain >= 2303001) && (this.inTrain <= 2303108)) || ((this.inTrain >= 2304001) && (this.inTrain <= 2304024)) || 
                    ((this.inTrain >= 2305001) && (this.inTrain <= 2305024)) || ((this.inTrain >= 2306001) && (this.inTrain <= 2306036)) ||
                    ((this.inTrain >= 2307001) && (this.inTrain <= 2307018)) || ((this.inTrain >= 2308001) && (this.inTrain <= 2308012)) ||
                    // edinburgh
                    ((this.inTrain >= 2400001) && (this.inTrain <= 2400024)) ||
                    ((this.inTrain >= 2401001) && (this.inTrain <= 2401024)) || ((this.inTrain >= 2402001) && (this.inTrain <= 2402018)) || 
                    ((this.inTrain >= 2403001) && (this.inTrain <= 2403108)) || ((this.inTrain >= 2404001) && (this.inTrain <= 2404036)) || 
                    ((this.inTrain >= 2405001) && (this.inTrain <= 2405024)) || ((this.inTrain >= 2406001) && (this.inTrain <= 2406054)) ||
                    ((this.inTrain >= 2407001) && (this.inTrain <= 2407018)) || ((this.inTrain >= 2408001) && (this.inTrain <= 2408012)) ||
                    // york
                    ((this.inTrain >= 2500001) && (this.inTrain <= 2500054)) ||
                    ((this.inTrain >= 2501001) && (this.inTrain <= 2501054)) || ((this.inTrain >= 2502001) && (this.inTrain <= 2502054)) || 
                    ((this.inTrain >= 2503001) && (this.inTrain <= 2503024)) || ((this.inTrain >= 2504001) && (this.inTrain <= 2504036)) || 
                    ((this.inTrain >= 2505001) && (this.inTrain <= 2505036)) || ((this.inTrain >= 2506001) && (this.inTrain <= 2506054)) ||
                    ((this.inTrain >= 2507001) && (this.inTrain <= 2507054)) || ((this.inTrain >= 2508001) && (this.inTrain <= 2508018)) ||
                    // chester
                    ((this.inTrain >= 2600001) && (this.inTrain <= 2600108)) ||
                    ((this.inTrain >= 2601001) && (this.inTrain <= 2601108)) || ((this.inTrain >= 2602001) && (this.inTrain <= 2602054)) || 
                    ((this.inTrain >= 2603001) && (this.inTrain <= 2603024)) || ((this.inTrain >= 2604001) && (this.inTrain <= 2604024)) || 
                    ((this.inTrain >= 2605001) && (this.inTrain <= 2605036)) || ((this.inTrain >= 2606001) && (this.inTrain <= 2606024)) ||
                    ((this.inTrain >= 2607001) && (this.inTrain <= 2607054)) || ((this.inTrain >= 2608001) && (this.inTrain <= 2608036)) ||
                    // newcastle
                    ((this.inTrain >= 2700001) && (this.inTrain <= 2700024)) ||
                    ((this.inTrain >= 2701001) && (this.inTrain <= 2701036)) || ((this.inTrain >= 2702001) && (this.inTrain <= 2702024)) || 
                    ((this.inTrain >= 2703001) && (this.inTrain <= 2703036)) || ((this.inTrain >= 2704001) && (this.inTrain <= 2704054)) || 
                    ((this.inTrain >= 2705001) && (this.inTrain <= 2705054)) || ((this.inTrain >= 2706001) && (this.inTrain <= 2706024)) ||
                    ((this.inTrain >= 2707001) && (this.inTrain <= 2707024)) || ((this.inTrain >= 2708001) && (this.inTrain <= 2708018)) ||
                    // birmingham
                    ((this.inTrain >= 2800001) && (this.inTrain <= 2800054)) ||
                    ((this.inTrain >= 2801001) && (this.inTrain <= 2801054)) || ((this.inTrain >= 2802001) && (this.inTrain <= 2802054)) || 
                    ((this.inTrain >= 2803001) && (this.inTrain <= 2803018)) || ((this.inTrain >= 2804001) && (this.inTrain <= 2804018)) || 
                    ((this.inTrain >= 2805001) && (this.inTrain <= 2805054)) || ((this.inTrain >= 2806001) && (this.inTrain <= 2806054)) ||
                    ((this.inTrain >= 2807001) && (this.inTrain <= 2807024)) || ((this.inTrain >= 2808001) && (this.inTrain <= 2808054)) ||
                    // cardiff
                    ((this.inTrain >= 2900001) && (this.inTrain <= 2900024)) ||
                    ((this.inTrain >= 2901001) && (this.inTrain <= 2901024)) || ((this.inTrain >= 2902001) && (this.inTrain <= 2902054)) || 
                    ((this.inTrain >= 2903001) && (this.inTrain <= 2903012)) || ((this.inTrain >= 2904001) && (this.inTrain <= 2904012)) || 
                    ((this.inTrain >= 2905001) && (this.inTrain <= 2905018)) || ((this.inTrain >= 2906001) && (this.inTrain <= 2906036)) ||
                    ((this.inTrain >= 2907001) && (this.inTrain <= 2907018)) || ((this.inTrain >= 2908001) && (this.inTrain <= 2908054))){
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String url="jdbc:mysql://mysql.cms.livjm.ac.uk:3306/cmpjcol1";
                    String username="cmpjcol1";
                    String password="password";
                    Connection con=DriverManager.getConnection(url, username, password);
                    Statement stm=con.createStatement();
                    
                    ResultSet rset=stm.executeQuery("SELECT vehicles.vehicle_id, flight.flight_id, train.train_id FROM vehicles "
                            + " INNER JOIN flight ON vehicles.vehicle_id = " + inVehicle + " AND flight.flight_id = " + inFlight + " INNER JOIN train ON train.train_id = " + inTrain);
                    while (rset.next()) {
                        return "confirmbooking?faces-redirect=true";
                    }
                    rset.close();
                    con.close();
                }
                catch(Exception e) {
                    e.printStackTrace();
                    return "error?faces-redirect=true";
                }
            }
            // if the user books flights , bus and vehicle hire
            else if ((this.inBus==null) && (this.inVehicle >= 1101) && (this.inVehicle <= 1163) && 
                    ((this.inFlight >= 5201001) && (this.inFlight <= 5101058)) || ((this.inFlight >= 5201001) && (this.inFlight <= 5201074)) || 
                    ((this.inFlight >= 5301001) && (this.inFlight <= 5301077)) || ((this.inFlight >= 5401001) && (this.inFlight <= 5401058)) || 
                    ((this.inFlight >= 5501001) && (this.inFlight <= 5501058)) &&
                    ((this.inBus >= 10101) && (this.inBus <= 10213)) || ((this.inBus >= 10301) && (this.inBus <= 10413)) || 
                    ((this.inBus >= 10501) && (this.inBus <= 10613)) || ((this.inBus >= 10701) && (this.inBus <= 10813)) || 
                    ((this.inBus >= 10901) && (this.inBus <= 11013)) || ((this.inBus >= 11301) && (this.inBus <= 11413)) || 
                    ((this.inBus >= 11501) && (this.inBus <= 11613)) || ((this.inBus >= 11701) && (this.inBus <= 11813)) || 
                    ((this.inBus >= 11901) && (this.inBus <= 12013)) || ((this.inBus >= 12101) && (this.inBus <= 12250)) ||
                    ((this.inBus >= 12301) && (this.inBus <= 12450)) || ((this.inBus >= 12501) && (this.inBus <= 12638)) || 
                    ((this.inBus >= 12701) && (this.inBus <= 12838)) || ((this.inBus >= 12901) && (this.inBus <= 13038)) || 
                    ((this.inBus >= 13101) && (this.inBus <= 13238))){
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String url="jdbc:mysql://mysql.cms.livjm.ac.uk:3306/cmpjcol1";
                    String username="cmpjcol1";
                    String password="password";
                    Connection con=DriverManager.getConnection(url, username, password);
                    Statement stm=con.createStatement();
                    
                    ResultSet rset=stm.executeQuery("SELECT vehicles.vehicle_id, flight.flight_id, bus.bus_id FROM vehicles "
                            + " INNER JOIN flight ON vehicles.vehicle_id = " + inVehicle + " AND flight.flight_id = " + inFlight + " INNER JOIN bus ON bus.bus_id = " + inBus);
                    while (rset.next()) {
                        return "confirmbooking?faces-redirect=true";
                    }
                    rset.close();
                    con.close();
                }
                catch(Exception e) {
                    e.printStackTrace();
                    return "error?faces-redirect=true";
                }
            }
            // if the user books flights , train and bus
            else if ((this.inVehicle==null) && 
                    (((this.inFlight >= 5201001) && (this.inFlight <= 5101058)) || ((this.inFlight >= 5201001) && (this.inFlight <= 5201074)) || 
                    ((this.inFlight >= 5301001) && (this.inFlight <= 5301077)) || ((this.inFlight >= 5401001) && (this.inFlight <= 5401058)) || 
                    ((this.inFlight >= 5501001) && (this.inFlight <= 5501058)) &&
                    ((this.inBus >= 10101) && (this.inBus <= 10213)) || ((this.inBus >= 10301) && (this.inBus <= 10413)) || 
                    ((this.inBus >= 10501) && (this.inBus <= 10613)) || ((this.inBus >= 10701) && (this.inBus <= 10813)) || 
                    ((this.inBus >= 10901) && (this.inBus <= 11013)) || ((this.inBus >= 11301) && (this.inBus <= 11413)) || 
                    ((this.inBus >= 11501) && (this.inBus <= 11613)) || ((this.inBus >= 11701) && (this.inBus <= 11813)) || 
                    ((this.inBus >= 11901) && (this.inBus <= 12013)) || ((this.inBus >= 12101) && (this.inBus <= 12250)) ||
                    ((this.inBus >= 12301) && (this.inBus <= 12450)) || ((this.inBus >= 12501) && (this.inBus <= 12638)) || 
                    ((this.inBus >= 12701) && (this.inBus <= 12838)) || ((this.inBus >= 12901) && (this.inBus <= 13038)) || 
                    ((this.inBus >= 13101) && (this.inBus <= 13238))) &&
                    // liverpool
                    ((this.inTrain >= 2000001) && (this.inTrain <= 2000108)) || ((this.inTrain >= 2001001) && (this.inTrain <= 2001036)) || 
                    ((this.inTrain >= 2002001) && (this.inTrain <= 2002024)) || ((this.inTrain >= 2003001) && (this.inTrain <= 2003024)) || 
                    ((this.inTrain >= 2004001) && (this.inTrain <= 2004054)) || ((this.inTrain >= 2005001) && (this.inTrain <= 2005108)) || 
                    ((this.inTrain >= 2006001) && (this.inTrain <= 2006024)) || ((this.inTrain >= 2007001) && (this.inTrain <= 2007054)) || 
                    ((this.inTrain >= 2008001) && (this.inTrain <= 2008024)) || 
                    // manchester
                    ((this.inTrain >= 2100001) && (this.inTrain <= 2100108)) ||
                    ((this.inTrain >= 2101001) && (this.inTrain <= 2101036)) || ((this.inTrain >= 2102001) && (this.inTrain <= 2102024)) || 
                    ((this.inTrain >= 2103001) && (this.inTrain <= 2103024)) || ((this.inTrain >= 2104001) && (this.inTrain <= 2104054)) || 
                    ((this.inTrain >= 2105001) && (this.inTrain <= 2105108)) || ((this.inTrain >= 2106001) && (this.inTrain <= 2106036)) ||
                    ((this.inTrain >= 2107001) && (this.inTrain <= 2107054)) || ((this.inTrain >= 2108001) && (this.inTrain <= 2108024)) ||
                    // london
                    ((this.inTrain >= 2200001) && (this.inTrain <= 2200036)) ||
                    ((this.inTrain >= 2201001) && (this.inTrain <= 2201036)) || ((this.inTrain >= 2202001) && (this.inTrain <= 2202018)) || 
                    ((this.inTrain >= 2203001) && (this.inTrain <= 2203018)) || ((this.inTrain >= 2204001) && (this.inTrain <= 2204054)) || 
                    ((this.inTrain >= 2205001) && (this.inTrain <= 2205054)) || ((this.inTrain >= 2206001) && (this.inTrain <= 2206024)) ||
                    ((this.inTrain >= 2207001) && (this.inTrain <= 2207054)) || ((this.inTrain >= 2208001) && (this.inTrain <= 2208054)) ||
                    // glasgow
                    ((this.inTrain >= 2300001) && (this.inTrain <= 2300024)) ||
                    ((this.inTrain >= 2301001) && (this.inTrain <= 2301024)) || ((this.inTrain >= 2302001) && (this.inTrain <= 2302018)) || 
                    ((this.inTrain >= 2303001) && (this.inTrain <= 2303108)) || ((this.inTrain >= 2304001) && (this.inTrain <= 2304024)) || 
                    ((this.inTrain >= 2305001) && (this.inTrain <= 2305024)) || ((this.inTrain >= 2306001) && (this.inTrain <= 2306036)) ||
                    ((this.inTrain >= 2307001) && (this.inTrain <= 2307018)) || ((this.inTrain >= 2308001) && (this.inTrain <= 2308012)) ||
                    // edinburgh
                    ((this.inTrain >= 2400001) && (this.inTrain <= 2400024)) ||
                    ((this.inTrain >= 2401001) && (this.inTrain <= 2401024)) || ((this.inTrain >= 2402001) && (this.inTrain <= 2402018)) || 
                    ((this.inTrain >= 2403001) && (this.inTrain <= 2403108)) || ((this.inTrain >= 2404001) && (this.inTrain <= 2404036)) || 
                    ((this.inTrain >= 2405001) && (this.inTrain <= 2405024)) || ((this.inTrain >= 2406001) && (this.inTrain <= 2406054)) ||
                    ((this.inTrain >= 2407001) && (this.inTrain <= 2407018)) || ((this.inTrain >= 2408001) && (this.inTrain <= 2408012)) ||
                    // york
                    ((this.inTrain >= 2500001) && (this.inTrain <= 2500054)) ||
                    ((this.inTrain >= 2501001) && (this.inTrain <= 2501054)) || ((this.inTrain >= 2502001) && (this.inTrain <= 2502054)) || 
                    ((this.inTrain >= 2503001) && (this.inTrain <= 2503024)) || ((this.inTrain >= 2504001) && (this.inTrain <= 2504036)) || 
                    ((this.inTrain >= 2505001) && (this.inTrain <= 2505036)) || ((this.inTrain >= 2506001) && (this.inTrain <= 2506054)) ||
                    ((this.inTrain >= 2507001) && (this.inTrain <= 2507054)) || ((this.inTrain >= 2508001) && (this.inTrain <= 2508018)) ||
                    // chester
                    ((this.inTrain >= 2600001) && (this.inTrain <= 2600108)) ||
                    ((this.inTrain >= 2601001) && (this.inTrain <= 2601108)) || ((this.inTrain >= 2602001) && (this.inTrain <= 2602054)) || 
                    ((this.inTrain >= 2603001) && (this.inTrain <= 2603024)) || ((this.inTrain >= 2604001) && (this.inTrain <= 2604024)) || 
                    ((this.inTrain >= 2605001) && (this.inTrain <= 2605036)) || ((this.inTrain >= 2606001) && (this.inTrain <= 2606024)) ||
                    ((this.inTrain >= 2607001) && (this.inTrain <= 2607054)) || ((this.inTrain >= 2608001) && (this.inTrain <= 2608036)) ||
                    // newcastle
                    ((this.inTrain >= 2700001) && (this.inTrain <= 2700024)) ||
                    ((this.inTrain >= 2701001) && (this.inTrain <= 2701036)) || ((this.inTrain >= 2702001) && (this.inTrain <= 2702024)) || 
                    ((this.inTrain >= 2703001) && (this.inTrain <= 2703036)) || ((this.inTrain >= 2704001) && (this.inTrain <= 2704054)) || 
                    ((this.inTrain >= 2705001) && (this.inTrain <= 2705054)) || ((this.inTrain >= 2706001) && (this.inTrain <= 2706024)) ||
                    ((this.inTrain >= 2707001) && (this.inTrain <= 2707024)) || ((this.inTrain >= 2708001) && (this.inTrain <= 2708018)) ||
                    // birmingham
                    ((this.inTrain >= 2800001) && (this.inTrain <= 2800054)) ||
                    ((this.inTrain >= 2801001) && (this.inTrain <= 2801054)) || ((this.inTrain >= 2802001) && (this.inTrain <= 2802054)) || 
                    ((this.inTrain >= 2803001) && (this.inTrain <= 2803018)) || ((this.inTrain >= 2804001) && (this.inTrain <= 2804018)) || 
                    ((this.inTrain >= 2805001) && (this.inTrain <= 2805054)) || ((this.inTrain >= 2806001) && (this.inTrain <= 2806054)) ||
                    ((this.inTrain >= 2807001) && (this.inTrain <= 2807024)) || ((this.inTrain >= 2808001) && (this.inTrain <= 2808054)) ||
                    // cardiff
                    ((this.inTrain >= 2900001) && (this.inTrain <= 2900024)) ||
                    ((this.inTrain >= 2901001) && (this.inTrain <= 2901024)) || ((this.inTrain >= 2902001) && (this.inTrain <= 2902054)) || 
                    ((this.inTrain >= 2903001) && (this.inTrain <= 2903012)) || ((this.inTrain >= 2904001) && (this.inTrain <= 2904012)) || 
                    ((this.inTrain >= 2905001) && (this.inTrain <= 2905018)) || ((this.inTrain >= 2906001) && (this.inTrain <= 2906036)) ||
                    ((this.inTrain >= 2907001) && (this.inTrain <= 2907018)) || ((this.inTrain >= 2908001) && (this.inTrain <= 2908054))){
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String url="jdbc:mysql://mysql.cms.livjm.ac.uk:3306/cmpjcol1";
                    String username="cmpjcol1";
                    String password="password";
                    Connection con=DriverManager.getConnection(url, username, password);
                    Statement stm=con.createStatement();
                    
                    ResultSet rset=stm.executeQuery("SELECT bus.bus_id, flight.flight_id, train.train_id FROM bus "
                            + " INNER JOIN flight ON bus.bus_id = " + inBus + " AND flight.flight_id = " + inFlight + " INNER JOIN train ON train.train_id = " + inTrain);
                    while (rset.next()) {
                        return "confirmbooking?faces-redirect=true";
                    }
                    rset.close();
                    con.close();
                }
                catch(Exception e) {
                    e.printStackTrace();
                    return "error?faces-redirect=true";
                }
            }
            // if the user books train, vehicle hire and bus
            else if ((this.inFlight==null) && 
                    (this.inVehicle >= 1101) && (this.inVehicle <= 1163) &&
                    ((this.inBus >= 10101) && (this.inBus <= 10213)) || ((this.inBus >= 10301) && (this.inBus <= 10413)) || 
                    ((this.inBus >= 10501) && (this.inBus <= 10613)) || ((this.inBus >= 10701) && (this.inBus <= 10813)) || 
                    ((this.inBus >= 10901) && (this.inBus <= 11013)) || ((this.inBus >= 11301) && (this.inBus <= 11413)) || 
                    ((this.inBus >= 11501) && (this.inBus <= 11613)) || ((this.inBus >= 11701) && (this.inBus <= 11813)) || 
                    ((this.inBus >= 11901) && (this.inBus <= 12013)) || ((this.inBus >= 12101) && (this.inBus <= 12250)) ||
                    ((this.inBus >= 12301) && (this.inBus <= 12450)) || ((this.inBus >= 12501) && (this.inBus <= 12638)) || 
                    ((this.inBus >= 12701) && (this.inBus <= 12838)) || ((this.inBus >= 12901) && (this.inBus <= 13038)) || 
                    ((this.inBus >= 13101) && (this.inBus <= 13238)) &&
                    // liverpool
                    ((this.inTrain >= 2000001) && (this.inTrain <= 2000108)) || ((this.inTrain >= 2001001) && (this.inTrain <= 2001036)) || 
                    ((this.inTrain >= 2002001) && (this.inTrain <= 2002024)) || ((this.inTrain >= 2003001) && (this.inTrain <= 2003024)) || 
                    ((this.inTrain >= 2004001) && (this.inTrain <= 2004054)) || ((this.inTrain >= 2005001) && (this.inTrain <= 2005108)) || 
                    ((this.inTrain >= 2006001) && (this.inTrain <= 2006024)) || ((this.inTrain >= 2007001) && (this.inTrain <= 2007054)) || 
                    ((this.inTrain >= 2008001) && (this.inTrain <= 2008024)) || 
                    // manchester
                    ((this.inTrain >= 2100001) && (this.inTrain <= 2100108)) ||
                    ((this.inTrain >= 2101001) && (this.inTrain <= 2101036)) || ((this.inTrain >= 2102001) && (this.inTrain <= 2102024)) || 
                    ((this.inTrain >= 2103001) && (this.inTrain <= 2103024)) || ((this.inTrain >= 2104001) && (this.inTrain <= 2104054)) || 
                    ((this.inTrain >= 2105001) && (this.inTrain <= 2105108)) || ((this.inTrain >= 2106001) && (this.inTrain <= 2106036)) ||
                    ((this.inTrain >= 2107001) && (this.inTrain <= 2107054)) || ((this.inTrain >= 2108001) && (this.inTrain <= 2108024)) ||
                    // london
                    ((this.inTrain >= 2200001) && (this.inTrain <= 2200036)) ||
                    ((this.inTrain >= 2201001) && (this.inTrain <= 2201036)) || ((this.inTrain >= 2202001) && (this.inTrain <= 2202018)) || 
                    ((this.inTrain >= 2203001) && (this.inTrain <= 2203018)) || ((this.inTrain >= 2204001) && (this.inTrain <= 2204054)) || 
                    ((this.inTrain >= 2205001) && (this.inTrain <= 2205054)) || ((this.inTrain >= 2206001) && (this.inTrain <= 2206024)) ||
                    ((this.inTrain >= 2207001) && (this.inTrain <= 2207054)) || ((this.inTrain >= 2208001) && (this.inTrain <= 2208054)) ||
                    // glasgow
                    ((this.inTrain >= 2300001) && (this.inTrain <= 2300024)) ||
                    ((this.inTrain >= 2301001) && (this.inTrain <= 2301024)) || ((this.inTrain >= 2302001) && (this.inTrain <= 2302018)) || 
                    ((this.inTrain >= 2303001) && (this.inTrain <= 2303108)) || ((this.inTrain >= 2304001) && (this.inTrain <= 2304024)) || 
                    ((this.inTrain >= 2305001) && (this.inTrain <= 2305024)) || ((this.inTrain >= 2306001) && (this.inTrain <= 2306036)) ||
                    ((this.inTrain >= 2307001) && (this.inTrain <= 2307018)) || ((this.inTrain >= 2308001) && (this.inTrain <= 2308012)) ||
                    // edinburgh
                    ((this.inTrain >= 2400001) && (this.inTrain <= 2400024)) ||
                    ((this.inTrain >= 2401001) && (this.inTrain <= 2401024)) || ((this.inTrain >= 2402001) && (this.inTrain <= 2402018)) || 
                    ((this.inTrain >= 2403001) && (this.inTrain <= 2403108)) || ((this.inTrain >= 2404001) && (this.inTrain <= 2404036)) || 
                    ((this.inTrain >= 2405001) && (this.inTrain <= 2405024)) || ((this.inTrain >= 2406001) && (this.inTrain <= 2406054)) ||
                    ((this.inTrain >= 2407001) && (this.inTrain <= 2407018)) || ((this.inTrain >= 2408001) && (this.inTrain <= 2408012)) ||
                    // york
                    ((this.inTrain >= 2500001) && (this.inTrain <= 2500054)) ||
                    ((this.inTrain >= 2501001) && (this.inTrain <= 2501054)) || ((this.inTrain >= 2502001) && (this.inTrain <= 2502054)) || 
                    ((this.inTrain >= 2503001) && (this.inTrain <= 2503024)) || ((this.inTrain >= 2504001) && (this.inTrain <= 2504036)) || 
                    ((this.inTrain >= 2505001) && (this.inTrain <= 2505036)) || ((this.inTrain >= 2506001) && (this.inTrain <= 2506054)) ||
                    ((this.inTrain >= 2507001) && (this.inTrain <= 2507054)) || ((this.inTrain >= 2508001) && (this.inTrain <= 2508018)) ||
                    // chester
                    ((this.inTrain >= 2600001) && (this.inTrain <= 2600108)) ||
                    ((this.inTrain >= 2601001) && (this.inTrain <= 2601108)) || ((this.inTrain >= 2602001) && (this.inTrain <= 2602054)) || 
                    ((this.inTrain >= 2603001) && (this.inTrain <= 2603024)) || ((this.inTrain >= 2604001) && (this.inTrain <= 2604024)) || 
                    ((this.inTrain >= 2605001) && (this.inTrain <= 2605036)) || ((this.inTrain >= 2606001) && (this.inTrain <= 2606024)) ||
                    ((this.inTrain >= 2607001) && (this.inTrain <= 2607054)) || ((this.inTrain >= 2608001) && (this.inTrain <= 2608036)) ||
                    // newcastle
                    ((this.inTrain >= 2700001) && (this.inTrain <= 2700024)) ||
                    ((this.inTrain >= 2701001) && (this.inTrain <= 2701036)) || ((this.inTrain >= 2702001) && (this.inTrain <= 2702024)) || 
                    ((this.inTrain >= 2703001) && (this.inTrain <= 2703036)) || ((this.inTrain >= 2704001) && (this.inTrain <= 2704054)) || 
                    ((this.inTrain >= 2705001) && (this.inTrain <= 2705054)) || ((this.inTrain >= 2706001) && (this.inTrain <= 2706024)) ||
                    ((this.inTrain >= 2707001) && (this.inTrain <= 2707024)) || ((this.inTrain >= 2708001) && (this.inTrain <= 2708018)) ||
                    // birmingham
                    ((this.inTrain >= 2800001) && (this.inTrain <= 2800054)) ||
                    ((this.inTrain >= 2801001) && (this.inTrain <= 2801054)) || ((this.inTrain >= 2802001) && (this.inTrain <= 2802054)) || 
                    ((this.inTrain >= 2803001) && (this.inTrain <= 2803018)) || ((this.inTrain >= 2804001) && (this.inTrain <= 2804018)) || 
                    ((this.inTrain >= 2805001) && (this.inTrain <= 2805054)) || ((this.inTrain >= 2806001) && (this.inTrain <= 2806054)) ||
                    ((this.inTrain >= 2807001) && (this.inTrain <= 2807024)) || ((this.inTrain >= 2808001) && (this.inTrain <= 2808054)) ||
                    // cardiff
                    ((this.inTrain >= 2900001) && (this.inTrain <= 2900024)) ||
                    ((this.inTrain >= 2901001) && (this.inTrain <= 2901024)) || ((this.inTrain >= 2902001) && (this.inTrain <= 2902054)) || 
                    ((this.inTrain >= 2903001) && (this.inTrain <= 2903012)) || ((this.inTrain >= 2904001) && (this.inTrain <= 2904012)) || 
                    ((this.inTrain >= 2905001) && (this.inTrain <= 2905018)) || ((this.inTrain >= 2906001) && (this.inTrain <= 2906036)) ||
                    ((this.inTrain >= 2907001) && (this.inTrain <= 2907018)) || ((this.inTrain >= 2908001) && (this.inTrain <= 2908054))){
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String url="jdbc:mysql://mysql.cms.livjm.ac.uk:3306/cmpjcol1";
                    String username="cmpjcol1";
                    String password="password";
                    Connection con=DriverManager.getConnection(url, username, password);
                    Statement stm=con.createStatement();
                    
                    ResultSet rset=stm.executeQuery("SELECT bus.bus_id, vehicle.vehicle_id, train.train_id FROM bus "
                            + " INNER JOIN vehicle ON bus.bus_id = " + inBus + " AND vehicle.vehicle_id = " + inVehicle + " INNER JOIN train ON train.train_id = " + inTrain);
                    while (rset.next()) {
                        return "confirmbooking?faces-redirect=true";
                        
                    }
                    rset.close();
                    con.close();
                }
                catch(Exception e) {
                    e.printStackTrace();
                    return "error?faces-redirect=true";
                }
            }
            // if the user books all
            else if (((this.inFlight >= 5201001) && (this.inFlight <= 5101058) || ((this.inFlight >= 5201001) && (this.inFlight <= 5201074)) || 
                    ((this.inFlight >= 5301001) && (this.inFlight <= 5301077)) || ((this.inFlight >= 5401001) && (this.inFlight <= 5401058)) || 
                    ((this.inFlight >= 5501001) && (this.inFlight <= 5501058)) && 
                    ((this.inVehicle >= 1101) && (this.inVehicle <= 1163)) &&
                    ((this.inBus >= 10101) && (this.inBus <= 10213)) || ((this.inBus >= 10301) && (this.inBus <= 10413)) || 
                    ((this.inBus >= 10501) && (this.inBus <= 10613)) || ((this.inBus >= 10701) && (this.inBus <= 10813)) || 
                    ((this.inBus >= 10901) && (this.inBus <= 11013)) || ((this.inBus >= 11301) && (this.inBus <= 11413)) || 
                    ((this.inBus >= 11501) && (this.inBus <= 11613)) || ((this.inBus >= 11701) && (this.inBus <= 11813)) || 
                    ((this.inBus >= 11901) && (this.inBus <= 12013)) || ((this.inBus >= 12101) && (this.inBus <= 12250)) ||
                    ((this.inBus >= 12301) && (this.inBus <= 12450)) || ((this.inBus >= 12501) && (this.inBus <= 12638)) || 
                    ((this.inBus >= 12701) && (this.inBus <= 12838)) || ((this.inBus >= 12901) && (this.inBus <= 13038)) || 
                    ((this.inBus >= 13101) && (this.inBus <= 13238)) &&
                    // liverpool
                    ((this.inTrain >= 2000001) && (this.inTrain <= 2000108)) || ((this.inTrain >= 2001001) && (this.inTrain <= 2001036)) || 
                    ((this.inTrain >= 2002001) && (this.inTrain <= 2002024)) || ((this.inTrain >= 2003001) && (this.inTrain <= 2003024)) || 
                    ((this.inTrain >= 2004001) && (this.inTrain <= 2004054)) || ((this.inTrain >= 2005001) && (this.inTrain <= 2005108)) || 
                    ((this.inTrain >= 2006001) && (this.inTrain <= 2006024)) || ((this.inTrain >= 2007001) && (this.inTrain <= 2007054)) || 
                    ((this.inTrain >= 2008001) && (this.inTrain <= 2008024)) || 
                    // manchester
                    ((this.inTrain >= 2100001) && (this.inTrain <= 2100108)) ||
                    ((this.inTrain >= 2101001) && (this.inTrain <= 2101036)) || ((this.inTrain >= 2102001) && (this.inTrain <= 2102024)) || 
                    ((this.inTrain >= 2103001) && (this.inTrain <= 2103024)) || ((this.inTrain >= 2104001) && (this.inTrain <= 2104054)) || 
                    ((this.inTrain >= 2105001) && (this.inTrain <= 2105108)) || ((this.inTrain >= 2106001) && (this.inTrain <= 2106036)) ||
                    ((this.inTrain >= 2107001) && (this.inTrain <= 2107054)) || ((this.inTrain >= 2108001) && (this.inTrain <= 2108024)) ||
                    // london
                    ((this.inTrain >= 2200001) && (this.inTrain <= 2200036)) ||
                    ((this.inTrain >= 2201001) && (this.inTrain <= 2201036)) || ((this.inTrain >= 2202001) && (this.inTrain <= 2202018)) || 
                    ((this.inTrain >= 2203001) && (this.inTrain <= 2203018)) || ((this.inTrain >= 2204001) && (this.inTrain <= 2204054)) || 
                    ((this.inTrain >= 2205001) && (this.inTrain <= 2205054)) || ((this.inTrain >= 2206001) && (this.inTrain <= 2206024)) ||
                    ((this.inTrain >= 2207001) && (this.inTrain <= 2207054)) || ((this.inTrain >= 2208001) && (this.inTrain <= 2208054)) ||
                    // glasgow
                    ((this.inTrain >= 2300001) && (this.inTrain <= 2300024)) ||
                    ((this.inTrain >= 2301001) && (this.inTrain <= 2301024)) || ((this.inTrain >= 2302001) && (this.inTrain <= 2302018)) || 
                    ((this.inTrain >= 2303001) && (this.inTrain <= 2303108)) || ((this.inTrain >= 2304001) && (this.inTrain <= 2304024)) || 
                    ((this.inTrain >= 2305001) && (this.inTrain <= 2305024)) || ((this.inTrain >= 2306001) && (this.inTrain <= 2306036)) ||
                    ((this.inTrain >= 2307001) && (this.inTrain <= 2307018)) || ((this.inTrain >= 2308001) && (this.inTrain <= 2308012)) ||
                    // edinburgh
                    ((this.inTrain >= 2400001) && (this.inTrain <= 2400024)) ||
                    ((this.inTrain >= 2401001) && (this.inTrain <= 2401024)) || ((this.inTrain >= 2402001) && (this.inTrain <= 2402018)) || 
                    ((this.inTrain >= 2403001) && (this.inTrain <= 2403108)) || ((this.inTrain >= 2404001) && (this.inTrain <= 2404036)) || 
                    ((this.inTrain >= 2405001) && (this.inTrain <= 2405024)) || ((this.inTrain >= 2406001) && (this.inTrain <= 2406054)) ||
                    ((this.inTrain >= 2407001) && (this.inTrain <= 2407018)) || ((this.inTrain >= 2408001) && (this.inTrain <= 2408012)) ||
                    // york
                    ((this.inTrain >= 2500001) && (this.inTrain <= 2500054)) ||
                    ((this.inTrain >= 2501001) && (this.inTrain <= 2501054)) || ((this.inTrain >= 2502001) && (this.inTrain <= 2502054)) || 
                    ((this.inTrain >= 2503001) && (this.inTrain <= 2503024)) || ((this.inTrain >= 2504001) && (this.inTrain <= 2504036)) || 
                    ((this.inTrain >= 2505001) && (this.inTrain <= 2505036)) || ((this.inTrain >= 2506001) && (this.inTrain <= 2506054)) ||
                    ((this.inTrain >= 2507001) && (this.inTrain <= 2507054)) || ((this.inTrain >= 2508001) && (this.inTrain <= 2508018)) ||
                    // chester
                    ((this.inTrain >= 2600001) && (this.inTrain <= 2600108)) ||
                    ((this.inTrain >= 2601001) && (this.inTrain <= 2601108)) || ((this.inTrain >= 2602001) && (this.inTrain <= 2602054)) || 
                    ((this.inTrain >= 2603001) && (this.inTrain <= 2603024)) || ((this.inTrain >= 2604001) && (this.inTrain <= 2604024)) || 
                    ((this.inTrain >= 2605001) && (this.inTrain <= 2605036)) || ((this.inTrain >= 2606001) && (this.inTrain <= 2606024)) ||
                    ((this.inTrain >= 2607001) && (this.inTrain <= 2607054)) || ((this.inTrain >= 2608001) && (this.inTrain <= 2608036)) ||
                    // newcastle
                    ((this.inTrain >= 2700001) && (this.inTrain <= 2700024)) ||
                    ((this.inTrain >= 2701001) && (this.inTrain <= 2701036)) || ((this.inTrain >= 2702001) && (this.inTrain <= 2702024)) || 
                    ((this.inTrain >= 2703001) && (this.inTrain <= 2703036)) || ((this.inTrain >= 2704001) && (this.inTrain <= 2704054)) || 
                    ((this.inTrain >= 2705001) && (this.inTrain <= 2705054)) || ((this.inTrain >= 2706001) && (this.inTrain <= 2706024)) ||
                    ((this.inTrain >= 2707001) && (this.inTrain <= 2707024)) || ((this.inTrain >= 2708001) && (this.inTrain <= 2708018)) ||
                    // birmingham
                    ((this.inTrain >= 2800001) && (this.inTrain <= 2800054)) ||
                    ((this.inTrain >= 2801001) && (this.inTrain <= 2801054)) || ((this.inTrain >= 2802001) && (this.inTrain <= 2802054)) || 
                    ((this.inTrain >= 2803001) && (this.inTrain <= 2803018)) || ((this.inTrain >= 2804001) && (this.inTrain <= 2804018)) || 
                    ((this.inTrain >= 2805001) && (this.inTrain <= 2805054)) || ((this.inTrain >= 2806001) && (this.inTrain <= 2806054)) ||
                    ((this.inTrain >= 2807001) && (this.inTrain <= 2807024)) || ((this.inTrain >= 2808001) && (this.inTrain <= 2808054)) ||
                    // cardiff
                    ((this.inTrain >= 2900001) && (this.inTrain <= 2900024)) ||
                    ((this.inTrain >= 2901001) && (this.inTrain <= 2901024)) || ((this.inTrain >= 2902001) && (this.inTrain <= 2902054)) || 
                    ((this.inTrain >= 2903001) && (this.inTrain <= 2903012)) || ((this.inTrain >= 2904001) && (this.inTrain <= 2904012)) || 
                    ((this.inTrain >= 2905001) && (this.inTrain <= 2905018)) || ((this.inTrain >= 2906001) && (this.inTrain <= 2906036)) ||
                    ((this.inTrain >= 2907001) && (this.inTrain <= 2907018)) || ((this.inTrain >= 2908001) && (this.inTrain <= 2908054)))){
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String url="jdbc:mysql://mysql.cms.livjm.ac.uk:3306/cmpjcol1";
                    String username="cmpjcol1";
                    String password="password";
                    Connection con=DriverManager.getConnection(url, username, password);
                    Statement stm=con.createStatement();
                    
                    ResultSet rset=stm.executeQuery("SELECT bus.bus_id, vehicle.vehicle_id, train.train_id, flight.flight_id FROM bus "
                            + " INNER JOIN vehicle ON bus.bus_id = " + inBus + " AND vehicle.vehicle_id = " + inVehicle + 
                            " INNER JOIN train ON train.train_id = " + inTrain + " INNER JOIN flight ON flight.flight_id = " + inFlight);
                    while (rset.next()) {
                        return "confirmbooking?faces-redirect=true";
                    }
                    rset.close();
                    con.close();
                }
                catch(Exception e) {
                    e.printStackTrace();
                    return "error?faces-redirect=true";
                }
            }
        }
        return "error?faces-redirect=true";
    }
         // save the name entered into the booking database
       public void setBooking(Booking booking)  {
        Integer bookv = booking.getVehicleId();
        Integer bookf = booking.getFlightId();
        Integer bookt = booking.getTrainId();
        Integer bookb = booking.getBusId();
        String bookemail = booking.getUserEmail();
        booking.setVehicleId(bookv + inVehicle);
        booking.setFlightId(bookf + inFlight);
        booking.setTrainId(bookt + inTrain);
        booking.setBusId(bookb + inBus);
        booking.setUserEmail(bookemail + inEmail);
        updateEntity(booking);
        }
}
