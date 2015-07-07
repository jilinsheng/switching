/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.model;

import java.io.Serializable;
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
@Table(name = "BIZ_JZBZXX", catalog = "", schema = "SWITCHING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BizJzbzxx.findAll", query = "SELECT b FROM BizJzbzxx b"),
    @NamedQuery(name = "BizJzbzxx.findByXh", query = "SELECT b FROM BizJzbzxx b WHERE b.xh = :xh"),
    @NamedQuery(name = "BizJzbzxx.findByBzje", query = "SELECT b FROM BizJzbzxx b WHERE b.bzje = :bzje"),
    @NamedQuery(name = "BizJzbzxx.findByQyrq", query = "SELECT b FROM BizJzbzxx b WHERE b.qyrq = :qyrq"),
    @NamedQuery(name = "BizJzbzxx.findByFzrq", query = "SELECT b FROM BizJzbzxx b WHERE b.fzrq = :fzrq"),
    @NamedQuery(name = "BizJzbzxx.findByFbwjh", query = "SELECT b FROM BizJzbzxx b WHERE b.fbwjh = :fbwjh"),
    @NamedQuery(name = "BizJzbzxx.findByJzywlx", query = "SELECT b FROM BizJzbzxx b WHERE b.jzywlx = :jzywlx"),
    @NamedQuery(name = "BizJzbzxx.findByJzbzlx", query = "SELECT b FROM BizJzbzxx b WHERE b.jzbzlx = :jzbzlx"),
    @NamedQuery(name = "BizJzbzxx.findByJgid", query = "SELECT b FROM BizJzbzxx b WHERE b.jgid = :jgid"),
    @NamedQuery(name = "BizJzbzxx.findByZllx", query = "SELECT b FROM BizJzbzxx b WHERE b.zllx = :zllx"),
    @NamedQuery(name = "BizJzbzxx.findByCzsj", query = "SELECT b FROM BizJzbzxx b WHERE b.czsj = :czsj")})
public class BizJzbzxx implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long xh;
    @Column(length = 12)
    private String bzje;
    @Column(length = 10)
    private String qyrq;
    @Column(length = 10)
    private String fzrq;
    @Column(length = 50)
    private String fbwjh;
    @Column(length = 3)
    private String jzywlx;
    @Column(length = 3)
    private String jzbzlx;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 32)
    private String jgid;
    @Column(length = 1)
    private String zllx;
    @Column(length = 19)
    private String czsj;

    public BizJzbzxx() {
    }

    public BizJzbzxx(String jgid) {
        this.jgid = jgid;
    }

    public Long getXh() {
        return xh;
    }

    public void setXh(Long xh) {
        this.xh = xh;
    }

    public String getBzje() {
        return bzje;
    }

    public void setBzje(String bzje) {
        this.bzje = bzje;
    }

    public String getQyrq() {
        return qyrq;
    }

    public void setQyrq(String qyrq) {
        this.qyrq = qyrq;
    }

    public String getFzrq() {
        return fzrq;
    }

    public void setFzrq(String fzrq) {
        this.fzrq = fzrq;
    }

    public String getFbwjh() {
        return fbwjh;
    }

    public void setFbwjh(String fbwjh) {
        this.fbwjh = fbwjh;
    }

    public String getJzywlx() {
        return jzywlx;
    }

    public void setJzywlx(String jzywlx) {
        this.jzywlx = jzywlx;
    }

    public String getJzbzlx() {
        return jzbzlx;
    }

    public void setJzbzlx(String jzbzlx) {
        this.jzbzlx = jzbzlx;
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
        if (!(object instanceof BizJzbzxx)) {
            return false;
        }
        BizJzbzxx other = (BizJzbzxx) object;
        if ((this.jgid == null && other.jgid != null) || (this.jgid != null && !this.jgid.equals(other.jgid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BizJzbzxx[ jgid=" + jgid + " ]";
    }
    
}
