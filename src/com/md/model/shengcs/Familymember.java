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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Familymember.findAll", query = "SELECT f FROM Familymember f"),
    @NamedQuery(name = "Familymember.findByFmId", query = "SELECT f FROM Familymember f WHERE f.fmId = :fmId"),
    @NamedQuery(name = "Familymember.findByFmName", query = "SELECT f FROM Familymember f WHERE f.fmName = :fmName"),
    @NamedQuery(name = "Familymember.findByFmSex", query = "SELECT f FROM Familymember f WHERE f.fmSex = :fmSex"),
    @NamedQuery(name = "Familymember.findByFmBirthday", query = "SELECT f FROM Familymember f WHERE f.fmBirthday = :fmBirthday"),
    @NamedQuery(name = "Familymember.findByUpdatetime", query = "SELECT f FROM Familymember f WHERE f.updatetime = :updatetime"),
    @NamedQuery(name = "Familymember.findByFmIfmarried", query = "SELECT f FROM Familymember f WHERE f.fmIfmarried = :fmIfmarried"),
    @NamedQuery(name = "Familymember.findByRegtime", query = "SELECT f FROM Familymember f WHERE f.regtime = :regtime"),
    @NamedQuery(name = "Familymember.findByFmKnowledge", query = "SELECT f FROM Familymember f WHERE f.fmKnowledge = :fmKnowledge"),
    @NamedQuery(name = "Familymember.findByUpdateemp", query = "SELECT f FROM Familymember f WHERE f.updateemp = :updateemp"),
    @NamedQuery(name = "Familymember.findByFmParty", query = "SELECT f FROM Familymember f WHERE f.fmParty = :fmParty"),
    @NamedQuery(name = "Familymember.findByUpdatereason", query = "SELECT f FROM Familymember f WHERE f.updatereason = :updatereason"),
    @NamedQuery(name = "Familymember.findByFmNation", query = "SELECT f FROM Familymember f WHERE f.fmNation = :fmNation"),
    @NamedQuery(name = "Familymember.findByRegemp", query = "SELECT f FROM Familymember f WHERE f.regemp = :regemp"),
    @NamedQuery(name = "Familymember.findByFmPaperid", query = "SELECT f FROM Familymember f WHERE f.fmPaperid = :fmPaperid"),
    @NamedQuery(name = "Familymember.findByFmRestype", query = "SELECT f FROM Familymember f WHERE f.fmRestype = :fmRestype"),
    @NamedQuery(name = "Familymember.findByFmResadd", query = "SELECT f FROM Familymember f WHERE f.fmResadd = :fmResadd"),
    @NamedQuery(name = "Familymember.findByFmAddress", query = "SELECT f FROM Familymember f WHERE f.fmAddress = :fmAddress"),
    @NamedQuery(name = "Familymember.findByFmLinkmode", query = "SELECT f FROM Familymember f WHERE f.fmLinkmode = :fmLinkmode"),
    @NamedQuery(name = "Familymember.findByFmMail", query = "SELECT f FROM Familymember f WHERE f.fmMail = :fmMail"),
    @NamedQuery(name = "Familymember.findByFmRelmaster", query = "SELECT f FROM Familymember f WHERE f.fmRelmaster = :fmRelmaster"),
    @NamedQuery(name = "Familymember.findByFmPersonstate", query = "SELECT f FROM Familymember f WHERE f.fmPersonstate = :fmPersonstate"),
    @NamedQuery(name = "Familymember.findByFmRemark", query = "SELECT f FROM Familymember f WHERE f.fmRemark = :fmRemark"),
    @NamedQuery(name = "Familymember.findByFmSort", query = "SELECT f FROM Familymember f WHERE f.fmSort = :fmSort"),
    @NamedQuery(name = "Familymember.findByFmSafesort", query = "SELECT f FROM Familymember f WHERE f.fmSafesort = :fmSafesort"),
    @NamedQuery(name = "Familymember.findByFmBody", query = "SELECT f FROM Familymember f WHERE f.fmBody = :fmBody"),
    @NamedQuery(name = "Familymember.findByFmSickentype", query = "SELECT f FROM Familymember f WHERE f.fmSickentype = :fmSickentype"),
    @NamedQuery(name = "Familymember.findByFmSickenname", query = "SELECT f FROM Familymember f WHERE f.fmSickenname = :fmSickenname"),
    @NamedQuery(name = "Familymember.findByFmDeformity", query = "SELECT f FROM Familymember f WHERE f.fmDeformity = :fmDeformity"),
    @NamedQuery(name = "Familymember.findByFmDefgrade", query = "SELECT f FROM Familymember f WHERE f.fmDefgrade = :fmDefgrade"),
    @NamedQuery(name = "Familymember.findByFmLabour", query = "SELECT f FROM Familymember f WHERE f.fmLabour = :fmLabour"),
    @NamedQuery(name = "Familymember.findByFmSafety", query = "SELECT f FROM Familymember f WHERE f.fmSafety = :fmSafety"),
    @NamedQuery(name = "Familymember.findByFmJob", query = "SELECT f FROM Familymember f WHERE f.fmJob = :fmJob"),
    @NamedQuery(name = "Familymember.findByFmIncome", query = "SELECT f FROM Familymember f WHERE f.fmIncome = :fmIncome"),
    @NamedQuery(name = "Familymember.findByFmRestype2", query = "SELECT f FROM Familymember f WHERE f.fmRestype2 = :fmRestype2"),
    @NamedQuery(name = "Familymember.findByFmType1", query = "SELECT f FROM Familymember f WHERE f.fmType1 = :fmType1"),
    @NamedQuery(name = "Familymember.findByFmType2", query = "SELECT f FROM Familymember f WHERE f.fmType2 = :fmType2"),
    @NamedQuery(name = "Familymember.findByFmType3", query = "SELECT f FROM Familymember f WHERE f.fmType3 = :fmType3"),
    @NamedQuery(name = "Familymember.findByFmType4", query = "SELECT f FROM Familymember f WHERE f.fmType4 = :fmType4"),
    @NamedQuery(name = "Familymember.findByTxtime", query = "SELECT f FROM Familymember f WHERE f.txtime = :txtime"),
    @NamedQuery(name = "Familymember.findByIsolder", query = "SELECT f FROM Familymember f WHERE f.isolder = :isolder"),
    @NamedQuery(name = "Familymember.findByIsprison", query = "SELECT f FROM Familymember f WHERE f.isprison = :isprison"),
    @NamedQuery(name = "Familymember.findByIscust", query = "SELECT f FROM Familymember f WHERE f.iscust = :iscust"),
    @NamedQuery(name = "Familymember.findByIswork", query = "SELECT f FROM Familymember f WHERE f.iswork = :iswork"),
    @NamedQuery(name = "Familymember.findByOldfmId", query = "SELECT f FROM Familymember f WHERE f.oldfmId = :oldfmId"),
    @NamedQuery(name = "Familymember.findByIndiId", query = "SELECT f FROM Familymember f WHERE f.indiId = :indiId"),
    @NamedQuery(name = "Familymember.findByMedicaretype", query = "SELECT f FROM Familymember f WHERE f.medicaretype = :medicaretype"),
    @NamedQuery(name = "Familymember.findByFmSafesortlevel", query = "SELECT f FROM Familymember f WHERE f.fmSafesortlevel = :fmSafesortlevel"),
    @NamedQuery(name = "Familymember.findByFmType", query = "SELECT f FROM Familymember f WHERE f.fmType = :fmType"),
    @NamedQuery(name = "Familymember.findByMzbMemId", query = "SELECT f FROM Familymember f WHERE f.mzbMemId = :mzbMemId"),
    @NamedQuery(name = "Familymember.findByMzbFamId", query = "SELECT f FROM Familymember f WHERE f.mzbFamId = :mzbFamId"),
    @NamedQuery(name = "Familymember.findByFmType5", query = "SELECT f FROM Familymember f WHERE f.fmType5 = :fmType5"),
    @NamedQuery(name = "Familymember.findByFmFFamilyno", query = "SELECT f FROM Familymember f WHERE f.fmFFamilyno = :fmFFamilyno"),
    @NamedQuery(name = "Familymember.findByFmOnNo", query = "SELECT f FROM Familymember f WHERE f.fmOnNo = :fmOnNo")})
