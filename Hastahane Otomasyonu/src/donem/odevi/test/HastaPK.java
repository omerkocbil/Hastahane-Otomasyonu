/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donem.odevi.test;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Bogdanovic44
 */
@Embeddable
public class HastaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "HASTA_ID")
    private int hastaId;
    @Basic(optional = false)
    @Column(name = "KULLANICI_ADI")
    private String kullaniciAdi;

    public HastaPK() {
    }

    public HastaPK(int hastaId, String kullaniciAdi) {
        this.hastaId = hastaId;
        this.kullaniciAdi = kullaniciAdi;
    }

    public int getHastaId() {
        return hastaId;
    }

    public void setHastaId(int hastaId) {
        this.hastaId = hastaId;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) hastaId;
        hash += (kullaniciAdi != null ? kullaniciAdi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HastaPK)) {
            return false;
        }
        HastaPK other = (HastaPK) object;
        if (this.hastaId != other.hastaId) {
            return false;
        }
        if ((this.kullaniciAdi == null && other.kullaniciAdi != null) || (this.kullaniciAdi != null && !this.kullaniciAdi.equals(other.kullaniciAdi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "donem.odevi.test.HastaPK[ hastaId=" + hastaId + ", kullaniciAdi=" + kullaniciAdi + " ]";
    }
    
}
