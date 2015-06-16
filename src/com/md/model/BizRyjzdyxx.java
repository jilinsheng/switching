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
@Table(name = "BIZ_RYJZDYXX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BizRyjzdyxx.findAll", query = "SELECT b FROM BizRyjzdyxx b"),
    @NamedQuery(name = "BizRyjzdyxx.findByXh", query = "SELECT b FROM BizRyjzdyxx b WHERE b.xh = :xh"),
    @NamedQuery(name = "BizRyjzdyxx.findByRylsid", query = "SELECT b FROM BizRyjzdyxx b WHERE b.rylsid = :rylsid"),
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
    @NamedQuery(name = "BizRyjzdyxx.findByCzsj", query = "SELECT b FROM BizRyjzdyxx b WHERE b.czsj = :czsj")})
public class BizRyjzdyxx implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "XH")
    private Long xh;
    @Id
    @Basic(optional = false)
    @Column(name = "RYLSID")
    private String rylsid;
    @Column(name = "CYSFZHM")
    private String cysfzhm;
    @Column(name = "KSNY")
    private String ksny;
    @Column(name = "JSNY")
    private String jsny;
    @Column(name = "JZSW")
    private String jzsw;
    @Column(name = "SL")
    private Short sl;
    @Column(name = "DW")
    private String dw;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "JZJE")
    private BigDecimal jzje;
    @Column(name = "DYSS")
    private String dyss;
    @Column(name = "JZYWLX")
    private String jzywlx;
    @Column(name = "JZXMBM")
    private String jzxmbm;
    @Column(name = "ZLLX")
    private String zllx;
    @Column(name = "CZSJ")
    private String czsj;

    public BizRyjzdyxx() {
    }

    public BizRyjzdyxx(String rylsid) {
        this.rylsid = rylsid;
    }

    public Long getXh() {
        return xh;
    }

    public void setXh(Long xh) {
        this.xh = xh;
    }

    public String getRylsid() {
        return rylsid;
    }

    public void setRylsid(String rylsid) {
        this.rylsid = rylsid;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rylsid != null ? rylsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BizRyjzdyxx)) {
            return false;
        }
        BizRyjzdyxx other = (BizRyjzdyxx) object;
        if ((this.rylsid == null && other.rylsid != null) || (this.rylsid != null && !this.rylsid.equals(other.rylsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BizRyjzdyxx[ rylsid=" + rylsid + " ]";
    }
    
}