public class Familymember implements Serializable {
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatetime;
    @Column(name = "FM_IFMARRIED", length = 4)
    private String fmIfmarried;
    @Temporal(TemporalType.TIMESTAMP)
    private Date regtime;
    @Column(name = "FM_KNOWLEDGE", length = 20)
    private String fmKnowledge;
    @Column(length = 50)
    private String updateemp;
    @Column(name = "FM_PARTY", length = 20)
    private String fmParty;
    @Column(length = 200)
    private String updatereason;
    @Column(name = "FM_NATION", length = 20)
    private String fmNation;
    @Column(length = 50)
    private String regemp;
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
    @Column(name = "FM_JOB", length = 20)
    private String fmJob;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FM_INCOME", precision = 8, scale = 2)
    private BigDecimal fmIncome;
    @Column(name = "FM_RESTYPE2", length = 20)
    private String fmRestype2;
    @Column(name = "FM_TYPE1", length = 50)
    private String fmType1;
    @Column(name = "FM_TYPE2", length = 50)
    private String fmType2;
    @Column(name = "FM_TYPE3", length = 50)
    private String fmType3;
    @Column(name = "FM_TYPE4", length = 50)
    private String fmType4;
    @Column(length = 50)
    private String txtime;
    private Character isolder;
    @Column(length = 20)
    private String isprison;
    private Character iscust;
    @Column(length = 20)
    private String iswork;
    @Column(name = "OLDFM_ID", length = 50)
    private String oldfmId;
    @Column(name = "INDI_ID", length = 50)
    private String indiId;
    private Character medicaretype;
    @Column(name = "FM_SAFESORTLEVEL", length = 50)
    private String fmSafesortlevel;
    @Column(name = "FM_TYPE", length = 50)
    private String fmType;
    @Column(name = "MZB_MEM_ID", length = 50)
    private String mzbMemId;
    @Column(name = "MZB_FAM_ID", length = 50)
    private String mzbFamId;
    @Column(name = "FM_TYPE5", length = 50)
    private String fmType5;
    @Column(name = "FM_F_FAMILYNO", length = 50)
    private String fmFFamilyno;
    @Column(name = "FM_ON_NO", length = 50)
    private String fmOnNo;
    @JoinColumn(name = "F_FAMILYID", referencedColumnName = "F_FAMILYID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Family fFamilyid;
    @JoinColumn(name = "UCI_ID", referencedColumnName = "UCI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usercompanyinfo uciId;

    public Familymember() {
    }

    public Familymember(String fmId) {
        this.fmId = fmId;
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

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getFmIfmarried() {
        return fmIfmarried;
    }

    public void setFmIfmarried(String fmIfmarried) {
        this.fmIfmarried = fmIfmarried;
    }

    public Date getRegtime() {
        return regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    public String getFmKnowledge() {
        return fmKnowledge;
    }

    public void setFmKnowledge(String fmKnowledge) {
        this.fmKnowledge = fmKnowledge;
    }

    public String getUpdateemp() {
        return updateemp;
    }

    public void setUpdateemp(String updateemp) {
        this.updateemp = updateemp;
    }

    public String getFmParty() {
        return fmParty;
    }

    public void setFmParty(String fmParty) {
        this.fmParty = fmParty;
    }

    public String getUpdatereason() {
        return updatereason;
    }

    public void setUpdatereason(String updatereason) {
        this.updatereason = updatereason;
    }

    public String getFmNation() {
        return fmNation;
    }

    public void setFmNation(String fmNation) {
        this.fmNation = fmNation;
    }

    public String getRegemp() {
        return regemp;
    }

    public void setRegemp(String regemp) {
        this.regemp = regemp;
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

    public String getFmJob() {
        return fmJob;
    }

    public void setFmJob(String fmJob) {
        this.fmJob = fmJob;
    }

    public BigDecimal getFmIncome() {
        return fmIncome;
    }

    public void setFmIncome(BigDecimal fmIncome) {
        this.fmIncome = fmIncome;
    }

    public String getFmRestype2() {
        return fmRestype2;
    }

    public void setFmRestype2(String fmRestype2) {
        this.fmRestype2 = fmRestype2;
    }

    public String getFmType1() {
        return fmType1;
    }

    public void setFmType1(String fmType1) {
        this.fmType1 = fmType1;
    }

    public String getFmType2() {
        return fmType2;
    }

    public void setFmType2(String fmType2) {
        this.fmType2 = fmType2;
    }

    public String getFmType3() {
        return fmType3;
    }

    public void setFmType3(String fmType3) {
        this.fmType3 = fmType3;
    }

    public String getFmType4() {
        return fmType4;
    }

    public void setFmType4(String fmType4) {
        this.fmType4 = fmType4;
    }

    public String getTxtime() {
        return txtime;
    }

    public void setTxtime(String txtime) {
        this.txtime = txtime;
    }

    public Character getIsolder() {
        return isolder;
    }

    public void setIsolder(Character isolder) {
        this.isolder = isolder;
    }

    public String getIsprison() {
        return isprison;
    }

    public void setIsprison(String isprison) {
        this.isprison = isprison;
    }

    public Character getIscust() {
        return iscust;
    }

    public void setIscust(Character iscust) {
        this.iscust = iscust;
    }

    public String getIswork() {
        return iswork;
    }

    public void setIswork(String iswork) {
        this.iswork = iswork;
    }

    public String getOldfmId() {
        return oldfmId;
    }

    public void setOldfmId(String oldfmId) {
        this.oldfmId = oldfmId;
    }

    public String getIndiId() {
        return indiId;
    }

    public void setIndiId(String indiId) {
        this.indiId = indiId;
    }

    public Character getMedicaretype() {
        return medicaretype;
    }

    public void setMedicaretype(Character medicaretype) {
        this.medicaretype = medicaretype;
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

    public String getMzbMemId() {
        return mzbMemId;
    }

    public void setMzbMemId(String mzbMemId) {
        this.mzbMemId = mzbMemId;
    }

    public String getMzbFamId() {
        return mzbFamId;
    }

    public void setMzbFamId(String mzbFamId) {
        this.mzbFamId = mzbFamId;
    }

    public String getFmType5() {
        return fmType5;
    }

    public void setFmType5(String fmType5) {
        this.fmType5 = fmType5;
    }

    public String getFmFFamilyno() {
        return fmFFamilyno;
    }

    public void setFmFFamilyno(String fmFFamilyno) {
        this.fmFFamilyno = fmFFamilyno;
    }

    public String getFmOnNo() {
        return fmOnNo;
    }

    public void setFmOnNo(String fmOnNo) {
        this.fmOnNo = fmOnNo;
    }

    public Family getFFamilyid() {
        return fFamilyid;
    }

    public void setFFamilyid(Family fFamilyid) {
        this.fFamilyid = fFamilyid;
    }

    public Usercompanyinfo getUciId() {
        return uciId;
    }

    public void setUciId(Usercompanyinfo uciId) {
        this.uciId = uciId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fmId != null ? fmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Familymember)) {
            return false;
        }
        Familymember other = (Familymember) object;
        if ((this.fmId == null && other.fmId != null) || (this.fmId != null && !this.fmId.equals(other.fmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.shengcs.Familymember[ fmId=" + fmId + " ]";
    }
    
}
