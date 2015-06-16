/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "BASE_XZQHXX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BaseXzqhxx.findAll", query = "SELECT b FROM BaseXzqhxx b"),
    @NamedQuery(name = "BaseXzqhxx.findByXh", query = "SELECT b FROM BaseXzqhxx b WHERE b.xh = :xh"),
    @NamedQuery(name = "BaseXzqhxx.findByXzqhid", query = "SELECT b FROM BaseXzqhxx b WHERE b.xzqhid = :xzqhid"),
    @NamedQuery(name = "BaseXzqhxx.findByXzqhbm", query = "SELECT b FROM BaseXzqhxx b WHERE b.xzqhbm = :xzqhbm"),
    @NamedQuery(name = "BaseXzqhxx.findByXzqhmc", query = "SELECT b FROM BaseXzqhxx b WHERE b.xzqhmc = :xzqhmc"),
    @NamedQuery(name = "BaseXzqhxx.findByXzjb", query = "SELECT b FROM BaseXzqhxx b WHERE b.xzjb = :xzjb"),
    @NamedQuery(name = "BaseXzqhxx.findBySjxzqhid", query = "SELECT b FROM BaseXzqhxx b WHERE b.sjxzqhid = :sjxzqhid"),
    @NamedQuery(name = "BaseXzqhxx.findByZt", query = "SELECT b FROM BaseXzqhxx b WHERE b.zt = :zt"),
    @NamedQuery(name = "BaseXzqhxx.findByZllx", query = "SELECT b FROM BaseXzqhxx b WHERE b.zllx = :zllx"),
    @NamedQuery(name = "BaseXzqhxx.findByCzsj", query = "SELECT b FROM BaseXzqhxx b WHERE b.czsj = :czsj"),
    @NamedQuery(name = "BaseXzqhxx.findByCtime", query = "SELECT b FROM BaseXzqhxx b WHERE b.ctime = :ctime"),
    @NamedQuery(name = "BaseXzqhxx.findByOper", query = "SELECT b FROM BaseXzqhxx b WHERE b.oper = :oper")})
public class BaseXzqhxx implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "XH")
    private Integer xh;
    @Id
    @Basic(optional = false)
    @Column(name = "XZQHID")
    private String xzqhid;
    @Column(name = "XZQHBM")
    private String xzqhbm;
    @Column(name = "XZQHMC")
    private String xzqhmc;
    @Column(name = "XZJB")
    private String xzjb;
    @Column(name = "SJXZQHID")
    private String sjxzqhid;
    @Column(name = "ZT")
    private String zt;
    @Column(name = "ZLLX")
    private String zllx;
    @Column(name = "CZSJ")
    private String czsj;
    @Column(name = "CTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ctime;
    @Column(name = "OPER")
    private String oper;

    public BaseXzqhxx() {
    }

    public BaseXzqhxx(String xzqhid) {
        this.xzqhid = xzqhid;
    }

    public Integer getXh() {
        return xh;
    }

    public void setXh(Integer xh) {
        this.xh = xh;
    }

    public String getXzqhid() {
        return xzqhid;
    }

    public void setXzqhid(String xzqhid) {
        this.xzqhid = xzqhid;
    }

    public String getXzqhbm() {
        return xzqhbm;
    }

    public void setXzqhbm(String xzqhbm) {
        this.xzqhbm = xzqhbm;
    }

    public String getXzqhmc() {
        return xzqhmc;
    }

    public void setXzqhmc(String xzqhmc) {
        this.xzqhmc = xzqhmc;
    }

    public String getXzjb() {
        return xzjb;
    }

    public void setXzjb(String xzjb) {
        this.xzjb = xzjb;
    }

    public String getSjxzqhid() {
        return sjxzqhid;
    }

    public void setSjxzqhid(String sjxzqhid) {
        this.sjxzqhid = sjxzqhid;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getZllx() {
        return zllx;
    }

    public void setZllx(String zllx) {
        this.zllx = zllx;
    }

    public String getCzsj() {
        return czsj;
    }

    public void setCzsj(String czsj) {
        this.czsj = czsj;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (xzqhid != null ? xzqhid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BaseXzqhxx)) {
            return false;
        }
        BaseXzqhxx other = (BaseXzqhxx) object;
        if ((this.xzqhid == null && other.xzqhid != null) || (this.xzqhid != null && !this.xzqhid.equals(other.xzqhid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BaseXzqhxx[ xzqhid=" + xzqhid + " ]";
    }
    
}
