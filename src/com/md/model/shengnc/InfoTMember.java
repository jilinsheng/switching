/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.model.shengnc;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "INFO_T_MEMBER", catalog = "", schema = "SUMMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InfoTMember.findAll", query = "SELECT i FROM InfoTMember i"),
    @NamedQuery(name = "InfoTMember.findByMemberId", query = "SELECT i FROM InfoTMember i WHERE i.memberId = :memberId"),
    @NamedQuery(name = "InfoTMember.findByRelmaster", query = "SELECT i FROM InfoTMember i WHERE i.relmaster = :relmaster"),
    @NamedQuery(name = "InfoTMember.findByMembername", query = "SELECT i FROM InfoTMember i WHERE i.membername = :membername"),
    @NamedQuery(name = "InfoTMember.findByPapertype", query = "SELECT i FROM InfoTMember i WHERE i.papertype = :papertype"),
    @NamedQuery(name = "InfoTMember.findByPaperid", query = "SELECT i FROM InfoTMember i WHERE i.paperid = :paperid"),
    @NamedQuery(name = "InfoTMember.findByBirthday", query = "SELECT i FROM InfoTMember i WHERE i.birthday = :birthday"),
    @NamedQuery(name = "InfoTMember.findBySex", query = "SELECT i FROM InfoTMember i WHERE i.sex = :sex"),
    @NamedQuery(name = "InfoTMember.findByNation", query = "SELECT i FROM InfoTMember i WHERE i.nation = :nation"),
    @NamedQuery(name = "InfoTMember.findByIsmarriage", query = "SELECT i FROM InfoTMember i WHERE i.ismarriage = :ismarriage"),
    @NamedQuery(name = "InfoTMember.findByPolitical", query = "SELECT i FROM InfoTMember i WHERE i.political = :political"),
    @NamedQuery(name = "InfoTMember.findByRprkind", query = "SELECT i FROM InfoTMember i WHERE i.rprkind = :rprkind"),
    @NamedQuery(name = "InfoTMember.findByRprtype", query = "SELECT i FROM InfoTMember i WHERE i.rprtype = :rprtype"),
    @NamedQuery(name = "InfoTMember.findByRpraddress", query = "SELECT i FROM InfoTMember i WHERE i.rpraddress = :rpraddress"),
    @NamedQuery(name = "InfoTMember.findByDegreesort", query = "SELECT i FROM InfoTMember i WHERE i.degreesort = :degreesort"),
    @NamedQuery(name = "InfoTMember.findByPolicy", query = "SELECT i FROM InfoTMember i WHERE i.policy = :policy"),
    @NamedQuery(name = "InfoTMember.findByFtap", query = "SELECT i FROM InfoTMember i WHERE i.ftap = :ftap"),
    @NamedQuery(name = "InfoTMember.findBySicken", query = "SELECT i FROM InfoTMember i WHERE i.sicken = :sicken"),
    @NamedQuery(name = "InfoTMember.findByDeformity", query = "SELECT i FROM InfoTMember i WHERE i.deformity = :deformity"),
    @NamedQuery(name = "InfoTMember.findByOldandinfirm", query = "SELECT i FROM InfoTMember i WHERE i.oldandinfirm = :oldandinfirm"),
    @NamedQuery(name = "InfoTMember.findByWorkability", query = "SELECT i FROM InfoTMember i WHERE i.workability = :workability"),
    @NamedQuery(name = "InfoTMember.findByPicpath", query = "SELECT i FROM InfoTMember i WHERE i.picpath = :picpath"),
    @NamedQuery(name = "InfoTMember.findByStudent", query = "SELECT i FROM InfoTMember i WHERE i.student = :student"),
    @NamedQuery(name = "InfoTMember.findByHealth", query = "SELECT i FROM InfoTMember i WHERE i.health = :health"),
    @NamedQuery(name = "InfoTMember.findByOtherreason", query = "SELECT i FROM InfoTMember i WHERE i.otherreason = :otherreason"),
    @NamedQuery(name = "InfoTMember.findByIndiId", query = "SELECT i FROM InfoTMember i WHERE i.indiId = :indiId"),
    @NamedQuery(name = "InfoTMember.findByMainworkplace", query = "SELECT i FROM InfoTMember i WHERE i.mainworkplace = :mainworkplace"),
    @NamedQuery(name = "InfoTMember.findByMedicaretype", query = "SELECT i FROM InfoTMember i WHERE i.medicaretype = :medicaretype"),
    @NamedQuery(name = "InfoTMember.findByTemp", query = "SELECT i FROM InfoTMember i WHERE i.temp = :temp"),
    @NamedQuery(name = "InfoTMember.findByFtaplevel", query = "SELECT i FROM InfoTMember i WHERE i.ftaplevel = :ftaplevel"),
    @NamedQuery(name = "InfoTMember.findByMzbMemId", query = "SELECT i FROM InfoTMember i WHERE i.mzbMemId = :mzbMemId"),
    @NamedQuery(name = "InfoTMember.findByMzbFamId", query = "SELECT i FROM InfoTMember i WHERE i.mzbFamId = :mzbFamId"),
    @NamedQuery(name = "InfoTMember.findByDegreesort1", query = "SELECT i FROM InfoTMember i WHERE i.degreesort1 = :degreesort1")})
