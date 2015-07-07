/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.model.shengcs;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(catalog = "", schema = "JLDBCS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Family.findAll", query = "SELECT f FROM Family f"),
    @NamedQuery(name = "Family.findByFFamilyid", query = "SELECT f FROM Family f WHERE f.fFamilyid = :fFamilyid"),
    @NamedQuery(name = "Family.findByFFamilyno", query = "SELECT f FROM Family f WHERE f.fFamilyno = :fFamilyno"),
    @NamedQuery(name = "Family.findByFDescription", query = "SELECT f FROM Family f WHERE f.fDescription = :fDescription"),
    @NamedQuery(name = "Family.findByFState", query = "SELECT f FROM Family f WHERE f.fState = :fState"),
    @NamedQuery(name = "Family.findByUpdatetime", query = "SELECT f FROM Family f WHERE f.updatetime = :updatetime"),
    @NamedQuery(name = "Family.findByFPersoncount", query = "SELECT f FROM Family f WHERE f.fPersoncount = :fPersoncount"),
    @NamedQuery(name = "Family.findByRegtime", query = "SELECT f FROM Family f WHERE f.regtime = :regtime"),
    @NamedQuery(name = "Family.findByUpdateemp", query = "SELECT f FROM Family f WHERE f.updateemp = :updateemp"),
    @NamedQuery(name = "Family.findByFSalvationcount", query = "SELECT f FROM Family f WHERE f.fSalvationcount = :fSalvationcount"),
    @NamedQuery(name = "Family.findByUpdatereason", query = "SELECT f FROM Family f WHERE f.updatereason = :updatereason"),
    @NamedQuery(name = "Family.findByFAccounts", query = "SELECT f FROM Family f WHERE f.fAccounts = :fAccounts"),
    @NamedQuery(name = "Family.findByRegemp", query = "SELECT f FROM Family f WHERE f.regemp = :regemp"),
    @NamedQuery(name = "Family.findByFMasterid", query = "SELECT f FROM Family f WHERE f.fMasterid = :fMasterid"),
    @NamedQuery(name = "Family.findByAudsts", query = "SELECT f FROM Family f WHERE f.audsts = :audsts"),
    @NamedQuery(name = "Family.findByAudid", query = "SELECT f FROM Family f WHERE f.audid = :audid"),
    @NamedQuery(name = "Family.findByFBankname", query = "SELECT f FROM Family f WHERE f.fBankname = :fBankname"),
    @NamedQuery(name = "Family.findByFKzflag", query = "SELECT f FROM Family f WHERE f.fKzflag = :fKzflag"),
    @NamedQuery(name = "Family.findByFIncome", query = "SELECT f FROM Family f WHERE f.fIncome = :fIncome"),
    @NamedQuery(name = "Family.findByFJxincome", query = "SELECT f FROM Family f WHERE f.fJxincome = :fJxincome"),
    @NamedQuery(name = "Family.findByFPayout", query = "SELECT f FROM Family f WHERE f.fPayout = :fPayout"),
    @NamedQuery(name = "Family.findByOperationstate", query = "SELECT f FROM Family f WHERE f.operationstate = :operationstate"),
    @NamedQuery(name = "Family.findByFDe", query = "SELECT f FROM Family f WHERE f.fDe = :fDe"),
    @NamedQuery(name = "Family.findByFDename", query = "SELECT f FROM Family f WHERE f.fDename = :fDename"),
    @NamedQuery(name = "Family.findByFDefamilyno", query = "SELECT f FROM Family f WHERE f.fDefamilyno = :fDefamilyno"),
    @NamedQuery(name = "Family.findByOldfFamilyid", query = "SELECT f FROM Family f WHERE f.oldfFamilyid = :oldfFamilyid"),
    @NamedQuery(name = "Family.findBySalvationId", query = "SELECT f FROM Family f WHERE f.salvationId = :salvationId"),
    @NamedQuery(name = "Family.findByMzbFamId", query = "SELECT f FROM Family f WHERE f.mzbFamId = :mzbFamId")})
