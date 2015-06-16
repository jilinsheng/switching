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
@Table(name = "BIZ_JZJTXX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BizJzjtxx.findAll", query = "SELECT b FROM BizJzjtxx b"),
    @NamedQuery(name = "BizJzjtxx.findByXh", query = "SELECT b FROM BizJzjtxx b WHERE b.xh = :xh"),
    @NamedQuery(name = "BizJzjtxx.findByJtlsid", query = "SELECT b FROM BizJzjtxx b WHERE b.jtlsid = :jtlsid"),
    @NamedQuery(name = "BizJzjtxx.findByHzsfzhm", query = "SELECT b FROM BizJzjtxx b WHERE b.hzsfzhm = :hzsfzhm"),
    @NamedQuery(name = "BizJzjtxx.findByJtbm", query = "SELECT b FROM BizJzjtxx b WHERE b.jtbm = :jtbm"),
    @NamedQuery(name = "BizJzjtxx.findByJtlb", query = "SELECT b FROM BizJzjtxx b WHERE b.jtlb = :jtlb"),
    @NamedQuery(name = "BizJzjtxx.findByZyzpyy", query = "SELECT b FROM BizJzjtxx b WHERE b.zyzpyy = :zyzpyy"),
    @NamedQuery(name = "BizJzjtxx.findByJtrk", query = "SELECT b FROM BizJzjtxx b WHERE b.jtrk = :jtrk"),
    @NamedQuery(name = "BizJzjtxx.findByBzrk", query = "SELECT b FROM BizJzjtxx b WHERE b.bzrk = :bzrk"),
    @NamedQuery(name = "BizJzjtxx.findByZsr", query = "SELECT b FROM BizJzjtxx b WHERE b.zsr = :zsr"),
    @NamedQuery(name = "BizJzjtxx.findByXzqhbm", query = "SELECT b FROM BizJzjtxx b WHERE b.xzqhbm = :xzqhbm"),
    @NamedQuery(name = "BizJzjtxx.findByCzrq", query = "SELECT b FROM BizJzjtxx b WHERE b.czrq = :czrq"),
    @NamedQuery(name = "BizJzjtxx.findByJbjgid", query = "SELECT b FROM BizJzjtxx b WHERE b.jbjgid = :jbjgid"),
    @NamedQuery(name = "BizJzjtxx.findBySprq", query = "SELECT b FROM BizJzjtxx b WHERE b.sprq = :sprq"),
    @NamedQuery(name = "BizJzjtxx.findByJzywlx", query = "SELECT b FROM BizJzjtxx b WHERE b.jzywlx = :jzywlx"),
    @NamedQuery(name = "BizJzjtxx.findByJzzh", query = "SELECT b FROM BizJzjtxx b WHERE b.jzzh = :jzzh"),
    @NamedQuery(name = "BizJzjtxx.findByZjkm", query = "SELECT b FROM BizJzjtxx b WHERE b.zjkm = :zjkm"),
    @NamedQuery(name = "BizJzjtxx.findByKhyh", query = "SELECT b FROM BizJzjtxx b WHERE b.khyh = :khyh"),
    @NamedQuery(name = "BizJzjtxx.findByKhmc", query = "SELECT b FROM BizJzjtxx b WHERE b.khmc = :khmc"),
    @NamedQuery(name = "BizJzjtxx.findByYhzh", query = "SELECT b FROM BizJzjtxx b WHERE b.yhzh = :yhzh"),
    @NamedQuery(name = "BizJzjtxx.findByJzdz", query = "SELECT b FROM BizJzjtxx b WHERE b.jzdz = :jzdz"),
    @NamedQuery(name = "BizJzjtxx.findByZllx", query = "SELECT b FROM BizJzjtxx b WHERE b.zllx = :zllx"),
    @NamedQuery(name = "BizJzjtxx.findByCzsj", query = "SELECT b FROM BizJzjtxx b WHERE b.czsj = :czsj")})
