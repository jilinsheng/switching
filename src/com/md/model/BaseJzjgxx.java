/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "BASE_JZJGXX", catalog = "", schema = "SWITCHING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BaseJzjgxx.findAll", query = "SELECT b FROM BaseJzjgxx b"),
    @NamedQuery(name = "BaseJzjgxx.findByXh", query = "SELECT b FROM BaseJzjgxx b WHERE b.xh = :xh"),
    @NamedQuery(name = "BaseJzjgxx.findByJgid", query = "SELECT b FROM BaseJzjgxx b WHERE b.jgid = :jgid"),
    @NamedQuery(name = "BaseJzjgxx.findByJgbm", query = "SELECT b FROM BaseJzjgxx b WHERE b.jgbm = :jgbm"),
    @NamedQuery(name = "BaseJzjgxx.findByJgmc", query = "SELECT b FROM BaseJzjgxx b WHERE b.jgmc = :jgmc"),
    @NamedQuery(name = "BaseJzjgxx.findBySjjgid", query = "SELECT b FROM BaseJzjgxx b WHERE b.sjjgid = :sjjgid"),
    @NamedQuery(name = "BaseJzjgxx.findByXzqhbm", query = "SELECT b FROM BaseJzjgxx b WHERE b.xzqhbm = :xzqhbm"),
    @NamedQuery(name = "BaseJzjgxx.findByGzrs", query = "SELECT b FROM BaseJzjgxx b WHERE b.gzrs = :gzrs"),
    @NamedQuery(name = "BaseJzjgxx.findByZzrs", query = "SELECT b FROM BaseJzjgxx b WHERE b.zzrs = :zzrs"),
    @NamedQuery(name = "BaseJzjgxx.findByJzrs", query = "SELECT b FROM BaseJzjgxx b WHERE b.jzrs = :jzrs"),
    @NamedQuery(name = "BaseJzjgxx.findByNd", query = "SELECT b FROM BaseJzjgxx b WHERE b.nd = :nd"),
    @NamedQuery(name = "BaseJzjgxx.findByNdgzjf", query = "SELECT b FROM BaseJzjgxx b WHERE b.ndgzjf = :ndgzjf"),
    @NamedQuery(name = "BaseJzjgxx.findByZllx", query = "SELECT b FROM BaseJzjgxx b WHERE b.zllx = :zllx"),
    @NamedQuery(name = "BaseJzjgxx.findByCzsj", query = "SELECT b FROM BaseJzjgxx b WHERE b.czsj = :czsj"),
    @NamedQuery(name = "BaseJzjgxx.findByCtime", query = "SELECT b FROM BaseJzjgxx b WHERE b.ctime = :ctime"),
    @NamedQuery(name = "BaseJzjgxx.findByOper", query = "SELECT b FROM BaseJzjgxx b WHERE b.oper = :oper")})
public class BaseJzjgxx implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer xh;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 32)
    private String jgid;
    @Column(length = 18)
    private String jgbm;
    @Column(length = 50)
    private String jgmc;
    @Column(length = 32)
    private String sjjgid;
    @Column(length = 12)
    private String xzqhbm;
    private Integer gzrs;
    private Integer zzrs;
    private Integer jzrs;
    @Column(length = 4)
    private String nd;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 15, scale = 2)
    private BigDecimal ndgzjf;
    @Column(length = 1)
    private String zllx;
    @Column(length = 19)
    private String czsj;
    @Temporal(TemporalType.TIMESTAMP)
    private Date ctime;
    @Column(length = 128)
    private String oper;

    public BaseJzjgxx() {
    }

    public BaseJzjgxx(String jgid) {
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

    public Integer getGzrs() {
        return gzrs;
    }

    public void setGzrs(Integer gzrs) {
        this.gzrs = gzrs;
    }

    public Integer getZzrs() {
        return zzrs;
    }

    public void setZzrs(Integer zzrs) {
        this.zzrs = zzrs;
    }

    public Integer getJzrs() {
        return jzrs;
    }

    public void setJzrs(Integer jzrs) {
        this.jzrs = jzrs;
    }

    public String getNd() {
        return nd;
    }

    public void setNd(String nd) {
        this.nd = nd;
    }

    public BigDecimal getNdgzjf() {
        return ndgzjf;
    }

    public void setNdgzjf(BigDecimal ndgzjf) {
        this.ndgzjf = ndgzjf;
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

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
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
        if (!(object instanceof BaseJzjgxx)) {
            return false;
        }
        BaseJzjgxx other = (BaseJzjgxx) object;
        if ((this.jgid == null && other.jgid != null) || (this.jgid != null && !this.jgid.equals(other.jgid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BaseJzjgxx[ jgid=" + jgid + " ]";
    }
    
}
