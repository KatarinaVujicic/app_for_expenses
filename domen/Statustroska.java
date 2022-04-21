/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Katarina
 */
@Entity
@Table(name = "statustroska")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Statustroska.findAll", query = "SELECT s FROM Statustroska s")
    , @NamedQuery(name = "Statustroska.findByStatusID", query = "SELECT s FROM Statustroska s WHERE s.statusID = :statusID")
    , @NamedQuery(name = "Statustroska.findByNaziv", query = "SELECT s FROM Statustroska s WHERE s.naziv = :naziv")})
public class Statustroska implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "StatusID")
    private Integer statusID;
    @Size(max = 150)
    @Column(name = "Naziv")
    private String naziv;
  

    public Statustroska() {
    }

    public Statustroska(Integer statusID) {
        this.statusID = statusID;
    }

    public Integer getStatusID() {
        return statusID;
    }

    public void setStatusID(Integer statusID) {
        this.statusID = statusID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusID != null ? statusID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statustroska)) {
            return false;
        }
        Statustroska other = (Statustroska) object;
        if ((this.statusID == null && other.statusID != null) || (this.statusID != null && !this.statusID.equals(other.statusID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sb.racun.Statustroska[ statusID=" + statusID + " ]";
    }
    
}
