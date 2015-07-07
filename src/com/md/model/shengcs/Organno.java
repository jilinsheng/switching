/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.model.shengcs;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    @NamedQuery(name = "Organno.findAll", query = "SELECT o FROM Organno o"),
    @NamedQuery(name = "Organno.findByOnNo", query = "SELECT o FROM Organno o WHERE o.onNo = :onNo"),
    @NamedQuery(name = "Organno.findByOnId", query = "SELECT o FROM Organno o WHERE o.onId = :onId"),
    @NamedQuery(name = "Organno.findByOnName", query = "SELECT o FROM Organno o WHERE o.onName = :onName"),
    @NamedQuery(name = "Organno.findByOnLevel", query = "SELECT o FROM Organno o WHERE o.onLevel = :onLevel"),
    @NamedQuery(name = "Organno.findByOnFatherid", query = "SELECT o FROM Organno o WHERE o.onFatherid = :onFatherid"),
    @NamedQuery(name = "Organno.findByOnAllname", query = "SELECT o FROM Organno o WHERE o.onAllname = :onAllname"),
    @NamedQuery(name = "Organno.findByOnPopulation", query = "SELECT o FROM Organno o WHERE o.onPopulation = :onPopulation"),
    @NamedQuery(name = "Organno.findBySequence", query = "SELECT o FROM Organno o WHERE o.sequence = :sequence"),
    @NamedQuery(name = "Organno.findByOnGl", query = "SELECT o FROM Organno o WHERE o.onGl = :onGl")})
public class Organno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ON_NO", nullable = false, length = 50)
    private String onNo;
    @Column(name = "ON_ID", length = 50)
    private String onId;
    @Column(name = "ON_NAME", length = 50)
    private String onName;
    @Column(name = "ON_LEVEL")
    private BigInteger onLevel;
    @Column(name = "ON_FATHERID", length = 50)
    private String onFatherid;
    @Column(name = "ON_ALLNAME", length = 200)
    private String onAllname;
    @Column(name = "ON_POPULATION")
    private Integer onPopulation;
    @Column(length = 50)
    private String sequence;
    @Column(name = "ON_GL", length = 50)
    private String onGl;
    @OneToMany(mappedBy = "onNo", fetch = FetchType.LAZY)
    private List<Salvationtype> salvationtypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "onNo", fetch = FetchType.LAZY)
    private List<Salvationstatus> salvationstatusList;
    @OneToMany(mappedBy = "onNo", fetch = FetchType.LAZY)
    private List<Family> familyList;

    public Organno() {
    }

    public Organno(String onNo) {
        this.onNo = onNo;
    }

    public String getOnNo() {
        return onNo;
    }

    public void setOnNo(String onNo) {
        this.onNo = onNo;
    }

    public String getOnId() {
        return onId;
    }

    public void setOnId(String onId) {
        this.onId = onId;
    }

    public String getOnName() {
        return onName;
    }

    public void setOnName(String onName) {
        this.onName = onName;
    }

    public BigInteger getOnLevel() {
        return onLevel;
    }

    public void setOnLevel(BigInteger onLevel) {
        this.onLevel = onLevel;
    }

    public String getOnFatherid() {
        return onFatherid;
    }

    public void setOnFatherid(String onFatherid) {
        this.onFatherid = onFatherid;
    }

    public String getOnAllname() {
        return onAllname;
    }

    public void setOnAllname(String onAllname) {
        this.onAllname = onAllname;
    }

    public Integer getOnPopulation() {
        return onPopulation;
    }

    public void setOnPopulation(Integer onPopulation) {
        this.onPopulation = onPopulation;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getOnGl() {
        return onGl;
    }

    public void setOnGl(String onGl) {
        this.onGl = onGl;
    }

    @XmlTransient
    public List<Salvationtype> getSalvationtypeList() {
        return salvationtypeList;
    }

    public void setSalvationtypeList(List<Salvationtype> salvationtypeList) {
        this.salvationtypeList = salvationtypeList;
    }

    @XmlTransient
    public List<Salvationstatus> getSalvationstatusList() {
        return salvationstatusList;
    }

    public void setSalvationstatusList(List<Salvationstatus> salvationstatusList) {
        this.salvationstatusList = salvationstatusList;
    }

    @XmlTransient
    public List<Family> getFamilyList() {
        return familyList;
    }

    public void setFamilyList(List<Family> familyList) {
        this.familyList = familyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (onNo != null ? onNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organno)) {
            return false;
        }
        Organno other = (Organno) object;
        if ((this.onNo == null && other.onNo != null) || (this.onNo != null && !this.onNo.equals(other.onNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.shengcs.Organno[ onNo=" + onNo + " ]";
    }
    
}
