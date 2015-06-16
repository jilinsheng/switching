/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "BIZ_JZDXJBXX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BizJzdxjbxx.findAll", query = "SELECT b FROM BizJzdxjbxx b"),
    @NamedQuery(name = "BizJzdxjbxx.findByXh", query = "SELECT b FROM BizJzdxjbxx b WHERE b.xh = :xh"),
    @NamedQuery(name = "BizJzdxjbxx.findByJtlsid", query = "SELECT b FROM BizJzdxjbxx b WHERE b.bizJzdxjbxxPK.jtlsid = :jtlsid"),
    @NamedQuery(name = "BizJzdxjbxx.findByRylsid", query = "SELECT b FROM BizJzdxjbxx b WHERE b.bizJzdxjbxxPK.rylsid = :rylsid"),
    @NamedQuery(name = "BizJzdxjbxx.findByCysfzhm", query = "SELECT b FROM BizJzdxjbxx b WHERE b.cysfzhm = :cysfzhm"),
    @NamedQuery(name = "BizJzdxjbxx.findByRybm", query = "SELECT b FROM BizJzdxjbxx b WHERE b.rybm = :rybm"),
    @NamedQuery(name = "BizJzdxjbxx.findByXm", query = "SELECT b FROM BizJzdxjbxx b WHERE b.xm = :xm"),
    @NamedQuery(name = "BizJzdxjbxx.findByXb", query = "SELECT b FROM BizJzdxjbxx b WHERE b.xb = :xb"),
    @NamedQuery(name = "BizJzdxjbxx.findByCsrq", query = "SELECT b FROM BizJzdxjbxx b WHERE b.csrq = :csrq"),
    @NamedQuery(name = "BizJzdxjbxx.findByMz", query = "SELECT b FROM BizJzdxjbxx b WHERE b.mz = :mz"),
    @NamedQuery(name = "BizJzdxjbxx.findByRylb", query = "SELECT b FROM BizJzdxjbxx b WHERE b.rylb = :rylb"),
    @NamedQuery(name = "BizJzdxjbxx.findByJyzk", query = "SELECT b FROM BizJzdxjbxx b WHERE b.jyzk = :jyzk"),
    @NamedQuery(name = "BizJzdxjbxx.findByHyzk", query = "SELECT b FROM BizJzdxjbxx b WHERE b.hyzk = :hyzk"),
    @NamedQuery(name = "BizJzdxjbxx.findByWhcd", query = "SELECT b FROM BizJzdxjbxx b WHERE b.whcd = :whcd"),
    @NamedQuery(name = "BizJzdxjbxx.findByZzmm", query = "SELECT b FROM BizJzdxjbxx b WHERE b.zzmm = :zzmm"),
    @NamedQuery(name = "BizJzdxjbxx.findByLdnl", query = "SELECT b FROM BizJzdxjbxx b WHERE b.ldnl = :ldnl"),
    @NamedQuery(name = "BizJzdxjbxx.findByJkzk", query = "SELECT b FROM BizJzdxjbxx b WHERE b.jkzk = :jkzk"),
    @NamedQuery(name = "BizJzdxjbxx.findByShsw", query = "SELECT b FROM BizJzdxjbxx b WHERE b.shsw = :shsw"),
    @NamedQuery(name = "BizJzdxjbxx.findByJtgx", query = "SELECT b FROM BizJzdxjbxx b WHERE b.jtgx = :jtgx"),
    @NamedQuery(name = "BizJzdxjbxx.findByHjxz", query = "SELECT b FROM BizJzdxjbxx b WHERE b.hjxz = :hjxz"),
    @NamedQuery(name = "BizJzdxjbxx.findByRyzt", query = "SELECT b FROM BizJzdxjbxx b WHERE b.ryzt = :ryzt"),
    @NamedQuery(name = "BizJzdxjbxx.findByXzqhbm", query = "SELECT b FROM BizJzdxjbxx b WHERE b.xzqhbm = :xzqhbm"),
    @NamedQuery(name = "BizJzdxjbxx.findByCzrq", query = "SELECT b FROM BizJzdxjbxx b WHERE b.czrq = :czrq"),
    @NamedQuery(name = "BizJzdxjbxx.findByJbjgid", query = "SELECT b FROM BizJzdxjbxx b WHERE b.jbjgid = :jbjgid"),
    @NamedQuery(name = "BizJzdxjbxx.findBySfbzdx", query = "SELECT b FROM BizJzdxjbxx b WHERE b.sfbzdx = :sfbzdx"),
    @NamedQuery(name = "BizJzdxjbxx.findByCjlx", query = "SELECT b FROM BizJzdxjbxx b WHERE b.cjlx = :cjlx"),
    @NamedQuery(name = "BizJzdxjbxx.findByCjdj", query = "SELECT b FROM BizJzdxjbxx b WHERE b.cjdj = :cjdj"),
    @NamedQuery(name = "BizJzdxjbxx.findByTdjzdxlb", query = "SELECT b FROM BizJzdxjbxx b WHERE b.tdjzdxlb = :tdjzdxlb"),
    @NamedQuery(name = "BizJzdxjbxx.findByGyfs", query = "SELECT b FROM BizJzdxjbxx b WHERE b.gyfs = :gyfs"),
    @NamedQuery(name = "BizJzdxjbxx.findByHjdz", query = "SELECT b FROM BizJzdxjbxx b WHERE b.hjdz = :hjdz"),
    @NamedQuery(name = "BizJzdxjbxx.findByShzlnl", query = "SELECT b FROM BizJzdxjbxx b WHERE b.shzlnl = :shzlnl"),
    @NamedQuery(name = "BizJzdxjbxx.findByGyfwjgid", query = "SELECT b FROM BizJzdxjbxx b WHERE b.gyfwjgid = :gyfwjgid"),
    @NamedQuery(name = "BizJzdxjbxx.findByXyzk", query = "SELECT b FROM BizJzdxjbxx b WHERE b.xyzk = :xyzk"),
    @NamedQuery(name = "BizJzdxjbxx.findByZllx", query = "SELECT b FROM BizJzdxjbxx b WHERE b.zllx = :zllx"),
    @NamedQuery(name = "BizJzdxjbxx.findByCzsj", query = "SELECT b FROM BizJzdxjbxx b WHERE b.czsj = :czsj"),
    @NamedQuery(name = "BizJzdxjbxx.findByDbzh", query = "SELECT b FROM BizJzdxjbxx b WHERE b.dbzh = :dbzh")})
