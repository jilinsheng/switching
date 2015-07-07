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
@Table(name = "BIZ_T_OPTCHECKIDEA2", catalog = "", schema = "SUMMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BizTOptcheckidea2.findAll", query = "SELECT b FROM BizTOptcheckidea2 b"),
    @NamedQuery(name = "BizTOptcheckidea2.findByOptcheckidea2Id", query = "SELECT b FROM BizTOptcheckidea2 b WHERE b.optcheckidea2Id = :optcheckidea2Id"),
    @NamedQuery(name = "BizTOptcheckidea2.findByOptcheckideaId", query = "SELECT b FROM BizTOptcheckidea2 b WHERE b.optcheckideaId = :optcheckideaId"),
    @NamedQuery(name = "BizTOptcheckidea2.findByOptcheck2Id", query = "SELECT b FROM BizTOptcheckidea2 b WHERE b.optcheck2Id = :optcheck2Id"),
    @NamedQuery(name = "BizTOptcheckidea2.findByAppideaman", query = "SELECT b FROM BizTOptcheckidea2 b WHERE b.appideaman = :appideaman"),
    @NamedQuery(name = "BizTOptcheckidea2.findByAppmandelnum", query = "SELECT b FROM BizTOptcheckidea2 b WHERE b.appmandelnum = :appmandelnum"),
    @NamedQuery(name = "BizTOptcheckidea2.findByAppmanoknum", query = "SELECT b FROM BizTOptcheckidea2 b WHERE b.appmanoknum = :appmanoknum"),
    @NamedQuery(name = "BizTOptcheckidea2.findByAppmannum", query = "SELECT b FROM BizTOptcheckidea2 b WHERE b.appmannum = :appmannum"),
    @NamedQuery(name = "BizTOptcheckidea2.findByAppmannotnum", query = "SELECT b FROM BizTOptcheckidea2 b WHERE b.appmannotnum = :appmannotnum"),
    @NamedQuery(name = "BizTOptcheckidea2.findByAppresult", query = "SELECT b FROM BizTOptcheckidea2 b WHERE b.appresult = :appresult"),
    @NamedQuery(name = "BizTOptcheckidea2.findByApparea", query = "SELECT b FROM BizTOptcheckidea2 b WHERE b.apparea = :apparea"),
    @NamedQuery(name = "BizTOptcheckidea2.findByRebegdt", query = "SELECT b FROM BizTOptcheckidea2 b WHERE b.rebegdt = :rebegdt"),
    @NamedQuery(name = "BizTOptcheckidea2.findByReenddt", query = "SELECT b FROM BizTOptcheckidea2 b WHERE b.reenddt = :reenddt"),
    @NamedQuery(name = "BizTOptcheckidea2.findByApptime", query = "SELECT b FROM BizTOptcheckidea2 b WHERE b.apptime = :apptime"),
    @NamedQuery(name = "BizTOptcheckidea2.findByNote", query = "SELECT b FROM BizTOptcheckidea2 b WHERE b.note = :note"),
    @NamedQuery(name = "BizTOptcheckidea2.findByDepth", query = "SELECT b FROM BizTOptcheckidea2 b WHERE b.depth = :depth"),
    @NamedQuery(name = "BizTOptcheckidea2.findByCheckoper", query = "SELECT b FROM BizTOptcheckidea2 b WHERE b.checkoper = :checkoper"),
    @NamedQuery(name = "BizTOptcheckidea2.findByCheckdt", query = "SELECT b FROM BizTOptcheckidea2 b WHERE b.checkdt = :checkdt"),
    @NamedQuery(name = "BizTOptcheckidea2.findByStatus", query = "SELECT b FROM BizTOptcheckidea2 b WHERE b.status = :status")})
