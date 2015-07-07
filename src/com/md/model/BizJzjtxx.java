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
@Table(name = "BIZ_JZJTXX", catalog = "", schema = "SWITCHING")
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
    @NamedQuery(name = "BizJzjtxx.findByCzsj", query = "SELECT b FROM BizJzjtxx b WHERE b.czsj = :czsj"),
    @NamedQuery(name = "BizJzjtxx.findByOFid", query = "SELECT b FROM BizJzjtxx b WHERE b.oFid = :oFid"),
    @NamedQuery(name = "BizJzjtxx.findByOFno", query = "SELECT b FROM BizJzjtxx b WHERE b.oFno = :oFno"),
    @NamedQuery(name = "BizJzjtxx.findByOId18", query = "SELECT b FROM BizJzjtxx b WHERE b.oId18 = :oId18"),
    @NamedQuery(name = "BizJzjtxx.findByOId15", query = "SELECT b FROM BizJzjtxx b WHERE b.oId15 = :oId15"),
    @NamedQuery(name = "BizJzjtxx.findByOIdck", query = "SELECT b FROM BizJzjtxx b WHERE b.oIdck = :oIdck"),
    @NamedQuery(name = "BizJzjtxx.findByOBirthday", query = "SELECT b FROM BizJzjtxx b WHERE b.oBirthday = :oBirthday"),
    @NamedQuery(name = "BizJzjtxx.findByOIdno", query = "SELECT b FROM BizJzjtxx b WHERE b.oIdno = :oIdno"),
    @NamedQuery(name = "BizJzjtxx.findByOXzqhbm", query = "SELECT b FROM BizJzjtxx b WHERE b.oXzqhbm = :oXzqhbm"),
    @NamedQuery(name = "BizJzjtxx.findByOMemberid", query = "SELECT b FROM BizJzjtxx b WHERE b.oMemberid = :oMemberid")})
public class BizJzjtxx implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long xh;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 32)
    private String jtlsid;
    @Column(length = 18)
    private String hzsfzhm;
    @Column(length = 32)
    private String jtbm;
    @Column(length = 3)
    private String jtlb;
    @Column(length = 3)
    private String zyzpyy;
    private Short jtrk;
    private Short bzrk;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 8, scale = 2)
    private BigDecimal zsr;
    @Column(length = 12)
    private String xzqhbm;
    @Column(length = 10)
    private String czrq;
    @Column(length = 32)
    private String jbjgid;
    @Column(length = 10)
    private String sprq;
    @Column(length = 3)
    private String jzywlx;
    @Column(length = 30)
    private String jzzh;
    @Column(length = 15)
    private String zjkm;
    @Column(length = 4)
    private String khyh;
    @Column(length = 50)
    private String khmc;
    @Column(length = 30)
    private String yhzh;
    @Column(length = 100)
    private String jzdz;
    @Column(length = 1)
    private String zllx;
    @Column(length = 19)
    private String czsj;
    @Column(name = "O_FID", length = 100)
    private String oFid;
    @Column(name = "O_FNO", length = 100)
    private String oFno;
    @Column(name = "O_ID18", length = 100)
    private String oId18;
    @Column(name = "O_ID15", length = 100)
    private String oId15;
    @Column(name = "O_IDCK", length = 100)
    private String oIdck;
    @Column(name = "O_BIRTHDAY", length = 100)
    private String oBirthday;
    @Column(name = "O_IDNO", length = 100)
    private String oIdno;
    @Column(name = "O_XZQHBM", length = 100)
    private String oXzqhbm;
    @Column(name = "O_MEMBERID", length = 100)
    private String oMemberid;

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

    public String getOFid() {
        return oFid;
    }

    public void setOFid(String oFid) {
        this.oFid = oFid;
    }

    public String getOFno() {
        return oFno;
    }

    public void setOFno(String oFno) {
        this.oFno = oFno;
    }

    public String getOId18() {
        return oId18;
    }

    public void setOId18(String oId18) {
        this.oId18 = oId18;
    }

    public String getOId15() {
        return oId15;
    }

    public void setOId15(String oId15) {
        this.oId15 = oId15;
    }

    public String getOIdck() {
        return oIdck;
    }

    public void setOIdck(String oIdck) {
        this.oIdck = oIdck;
    }

    public String getOBirthday() {
        return oBirthday;
    }

    public void setOBirthday(String oBirthday) {
        this.oBirthday = oBirthday;
    }

    public String getOIdno() {
        return oIdno;
    }

    public void setOIdno(String oIdno) {
        this.oIdno = oIdno;
    }

    public String getOXzqhbm() {
        return oXzqhbm;
    }

    public void setOXzqhbm(String oXzqhbm) {
        this.oXzqhbm = oXzqhbm;
    }

    public String getOMemberid() {
        return oMemberid;
    }

    public void setOMemberid(String oMemberid) {
        this.oMemberid = oMemberid;
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
