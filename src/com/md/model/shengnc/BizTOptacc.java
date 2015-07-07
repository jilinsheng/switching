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
@Table(name = "BIZ_T_OPTACC", catalog = "", schema = "SUMMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BizTOptacc.findAll", query = "SELECT b FROM BizTOptacc b"),
    @NamedQuery(name = "BizTOptacc.findByOptaccId", query = "SELECT b FROM BizTOptacc b WHERE b.optaccId = :optaccId"),
    @NamedQuery(name = "BizTOptacc.findByAccyear", query = "SELECT b FROM BizTOptacc b WHERE b.accyear = :accyear"),
    @NamedQuery(name = "BizTOptacc.findByAccmonth", query = "SELECT b FROM BizTOptacc b WHERE b.accmonth = :accmonth"),
    @NamedQuery(name = "BizTOptacc.findByAccdesc", query = "SELECT b FROM BizTOptacc b WHERE b.accdesc = :accdesc"),
    @NamedQuery(name = "BizTOptacc.findByAccbegdt", query = "SELECT b FROM BizTOptacc b WHERE b.accbegdt = :accbegdt"),
    @NamedQuery(name = "BizTOptacc.findByAccenddt", query = "SELECT b FROM BizTOptacc b WHERE b.accenddt = :accenddt"),
    @NamedQuery(name = "BizTOptacc.findByAccexedt", query = "SELECT b FROM BizTOptacc b WHERE b.accexedt = :accexedt"),
    @NamedQuery(name = "BizTOptacc.findByAccexeoper", query = "SELECT b FROM BizTOptacc b WHERE b.accexeoper = :accexeoper"),
    @NamedQuery(name = "BizTOptacc.findByAccexeoverdt", query = "SELECT b FROM BizTOptacc b WHERE b.accexeoverdt = :accexeoverdt"),
    @NamedQuery(name = "BizTOptacc.findByAccflag", query = "SELECT b FROM BizTOptacc b WHERE b.accflag = :accflag"),
    @NamedQuery(name = "BizTOptacc.findByAccmoneyflag", query = "SELECT b FROM BizTOptacc b WHERE b.accmoneyflag = :accmoneyflag"),
    @NamedQuery(name = "BizTOptacc.findByAccmoney", query = "SELECT b FROM BizTOptacc b WHERE b.accmoney = :accmoney"),
    @NamedQuery(name = "BizTOptacc.findByAccoper", query = "SELECT b FROM BizTOptacc b WHERE b.accoper = :accoper"),
    @NamedQuery(name = "BizTOptacc.findByAccdt", query = "SELECT b FROM BizTOptacc b WHERE b.accdt = :accdt")})
public class BizTOptacc implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "OPTACC_ID", nullable = false, precision = 22, scale = 0)
    private BigDecimal optaccId;
    @Column(length = 4)
    private String accyear;
    @Column(length = 2)
    private String accmonth;
    @Column(length = 500)
    private String accdesc;
    @Temporal(TemporalType.TIMESTAMP)
    private Date accbegdt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date accenddt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date accexedt;
    private BigInteger accexeoper;
    @Temporal(TemporalType.TIMESTAMP)
    private Date accexeoverdt;
    @Column(length = 1)
    private String accflag;
    @Column(length = 1)
    private String accmoneyflag;
    @Column(precision = 8, scale = 2)
    private BigDecimal accmoney;
    private BigInteger accoper;
    @Temporal(TemporalType.TIMESTAMP)
    private Date accdt;
    @OneToMany(mappedBy = "optaccId")
    private Set<BizTOptcheck2> bizTOptcheck2Set;
    @JoinColumn(name = "POLICY_ID", referencedColumnName = "POLICY_ID")
    @ManyToOne
    private DoperTPolicy policyId;
    @JoinColumn(name = "ORGANIZATION_ID", referencedColumnName = "ORGANIZATION_ID")
    @ManyToOne
    private SysTOrganization organizationId;

    public BizTOptacc() {
    }

    public BizTOptacc(BigDecimal optaccId) {
        this.optaccId = optaccId;
    }

    public BigDecimal getOptaccId() {
        return optaccId;
    }

    public void setOptaccId(BigDecimal optaccId) {
        this.optaccId = optaccId;
    }

    public String getAccyear() {
        return accyear;
    }

    public void setAccyear(String accyear) {
        this.accyear = accyear;
    }

    public String getAccmonth() {
        return accmonth;
    }

    public void setAccmonth(String accmonth) {
        this.accmonth = accmonth;
    }

    public String getAccdesc() {
        return accdesc;
    }

    public void setAccdesc(String accdesc) {
        this.accdesc = accdesc;
    }

    public Date getAccbegdt() {
        return accbegdt;
    }

    public void setAccbegdt(Date accbegdt) {
        this.accbegdt = accbegdt;
    }

    public Date getAccenddt() {
        return accenddt;
    }

    public void setAccenddt(Date accenddt) {
        this.accenddt = accenddt;
    }

    public Date getAccexedt() {
        return accexedt;
    }

    public void setAccexedt(Date accexedt) {
        this.accexedt = accexedt;
    }

    public BigInteger getAccexeoper() {
        return accexeoper;
    }

    public void setAccexeoper(BigInteger accexeoper) {
        this.accexeoper = accexeoper;
    }

    public Date getAccexeoverdt() {
        return accexeoverdt;
    }

    public void setAccexeoverdt(Date accexeoverdt) {
        this.accexeoverdt = accexeoverdt;
    }

    public String getAccflag() {
        return accflag;
    }

    public void setAccflag(String accflag) {
        this.accflag = accflag;
    }

    public String getAccmoneyflag() {
        return accmoneyflag;
    }

    public void setAccmoneyflag(String accmoneyflag) {
        this.accmoneyflag = accmoneyflag;
    }

    public BigDecimal getAccmoney() {
        return accmoney;
    }

    public void setAccmoney(BigDecimal accmoney) {
        this.accmoney = accmoney;
    }

    public BigInteger getAccoper() {
        return accoper;
    }

    public void setAccoper(BigInteger accoper) {
        this.accoper = accoper;
    }

    public Date getAccdt() {
        return accdt;
    }

    public void setAccdt(Date accdt) {
        this.accdt = accdt;
    }

    @XmlTransient
    public Set<BizTOptcheck2> getBizTOptcheck2Set() {
        return bizTOptcheck2Set;
    }

    public void setBizTOptcheck2Set(Set<BizTOptcheck2> bizTOptcheck2Set) {
        this.bizTOptcheck2Set = bizTOptcheck2Set;
    }

    public DoperTPolicy getPolicyId() {
        return policyId;
    }

    public void setPolicyId(DoperTPolicy policyId) {
        this.policyId = policyId;
    }

    public SysTOrganization getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(SysTOrganization organizationId) {
        this.organizationId = organizationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (optaccId != null ? optaccId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BizTOptacc)) {
            return false;
        }
        BizTOptacc other = (BizTOptacc) object;
        if ((this.optaccId == null && other.optaccId != null) || (this.optaccId != null && !this.optaccId.equals(other.optaccId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.shengnc.BizTOptacc[ optaccId=" + optaccId + " ]";
    }
    
}