public class InfoTMember implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "MEMBER_ID", nullable = false, precision = 22)
    private BigDecimal memberId;
    private BigInteger relmaster;
    @Column(length = 64)
    private String membername;
    private BigInteger papertype;
    @Column(length = 64)
    private String paperid;
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    private BigInteger sex;
    private BigInteger nation;
    private BigInteger ismarriage;
    private BigInteger political;
    private BigInteger rprkind;
    private BigInteger rprtype;
    @Column(length = 200)
    private String rpraddress;
    private BigInteger degreesort;
    private BigInteger policy;
    private BigInteger ftap;
    private BigInteger sicken;
    private BigInteger deformity;
    private BigInteger oldandinfirm;
    private BigInteger workability;
    @Column(length = 400)
    private String picpath;
    private BigInteger student;
    private BigInteger health;
    @Column(length = 400)
    private String otherreason;
    @Column(name = "INDI_ID", length = 50)
    private String indiId;
    @Column(length = 50)
    private String mainworkplace;
    private Character medicaretype;
    private Character temp;
    private BigInteger ftaplevel;
    @Column(name = "MZB_MEM_ID", length = 50)
    private String mzbMemId;
    @Column(name = "MZB_FAM_ID", length = 50)
    private String mzbFamId;
    @Column(length = 50)
    private String degreesort1;
    @JoinColumn(name = "FAMILY_ID", referencedColumnName = "FAMILY_ID")
    @ManyToOne
    private InfoTFamily familyId;
    @OneToMany(mappedBy = "memberId")
    private Set<BizTOptcheck> bizTOptcheckSet;

    public InfoTMember() {
    }

    public InfoTMember(BigDecimal memberId) {
        this.memberId = memberId;
    }

    public BigDecimal getMemberId() {
        return memberId;
    }

    public void setMemberId(BigDecimal memberId) {
        this.memberId = memberId;
    }

    public BigInteger getRelmaster() {
        return relmaster;
    }

    public void setRelmaster(BigInteger relmaster) {
        this.relmaster = relmaster;
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public BigInteger getPapertype() {
        return papertype;
    }

    public void setPapertype(BigInteger papertype) {
        this.papertype = papertype;
    }

    public String getPaperid() {
        return paperid;
    }

    public void setPaperid(String paperid) {
        this.paperid = paperid;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public BigInteger getSex() {
        return sex;
    }

    public void setSex(BigInteger sex) {
        this.sex = sex;
    }

    public BigInteger getNation() {
        return nation;
    }

    public void setNation(BigInteger nation) {
        this.nation = nation;
    }

    public BigInteger getIsmarriage() {
        return ismarriage;
    }

    public void setIsmarriage(BigInteger ismarriage) {
        this.ismarriage = ismarriage;
    }

    public BigInteger getPolitical() {
        return political;
    }

    public void setPolitical(BigInteger political) {
        this.political = political;
    }

    public BigInteger getRprkind() {
        return rprkind;
    }

    public void setRprkind(BigInteger rprkind) {
        this.rprkind = rprkind;
    }

    public BigInteger getRprtype() {
        return rprtype;
    }

    public void setRprtype(BigInteger rprtype) {
        this.rprtype = rprtype;
    }

    public String getRpraddress() {
        return rpraddress;
    }

    public void setRpraddress(String rpraddress) {
        this.rpraddress = rpraddress;
    }

    public BigInteger getDegreesort() {
        return degreesort;
    }

    public void setDegreesort(BigInteger degreesort) {
        this.degreesort = degreesort;
    }

    public BigInteger getPolicy() {
        return policy;
    }

    public void setPolicy(BigInteger policy) {
        this.policy = policy;
    }

    public BigInteger getFtap() {
        return ftap;
    }

    public void setFtap(BigInteger ftap) {
        this.ftap = ftap;
    }

    public BigInteger getSicken() {
        return sicken;
    }

    public void setSicken(BigInteger sicken) {
        this.sicken = sicken;
    }

    public BigInteger getDeformity() {
        return deformity;
    }

    public void setDeformity(BigInteger deformity) {
        this.deformity = deformity;
    }

    public BigInteger getOldandinfirm() {
        return oldandinfirm;
    }

    public void setOldandinfirm(BigInteger oldandinfirm) {
        this.oldandinfirm = oldandinfirm;
    }

    public BigInteger getWorkability() {
        return workability;
    }

    public void setWorkability(BigInteger workability) {
        this.workability = workability;
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath;
    }

    public BigInteger getStudent() {
        return student;
    }

    public void setStudent(BigInteger student) {
        this.student = student;
    }

    public BigInteger getHealth() {
        return health;
    }

    public void setHealth(BigInteger health) {
        this.health = health;
    }

    public String getOtherreason() {
        return otherreason;
    }

    public void setOtherreason(String otherreason) {
        this.otherreason = otherreason;
    }

    public String getIndiId() {
        return indiId;
    }

    public void setIndiId(String indiId) {
        this.indiId = indiId;
    }

    public String getMainworkplace() {
        return mainworkplace;
    }

    public void setMainworkplace(String mainworkplace) {
        this.mainworkplace = mainworkplace;
    }

    public Character getMedicaretype() {
        return medicaretype;
    }

    public void setMedicaretype(Character medicaretype) {
        this.medicaretype = medicaretype;
    }

    public Character getTemp() {
        return temp;
    }

    public void setTemp(Character temp) {
        this.temp = temp;
    }

    public BigInteger getFtaplevel() {
        return ftaplevel;
    }

    public void setFtaplevel(BigInteger ftaplevel) {
        this.ftaplevel = ftaplevel;
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

    public String getDegreesort1() {
        return degreesort1;
    }

    public void setDegreesort1(String degreesort1) {
        this.degreesort1 = degreesort1;
    }

    public InfoTFamily getFamilyId() {
        return familyId;
    }

    public void setFamilyId(InfoTFamily familyId) {
        this.familyId = familyId;
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
        hash += (memberId != null ? memberId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InfoTMember)) {
            return false;
        }
        InfoTMember other = (InfoTMember) object;
        if ((this.memberId == null && other.memberId != null) || (this.memberId != null && !this.memberId.equals(other.memberId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.shengnc.InfoTMember[ memberId=" + memberId + " ]";
    }
    
}
