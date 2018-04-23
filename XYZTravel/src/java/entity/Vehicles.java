package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "vehicles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicles.findAll", query = "SELECT v FROM Vehicles v")
    , @NamedQuery(name = "Vehicles.findByVehicleId", query = "SELECT v FROM Vehicles v WHERE v.vehicleId = :vehicleId")
    , @NamedQuery(name = "Vehicles.findByVehicleLocation", query = "SELECT v FROM Vehicles v WHERE v.vehicleLocation = :vehicleLocation")
    , @NamedQuery(name = "Vehicles.findByVehicleType", query = "SELECT v FROM Vehicles v WHERE v.vehicleType = :vehicleType")
    , @NamedQuery(name = "Vehicles.findByVehicleMake", query = "SELECT v FROM Vehicles v WHERE v.vehicleMake = :vehicleMake")
    , @NamedQuery(name = "Vehicles.findByVehicleModel", query = "SELECT v FROM Vehicles v WHERE v.vehicleModel = :vehicleModel")
    , @NamedQuery(name = "Vehicles.findByVehiclePrice", query = "SELECT v FROM Vehicles v WHERE v.vehiclePrice = :vehiclePrice")
    , @NamedQuery(name = "Vehicles.findByVehicleQuantity", query = "SELECT v FROM Vehicles v WHERE v.vehicleQuantity = :vehicleQuantity")
    , @NamedQuery(name = "Vehicles.findByBelfastLocation", query = "SELECT v FROM Vehicles v WHERE v.vehicleLocation IN ('Belfast')")
    , @NamedQuery(name = "Vehicles.findByCardiffLocation", query = "SELECT v FROM Vehicles v WHERE v.vehicleLocation IN ('Cardiff')")
    , @NamedQuery(name = "Vehicles.findByEdinburghLocation", query = "SELECT v FROM Vehicles v WHERE v.vehicleLocation IN ('Edinburgh')")
    , @NamedQuery(name = "Vehicles.findByIsleofManLocation", query = "SELECT v FROM Vehicles v WHERE v.vehicleLocation IN ('Isle of Man')")
    , @NamedQuery(name = "Vehicles.findByLondonLocation", query = "SELECT v FROM Vehicles v WHERE v.vehicleLocation IN ('London')")
    , @NamedQuery(name = "Vehicles.findByManchesterLocation", query = "SELECT v FROM Vehicles v WHERE v.vehicleLocation IN ('Manchester')")})
public class Vehicles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "vehicle_id")
    private Integer vehicleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "vehicle_location")
    private String vehicleLocation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "vehicle_type")
    private String vehicleType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "vehicle_make")
    private String vehicleMake;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "vehicle_model")
    private String vehicleModel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vehicle_price")
    private double vehiclePrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vehicle_quantity")
    private short vehicleQuantity;

    public Vehicles() {
    }

    public Vehicles(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Vehicles(Integer vehicleId, String vehicleLocation, String vehicleType, String vehicleMake, String vehicleModel, double vehiclePrice, short vehicleQuantity) {
        this.vehicleId = vehicleId;
        this.vehicleLocation = vehicleLocation;
        this.vehicleType = vehicleType;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.vehiclePrice = vehiclePrice;
        this.vehicleQuantity = vehicleQuantity;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleLocation() {
        return vehicleLocation;
    }

    public void setVehicleLocation(String vehicleLocation) {
        this.vehicleLocation = vehicleLocation;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public double getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public short getVehicleQuantity() {
        return vehicleQuantity;
    }

    public void setVehicleQuantity(short vehicleQuantity) {
        this.vehicleQuantity = vehicleQuantity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vehicleId != null ? vehicleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicles)) {
            return false;
        }
        Vehicles other = (Vehicles) object;
        if ((this.vehicleId == null && other.vehicleId != null) || (this.vehicleId != null && !this.vehicleId.equals(other.vehicleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Vehicles[ vehicleId=" + vehicleId + " ]";
    }
    
}
