package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cmpjcol1
 */
@Entity
@Table(name = "booking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b")
    , @NamedQuery(name = "Booking.findByVbookingId", query = "SELECT b FROM Booking b WHERE b.vbookingId = :vbookingId")
    , @NamedQuery(name = "Booking.findByVehicleId", query = "SELECT b FROM Booking b WHERE b.vehicleId = :vehicleId")
    , @NamedQuery(name = "Booking.findByBusId", query = "SELECT b FROM Booking b WHERE b.busId = :busId")
    , @NamedQuery(name = "Booking.findByFlightId", query = "SELECT b FROM Booking b WHERE b.flightId = :flightId")
    , @NamedQuery(name = "Booking.findByTrainId", query = "SELECT b FROM Booking b WHERE b.trainId = :trainId")
    , @NamedQuery(name = "Booking.findByUserEmail", query = "SELECT b FROM Booking b WHERE b.userEmail = :userEmail")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vbooking_id")
    private Integer vbookingId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vehicle_id")
    private int vehicleId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bus_id")
    private int busId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flight_id")
    private int flightId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "train_id")
    private int trainId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "user_email")
    private String userEmail;

    public Booking() {
    }

    public Booking(Integer vbookingId) {
        this.vbookingId = vbookingId;
    }

    public Booking(Integer vbookingId, int vehicleId, int busId, int flightId, int trainId, String userEmail) {
        this.vbookingId = vbookingId;
        this.vehicleId = vehicleId;
        this.busId = busId;
        this.flightId = flightId;
        this.trainId = trainId;
        this.userEmail = userEmail;
    }

    public Integer getVbookingId() {
        return vbookingId;
    }

    public void setVbookingId(Integer vbookingId) {
        this.vbookingId = vbookingId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vbookingId != null ? vbookingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.vbookingId == null && other.vbookingId != null) || (this.vbookingId != null && !this.vbookingId.equals(other.vbookingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Booking[ vbookingId=" + vbookingId + " ]";
    }
    
}
