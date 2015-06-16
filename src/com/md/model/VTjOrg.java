/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
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
@Table(name = "V_TJ_ORG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VTjOrg.findAll", query = "SELECT v FROM VTjOrg v"),
    @NamedQuery(name = "VTjOrg.findByOrgid", query = "SELECT v FROM VTjOrg v WHERE v.orgid = :orgid"),
    @NamedQuery(name = "VTjOrg.findByOrgcode", query = "SELECT v FROM VTjOrg v WHERE v.orgcode = :orgcode"),
    @NamedQuery(name = "VTjOrg.findByOrgname", query = "SELECT v FROM VTjOrg v WHERE v.orgname = :orgname"),
    @NamedQuery(name = "VTjOrg.findByOrglevel", query = "SELECT v FROM VTjOrg v WHERE v.orglevel = :orglevel"),
    @NamedQuery(name = "VTjOrg.findByParentid", query = "SELECT v FROM VTjOrg v WHERE v.parentid = :parentid"),
    @NamedQuery(name = "VTjOrg.findByZt", query = "SELECT v FROM VTjOrg v WHERE v.zt = :zt"),
    @NamedQuery(name = "VTjOrg.findByZllx", query = "SELECT v FROM VTjOrg v WHERE v.zllx = :zllx"),
    @NamedQuery(name = "VTjOrg.findByJltime", query = "SELECT v FROM VTjOrg v WHERE v.jltime = :jltime"),
    @NamedQuery(name = "VTjOrg.findByT", query = "SELECT v FROM VTjOrg v WHERE v.t = :t")})
public class VTjOrg implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "ORGID")
    private String orgid;
    @Basic(optional = false)
    @Column(name = "ORGCODE")
    private String orgcode;
    @Column(name = "ORGNAME")
    private String orgname;
    @Column(name = "ORGLEVEL")
    private BigInteger orglevel;
    @Column(name = "PARENTID")
    private String parentid;
    @Column(name = "ZT")
    private Character zt;
    @Column(name = "ZLLX")
    private Character zllx;
    @Column(name = "JLTIME")
    private String jltime;
    @Column(name = "T")
    private String t;

    public VTjOrg() {
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public BigInteger getOrglevel() {
        return orglevel;
    }

    public void setOrglevel(BigInteger orglevel) {
        this.orglevel = orglevel;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public Character getZt() {
        return zt;
    }

    public void setZt(Character zt) {
        this.zt = zt;
    }

    public Character getZllx() {
        return zllx;
    }

    public void setZllx(Character zllx) {
        this.zllx = zllx;
    }

    public String getJltime() {
        return jltime;
    }

    public void setJltime(String jltime) {
        this.jltime = jltime;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }
    
}
