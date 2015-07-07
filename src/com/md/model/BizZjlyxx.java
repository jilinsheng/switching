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
@Table(name = "BIZ_ZJLYXX", catalog = "", schema = "SWITCHING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BizZjlyxx.findAll", query = "SELECT b FROM BizZjlyxx b"),
    @NamedQuery(name = "BizZjlyxx.findByXh", query = "SELECT b FROM BizZjlyxx b WHERE b.xh = :xh"),
    @NamedQuery(name = "BizZjlyxx.findByZjkm", query = "SELECT b FROM BizZjlyxx b WHERE b.zjkm = :zjkm"),
    @NamedQuery(name = "BizZjlyxx.findByZjly", query = "SELECT b FROM BizZjlyxx b WHERE b.zjly = :zjly"),
    @NamedQuery(name = "BizZjlyxx.findByJe", query = "SELECT b FROM BizZjlyxx b WHERE b.je = :je"),
    @NamedQuery(name = "BizZjlyxx.findByZjdzrq", query = "SELECT b FROM BizZjlyxx b WHERE b.zjdzrq = :zjdzrq"),
    @NamedQuery(name = "BizZjlyxx.findByJgid", query = "SELECT b FROM BizZjlyxx b WHERE b.jgid = :jgid"),
    @NamedQuery(name = "BizZjlyxx.findByZllx", query = "SELECT b FROM BizZjlyxx b WHERE b.zllx = :zllx"),
    @NamedQuery(name = "BizZjlyxx.findByCzsj", query = "SELECT b FROM BizZjlyxx b WHERE b.czsj = :czsj")})
public class BizZjlyxx implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long xh;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 3)
    private String zjkm;
    @Column(length = 3)
    private String zjly;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 15, scale = 2)
    private BigDecimal je;
    @Column(length = 10)
    private String zjdzrq;
    @Column(length = 32)
    private String jgid;
    @Column(length = 1)
    private String zllx;
    @Column(length = 19)
    private String czsj;

    public BizZjlyxx() {
    }

    public BizZjlyxx(String zjkm) {
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

    public String getZjly() {
        return zjly;
    }

    public void setZjly(String zjly) {
        this.zjly = zjly;
    }

    public BigDecimal getJe() {
        return je;
    }

    public void setJe(BigDecimal je) {
        this.je = je;
    }

    public String getZjdzrq() {
        return zjdzrq;
    }

    public void setZjdzrq(String zjdzrq) {
        this.zjdzrq = zjdzrq;
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
        if (!(object instanceof BizZjlyxx)) {
            return false;
        }
        BizZjlyxx other = (BizZjlyxx) object;
        if ((this.zjkm == null && other.zjkm != null) || (this.zjkm != null && !this.zjkm.equals(other.zjkm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BizZjlyxx[ zjkm=" + zjkm + " ]";
    }
    
}
