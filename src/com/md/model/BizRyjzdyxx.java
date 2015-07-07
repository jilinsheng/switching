/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "BIZ_RYJZDYXX", catalog = "", schema = "SWITCHING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BizRyjzdyxx.findAll", query = "SELECT b FROM BizRyjzdyxx b"),
    @NamedQuery(name = "BizRyjzdyxx.findByXh", query = "SELECT b FROM BizRyjzdyxx b WHERE b.bizRyjzdyxxPK.xh = :xh"),
    @NamedQuery(name = "BizRyjzdyxx.findByRylsid", query = "SELECT b FROM BizRyjzdyxx b WHERE b.bizRyjzdyxxPK.rylsid = :rylsid"),
    @NamedQuery(name = "BizRyjzdyxx.findByCysfzhm", query = "SELECT b FROM BizRyjzdyxx b WHERE b.cysfzhm = :cysfzhm"),
    @NamedQuery(name = "BizRyjzdyxx.findByKsny", query = "SELECT b FROM BizRyjzdyxx b WHERE b.ksny = :ksny"),
    @NamedQuery(name = "BizRyjzdyxx.findByJsny", query = "SELECT b FROM BizRyjzdyxx b WHERE b.jsny = :jsny"),
    @NamedQuery(name = "BizRyjzdyxx.findByJzsw", query = "SELECT b FROM BizRyjzdyxx b WHERE b.jzsw = :jzsw"),
    @NamedQuery(name = "BizRyjzdyxx.findBySl", query = "SELECT b FROM BizRyjzdyxx b WHERE b.sl = :sl"),
    @NamedQuery(name = "BizRyjzdyxx.findByDw", query = "SELECT b FROM BizRyjzdyxx b WHERE b.dw = :dw"),
    @NamedQuery(name = "BizRyjzdyxx.findByJzje", query = "SELECT b FROM BizRyjzdyxx b WHERE b.jzje = :jzje"),
    @NamedQuery(name = "BizRyjzdyxx.findByDyss", query = "SELECT b FROM BizRyjzdyxx b WHERE b.dyss = :dyss"),
    @NamedQuery(name = "BizRyjzdyxx.findByJzywlx", query = "SELECT b FROM BizRyjzdyxx b WHERE b.jzywlx = :jzywlx"),
    @NamedQuery(name = "BizRyjzdyxx.findByJzxmbm", query = "SELECT b FROM BizRyjzdyxx b WHERE b.jzxmbm = :jzxmbm"),
    @NamedQuery(name = "BizRyjzdyxx.findByZllx", query = "SELECT b FROM BizRyjzdyxx b WHERE b.zllx = :zllx"),
    @NamedQuery(name = "BizRyjzdyxx.findByCzsj", query = "SELECT b FROM BizRyjzdyxx b WHERE b.czsj = :czsj"),
    @NamedQuery(name = "BizRyjzdyxx.findByOXzqhbm", query = "SELECT b FROM BizRyjzdyxx b WHERE b.oXzqhbm = :oXzqhbm")})
public class BizRyjzdyxx implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BizRyjzdyxxPK bizRyjzdyxxPK;
    @Column(length = 18)
    private String cysfzhm;
    @Column(length = 6)
    private String ksny;
    @Column(length = 6)
    private String jsny;
    @Column(length = 15)
    private String jzsw;
    private Short sl;
    @Column(length = 15)
    private String dw;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 7, scale = 2)
    private BigDecimal jzje;
    @Column(length = 3)
    private String dyss;
    @Column(length = 3)
    private String jzywlx;
    @Column(length = 3)
    private String jzxmbm;
    @Column(length = 1)
    private String zllx;
    @Column(length = 19)
    private String czsj;
    @Column(name = "O_XZQHBM", length = 32)
    private String oXzqhbm;

    public BizRyjzdyxx() {
    }

    public BizRyjzdyxx(BizRyjzdyxxPK bizRyjzdyxxPK) {
        this.bizRyjzdyxxPK = bizRyjzdyxxPK;
    }

    public BizRyjzdyxx(long xh, String rylsid) {
        this.bizRyjzdyxxPK = new BizRyjzdyxxPK(xh, rylsid);
    }

    public BizRyjzdyxxPK getBizRyjzdyxxPK() {
        return bizRyjzdyxxPK;
    }

    public void setBizRyjzdyxxPK(BizRyjzdyxxPK bizRyjzdyxxPK) {
        this.bizRyjzdyxxPK = bizRyjzdyxxPK;
    }

    public String getCysfzhm() {
        return cysfzhm;
    }

    public void setCysfzhm(String cysfzhm) {
        this.cysfzhm = cysfzhm;
    }

    public String getKsny() {
        return ksny;
    }

    public void setKsny(String ksny) {
        this.ksny = ksny;
    }

    public String getJsny() {
        return jsny;
    }

    public void setJsny(String jsny) {
        this.jsny = jsny;
    }

    public String getJzsw() {
        return jzsw;
    }

    public void setJzsw(String jzsw) {
        this.jzsw = jzsw;
    }

    public Short getSl() {
        return sl;
    }

    public void setSl(Short sl) {
        this.sl = sl;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public BigDecimal getJzje() {
        return jzje;
    }

    public void setJzje(BigDecimal jzje) {
        this.jzje = jzje;
    }

    public String getDyss() {
        return dyss;
    }

    public void setDyss(String dyss) {
        this.dyss = dyss;
    }

    public String getJzywlx() {
        return jzywlx;
    }

    public void setJzywlx(String jzywlx) {
        this.jzywlx = jzywlx;
    }

    public String getJzxmbm() {
        return jzxmbm;
    }

    public void setJzxmbm(String jzxmbm) {
        this.jzxmbm = jzxmbm;
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
        hash += (bizRyjzdyxxPK != null ? bizRyjzdyxxPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BizRyjzdyxx)) {
            return false;
        }
        BizRyjzdyxx other = (BizRyjzdyxx) object;
        if ((this.bizRyjzdyxxPK == null && other.bizRyjzdyxxPK != null) || (this.bizRyjzdyxxPK != null && !this.bizRyjzdyxxPK.equals(other.bizRyjzdyxxPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BizRyjzdyxx[ bizRyjzdyxxPK=" + bizRyjzdyxxPK + " ]";
    }
    
}
