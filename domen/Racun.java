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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Katarina
 */
@Entity
@Table(name = "racun")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Racun.findAll", query = "SELECT r FROM Racun r")
    , @NamedQuery(name = "Racun.findByBrojRacuna", query = "SELECT r FROM Racun r WHERE r.brojRacuna = :brojRacuna")
    , @NamedQuery(name = "Racun.findByUkupanIznos", query = "SELECT r FROM Racun r WHERE r.ukupanIznos = :ukupanIznos")
    , @NamedQuery(name = "Racun.findByDatum", query = "SELECT r FROM Racun r WHERE r.datum = :datum")
    , @NamedQuery(name = "Racun.findByRBRacuna", query = "SELECT r FROM Racun r WHERE r.rBRacuna = :rBRacuna")})
public class Racun implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
   
    @Column(name = "BrojRacuna")
    private Integer brojRacuna;

    @Column(name = "UkupanIznos")
    private Double ukupanIznos;
    @Column(name = "Datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Column(name = "RBRacuna")
    private Integer rBRacuna;
   
    @JoinColumn(name = "Zaposleni", referencedColumnName = "ZaposleniId")
    @ManyToOne
    private Zaposleni zaposleni;
    @JoinColumn(name = "Trosak", referencedColumnName = "TrosakID")
    @ManyToOne
    private Trosak trosak;

    public Racun() {
    }

    public Racun(Integer brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public Integer getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(Integer brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public Double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(Double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Integer getRBRacuna() {
        return rBRacuna;
    }

    public void setRBRacuna(Integer rBRacuna) {
        this.rBRacuna = rBRacuna;
    }

  
    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public Trosak getTrosak() {
        return trosak;
    }

    public void setTrosak(Trosak trosak) {
        this.trosak = trosak;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (brojRacuna != null ? brojRacuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Racun)) {
            return false;
        }
        Racun other = (Racun) object;
        if ((this.brojRacuna == null && other.brojRacuna != null) || (this.brojRacuna != null && !this.brojRacuna.equals(other.brojRacuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sb.racun.Racun[ brojRacuna=" + brojRacuna + " ]";
    }
    
}
