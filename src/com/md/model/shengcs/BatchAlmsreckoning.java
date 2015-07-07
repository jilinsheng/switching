/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.model.shengcs;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "BATCH_ALMSRECKONING", catalog = "", schema = "JLDBCS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BatchAlmsreckoning.findAll", query = "SELECT b FROM BatchAlmsreckoning b"),
    @NamedQuery(name = "BatchAlmsreckoning.findByBarId", query = "SELECT b FROM BatchAlmsreckoning b WHERE b.barId = :barId"),
    @NamedQuery(name = "BatchAlmsreckoning.findByBarSubject", query = "SELECT b FROM BatchAlmsreckoning b WHERE b.barSubject = :barSubject"),
    @NamedQuery(name = "BatchAlmsreckoning.findByBarMoney", query = "SELECT b FROM BatchAlmsreckoning b WHERE b.barMoney = :barMoney"),
    @NamedQuery(name = "BatchAlmsreckoning.findByBarMaster", query = "SELECT b FROM BatchAlmsreckoning b WHERE b.barMaster = :barMaster"),
    @NamedQuery(name = "BatchAlmsreckoning.findByBarFmidcard", query = "SELECT b FROM BatchAlmsreckoning b WHERE b.barFmidcard = :barFmidcard"),
    @NamedQuery(name = "BatchAlmsreckoning.findByBarBankAccounts", query = "SELECT b FROM BatchAlmsreckoning b WHERE b.barBankAccounts = :barBankAccounts"),
    @NamedQuery(name = "BatchAlmsreckoning.findBySbId", query = "SELECT b FROM BatchAlmsreckoning b WHERE b.sbId = :sbId"),
    @NamedQuery(name = "BatchAlmsreckoning.findByBarFamilyno", query = "SELECT b FROM BatchAlmsreckoning b WHERE b.barFamilyno = :barFamilyno"),
    @NamedQuery(name = "BatchAlmsreckoning.findByBarAwardflag", query = "SELECT b FROM BatchAlmsreckoning b WHERE b.barAwardflag = :barAwardflag"),
    @NamedQuery(name = "BatchAlmsreckoning.findByBarFamilyid", query = "SELECT b FROM BatchAlmsreckoning b WHERE b.barFamilyid = :barFamilyid"),
    @NamedQuery(name = "BatchAlmsreckoning.findByOnNo", query = "SELECT b FROM BatchAlmsreckoning b WHERE b.onNo = :onNo"),
    @NamedQuery(name = "BatchAlmsreckoning.findBySaId", query = "SELECT b FROM BatchAlmsreckoning b WHERE b.saId = :saId"),
    @NamedQuery(name = "BatchAlmsreckoning.findByBarFamilycount", query = "SELECT b FROM BatchAlmsreckoning b WHERE b.barFamilycount = :barFamilycount"),
    @NamedQuery(name = "BatchAlmsreckoning.findByStId", query = "SELECT b FROM BatchAlmsreckoning b WHERE b.stId = :stId"),
    @NamedQuery(name = "BatchAlmsreckoning.findByStandard", query = "SELECT b FROM BatchAlmsreckoning b WHERE b.standard = :standard"),
    @NamedQuery(name = "BatchAlmsreckoning.findByOldbarId", query = "SELECT b FROM BatchAlmsreckoning b WHERE b.oldbarId = :oldbarId")})
public class BatchAlmsreckoning implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BAR_ID", nullable = false, length = 50)
    private String barId;
    @Column(name = "BAR_SUBJECT", length = 50)
    private String barSubject;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BAR_MONEY", precision = 8, scale = 2)
    private BigDecimal barMoney;
    @Column(name = "BAR_MASTER", length = 200)
    private String barMaster;
    @Column(name = "BAR_FMIDCARD", length = 50)
    private String barFmidcard;
    @Column(name = "BAR_BANK_ACCOUNTS", length = 50)
    private String barBankAccounts;
    @Column(name = "SB_ID", length = 50)
    private String sbId;
    @Column(name = "BAR_FAMILYNO", length = 50)
    private String barFamilyno;
    @Column(name = "BAR_AWARDFLAG", length = 20)
    private String barAwardflag;
    @Column(name = "BAR_FAMILYID", length = 50)
    private String barFamilyid;
    @Column(name = "ON_NO", length = 50)
    private String onNo;
    @Column(name = "SA_ID", length = 50)
    private String saId;
    @Column(name = "BAR_FAMILYCOUNT")
    private BigInteger barFamilycount;
    @Column(name = "ST_ID", length = 50)
    private String stId;
    private BigInteger standard;
    @Column(name = "OLDBAR_ID", length = 50)
    private String oldbarId;

    public BatchAlmsreckoning() {
    }

    public BatchAlmsreckoning(String barId) {
        this.barId = barId;
    }

    public String getBarId() {
        return barId;
    }

    public void setBarId(String barId) {
        this.barId = barId;
    }

    public String getBarSubject() {
        return barSubject;
    }

    public void setBarSubject(String barSubject) {
        this.barSubject = barSubject;
    }

    public BigDecimal getBarMoney() {
        return barMoney;
    }

    public void setBarMoney(BigDecimal barMoney) {
        this.barMoney = barMoney;
    }

    public String getBarMaster() {
        return barMaster;
    }

    public void setBarMaster(String barMaster) {
        this.barMaster = barMaster;
    }

    public String getBarFmidcard() {
        return barFmidcard;
    }

    public void setBarFmidcard(String barFmidcard) {
        this.barFmidcard = barFmidcard;
    }

    public String getBarBankAccounts() {
        return barBankAccounts;
    }

    public void setBarBankAccounts(String barBankAccounts) {
        this.barBankAccounts = barBankAccounts;
    }

    public String getSbId() {
        return sbId;
    }

    public void setSbId(String sbId) {
        this.sbId = sbId;
    }

    public String getBarFamilyno() {
        return barFamilyno;
    }

    public void setBarFamilyno(String barFamilyno) {
        this.barFamilyno = barFamilyno;
    }

    public String getBarAwardflag() {
        return barAwardflag;
    }

    public void setBarAwardflag(String barAwardflag) {
        this.barAwardflag = barAwardflag;
    }

    public String getBarFamilyid() {
        return barFamilyid;
    }

    public void setBarFamilyid(String barFamilyid) {
        this.barFamilyid = barFamilyid;
    }

    public String getOnNo() {
        return onNo;
    }

    public void setOnNo(String onNo) {
        this.onNo = onNo;
    }

    public String getSaId() {
        return saId;
    }

    public void setSaId(String saId) {
        this.saId = saId;
    }

    public BigInteger getBarFamilycount() {
        return barFamilycount;
    }

    public void setBarFamilycount(BigInteger barFamilycount) {
        this.barFamilycount = barFamilycount;
    }

    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    public BigInteger getStandard() {
        return standard;
    }

    public void setStandard(BigInteger standard) {
        this.standard = standard;
    }

    public String getOldbarId() {
        return oldbarId;
    }

    public void setOldbarId(String oldbarId) {
        this.oldbarId = oldbarId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (barId != null ? barId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BatchAlmsreckoning)) {
            return false;
        }
        BatchAlmsreckoning other = (BatchAlmsreckoning) object;
        if ((this.barId == null && other.barId != null) || (this.barId != null && !this.barId.equals(other.barId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.shengcs.BatchAlmsreckoning[ barId=" + barId + " ]";
    }
    
}
