/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Katarina
 */
@Entity
@Table(name = "trosak")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trosak.findAll", query = "SELECT t FROM Trosak t")
    , @NamedQuery(name = "Trosak.findByTrosakID", query = "SELECT t FROM Trosak t WHERE t.trosakID = :trosakID")
    , @NamedQuery(name = "Trosak.findByNaziv", query = "SELECT t FROM Trosak t WHERE t.naziv = :naziv")
    , @NamedQuery(name = "Trosak.findByDatum", query = "SELECT t FROM Trosak t WHERE t.datum = :datum")
    , @NamedQuery(name = "Trosak.findByOpis", query = "SELECT t FROM Trosak t WHERE t.opis = :opis")})
public class Trosak implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TrosakID")
    private Integer trosakID;
    @Size(max = 150)
    @Column(name = "Naziv")
    private String naziv;
    @Column(name = "Datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Size(max = 500)
    @Column(name = "Opis")
    private String opis;
    @JoinColumn(name = "VrstaTroska", referencedColumnName = "VrstaTroskaID")
    @ManyToOne
    private Vrstatroska vrstaTroska;
    @JoinColumn(name = "Zaposleni", referencedColumnName = "ZaposleniId")
    @ManyToOne
    private Zaposleni zaposleni;
    @JoinColumn(name = "StatusTroska", referencedColumnName = "StatusID")
    @ManyToOne
    private Statustroska statusTroska;
   

    public Trosak() {
    }

    public Trosak(Integer trosakID) {
        this.trosakID = trosakID;
    }

    public Integer getTrosakID() {
        return trosakID;
    }

    public void setTrosakID(Integer trosakID) {
        this.trosakID = trosakID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Vrstatroska getVrstaTroska() {
        return vrstaTroska;
    }

    public void setVrstaTroska(Vrstatroska vrstaTroska) {
        this.vrstaTroska = vrstaTroska;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public Statustroska getStatusTroska() {
        return statusTroska;
    }

    public void setStatusTroska(Statustroska statusTroska) {
        this.statusTroska = statusTroska;
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trosakID != null ? trosakID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trosak)) {
            return false;
        }
        Trosak other = (Trosak) object;
        if ((this.trosakID == null && other.trosakID != null) || (this.trosakID != null && !this.trosakID.equals(other.trosakID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sb.racun.Trosak[ trosakID=" + trosakID + " ]";
    }
    
}