public class BizTOptcheckidea2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "OPTCHECKIDEA2_ID", nullable = false)
    private BigInteger optcheckidea2Id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "OPTCHECKIDEA_ID", nullable = false, precision = 22)
    private BigDecimal optcheckideaId;
    @Column(name = "OPTCHECK2_ID")
    private BigInteger optcheck2Id;
    @Column(length = 1024)
    private String appideaman;
    private BigInteger appmandelnum;
    private BigInteger appmanoknum;
    private BigInteger appmannum;
    private BigInteger appmannotnum;
    private BigInteger appresult;
    @Column(length = 1024)
    private String apparea;
    @Temporal(TemporalType.TIMESTAMP)
    private Date rebegdt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date reenddt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date apptime;
    @Column(length = 2048)
    private String note;
    private BigInteger depth;
    private BigInteger checkoper;
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkdt;
    private Character status;

    public BizTOptcheckidea2() {
    }

    public BizTOptcheckidea2(BigDecimal optcheckideaId) {
        this.optcheckideaId = optcheckideaId;
    }

    public BizTOptcheckidea2(BigDecimal optcheckideaId, BigInteger optcheckidea2Id) {
        this.optcheckideaId = optcheckideaId;
        this.optcheckidea2Id = optcheckidea2Id;
    }

    public BigInteger getOptcheckidea2Id() {
        return optcheckidea2Id;
    }

    public void setOptcheckidea2Id(BigInteger optcheckidea2Id) {
        this.optcheckidea2Id = optcheckidea2Id;
    }

    public BigDecimal getOptcheckideaId() {
        return optcheckideaId;
    }

    public void setOptcheckideaId(BigDecimal optcheckideaId) {
        this.optcheckideaId = optcheckideaId;
    }

    public BigInteger getOptcheck2Id() {
        return optcheck2Id;
    }

    public void setOptcheck2Id(BigInteger optcheck2Id) {
        this.optcheck2Id = optcheck2Id;
    }

    public String getAppideaman() {
        return appideaman;
    }

    public void setAppideaman(String appideaman) {
        this.appideaman = appideaman;
    }

    public BigInteger getAppmandelnum() {
        return appmandelnum;
    }

    public void setAppmandelnum(BigInteger appmandelnum) {
        this.appmandelnum = appmandelnum;
    }

    public BigInteger getAppmanoknum() {
        return appmanoknum;
    }

    public void setAppmanoknum(BigInteger appmanoknum) {
        this.appmanoknum = appmanoknum;
    }

    public BigInteger getAppmannum() {
        return appmannum;
    }

    public void setAppmannum(BigInteger appmannum) {
        this.appmannum = appmannum;
    }

    public BigInteger getAppmannotnum() {
        return appmannotnum;
    }

    public void setAppmannotnum(BigInteger appmannotnum) {
        this.appmannotnum = appmannotnum;
    }

    public BigInteger getAppresult() {
        return appresult;
    }

    public void setAppresult(BigInteger appresult) {
        this.appresult = appresult;
    }

    public String getApparea() {
        return apparea;
    }

    public void setApparea(String apparea) {
        this.apparea = apparea;
    }

    public Date getRebegdt() {
        return rebegdt;
    }

    public void setRebegdt(Date rebegdt) {
        this.rebegdt = rebegdt;
    }

    public Date getReenddt() {
        return reenddt;
    }

    public void setReenddt(Date reenddt) {
        this.reenddt = reenddt;
    }

    public Date getApptime() {
        return apptime;
    }

    public void setApptime(Date apptime) {
        this.apptime = apptime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BigInteger getDepth() {
        return depth;
    }

    public void setDepth(BigInteger depth) {
        this.depth = depth;
    }

    public BigInteger getCheckoper() {
        return checkoper;
    }

    public void setCheckoper(BigInteger checkoper) {
        this.checkoper = checkoper;
    }

    public Date getCheckdt() {
        return checkdt;
    }

    public void setCheckdt(Date checkdt) {
        this.checkdt = checkdt;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (optcheckideaId != null ? optcheckideaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BizTOptcheckidea2)) {
            return false;
        }
        BizTOptcheckidea2 other = (BizTOptcheckidea2) object;
        if ((this.optcheckideaId == null && other.optcheckideaId != null) || (this.optcheckideaId != null && !this.optcheckideaId.equals(other.optcheckideaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.shengnc.BizTOptcheckidea2[ optcheckideaId=" + optcheckideaId + " ]";
    }
    
}
