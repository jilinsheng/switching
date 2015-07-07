/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.model.shengnc;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "INFO_T_FAMILY", catalog = "", schema = "SUMMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InfoTFamily.findAll", query = "SELECT i FROM InfoTFamily i"),
    @NamedQuery(name = "InfoTFamily.findByFamilyId", query = "SELECT i FROM InfoTFamily i WHERE i.familyId = :familyId"),
    @NamedQuery(name = "InfoTFamily.findByFamilyno", query = "SELECT i FROM InfoTFamily i WHERE i.familyno = :familyno"),
    @NamedQuery(name = "InfoTFamily.findByPopulation", query = "SELECT i FROM InfoTFamily i WHERE i.population = :population"),
    @NamedQuery(name = "InfoTFamily.findByEnsurecount", query = "SELECT i FROM InfoTFamily i WHERE i.ensurecount = :ensurecount"),
    @NamedQuery(name = "InfoTFamily.findByMasterid", query = "SELECT i FROM InfoTFamily i WHERE i.masterid = :masterid"),
    @NamedQuery(name = "InfoTFamily.findByAssetworth", query = "SELECT i FROM InfoTFamily i WHERE i.assetworth = :assetworth"),
    @NamedQuery(name = "InfoTFamily.findByConsultincome", query = "SELECT i FROM InfoTFamily i WHERE i.consultincome = :consultincome"),
    @NamedQuery(name = "InfoTFamily.findByMasterpapertype", query = "SELECT i FROM InfoTFamily i WHERE i.masterpapertype = :masterpapertype"),
    @NamedQuery(name = "InfoTFamily.findByMasterpaperid", query = "SELECT i FROM InfoTFamily i WHERE i.masterpaperid = :masterpaperid"),
    @NamedQuery(name = "InfoTFamily.findByRpraddress", query = "SELECT i FROM InfoTFamily i WHERE i.rpraddress = :rpraddress"),
    @NamedQuery(name = "InfoTFamily.findByFamaddress", query = "SELECT i FROM InfoTFamily i WHERE i.famaddress = :famaddress"),
    @NamedQuery(name = "InfoTFamily.findByLinkmode", query = "SELECT i FROM InfoTFamily i WHERE i.linkmode = :linkmode"),
    @NamedQuery(name = "InfoTFamily.findByStatus", query = "SELECT i FROM InfoTFamily i WHERE i.status = :status"),
    @NamedQuery(name = "InfoTFamily.findByAvgincome", query = "SELECT i FROM InfoTFamily i WHERE i.avgincome = :avgincome"),
    @NamedQuery(name = "InfoTFamily.findByMalcondition", query = "SELECT i FROM InfoTFamily i WHERE i.malcondition = :malcondition"),
    @NamedQuery(name = "InfoTFamily.findByOnlychild", query = "SELECT i FROM InfoTFamily i WHERE i.onlychild = :onlychild"),
    @NamedQuery(name = "InfoTFamily.findByAllpayout", query = "SELECT i FROM InfoTFamily i WHERE i.allpayout = :allpayout"),
    @NamedQuery(name = "InfoTFamily.findBySalmoney", query = "SELECT i FROM InfoTFamily i WHERE i.salmoney = :salmoney"),
    @NamedQuery(name = "InfoTFamily.findByTohtml", query = "SELECT i FROM InfoTFamily i WHERE i.tohtml = :tohtml"),
    @NamedQuery(name = "InfoTFamily.findByDessaltype", query = "SELECT i FROM InfoTFamily i WHERE i.dessaltype = :dessaltype"),
    @NamedQuery(name = "InfoTFamily.findBySaltype", query = "SELECT i FROM InfoTFamily i WHERE i.saltype = :saltype"),
    @NamedQuery(name = "InfoTFamily.findByIschange", query = "SELECT i FROM InfoTFamily i WHERE i.ischange = :ischange"),
    @NamedQuery(name = "InfoTFamily.findByIsstress", query = "SELECT i FROM InfoTFamily i WHERE i.isstress = :isstress"),
    @NamedQuery(name = "InfoTFamily.findByMastername", query = "SELECT i FROM InfoTFamily i WHERE i.mastername = :mastername"),
    @NamedQuery(name = "InfoTFamily.findBySalvationId", query = "SELECT i FROM InfoTFamily i WHERE i.salvationId = :salvationId"),
    @NamedQuery(name = "InfoTFamily.findByMzbFamId", query = "SELECT i FROM InfoTFamily i WHERE i.mzbFamId = :mzbFamId")})
