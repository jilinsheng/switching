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
@Table(name = "BIZ_JZDXSRXX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BizJzdxsrxx.findAll", query = "SELECT b FROM BizJzdxsrxx b"),
    @NamedQuery(name = "BizJzdxsrxx.findByXh", query = "SELECT b FROM BizJzdxsrxx b WHERE b.xh = :xh"),
    @NamedQuery(name = "BizJzdxsrxx.findByJzdxsrlsid", query = "SELECT b FROM BizJzdxsrxx b WHERE b.jzdxsrlsid = :jzdxsrlsid"),
    @NamedQuery(name = "BizJzdxsrxx.findByRylsid", query = "SELECT b FROM BizJzdxsrxx b WHERE b.rylsid = :rylsid"),
    @NamedQuery(name = "BizJzdxsrxx.findByCysfzhm", query = "SELECT b FROM BizJzdxsrxx b WHERE b.cysfzhm = :cysfzhm"),
    @NamedQuery(name = "BizJzdxsrxx.findBySrlx", query = "SELECT b FROM BizJzdxsrxx b WHERE b.srlx = :srlx"),
    @NamedQuery(name = "BizJzdxsrxx.findByYsrje", query = "SELECT b FROM BizJzdxsrxx b WHERE b.ysrje = :ysrje"),
    @NamedQuery(name = "BizJzdxsrxx.findByNsrje", query = "SELECT b FROM BizJzdxsrxx b WHERE b.nsrje = :nsrje"),
    @NamedQuery(name = "BizJzdxsrxx.findByYjrje", query = "SELECT b FROM BizJzdxsrxx b WHERE b.yjrje = :yjrje"),
    @NamedQuery(name = "BizJzdxsrxx.findByNjrje", query = "SELECT b FROM BizJzdxsrxx b WHERE b.njrje = :njrje"),
    @NamedQuery(name = "BizJzdxsrxx.findBySrjsfs", query = "SELECT b FROM BizJzdxsrxx b WHERE b.srjsfs = :srjsfs"),
    @NamedQuery(name = "BizJzdxsrxx.findByZllx", query = "SELECT b FROM BizJzdxsrxx b WHERE b.zllx = :zllx"),
    @NamedQuery(name = "BizJzdxsrxx.findByCzsj", query = "SELECT b FROM BizJzdxsrxx b WHERE b.czsj = :czsj")})
public class BizJzdxsrxx implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "XH")
    private Long xh;
    @Id
    @Basic(optional = false)
    @Column(name = "JZDXSRLSID")
    private String jzdxsrlsid;
    @Column(name = "RYLSID")
    private String rylsid;
    @Column(name = "CYSFZHM")
    private String cysfzhm;
    @Column(name = "SRLX")
    private String srlx;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "YSRJE")
    private BigDecimal ysrje;
    @Column(name = "NSRJE")
    private BigDecimal nsrje;
    @Column(name = "YJRJE")
    private BigDecimal yjrje;
    @Column(name = "NJRJE")
    private BigDecimal njrje;
    @Column(name = "SRJSFS")
    private String srjsfs;
    @Column(name = "ZLLX")
    private String zllx;
    @Column(name = "CZSJ")
    private String czsj;

    public BizJzdxsrxx() {
    }

    public BizJzdxsrxx(String jzdxsrlsid) {
        this.jzdxsrlsid = jzdxsrlsid;
    }

    public Long getXh() {
        return xh;
    }

    public void setXh(Long xh) {
        this.xh = xh;
    }

    public String getJzdxsrlsid() {
        return jzdxsrlsid;
    }

    public void setJzdxsrlsid(String jzdxsrlsid) {
        this.jzdxsrlsid = jzdxsrlsid;
    }

    public String getRylsid() {
        return rylsid;
    }

    public void setRylsid(String rylsid) {
        this.rylsid = rylsid;
    }

    public String getCysfzhm() {
        return cysfzhm;
    }

    public void setCysfzhm(String cysfzhm) {
        this.cysfzhm = cysfzhm;
    }

    public String getSrlx() {
        return srlx;
    }

    public void setSrlx(String srlx) {
        this.srlx = srlx;
    }

    public BigDecimal getYsrje() {
        return ysrje;
    }

    public void setYsrje(BigDecimal ysrje) {
        this.ysrje = ysrje;
    }

    public BigDecimal getNsrje() {
        return nsrje;
    }

    public void setNsrje(BigDecimal nsrje) {
        this.nsrje = nsrje;
    }

    public BigDecimal getYjrje() {
        return yjrje;
    }

    public void setYjrje(BigDecimal yjrje) {
        this.yjrje = yjrje;
    }

    public BigDecimal getNjrje() {
        return njrje;
    }

    public void setNjrje(BigDecimal njrje) {
        this.njrje = njrje;
    }

    public String getSrjsfs() {
        return srjsfs;
    }

    public void setSrjsfs(String srjsfs) {
        this.srjsfs = srjsfs;
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
        hash += (jzdxsrlsid != null ? jzdxsrlsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BizJzdxsrxx)) {
            return false;
        }
        BizJzdxsrxx other = (BizJzdxsrxx) object;
        if ((this.jzdxsrlsid == null && other.jzdxsrlsid != null) || (this.jzdxsrlsid != null && !this.jzdxsrlsid.equals(other.jzdxsrlsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BizJzdxsrxx[ jzdxsrlsid=" + jzdxsrlsid + " ]";
    }
    
}
