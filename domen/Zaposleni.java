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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Katarina
 */
@Entity
@Table(name = "zaposleni")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zaposleni.findAll", query = "SELECT z FROM Zaposleni z")
    , @NamedQuery(name = "Zaposleni.findByZaposleniId", query = "SELECT z FROM Zaposleni z WHERE z.zaposleniId = :zaposleniId")
    , @NamedQuery(name = "Zaposleni.findByIme", query = "SELECT z FROM Zaposleni z WHERE z.ime = :ime")
    , @NamedQuery(name = "Zaposleni.findByPrezime", query = "SELECT z FROM Zaposleni z WHERE z.prezime = :prezime")
    , @NamedQuery(name = "Zaposleni.findByJmbg", query = "SELECT z FROM Zaposleni z WHERE z.jmbg = :jmbg")
    , @NamedQuery(name = "Zaposleni.findByUsername", query = "SELECT z FROM Zaposleni z WHERE z.username = :username")
    , @NamedQuery(name = "Zaposleni.findByPassword", query = "SELECT z FROM Zaposleni z WHERE z.password = :password")})
public class Zaposleni implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ZaposleniId")
    private Integer zaposleniId;
    @Size(max = 150)
    @Column(name = "Ime")
    private String ime;
    @Size(max = 150)
    @Column(name = "Prezime")
    private String prezime;
    @Size(max = 15)
    @Column(name = "JMBG")
    private String jmbg;
    @Size(max = 50)
    @Column(name = "Username")
    private String username;
    @Size(max = 50)
    @Column(name = "Password")
    private String password;
    
    @JoinColumn(name = "Tip", referencedColumnName = "TipID")
    @ManyToOne
    private Tip tip;
  
    public Zaposleni() {
    }

    public Zaposleni(Integer zaposleniId) {
        this.zaposleniId = zaposleniId;
    }

    public Integer getZaposleniId() {
        return zaposleniId;
    }

    public void setZaposleniId(Integer zaposleniId) {
        this.zaposleniId = zaposleniId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  

    public Tip getTip() {
        return tip;
    }

    public void setTip(Tip tip) {
        this.tip = tip;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zaposleniId != null ? zaposleniId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zaposleni)) {
            return false;
        }
        Zaposleni other = (Zaposleni) object;
        if ((this.zaposleniId == null && other.zaposleniId != null) || (this.zaposleniId != null && !this.zaposleniId.equals(other.zaposleniId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sb.racun.Zaposleni[ zaposleniId=" + zaposleniId + " ]";
    }
    
}
