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
@Table(name = "MV_TJ_ORG", catalog = "", schema = "SWITCHING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MvTjOrg.findAll", query = "SELECT m FROM MvTjOrg m"),
    @NamedQuery(name = "MvTjOrg.findByOrgid", query = "SELECT m FROM MvTjOrg m WHERE m.orgid = :orgid"),
    @NamedQuery(name = "MvTjOrg.findByOrgname", query = "SELECT m FROM MvTjOrg m WHERE m.orgname = :orgname"),
    @NamedQuery(name = "MvTjOrg.findByParentid", query = "SELECT m FROM MvTjOrg m WHERE m.parentid = :parentid"),
    @NamedQuery(name = "MvTjOrg.findByLayer", query = "SELECT m FROM MvTjOrg m WHERE m.layer = :layer"),
    @NamedQuery(name = "MvTjOrg.findByYffullname", query = "SELECT m FROM MvTjOrg m WHERE m.yffullname = :yffullname")})
public class MvTjOrg implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String orgid;
    @Column(length = 100)
    private String orgname;
    @Column(length = 50)
    private String parentid;
    private BigInteger layer;
    @Column(length = 200)
    private String yffullname;

    public MvTjOrg() {
    }

    public MvTjOrg(String orgid) {
        this.orgid = orgid;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public BigInteger getLayer() {
        return layer;
    }

    public void setLayer(BigInteger layer) {
        this.layer = layer;
    }

    public String getYffullname() {
        return yffullname;
    }

    public void setYffullname(String yffullname) {
        this.yffullname = yffullname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orgid != null ? orgid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MvTjOrg)) {
            return false;
        }
        MvTjOrg other = (MvTjOrg) object;
        if ((this.orgid == null && other.orgid != null) || (this.orgid != null && !this.orgid.equals(other.orgid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.MvTjOrg[ orgid=" + orgid + " ]";
    }
    
}
