/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donem.odevi.test;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bogdanovic44
 */
@Entity
@Table(name = "HASTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hasta.findAll", query = "SELECT h FROM Hasta h"),
    @NamedQuery(name = "Hasta.findByHastaId", query = "SELECT h FROM Hasta h WHERE h.hastaPK.hastaId = :hastaId"),
    @NamedQuery(name = "Hasta.findByAd", query = "SELECT h FROM Hasta h WHERE h.ad = :ad"),
    @NamedQuery(name = "Hasta.findBySoyad", query = "SELECT h FROM Hasta h WHERE h.soyad = :soyad"),
    @NamedQuery(name = "Hasta.findByKullaniciAdi", query = "SELECT h FROM Hasta h WHERE h.hastaPK.kullaniciAdi = :kullaniciAdi"),
    @NamedQuery(name = "Hasta.findBySifre", query = "SELECT h FROM Hasta h WHERE h.sifre = :sifre"),
    @NamedQuery(name = "Hasta.findByYas", query = "SELECT h FROM Hasta h WHERE h.yas = :yas"),
    @NamedQuery(name = "Hasta.findByHastaliK1", query = "SELECT h FROM Hasta h WHERE h.hastaliK1 = :hastaliK1"),
    @NamedQuery(name = "Hasta.findByHastaliK2", query = "SELECT h FROM Hasta h WHERE h.hastaliK2 = :hastaliK2"),
    @NamedQuery(name = "Hasta.findByHastaliK3", query = "SELECT h FROM Hasta h WHERE h.hastaliK3 = :hastaliK3"),
    @NamedQuery(name = "Hasta.findByIlac1", query = "SELECT h FROM Hasta h WHERE h.ilac1 = :ilac1"),
    @NamedQuery(name = "Hasta.findByIlac2", query = "SELECT h FROM Hasta h WHERE h.ilac2 = :ilac2"),
    @NamedQuery(name = "Hasta.findByIlac3", query = "SELECT h FROM Hasta h WHERE h.ilac3 = :ilac3"),
    @NamedQuery(name = "Hasta.findByIlac4", query = "SELECT h FROM Hasta h WHERE h.ilac4 = :ilac4"),
    @NamedQuery(name = "Hasta.findByIlac5", query = "SELECT h FROM Hasta h WHERE h.ilac5 = :ilac5"),
    @NamedQuery(name = "Hasta.findByIlac6", query = "SELECT h FROM Hasta h WHERE h.ilac6 = :ilac6"),
    @NamedQuery(name = "Hasta.findByIlac7", query = "SELECT h FROM Hasta h WHERE h.ilac7 = :ilac7"),
    @NamedQuery(name = "Hasta.findByIlac8", query = "SELECT h FROM Hasta h WHERE h.ilac8 = :ilac8"),
    @NamedQuery(name = "Hasta.findByIlac9", query = "SELECT h FROM Hasta h WHERE h.ilac9 = :ilac9")})
public class Hasta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HastaPK hastaPK;
    @Column(name = "AD")
    private String ad;
    @Column(name = "SOYAD")
    private String soyad;
    @Column(name = "SIFRE")
    private String sifre;
    @Column(name = "YAS")
    private Integer yas;
    @Column(name = "HASTALIK_1")
    private String hastaliK1;
    @Column(name = "HASTALIK_2")
    private String hastaliK2;
    @Column(name = "HASTALIK_3")
    private String hastaliK3;
    @Column(name = "ILAC_1")
    private String ilac1;
    @Column(name = "ILAC_2")
    private String ilac2;
    @Column(name = "ILAC_3")
    private String ilac3;
    @Column(name = "ILAC_4")
    private String ilac4;
    @Column(name = "ILAC_5")
    private String ilac5;
    @Column(name = "ILAC_6")
    private String ilac6;
    @Column(name = "ILAC_7")
    private String ilac7;
    @Column(name = "ILAC_8")
    private String ilac8;
    @Column(name = "ILAC_9")
    private String ilac9;

    public Hasta() {
    }

    public Hasta(HastaPK hastaPK) {
        this.hastaPK = hastaPK;
    }

    public Hasta(int hastaId, String kullaniciAdi) {
        this.hastaPK = new HastaPK(hastaId, kullaniciAdi);
    }

    public HastaPK getHastaPK() {
        return hastaPK;
    }

    public void setHastaPK(HastaPK hastaPK) {
        this.hastaPK = hastaPK;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public Integer getYas() {
        return yas;
    }

    public void setYas(Integer yas) {
        this.yas = yas;
    }

    public String getHastaliK1() {
        return hastaliK1;
    }

    public void setHastaliK1(String hastaliK1) {
        this.hastaliK1 = hastaliK1;
    }

    public String getHastaliK2() {
        return hastaliK2;
    }

    public void setHastaliK2(String hastaliK2) {
        this.hastaliK2 = hastaliK2;
    }

    public String getHastaliK3() {
        return hastaliK3;
    }

    public void setHastaliK3(String hastaliK3) {
        this.hastaliK3 = hastaliK3;
    }

    public String getIlac1() {
        return ilac1;
    }

    public void setIlac1(String ilac1) {
        this.ilac1 = ilac1;
    }

    public String getIlac2() {
        return ilac2;
    }

    public void setIlac2(String ilac2) {
        this.ilac2 = ilac2;
    }

    public String getIlac3() {
        return ilac3;
    }

    public void setIlac3(String ilac3) {
        this.ilac3 = ilac3;
    }

    public String getIlac4() {
        return ilac4;
    }

    public void setIlac4(String ilac4) {
        this.ilac4 = ilac4;
    }

    public String getIlac5() {
        return ilac5;
    }

    public void setIlac5(String ilac5) {
        this.ilac5 = ilac5;
    }

    public String getIlac6() {
        return ilac6;
    }

    public void setIlac6(String ilac6) {
        this.ilac6 = ilac6;
    }

    public String getIlac7() {
        return ilac7;
    }

    public void setIlac7(String ilac7) {
        this.ilac7 = ilac7;
    }

    public String getIlac8() {
        return ilac8;
    }

    public void setIlac8(String ilac8) {
        this.ilac8 = ilac8;
    }

    public String getIlac9() {
        return ilac9;
    }

    public void setIlac9(String ilac9) {
        this.ilac9 = ilac9;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hastaPK != null ? hastaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hasta)) {
            return false;
        }
        Hasta other = (Hasta) object;
        if ((this.hastaPK == null && other.hastaPK != null) || (this.hastaPK != null && !this.hastaPK.equals(other.hastaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "donem.odevi.test.Hasta[ hastaPK=" + hastaPK + " ]";
    }
    
}
