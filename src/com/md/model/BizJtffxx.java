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
@Table(name = "BIZ_JTFFXX", catalog = "", schema = "SWITCHING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BizJtffxx.findAll", query = "SELECT b FROM BizJtffxx b"),
    @NamedQuery(name = "BizJtffxx.findByXh", query = "SELECT b FROM BizJtffxx b WHERE b.xh = :xh"),
    @NamedQuery(name = "BizJtffxx.findByJtffxxid", query = "SELECT b FROM BizJtffxx b WHERE b.jtffxxid = :jtffxxid"),
    @NamedQuery(name = "BizJtffxx.findByFfxxid", query = "SELECT b FROM BizJtffxx b WHERE b.ffxxid = :ffxxid"),
    @NamedQuery(name = "BizJtffxx.findByZjjsxxid", query = "SELECT b FROM BizJtffxx b WHERE b.zjjsxxid = :zjjsxxid"),
    @NamedQuery(name = "BizJtffxx.findByFfje", query = "SELECT b FROM BizJtffxx b WHERE b.ffje = :ffje"),
    @NamedQuery(name = "BizJtffxx.findByJtbm", query = "SELECT b FROM BizJtffxx b WHERE b.jtbm = :jtbm"),
    @NamedQuery(name = "BizJtffxx.findByHzid", query = "SELECT b FROM BizJtffxx b WHERE b.hzid = :hzid"),
    @NamedQuery(name = "BizJtffxx.findByFfyhzhid", query = "SELECT b FROM BizJtffxx b WHERE b.ffyhzhid = :ffyhzhid"),
    @NamedQuery(name = "BizJtffxx.findByFfrs", query = "SELECT b FROM BizJtffxx b WHERE b.ffrs = :ffrs"),
    @NamedQuery(name = "BizJtffxx.findByZllx", query = "SELECT b FROM BizJtffxx b WHERE b.zllx = :zllx"),
    @NamedQuery(name = "BizJtffxx.findByCzsj", query = "SELECT b FROM BizJtffxx b WHERE b.czsj = :czsj"),
    @NamedQuery(name = "BizJtffxx.findByOXzqhbm", query = "SELECT b FROM BizJtffxx b WHERE b.oXzqhbm = :oXzqhbm")})
public class BizJtffxx implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long xh;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 32)
    private String jtffxxid;
    @Column(length = 32)
    private String ffxxid;
    @Column(length = 32)
    private String zjjsxxid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 7, scale = 2)
    private BigDecimal ffje;
    @Column(length = 32)
    private String jtbm;
    @Column(length = 32)
    private String hzid;
    @Column(length = 32)
    private String ffyhzhid;
    private Integer ffrs;
    @Column(length = 1)
    private String zllx;
    @Column(length = 19)
    private String czsj;
    @Column(name = "O_XZQHBM", length = 32)
    private String oXzqhbm;

    public BizJtffxx() {
    }

    public BizJtffxx(String jtffxxid) {
        this.jtffxxid = jtffxxid;
    }

    public Long getXh() {
        return xh;
    }

    public void setXh(Long xh) {
        this.xh = xh;
    }

    public String getJtffxxid() {
        return jtffxxid;
    }

    public void setJtffxxid(String jtffxxid) {
        this.jtffxxid = jtffxxid;
    }

    public String getFfxxid() {
        return ffxxid;
    }

    public void setFfxxid(String ffxxid) {
        this.ffxxid = ffxxid;
    }

    public String getZjjsxxid() {
        return zjjsxxid;
    }

    public void setZjjsxxid(String zjjsxxid) {
        this.zjjsxxid = zjjsxxid;
    }

    public BigDecimal getFfje() {
        return ffje;
    }

    public void setFfje(BigDecimal ffje) {
        this.ffje = ffje;
    }

    public String getJtbm() {
        return jtbm;
    }

    public void setJtbm(String jtbm) {
        this.jtbm = jtbm;
    }

    public String getHzid() {
        return hzid;
    }

    public void setHzid(String hzid) {
        this.hzid = hzid;
    }

    public String getFfyhzhid() {
        return ffyhzhid;
    }

    public void setFfyhzhid(String ffyhzhid) {
        this.ffyhzhid = ffyhzhid;
    }

    public Integer getFfrs() {
        return ffrs;
    }

    public void setFfrs(Integer ffrs) {
        this.ffrs = ffrs;
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
        hash += (jtffxxid != null ? jtffxxid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BizJtffxx)) {
            return false;
        }
        BizJtffxx other = (BizJtffxx) object;
        if ((this.jtffxxid == null && other.jtffxxid != null) || (this.jtffxxid != null && !this.jtffxxid.equals(other.jtffxxid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BizJtffxx[ jtffxxid=" + jtffxxid + " ]";
    }
    
}
