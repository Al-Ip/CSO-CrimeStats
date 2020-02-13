/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;

/**
 *
 * @author alexi
 */
@Entity
@Table(name = "userreports")
@NamedQueries({
    @NamedQuery(name = "Userreports.findAll", query = "SELECT u FROM Userreports u")})
public class Userreports implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Region")
    private String region;
    @Basic(optional = false)
    @Column(name = "GardaDivision")
    private String gardaDivision;
    @Basic(optional = false)
    @Column(name = "OffenceCode")
    private int offenceCode;
    @Basic(optional = false)
    @Column(name = "Offence")
    private String offence;
    @Basic(optional = false)
    @Column(name = "TypeOfOffence")
    private String typeOfOffence;
    @Basic(optional = false)
    @Column(name = "Date")
    private String date;
    @Basic(optional = false)
    @Column(name = "numOfOffences")
    private int numOfOffences;

    public Userreports() {
    }

    public Userreports(Integer id) {
        this.id = id;
    }
    
    public Userreports(String region, String gardaDivision, int offenceCode, String offence, String typeOfOffence, String date, int numOfOffences) {
        this.region = region;
        this.gardaDivision = gardaDivision;
        this.offenceCode = offenceCode;
        this.offence = offence;
        this.typeOfOffence = typeOfOffence;
        this.date = date;
        this.numOfOffences = numOfOffences;
    }

    public Userreports(Integer id, String region, String gardaDivision, int offenceCode, String offence, String typeOfOffence, String date, int numOfOffences) {
        this.id = id;
        this.region = region;
        this.gardaDivision = gardaDivision;
        this.offenceCode = offenceCode;
        this.offence = offence;
        this.typeOfOffence = typeOfOffence;
        this.date = date;
        this.numOfOffences = numOfOffences;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        String oldRegion = this.region;
        this.region = region;
        changeSupport.firePropertyChange("region", oldRegion, region);
    }

    public String getGardaDivision() {
        return gardaDivision;
    }

    public void setGardaDivision(String gardaDivision) {
        String oldGardaDivision = this.gardaDivision;
        this.gardaDivision = gardaDivision;
        changeSupport.firePropertyChange("gardaDivision", oldGardaDivision, gardaDivision);
    }

    public int getOffenceCode() {
        return offenceCode;
    }

    public void setOffenceCode(int offenceCode) {
        int oldOffenceCode = this.offenceCode;
        this.offenceCode = offenceCode;
        changeSupport.firePropertyChange("offenceCode", oldOffenceCode, offenceCode);
    }

    public String getOffence() {
        return offence;
    }

    public void setOffence(String offence) {
        String oldOffence = this.offence;
        this.offence = offence;
        changeSupport.firePropertyChange("offence", oldOffence, offence);
    }

    public String getTypeOfOffence() {
        return typeOfOffence;
    }

    public void setTypeOfOffence(String typeOfOffence) {
        String oldTypeOfOffence = this.typeOfOffence;
        this.typeOfOffence = typeOfOffence;
        changeSupport.firePropertyChange("typeOfOffence", oldTypeOfOffence, typeOfOffence);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        String oldDate = this.date;
        this.date = date;
        changeSupport.firePropertyChange("date", oldDate, date);
    }

    public int getNumOfOffences() {
        return numOfOffences;
    }

    public void setNumOfOffences(int numOfOffences) {
        int oldNumOfOffences = this.numOfOffences;
        this.numOfOffences = numOfOffences;
        changeSupport.firePropertyChange("numOfOffences", oldNumOfOffences, numOfOffences);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userreports)) {
            return false;
        }
        Userreports other = (Userreports) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.Userreports[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
