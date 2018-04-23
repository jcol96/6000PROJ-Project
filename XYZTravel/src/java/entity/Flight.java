package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cmpjcol1
 */
@Entity
@Table(name = "flight")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Flight.findAll", query = "SELECT f FROM Flight f")
    , @NamedQuery(name = "Flight.findByFlightId", query = "SELECT f FROM Flight f WHERE f.flightId = :flightId")
    , @NamedQuery(name = "Flight.findByFlightFromid", query = "SELECT f FROM Flight f WHERE f.flightFromid = :flightFromid")
    , @NamedQuery(name = "Flight.findByFlightFrom", query = "SELECT f FROM Flight f WHERE f.flightFrom = :flightFrom")
    , @NamedQuery(name = "Flight.findByFlightToid", query = "SELECT f FROM Flight f WHERE f.flightToid = :flightToid")
    , @NamedQuery(name = "Flight.findByFlightTo", query = "SELECT f FROM Flight f WHERE f.flightTo = :flightTo")
    , @NamedQuery(name = "Flight.findByFlightDateid", query = "SELECT f FROM Flight f WHERE f.flightDateid = :flightDateid")
    , @NamedQuery(name = "Flight.findByFlightDate", query = "SELECT f FROM Flight f WHERE f.flightDate = :flightDate")
    , @NamedQuery(name = "Flight.findByFlightDepart", query = "SELECT f FROM Flight f WHERE f.flightDepart = :flightDepart")
    , @NamedQuery(name = "Flight.findByFlightArrival", query = "SELECT f FROM Flight f WHERE f.flightArrival = :flightArrival")
    , @NamedQuery(name = "Flight.findByFlightPriceid", query = "SELECT f FROM Flight f WHERE f.flightPriceid = :flightPriceid")
    , @NamedQuery(name = "Flight.findByFlightPrice", query = "SELECT f FROM Flight f WHERE f.flightPrice = :flightPrice")})
public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "flight_id")
    private Integer flightId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flight_fromid")
    private int flightFromid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "flight_from")
    private String flightFrom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flight_toid")
    private int flightToid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "flight_to")
    private String flightTo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flight_dateid")
    private int flightDateid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flight_date")
    @Temporal(TemporalType.DATE)
    private Date flightDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flight_depart")
    @Temporal(TemporalType.TIME)
    private Date flightDepart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flight_arrival")
    @Temporal(TemporalType.TIME)
    private Date flightArrival;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flight_priceid")
    private int flightPriceid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flight_price")
    private double flightPrice;

    public Flight() {
    }

    public Flight(Integer flightId) {
        this.flightId = flightId;
    }

    public Flight(Integer flightId, int flightFromid, String flightFrom, int flightToid, String flightTo, int flightDateid, Date flightDate, Date flightDepart, Date flightArrival, int flightPriceid, double flightPrice) {
        this.flightId = flightId;
        this.flightFromid = flightFromid;
        this.flightFrom = flightFrom;
        this.flightToid = flightToid;
        this.flightTo = flightTo;
        this.flightDateid = flightDateid;
        this.flightDate = flightDate;
        this.flightDepart = flightDepart;
        this.flightArrival = flightArrival;
        this.flightPriceid = flightPriceid;
        this.flightPrice = flightPrice;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public int getFlightFromid() {
        return flightFromid;
    }

    public void setFlightFromid(int flightFromid) {
        this.flightFromid = flightFromid;
    }

    public String getFlightFrom() {
        return flightFrom;
    }

    public void setFlightFrom(String flightFrom) {
        this.flightFrom = flightFrom;
    }

    public int getFlightToid() {
        return flightToid;
    }

    public void setFlightToid(int flightToid) {
        this.flightToid = flightToid;
    }

    public String getFlightTo() {
        return flightTo;
    }

    public void setFlightTo(String flightTo) {
        this.flightTo = flightTo;
    }

    public int getFlightDateid() {
        return flightDateid;
    }

    public void setFlightDateid(int flightDateid) {
        this.flightDateid = flightDateid;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public Date getFlightDepart() {
        return flightDepart;
    }

    public void setFlightDepart(Date flightDepart) {
        this.flightDepart = flightDepart;
    }

    public Date getFlightArrival() {
        return flightArrival;
    }

    public void setFlightArrival(Date flightArrival) {
        this.flightArrival = flightArrival;
    }

    public int getFlightPriceid() {
        return flightPriceid;
    }

    public void setFlightPriceid(int flightPriceid) {
        this.flightPriceid = flightPriceid;
    }

    public double getFlightPrice() {
        return flightPrice;
    }

    public void setFlightPrice(double flightPrice) {
        this.flightPrice = flightPrice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (flightId != null ? flightId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flight)) {
            return false;
        }
        Flight other = (Flight) object;
        if ((this.flightId == null && other.flightId != null) || (this.flightId != null && !this.flightId.equals(other.flightId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Flight[ flightId=" + flightId + " ]";
    }
    
}
