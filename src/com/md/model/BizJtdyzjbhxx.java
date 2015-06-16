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
@Table(name = "BIZ_JTDYZJBHXX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BizJtdyzjbhxx.findAll", query = "SELECT b FROM BizJtdyzjbhxx b"),
    @NamedQuery(name = "BizJtdyzjbhxx.findByXh", query = "SELECT b FROM BizJtdyzjbhxx b WHERE b.xh = :xh"),
    @NamedQuery(name = "BizJtdyzjbhxx.findByJtlsid", query = "SELECT b FROM BizJtdyzjbhxx b WHERE b.jtlsid = :jtlsid"),
    @NamedQuery(name = "BizJtdyzjbhxx.findByBhlx", query = "SELECT b FROM BizJtdyzjbhxx b WHERE b.bhlx = :bhlx"),
    @NamedQuery(name = "BizJtdyzjbhxx.findByZjbhje", query = "SELECT b FROM BizJtdyzjbhxx b WHERE b.zjbhje = :zjbhje"),
    @NamedQuery(name = "BizJtdyzjbhxx.findByBhrq", query = "SELECT b FROM BizJtdyzjbhxx b WHERE b.bhrq = :bhrq"),
    @NamedQuery(name = "BizJtdyzjbhxx.findBySxny", query = "SELECT b FROM BizJtdyzjbhxx b WHERE b.sxny = :sxny"),
    @NamedQuery(name = "BizJtdyzjbhxx.findByZllx", query = "SELECT b FROM BizJtdyzjbhxx b WHERE b.zllx = :zllx"),
    @NamedQuery(name = "BizJtdyzjbhxx.findByCzsj", query = "SELECT b FROM BizJtdyzjbhxx b WHERE b.czsj = :czsj")})
public class BizJtdyzjbhxx implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "XH")
    private Long xh;
    @Id
    @Basic(optional = false)
    @Column(name = "JTLSID")
    private String jtlsid;
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

    public BizJtdyzjbhxx() {
    }

    public BizJtdyzjbhxx(String jtlsid) {
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
        hash += (jtlsid != null ? jtlsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BizJtdyzjbhxx)) {
            return false;
        }
        BizJtdyzjbhxx other = (BizJtdyzjbhxx) object;
        if ((this.jtlsid == null && other.jtlsid != null) || (this.jtlsid != null && !this.jtlsid.equals(other.jtlsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BizJtdyzjbhxx[ jtlsid=" + jtlsid + " ]";
    }
    
}
