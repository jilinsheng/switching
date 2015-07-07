/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "BIZ_JTDYZJBHXX", catalog = "", schema = "SWITCHING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BizJtdyzjbhxx.findAll", query = "SELECT b FROM BizJtdyzjbhxx b"),
    @NamedQuery(name = "BizJtdyzjbhxx.findByXh", query = "SELECT b FROM BizJtdyzjbhxx b WHERE b.bizJtdyzjbhxxPK.xh = :xh"),
    @NamedQuery(name = "BizJtdyzjbhxx.findByJtlsid", query = "SELECT b FROM BizJtdyzjbhxx b WHERE b.bizJtdyzjbhxxPK.jtlsid = :jtlsid"),
    @NamedQuery(name = "BizJtdyzjbhxx.findByBhlx", query = "SELECT b FROM BizJtdyzjbhxx b WHERE b.bhlx = :bhlx"),
    @NamedQuery(name = "BizJtdyzjbhxx.findByZjbhje", query = "SELECT b FROM BizJtdyzjbhxx b WHERE b.zjbhje = :zjbhje"),
    @NamedQuery(name = "BizJtdyzjbhxx.findByBhrq", query = "SELECT b FROM BizJtdyzjbhxx b WHERE b.bhrq = :bhrq"),
    @NamedQuery(name = "BizJtdyzjbhxx.findBySxny", query = "SELECT b FROM BizJtdyzjbhxx b WHERE b.sxny = :sxny"),
    @NamedQuery(name = "BizJtdyzjbhxx.findByZllx", query = "SELECT b FROM BizJtdyzjbhxx b WHERE b.zllx = :zllx"),
    @NamedQuery(name = "BizJtdyzjbhxx.findByCzsj", query = "SELECT b FROM BizJtdyzjbhxx b WHERE b.czsj = :czsj")})
public class BizJtdyzjbhxx implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BizJtdyzjbhxxPK bizJtdyzjbhxxPK;
    @Column(length = 3)
    private String bhlx;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 7, scale = 2)
    private BigDecimal zjbhje;
    @Column(length = 10)
    private String bhrq;
    @Column(length = 10)
    private String sxny;
    @Column(length = 1)
    private String zllx;
    @Column(length = 19)
    private String czsj;

    public BizJtdyzjbhxx() {
    }

    public BizJtdyzjbhxx(BizJtdyzjbhxxPK bizJtdyzjbhxxPK) {
        this.bizJtdyzjbhxxPK = bizJtdyzjbhxxPK;
    }

    public BizJtdyzjbhxx(long xh, String jtlsid) {
        this.bizJtdyzjbhxxPK = new BizJtdyzjbhxxPK(xh, jtlsid);
    }

    public BizJtdyzjbhxxPK getBizJtdyzjbhxxPK() {
        return bizJtdyzjbhxxPK;
    }

    public void setBizJtdyzjbhxxPK(BizJtdyzjbhxxPK bizJtdyzjbhxxPK) {
        this.bizJtdyzjbhxxPK = bizJtdyzjbhxxPK;
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
        hash += (bizJtdyzjbhxxPK != null ? bizJtdyzjbhxxPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BizJtdyzjbhxx)) {
            return false;
        }
        BizJtdyzjbhxx other = (BizJtdyzjbhxx) object;
        if ((this.bizJtdyzjbhxxPK == null && other.bizJtdyzjbhxxPK != null) || (this.bizJtdyzjbhxxPK != null && !this.bizJtdyzjbhxxPK.equals(other.bizJtdyzjbhxxPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BizJtdyzjbhxx[ bizJtdyzjbhxxPK=" + bizJtdyzjbhxxPK + " ]";
    }
    
}
