/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.model;

import java.io.Serializable;
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
@Table(name = "BIZ_JZDXJYXX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BizJzdxjyxx.findAll", query = "SELECT b FROM BizJzdxjyxx b"),
    @NamedQuery(name = "BizJzdxjyxx.findByXh", query = "SELECT b FROM BizJzdxjyxx b WHERE b.xh = :xh"),
    @NamedQuery(name = "BizJzdxjyxx.findByJylsid", query = "SELECT b FROM BizJzdxjyxx b WHERE b.bizJzdxjyxxPK.jylsid = :jylsid"),
    @NamedQuery(name = "BizJzdxjyxx.findByRylsid", query = "SELECT b FROM BizJzdxjyxx b WHERE b.bizJzdxjyxxPK.rylsid = :rylsid"),
    @NamedQuery(name = "BizJzdxjyxx.findByCysfzhm", query = "SELECT b FROM BizJzdxjyxx b WHERE b.cysfzhm = :cysfzhm"),
    @NamedQuery(name = "BizJzdxjyxx.findByXxmc", query = "SELECT b FROM BizJzdxjyxx b WHERE b.xxmc = :xxmc"),
    @NamedQuery(name = "BizJzdxjyxx.findByXxlb", query = "SELECT b FROM BizJzdxjyxx b WHERE b.xxlb = :xxlb"),
    @NamedQuery(name = "BizJzdxjyxx.findByRxsj", query = "SELECT b FROM BizJzdxjyxx b WHERE b.rxsj = :rxsj"),
    @NamedQuery(name = "BizJzdxjyxx.findByBysj", query = "SELECT b FROM BizJzdxjyxx b WHERE b.bysj = :bysj"),
    @NamedQuery(name = "BizJzdxjyxx.findByZllx", query = "SELECT b FROM BizJzdxjyxx b WHERE b.zllx = :zllx"),
    @NamedQuery(name = "BizJzdxjyxx.findByCzsj", query = "SELECT b FROM BizJzdxjyxx b WHERE b.czsj = :czsj")})
public class BizJzdxjyxx implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BizJzdxjyxxPK bizJzdxjyxxPK;
    @Column(name = "XH")
    private Long xh;
    @Column(name = "CYSFZHM")
    private String cysfzhm;
    @Column(name = "XXMC")
    private String xxmc;
    @Column(name = "XXLB")
    private String xxlb;
    @Column(name = "RXSJ")
    private String rxsj;
    @Column(name = "BYSJ")
    private String bysj;
    @Column(name = "ZLLX")
    private String zllx;
    @Column(name = "CZSJ")
    private String czsj;

    public BizJzdxjyxx() {
    }

    public BizJzdxjyxx(BizJzdxjyxxPK bizJzdxjyxxPK) {
        this.bizJzdxjyxxPK = bizJzdxjyxxPK;
    }

    public BizJzdxjyxx(String jylsid, String rylsid) {
        this.bizJzdxjyxxPK = new BizJzdxjyxxPK(jylsid, rylsid);
    }

    public BizJzdxjyxxPK getBizJzdxjyxxPK() {
        return bizJzdxjyxxPK;
    }

    public void setBizJzdxjyxxPK(BizJzdxjyxxPK bizJzdxjyxxPK) {
        this.bizJzdxjyxxPK = bizJzdxjyxxPK;
    }

    public Long getXh() {
        return xh;
    }

    public void setXh(Long xh) {
        this.xh = xh;
    }

    public String getCysfzhm() {
        return cysfzhm;
    }

    public void setCysfzhm(String cysfzhm) {
        this.cysfzhm = cysfzhm;
    }

    public String getXxmc() {
        return xxmc;
    }

    public void setXxmc(String xxmc) {
        this.xxmc = xxmc;
    }

    public String getXxlb() {
        return xxlb;
    }

    public void setXxlb(String xxlb) {
        this.xxlb = xxlb;
    }

    public String getRxsj() {
        return rxsj;
    }

    public void setRxsj(String rxsj) {
        this.rxsj = rxsj;
    }

    public String getBysj() {
        return bysj;
    }

    public void setBysj(String bysj) {
        this.bysj = bysj;
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
        hash += (bizJzdxjyxxPK != null ? bizJzdxjyxxPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BizJzdxjyxx)) {
            return false;
        }
        BizJzdxjyxx other = (BizJzdxjyxx) object;
        if ((this.bizJzdxjyxxPK == null && other.bizJzdxjyxxPK != null) || (this.bizJzdxjyxxPK != null && !this.bizJzdxjyxxPK.equals(other.bizJzdxjyxxPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BizJzdxjyxx[ bizJzdxjyxxPK=" + bizJzdxjyxxPK + " ]";
    }
    
}
