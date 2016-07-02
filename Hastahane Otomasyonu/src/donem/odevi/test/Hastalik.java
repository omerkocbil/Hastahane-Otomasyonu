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
@Table(name = "HASTALIK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hastalik.findAll", query = "SELECT h FROM Hastalik h"),
    @NamedQuery(name = "Hastalik.findByAd", query = "SELECT h FROM Hastalik h WHERE h.ad = :ad"),
    @NamedQuery(name = "Hastalik.findByBelirti1", query = "SELECT h FROM Hastalik h WHERE h.belirti1 = :belirti1"),
    @NamedQuery(name = "Hastalik.findByBelirti2", query = "SELECT h FROM Hastalik h WHERE h.belirti2 = :belirti2"),
    @NamedQuery(name = "Hastalik.findByBelirti3", query = "SELECT h FROM Hastalik h WHERE h.belirti3 = :belirti3"),
    @NamedQuery(name = "Hastalik.findByBelirti4", query = "SELECT h FROM Hastalik h WHERE h.belirti4 = :belirti4")})
public class Hastalik implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "AD")
    private String ad;
    @Column(name = "BELIRTI_1")
    private String belirti1;
    @Column(name = "BELIRTI_2")
    private String belirti2;
    @Column(name = "BELIRTI_3")
    private String belirti3;
    @Column(name = "BELIRTI_4")
    private String belirti4;

    public Hastalik() {
    }

    public Hastalik(String ad) {
        this.ad = ad;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getBelirti1() {
        return belirti1;
    }

    public void setBelirti1(String belirti1) {
        this.belirti1 = belirti1;
    }

    public String getBelirti2() {
        return belirti2;
    }

    public void setBelirti2(String belirti2) {
        this.belirti2 = belirti2;
    }

    public String getBelirti3() {
        return belirti3;
    }

    public void setBelirti3(String belirti3) {
        this.belirti3 = belirti3;
    }

    public String getBelirti4() {
        return belirti4;
    }

    public void setBelirti4(String belirti4) {
        this.belirti4 = belirti4;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ad != null ? ad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hastalik)) {
            return false;
        }
        Hastalik other = (Hastalik) object;
        if ((this.ad == null && other.ad != null) || (this.ad != null && !this.ad.equals(other.ad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "donem.odevi.test.Hastalik[ ad=" + ad + " ]";
    }
    
}
