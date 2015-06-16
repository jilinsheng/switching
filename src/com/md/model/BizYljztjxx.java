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
@Table(name = "BIZ_YLJZTJXX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BizYljztjxx.findAll", query = "SELECT b FROM BizYljztjxx b"),
    @NamedQuery(name = "BizYljztjxx.findByXh", query = "SELECT b FROM BizYljztjxx b WHERE b.xh = :xh"),
    @NamedQuery(name = "BizYljztjxx.findByQxxzqhbm", query = "SELECT b FROM BizYljztjxx b WHERE b.qxxzqhbm = :qxxzqhbm"),
    @NamedQuery(name = "BizYljztjxx.findByYnrcsyldbrs", query = "SELECT b FROM BizYljztjxx b WHERE b.ynrcsyldbrs = :ynrcsyldbrs"),
    @NamedQuery(name = "BizYljztjxx.findByYnrncyldbrs", query = "SELECT b FROM BizYljztjxx b WHERE b.ynrncyldbrs = :ynrncyldbrs"),
    @NamedQuery(name = "BizYljztjxx.findByMzjznfdx", query = "SELECT b FROM BizYljztjxx b WHERE b.mzjznfdx = :mzjznfdx"),
    @NamedQuery(name = "BizYljztjxx.findByZyjznfdx", query = "SELECT b FROM BizYljztjxx b WHERE b.zyjznfdx = :zyjznfdx"),
    @NamedQuery(name = "BizYljztjxx.findByPjjzbl", query = "SELECT b FROM BizYljztjxx b WHERE b.pjjzbl = :pjjzbl"),
    @NamedQuery(name = "BizYljztjxx.findByMzjzqfx", query = "SELECT b FROM BizYljztjxx b WHERE b.mzjzqfx = :mzjzqfx"),
    @NamedQuery(name = "BizYljztjxx.findByZyjzqfx", query = "SELECT b FROM BizYljztjxx b WHERE b.zyjzqfx = :zyjzqfx"),
    @NamedQuery(name = "BizYljztjxx.findByTjnd", query = "SELECT b FROM BizYljztjxx b WHERE b.tjnd = :tjnd"),
    @NamedQuery(name = "BizYljztjxx.findByZllx", query = "SELECT b FROM BizYljztjxx b WHERE b.zllx = :zllx"),
    @NamedQuery(name = "BizYljztjxx.findByCzsj", query = "SELECT b FROM BizYljztjxx b WHERE b.czsj = :czsj")})
public class BizYljztjxx implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "XH")
    private Long xh;
    @Id
    @Basic(optional = false)
    @Column(name = "QXXZQHBM")
    private String qxxzqhbm;
    @Column(name = "YNRCSYLDBRS")
    private Long ynrcsyldbrs;
    @Column(name = "YNRNCYLDBRS")
    private Long ynrncyldbrs;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MZJZNFDX")
    private BigDecimal mzjznfdx;
    @Column(name = "ZYJZNFDX")
    private BigDecimal zyjznfdx;
    @Column(name = "PJJZBL")
    private Integer pjjzbl;
    @Column(name = "MZJZQFX")
    private BigDecimal mzjzqfx;
    @Column(name = "ZYJZQFX")
    private BigDecimal zyjzqfx;
    @Column(name = "TJND")
    private String tjnd;
    @Column(name = "ZLLX")
    private String zllx;
    @Column(name = "CZSJ")
    private String czsj;

    public BizYljztjxx() {
    }

    public BizYljztjxx(String qxxzqhbm) {
        this.qxxzqhbm = qxxzqhbm;
    }

    public Long getXh() {
        return xh;
    }

    public void setXh(Long xh) {
        this.xh = xh;
    }

    public String getQxxzqhbm() {
        return qxxzqhbm;
    }

    public void setQxxzqhbm(String qxxzqhbm) {
        this.qxxzqhbm = qxxzqhbm;
    }

    public Long getYnrcsyldbrs() {
        return ynrcsyldbrs;
    }

    public void setYnrcsyldbrs(Long ynrcsyldbrs) {
        this.ynrcsyldbrs = ynrcsyldbrs;
    }

    public Long getYnrncyldbrs() {
        return ynrncyldbrs;
    }

    public void setYnrncyldbrs(Long ynrncyldbrs) {
        this.ynrncyldbrs = ynrncyldbrs;
    }

    public BigDecimal getMzjznfdx() {
        return mzjznfdx;
    }

    public void setMzjznfdx(BigDecimal mzjznfdx) {
        this.mzjznfdx = mzjznfdx;
    }

    public BigDecimal getZyjznfdx() {
        return zyjznfdx;
    }

    public void setZyjznfdx(BigDecimal zyjznfdx) {
        this.zyjznfdx = zyjznfdx;
    }

    public Integer getPjjzbl() {
        return pjjzbl;
    }

    public void setPjjzbl(Integer pjjzbl) {
        this.pjjzbl = pjjzbl;
    }

    public BigDecimal getMzjzqfx() {
        return mzjzqfx;
    }

    public void setMzjzqfx(BigDecimal mzjzqfx) {
        this.mzjzqfx = mzjzqfx;
    }

    public BigDecimal getZyjzqfx() {
        return zyjzqfx;
    }

    public void setZyjzqfx(BigDecimal zyjzqfx) {
        this.zyjzqfx = zyjzqfx;
    }

    public String getTjnd() {
        return tjnd;
    }

    public void setTjnd(String tjnd) {
        this.tjnd = tjnd;
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
        hash += (qxxzqhbm != null ? qxxzqhbm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BizYljztjxx)) {
            return false;
        }
        BizYljztjxx other = (BizYljztjxx) object;
        if ((this.qxxzqhbm == null && other.qxxzqhbm != null) || (this.qxxzqhbm != null && !this.qxxzqhbm.equals(other.qxxzqhbm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BizYljztjxx[ qxxzqhbm=" + qxxzqhbm + " ]";
    }
    
}
