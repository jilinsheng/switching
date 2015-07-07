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
@Table(name = "BIZ_ZJBFXX", catalog = "", schema = "SWITCHING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BizZjbfxx.findAll", query = "SELECT b FROM BizZjbfxx b"),
    @NamedQuery(name = "BizZjbfxx.findByXh", query = "SELECT b FROM BizZjbfxx b WHERE b.xh = :xh"),
    @NamedQuery(name = "BizZjbfxx.findByZjkm", query = "SELECT b FROM BizZjbfxx b WHERE b.zjkm = :zjkm"),
    @NamedQuery(name = "BizZjbfxx.findByBfrq", query = "SELECT b FROM BizZjbfxx b WHERE b.bfrq = :bfrq"),
    @NamedQuery(name = "BizZjbfxx.findByJsjg", query = "SELECT b FROM BizZjbfxx b WHERE b.jsjg = :jsjg"),
    @NamedQuery(name = "BizZjbfxx.findByBfje", query = "SELECT b FROM BizZjbfxx b WHERE b.bfje = :bfje"),
    @NamedQuery(name = "BizZjbfxx.findByBfwjmc", query = "SELECT b FROM BizZjbfxx b WHERE b.bfwjmc = :bfwjmc"),
    @NamedQuery(name = "BizZjbfxx.findByBfwjh", query = "SELECT b FROM BizZjbfxx b WHERE b.bfwjh = :bfwjh"),
    @NamedQuery(name = "BizZjbfxx.findByJgid", query = "SELECT b FROM BizZjbfxx b WHERE b.jgid = :jgid"),
    @NamedQuery(name = "BizZjbfxx.findByZllx", query = "SELECT b FROM BizZjbfxx b WHERE b.zllx = :zllx"),
    @NamedQuery(name = "BizZjbfxx.findByCzsj", query = "SELECT b FROM BizZjbfxx b WHERE b.czsj = :czsj")})
public class BizZjbfxx implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long xh;
    @Column(length = 3)
    private String zjkm;
    @Column(length = 10)
    private String bfrq;
    @Column(length = 32)
    private String jsjg;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 15, scale = 2)
    private BigDecimal bfje;
    @Column(length = 50)
    private String bfwjmc;
    @Column(length = 50)
    private String bfwjh;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 32)
    private String jgid;
    @Column(length = 1)
    private String zllx;
    @Column(length = 19)
    private String czsj;

    public BizZjbfxx() {
    }

    public BizZjbfxx(String jgid) {
        this.jgid = jgid;
    }

    public Long getXh() {
        return xh;
    }

    public void setXh(Long xh) {
        this.xh = xh;
    }

    public String getZjkm() {
        return zjkm;
    }

    public void setZjkm(String zjkm) {
        this.zjkm = zjkm;
    }

    public String getBfrq() {
        return bfrq;
    }

    public void setBfrq(String bfrq) {
        this.bfrq = bfrq;
    }

    public String getJsjg() {
        return jsjg;
    }

    public void setJsjg(String jsjg) {
        this.jsjg = jsjg;
    }

    public BigDecimal getBfje() {
        return bfje;
    }

    public void setBfje(BigDecimal bfje) {
        this.bfje = bfje;
    }

    public String getBfwjmc() {
        return bfwjmc;
    }

    public void setBfwjmc(String bfwjmc) {
        this.bfwjmc = bfwjmc;
    }

    public String getBfwjh() {
        return bfwjh;
    }

    public void setBfwjh(String bfwjh) {
        this.bfwjh = bfwjh;
    }

    public String getJgid() {
        return jgid;
    }

    public void setJgid(String jgid) {
        this.jgid = jgid;
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
        hash += (jgid != null ? jgid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BizZjbfxx)) {
            return false;
        }
        BizZjbfxx other = (BizZjbfxx) object;
        if ((this.jgid == null && other.jgid != null) || (this.jgid != null && !this.jgid.equals(other.jgid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BizZjbfxx[ jgid=" + jgid + " ]";
    }
    
}
