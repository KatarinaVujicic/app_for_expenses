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
@Table(name = "tip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tip.findAll", query = "SELECT t FROM Tip t")
    , @NamedQuery(name = "Tip.findByTipID", query = "SELECT t FROM Tip t WHERE t.tipID = :tipID")
    , @NamedQuery(name = "Tip.findByNaziv", query = "SELECT t FROM Tip t WHERE t.naziv = :naziv")})
public class Tip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TipID")
    private Integer tipID;
    @Size(max = 150)
    @Column(name = "Naziv")
    private String naziv;
    @OneToMany(mappedBy = "tip")
    private List<Zaposleni> zaposleniList;

    public Tip() {
    }

    public Tip(Integer tipID) {
        this.tipID = tipID;
    }

    public Integer getTipID() {
        return tipID;
    }

    public void setTipID(Integer tipID) {
        this.tipID = tipID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @XmlTransient
    public List<Zaposleni> getZaposleniList() {
        return zaposleniList;
    }

    public void setZaposleniList(List<Zaposleni> zaposleniList) {
        this.zaposleniList = zaposleniList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipID != null ? tipID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tip)) {
            return false;
        }
        Tip other = (Tip) object;
        if ((this.tipID == null && other.tipID != null) || (this.tipID != null && !this.tipID.equals(other.tipID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sb.racun.Tip[ tipID=" + tipID + " ]";
    }
    
}
