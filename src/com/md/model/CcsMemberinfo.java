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
@Table(name = "CCS_MEMBERINFO", catalog = "", schema = "SWITCHING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CcsMemberinfo.findAll", query = "SELECT c FROM CcsMemberinfo c"),
    @NamedQuery(name = "CcsMemberinfo.findByJtbm", query = "SELECT c FROM CcsMemberinfo c WHERE c.jtbm = :jtbm"),
    @NamedQuery(name = "CcsMemberinfo.findByDxsfzh", query = "SELECT c FROM CcsMemberinfo c WHERE c.dxsfzh = :dxsfzh"),
    @NamedQuery(name = "CcsMemberinfo.findByDxxm", query = "SELECT c FROM CcsMemberinfo c WHERE c.dxxm = :dxxm"),
    @NamedQuery(name = "CcsMemberinfo.findByXb", query = "SELECT c FROM CcsMemberinfo c WHERE c.xb = :xb"),
    @NamedQuery(name = "CcsMemberinfo.findByYhzgx", query = "SELECT c FROM CcsMemberinfo c WHERE c.yhzgx = :yhzgx"),
    @NamedQuery(name = "CcsMemberinfo.findByHklx", query = "SELECT c FROM CcsMemberinfo c WHERE c.hklx = :hklx"),
    @NamedQuery(name = "CcsMemberinfo.findByHkszd", query = "SELECT c FROM CcsMemberinfo c WHERE c.hkszd = :hkszd"),
    @NamedQuery(name = "CcsMemberinfo.findByJzdz", query = "SELECT c FROM CcsMemberinfo c WHERE c.jzdz = :jzdz"),
    @NamedQuery(name = "CcsMemberinfo.findByLxfs", query = "SELECT c FROM CcsMemberinfo c WHERE c.lxfs = :lxfs"),
    @NamedQuery(name = "CcsMemberinfo.findByStzk", query = "SELECT c FROM CcsMemberinfo c WHERE c.stzk = :stzk"),
    @NamedQuery(name = "CcsMemberinfo.findBySfcj", query = "SELECT c FROM CcsMemberinfo c WHERE c.sfcj = :sfcj"),
    @NamedQuery(name = "CcsMemberinfo.findByHbmc", query = "SELECT c FROM CcsMemberinfo c WHERE c.hbmc = :hbmc"),
    @NamedQuery(name = "CcsMemberinfo.findByZt", query = "SELECT c FROM CcsMemberinfo c WHERE c.zt = :zt"),
    @NamedQuery(name = "CcsMemberinfo.findByBgsj", query = "SELECT c FROM CcsMemberinfo c WHERE c.bgsj = :bgsj"),
    @NamedQuery(name = "CcsMemberinfo.findByOFamilyid", query = "SELECT c FROM CcsMemberinfo c WHERE c.oFamilyid = :oFamilyid"),
    @NamedQuery(name = "CcsMemberinfo.findByOMemberid", query = "SELECT c FROM CcsMemberinfo c WHERE c.oMemberid = :oMemberid"),
    @NamedQuery(name = "CcsMemberinfo.findByODs", query = "SELECT c FROM CcsMemberinfo c WHERE c.oDs = :oDs"),
    @NamedQuery(name = "CcsMemberinfo.findByOOnno", query = "SELECT c FROM CcsMemberinfo c WHERE c.oOnno = :oOnno"),
    @NamedQuery(name = "CcsMemberinfo.findByOFamilyno", query = "SELECT c FROM CcsMemberinfo c WHERE c.oFamilyno = :oFamilyno"),
    @NamedQuery(name = "CcsMemberinfo.findByZrowid", query = "SELECT c FROM CcsMemberinfo c WHERE c.zrowid = :zrowid")})