public class BizJzjtxx implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "XH")
    private Long xh;
    @Id
    @Basic(optional = false)
    @Column(name = "JTLSID")
    private String jtlsid;
    @Column(name = "HZSFZHM")
    private String hzsfzhm;
    @Column(name = "JTBM")
    private String jtbm;
    @Column(name = "JTLB")
    private String jtlb;
    @Column(name = "ZYZPYY")
    private String zyzpyy;
    @Column(name = "JTRK")
    private Short jtrk;
    @Column(name = "BZRK")
    private Short bzrk;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ZSR")
    private BigDecimal zsr;
    @Column(name = "XZQHBM")
    private String xzqhbm;
    @Column(name = "CZRQ")
    private String czrq;
    @Column(name = "JBJGID")
    private String jbjgid;
    @Column(name = "SPRQ")
    private String sprq;
    @Column(name = "JZYWLX")
    private String jzywlx;
    @Column(name = "JZZH")
    private String jzzh;
    @Column(name = "ZJKM")
    private String zjkm;
    @Column(name = "KHYH")
    private String khyh;
    @Column(name = "KHMC")
    private String khmc;
    @Column(name = "YHZH")
    private String yhzh;
    @Column(name = "JZDZ")
    private String jzdz;
    @Column(name = "ZLLX")
    private String zllx;
    @Column(name = "CZSJ")
    private String czsj;

    public BizJzjtxx() {
    }

    public BizJzjtxx(String jtlsid) {
        this.jtlsid = jtlsid;
    }

    public Long getXh() {
        return xh;
    }

    public void setXh(Long xh) {
        this.xh = xh;
    }

    public String getJtlsid() {
        return jtlsid;
    }

    public void setJtlsid(String jtlsid) {
        this.jtlsid = jtlsid;
    }

    public String getHzsfzhm() {
        return hzsfzhm;
    }

    public void setHzsfzhm(String hzsfzhm) {
        this.hzsfzhm = hzsfzhm;
    }

    public String getJtbm() {
        return jtbm;
    }

    public void setJtbm(String jtbm) {
        this.jtbm = jtbm;
    }

    public String getJtlb() {
        return jtlb;
    }

    public void setJtlb(String jtlb) {
        this.jtlb = jtlb;
    }

    public String getZyzpyy() {
        return zyzpyy;
    }

    public void setZyzpyy(String zyzpyy) {
        this.zyzpyy = zyzpyy;
    }

    public Short getJtrk() {
        return jtrk;
    }

    public void setJtrk(Short jtrk) {
        this.jtrk = jtrk;
    }

    public Short getBzrk() {
        return bzrk;
    }

    public void setBzrk(Short bzrk) {
        this.bzrk = bzrk;
    }

    public BigDecimal getZsr() {
        return zsr;
    }

    public void setZsr(BigDecimal zsr) {
        this.zsr = zsr;
    }

    public String getXzqhbm() {
        return xzqhbm;
    }

    public void setXzqhbm(String xzqhbm) {
        this.xzqhbm = xzqhbm;
    }

    public String getCzrq() {
        return czrq;
    }

    public void setCzrq(String czrq) {
        this.czrq = czrq;
    }

    public String getJbjgid() {
        return jbjgid;
    }

    public void setJbjgid(String jbjgid) {
        this.jbjgid = jbjgid;
    }

    public String getSprq() {
        return sprq;
    }

    public void setSprq(String sprq) {
        this.sprq = sprq;
    }

    public String getJzywlx() {
        return jzywlx;
    }

    public void setJzywlx(String jzywlx) {
        this.jzywlx = jzywlx;
    }

    public String getJzzh() {
        return jzzh;
    }

    public void setJzzh(String jzzh) {
        this.jzzh = jzzh;
    }

    public String getZjkm() {
        return zjkm;
    }

    public void setZjkm(String zjkm) {
        this.zjkm = zjkm;
    }

    public String getKhyh() {
        return khyh;
    }

    public void setKhyh(String khyh) {
        this.khyh = khyh;
    }

    public String getKhmc() {
        return khmc;
    }

    public void setKhmc(String khmc) {
        this.khmc = khmc;
    }

    public String getYhzh() {
        return yhzh;
    }

    public void setYhzh(String yhzh) {
        this.yhzh = yhzh;
    }

    public String getJzdz() {
        return jzdz;
    }

    public void setJzdz(String jzdz) {
        this.jzdz = jzdz;
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
        hash += (jtlsid != null ? jtlsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BizJzjtxx)) {
            return false;
        }
        BizJzjtxx other = (BizJzjtxx) object;
        if ((this.jtlsid == null && other.jtlsid != null) || (this.jtlsid != null && !this.jtlsid.equals(other.jtlsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BizJzjtxx[ jtlsid=" + jtlsid + " ]";
    }
    
}