public class Family implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "F_FAMILYID", nullable = false, length = 50)
    private String fFamilyid;
    @Column(name = "F_FAMILYNO", length = 50)
    private String fFamilyno;
    @Column(name = "F_DESCRIPTION", length = 200)
    private String fDescription;
    @Column(name = "F_STATE", length = 50)
    private String fState;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatetime;
    @Column(name = "F_PERSONCOUNT")
    private BigInteger fPersoncount;
    @Temporal(TemporalType.TIMESTAMP)
    private Date regtime;
    @Column(length = 50)
    private String updateemp;
    @Column(name = "F_SALVATIONCOUNT")
    private BigInteger fSalvationcount;
    @Column(length = 200)
    private String updatereason;
    @Column(name = "F_ACCOUNTS", length = 50)
    private String fAccounts;
    @Column(length = 50)
    private String regemp;
    @Column(name = "F_MASTERID", length = 50)
    private String fMasterid;
    @Column(length = 50)
    private String audsts;
    @Column(length = 50)
    private String audid;
    @Column(name = "F_BANKNAME", length = 200)
    private String fBankname;
    @Column(name = "F_KZFLAG", length = 20)
    private String fKzflag;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "F_INCOME", precision = 8, scale = 2)
    private BigDecimal fIncome;
    @Column(name = "F_JXINCOME", precision = 8, scale = 2)
    private BigDecimal fJxincome;
    @Column(name = "F_PAYOUT", precision = 8, scale = 2)
    private BigDecimal fPayout;
    @Column(length = 200)
    private String operationstate;
    @Column(name = "F_DE", length = 50)
    private String fDe;
    @Column(name = "F_DENAME", length = 50)
    private String fDename;
    @Column(name = "F_DEFAMILYNO", length = 50)
    private String fDefamilyno;
    @Column(name = "OLDF_FAMILYID", length = 50)
    private String oldfFamilyid;
    @Column(name = "SALVATION_ID", length = 100)
    private String salvationId;
    @Column(name = "MZB_FAM_ID", length = 100)
    private String mzbFamId;
    @OneToMany(mappedBy = "fFamilyid", fetch = FetchType.LAZY)
    private List<Familymember> familymemberList;
    @JoinColumn(name = "ON_NO", referencedColumnName = "ON_NO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Organno onNo;

    public Family() {
    }

    public Family(String fFamilyid) {
        this.fFamilyid = fFamilyid;
    }

    public String getFFamilyid() {
        return fFamilyid;
    }

    public void setFFamilyid(String fFamilyid) {
        this.fFamilyid = fFamilyid;
    }

    public String getFFamilyno() {
        return fFamilyno;
    }

    public void setFFamilyno(String fFamilyno) {
        this.fFamilyno = fFamilyno;
    }

    public String getFDescription() {
        return fDescription;
    }

    public void setFDescription(String fDescription) {
        this.fDescription = fDescription;
    }

    public String getFState() {
        return fState;
    }

    public void setFState(String fState) {
        this.fState = fState;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public BigInteger getFPersoncount() {
        return fPersoncount;
    }

    public void setFPersoncount(BigInteger fPersoncount) {
        this.fPersoncount = fPersoncount;
    }

    public Date getRegtime() {
        return regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    public String getUpdateemp() {
        return updateemp;
    }

    public void setUpdateemp(String updateemp) {
        this.updateemp = updateemp;
    }

    public BigInteger getFSalvationcount() {
        return fSalvationcount;
    }

    public void setFSalvationcount(BigInteger fSalvationcount) {
        this.fSalvationcount = fSalvationcount;
    }

    public String getUpdatereason() {
        return updatereason;
    }

    public void setUpdatereason(String updatereason) {
        this.updatereason = updatereason;
    }

    public String getFAccounts() {
        return fAccounts;
    }

    public void setFAccounts(String fAccounts) {
        this.fAccounts = fAccounts;
    }

    public String getRegemp() {
        return regemp;
    }

    public void setRegemp(String regemp) {
        this.regemp = regemp;
    }

    public String getFMasterid() {
        return fMasterid;
    }

    public void setFMasterid(String fMasterid) {
        this.fMasterid = fMasterid;
    }

    public String getAudsts() {
        return audsts;
    }

    public void setAudsts(String audsts) {
        this.audsts = audsts;
    }

    public String getAudid() {
        return audid;
    }

    public void setAudid(String audid) {
        this.audid = audid;
    }

    public String getFBankname() {
        return fBankname;
    }

    public void setFBankname(String fBankname) {
        this.fBankname = fBankname;
    }

    public String getFKzflag() {
        return fKzflag;
    }

    public void setFKzflag(String fKzflag) {
        this.fKzflag = fKzflag;
    }

    public BigDecimal getFIncome() {
        return fIncome;
    }

    public void setFIncome(BigDecimal fIncome) {
        this.fIncome = fIncome;
    }

    public BigDecimal getFJxincome() {
        return fJxincome;
    }

    public void setFJxincome(BigDecimal fJxincome) {
        this.fJxincome = fJxincome;
    }

    public BigDecimal getFPayout() {
        return fPayout;
    }

    public void setFPayout(BigDecimal fPayout) {
        this.fPayout = fPayout;
    }

    public String getOperationstate() {
        return operationstate;
    }

    public void setOperationstate(String operationstate) {
        this.operationstate = operationstate;
    }

    public String getFDe() {
        return fDe;
    }

    public void setFDe(String fDe) {
        this.fDe = fDe;
    }

    public String getFDename() {
        return fDename;
    }

    public void setFDename(String fDename) {
        this.fDename = fDename;
    }

    public String getFDefamilyno() {
        return fDefamilyno;
    }

    public void setFDefamilyno(String fDefamilyno) {
        this.fDefamilyno = fDefamilyno;
    }

    public String getOldfFamilyid() {
        return oldfFamilyid;
    }

    public void setOldfFamilyid(String oldfFamilyid) {
        this.oldfFamilyid = oldfFamilyid;
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

    @XmlTransient
    public List<Familymember> getFamilymemberList() {
        return familymemberList;
    }

    public void setFamilymemberList(List<Familymember> familymemberList) {
        this.familymemberList = familymemberList;
    }

    public Organno getOnNo() {
        return onNo;
    }

    public void setOnNo(Organno onNo) {
        this.onNo = onNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fFamilyid != null ? fFamilyid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Family)) {
            return false;
        }
        Family other = (Family) object;
        if ((this.fFamilyid == null && other.fFamilyid != null) || (this.fFamilyid != null && !this.fFamilyid.equals(other.fFamilyid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.shengcs.Family[ fFamilyid=" + fFamilyid + " ]";
    }
    
}
