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
@Table(name = "BIZ_ZJYSXX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BizZjysxx.findAll", query = "SELECT b FROM BizZjysxx b"),
    @NamedQuery(name = "BizZjysxx.findByXh", query = "SELECT b FROM BizZjysxx b WHERE b.xh = :xh"),
    @NamedQuery(name = "BizZjysxx.findByZjkm", query = "SELECT b FROM BizZjysxx b WHERE b.zjkm = :zjkm"),
    @NamedQuery(name = "BizZjysxx.findByBjysje", query = "SELECT b FROM BizZjysxx b WHERE b.bjysje = :bjysje"),
    @NamedQuery(name = "BizZjysxx.findByZjysnd", query = "SELECT b FROM BizZjysxx b WHERE b.zjysnd = :zjysnd"),
    @NamedQuery(name = "BizZjysxx.findBySjysje", query = "SELECT b FROM BizZjysxx b WHERE b.sjysje = :sjysje"),
    @NamedQuery(name = "BizZjysxx.findByJgid", query = "SELECT b FROM BizZjysxx b WHERE b.jgid = :jgid"),
    @NamedQuery(name = "BizZjysxx.findByZllx", query = "SELECT b FROM BizZjysxx b WHERE b.zllx = :zllx"),
    @NamedQuery(name = "BizZjysxx.findByCzsj", query = "SELECT b FROM BizZjysxx b WHERE b.czsj = :czsj")})
public class BizZjysxx implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "XH")
    private Long xh;
    @Id
    @Basic(optional = false)
    @Column(name = "ZJKM")
    private String zjkm;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BJYSJE")
    private BigDecimal bjysje;
    @Column(name = "ZJYSND")
    private String zjysnd;
    @Column(name = "SJYSJE")
    private BigDecimal sjysje;
    @Column(name = "JGID")
    private String jgid;
    @Column(name = "ZLLX")
    private String zllx;
    @Column(name = "CZSJ")
    private String czsj;

    public BizZjysxx() {
    }

    public BizZjysxx(String zjkm) {
        this.zjkm = zjkm;
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

    public BigDecimal getBjysje() {
        return bjysje;
    }

    public void setBjysje(BigDecimal bjysje) {
        this.bjysje = bjysje;
    }

    public String getZjysnd() {
        return zjysnd;
    }

    public void setZjysnd(String zjysnd) {
        this.zjysnd = zjysnd;
    }

    public BigDecimal getSjysje() {
        return sjysje;
    }

    public void setSjysje(BigDecimal sjysje) {
        this.sjysje = sjysje;
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
        hash += (zjkm != null ? zjkm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BizZjysxx)) {
            return false;
        }
        BizZjysxx other = (BizZjysxx) object;
        if ((this.zjkm == null && other.zjkm != null) || (this.zjkm != null && !this.zjkm.equals(other.zjkm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BizZjysxx[ zjkm=" + zjkm + " ]";
    }
    
}
