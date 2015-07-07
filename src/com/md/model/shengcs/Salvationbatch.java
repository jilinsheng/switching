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
    @NamedQuery(name = "Salvationbatch.findAll", query = "SELECT s FROM Salvationbatch s"),
    @NamedQuery(name = "Salvationbatch.findBySbId", query = "SELECT s FROM Salvationbatch s WHERE s.sbId = :sbId"),
    @NamedQuery(name = "Salvationbatch.findByOnNo", query = "SELECT s FROM Salvationbatch s WHERE s.onNo = :onNo"),
    @NamedQuery(name = "Salvationbatch.findBySbTime", query = "SELECT s FROM Salvationbatch s WHERE s.sbTime = :sbTime"),
    @NamedQuery(name = "Salvationbatch.findBySbBatchname", query = "SELECT s FROM Salvationbatch s WHERE s.sbBatchname = :sbBatchname"),
    @NamedQuery(name = "Salvationbatch.findBySbDisposests", query = "SELECT s FROM Salvationbatch s WHERE s.sbDisposests = :sbDisposests"),
    @NamedQuery(name = "Salvationbatch.findBySbBegintime", query = "SELECT s FROM Salvationbatch s WHERE s.sbBegintime = :sbBegintime"),
    @NamedQuery(name = "Salvationbatch.findBySbEndtime", query = "SELECT s FROM Salvationbatch s WHERE s.sbEndtime = :sbEndtime"),
    @NamedQuery(name = "Salvationbatch.findBySoId", query = "SELECT s FROM Salvationbatch s WHERE s.soId = :soId"),
    @NamedQuery(name = "Salvationbatch.findBySbUpid", query = "SELECT s FROM Salvationbatch s WHERE s.sbUpid = :sbUpid"),
    @NamedQuery(name = "Salvationbatch.findBySbValue", query = "SELECT s FROM Salvationbatch s WHERE s.sbValue = :sbValue"),
    @NamedQuery(name = "Salvationbatch.findBySbBanksts", query = "SELECT s FROM Salvationbatch s WHERE s.sbBanksts = :sbBanksts"),
    @NamedQuery(name = "Salvationbatch.findBySbDetail", query = "SELECT s FROM Salvationbatch s WHERE s.sbDetail = :sbDetail"),
    @NamedQuery(name = "Salvationbatch.findBySbCountunit", query = "SELECT s FROM Salvationbatch s WHERE s.sbCountunit = :sbCountunit"),
    @NamedQuery(name = "Salvationbatch.findByOldsbId", query = "SELECT s FROM Salvationbatch s WHERE s.oldsbId = :oldsbId")})
public class Salvationbatch implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SB_ID", nullable = false, length = 50)
    private String sbId;
    @Basic(optional = false)
    @Column(name = "ON_NO", nullable = false, length = 50)
    private String onNo;
    @Column(name = "SB_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sbTime;
    @Column(name = "SB_BATCHNAME", length = 200)
    private String sbBatchname;
    @Column(name = "SB_DISPOSESTS", length = 20)
    private String sbDisposests;
    @Column(name = "SB_BEGINTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sbBegintime;
    @Column(name = "SB_ENDTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sbEndtime;
    @Column(name = "SO_ID", length = 50)
    private String soId;
    @Column(name = "SB_UPID", length = 50)
    private String sbUpid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SB_VALUE", precision = 8, scale = 2)
    private BigDecimal sbValue;
    @Column(name = "SB_BANKSTS", length = 20)
    private String sbBanksts;
    @Column(name = "SB_DETAIL", length = 800)
    private String sbDetail;
    @Column(name = "SB_COUNTUNIT", length = 20)
    private String sbCountunit;
    @Column(name = "OLDSB_ID", length = 50)
    private String oldsbId;

    public Salvationbatch() {
    }

    public Salvationbatch(String sbId) {
        this.sbId = sbId;
    }

    public Salvationbatch(String sbId, String onNo) {
        this.sbId = sbId;
        this.onNo = onNo;
    }

    public String getSbId() {
        return sbId;
    }

    public void setSbId(String sbId) {
        this.sbId = sbId;
    }

    public String getOnNo() {
        return onNo;
    }

    public void setOnNo(String onNo) {
        this.onNo = onNo;
    }

    public Date getSbTime() {
        return sbTime;
    }

    public void setSbTime(Date sbTime) {
        this.sbTime = sbTime;
    }

    public String getSbBatchname() {
        return sbBatchname;
    }

    public void setSbBatchname(String sbBatchname) {
        this.sbBatchname = sbBatchname;
    }

    public String getSbDisposests() {
        return sbDisposests;
    }

    public void setSbDisposests(String sbDisposests) {
        this.sbDisposests = sbDisposests;
    }

    public Date getSbBegintime() {
        return sbBegintime;
    }

    public void setSbBegintime(Date sbBegintime) {
        this.sbBegintime = sbBegintime;
    }

    public Date getSbEndtime() {
        return sbEndtime;
    }

    public void setSbEndtime(Date sbEndtime) {
        this.sbEndtime = sbEndtime;
    }

    public String getSoId() {
        return soId;
    }

    public void setSoId(String soId) {
        this.soId = soId;
    }

    public String getSbUpid() {
        return sbUpid;
    }

    public void setSbUpid(String sbUpid) {
        this.sbUpid = sbUpid;
    }

    public BigDecimal getSbValue() {
        return sbValue;
    }

    public void setSbValue(BigDecimal sbValue) {
        this.sbValue = sbValue;
    }

    public String getSbBanksts() {
        return sbBanksts;
    }

    public void setSbBanksts(String sbBanksts) {
        this.sbBanksts = sbBanksts;
    }

    public String getSbDetail() {
        return sbDetail;
    }

    public void setSbDetail(String sbDetail) {
        this.sbDetail = sbDetail;
    }

    public String getSbCountunit() {
        return sbCountunit;
    }

    public void setSbCountunit(String sbCountunit) {
        this.sbCountunit = sbCountunit;
    }

    public String getOldsbId() {
        return oldsbId;
    }

    public void setOldsbId(String oldsbId) {
        this.oldsbId = oldsbId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sbId != null ? sbId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salvationbatch)) {
            return false;
        }
        Salvationbatch other = (Salvationbatch) object;
        if ((this.sbId == null && other.sbId != null) || (this.sbId != null && !this.sbId.equals(other.sbId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.shengcs.Salvationbatch[ sbId=" + sbId + " ]";
    }
    
}
