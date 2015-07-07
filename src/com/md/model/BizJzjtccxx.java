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
@Table(name = "BIZ_JZJTCCXX", catalog = "", schema = "SWITCHING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BizJzjtccxx.findAll", query = "SELECT b FROM BizJzjtccxx b"),
    @NamedQuery(name = "BizJzjtccxx.findByXh", query = "SELECT b FROM BizJzjtccxx b WHERE b.xh = :xh"),
    @NamedQuery(name = "BizJzjtccxx.findByJtcclsid", query = "SELECT b FROM BizJzjtccxx b WHERE b.jtcclsid = :jtcclsid"),
    @NamedQuery(name = "BizJzjtccxx.findByJtlsid", query = "SELECT b FROM BizJzjtccxx b WHERE b.jtlsid = :jtlsid"),
    @NamedQuery(name = "BizJzjtccxx.findByCclx", query = "SELECT b FROM BizJzjtccxx b WHERE b.cclx = :cclx"),
    @NamedQuery(name = "BizJzjtccxx.findByCcgz", query = "SELECT b FROM BizJzjtccxx b WHERE b.ccgz = :ccgz"),
    @NamedQuery(name = "BizJzjtccxx.findByZllx", query = "SELECT b FROM BizJzjtccxx b WHERE b.zllx = :zllx"),
    @NamedQuery(name = "BizJzjtccxx.findByCzsj", query = "SELECT b FROM BizJzjtccxx b WHERE b.czsj = :czsj")})
public class BizJzjtccxx implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long xh;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 32)
    private String jtcclsid;
    @Column(length = 32)
    private String jtlsid;
    @Column(length = 3)
    private String cclx;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 13, scale = 2)
    private BigDecimal ccgz;
    @Column(length = 1)
    private String zllx;
    @Column(length = 19)
    private String czsj;

    public BizJzjtccxx() {
    }

    public BizJzjtccxx(String jtcclsid) {
        this.jtcclsid = jtcclsid;
    }

    public Long getXh() {
        return xh;
    }

    public void setXh(Long xh) {
        this.xh = xh;
    }

    public String getJtcclsid() {
        return jtcclsid;
    }

    public void setJtcclsid(String jtcclsid) {
        this.jtcclsid = jtcclsid;
    }

    public String getJtlsid() {
        return jtlsid;
    }

    public void setJtlsid(String jtlsid) {
        this.jtlsid = jtlsid;
    }

    public String getCclx() {
        return cclx;
    }

    public void setCclx(String cclx) {
        this.cclx = cclx;
    }

    public BigDecimal getCcgz() {
        return ccgz;
    }

    public void setCcgz(BigDecimal ccgz) {
        this.ccgz = ccgz;
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
        hash += (jtcclsid != null ? jtcclsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BizJzjtccxx)) {
            return false;
        }
        BizJzjtccxx other = (BizJzjtccxx) object;
        if ((this.jtcclsid == null && other.jtcclsid != null) || (this.jtcclsid != null && !this.jtcclsid.equals(other.jtcclsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BizJzjtccxx[ jtcclsid=" + jtcclsid + " ]";
    }
    
}
