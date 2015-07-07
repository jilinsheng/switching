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
@Table(name = "BIZ_JZJTZFXX", catalog = "", schema = "SWITCHING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BizJzjtzfxx.findAll", query = "SELECT b FROM BizJzjtzfxx b"),
    @NamedQuery(name = "BizJzjtzfxx.findByXh", query = "SELECT b FROM BizJzjtzfxx b WHERE b.xh = :xh"),
    @NamedQuery(name = "BizJzjtzfxx.findByJtzflsid", query = "SELECT b FROM BizJzjtzfxx b WHERE b.jtzflsid = :jtzflsid"),
    @NamedQuery(name = "BizJzjtzfxx.findByJtlsid", query = "SELECT b FROM BizJzjtzfxx b WHERE b.jtlsid = :jtlsid"),
    @NamedQuery(name = "BizJzjtzfxx.findByZfjg", query = "SELECT b FROM BizJzjtzfxx b WHERE b.zfjg = :zfjg"),
    @NamedQuery(name = "BizJzjtzfxx.findByZfxz", query = "SELECT b FROM BizJzjtzfxx b WHERE b.zfxz = :zfxz"),
    @NamedQuery(name = "BizJzjtzfxx.findByZfdz", query = "SELECT b FROM BizJzjtzfxx b WHERE b.zfdz = :zfdz"),
    @NamedQuery(name = "BizJzjtzfxx.findByJzmj", query = "SELECT b FROM BizJzjtzfxx b WHERE b.jzmj = :jzmj"),
    @NamedQuery(name = "BizJzjtzfxx.findBySymj", query = "SELECT b FROM BizJzjtzfxx b WHERE b.symj = :symj"),
    @NamedQuery(name = "BizJzjtzfxx.findByZllx", query = "SELECT b FROM BizJzjtzfxx b WHERE b.zllx = :zllx"),
    @NamedQuery(name = "BizJzjtzfxx.findByCzsj", query = "SELECT b FROM BizJzjtzfxx b WHERE b.czsj = :czsj")})
public class BizJzjtzfxx implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long xh;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 32)
    private String jtzflsid;
    @Column(length = 32)
    private String jtlsid;
    @Column(length = 3)
    private String zfjg;
    @Column(length = 3)
    private String zfxz;
    @Column(length = 50)
    private String zfdz;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 7, scale = 2)
    private BigDecimal jzmj;
    @Column(precision = 7, scale = 2)
    private BigDecimal symj;
    @Column(length = 1)
    private String zllx;
    @Column(length = 19)
    private String czsj;

    public BizJzjtzfxx() {
    }

    public BizJzjtzfxx(String jtzflsid) {
        this.jtzflsid = jtzflsid;
    }

    public Long getXh() {
        return xh;
    }

    public void setXh(Long xh) {
        this.xh = xh;
    }

    public String getJtzflsid() {
        return jtzflsid;
    }

    public void setJtzflsid(String jtzflsid) {
        this.jtzflsid = jtzflsid;
    }

    public String getJtlsid() {
        return jtlsid;
    }

    public void setJtlsid(String jtlsid) {
        this.jtlsid = jtlsid;
    }

    public String getZfjg() {
        return zfjg;
    }

    public void setZfjg(String zfjg) {
        this.zfjg = zfjg;
    }

    public String getZfxz() {
        return zfxz;
    }

    public void setZfxz(String zfxz) {
        this.zfxz = zfxz;
    }

    public String getZfdz() {
        return zfdz;
    }

    public void setZfdz(String zfdz) {
        this.zfdz = zfdz;
    }

    public BigDecimal getJzmj() {
        return jzmj;
    }

    public void setJzmj(BigDecimal jzmj) {
        this.jzmj = jzmj;
    }

    public BigDecimal getSymj() {
        return symj;
    }

    public void setSymj(BigDecimal symj) {
        this.symj = symj;
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
        hash += (jtzflsid != null ? jtzflsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BizJzjtzfxx)) {
            return false;
        }
        BizJzjtzfxx other = (BizJzjtzfxx) object;
        if ((this.jtzflsid == null && other.jtzflsid != null) || (this.jtzflsid != null && !this.jtzflsid.equals(other.jtzflsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BizJzjtzfxx[ jtzflsid=" + jtzflsid + " ]";
    }
    
}
