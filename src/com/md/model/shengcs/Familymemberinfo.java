/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.model.shengcs;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(catalog = "", schema = "JLDBCS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Familymemberinfo.findAll", query = "SELECT f FROM Familymemberinfo f"),
    @NamedQuery(name = "Familymemberinfo.findByFmId", query = "SELECT f FROM Familymemberinfo f WHERE f.fmId = :fmId"),
    @NamedQuery(name = "Familymemberinfo.findByFmName", query = "SELECT f FROM Familymemberinfo f WHERE f.fmName = :fmName"),
    @NamedQuery(name = "Familymemberinfo.findByFmSex", query = "SELECT f FROM Familymemberinfo f WHERE f.fmSex = :fmSex"),
    @NamedQuery(name = "Familymemberinfo.findByFmBirthday", query = "SELECT f FROM Familymemberinfo f WHERE f.fmBirthday = :fmBirthday"),
    @NamedQuery(name = "Familymemberinfo.findByFmIfmarried", query = "SELECT f FROM Familymemberinfo f WHERE f.fmIfmarried = :fmIfmarried"),
    @NamedQuery(name = "Familymemberinfo.findByFmKnowledge", query = "SELECT f FROM Familymemberinfo f WHERE f.fmKnowledge = :fmKnowledge"),
    @NamedQuery(name = "Familymemberinfo.findByFmParty", query = "SELECT f FROM Familymemberinfo f WHERE f.fmParty = :fmParty"),
    @NamedQuery(name = "Familymemberinfo.findByFmNation", query = "SELECT f FROM Familymemberinfo f WHERE f.fmNation = :fmNation"),
    @NamedQuery(name = "Familymemberinfo.findByFmPaperid", query = "SELECT f FROM Familymemberinfo f WHERE f.fmPaperid = :fmPaperid"),
    @NamedQuery(name = "Familymemberinfo.findByFmRestype", query = "SELECT f FROM Familymemberinfo f WHERE f.fmRestype = :fmRestype"),
    @NamedQuery(name = "Familymemberinfo.findByFmResadd", query = "SELECT f FROM Familymemberinfo f WHERE f.fmResadd = :fmResadd"),
    @NamedQuery(name = "Familymemberinfo.findByFmAddress", query = "SELECT f FROM Familymemberinfo f WHERE f.fmAddress = :fmAddress"),
    @NamedQuery(name = "Familymemberinfo.findByFmLinkmode", query = "SELECT f FROM Familymemberinfo f WHERE f.fmLinkmode = :fmLinkmode"),
    @NamedQuery(name = "Familymemberinfo.findByFmMail", query = "SELECT f FROM Familymemberinfo f WHERE f.fmMail = :fmMail"),
    @NamedQuery(name = "Familymemberinfo.findByFmRelmaster", query = "SELECT f FROM Familymemberinfo f WHERE f.fmRelmaster = :fmRelmaster"),
    @NamedQuery(name = "Familymemberinfo.findByFmPersonstate", query = "SELECT f FROM Familymemberinfo f WHERE f.fmPersonstate = :fmPersonstate"),
    @NamedQuery(name = "Familymemberinfo.findByFmRemark", query = "SELECT f FROM Familymemberinfo f WHERE f.fmRemark = :fmRemark"),
    @NamedQuery(name = "Familymemberinfo.findByFmSort", query = "SELECT f FROM Familymemberinfo f WHERE f.fmSort = :fmSort"),
    @NamedQuery(name = "Familymemberinfo.findByFmSafesort", query = "SELECT f FROM Familymemberinfo f WHERE f.fmSafesort = :fmSafesort"),
    @NamedQuery(name = "Familymemberinfo.findByFmBody", query = "SELECT f FROM Familymemberinfo f WHERE f.fmBody = :fmBody"),
    @NamedQuery(name = "Familymemberinfo.findByFmSickentype", query = "SELECT f FROM Familymemberinfo f WHERE f.fmSickentype = :fmSickentype"),
    @NamedQuery(name = "Familymemberinfo.findByFmSickenname", query = "SELECT f FROM Familymemberinfo f WHERE f.fmSickenname = :fmSickenname"),
    @NamedQuery(name = "Familymemberinfo.findByFmDeformity", query = "SELECT f FROM Familymemberinfo f WHERE f.fmDeformity = :fmDeformity"),
    @NamedQuery(name = "Familymemberinfo.findByFmDefgrade", query = "SELECT f FROM Familymemberinfo f WHERE f.fmDefgrade = :fmDefgrade"),
    @NamedQuery(name = "Familymemberinfo.findByFmLabour", query = "SELECT f FROM Familymemberinfo f WHERE f.fmLabour = :fmLabour"),
    @NamedQuery(name = "Familymemberinfo.findByFmSafety", query = "SELECT f FROM Familymemberinfo f WHERE f.fmSafety = :fmSafety"),
    @NamedQuery(name = "Familymemberinfo.findByFFamilyid", query = "SELECT f FROM Familymemberinfo f WHERE f.fFamilyid = :fFamilyid"),
    @NamedQuery(name = "Familymemberinfo.findByFmJob", query = "SELECT f FROM Familymemberinfo f WHERE f.fmJob = :fmJob"),
    @NamedQuery(name = "Familymemberinfo.findByFFamilyno", query = "SELECT f FROM Familymemberinfo f WHERE f.fFamilyno = :fFamilyno"),
    @NamedQuery(name = "Familymemberinfo.findByOnNo", query = "SELECT f FROM Familymemberinfo f WHERE f.onNo = :onNo"),
    @NamedQuery(name = "Familymemberinfo.findByFamilyno", query = "SELECT f FROM Familymemberinfo f WHERE f.familyno = :familyno"),
    @NamedQuery(name = "Familymemberinfo.findByFmType2", query = "SELECT f FROM Familymemberinfo f WHERE f.fmType2 = :fmType2"),
    @NamedQuery(name = "Familymemberinfo.findByIndiId", query = "SELECT f FROM Familymemberinfo f WHERE f.indiId = :indiId"),
    @NamedQuery(name = "Familymemberinfo.findByFamilyid", query = "SELECT f FROM Familymemberinfo f WHERE f.familyid = :familyid"),
    @NamedQuery(name = "Familymemberinfo.findByFmSafesortlevel", query = "SELECT f FROM Familymemberinfo f WHERE f.fmSafesortlevel = :fmSafesortlevel"),
    @NamedQuery(name = "Familymemberinfo.findByFmType", query = "SELECT f FROM Familymemberinfo f WHERE f.fmType = :fmType"),
    @NamedQuery(name = "Familymemberinfo.findByOperationstate", query = "SELECT f FROM Familymemberinfo f WHERE f.operationstate = :operationstate"),
    @NamedQuery(name = "Familymemberinfo.findByFJxincome", query = "SELECT f FROM Familymemberinfo f WHERE f.fJxincome = :fJxincome"),
    @NamedQuery(name = "Familymemberinfo.findByIswork", query = "SELECT f FROM Familymemberinfo f WHERE f.iswork = :iswork"),
    @NamedQuery(name = "Familymemberinfo.findByOo1", query = "SELECT f FROM Familymemberinfo f WHERE f.oo1 = :oo1"),
    @NamedQuery(name = "Familymemberinfo.findByOo2", query = "SELECT f FROM Familymemberinfo f WHERE f.oo2 = :oo2"),
    @NamedQuery(name = "Familymemberinfo.findByOo3", query = "SELECT f FROM Familymemberinfo f WHERE f.oo3 = :oo3")})
