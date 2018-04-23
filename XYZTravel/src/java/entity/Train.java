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
@Table(name = "train")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Train.findAll", query = "SELECT t FROM Train t")
    , @NamedQuery(name = "Train.findByTrainId", query = "SELECT t FROM Train t WHERE t.trainId = :trainId")
    , @NamedQuery(name = "Train.findByTrainFromid", query = "SELECT t FROM Train t WHERE t.trainFromid = :trainFromid")
    , @NamedQuery(name = "Train.findByTrainFrom", query = "SELECT t FROM Train t WHERE t.trainFrom = :trainFrom")
    , @NamedQuery(name = "Train.findByTrainToid", query = "SELECT t FROM Train t WHERE t.trainToid = :trainToid")
    , @NamedQuery(name = "Train.findByTrainTo", query = "SELECT t FROM Train t WHERE t.trainTo = :trainTo")
    , @NamedQuery(name = "Train.findByTrainDateid", query = "SELECT t FROM Train t WHERE t.trainDateid = :trainDateid")
    , @NamedQuery(name = "Train.findByTrainDate", query = "SELECT t FROM Train t WHERE t.trainDate = :trainDate")
    , @NamedQuery(name = "Train.findByTrainDepart", query = "SELECT t FROM Train t WHERE t.trainDepart = :trainDepart")
    , @NamedQuery(name = "Train.findByTrainArrival", query = "SELECT t FROM Train t WHERE t.trainArrival = :trainArrival")
    , @NamedQuery(name = "Train.findByTrainPrice", query = "SELECT t FROM Train t WHERE t.trainPrice = :trainPrice")})
public class Train implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "train_id")
    private Integer trainId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "train_fromid")
    private int trainFromid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "train_from")
    private String trainFrom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "train_toid")
    private int trainToid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "train_to")
    private String trainTo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "train_dateid")
    private int trainDateid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "train_date")
    @Temporal(TemporalType.DATE)
    private Date trainDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "train_depart")
    @Temporal(TemporalType.TIME)
    private Date trainDepart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "train_arrival")
    @Temporal(TemporalType.TIME)
    private Date trainArrival;
    @Basic(optional = false)
    @NotNull
    @Column(name = "train_price")
    private double trainPrice;

    public Train() {
    }

    public Train(Integer trainId) {
        this.trainId = trainId;
    }

    public Train(Integer trainId, int trainFromid, String trainFrom, int trainToid, String trainTo, int trainDateid, Date trainDate, Date trainDepart, Date trainArrival, double trainPrice) {
        this.trainId = trainId;
        this.trainFromid = trainFromid;
        this.trainFrom = trainFrom;
        this.trainToid = trainToid;
        this.trainTo = trainTo;
        this.trainDateid = trainDateid;
        this.trainDate = trainDate;
        this.trainDepart = trainDepart;
        this.trainArrival = trainArrival;
        this.trainPrice = trainPrice;
    }

    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    public int getTrainFromid() {
        return trainFromid;
    }

    public void setTrainFromid(int trainFromid) {
        this.trainFromid = trainFromid;
    }

    public String getTrainFrom() {
        return trainFrom;
    }

    public void setTrainFrom(String trainFrom) {
        this.trainFrom = trainFrom;
    }

    public int getTrainToid() {
        return trainToid;
    }

    public void setTrainToid(int trainToid) {
        this.trainToid = trainToid;
    }

    public String getTrainTo() {
        return trainTo;
    }

    public void setTrainTo(String trainTo) {
        this.trainTo = trainTo;
    }

    public int getTrainDateid() {
        return trainDateid;
    }

    public void setTrainDateid(int trainDateid) {
        this.trainDateid = trainDateid;
    }

    public Date getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(Date trainDate) {
        this.trainDate = trainDate;
    }

    public Date getTrainDepart() {
        return trainDepart;
    }

    public void setTrainDepart(Date trainDepart) {
        this.trainDepart = trainDepart;
    }

    public Date getTrainArrival() {
        return trainArrival;
    }

    public void setTrainArrival(Date trainArrival) {
        this.trainArrival = trainArrival;
    }

    public double getTrainPrice() {
        return trainPrice;
    }

    public void setTrainPrice(double trainPrice) {
        this.trainPrice = trainPrice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trainId != null ? trainId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Train)) {
            return false;
        }
        Train other = (Train) object;
        if ((this.trainId == null && other.trainId != null) || (this.trainId != null && !this.trainId.equals(other.trainId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Train[ trainId=" + trainId + " ]";
    }
    
}
