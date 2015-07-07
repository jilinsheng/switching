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
@Table(name = "BIZ_T_OPTCHECK2", catalog = "", schema = "SUMMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BizTOptcheck2.findAll", query = "SELECT b FROM BizTOptcheck2 b"),
    @NamedQuery(name = "BizTOptcheck2.findByOptcheck2Id", query = "SELECT b FROM BizTOptcheck2 b WHERE b.optcheck2Id = :optcheck2Id"),
    @NamedQuery(name = "BizTOptcheck2.findByOptcheckId", query = "SELECT b FROM BizTOptcheck2 b WHERE b.optcheckId = :optcheckId"),
    @NamedQuery(name = "BizTOptcheck2.findByPolicyId", query = "SELECT b FROM BizTOptcheck2 b WHERE b.policyId = :policyId"),
    @NamedQuery(name = "BizTOptcheck2.findByFamilyId", query = "SELECT b FROM BizTOptcheck2 b WHERE b.familyId = :familyId"),
    @NamedQuery(name = "BizTOptcheck2.findByMemberId", query = "SELECT b FROM BizTOptcheck2 b WHERE b.memberId = :memberId"),
    @NamedQuery(name = "BizTOptcheck2.findByAcctype", query = "SELECT b FROM BizTOptcheck2 b WHERE b.acctype = :acctype"),
    @NamedQuery(name = "BizTOptcheck2.findByCountmoney", query = "SELECT b FROM BizTOptcheck2 b WHERE b.countmoney = :countmoney"),
    @NamedQuery(name = "BizTOptcheck2.findByMoneyflag", query = "SELECT b FROM BizTOptcheck2 b WHERE b.moneyflag = :moneyflag"),
    @NamedQuery(name = "BizTOptcheck2.findByCheckmoney", query = "SELECT b FROM BizTOptcheck2 b WHERE b.checkmoney = :checkmoney"),
    @NamedQuery(name = "BizTOptcheck2.findByCheckflag1", query = "SELECT b FROM BizTOptcheck2 b WHERE b.checkflag1 = :checkflag1"),
    @NamedQuery(name = "BizTOptcheck2.findByCheckflag2", query = "SELECT b FROM BizTOptcheck2 b WHERE b.checkflag2 = :checkflag2"),
    @NamedQuery(name = "BizTOptcheck2.findByCheckflag3", query = "SELECT b FROM BizTOptcheck2 b WHERE b.checkflag3 = :checkflag3"),
    @NamedQuery(name = "BizTOptcheck2.findByCheckflag4", query = "SELECT b FROM BizTOptcheck2 b WHERE b.checkflag4 = :checkflag4"),
    @NamedQuery(name = "BizTOptcheck2.findByCheckflag5", query = "SELECT b FROM BizTOptcheck2 b WHERE b.checkflag5 = :checkflag5"),
    @NamedQuery(name = "BizTOptcheck2.findByCheckchildmoney", query = "SELECT b FROM BizTOptcheck2 b WHERE b.checkchildmoney = :checkchildmoney"),
    @NamedQuery(name = "BizTOptcheck2.findByAdjustmoney", query = "SELECT b FROM BizTOptcheck2 b WHERE b.adjustmoney = :adjustmoney"),
    @NamedQuery(name = "BizTOptcheck2.findByIfover", query = "SELECT b FROM BizTOptcheck2 b WHERE b.ifover = :ifover"),
    @NamedQuery(name = "BizTOptcheck2.findByResult", query = "SELECT b FROM BizTOptcheck2 b WHERE b.result = :result"),
    @NamedQuery(name = "BizTOptcheck2.findByResultoper", query = "SELECT b FROM BizTOptcheck2 b WHERE b.resultoper = :resultoper"),
    @NamedQuery(name = "BizTOptcheck2.findByResultdt", query = "SELECT b FROM BizTOptcheck2 b WHERE b.resultdt = :resultdt"),
    @NamedQuery(name = "BizTOptcheck2.findByRebegdt", query = "SELECT b FROM BizTOptcheck2 b WHERE b.rebegdt = :rebegdt"),
    @NamedQuery(name = "BizTOptcheck2.findByReenddt", query = "SELECT b FROM BizTOptcheck2 b WHERE b.reenddt = :reenddt"),
    @NamedQuery(name = "BizTOptcheck2.findByRecheckmoney", query = "SELECT b FROM BizTOptcheck2 b WHERE b.recheckmoney = :recheckmoney"),
    @NamedQuery(name = "BizTOptcheck2.findByPhysql", query = "SELECT b FROM BizTOptcheck2 b WHERE b.physql = :physql"),
    @NamedQuery(name = "BizTOptcheck2.findByLocsql", query = "SELECT b FROM BizTOptcheck2 b WHERE b.locsql = :locsql"),
    @NamedQuery(name = "BizTOptcheck2.findByAccphysql", query = "SELECT b FROM BizTOptcheck2 b WHERE b.accphysql = :accphysql"),
    @NamedQuery(name = "BizTOptcheck2.findByAcclocsql", query = "SELECT b FROM BizTOptcheck2 b WHERE b.acclocsql = :acclocsql"),
    @NamedQuery(name = "BizTOptcheck2.findBySqlmoney", query = "SELECT b FROM BizTOptcheck2 b WHERE b.sqlmoney = :sqlmoney"),
    @NamedQuery(name = "BizTOptcheck2.findByOptoper", query = "SELECT b FROM BizTOptcheck2 b WHERE b.optoper = :optoper"),
    @NamedQuery(name = "BizTOptcheck2.findByOptdt", query = "SELECT b FROM BizTOptcheck2 b WHERE b.optdt = :optdt")})
