/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.model.shengnc;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "SYS_T_ORGANIZATION", catalog = "", schema = "SUMMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysTOrganization.findAll", query = "SELECT s FROM SysTOrganization s"),
    @NamedQuery(name = "SysTOrganization.findByOrganizationId", query = "SELECT s FROM SysTOrganization s WHERE s.organizationId = :organizationId"),
    @NamedQuery(name = "SysTOrganization.findBySerialnumber", query = "SELECT s FROM SysTOrganization s WHERE s.serialnumber = :serialnumber"),
    @NamedQuery(name = "SysTOrganization.findByOrgname", query = "SELECT s FROM SysTOrganization s WHERE s.orgname = :orgname"),
    @NamedQuery(name = "SysTOrganization.findByFullname", query = "SELECT s FROM SysTOrganization s WHERE s.fullname = :fullname"),
    @NamedQuery(name = "SysTOrganization.findByParentorgid", query = "SELECT s FROM SysTOrganization s WHERE s.parentorgid = :parentorgid"),
    @NamedQuery(name = "SysTOrganization.findByDepth", query = "SELECT s FROM SysTOrganization s WHERE s.depth = :depth"),
    @NamedQuery(name = "SysTOrganization.findByStatus", query = "SELECT s FROM SysTOrganization s WHERE s.status = :status"),
    @NamedQuery(name = "SysTOrganization.findByZone", query = "SELECT s FROM SysTOrganization s WHERE s.zone = :zone")})
public class SysTOrganization implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ORGANIZATION_ID", nullable = false, length = 32)
    private String organizationId;
    @Column(length = 32)
    private String serialnumber;
    @Column(length = 128)
    private String orgname;
    @Column(length = 256)
    private String fullname;
    @Column(length = 32)
    private String parentorgid;
    private BigInteger depth;
    private Character status;
    private Character zone;
    @OneToMany(mappedBy = "organizationId")
    private Set<InfoTFamily> infoTFamilySet;
    @OneToMany(mappedBy = "organizationId")
    private Set<BizTOptacc> bizTOptaccSet;

    public SysTOrganization() {
    }

    public SysTOrganization(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getParentorgid() {
        return parentorgid;
    }

    public void setParentorgid(String parentorgid) {
        this.parentorgid = parentorgid;
    }

    public BigInteger getDepth() {
        return depth;
    }

    public void setDepth(BigInteger depth) {
        this.depth = depth;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Character getZone() {
        return zone;
    }

    public void setZone(Character zone) {
        this.zone = zone;
    }

    @XmlTransient
    public Set<InfoTFamily> getInfoTFamilySet() {
        return infoTFamilySet;
    }

    public void setInfoTFamilySet(Set<InfoTFamily> infoTFamilySet) {
        this.infoTFamilySet = infoTFamilySet;
    }

    @XmlTransient
    public Set<BizTOptacc> getBizTOptaccSet() {
        return bizTOptaccSet;
    }

    public void setBizTOptaccSet(Set<BizTOptacc> bizTOptaccSet) {
        this.bizTOptaccSet = bizTOptaccSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (organizationId != null ? organizationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysTOrganization)) {
            return false;
        }
        SysTOrganization other = (SysTOrganization) object;
        if ((this.organizationId == null && other.organizationId != null) || (this.organizationId != null && !this.organizationId.equals(other.organizationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.shengnc.SysTOrganization[ organizationId=" + organizationId + " ]";
    }
    
}
