/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.model;

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
 * @author Administrator
 */
@Entity
@Table(name = "CCS_FAMILYINFO", catalog = "", schema = "SWITCHING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CcsFamilyinfo.findAll", query = "SELECT c FROM CcsFamilyinfo c"),
    @NamedQuery(name = "CcsFamilyinfo.findByJtbm", query = "SELECT c FROM CcsFamilyinfo c WHERE c.jtbm = :jtbm"),
    @NamedQuery(name = "CcsFamilyinfo.findByHzsfzh", query = "SELECT c FROM CcsFamilyinfo c WHERE c.hzsfzh = :hzsfzh"),
    @NamedQuery(name = "CcsFamilyinfo.findByHzxm", query = "SELECT c FROM CcsFamilyinfo c WHERE c.hzxm = :hzxm"),
    @NamedQuery(name = "CcsFamilyinfo.findByJtrk", query = "SELECT c FROM CcsFamilyinfo c WHERE c.jtrk = :jtrk"),
    @NamedQuery(name = "CcsFamilyinfo.findByJtsr", query = "SELECT c FROM CcsFamilyinfo c WHERE c.jtsr = :jtsr"),
    @NamedQuery(name = "CcsFamilyinfo.findByJtzc", query = "SELECT c FROM CcsFamilyinfo c WHERE c.jtzc = :jtzc"),
    @NamedQuery(name = "CcsFamilyinfo.findByZt", query = "SELECT c FROM CcsFamilyinfo c WHERE c.zt = :zt"),
    @NamedQuery(name = "CcsFamilyinfo.findByBgsj", query = "SELECT c FROM CcsFamilyinfo c WHERE c.bgsj = :bgsj"),
    @NamedQuery(name = "CcsFamilyinfo.findByZrowid", query = "SELECT c FROM CcsFamilyinfo c WHERE c.zrowid = :zrowid")})
public class CcsFamilyinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(length = 128)
    private String jtbm;
    @Column(length = 128)
    private String hzsfzh;
    @Column(length = 128)
    private String hzxm;
    @Column(length = 128)
    private String jtrk;
    @Column(length = 128)
    private String jtsr;
    @Column(length = 128)
    private String jtzc;
    @Column(length = 128)
    private String zt;
    @Column(length = 128)
    private String bgsj;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 128)
    private String zrowid;

    public CcsFamilyinfo() {
    }

    public CcsFamilyinfo(String zrowid) {
        this.zrowid = zrowid;
    }

    public String getJtbm() {
        return jtbm;
    }

    public void setJtbm(String jtbm) {
        this.jtbm = jtbm;
    }

    public String getHzsfzh() {
        return hzsfzh;
    }

    public void setHzsfzh(String hzsfzh) {
        this.hzsfzh = hzsfzh;
    }

    public String getHzxm() {
        return hzxm;
    }

    public void setHzxm(String hzxm) {
        this.hzxm = hzxm;
    }

    public String getJtrk() {
        return jtrk;
    }

    public void setJtrk(String jtrk) {
        this.jtrk = jtrk;
    }

    public String getJtsr() {
        return jtsr;
    }

    public void setJtsr(String jtsr) {
        this.jtsr = jtsr;
    }

    public String getJtzc() {
        return jtzc;
    }

    public void setJtzc(String jtzc) {
        this.jtzc = jtzc;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getBgsj() {
        return bgsj;
    }

    public void setBgsj(String bgsj) {
        this.bgsj = bgsj;
    }

    public String getZrowid() {
        return zrowid;
    }

    public void setZrowid(String zrowid) {
        this.zrowid = zrowid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zrowid != null ? zrowid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CcsFamilyinfo)) {
            return false;
        }
        CcsFamilyinfo other = (CcsFamilyinfo) object;
        if ((this.zrowid == null && other.zrowid != null) || (this.zrowid != null && !this.zrowid.equals(other.zrowid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.CcsFamilyinfo[ zrowid=" + zrowid + " ]";
    }
    
}
