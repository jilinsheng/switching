/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.model;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "V_MEMBERBASEINFO", catalog = "", schema = "SWITCHING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VMemberbaseinfo.findAll", query = "SELECT v FROM VMemberbaseinfo v"),
    @NamedQuery(name = "VMemberbaseinfo.findByMemberId", query = "SELECT v FROM VMemberbaseinfo v WHERE v.memberId = :memberId"),
    @NamedQuery(name = "VMemberbaseinfo.findByMembername", query = "SELECT v FROM VMemberbaseinfo v WHERE v.membername = :membername"),
    @NamedQuery(name = "VMemberbaseinfo.findByPaperid", query = "SELECT v FROM VMemberbaseinfo v WHERE v.paperid = :paperid"),
    @NamedQuery(name = "VMemberbaseinfo.findBySsn", query = "SELECT v FROM VMemberbaseinfo v WHERE v.ssn = :ssn"),
    @NamedQuery(name = "VMemberbaseinfo.findByFamilyid", query = "SELECT v FROM VMemberbaseinfo v WHERE v.familyid = :familyid"),
    @NamedQuery(name = "VMemberbaseinfo.findByFamilyno", query = "SELECT v FROM VMemberbaseinfo v WHERE v.familyno = :familyno"),
    @NamedQuery(name = "VMemberbaseinfo.findByRelmaster", query = "SELECT v FROM VMemberbaseinfo v WHERE v.relmaster = :relmaster"),
    @NamedQuery(name = "VMemberbaseinfo.findBySex", query = "SELECT v FROM VMemberbaseinfo v WHERE v.sex = :sex"),
    @NamedQuery(name = "VMemberbaseinfo.findByMastername", query = "SELECT v FROM VMemberbaseinfo v WHERE v.mastername = :mastername"),
    @NamedQuery(name = "VMemberbaseinfo.findByBirthday", query = "SELECT v FROM VMemberbaseinfo v WHERE v.birthday = :birthday"),
    @NamedQuery(name = "VMemberbaseinfo.findByHealth", query = "SELECT v FROM VMemberbaseinfo v WHERE v.health = :health"),
    @NamedQuery(name = "VMemberbaseinfo.findBySickentype", query = "SELECT v FROM VMemberbaseinfo v WHERE v.sickentype = :sickentype"),
    @NamedQuery(name = "VMemberbaseinfo.findBySickenname", query = "SELECT v FROM VMemberbaseinfo v WHERE v.sickenname = :sickenname"),
    @NamedQuery(name = "VMemberbaseinfo.findByDeformity", query = "SELECT v FROM VMemberbaseinfo v WHERE v.deformity = :deformity"),
    @NamedQuery(name = "VMemberbaseinfo.findByDefgrade", query = "SELECT v FROM VMemberbaseinfo v WHERE v.defgrade = :defgrade"),
    @NamedQuery(name = "VMemberbaseinfo.findByRprkind", query = "SELECT v FROM VMemberbaseinfo v WHERE v.rprkind = :rprkind"),
    @NamedQuery(name = "VMemberbaseinfo.findByRprtype", query = "SELECT v FROM VMemberbaseinfo v WHERE v.rprtype = :rprtype"),
    @NamedQuery(name = "VMemberbaseinfo.findByRpraddress", query = "SELECT v FROM VMemberbaseinfo v WHERE v.rpraddress = :rpraddress"),
    @NamedQuery(name = "VMemberbaseinfo.findByLinkmode", query = "SELECT v FROM VMemberbaseinfo v WHERE v.linkmode = :linkmode"),
    @NamedQuery(name = "VMemberbaseinfo.findByAddress", query = "SELECT v FROM VMemberbaseinfo v WHERE v.address = :address"),
    @NamedQuery(name = "VMemberbaseinfo.findByPersonstate", query = "SELECT v FROM VMemberbaseinfo v WHERE v.personstate = :personstate"),
    @NamedQuery(name = "VMemberbaseinfo.findByAssistType", query = "SELECT v FROM VMemberbaseinfo v WHERE v.assistType = :assistType"),
    @NamedQuery(name = "VMemberbaseinfo.findByDs", query = "SELECT v FROM VMemberbaseinfo v WHERE v.ds = :ds"),
    @NamedQuery(name = "VMemberbaseinfo.findBySalvationId", query = "SELECT v FROM VMemberbaseinfo v WHERE v.salvationId = :salvationId"),
    @NamedQuery(name = "VMemberbaseinfo.findByMedicaretype", query = "SELECT v FROM VMemberbaseinfo v WHERE v.medicaretype = :medicaretype"),
    @NamedQuery(name = "VMemberbaseinfo.findByA1", query = "SELECT v FROM VMemberbaseinfo v WHERE v.a1 = :a1"),
    @NamedQuery(name = "VMemberbaseinfo.findByA2", query = "SELECT v FROM VMemberbaseinfo v WHERE v.a2 = :a2"),
    @NamedQuery(name = "VMemberbaseinfo.findByA3", query = "SELECT v FROM VMemberbaseinfo v WHERE v.a3 = :a3"),
    @NamedQuery(name = "VMemberbaseinfo.findByA4", query = "SELECT v FROM VMemberbaseinfo v WHERE v.a4 = :a4"),
    @NamedQuery(name = "VMemberbaseinfo.findByA5", query = "SELECT v FROM VMemberbaseinfo v WHERE v.a5 = :a5"),
    @NamedQuery(name = "VMemberbaseinfo.findByArea", query = "SELECT v FROM VMemberbaseinfo v WHERE v.area = :area"),
    @NamedQuery(name = "VMemberbaseinfo.findByNation", query = "SELECT v FROM VMemberbaseinfo v WHERE v.nation = :nation"),
    @NamedQuery(name = "VMemberbaseinfo.findByMailno", query = "SELECT v FROM VMemberbaseinfo v WHERE v.mailno = :mailno"),
    @NamedQuery(name = "VMemberbaseinfo.findByPhoneno", query = "SELECT v FROM VMemberbaseinfo v WHERE v.phoneno = :phoneno"),
    @NamedQuery(name = "VMemberbaseinfo.findByOperTime", query = "SELECT v FROM VMemberbaseinfo v WHERE v.operTime = :operTime"),
    @NamedQuery(name = "VMemberbaseinfo.findByAssistTypex", query = "SELECT v FROM VMemberbaseinfo v WHERE v.assistTypex = :assistTypex"),
    @NamedQuery(name = "VMemberbaseinfo.findByA6", query = "SELECT v FROM VMemberbaseinfo v WHERE v.a6 = :a6"),
    @NamedQuery(name = "VMemberbaseinfo.findByA7", query = "SELECT v FROM VMemberbaseinfo v WHERE v.a7 = :a7"),
    @NamedQuery(name = "VMemberbaseinfo.findByA8", query = "SELECT v FROM VMemberbaseinfo v WHERE v.a8 = :a8"),
    @NamedQuery(name = "VMemberbaseinfo.findByA9", query = "SELECT v FROM VMemberbaseinfo v WHERE v.a9 = :a9"),
    @NamedQuery(name = "VMemberbaseinfo.findByA10", query = "SELECT v FROM VMemberbaseinfo v WHERE v.a10 = :a10"),
    @NamedQuery(name = "VMemberbaseinfo.findByA11", query = "SELECT v FROM VMemberbaseinfo v WHERE v.a11 = :a11"),
    @NamedQuery(name = "VMemberbaseinfo.findByOptime", query = "SELECT v FROM VMemberbaseinfo v WHERE v.optime = :optime"),
    @NamedQuery(name = "VMemberbaseinfo.findByPaperid15", query = "SELECT v FROM VMemberbaseinfo v WHERE v.paperid15 = :paperid15"),
    @NamedQuery(name = "VMemberbaseinfo.findByPaperid18", query = "SELECT v FROM VMemberbaseinfo v WHERE v.paperid18 = :paperid18")})