public class BizJzdxjbxx implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BizJzdxjbxxPK bizJzdxjbxxPK;
    @Column(name = "XH")
    private Long xh;
    @Column(name = "CYSFZHM")
    private String cysfzhm;
    @Column(name = "RYBM")
    private String rybm;
    @Column(name = "XM")
    private String xm;
    @Column(name = "XB")
    private String xb;
    @Column(name = "CSRQ")
    @Temporal(TemporalType.TIMESTAMP)
    private Date csrq;
    @Column(name = "MZ")
    private String mz;
    @Column(name = "RYLB")
    private String rylb;
    @Column(name = "JYZK")
    private String jyzk;
    @Column(name = "HYZK")
    private String hyzk;
    @Column(name = "WHCD")
    private String whcd;
    @Column(name = "ZZMM")
    private String zzmm;
    @Column(name = "LDNL")
    private String ldnl;
    @Column(name = "JKZK")
    private String jkzk;
    @Column(name = "SHSW")
    private String shsw;
    @Column(name = "JTGX")
    private String jtgx;
    @Column(name = "HJXZ")
    private String hjxz;
    @Column(name = "RYZT")
    private String ryzt;
    @Column(name = "XZQHBM")
    private String xzqhbm;
    @Column(name = "CZRQ")
    private String czrq;
    @Column(name = "JBJGID")
    private String jbjgid;
    @Column(name = "SFBZDX")
    private String sfbzdx;
    @Column(name = "CJLX")
    private String cjlx;
    @Column(name = "CJDJ")
    private String cjdj;
    @Column(name = "TDJZDXLB")
    private String tdjzdxlb;
    @Column(name = "GYFS")
    private String gyfs;
    @Column(name = "HJDZ")
    private String hjdz;
    @Column(name = "SHZLNL")
    private String shzlnl;
    @Column(name = "GYFWJGID")
    private String gyfwjgid;
    @Column(name = "XYZK")
    private String xyzk;
    @Column(name = "ZLLX")
    private String zllx;
    @Column(name = "CZSJ")
    private String czsj;
    @Column(name = "DBZH")
    private String dbzh;

    public BizJzdxjbxx() {
    }

    public BizJzdxjbxx(BizJzdxjbxxPK bizJzdxjbxxPK) {
        this.bizJzdxjbxxPK = bizJzdxjbxxPK;
    }

    public BizJzdxjbxx(String jtlsid, String rylsid) {
        this.bizJzdxjbxxPK = new BizJzdxjbxxPK(jtlsid, rylsid);
    }

    public BizJzdxjbxxPK getBizJzdxjbxxPK() {
        return bizJzdxjbxxPK;
    }

    public void setBizJzdxjbxxPK(BizJzdxjbxxPK bizJzdxjbxxPK) {
        this.bizJzdxjbxxPK = bizJzdxjbxxPK;
    }

    public Long getXh() {
        return xh;
    }

    public void setXh(Long xh) {
        this.xh = xh;
    }

    public String getCysfzhm() {
        return cysfzhm;
    }

    public void setCysfzhm(String cysfzhm) {
        this.cysfzhm = cysfzhm;
    }

    public String getRybm() {
        return rybm;
    }

    public void setRybm(String rybm) {
        this.rybm = rybm;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public Date getCsrq() {
        return csrq;
    }

    public void setCsrq(Date csrq) {
        this.csrq = csrq;
    }

    public String getMz() {
        return mz;
    }

    public void setMz(String mz) {
        this.mz = mz;
    }

    public String getRylb() {
        return rylb;
    }

    public void setRylb(String rylb) {
        this.rylb = rylb;
    }

    public String getJyzk() {
        return jyzk;
    }

    public void setJyzk(String jyzk) {
        this.jyzk = jyzk;
    }

    public String getHyzk() {
        return hyzk;
    }

    public void setHyzk(String hyzk) {
        this.hyzk = hyzk;
    }

    public String getWhcd() {
        return whcd;
    }

    public void setWhcd(String whcd) {
        this.whcd = whcd;
    }

    public String getZzmm() {
        return zzmm;
    }

    public void setZzmm(String zzmm) {
        this.zzmm = zzmm;
    }

    public String getLdnl() {
        return ldnl;
    }

    public void setLdnl(String ldnl) {
        this.ldnl = ldnl;
    }

    public String getJkzk() {
        return jkzk;
    }

    public void setJkzk(String jkzk) {
        this.jkzk = jkzk;
    }

    public String getShsw() {
        return shsw;
    }

    public void setShsw(String shsw) {
        this.shsw = shsw;
    }

    public String getJtgx() {
        return jtgx;
    }

    public void setJtgx(String jtgx) {
        this.jtgx = jtgx;
    }

    public String getHjxz() {
        return hjxz;
    }

    public void setHjxz(String hjxz) {
        this.hjxz = hjxz;
    }

    public String getRyzt() {
        return ryzt;
    }

    public void setRyzt(String ryzt) {
        this.ryzt = ryzt;
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

    public String getSfbzdx() {
        return sfbzdx;
    }

    public void setSfbzdx(String sfbzdx) {
        this.sfbzdx = sfbzdx;
    }

    public String getCjlx() {
        return cjlx;
    }

    public void setCjlx(String cjlx) {
        this.cjlx = cjlx;
    }

    public String getCjdj() {
        return cjdj;
    }

    public void setCjdj(String cjdj) {
        this.cjdj = cjdj;
    }

    public String getTdjzdxlb() {
        return tdjzdxlb;
    }

    public void setTdjzdxlb(String tdjzdxlb) {
        this.tdjzdxlb = tdjzdxlb;
    }

    public String getGyfs() {
        return gyfs;
    }

    public void setGyfs(String gyfs) {
        this.gyfs = gyfs;
    }

    public String getHjdz() {
        return hjdz;
    }

    public void setHjdz(String hjdz) {
        this.hjdz = hjdz;
    }

    public String getShzlnl() {
        return shzlnl;
    }

    public void setShzlnl(String shzlnl) {
        this.shzlnl = shzlnl;
    }

    public String getGyfwjgid() {
        return gyfwjgid;
    }

    public void setGyfwjgid(String gyfwjgid) {
        this.gyfwjgid = gyfwjgid;
    }

    public String getXyzk() {
        return xyzk;
    }

    public void setXyzk(String xyzk) {
        this.xyzk = xyzk;
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

    public String getDbzh() {
        return dbzh;
    }

    public void setDbzh(String dbzh) {
        this.dbzh = dbzh;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bizJzdxjbxxPK != null ? bizJzdxjbxxPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BizJzdxjbxx)) {
            return false;
        }
        BizJzdxjbxx other = (BizJzdxjbxx) object;
        if ((this.bizJzdxjbxxPK == null && other.bizJzdxjbxxPK != null) || (this.bizJzdxjbxxPK != null && !this.bizJzdxjbxxPK.equals(other.bizJzdxjbxxPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BizJzdxjbxx[ bizJzdxjbxxPK=" + bizJzdxjbxxPK + " ]";
    }
    
}
