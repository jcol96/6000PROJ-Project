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
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByUserEmail", query = "SELECT u FROM Users u WHERE u.userEmail = :userEmail")
    , @NamedQuery(name = "Users.findByUserPassword", query = "SELECT u FROM Users u WHERE u.userPassword = :userPassword")
    , @NamedQuery(name = "Users.findByUserFirstname", query = "SELECT u FROM Users u WHERE u.userFirstname = :userFirstname")
    , @NamedQuery(name = "Users.findByUserSurname", query = "SELECT u FROM Users u WHERE u.userSurname = :userSurname")
    , @NamedQuery(name = "Users.findByUserHometown", query = "SELECT u FROM Users u WHERE u.userHometown = :userHometown")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "user_email")
    private String userEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "user_password")
    private String userPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "user_firstname")
    private String userFirstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "user_surname")
    private String userSurname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "user_hometown")
    private String userHometown;

    public Users() {
    }

    public Users(String userEmail) {
        this.userEmail = userEmail;
    }

    public Users(String userEmail, String userPassword, String userFirstname, String userSurname, String userHometown) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userFirstname = userFirstname;
        this.userSurname = userSurname;
        this.userHometown = userHometown;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserFirstname() {
        return userFirstname;
    }

    public void setUserFirstname(String userFirstname) {
        this.userFirstname = userFirstname;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserHometown() {
        return userHometown;
    }

    public void setUserHometown(String userHometown) {
        this.userHometown = userHometown;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userEmail != null ? userEmail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userEmail == null && other.userEmail != null) || (this.userEmail != null && !this.userEmail.equals(other.userEmail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Users[ userEmail=" + userEmail + " ]";
    }
    
}