public class VMemberbaseinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "MEMBER_ID", length = 50)
    private String memberId;
    @Column(length = 400)
    private String membername;
    @Column(length = 400)
    private String paperid;
    @Column(length = 50)
    private String ssn;
    @Column(length = 50)
    private String familyid;
    @Column(length = 50)
    private String familyno;
    @Column(length = 128)
    private String relmaster;
    @Column(length = 400)
    private String sex;
    @Column(length = 400)
    private String mastername;
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    @Column(length = 400)
    private String health;
    @Column(length = 128)
    private String sickentype;
    @Column(length = 200)
    private String sickenname;
    @Column(length = 128)
    private String deformity;
    @Column(length = 20)
    private String defgrade;
    @Column(length = 128)
    private String rprkind;
    @Column(length = 128)
    private String rprtype;
    @Column(length = 200)
    private String rpraddress;
    @Column(length = 256)
    private String linkmode;
    @Column(length = 800)
    private String address;
    @Column(length = 20)
    private String personstate;
    @Column(name = "ASSIST_TYPE", length = 256)
    private String assistType;
    @Column(length = 256)
    private String ds;
    @Column(name = "SALVATION_ID", length = 128)
    private String salvationId;
    @Column(length = 1)
    private String medicaretype;
    @Column(length = 2)
    private String a1;
    @Column(length = 2)
    private String a2;
    @Column(length = 2)
    private String a3;
    @Column(length = 2)
    private String a4;
    @Column(length = 2)
    private String a5;
    @Column(length = 10)
    private String area;
    @Column(length = 256)
    private String nation;
    @Column(length = 256)
    private String mailno;
    @Column(length = 256)
    private String phoneno;
    @Column(name = "OPER_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date operTime;
    @Column(name = "ASSIST_TYPEX", length = 256)
    private String assistTypex;
    @Column(length = 256)
    private String a6;
    @Column(length = 256)
    private String a7;
    @Column(length = 256)
    private String a8;
    @Column(length = 256)
    private String a9;
    @Column(length = 256)
    private String a10;
    @Column(length = 256)
    private String a11;
    @Temporal(TemporalType.TIMESTAMP)
    private Date optime;
    @Column(length = 256)
    private String paperid15;
    @Column(length = 256)
    private String paperid18;

    public VMemberbaseinfo() {
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public String getPaperid() {
        return paperid;
    }

    public void setPaperid(String paperid) {
        this.paperid = paperid;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
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

    public String getRelmaster() {
        return relmaster;
    }

    public void setRelmaster(String relmaster) {
        this.relmaster = relmaster;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMastername() {
        return mastername;
    }

    public void setMastername(String mastername) {
        this.mastername = mastername;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getSickentype() {
        return sickentype;
    }

    public void setSickentype(String sickentype) {
        this.sickentype = sickentype;
    }

    public String getSickenname() {
        return sickenname;
    }

    public void setSickenname(String sickenname) {
        this.sickenname = sickenname;
    }

    public String getDeformity() {
        return deformity;
    }

    public void setDeformity(String deformity) {
        this.deformity = deformity;
    }

    public String getDefgrade() {
        return defgrade;
    }

    public void setDefgrade(String defgrade) {
        this.defgrade = defgrade;
    }

    public String getRprkind() {
        return rprkind;
    }

    public void setRprkind(String rprkind) {
        this.rprkind = rprkind;
    }

    public String getRprtype() {
        return rprtype;
    }

    public void setRprtype(String rprtype) {
        this.rprtype = rprtype;
    }

    public String getRpraddress() {
        return rpraddress;
    }

    public void setRpraddress(String rpraddress) {
        this.rpraddress = rpraddress;
    }

    public String getLinkmode() {
        return linkmode;
    }

    public void setLinkmode(String linkmode) {
        this.linkmode = linkmode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPersonstate() {
        return personstate;
    }

    public void setPersonstate(String personstate) {
        this.personstate = personstate;
    }

    public String getAssistType() {
        return assistType;
    }

    public void setAssistType(String assistType) {
        this.assistType = assistType;
    }

    public String getDs() {
        return ds;
    }

    public void setDs(String ds) {
        this.ds = ds;
    }

    public String getSalvationId() {
        return salvationId;
    }

    public void setSalvationId(String salvationId) {
        this.salvationId = salvationId;
    }

    public String getMedicaretype() {
        return medicaretype;
    }

    public void setMedicaretype(String medicaretype) {
        this.medicaretype = medicaretype;
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    public String getA4() {
        return a4;
    }

    public void setA4(String a4) {
        this.a4 = a4;
    }

    public String getA5() {
        return a5;
    }

    public void setA5(String a5) {
        this.a5 = a5;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getMailno() {
        return mailno;
    }

    public void setMailno(String mailno) {
        this.mailno = mailno;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public String getAssistTypex() {
        return assistTypex;
    }

    public void setAssistTypex(String assistTypex) {
        this.assistTypex = assistTypex;
    }

    public String getA6() {
        return a6;
    }

    public void setA6(String a6) {
        this.a6 = a6;
    }

    public String getA7() {
        return a7;
    }

    public void setA7(String a7) {
        this.a7 = a7;
    }

    public String getA8() {
        return a8;
    }

    public void setA8(String a8) {
        this.a8 = a8;
    }

    public String getA9() {
        return a9;
    }

    public void setA9(String a9) {
        this.a9 = a9;
    }

    public String getA10() {
        return a10;
    }

    public void setA10(String a10) {
        this.a10 = a10;
    }

    public String getA11() {
        return a11;
    }

    public void setA11(String a11) {
        this.a11 = a11;
    }

    public Date getOptime() {
        return optime;
    }

    public void setOptime(Date optime) {
        this.optime = optime;
    }

    public String getPaperid15() {
        return paperid15;
    }

    public void setPaperid15(String paperid15) {
        this.paperid15 = paperid15;
    }

    public String getPaperid18() {
        return paperid18;
    }

    public void setPaperid18(String paperid18) {
        this.paperid18 = paperid18;
    }
    
}
