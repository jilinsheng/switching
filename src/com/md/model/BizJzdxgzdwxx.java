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
@Table(name = "BIZ_JZDXGZDWXX", catalog = "", schema = "SWITCHING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BizJzdxgzdwxx.findAll", query = "SELECT b FROM BizJzdxgzdwxx b"),
    @NamedQuery(name = "BizJzdxgzdwxx.findByXh", query = "SELECT b FROM BizJzdxgzdwxx b WHERE b.xh = :xh"),
    @NamedQuery(name = "BizJzdxgzdwxx.findByGzdwlsid", query = "SELECT b FROM BizJzdxgzdwxx b WHERE b.gzdwlsid = :gzdwlsid"),
    @NamedQuery(name = "BizJzdxgzdwxx.findByRylsid", query = "SELECT b FROM BizJzdxgzdwxx b WHERE b.rylsid = :rylsid"),
    @NamedQuery(name = "BizJzdxgzdwxx.findByCysfzhm", query = "SELECT b FROM BizJzdxgzdwxx b WHERE b.cysfzhm = :cysfzhm"),
    @NamedQuery(name = "BizJzdxgzdwxx.findByDwmc", query = "SELECT b FROM BizJzdxgzdwxx b WHERE b.dwmc = :dwmc"),
    @NamedQuery(name = "BizJzdxgzdwxx.findByDwxz", query = "SELECT b FROM BizJzdxgzdwxx b WHERE b.dwxz = :dwxz"),
    @NamedQuery(name = "BizJzdxgzdwxx.findByLxdh", query = "SELECT b FROM BizJzdxgzdwxx b WHERE b.lxdh = :lxdh"),
    @NamedQuery(name = "BizJzdxgzdwxx.findByDz", query = "SELECT b FROM BizJzdxgzdwxx b WHERE b.dz = :dz"),
    @NamedQuery(name = "BizJzdxgzdwxx.findByZllx", query = "SELECT b FROM BizJzdxgzdwxx b WHERE b.zllx = :zllx"),
    @NamedQuery(name = "BizJzdxgzdwxx.findByCzsj", query = "SELECT b FROM BizJzdxgzdwxx b WHERE b.czsj = :czsj")})
public class BizJzdxgzdwxx implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long xh;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 32)
    private String gzdwlsid;
    @Column(length = 32)
    private String rylsid;
    @Column(length = 18)
    private String cysfzhm;
    @Column(length = 50)
    private String dwmc;
    @Column(length = 3)
    private String dwxz;
    @Column(length = 50)
    private String lxdh;
    @Column(length = 60)
    private String dz;
    @Column(length = 1)
    private String zllx;
    @Column(length = 19)
    private String czsj;

    public BizJzdxgzdwxx() {
    }

    public BizJzdxgzdwxx(String gzdwlsid) {
        this.gzdwlsid = gzdwlsid;
    }

    public Long getXh() {
        return xh;
    }

    public void setXh(Long xh) {
        this.xh = xh;
    }

    public String getGzdwlsid() {
        return gzdwlsid;
    }

    public void setGzdwlsid(String gzdwlsid) {
        this.gzdwlsid = gzdwlsid;
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

    public String getDwmc() {
        return dwmc;
    }

    public void setDwmc(String dwmc) {
        this.dwmc = dwmc;
    }

    public String getDwxz() {
        return dwxz;
    }

    public void setDwxz(String dwxz) {
        this.dwxz = dwxz;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getDz() {
        return dz;
    }

    public void setDz(String dz) {
        this.dz = dz;
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
        hash += (gzdwlsid != null ? gzdwlsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BizJzdxgzdwxx)) {
            return false;
        }
        BizJzdxgzdwxx other = (BizJzdxgzdwxx) object;
        if ((this.gzdwlsid == null && other.gzdwlsid != null) || (this.gzdwlsid != null && !this.gzdwlsid.equals(other.gzdwlsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BizJzdxgzdwxx[ gzdwlsid=" + gzdwlsid + " ]";
    }
    
}
