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
@Table(name = "BASE_GYJGXX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BaseGyjgxx.findAll", query = "SELECT b FROM BaseGyjgxx b"),
    @NamedQuery(name = "BaseGyjgxx.findByXh", query = "SELECT b FROM BaseGyjgxx b WHERE b.xh = :xh"),
    @NamedQuery(name = "BaseGyjgxx.findByJgid", query = "SELECT b FROM BaseGyjgxx b WHERE b.jgid = :jgid"),
    @NamedQuery(name = "BaseGyjgxx.findByJgbm", query = "SELECT b FROM BaseGyjgxx b WHERE b.jgbm = :jgbm"),
    @NamedQuery(name = "BaseGyjgxx.findByJgmc", query = "SELECT b FROM BaseGyjgxx b WHERE b.jgmc = :jgmc"),
    @NamedQuery(name = "BaseGyjgxx.findByNd", query = "SELECT b FROM BaseGyjgxx b WHERE b.nd = :nd"),
    @NamedQuery(name = "BaseGyjgxx.findBySjjgid", query = "SELECT b FROM BaseGyjgxx b WHERE b.sjjgid = :sjjgid"),
    @NamedQuery(name = "BaseGyjgxx.findByXzqhbm", query = "SELECT b FROM BaseGyjgxx b WHERE b.xzqhbm = :xzqhbm"),
    @NamedQuery(name = "BaseGyjgxx.findByJzmj", query = "SELECT b FROM BaseGyjgxx b WHERE b.jzmj = :jzmj"),
    @NamedQuery(name = "BaseGyjgxx.findByZdmj", query = "SELECT b FROM BaseGyjgxx b WHERE b.zdmj = :zdmj"),
    @NamedQuery(name = "BaseGyjgxx.findByCwsl", query = "SELECT b FROM BaseGyjgxx b WHERE b.cwsl = :cwsl"),
    @NamedQuery(name = "BaseGyjgxx.findByGdzc", query = "SELECT b FROM BaseGyjgxx b WHERE b.gdzc = :gdzc"),
    @NamedQuery(name = "BaseGyjgxx.findByNjrsr", query = "SELECT b FROM BaseGyjgxx b WHERE b.njrsr = :njrsr"),
    @NamedQuery(name = "BaseGyjgxx.findByNgzzcze", query = "SELECT b FROM BaseGyjgxx b WHERE b.ngzzcze = :ngzzcze"),
    @NamedQuery(name = "BaseGyjgxx.findByNrcgljf", query = "SELECT b FROM BaseGyjgxx b WHERE b.nrcgljf = :nrcgljf"),
    @NamedQuery(name = "BaseGyjgxx.findByGkjzj", query = "SELECT b FROM BaseGyjgxx b WHERE b.gkjzj = :gkjzj"),
    @NamedQuery(name = "BaseGyjgxx.findByGkjrq", query = "SELECT b FROM BaseGyjgxx b WHERE b.gkjrq = :gkjrq"),
    @NamedQuery(name = "BaseGyjgxx.findByZllx", query = "SELECT b FROM BaseGyjgxx b WHERE b.zllx = :zllx"),
    @NamedQuery(name = "BaseGyjgxx.findByCzsj", query = "SELECT b FROM BaseGyjgxx b WHERE b.czsj = :czsj")})
public class BaseGyjgxx implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "XH")
    private Integer xh;
    @Id
    @Basic(optional = false)
    @Column(name = "JGID")
    private String jgid;
    @Column(name = "JGBM")
    private String jgbm;
    @Column(name = "JGMC")
    private String jgmc;
    @Column(name = "ND")
    private String nd;
    @Column(name = "SJJGID")
    private String sjjgid;
    @Column(name = "XZQHBM")
    private String xzqhbm;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "JZMJ")
    private BigDecimal jzmj;
    @Column(name = "ZDMJ")
    private BigDecimal zdmj;
    @Column(name = "CWSL")
    private Integer cwsl;
    @Column(name = "GDZC")
    private BigDecimal gdzc;
    @Column(name = "NJRSR")
    private BigDecimal njrsr;
    @Column(name = "NGZZCZE")
    private BigDecimal ngzzcze;
    @Column(name = "NRCGLJF")
    private BigDecimal nrcgljf;
    @Column(name = "GKJZJ")
    private BigDecimal gkjzj;
    @Column(name = "GKJRQ")
    private String gkjrq;
    @Column(name = "ZLLX")
    private String zllx;
    @Column(name = "CZSJ")
    private String czsj;

    public BaseGyjgxx() {
    }

    public BaseGyjgxx(String jgid) {
        this.jgid = jgid;
    }

    public Integer getXh() {
        return xh;
    }

    public void setXh(Integer xh) {
        this.xh = xh;
    }

    public String getJgid() {
        return jgid;
    }

    public void setJgid(String jgid) {
        this.jgid = jgid;
    }

    public String getJgbm() {
        return jgbm;
    }

    public void setJgbm(String jgbm) {
        this.jgbm = jgbm;
    }

    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }

    public String getNd() {
        return nd;
    }

    public void setNd(String nd) {
        this.nd = nd;
    }

    public String getSjjgid() {
        return sjjgid;
    }

    public void setSjjgid(String sjjgid) {
        this.sjjgid = sjjgid;
    }

    public String getXzqhbm() {
        return xzqhbm;
    }

    public void setXzqhbm(String xzqhbm) {
        this.xzqhbm = xzqhbm;
    }

    public BigDecimal getJzmj() {
        return jzmj;
    }

    public void setJzmj(BigDecimal jzmj) {
        this.jzmj = jzmj;
    }

    public BigDecimal getZdmj() {
        return zdmj;
    }

    public void setZdmj(BigDecimal zdmj) {
        this.zdmj = zdmj;
    }

    public Integer getCwsl() {
        return cwsl;
    }

    public void setCwsl(Integer cwsl) {
        this.cwsl = cwsl;
    }

    public BigDecimal getGdzc() {
        return gdzc;
    }

    public void setGdzc(BigDecimal gdzc) {
        this.gdzc = gdzc;
    }

    public BigDecimal getNjrsr() {
        return njrsr;
    }

    public void setNjrsr(BigDecimal njrsr) {
        this.njrsr = njrsr;
    }

    public BigDecimal getNgzzcze() {
        return ngzzcze;
    }

    public void setNgzzcze(BigDecimal ngzzcze) {
        this.ngzzcze = ngzzcze;
    }

    public BigDecimal getNrcgljf() {
        return nrcgljf;
    }

    public void setNrcgljf(BigDecimal nrcgljf) {
        this.nrcgljf = nrcgljf;
    }

    public BigDecimal getGkjzj() {
        return gkjzj;
    }

    public void setGkjzj(BigDecimal gkjzj) {
        this.gkjzj = gkjzj;
    }

    public String getGkjrq() {
        return gkjrq;
    }

    public void setGkjrq(String gkjrq) {
        this.gkjrq = gkjrq;
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
        if (!(object instanceof BaseGyjgxx)) {
            return false;
        }
        BaseGyjgxx other = (BaseGyjgxx) object;
        if ((this.jgid == null && other.jgid != null) || (this.jgid != null && !this.jgid.equals(other.jgid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BaseGyjgxx[ jgid=" + jgid + " ]";
    }
    
}
