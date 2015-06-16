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
@Table(name = "BIZ_RKTJXX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BizRktjxx.findAll", query = "SELECT b FROM BizRktjxx b"),
    @NamedQuery(name = "BizRktjxx.findByXh", query = "SELECT b FROM BizRktjxx b WHERE b.xh = :xh"),
    @NamedQuery(name = "BizRktjxx.findByQxxzqhbm", query = "SELECT b FROM BizRktjxx b WHERE b.qxxzqhbm = :qxxzqhbm"),
    @NamedQuery(name = "BizRktjxx.findByFnyrks", query = "SELECT b FROM BizRktjxx b WHERE b.fnyrks = :fnyrks"),
    @NamedQuery(name = "BizRktjxx.findByNyrks", query = "SELECT b FROM BizRktjxx b WHERE b.nyrks = :nyrks"),
    @NamedQuery(name = "BizRktjxx.findByTjnd", query = "SELECT b FROM BizRktjxx b WHERE b.tjnd = :tjnd"),
    @NamedQuery(name = "BizRktjxx.findByZllx", query = "SELECT b FROM BizRktjxx b WHERE b.zllx = :zllx"),
    @NamedQuery(name = "BizRktjxx.findByCzsj", query = "SELECT b FROM BizRktjxx b WHERE b.czsj = :czsj")})
public class BizRktjxx implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "XH")
    private Long xh;
    @Id
    @Basic(optional = false)
    @Column(name = "QXXZQHBM")
    private String qxxzqhbm;
    @Column(name = "FNYRKS")
    private Long fnyrks;
    @Column(name = "NYRKS")
    private Long nyrks;
    @Column(name = "TJND")
    private String tjnd;
    @Column(name = "ZLLX")
    private String zllx;
    @Column(name = "CZSJ")
    private String czsj;

    public BizRktjxx() {
    }

    public BizRktjxx(String qxxzqhbm) {
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

    public Long getFnyrks() {
        return fnyrks;
    }

    public void setFnyrks(Long fnyrks) {
        this.fnyrks = fnyrks;
    }

    public Long getNyrks() {
        return nyrks;
    }

    public void setNyrks(Long nyrks) {
        this.nyrks = nyrks;
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
        if (!(object instanceof BizRktjxx)) {
            return false;
        }
        BizRktjxx other = (BizRktjxx) object;
        if ((this.qxxzqhbm == null && other.qxxzqhbm != null) || (this.qxxzqhbm != null && !this.qxxzqhbm.equals(other.qxxzqhbm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BizRktjxx[ qxxzqhbm=" + qxxzqhbm + " ]";
    }
    
}
