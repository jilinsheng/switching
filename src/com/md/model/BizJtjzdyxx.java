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
@Table(name = "BIZ_JTJZDYXX", catalog = "", schema = "SWITCHING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BizJtjzdyxx.findAll", query = "SELECT b FROM BizJtjzdyxx b"),
    @NamedQuery(name = "BizJtjzdyxx.findByXh", query = "SELECT b FROM BizJtjzdyxx b WHERE b.xh = :xh"),
    @NamedQuery(name = "BizJtjzdyxx.findByJtlsid", query = "SELECT b FROM BizJtjzdyxx b WHERE b.jtlsid = :jtlsid"),
    @NamedQuery(name = "BizJtjzdyxx.findByKsny", query = "SELECT b FROM BizJtjzdyxx b WHERE b.ksny = :ksny"),
    @NamedQuery(name = "BizJtjzdyxx.findByJsny", query = "SELECT b FROM BizJtjzdyxx b WHERE b.jsny = :jsny"),
    @NamedQuery(name = "BizJtjzdyxx.findByJzsw", query = "SELECT b FROM BizJtjzdyxx b WHERE b.jzsw = :jzsw"),
    @NamedQuery(name = "BizJtjzdyxx.findBySl", query = "SELECT b FROM BizJtjzdyxx b WHERE b.sl = :sl"),
    @NamedQuery(name = "BizJtjzdyxx.findByDw", query = "SELECT b FROM BizJtjzdyxx b WHERE b.dw = :dw"),
    @NamedQuery(name = "BizJtjzdyxx.findByJzje", query = "SELECT b FROM BizJtjzdyxx b WHERE b.jzje = :jzje"),
    @NamedQuery(name = "BizJtjzdyxx.findByJzywlx", query = "SELECT b FROM BizJtjzdyxx b WHERE b.jzywlx = :jzywlx"),
    @NamedQuery(name = "BizJtjzdyxx.findByZllx", query = "SELECT b FROM BizJtjzdyxx b WHERE b.zllx = :zllx"),
    @NamedQuery(name = "BizJtjzdyxx.findByCzsj", query = "SELECT b FROM BizJtjzdyxx b WHERE b.czsj = :czsj"),
    @NamedQuery(name = "BizJtjzdyxx.findByOXzqhbm", query = "SELECT b FROM BizJtjzdyxx b WHERE b.oXzqhbm = :oXzqhbm")})
public class BizJtjzdyxx implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long xh;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 32)
    private String jtlsid;
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
    private String jzywlx;
    @Column(length = 1)
    private String zllx;
    @Column(length = 19)
    private String czsj;
    @Column(name = "O_XZQHBM", length = 32)
    private String oXzqhbm;

    public BizJtjzdyxx() {
    }

    public BizJtjzdyxx(String jtlsid) {
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

    public String getJzywlx() {
        return jzywlx;
    }

    public void setJzywlx(String jzywlx) {
        this.jzywlx = jzywlx;
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
        hash += (jtlsid != null ? jtlsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BizJtjzdyxx)) {
            return false;
        }
        BizJtjzdyxx other = (BizJtjzdyxx) object;
        if ((this.jtlsid == null && other.jtlsid != null) || (this.jtlsid != null && !this.jtlsid.equals(other.jtlsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BizJtjzdyxx[ jtlsid=" + jtlsid + " ]";
    }
    
}
