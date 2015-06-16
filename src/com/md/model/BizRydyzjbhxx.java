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
@Table(name = "BIZ_RYDYZJBHXX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BizRydyzjbhxx.findAll", query = "SELECT b FROM BizRydyzjbhxx b"),
    @NamedQuery(name = "BizRydyzjbhxx.findByXh", query = "SELECT b FROM BizRydyzjbhxx b WHERE b.xh = :xh"),
    @NamedQuery(name = "BizRydyzjbhxx.findByRylsid", query = "SELECT b FROM BizRydyzjbhxx b WHERE b.rylsid = :rylsid"),
    @NamedQuery(name = "BizRydyzjbhxx.findByCysfzhm", query = "SELECT b FROM BizRydyzjbhxx b WHERE b.cysfzhm = :cysfzhm"),
    @NamedQuery(name = "BizRydyzjbhxx.findByBhlx", query = "SELECT b FROM BizRydyzjbhxx b WHERE b.bhlx = :bhlx"),
    @NamedQuery(name = "BizRydyzjbhxx.findByZjbhje", query = "SELECT b FROM BizRydyzjbhxx b WHERE b.zjbhje = :zjbhje"),
    @NamedQuery(name = "BizRydyzjbhxx.findByBhrq", query = "SELECT b FROM BizRydyzjbhxx b WHERE b.bhrq = :bhrq"),
    @NamedQuery(name = "BizRydyzjbhxx.findBySxny", query = "SELECT b FROM BizRydyzjbhxx b WHERE b.sxny = :sxny"),
    @NamedQuery(name = "BizRydyzjbhxx.findByZllx", query = "SELECT b FROM BizRydyzjbhxx b WHERE b.zllx = :zllx"),
    @NamedQuery(name = "BizRydyzjbhxx.findByCzsj", query = "SELECT b FROM BizRydyzjbhxx b WHERE b.czsj = :czsj")})
public class BizRydyzjbhxx implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "XH")
    private Long xh;
    @Id
    @Basic(optional = false)
    @Column(name = "RYLSID")
    private String rylsid;
    @Column(name = "CYSFZHM")
    private String cysfzhm;
    @Column(name = "BHLX")
    private String bhlx;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ZJBHJE")
    private BigDecimal zjbhje;
    @Column(name = "BHRQ")
    private String bhrq;
    @Column(name = "SXNY")
    private String sxny;
    @Column(name = "ZLLX")
    private String zllx;
    @Column(name = "CZSJ")
    private String czsj;

    public BizRydyzjbhxx() {
    }

    public BizRydyzjbhxx(String rylsid) {
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

    public String getBhlx() {
        return bhlx;
    }

    public void setBhlx(String bhlx) {
        this.bhlx = bhlx;
    }

    public BigDecimal getZjbhje() {
        return zjbhje;
    }

    public void setZjbhje(BigDecimal zjbhje) {
        this.zjbhje = zjbhje;
    }

    public String getBhrq() {
        return bhrq;
    }

    public void setBhrq(String bhrq) {
        this.bhrq = bhrq;
    }

    public String getSxny() {
        return sxny;
    }

    public void setSxny(String sxny) {
        this.sxny = sxny;
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
        if (!(object instanceof BizRydyzjbhxx)) {
            return false;
        }
        BizRydyzjbhxx other = (BizRydyzjbhxx) object;
        if ((this.rylsid == null && other.rylsid != null) || (this.rylsid != null && !this.rylsid.equals(other.rylsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BizRydyzjbhxx[ rylsid=" + rylsid + " ]";
    }
    
}