public class Familymemberinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FM_ID", nullable = false, length = 50)
    private String fmId;
    @Column(name = "FM_NAME", length = 50)
    private String fmName;
    @Column(name = "FM_SEX", length = 2)
    private String fmSex;
    @Column(name = "FM_BIRTHDAY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fmBirthday;
    @Column(name = "FM_IFMARRIED", length = 4)
    private String fmIfmarried;
    @Column(name = "FM_KNOWLEDGE", length = 20)
    private String fmKnowledge;
    @Column(name = "FM_PARTY", length = 20)
    private String fmParty;
    @Column(name = "FM_NATION", length = 20)
    private String fmNation;
    @Column(name = "FM_PAPERID", length = 20)
    private String fmPaperid;
    @Column(name = "FM_RESTYPE", length = 20)
    private String fmRestype;
    @Column(name = "FM_RESADD", length = 200)
    private String fmResadd;
    @Column(name = "FM_ADDRESS", length = 200)
    private String fmAddress;
    @Column(name = "FM_LINKMODE", length = 200)
    private String fmLinkmode;
    @Column(name = "FM_MAIL", length = 20)
    private String fmMail;
    @Column(name = "FM_RELMASTER", length = 20)
    private String fmRelmaster;
    @Column(name = "FM_PERSONSTATE", length = 20)
    private String fmPersonstate;
    @Column(name = "FM_REMARK", length = 400)
    private String fmRemark;
    @Column(name = "FM_SORT", length = 50)
    private String fmSort;
    @Column(name = "FM_SAFESORT", length = 50)
    private String fmSafesort;
    @Column(name = "FM_BODY", length = 50)
    private String fmBody;
    @Column(name = "FM_SICKENTYPE", length = 50)
    private String fmSickentype;
    @Column(name = "FM_SICKENNAME", length = 200)
    private String fmSickenname;
    @Column(name = "FM_DEFORMITY", length = 20)
    private String fmDeformity;
    @Column(name = "FM_DEFGRADE", length = 20)
    private String fmDefgrade;
    @Column(name = "FM_LABOUR", length = 20)
    private String fmLabour;
    @Column(name = "FM_SAFETY", length = 400)
    private String fmSafety;
    @Column(name = "F_FAMILYID", length = 50)
    private String fFamilyid;
    @Column(name = "FM_JOB", length = 20)
    private String fmJob;
    @Column(name = "F_FAMILYNO", length = 50)
    private String fFamilyno;
    @Column(name = "ON_NO", length = 50)
    private String onNo;
    @Column(length = 50)
    private String familyno;
    @Column(name = "FM_TYPE2", length = 50)
    private String fmType2;
    @Column(name = "INDI_ID", length = 50)
    private String indiId;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String familyid;
    @Column(name = "FM_SAFESORTLEVEL", length = 50)
    private String fmSafesortlevel;
    @Column(name = "FM_TYPE", length = 50)
    private String fmType;
    @Column(length = 200)
    private String operationstate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "F_JXINCOME", precision = 8, scale = 2)
    private BigDecimal fJxincome;
    @Column(length = 20)
    private String iswork;
    @Column(length = 50)
    private String oo1;
    @Column(length = 50)
    private String oo2;
    @Column(length = 50)
    private String oo3;

    public Familymemberinfo() {
    }

    public String getFmId() {
        return fmId;
    }

    public void setFmId(String fmId) {
        this.fmId = fmId;
    }

    public String getFmName() {
        return fmName;
    }

    public void setFmName(String fmName) {
        this.fmName = fmName;
    }

    public String getFmSex() {
        return fmSex;
    }

    public void setFmSex(String fmSex) {
        this.fmSex = fmSex;
    }

    public Date getFmBirthday() {
        return fmBirthday;
    }

    public void setFmBirthday(Date fmBirthday) {
        this.fmBirthday = fmBirthday;
    }

    public String getFmIfmarried() {
        return fmIfmarried;
    }

    public void setFmIfmarried(String fmIfmarried) {
        this.fmIfmarried = fmIfmarried;
    }

    public String getFmKnowledge() {
        return fmKnowledge;
    }

    public void setFmKnowledge(String fmKnowledge) {
        this.fmKnowledge = fmKnowledge;
    }

    public String getFmParty() {
        return fmParty;
    }

    public void setFmParty(String fmParty) {
        this.fmParty = fmParty;
    }

    public String getFmNation() {
        return fmNation;
    }

    public void setFmNation(String fmNation) {
        this.fmNation = fmNation;
    }

    public String getFmPaperid() {
        return fmPaperid;
    }

    public void setFmPaperid(String fmPaperid) {
        this.fmPaperid = fmPaperid;
    }

    public String getFmRestype() {
        return fmRestype;
    }

    public void setFmRestype(String fmRestype) {
        this.fmRestype = fmRestype;
    }

    public String getFmResadd() {
        return fmResadd;
    }

    public void setFmResadd(String fmResadd) {
        this.fmResadd = fmResadd;
    }

    public String getFmAddress() {
        return fmAddress;
    }

    public void setFmAddress(String fmAddress) {
        this.fmAddress = fmAddress;
    }

    public String getFmLinkmode() {
        return fmLinkmode;
    }

    public void setFmLinkmode(String fmLinkmode) {
        this.fmLinkmode = fmLinkmode;
    }

    public String getFmMail() {
        return fmMail;
    }

    public void setFmMail(String fmMail) {
        this.fmMail = fmMail;
    }

    public String getFmRelmaster() {
        return fmRelmaster;
    }

    public void setFmRelmaster(String fmRelmaster) {
        this.fmRelmaster = fmRelmaster;
    }

    public String getFmPersonstate() {
        return fmPersonstate;
    }

    public void setFmPersonstate(String fmPersonstate) {
        this.fmPersonstate = fmPersonstate;
    }

    public String getFmRemark() {
        return fmRemark;
    }

    public void setFmRemark(String fmRemark) {
        this.fmRemark = fmRemark;
    }

    public String getFmSort() {
        return fmSort;
    }

    public void setFmSort(String fmSort) {
        this.fmSort = fmSort;
    }

    public String getFmSafesort() {
        return fmSafesort;
    }

    public void setFmSafesort(String fmSafesort) {
        this.fmSafesort = fmSafesort;
    }

    public String getFmBody() {
        return fmBody;
    }

    public void setFmBody(String fmBody) {
        this.fmBody = fmBody;
    }

    public String getFmSickentype() {
        return fmSickentype;
    }

    public void setFmSickentype(String fmSickentype) {
        this.fmSickentype = fmSickentype;
    }

    public String getFmSickenname() {
        return fmSickenname;
    }

    public void setFmSickenname(String fmSickenname) {
        this.fmSickenname = fmSickenname;
    }

    public String getFmDeformity() {
        return fmDeformity;
    }

    public void setFmDeformity(String fmDeformity) {
        this.fmDeformity = fmDeformity;
    }

    public String getFmDefgrade() {
        return fmDefgrade;
    }

    public void setFmDefgrade(String fmDefgrade) {
        this.fmDefgrade = fmDefgrade;
    }

    public String getFmLabour() {
        return fmLabour;
    }

    public void setFmLabour(String fmLabour) {
        this.fmLabour = fmLabour;
    }

    public String getFmSafety() {
        return fmSafety;
    }

    public void setFmSafety(String fmSafety) {
        this.fmSafety = fmSafety;
    }

    public String getFFamilyid() {
        return fFamilyid;
    }

    public void setFFamilyid(String fFamilyid) {
        this.fFamilyid = fFamilyid;
    }

    public String getFmJob() {
        return fmJob;
    }

    public void setFmJob(String fmJob) {
        this.fmJob = fmJob;
    }

    public String getFFamilyno() {
        return fFamilyno;
    }

    public void setFFamilyno(String fFamilyno) {
        this.fFamilyno = fFamilyno;
    }

    public String getOnNo() {
        return onNo;
    }

    public void setOnNo(String onNo) {
        this.onNo = onNo;
    }

    public String getFamilyno() {
        return familyno;
    }

    public void setFamilyno(String familyno) {
        this.familyno = familyno;
    }

    public String getFmType2() {
        return fmType2;
    }

    public void setFmType2(String fmType2) {
        this.fmType2 = fmType2;
    }

    public String getIndiId() {
        return indiId;
    }

    public void setIndiId(String indiId) {
        this.indiId = indiId;
    }

    public String getFamilyid() {
        return familyid;
    }

    public void setFamilyid(String familyid) {
        this.familyid = familyid;
    }

    public String getFmSafesortlevel() {
        return fmSafesortlevel;
    }

    public void setFmSafesortlevel(String fmSafesortlevel) {
        this.fmSafesortlevel = fmSafesortlevel;
    }

    public String getFmType() {
        return fmType;
    }

    public void setFmType(String fmType) {
        this.fmType = fmType;
    }

    public String getOperationstate() {
        return operationstate;
    }

    public void setOperationstate(String operationstate) {
        this.operationstate = operationstate;
    }

    public BigDecimal getFJxincome() {
        return fJxincome;
    }

    public void setFJxincome(BigDecimal fJxincome) {
        this.fJxincome = fJxincome;
    }

    public String getIswork() {
        return iswork;
    }

    public void setIswork(String iswork) {
        this.iswork = iswork;
    }

    public String getOo1() {
        return oo1;
    }

    public void setOo1(String oo1) {
        this.oo1 = oo1;
    }

    public String getOo2() {
        return oo2;
    }

    public void setOo2(String oo2) {
        this.oo2 = oo2;
    }

    public String getOo3() {
        return oo3;
    }

    public void setOo3(String oo3) {
        this.oo3 = oo3;
    }
    
}
