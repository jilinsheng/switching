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
@Table(name = "BIZ_T_OPTCHECK", catalog = "", schema = "SUMMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BizTOptcheck.findAll", query = "SELECT b FROM BizTOptcheck b"),
    @NamedQuery(name = "BizTOptcheck.findByOptcheckId", query = "SELECT b FROM BizTOptcheck b WHERE b.optcheckId = :optcheckId"),
    @NamedQuery(name = "BizTOptcheck.findByAcctype", query = "SELECT b FROM BizTOptcheck b WHERE b.acctype = :acctype"),
    @NamedQuery(name = "BizTOptcheck.findByCountmoney", query = "SELECT b FROM BizTOptcheck b WHERE b.countmoney = :countmoney"),
    @NamedQuery(name = "BizTOptcheck.findByMoneyflag", query = "SELECT b FROM BizTOptcheck b WHERE b.moneyflag = :moneyflag"),
    @NamedQuery(name = "BizTOptcheck.findByCheckmoney", query = "SELECT b FROM BizTOptcheck b WHERE b.checkmoney = :checkmoney"),
    @NamedQuery(name = "BizTOptcheck.findByCheckflag1", query = "SELECT b FROM BizTOptcheck b WHERE b.checkflag1 = :checkflag1"),
    @NamedQuery(name = "BizTOptcheck.findByCheckflag2", query = "SELECT b FROM BizTOptcheck b WHERE b.checkflag2 = :checkflag2"),
    @NamedQuery(name = "BizTOptcheck.findByCheckflag3", query = "SELECT b FROM BizTOptcheck b WHERE b.checkflag3 = :checkflag3"),
    @NamedQuery(name = "BizTOptcheck.findByCheckflag4", query = "SELECT b FROM BizTOptcheck b WHERE b.checkflag4 = :checkflag4"),
    @NamedQuery(name = "BizTOptcheck.findByCheckflag5", query = "SELECT b FROM BizTOptcheck b WHERE b.checkflag5 = :checkflag5"),
    @NamedQuery(name = "BizTOptcheck.findByCheckchildmoney", query = "SELECT b FROM BizTOptcheck b WHERE b.checkchildmoney = :checkchildmoney"),
    @NamedQuery(name = "BizTOptcheck.findByAdjustmoney", query = "SELECT b FROM BizTOptcheck b WHERE b.adjustmoney = :adjustmoney"),
    @NamedQuery(name = "BizTOptcheck.findByIfover", query = "SELECT b FROM BizTOptcheck b WHERE b.ifover = :ifover"),
    @NamedQuery(name = "BizTOptcheck.findByResult", query = "SELECT b FROM BizTOptcheck b WHERE b.result = :result"),
    @NamedQuery(name = "BizTOptcheck.findByResultoper", query = "SELECT b FROM BizTOptcheck b WHERE b.resultoper = :resultoper"),
    @NamedQuery(name = "BizTOptcheck.findByResultdt", query = "SELECT b FROM BizTOptcheck b WHERE b.resultdt = :resultdt"),
    @NamedQuery(name = "BizTOptcheck.findByRebegdt", query = "SELECT b FROM BizTOptcheck b WHERE b.rebegdt = :rebegdt"),
    @NamedQuery(name = "BizTOptcheck.findByReenddt", query = "SELECT b FROM BizTOptcheck b WHERE b.reenddt = :reenddt"),
    @NamedQuery(name = "BizTOptcheck.findByRecheckmoney", query = "SELECT b FROM BizTOptcheck b WHERE b.recheckmoney = :recheckmoney"),
    @NamedQuery(name = "BizTOptcheck.findByPhysql", query = "SELECT b FROM BizTOptcheck b WHERE b.physql = :physql"),
    @NamedQuery(name = "BizTOptcheck.findByLocsql", query = "SELECT b FROM BizTOptcheck b WHERE b.locsql = :locsql"),
    @NamedQuery(name = "BizTOptcheck.findByAccphysql", query = "SELECT b FROM BizTOptcheck b WHERE b.accphysql = :accphysql"),
    @NamedQuery(name = "BizTOptcheck.findByAcclocsql", query = "SELECT b FROM BizTOptcheck b WHERE b.acclocsql = :acclocsql"),
    @NamedQuery(name = "BizTOptcheck.findBySqlmoney", query = "SELECT b FROM BizTOptcheck b WHERE b.sqlmoney = :sqlmoney"),
    @NamedQuery(name = "BizTOptcheck.findByOptoper", query = "SELECT b FROM BizTOptcheck b WHERE b.optoper = :optoper"),
    @NamedQuery(name = "BizTOptcheck.findByOptdt", query = "SELECT b FROM BizTOptcheck b WHERE b.optdt = :optdt")})
