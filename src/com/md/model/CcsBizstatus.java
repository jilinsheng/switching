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
@Table(name = "CCS_BIZSTATUS", catalog = "", schema = "SWITCHING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CcsBizstatus.findAll", query = "SELECT c FROM CcsBizstatus c"),
    @NamedQuery(name = "CcsBizstatus.findByJtbm", query = "SELECT c FROM CcsBizstatus c WHERE c.jtbm = :jtbm"),
    @NamedQuery(name = "CcsBizstatus.findByHzsfzh", query = "SELECT c FROM CcsBizstatus c WHERE c.hzsfzh = :hzsfzh"),
    @NamedQuery(name = "CcsBizstatus.findByHzxm", query = "SELECT c FROM CcsBizstatus c WHERE c.hzxm = :hzxm"),
    @NamedQuery(name = "CcsBizstatus.findByJzyw", query = "SELECT c FROM CcsBizstatus c WHERE c.jzyw = :jzyw"),
    @NamedQuery(name = "CcsBizstatus.findByKssj", query = "SELECT c FROM CcsBizstatus c WHERE c.kssj = :kssj"),
    @NamedQuery(name = "CcsBizstatus.findByJzj", query = "SELECT c FROM CcsBizstatus c WHERE c.jzj = :jzj"),
    @NamedQuery(name = "CcsBizstatus.findByJzrk", query = "SELECT c FROM CcsBizstatus c WHERE c.jzrk = :jzrk"),
    @NamedQuery(name = "CcsBizstatus.findByJzyf", query = "SELECT c FROM CcsBizstatus c WHERE c.jzyf = :jzyf"),
    @NamedQuery(name = "CcsBizstatus.findByYwms", query = "SELECT c FROM CcsBizstatus c WHERE c.ywms = :ywms"),
    @NamedQuery(name = "CcsBizstatus.findByBgsj", query = "SELECT c FROM CcsBizstatus c WHERE c.bgsj = :bgsj"),
    @NamedQuery(name = "CcsBizstatus.findByZrowid", query = "SELECT c FROM CcsBizstatus c WHERE c.zrowid = :zrowid")})
public class CcsBizstatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(length = 128)
    private String jtbm;
    @Column(length = 128)
    private String hzsfzh;
    @Column(length = 128)
    private String hzxm;
    @Column(length = 128)
    private String jzyw;
    @Column(length = 128)
    private String kssj;
    @Column(length = 128)
    private String jzj;
    @Column(length = 128)
    private String jzrk;
    @Column(length = 128)
    private String jzyf;
    @Column(length = 128)
    private String ywms;
    @Column(length = 128)
    private String bgsj;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 128)
    private String zrowid;

    public CcsBizstatus() {
    }

    public CcsBizstatus(String zrowid) {
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

    public String getJzyw() {
        return jzyw;
    }

    public void setJzyw(String jzyw) {
        this.jzyw = jzyw;
    }

    public String getKssj() {
        return kssj;
    }

    public void setKssj(String kssj) {
        this.kssj = kssj;
    }

    public String getJzj() {
        return jzj;
    }

    public void setJzj(String jzj) {
        this.jzj = jzj;
    }

    public String getJzrk() {
        return jzrk;
    }

    public void setJzrk(String jzrk) {
        this.jzrk = jzrk;
    }

    public String getJzyf() {
        return jzyf;
    }

    public void setJzyf(String jzyf) {
        this.jzyf = jzyf;
    }

    public String getYwms() {
        return ywms;
    }

    public void setYwms(String ywms) {
        this.ywms = ywms;
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
        if (!(object instanceof CcsBizstatus)) {
            return false;
        }
        CcsBizstatus other = (CcsBizstatus) object;
        if ((this.zrowid == null && other.zrowid != null) || (this.zrowid != null && !this.zrowid.equals(other.zrowid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.CcsBizstatus[ zrowid=" + zrowid + " ]";
    }
    
}
