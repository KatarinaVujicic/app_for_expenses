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
@Table(name = "vrstatroska")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vrstatroska.findAll", query = "SELECT v FROM Vrstatroska v")
    , @NamedQuery(name = "Vrstatroska.findByVrstaTroskaID", query = "SELECT v FROM Vrstatroska v WHERE v.vrstaTroskaID = :vrstaTroskaID")
    , @NamedQuery(name = "Vrstatroska.findByNaziv", query = "SELECT v FROM Vrstatroska v WHERE v.naziv = :naziv")})
public class Vrstatroska implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "VrstaTroskaID")
    private Integer vrstaTroskaID;
    @Size(max = 150)
    @Column(name = "Naziv")
    private String naziv;
  

    public Vrstatroska() {
    }

    public Vrstatroska(Integer vrstaTroskaID) {
        this.vrstaTroskaID = vrstaTroskaID;
    }

    public Integer getVrstaTroskaID() {
        return vrstaTroskaID;
    }

    public void setVrstaTroskaID(Integer vrstaTroskaID) {
        this.vrstaTroskaID = vrstaTroskaID;
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
        hash += (vrstaTroskaID != null ? vrstaTroskaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vrstatroska)) {
            return false;
        }
        Vrstatroska other = (Vrstatroska) object;
        if ((this.vrstaTroskaID == null && other.vrstaTroskaID != null) || (this.vrstaTroskaID != null && !this.vrstaTroskaID.equals(other.vrstaTroskaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sb.racun.Vrstatroska[ vrstaTroskaID=" + vrstaTroskaID + " ]";
    }
    
}
