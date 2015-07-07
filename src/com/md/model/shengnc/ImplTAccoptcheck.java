/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.model.shengnc;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "IMPL_T_ACCOPTCHECK", catalog = "", schema = "SUMMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImplTAccoptcheck.findAll", query = "SELECT i FROM ImplTAccoptcheck i"),
    @NamedQuery(name = "ImplTAccoptcheck.findByAccoptcheckId", query = "SELECT i FROM ImplTAccoptcheck i WHERE i.accoptcheckId = :accoptcheckId"),
    @NamedQuery(name = "ImplTAccoptcheck.findByOptaccId", query = "SELECT i FROM ImplTAccoptcheck i WHERE i.optaccId = :optaccId"),
    @NamedQuery(name = "ImplTAccoptcheck.findByFamilyId", query = "SELECT i FROM ImplTAccoptcheck i WHERE i.familyId = :familyId"),
    @NamedQuery(name = "ImplTAccoptcheck.findByMemberId", query = "SELECT i FROM ImplTAccoptcheck i WHERE i.memberId = :memberId"),
    @NamedQuery(name = "ImplTAccoptcheck.findByCountmoney", query = "SELECT i FROM ImplTAccoptcheck i WHERE i.countmoney = :countmoney"),
    @NamedQuery(name = "ImplTAccoptcheck.findByCheckmoney", query = "SELECT i FROM ImplTAccoptcheck i WHERE i.checkmoney = :checkmoney"),
    @NamedQuery(name = "ImplTAccoptcheck.findByCheckchildmoney", query = "SELECT i FROM ImplTAccoptcheck i WHERE i.checkchildmoney = :checkchildmoney"),
    @NamedQuery(name = "ImplTAccoptcheck.findByPopulaiton", query = "SELECT i FROM ImplTAccoptcheck i WHERE i.populaiton = :populaiton"),
    @NamedQuery(name = "ImplTAccoptcheck.findBySaltype", query = "SELECT i FROM ImplTAccoptcheck i WHERE i.saltype = :saltype")})
public class ImplTAccoptcheck implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ACCOPTCHECK_ID", nullable = false, precision = 22)
    private BigDecimal accoptcheckId;
    @Column(name = "OPTACC_ID")
    private BigInteger optaccId;
    @Column(name = "FAMILY_ID")
    private BigInteger familyId;
    @Column(name = "MEMBER_ID")
    private BigInteger memberId;
    @Column(precision = 8, scale = 2)
    private BigDecimal countmoney;
    @Column(precision = 8, scale = 2)
    private BigDecimal checkmoney;
    @Column(precision = 8, scale = 2)
    private BigDecimal checkchildmoney;
    private Short populaiton;
    @Column(length = 4)
    private String saltype;
    @JoinColumn(name = "POLICY_ID", referencedColumnName = "POLICY_ID")
    @ManyToOne
    private DoperTPolicy policyId;

    public ImplTAccoptcheck() {
    }

    public ImplTAccoptcheck(BigDecimal accoptcheckId) {
        this.accoptcheckId = accoptcheckId;
    }

    public BigDecimal getAccoptcheckId() {
        return accoptcheckId;
    }

    public void setAccoptcheckId(BigDecimal accoptcheckId) {
        this.accoptcheckId = accoptcheckId;
    }

    public BigInteger getOptaccId() {
        return optaccId;
    }

    public void setOptaccId(BigInteger optaccId) {
        this.optaccId = optaccId;
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

    public BigDecimal getCountmoney() {
        return countmoney;
    }

    public void setCountmoney(BigDecimal countmoney) {
        this.countmoney = countmoney;
    }

    public BigDecimal getCheckmoney() {
        return checkmoney;
    }

    public void setCheckmoney(BigDecimal checkmoney) {
        this.checkmoney = checkmoney;
    }

    public BigDecimal getCheckchildmoney() {
        return checkchildmoney;
    }

    public void setCheckchildmoney(BigDecimal checkchildmoney) {
        this.checkchildmoney = checkchildmoney;
    }

    public Short getPopulaiton() {
        return populaiton;
    }

    public void setPopulaiton(Short populaiton) {
        this.populaiton = populaiton;
    }

    public String getSaltype() {
        return saltype;
    }

    public void setSaltype(String saltype) {
        this.saltype = saltype;
    }

    public DoperTPolicy getPolicyId() {
        return policyId;
    }

    public void setPolicyId(DoperTPolicy policyId) {
        this.policyId = policyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accoptcheckId != null ? accoptcheckId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImplTAccoptcheck)) {
            return false;
        }
        ImplTAccoptcheck other = (ImplTAccoptcheck) object;
        if ((this.accoptcheckId == null && other.accoptcheckId != null) || (this.accoptcheckId != null && !this.accoptcheckId.equals(other.accoptcheckId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.shengnc.ImplTAccoptcheck[ accoptcheckId=" + accoptcheckId + " ]";
    }
    
}