public class CcsMemberinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(length = 256)
    private String jtbm;
    @Column(length = 256)
    private String dxsfzh;
    @Column(length = 256)
    private String dxxm;
    @Column(length = 256)
    private String xb;
    @Column(length = 256)
    private String yhzgx;
    @Column(length = 256)
    private String hklx;
    @Column(length = 256)
    private String hkszd;
    @Column(length = 256)
    private String jzdz;
    @Column(length = 256)
    private String lxfs;
    @Column(length = 256)
    private String stzk;
    @Column(length = 256)
    private String sfcj;
    @Column(length = 256)
    private String hbmc;
    @Column(length = 256)
    private String zt;
    @Column(length = 256)
    private String bgsj;
    @Column(name = "O_FAMILYID", length = 256)
    private String oFamilyid;
    @Column(name = "O_MEMBERID", length = 256)
    private String oMemberid;
    @Column(name = "O_DS", length = 256)
    private String oDs;
    @Column(name = "O_ONNO", length = 256)
    private String oOnno;
    @Column(name = "O_FAMILYNO", length = 256)
    private String oFamilyno;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 256)
    private String zrowid;

    public CcsMemberinfo() {
    }

    public CcsMemberinfo(String zrowid) {
        this.zrowid = zrowid;
    }

    public String getJtbm() {
        return jtbm;
    }

    public void setJtbm(String jtbm) {
        this.jtbm = jtbm;
    }

    public String getDxsfzh() {
        return dxsfzh;
    }

    public void setDxsfzh(String dxsfzh) {
        this.dxsfzh = dxsfzh;
    }

    public String getDxxm() {
        return dxxm;
    }

    public void setDxxm(String dxxm) {
        this.dxxm = dxxm;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public String getYhzgx() {
        return yhzgx;
    }

    public void setYhzgx(String yhzgx) {
        this.yhzgx = yhzgx;
    }

    public String getHklx() {
        return hklx;
    }

    public void setHklx(String hklx) {
        this.hklx = hklx;
    }

    public String getHkszd() {
        return hkszd;
    }

    public void setHkszd(String hkszd) {
        this.hkszd = hkszd;
    }

    public String getJzdz() {
        return jzdz;
    }

    public void setJzdz(String jzdz) {
        this.jzdz = jzdz;
    }

    public String getLxfs() {
        return lxfs;
    }

    public void setLxfs(String lxfs) {
        this.lxfs = lxfs;
    }

    public String getStzk() {
        return stzk;
    }

    public void setStzk(String stzk) {
        this.stzk = stzk;
    }

    public String getSfcj() {
        return sfcj;
    }

    public void setSfcj(String sfcj) {
        this.sfcj = sfcj;
    }

    public String getHbmc() {
        return hbmc;
    }

    public void setHbmc(String hbmc) {
        this.hbmc = hbmc;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getBgsj() {
        return bgsj;
    }

    public void setBgsj(String bgsj) {
        this.bgsj = bgsj;
    }

    public String getOFamilyid() {
        return oFamilyid;
    }

    public void setOFamilyid(String oFamilyid) {
        this.oFamilyid = oFamilyid;
    }

    public String getOMemberid() {
        return oMemberid;
    }

    public void setOMemberid(String oMemberid) {
        this.oMemberid = oMemberid;
    }

    public String getODs() {
        return oDs;
    }

    public void setODs(String oDs) {
        this.oDs = oDs;
    }

    public String getOOnno() {
        return oOnno;
    }

    public void setOOnno(String oOnno) {
        this.oOnno = oOnno;
    }

    public String getOFamilyno() {
        return oFamilyno;
    }

    public void setOFamilyno(String oFamilyno) {
        this.oFamilyno = oFamilyno;
    }

    public String getZrowid() {
        return zrowid;
    }

    public void setZrowid(String zrowid) {
        this.zrowid = zrowid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zrowid != null ? zrowid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CcsMemberinfo)) {
            return false;
        }
        CcsMemberinfo other = (CcsMemberinfo) object;
        if ((this.zrowid == null && other.zrowid != null) || (this.zrowid != null && !this.zrowid.equals(other.zrowid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.CcsMemberinfo[ zrowid=" + zrowid + " ]";
    }
    
}
