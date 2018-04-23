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
@Table(name = "bus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bus.findAll", query = "SELECT b FROM Bus b")
    , @NamedQuery(name = "Bus.findByBusId", query = "SELECT b FROM Bus b WHERE b.busId = :busId")
    , @NamedQuery(name = "Bus.findByBusFromid", query = "SELECT b FROM Bus b WHERE b.busFromid = :busFromid")
    , @NamedQuery(name = "Bus.findByBusFrom", query = "SELECT b FROM Bus b WHERE b.busFrom = :busFrom")
    , @NamedQuery(name = "Bus.findByBusToid", query = "SELECT b FROM Bus b WHERE b.busToid = :busToid")
    , @NamedQuery(name = "Bus.findByBusTo", query = "SELECT b FROM Bus b WHERE b.busTo = :busTo")
    , @NamedQuery(name = "Bus.findByBusDateid", query = "SELECT b FROM Bus b WHERE b.busDateid = :busDateid")
    , @NamedQuery(name = "Bus.findByBusDate", query = "SELECT b FROM Bus b WHERE b.busDate = :busDate")
    , @NamedQuery(name = "Bus.findByBusDepart", query = "SELECT b FROM Bus b WHERE b.busDepart = :busDepart")
    , @NamedQuery(name = "Bus.findByBusArrival", query = "SELECT b FROM Bus b WHERE b.busArrival = :busArrival")
    , @NamedQuery(name = "Bus.findByBusPrice", query = "SELECT b FROM Bus b WHERE b.busPrice = :busPrice")})
public class Bus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "bus_id")
    private Integer busId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bus_fromid")
    private int busFromid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "bus_from")
    private String busFrom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bus_toid")
    private int busToid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "bus_to")
    private String busTo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bus_dateid")
    private int busDateid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bus_date")
    @Temporal(TemporalType.DATE)
    private Date busDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bus_depart")
    @Temporal(TemporalType.TIME)
    private Date busDepart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bus_arrival")
    @Temporal(TemporalType.TIME)
    private Date busArrival;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bus_price")
    private double busPrice;

    public Bus() {
    }

    public Bus(Integer busId) {
        this.busId = busId;
    }

    public Bus(Integer busId, int busFromid, String busFrom, int busToid, String busTo, int busDateid, Date busDate, Date busDepart, Date busArrival, double busPrice) {
        this.busId = busId;
        this.busFromid = busFromid;
        this.busFrom = busFrom;
        this.busToid = busToid;
        this.busTo = busTo;
        this.busDateid = busDateid;
        this.busDate = busDate;
        this.busDepart = busDepart;
        this.busArrival = busArrival;
        this.busPrice = busPrice;
    }

    public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    public int getBusFromid() {
        return busFromid;
    }

    public void setBusFromid(int busFromid) {
        this.busFromid = busFromid;
    }

    public String getBusFrom() {
        return busFrom;
    }

    public void setBusFrom(String busFrom) {
        this.busFrom = busFrom;
    }

    public int getBusToid() {
        return busToid;
    }

    public void setBusToid(int busToid) {
        this.busToid = busToid;
    }

    public String getBusTo() {
        return busTo;
    }

    public void setBusTo(String busTo) {
        this.busTo = busTo;
    }

    public int getBusDateid() {
        return busDateid;
    }

    public void setBusDateid(int busDateid) {
        this.busDateid = busDateid;
    }

    public Date getBusDate() {
        return busDate;
    }

    public void setBusDate(Date busDate) {
        this.busDate = busDate;
    }

    public Date getBusDepart() {
        return busDepart;
    }

    public void setBusDepart(Date busDepart) {
        this.busDepart = busDepart;
    }

    public Date getBusArrival() {
        return busArrival;
    }

    public void setBusArrival(Date busArrival) {
        this.busArrival = busArrival;
    }

    public double getBusPrice() {
        return busPrice;
    }

    public void setBusPrice(double busPrice) {
        this.busPrice = busPrice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (busId != null ? busId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bus)) {
            return false;
        }
        Bus other = (Bus) object;
        if ((this.busId == null && other.busId != null) || (this.busId != null && !this.busId.equals(other.busId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Bus[ busId=" + busId + " ]";
    }
    
}
