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
    @NamedQuery(name = "Familyinfo.findAll", query = "SELECT f FROM Familyinfo f"),
    @NamedQuery(name = "Familyinfo.findByFamilyid", query = "SELECT f FROM Familyinfo f WHERE f.familyid = :familyid"),
    @NamedQuery(name = "Familyinfo.findByFamilyno", query = "SELECT f FROM Familyinfo f WHERE f.familyno = :familyno"),
    @NamedQuery(name = "Familyinfo.findByMasterid", query = "SELECT f FROM Familyinfo f WHERE f.masterid = :masterid"),
    @NamedQuery(name = "Familyinfo.findByMastername", query = "SELECT f FROM Familyinfo f WHERE f.mastername = :mastername"),
    @NamedQuery(name = "Familyinfo.findByPaperid", query = "SELECT f FROM Familyinfo f WHERE f.paperid = :paperid"),
    @NamedQuery(name = "Familyinfo.findByPercount", query = "SELECT f FROM Familyinfo f WHERE f.percount = :percount"),
    @NamedQuery(name = "Familyinfo.findBySalcount", query = "SELECT f FROM Familyinfo f WHERE f.salcount = :salcount"),
    @NamedQuery(name = "Familyinfo.findByOperstate", query = "SELECT f FROM Familyinfo f WHERE f.operstate = :operstate"),
    @NamedQuery(name = "Familyinfo.findByOnNo", query = "SELECT f FROM Familyinfo f WHERE f.onNo = :onNo"),
    @NamedQuery(name = "Familyinfo.findByFamsort", query = "SELECT f FROM Familyinfo f WHERE f.famsort = :famsort"),
    @NamedQuery(name = "Familyinfo.findByAccounts", query = "SELECT f FROM Familyinfo f WHERE f.accounts = :accounts"),
    @NamedQuery(name = "Familyinfo.findByOnallname", query = "SELECT f FROM Familyinfo f WHERE f.onallname = :onallname"),
    @NamedQuery(name = "Familyinfo.findByFde", query = "SELECT f FROM Familyinfo f WHERE f.fde = :fde"),
    @NamedQuery(name = "Familyinfo.findByFdefamilyno", query = "SELECT f FROM Familyinfo f WHERE f.fdefamilyno = :fdefamilyno"),
    @NamedQuery(name = "Familyinfo.findByFdename", query = "SELECT f FROM Familyinfo f WHERE f.fdename = :fdename"),
    @NamedQuery(name = "Familyinfo.findByFincome", query = "SELECT f FROM Familyinfo f WHERE f.fincome = :fincome"),
    @NamedQuery(name = "Familyinfo.findByAddress", query = "SELECT f FROM Familyinfo f WHERE f.address = :address"),
    @NamedQuery(name = "Familyinfo.findByResadd", query = "SELECT f FROM Familyinfo f WHERE f.resadd = :resadd"),
    @NamedQuery(name = "Familyinfo.findByFmBirthday", query = "SELECT f FROM Familyinfo f WHERE f.fmBirthday = :fmBirthday")})
public class Familyinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String familyid;
    @Column(length = 50)
    private String familyno;
    @Column(length = 50)
    private String masterid;
    @Column(length = 50)
    private String mastername;
    @Column(length = 20)
    private String paperid;
    private BigInteger percount;
    private BigInteger salcount;
    @Column(length = 200)
    private String operstate;
    @Column(name = "ON_NO", length = 50)
    private String onNo;
    @Column(length = 50)
    private String famsort;
    @Column(length = 50)
    private String accounts;
    @Column(length = 200)
    private String onallname;
    @Column(length = 50)
    private String fde;
    @Column(length = 50)
    private String fdefamilyno;
    @Column(length = 50)
    private String fdename;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 8, scale = 2)
    private BigDecimal fincome;
    @Column(length = 200)
    private String address;
    @Column(length = 200)
    private String resadd;
    @Column(name = "FM_BIRTHDAY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fmBirthday;

    public Familyinfo() {
    }

    public String getFamilyid() {
        return familyid;
    }

    public void setFamilyid(String familyid) {
        this.familyid = familyid;
    }

    public String getFamilyno() {
        return familyno;
    }

    public void setFamilyno(String familyno) {
        this.familyno = familyno;
    }

    public String getMasterid() {
        return masterid;
    }

    public void setMasterid(String masterid) {
        this.masterid = masterid;
    }

    public String getMastername() {
        return mastername;
    }

    public void setMastername(String mastername) {
        this.mastername = mastername;
    }

    public String getPaperid() {
        return paperid;
    }

    public void setPaperid(String paperid) {
        this.paperid = paperid;
    }

    public BigInteger getPercount() {
        return percount;
    }

    public void setPercount(BigInteger percount) {
        this.percount = percount;
    }

    public BigInteger getSalcount() {
        return salcount;
    }

    public void setSalcount(BigInteger salcount) {
        this.salcount = salcount;
    }

    public String getOperstate() {
        return operstate;
    }

    public void setOperstate(String operstate) {
        this.operstate = operstate;
    }

    public String getOnNo() {
        return onNo;
    }

    public void setOnNo(String onNo) {
        this.onNo = onNo;
    }

    public String getFamsort() {
        return famsort;
    }

    public void setFamsort(String famsort) {
        this.famsort = famsort;
    }

    public String getAccounts() {
        return accounts;
    }

    public void setAccounts(String accounts) {
        this.accounts = accounts;
    }

    public String getOnallname() {
        return onallname;
    }

    public void setOnallname(String onallname) {
        this.onallname = onallname;
    }

    public String getFde() {
        return fde;
    }

    public void setFde(String fde) {
        this.fde = fde;
    }

    public String getFdefamilyno() {
        return fdefamilyno;
    }

    public void setFdefamilyno(String fdefamilyno) {
        this.fdefamilyno = fdefamilyno;
    }

    public String getFdename() {
        return fdename;
    }

    public void setFdename(String fdename) {
        this.fdename = fdename;
    }

    public BigDecimal getFincome() {
        return fincome;
    }

    public void setFincome(BigDecimal fincome) {
        this.fincome = fincome;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getResadd() {
        return resadd;
    }

    public void setResadd(String resadd) {
        this.resadd = resadd;
    }

    public Date getFmBirthday() {
        return fmBirthday;
    }

    public void setFmBirthday(Date fmBirthday) {
        this.fmBirthday = fmBirthday;
    }

    public Familyinfo get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