public class InfoTFamily implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "FAMILY_ID", nullable = false, precision = 22)
    private BigDecimal familyId;
    @Column(length = 32)
    private String familyno;
    private BigInteger population;
    private BigInteger ensurecount;
    private BigInteger masterid;
    private BigInteger assetworth;
    private BigInteger consultincome;
    private BigInteger masterpapertype;
    @Column(length = 256)
    private String masterpaperid;
    @Column(length = 512)
    private String rpraddress;
    @Column(length = 512)
    private String famaddress;
    @Column(length = 256)
    private String linkmode;
    private Character status;
    private BigInteger avgincome;
    @Column(length = 800)
    private String malcondition;
    private BigInteger onlychild;
    private BigInteger allpayout;
    private BigInteger salmoney;
    @Column(length = 32)
    private String tohtml;
    private BigInteger dessaltype;
    private BigInteger saltype;
    private Character ischange;
    private Character isstress;
    @Column(length = 128)
    private String mastername;
    @Column(name = "SALVATION_ID", length = 128)
    private String salvationId;
    @Column(name = "MZB_FAM_ID", length = 128)
    private String mzbFamId;
    @JoinColumn(name = "ORGANIZATION_ID", referencedColumnName = "ORGANIZATION_ID")
    @ManyToOne
    private SysTOrganization organizationId;
    @OneToMany(mappedBy = "familyId")
    private Set<InfoTMember> infoTMemberSet;
    @OneToMany(mappedBy = "familyId")
    private Set<BizTOptcheck> bizTOptcheckSet;

    public InfoTFamily() {
    }

    public InfoTFamily(BigDecimal familyId) {
        this.familyId = familyId;
    }

    public BigDecimal getFamilyId() {
        return familyId;
    }

    public void setFamilyId(BigDecimal familyId) {
        this.familyId = familyId;
    }

    public String getFamilyno() {
        return familyno;
    }

    public void setFamilyno(String familyno) {
        this.familyno = familyno;
    }

    public BigInteger getPopulation() {
        return population;
    }

    public void setPopulation(BigInteger population) {
        this.population = population;
    }

    public BigInteger getEnsurecount() {
        return ensurecount;
    }

    public void setEnsurecount(BigInteger ensurecount) {
        this.ensurecount = ensurecount;
    }

    public BigInteger getMasterid() {
        return masterid;
    }

    public void setMasterid(BigInteger masterid) {
        this.masterid = masterid;
    }

    public BigInteger getAssetworth() {
        return assetworth;
    }

    public void setAssetworth(BigInteger assetworth) {
        this.assetworth = assetworth;
    }

    public BigInteger getConsultincome() {
        return consultincome;
    }

    public void setConsultincome(BigInteger consultincome) {
        this.consultincome = consultincome;
    }

    public BigInteger getMasterpapertype() {
        return masterpapertype;
    }

    public void setMasterpapertype(BigInteger masterpapertype) {
        this.masterpapertype = masterpapertype;
    }

    public String getMasterpaperid() {
        return masterpaperid;
    }

    public void setMasterpaperid(String masterpaperid) {
        this.masterpaperid = masterpaperid;
    }

    public String getRpraddress() {
        return rpraddress;
    }

    public void setRpraddress(String rpraddress) {
        this.rpraddress = rpraddress;
    }

    public String getFamaddress() {
        return famaddress;
    }

    public void setFamaddress(String famaddress) {
        this.famaddress = famaddress;
    }

    public String getLinkmode() {
        return linkmode;
    }

    public void setLinkmode(String linkmode) {
        this.linkmode = linkmode;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public BigInteger getAvgincome() {
        return avgincome;
    }

    public void setAvgincome(BigInteger avgincome) {
        this.avgincome = avgincome;
    }

    public String getMalcondition() {
        return malcondition;
    }

    public void setMalcondition(String malcondition) {
        this.malcondition = malcondition;
    }

    public BigInteger getOnlychild() {
        return onlychild;
    }

    public void setOnlychild(BigInteger onlychild) {
        this.onlychild = onlychild;
    }

    public BigInteger getAllpayout() {
        return allpayout;
    }

    public void setAllpayout(BigInteger allpayout) {
        this.allpayout = allpayout;
    }

    public BigInteger getSalmoney() {
        return salmoney;
    }

    public void setSalmoney(BigInteger salmoney) {
        this.salmoney = salmoney;
    }

    public String getTohtml() {
        return tohtml;
    }

    public void setTohtml(String tohtml) {
        this.tohtml = tohtml;
    }

    public BigInteger getDessaltype() {
        return dessaltype;
    }

    public void setDessaltype(BigInteger dessaltype) {
        this.dessaltype = dessaltype;
    }

    public BigInteger getSaltype() {
        return saltype;
    }

    public void setSaltype(BigInteger saltype) {
        this.saltype = saltype;
    }

    public Character getIschange() {
        return ischange;
    }

    public void setIschange(Character ischange) {
        this.ischange = ischange;
    }

    public Character getIsstress() {
        return isstress;
    }

    public void setIsstress(Character isstress) {
        this.isstress = isstress;
    }

    public String getMastername() {
        return mastername;
    }

    public void setMastername(String mastername) {
        this.mastername = mastername;
    }

    public String getSalvationId() {
        return salvationId;
    }

    public void setSalvationId(String salvationId) {
        this.salvationId = salvationId;
    }

    public String getMzbFamId() {
        return mzbFamId;
    }

    public void setMzbFamId(String mzbFamId) {
        this.mzbFamId = mzbFamId;
    }

    public SysTOrganization getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(SysTOrganization organizationId) {
        this.organizationId = organizationId;
    }

    @XmlTransient
    public Set<InfoTMember> getInfoTMemberSet() {
        return infoTMemberSet;
    }

    public void setInfoTMemberSet(Set<InfoTMember> infoTMemberSet) {
        this.infoTMemberSet = infoTMemberSet;
    }

    @XmlTransient
    public Set<BizTOptcheck> getBizTOptcheckSet() {
        return bizTOptcheckSet;
    }

    public void setBizTOptcheckSet(Set<BizTOptcheck> bizTOptcheckSet) {
        this.bizTOptcheckSet = bizTOptcheckSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (familyId != null ? familyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InfoTFamily)) {
            return false;
        }
        InfoTFamily other = (InfoTFamily) object;
        if ((this.familyId == null && other.familyId != null) || (this.familyId != null && !this.familyId.equals(other.familyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.shengnc.InfoTFamily[ familyId=" + familyId + " ]";
    }
    
}
