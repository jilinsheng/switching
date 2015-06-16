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
@Table(name = "BIZ_FFXX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BizFfxx.findAll", query = "SELECT b FROM BizFfxx b"),
    @NamedQuery(name = "BizFfxx.findByXh", query = "SELECT b FROM BizFfxx b WHERE b.xh = :xh"),
    @NamedQuery(name = "BizFfxx.findByFfxxid", query = "SELECT b FROM BizFfxx b WHERE b.ffxxid = :ffxxid"),
    @NamedQuery(name = "BizFfxx.findByZjzhid", query = "SELECT b FROM BizFfxx b WHERE b.zjzhid = :zjzhid"),
    @NamedQuery(name = "BizFfxx.findByFfny", query = "SELECT b FROM BizFfxx b WHERE b.ffny = :ffny"),
    @NamedQuery(name = "BizFfxx.findByFfje", query = "SELECT b FROM BizFfxx b WHERE b.ffje = :ffje"),
    @NamedQuery(name = "BizFfxx.findByFfrs", query = "SELECT b FROM BizFfxx b WHERE b.ffrs = :ffrs"),
    @NamedQuery(name = "BizFfxx.findByFflx", query = "SELECT b FROM BizFfxx b WHERE b.fflx = :fflx"),
    @NamedQuery(name = "BizFfxx.findByJbr", query = "SELECT b FROM BizFfxx b WHERE b.jbr = :jbr"),
    @NamedQuery(name = "BizFfxx.findBySpr", query = "SELECT b FROM BizFfxx b WHERE b.spr = :spr"),
    @NamedQuery(name = "BizFfxx.findByFfzt", query = "SELECT b FROM BizFfxx b WHERE b.ffzt = :ffzt"),
    @NamedQuery(name = "BizFfxx.findByFffs", query = "SELECT b FROM BizFfxx b WHERE b.fffs = :fffs"),
    @NamedQuery(name = "BizFfxx.findByJzywbm", query = "SELECT b FROM BizFfxx b WHERE b.jzywbm = :jzywbm"),
    @NamedQuery(name = "BizFfxx.findByBz", query = "SELECT b FROM BizFfxx b WHERE b.bz = :bz"),
    @NamedQuery(name = "BizFfxx.findByCzy", query = "SELECT b FROM BizFfxx b WHERE b.czy = :czy"),
    @NamedQuery(name = "BizFfxx.findByJbjg", query = "SELECT b FROM BizFfxx b WHERE b.jbjg = :jbjg"),
    @NamedQuery(name = "BizFfxx.findByXzqhbm", query = "SELECT b FROM BizFfxx b WHERE b.xzqhbm = :xzqhbm"),
    @NamedQuery(name = "BizFfxx.findByZllx", query = "SELECT b FROM BizFfxx b WHERE b.zllx = :zllx"),
    @NamedQuery(name = "BizFfxx.findByCzsj", query = "SELECT b FROM BizFfxx b WHERE b.czsj = :czsj")})
public class BizFfxx implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "XH")
    private Long xh;
    @Id
    @Basic(optional = false)
    @Column(name = "FFXXID")
    private String ffxxid;
    @Column(name = "ZJZHID")
    private String zjzhid;
    @Column(name = "FFNY")
    private String ffny;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FFJE")
    private BigDecimal ffje;
    @Column(name = "FFRS")
    private Integer ffrs;
    @Column(name = "FFLX")
    private String fflx;
    @Column(name = "JBR")
    private String jbr;
    @Column(name = "SPR")
    private String spr;
    @Column(name = "FFZT")
    private Character ffzt;
    @Column(name = "FFFS")
    private String fffs;
    @Column(name = "JZYWBM")
    private String jzywbm;
    @Column(name = "BZ")
    private String bz;
    @Column(name = "CZY")
    private String czy;
    @Column(name = "JBJG")
    private String jbjg;
    @Column(name = "XZQHBM")
    private String xzqhbm;
    @Column(name = "ZLLX")
    private String zllx;
    @Column(name = "CZSJ")
    private String czsj;

    public BizFfxx() {
    }

    public BizFfxx(String ffxxid) {
        this.ffxxid = ffxxid;
    }

    public Long getXh() {
        return xh;
    }

    public void setXh(Long xh) {
        this.xh = xh;
    }

    public String getFfxxid() {
        return ffxxid;
    }

    public void setFfxxid(String ffxxid) {
        this.ffxxid = ffxxid;
    }

    public String getZjzhid() {
        return zjzhid;
    }

    public void setZjzhid(String zjzhid) {
        this.zjzhid = zjzhid;
    }

    public String getFfny() {
        return ffny;
    }

    public void setFfny(String ffny) {
        this.ffny = ffny;
    }

    public BigDecimal getFfje() {
        return ffje;
    }

    public void setFfje(BigDecimal ffje) {
        this.ffje = ffje;
    }

    public Integer getFfrs() {
        return ffrs;
    }

    public void setFfrs(Integer ffrs) {
        this.ffrs = ffrs;
    }

    public String getFflx() {
        return fflx;
    }

    public void setFflx(String fflx) {
        this.fflx = fflx;
    }

    public String getJbr() {
        return jbr;
    }

    public void setJbr(String jbr) {
        this.jbr = jbr;
    }

    public String getSpr() {
        return spr;
    }

    public void setSpr(String spr) {
        this.spr = spr;
    }

    public Character getFfzt() {
        return ffzt;
    }

    public void setFfzt(Character ffzt) {
        this.ffzt = ffzt;
    }

    public String getFffs() {
        return fffs;
    }

    public void setFffs(String fffs) {
        this.fffs = fffs;
    }

    public String getJzywbm() {
        return jzywbm;
    }

    public void setJzywbm(String jzywbm) {
        this.jzywbm = jzywbm;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getCzy() {
        return czy;
    }

    public void setCzy(String czy) {
        this.czy = czy;
    }

    public String getJbjg() {
        return jbjg;
    }

    public void setJbjg(String jbjg) {
        this.jbjg = jbjg;
    }

    public String getXzqhbm() {
        return xzqhbm;
    }

    public void setXzqhbm(String xzqhbm) {
        this.xzqhbm = xzqhbm;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ffxxid != null ? ffxxid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BizFfxx)) {
            return false;
        }
        BizFfxx other = (BizFfxx) object;
        if ((this.ffxxid == null && other.ffxxid != null) || (this.ffxxid != null && !this.ffxxid.equals(other.ffxxid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BizFfxx[ ffxxid=" + ffxxid + " ]";
    }
    
}
