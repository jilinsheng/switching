/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "BIZ_GRFFXX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BizGrffxx.findAll", query = "SELECT b FROM BizGrffxx b"),
    @NamedQuery(name = "BizGrffxx.findByXh", query = "SELECT b FROM BizGrffxx b WHERE b.xh = :xh"),
    @NamedQuery(name = "BizGrffxx.findByGrffxxid", query = "SELECT b FROM BizGrffxx b WHERE b.grffxxid = :grffxxid"),
    @NamedQuery(name = "BizGrffxx.findByFfxxid", query = "SELECT b FROM BizGrffxx b WHERE b.ffxxid = :ffxxid"),
    @NamedQuery(name = "BizGrffxx.findByJtffxxid", query = "SELECT b FROM BizGrffxx b WHERE b.jtffxxid = :jtffxxid"),
    @NamedQuery(name = "BizGrffxx.findByZjjsxxid", query = "SELECT b FROM BizGrffxx b WHERE b.zjjsxxid = :zjjsxxid"),
    @NamedQuery(name = "BizGrffxx.findByFfje", query = "SELECT b FROM BizGrffxx b WHERE b.ffje = :ffje"),
    @NamedQuery(name = "BizGrffxx.findByRybm", query = "SELECT b FROM BizGrffxx b WHERE b.rybm = :rybm"),
    @NamedQuery(name = "BizGrffxx.findByZllx", query = "SELECT b FROM BizGrffxx b WHERE b.zllx = :zllx"),
    @NamedQuery(name = "BizGrffxx.findByCzsj", query = "SELECT b FROM BizGrffxx b WHERE b.czsj = :czsj"),
    @NamedQuery(name = "BizGrffxx.findByOXzqhbm", query = "SELECT b FROM BizGrffxx b WHERE b.oXzqhbm = :oXzqhbm")})
public class BizGrffxx implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "XH")
    private Long xh;
    @Id
    @Basic(optional = false)
    @Column(name = "GRFFXXID")
    private String grffxxid;
    @Column(name = "FFXXID")
    private String ffxxid;
    @Column(name = "JTFFXXID")
    private String jtffxxid;
    @Column(name = "ZJJSXXID")
    private String zjjsxxid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FFJE")
    private BigDecimal ffje;
    @Column(name = "RYBM")
    private String rybm;
    @Column(name = "ZLLX")
    private String zllx;
    @Column(name = "CZSJ")
    private String czsj;
    @Column(name = "O_XZQHBM")
    private String oXzqhbm;

    public BizGrffxx() {
    }

    public BizGrffxx(String grffxxid) {
        this.grffxxid = grffxxid;
    }

    public Long getXh() {
        return xh;
    }

    public void setXh(Long xh) {
        this.xh = xh;
    }

    public String getGrffxxid() {
        return grffxxid;
    }

    public void setGrffxxid(String grffxxid) {
        this.grffxxid = grffxxid;
    }

    public String getFfxxid() {
        return ffxxid;
    }

    public void setFfxxid(String ffxxid) {
        this.ffxxid = ffxxid;
    }

    public String getJtffxxid() {
        return jtffxxid;
    }

    public void setJtffxxid(String jtffxxid) {
        this.jtffxxid = jtffxxid;
    }

    public String getZjjsxxid() {
        return zjjsxxid;
    }

    public void setZjjsxxid(String zjjsxxid) {
        this.zjjsxxid = zjjsxxid;
    }

    public BigDecimal getFfje() {
        return ffje;
    }

    public void setFfje(BigDecimal ffje) {
        this.ffje = ffje;
    }

    public String getRybm() {
        return rybm;
    }

    public void setRybm(String rybm) {
        this.rybm = rybm;
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

    public String getOXzqhbm() {
        return oXzqhbm;
    }

    public void setOXzqhbm(String oXzqhbm) {
        this.oXzqhbm = oXzqhbm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grffxxid != null ? grffxxid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BizGrffxx)) {
            return false;
        }
        BizGrffxx other = (BizGrffxx) object;
        if ((this.grffxxid == null && other.grffxxid != null) || (this.grffxxid != null && !this.grffxxid.equals(other.grffxxid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BizGrffxx[ grffxxid=" + grffxxid + " ]";
    }
    
}
