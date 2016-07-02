/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donem.odevi.test;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bogdanovic44
 */
@Entity
@Table(name = "RANDEVU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Randevu.findAll", query = "SELECT r FROM Randevu r"),
    @NamedQuery(name = "Randevu.findByKullanici", query = "SELECT r FROM Randevu r WHERE r.kullanici = :kullanici"),
    @NamedQuery(name = "Randevu.findByRandevuKodu", query = "SELECT r FROM Randevu r WHERE r.randevuKodu = :randevuKodu")})
public class Randevu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "KULLANICI")
    private String kullanici;
    @Id
    @Basic(optional = false)
    @Column(name = "RANDEVU_KODU")
    private Integer randevuKodu;

    public Randevu() {
    }

    public Randevu(Integer randevuKodu) {
        this.randevuKodu = randevuKodu;
    }

    public String getKullanici() {
        return kullanici;
    }

    public void setKullanici(String kullanici) {
        this.kullanici = kullanici;
    }

    public Integer getRandevuKodu() {
        return randevuKodu;
    }

    public void setRandevuKodu(Integer randevuKodu) {
        this.randevuKodu = randevuKodu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (randevuKodu != null ? randevuKodu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Randevu)) {
            return false;
        }
        Randevu other = (Randevu) object;
        if ((this.randevuKodu == null && other.randevuKodu != null) || (this.randevuKodu != null && !this.randevuKodu.equals(other.randevuKodu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "donem.odevi.test.Randevu[ randevuKodu=" + randevuKodu + " ]";
    }
    
}