public class BizTOptcheck implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "OPTCHECK_ID", nullable = false, precision = 22)
    private BigDecimal optcheckId;
    private Character acctype;
    @Column(precision = 12, scale = 2)
    private BigDecimal countmoney;
    private BigInteger moneyflag;
    @Column(precision = 12, scale = 2)
    private BigDecimal checkmoney;
    private Character checkflag1;
    private Character checkflag2;
    private Character checkflag3;
    private Character checkflag4;
    private Character checkflag5;
    @Column(precision = 12, scale = 2)
    private BigDecimal checkchildmoney;
    @Column(precision = 12, scale = 2)
    private BigDecimal adjustmoney;
    private Character ifover;
    private Character result;
    private BigInteger resultoper;
    @Temporal(TemporalType.TIMESTAMP)
    private Date resultdt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date rebegdt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date reenddt;
    @Column(precision = 12, scale = 2)
    private BigDecimal recheckmoney;
    @Column(length = 2000)
    private String physql;
    @Column(length = 2000)
    private String locsql;
    @Column(length = 2000)
    private String accphysql;
    @Column(length = 2000)
    private String acclocsql;
    @Column(precision = 12, scale = 2)
    private BigDecimal sqlmoney;
    private BigInteger optoper;
    @Temporal(TemporalType.TIMESTAMP)
    private Date optdt;
    @OneToMany(mappedBy = "optcheckId")
    private Set<BizTOptcheckidea> bizTOptcheckideaSet;
    @JoinColumn(name = "POLICY_ID", referencedColumnName = "POLICY_ID")
    @ManyToOne
    private DoperTPolicy policyId;
    @JoinColumn(name = "FAMILY_ID", referencedColumnName = "FAMILY_ID")
    @ManyToOne
    private InfoTFamily familyId;
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "MEMBER_ID")
    @ManyToOne
    private InfoTMember memberId;

    public BizTOptcheck() {
    }

    public BizTOptcheck(BigDecimal optcheckId) {
        this.optcheckId = optcheckId;
    }

    public BigDecimal getOptcheckId() {
        return optcheckId;
    }

    public void setOptcheckId(BigDecimal optcheckId) {
        this.optcheckId = optcheckId;
    }

    public Character getAcctype() {
        return acctype;
    }

    public void setAcctype(Character acctype) {
        this.acctype = acctype;
    }

    public BigDecimal getCountmoney() {
        return countmoney;
    }

    public void setCountmoney(BigDecimal countmoney) {
        this.countmoney = countmoney;
    }

    public BigInteger getMoneyflag() {
        return moneyflag;
    }

    public void setMoneyflag(BigInteger moneyflag) {
        this.moneyflag = moneyflag;
    }

    public BigDecimal getCheckmoney() {
        return checkmoney;
    }

    public void setCheckmoney(BigDecimal checkmoney) {
        this.checkmoney = checkmoney;
    }

    public Character getCheckflag1() {
        return checkflag1;
    }

    public void setCheckflag1(Character checkflag1) {
        this.checkflag1 = checkflag1;
    }

    public Character getCheckflag2() {
        return checkflag2;
    }

    public void setCheckflag2(Character checkflag2) {
        this.checkflag2 = checkflag2;
    }

    public Character getCheckflag3() {
        return checkflag3;
    }

    public void setCheckflag3(Character checkflag3) {
        this.checkflag3 = checkflag3;
    }

    public Character getCheckflag4() {
        return checkflag4;
    }

    public void setCheckflag4(Character checkflag4) {
        this.checkflag4 = checkflag4;
    }

    public Character getCheckflag5() {
        return checkflag5;
    }

    public void setCheckflag5(Character checkflag5) {
        this.checkflag5 = checkflag5;
    }

    public BigDecimal getCheckchildmoney() {
        return checkchildmoney;
    }

    public void setCheckchildmoney(BigDecimal checkchildmoney) {
        this.checkchildmoney = checkchildmoney;
    }

    public BigDecimal getAdjustmoney() {
        return adjustmoney;
    }

    public void setAdjustmoney(BigDecimal adjustmoney) {
        this.adjustmoney = adjustmoney;
    }

    public Character getIfover() {
        return ifover;
    }

    public void setIfover(Character ifover) {
        this.ifover = ifover;
    }

    public Character getResult() {
        return result;
    }

    public void setResult(Character result) {
        this.result = result;
    }

    public BigInteger getResultoper() {
        return resultoper;
    }

    public void setResultoper(BigInteger resultoper) {
        this.resultoper = resultoper;
    }

    public Date getResultdt() {
        return resultdt;
    }

    public void setResultdt(Date resultdt) {
        this.resultdt = resultdt;
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

    public BigDecimal getRecheckmoney() {
        return recheckmoney;
    }

    public void setRecheckmoney(BigDecimal recheckmoney) {
        this.recheckmoney = recheckmoney;
    }

    public String getPhysql() {
        return physql;
    }

    public void setPhysql(String physql) {
        this.physql = physql;
    }

    public String getLocsql() {
        return locsql;
    }

    public void setLocsql(String locsql) {
        this.locsql = locsql;
    }

    public String getAccphysql() {
        return accphysql;
    }

    public void setAccphysql(String accphysql) {
        this.accphysql = accphysql;
    }

    public String getAcclocsql() {
        return acclocsql;
    }

    public void setAcclocsql(String acclocsql) {
        this.acclocsql = acclocsql;
    }

    public BigDecimal getSqlmoney() {
        return sqlmoney;
    }

    public void setSqlmoney(BigDecimal sqlmoney) {
        this.sqlmoney = sqlmoney;
    }

    public BigInteger getOptoper() {
        return optoper;
    }

    public void setOptoper(BigInteger optoper) {
        this.optoper = optoper;
    }

    public Date getOptdt() {
        return optdt;
    }

    public void setOptdt(Date optdt) {
        this.optdt = optdt;
    }

    @XmlTransient
    public Set<BizTOptcheckidea> getBizTOptcheckideaSet() {
        return bizTOptcheckideaSet;
    }

    public void setBizTOptcheckideaSet(Set<BizTOptcheckidea> bizTOptcheckideaSet) {
        this.bizTOptcheckideaSet = bizTOptcheckideaSet;
    }

    public DoperTPolicy getPolicyId() {
        return policyId;
    }

    public void setPolicyId(DoperTPolicy policyId) {
        this.policyId = policyId;
    }

    public InfoTFamily getFamilyId() {
        return familyId;
    }

    public void setFamilyId(InfoTFamily familyId) {
        this.familyId = familyId;
    }

    public InfoTMember getMemberId() {
        return memberId;
    }

    public void setMemberId(InfoTMember memberId) {
        this.memberId = memberId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (optcheckId != null ? optcheckId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BizTOptcheck)) {
            return false;
        }
        BizTOptcheck other = (BizTOptcheck) object;
        if ((this.optcheckId == null && other.optcheckId != null) || (this.optcheckId != null && !this.optcheckId.equals(other.optcheckId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.shengnc.BizTOptcheck[ optcheckId=" + optcheckId + " ]";
    }
    
}
