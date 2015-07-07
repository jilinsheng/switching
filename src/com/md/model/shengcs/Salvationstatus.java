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
    @NamedQuery(name = "Salvationstatus.findAll", query = "SELECT s FROM Salvationstatus s"),
    @NamedQuery(name = "Salvationstatus.findBySsId", query = "SELECT s FROM Salvationstatus s WHERE s.ssId = :ssId"),
    @NamedQuery(name = "Salvationstatus.findBySsObjecttype", query = "SELECT s FROM Salvationstatus s WHERE s.ssObjecttype = :ssObjecttype"),
    @NamedQuery(name = "Salvationstatus.findBySsOtId", query = "SELECT s FROM Salvationstatus s WHERE s.ssOtId = :ssOtId"),
    @NamedQuery(name = "Salvationstatus.findBySsState", query = "SELECT s FROM Salvationstatus s WHERE s.ssState = :ssState"),
    @NamedQuery(name = "Salvationstatus.findBySaId", query = "SELECT s FROM Salvationstatus s WHERE s.saId = :saId"),
    @NamedQuery(name = "Salvationstatus.findBySsNexttime", query = "SELECT s FROM Salvationstatus s WHERE s.ssNexttime = :ssNexttime"),
    @NamedQuery(name = "Salvationstatus.findBySsTime", query = "SELECT s FROM Salvationstatus s WHERE s.ssTime = :ssTime"),
    @NamedQuery(name = "Salvationstatus.findBySsCount", query = "SELECT s FROM Salvationstatus s WHERE s.ssCount = :ssCount"),
    @NamedQuery(name = "Salvationstatus.findBySsBegintime", query = "SELECT s FROM Salvationstatus s WHERE s.ssBegintime = :ssBegintime"),
    @NamedQuery(name = "Salvationstatus.findBySsMoney", query = "SELECT s FROM Salvationstatus s WHERE s.ssMoney = :ssMoney"),
    @NamedQuery(name = "Salvationstatus.findBySsAward", query = "SELECT s FROM Salvationstatus s WHERE s.ssAward = :ssAward"),
    @NamedQuery(name = "Salvationstatus.findBySbId", query = "SELECT s FROM Salvationstatus s WHERE s.sbId = :sbId"),
    @NamedQuery(name = "Salvationstatus.findBySsUpmoney", query = "SELECT s FROM Salvationstatus s WHERE s.ssUpmoney = :ssUpmoney"),
    @NamedQuery(name = "Salvationstatus.findByOldssId", query = "SELECT s FROM Salvationstatus s WHERE s.oldssId = :oldssId")})
public class Salvationstatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SS_ID", nullable = false, length = 50)
    private String ssId;
    @Column(name = "SS_OBJECTTYPE", length = 20)
    private String ssObjecttype;
    @Column(name = "SS_OT_ID", length = 50)
    private String ssOtId;
    @Column(name = "SS_STATE", length = 20)
    private String ssState;
    @Column(name = "SA_ID", length = 50)
    private String saId;
    @Column(name = "SS_NEXTTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ssNexttime;
    @Column(name = "SS_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ssTime;
    @Column(name = "SS_COUNT")
    private BigInteger ssCount;
    @Column(name = "SS_BEGINTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ssBegintime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SS_MONEY", precision = 8, scale = 2)
    private BigDecimal ssMoney;
    @Column(name = "SS_AWARD", length = 4)
    private String ssAward;
    @Column(name = "SB_ID", length = 50)
    private String sbId;
    @Column(name = "SS_UPMONEY", precision = 8, scale = 2)
    private BigDecimal ssUpmoney;
    @Column(name = "OLDSS_ID", length = 50)
    private String oldssId;
    @JoinColumn(name = "ON_NO", referencedColumnName = "ON_NO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Organno onNo;
    @JoinColumn(name = "ST_ID", referencedColumnName = "ST_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Salvationtype stId;

    public Salvationstatus() {
    }

    public Salvationstatus(String ssId) {
        this.ssId = ssId;
    }

    public String getSsId() {
        return ssId;
    }

    public void setSsId(String ssId) {
        this.ssId = ssId;
    }

    public String getSsObjecttype() {
        return ssObjecttype;
    }

    public void setSsObjecttype(String ssObjecttype) {
        this.ssObjecttype = ssObjecttype;
    }

    public String getSsOtId() {
        return ssOtId;
    }

    public void setSsOtId(String ssOtId) {
        this.ssOtId = ssOtId;
    }

    public String getSsState() {
        return ssState;
    }

    public void setSsState(String ssState) {
        this.ssState = ssState;
    }

    public String getSaId() {
        return saId;
    }

    public void setSaId(String saId) {
        this.saId = saId;
    }

    public Date getSsNexttime() {
        return ssNexttime;
    }

    public void setSsNexttime(Date ssNexttime) {
        this.ssNexttime = ssNexttime;
    }

    public Date getSsTime() {
        return ssTime;
    }

    public void setSsTime(Date ssTime) {
        this.ssTime = ssTime;
    }

    public BigInteger getSsCount() {
        return ssCount;
    }

    public void setSsCount(BigInteger ssCount) {
        this.ssCount = ssCount;
    }

    public Date getSsBegintime() {
        return ssBegintime;
    }

    public void setSsBegintime(Date ssBegintime) {
        this.ssBegintime = ssBegintime;
    }

    public BigDecimal getSsMoney() {
        return ssMoney;
    }

    public void setSsMoney(BigDecimal ssMoney) {
        this.ssMoney = ssMoney;
    }

    public String getSsAward() {
        return ssAward;
    }

    public void setSsAward(String ssAward) {
        this.ssAward = ssAward;
    }

    public String getSbId() {
        return sbId;
    }

    public void setSbId(String sbId) {
        this.sbId = sbId;
    }

    public BigDecimal getSsUpmoney() {
        return ssUpmoney;
    }

    public void setSsUpmoney(BigDecimal ssUpmoney) {
        this.ssUpmoney = ssUpmoney;
    }

    public String getOldssId() {
        return oldssId;
    }

    public void setOldssId(String oldssId) {
        this.oldssId = oldssId;
    }

    public Organno getOnNo() {
        return onNo;
    }

    public void setOnNo(Organno onNo) {
        this.onNo = onNo;
    }

    public Salvationtype getStId() {
        return stId;
    }

    public void setStId(Salvationtype stId) {
        this.stId = stId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ssId != null ? ssId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salvationstatus)) {
            return false;
        }
        Salvationstatus other = (Salvationstatus) object;
        if ((this.ssId == null && other.ssId != null) || (this.ssId != null && !this.ssId.equals(other.ssId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.shengcs.Salvationstatus[ ssId=" + ssId + " ]";
    }
    
}
