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
@Table(name = "BIZ_ZJJSXX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BizZjjsxx.findAll", query = "SELECT b FROM BizZjjsxx b"),
    @NamedQuery(name = "BizZjjsxx.findByXh", query = "SELECT b FROM BizZjjsxx b WHERE b.xh = :xh"),
    @NamedQuery(name = "BizZjjsxx.findByZjjsxxid", query = "SELECT b FROM BizZjjsxx b WHERE b.zjjsxxid = :zjjsxxid"),
    @NamedQuery(name = "BizZjjsxx.findByJsksny", query = "SELECT b FROM BizZjjsxx b WHERE b.jsksny = :jsksny"),
    @NamedQuery(name = "BizZjjsxx.findByJsrq", query = "SELECT b FROM BizZjjsxx b WHERE b.jsrq = :jsrq"),
    @NamedQuery(name = "BizZjjsxx.findByJsje", query = "SELECT b FROM BizZjjsxx b WHERE b.jsje = :jsje"),
    @NamedQuery(name = "BizZjjsxx.findByJsbm", query = "SELECT b FROM BizZjjsxx b WHERE b.jsbm = :jsbm"),
    @NamedQuery(name = "BizZjjsxx.findByJsjsny", query = "SELECT b FROM BizZjjsxx b WHERE b.jsjsny = :jsjsny"),
    @NamedQuery(name = "BizZjjsxx.findByJzywbm", query = "SELECT b FROM BizZjjsxx b WHERE b.jzywbm = :jzywbm"),
    @NamedQuery(name = "BizZjjsxx.findByJbjg", query = "SELECT b FROM BizZjjsxx b WHERE b.jbjg = :jbjg"),
    @NamedQuery(name = "BizZjjsxx.findByXzqhbm", query = "SELECT b FROM BizZjjsxx b WHERE b.xzqhbm = :xzqhbm"),
    @NamedQuery(name = "BizZjjsxx.findByZllx", query = "SELECT b FROM BizZjjsxx b WHERE b.zllx = :zllx"),
    @NamedQuery(name = "BizZjjsxx.findByCzsj", query = "SELECT b FROM BizZjjsxx b WHERE b.czsj = :czsj")})
public class BizZjjsxx implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "XH")
    private Long xh;
    @Id
    @Basic(optional = false)
    @Column(name = "ZJJSXXID")
    private String zjjsxxid;
    @Column(name = "JSKSNY")
    private String jsksny;
    @Column(name = "JSRQ")
    private String jsrq;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "JSJE")
    private BigDecimal jsje;
    @Column(name = "JSBM")
    private String jsbm;
    @Column(name = "JSJSNY")
    private String jsjsny;
    @Column(name = "JZYWBM")
    private String jzywbm;
    @Column(name = "JBJG")
    private String jbjg;
    @Column(name = "XZQHBM")
    private String xzqhbm;
    @Column(name = "ZLLX")
    private String zllx;
    @Column(name = "CZSJ")
    private String czsj;

    public BizZjjsxx() {
    }

    public BizZjjsxx(String zjjsxxid) {
        this.zjjsxxid = zjjsxxid;
    }

    public Long getXh() {
        return xh;
    }

    public void setXh(Long xh) {
        this.xh = xh;
    }

    public String getZjjsxxid() {
        return zjjsxxid;
    }

    public void setZjjsxxid(String zjjsxxid) {
        this.zjjsxxid = zjjsxxid;
    }

    public String getJsksny() {
        return jsksny;
    }

    public void setJsksny(String jsksny) {
        this.jsksny = jsksny;
    }

    public String getJsrq() {
        return jsrq;
    }

    public void setJsrq(String jsrq) {
        this.jsrq = jsrq;
    }

    public BigDecimal getJsje() {
        return jsje;
    }

    public void setJsje(BigDecimal jsje) {
        this.jsje = jsje;
    }

    public String getJsbm() {
        return jsbm;
    }

    public void setJsbm(String jsbm) {
        this.jsbm = jsbm;
    }

    public String getJsjsny() {
        return jsjsny;
    }

    public void setJsjsny(String jsjsny) {
        this.jsjsny = jsjsny;
    }

    public String getJzywbm() {
        return jzywbm;
    }

    public void setJzywbm(String jzywbm) {
        this.jzywbm = jzywbm;
    }

    public String getJbjg() {
        return jbjg;
    }

    public void setJbjg(String jbjg) {
        this.jbjg = jbjg;
    }

    public String getXzqhbm() {
        return xzqhbm;
    }

    public void setXzqhbm(String xzqhbm) {
        this.xzqhbm = xzqhbm;
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
        hash += (zjjsxxid != null ? zjjsxxid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BizZjjsxx)) {
            return false;
        }
        BizZjjsxx other = (BizZjjsxx) object;
        if ((this.zjjsxxid == null && other.zjjsxxid != null) || (this.zjjsxxid != null && !this.zjjsxxid.equals(other.zjjsxxid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BizZjjsxx[ zjjsxxid=" + zjjsxxid + " ]";
    }
    
}
