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
@Table(name = "DOPER_T_POLICY", catalog = "", schema = "SUMMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DoperTPolicy.findAll", query = "SELECT d FROM DoperTPolicy d"),
    @NamedQuery(name = "DoperTPolicy.findByPolicyId", query = "SELECT d FROM DoperTPolicy d WHERE d.policyId = :policyId"),
    @NamedQuery(name = "DoperTPolicy.findByObjtype", query = "SELECT d FROM DoperTPolicy d WHERE d.objtype = :objtype"),
    @NamedQuery(name = "DoperTPolicy.findByName", query = "SELECT d FROM DoperTPolicy d WHERE d.name = :name"),
    @NamedQuery(name = "DoperTPolicy.findByDescr", query = "SELECT d FROM DoperTPolicy d WHERE d.descr = :descr"),
    @NamedQuery(name = "DoperTPolicy.findByType", query = "SELECT d FROM DoperTPolicy d WHERE d.type = :type"),
    @NamedQuery(name = "DoperTPolicy.findByAcctu", query = "SELECT d FROM DoperTPolicy d WHERE d.acctu = :acctu"),
    @NamedQuery(name = "DoperTPolicy.findByCycle", query = "SELECT d FROM DoperTPolicy d WHERE d.cycle = :cycle"),
    @NamedQuery(name = "DoperTPolicy.findByCycnum", query = "SELECT d FROM DoperTPolicy d WHERE d.cycnum = :cycnum"),
    @NamedQuery(name = "DoperTPolicy.findByIsprint", query = "SELECT d FROM DoperTPolicy d WHERE d.isprint = :isprint"),
    @NamedQuery(name = "DoperTPolicy.findByBegdt", query = "SELECT d FROM DoperTPolicy d WHERE d.begdt = :begdt"),
    @NamedQuery(name = "DoperTPolicy.findByNote", query = "SELECT d FROM DoperTPolicy d WHERE d.note = :note"),
    @NamedQuery(name = "DoperTPolicy.findByFlag", query = "SELECT d FROM DoperTPolicy d WHERE d.flag = :flag"),
    @NamedQuery(name = "DoperTPolicy.findByMenutype", query = "SELECT d FROM DoperTPolicy d WHERE d.menutype = :menutype"),
    @NamedQuery(name = "DoperTPolicy.findByAcctype", query = "SELECT d FROM DoperTPolicy d WHERE d.acctype = :acctype"),
    @NamedQuery(name = "DoperTPolicy.findBySequence", query = "SELECT d FROM DoperTPolicy d WHERE d.sequence = :sequence")})
public class DoperTPolicy implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "POLICY_ID", nullable = false, precision = 22)
    private BigDecimal policyId;
    private BigInteger objtype;
    @Column(length = 255)
    private String name;
    @Column(length = 4000)
    private String descr;
    private BigInteger type;
    private BigInteger acctu;
    private BigInteger cycle;
    private BigInteger cycnum;
    private Short isprint;
    @Temporal(TemporalType.TIMESTAMP)
    private Date begdt;
    @Column(length = 4000)
    private String note;
    private Short flag;
    private Short menutype;
    private Short acctype;
    private BigInteger sequence;
    @OneToMany(mappedBy = "policyId")
    private Set<ImplTAccoptcheck> implTAccoptcheckSet;
    @OneToMany(mappedBy = "policyId")
    private Set<BizTOptacc> bizTOptaccSet;
    @OneToMany(mappedBy = "policyId")
    private Set<BizTOptcheck> bizTOptcheckSet;

    public DoperTPolicy() {
    }

    public DoperTPolicy(BigDecimal policyId) {
        this.policyId = policyId;
    }

    public BigDecimal getPolicyId() {
        return policyId;
    }

    public void setPolicyId(BigDecimal policyId) {
        this.policyId = policyId;
    }

    public BigInteger getObjtype() {
        return objtype;
    }

    public void setObjtype(BigInteger objtype) {
        this.objtype = objtype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public BigInteger getType() {
        return type;
    }

    public void setType(BigInteger type) {
        this.type = type;
    }

    public BigInteger getAcctu() {
        return acctu;
    }

    public void setAcctu(BigInteger acctu) {
        this.acctu = acctu;
    }

    public BigInteger getCycle() {
        return cycle;
    }

    public void setCycle(BigInteger cycle) {
        this.cycle = cycle;
    }

    public BigInteger getCycnum() {
        return cycnum;
    }

    public void setCycnum(BigInteger cycnum) {
        this.cycnum = cycnum;
    }

    public Short getIsprint() {
        return isprint;
    }

    public void setIsprint(Short isprint) {
        this.isprint = isprint;
    }

    public Date getBegdt() {
        return begdt;
    }

    public void setBegdt(Date begdt) {
        this.begdt = begdt;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Short getFlag() {
        return flag;
    }

    public void setFlag(Short flag) {
        this.flag = flag;
    }

    public Short getMenutype() {
        return menutype;
    }

    public void setMenutype(Short menutype) {
        this.menutype = menutype;
    }

    public Short getAcctype() {
        return acctype;
    }

    public void setAcctype(Short acctype) {
        this.acctype = acctype;
    }

    public BigInteger getSequence() {
        return sequence;
    }

    public void setSequence(BigInteger sequence) {
        this.sequence = sequence;
    }

    @XmlTransient
    public Set<ImplTAccoptcheck> getImplTAccoptcheckSet() {
        return implTAccoptcheckSet;
    }

    public void setImplTAccoptcheckSet(Set<ImplTAccoptcheck> implTAccoptcheckSet) {
        this.implTAccoptcheckSet = implTAccoptcheckSet;
    }

    @XmlTransient
    public Set<BizTOptacc> getBizTOptaccSet() {
        return bizTOptaccSet;
    }

    public void setBizTOptaccSet(Set<BizTOptacc> bizTOptaccSet) {
        this.bizTOptaccSet = bizTOptaccSet;
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
        hash += (policyId != null ? policyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DoperTPolicy)) {
            return false;
        }
        DoperTPolicy other = (DoperTPolicy) object;
        if ((this.policyId == null && other.policyId != null) || (this.policyId != null && !this.policyId.equals(other.policyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.shengnc.DoperTPolicy[ policyId=" + policyId + " ]";
    }
    
}