public class BizTOptcheck2 implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "OPTCHECK2_ID", nullable = false, precision = 22)
    private BigDecimal optcheck2Id;
    @Column(name = "OPTCHECK_ID")
    private BigInteger optcheckId;
    @Column(name = "POLICY_ID")
    private BigInteger policyId;
    @Column(name = "FAMILY_ID")
    private BigInteger familyId;
    @Column(name = "MEMBER_ID")
    private BigInteger memberId;
    private Character acctype;
    @Column(precision = 8, scale = 2)
    private BigDecimal countmoney;
    private BigInteger moneyflag;
    @Column(precision = 8, scale = 2)
    private BigDecimal checkmoney;
    private Character checkflag1;
    private Character checkflag2;
    private Character checkflag3;
    private Character checkflag4;
    private Character checkflag5;
    @Column(precision = 8, scale = 2)
    private BigDecimal checkchildmoney;
    @Column(precision = 8, scale = 2)
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
    @Column(precision = 8, scale = 2)
    private BigDecimal recheckmoney;
    @Column(length = 2000)
    private String physql;
    @Column(length = 2000)
    private String locsql;
    @Column(length = 2000)
    private String accphysql;
    @Column(length = 2000)
    private String acclocsql;
    @Column(precision = 8, scale = 2)
    private BigDecimal sqlmoney;
    private BigInteger optoper;
    @Temporal(TemporalType.TIMESTAMP)
    private Date optdt;
    @JoinColumn(name = "OPTACC_ID", referencedColumnName = "OPTACC_ID")
    @ManyToOne
    private BizTOptacc optaccId;

    public BizTOptcheck2() {
    }

    public BizTOptcheck2(BigDecimal optcheck2Id) {
        this.optcheck2Id = optcheck2Id;
    }

    public BigDecimal getOptcheck2Id() {
        return optcheck2Id;
    }

    public void setOptcheck2Id(BigDecimal optcheck2Id) {
        this.optcheck2Id = optcheck2Id;
    }

    public BigInteger getOptcheckId() {
        return optcheckId;
    }

    public void setOptcheckId(BigInteger optcheckId) {
        this.optcheckId = optcheckId;
    }

    public BigInteger getPolicyId() {
        return policyId;
    }

    public void setPolicyId(BigInteger policyId) {
        this.policyId = policyId;
    }

    public BigInteger getFamilyId() {
        return familyId;
    }

    public void setFamilyId(BigInteger familyId) {
        this.familyId = familyId;
    }

    public BigInteger getMemberId() {
        return memberId;
    }

    public void setMemberId(BigInteger memberId) {
        this.memberId = memberId;
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

    public BizTOptacc getOptaccId() {
        return optaccId;
    }

    public void setOptaccId(BizTOptacc optaccId) {
        this.optaccId = optaccId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (optcheck2Id != null ? optcheck2Id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BizTOptcheck2)) {
            return false;
        }
        BizTOptcheck2 other = (BizTOptcheck2) object;
        if ((this.optcheck2Id == null && other.optcheck2Id != null) || (this.optcheck2Id != null && !this.optcheck2Id.equals(other.optcheck2Id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.shengnc.BizTOptcheck2[ optcheck2Id=" + optcheck2Id + " ]";
    }
    
}
