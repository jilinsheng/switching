/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.model.shengcs;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(catalog = "", schema = "JLDBCS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usercompanyinfo.findAll", query = "SELECT u FROM Usercompanyinfo u"),
    @NamedQuery(name = "Usercompanyinfo.findByUciId", query = "SELECT u FROM Usercompanyinfo u WHERE u.uciId = :uciId"),
    @NamedQuery(name = "Usercompanyinfo.findByUciCompname", query = "SELECT u FROM Usercompanyinfo u WHERE u.uciCompname = :uciCompname"),
    @NamedQuery(name = "Usercompanyinfo.findByUciComptype", query = "SELECT u FROM Usercompanyinfo u WHERE u.uciComptype = :uciComptype"),
    @NamedQuery(name = "Usercompanyinfo.findByUciCompstate", query = "SELECT u FROM Usercompanyinfo u WHERE u.uciCompstate = :uciCompstate"),
    @NamedQuery(name = "Usercompanyinfo.findByUciComplable", query = "SELECT u FROM Usercompanyinfo u WHERE u.uciComplable = :uciComplable"),
    @NamedQuery(name = "Usercompanyinfo.findByUciDescription", query = "SELECT u FROM Usercompanyinfo u WHERE u.uciDescription = :uciDescription"),
    @NamedQuery(name = "Usercompanyinfo.findByUciFlag", query = "SELECT u FROM Usercompanyinfo u WHERE u.uciFlag = :uciFlag"),
    @NamedQuery(name = "Usercompanyinfo.findByOlduciId", query = "SELECT u FROM Usercompanyinfo u WHERE u.olduciId = :olduciId")})
public class Usercompanyinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "UCI_ID", nullable = false, length = 50)
    private String uciId;
    @Column(name = "UCI_COMPNAME", length = 50)
    private String uciCompname;
    @Column(name = "UCI_COMPTYPE", length = 50)
    private String uciComptype;
    @Column(name = "UCI_COMPSTATE", length = 50)
    private String uciCompstate;
    @Column(name = "UCI_COMPLABLE", length = 50)
    private String uciComplable;
    @Column(name = "UCI_DESCRIPTION", length = 200)
    private String uciDescription;
    @Column(name = "UCI_FLAG", length = 20)
    private String uciFlag;
    @Column(name = "OLDUCI_ID", length = 50)
    private String olduciId;
    @OneToMany(mappedBy = "uciId", fetch = FetchType.LAZY)
    private List<Familymember> familymemberList;

    public Usercompanyinfo() {
    }

    public Usercompanyinfo(String uciId) {
        this.uciId = uciId;
    }

    public String getUciId() {
        return uciId;
    }

    public void setUciId(String uciId) {
        this.uciId = uciId;
    }

    public String getUciCompname() {
        return uciCompname;
    }

    public void setUciCompname(String uciCompname) {
        this.uciCompname = uciCompname;
    }

    public String getUciComptype() {
        return uciComptype;
    }

    public void setUciComptype(String uciComptype) {
        this.uciComptype = uciComptype;
    }

    public String getUciCompstate() {
        return uciCompstate;
    }

    public void setUciCompstate(String uciCompstate) {
        this.uciCompstate = uciCompstate;
    }

    public String getUciComplable() {
        return uciComplable;
    }

    public void setUciComplable(String uciComplable) {
        this.uciComplable = uciComplable;
    }

    public String getUciDescription() {
        return uciDescription;
    }

    public void setUciDescription(String uciDescription) {
        this.uciDescription = uciDescription;
    }

    public String getUciFlag() {
        return uciFlag;
    }

    public void setUciFlag(String uciFlag) {
        this.uciFlag = uciFlag;
    }

    public String getOlduciId() {
        return olduciId;
    }

    public void setOlduciId(String olduciId) {
        this.olduciId = olduciId;
    }

    @XmlTransient
    public List<Familymember> getFamilymemberList() {
        return familymemberList;
    }

    public void setFamilymemberList(List<Familymember> familymemberList) {
        this.familymemberList = familymemberList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uciId != null ? uciId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usercompanyinfo)) {
            return false;
        }
        Usercompanyinfo other = (Usercompanyinfo) object;
        if ((this.uciId == null && other.uciId != null) || (this.uciId != null && !this.uciId.equals(other.uciId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.shengcs.Usercompanyinfo[ uciId=" + uciId + " ]";
    }
    
}
