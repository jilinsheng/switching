/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.model.shengcs;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Salvationtype.findAll", query = "SELECT s FROM Salvationtype s"),
    @NamedQuery(name = "Salvationtype.findByStId", query = "SELECT s FROM Salvationtype s WHERE s.stId = :stId"),
    @NamedQuery(name = "Salvationtype.findByStName", query = "SELECT s FROM Salvationtype s WHERE s.stName = :stName"),
    @NamedQuery(name = "Salvationtype.findByStDescription", query = "SELECT s FROM Salvationtype s WHERE s.stDescription = :stDescription"),
    @NamedQuery(name = "Salvationtype.findByStObjecttype", query = "SELECT s FROM Salvationtype s WHERE s.stObjecttype = :stObjecttype"),
    @NamedQuery(name = "Salvationtype.findByStIfreview", query = "SELECT s FROM Salvationtype s WHERE s.stIfreview = :stIfreview"),
    @NamedQuery(name = "Salvationtype.findByStIfjoind", query = "SELECT s FROM Salvationtype s WHERE s.stIfjoind = :stIfjoind"),
    @NamedQuery(name = "Salvationtype.findByStState", query = "SELECT s FROM Salvationtype s WHERE s.stState = :stState")})
public class Salvationtype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ST_ID", nullable = false, length = 50)
    private String stId;
    @Column(name = "ST_NAME", length = 200)
    private String stName;
    @Column(name = "ST_DESCRIPTION", length = 400)
    private String stDescription;
    @Column(name = "ST_OBJECTTYPE", length = 20)
    private String stObjecttype;
    @Column(name = "ST_IFREVIEW", length = 20)
    private String stIfreview;
    @Column(name = "ST_IFJOIND")
    private Integer stIfjoind;
    @Column(name = "ST_STATE")
    private Character stState;
    @JoinColumn(name = "ON_NO", referencedColumnName = "ON_NO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Organno onNo;
    @OneToMany(mappedBy = "stId", fetch = FetchType.LAZY)
    private List<Salvationstatus> salvationstatusList;

    public Salvationtype() {
    }

    public Salvationtype(String stId) {
        this.stId = stId;
    }

    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getStDescription() {
        return stDescription;
    }

    public void setStDescription(String stDescription) {
        this.stDescription = stDescription;
    }

    public String getStObjecttype() {
        return stObjecttype;
    }

    public void setStObjecttype(String stObjecttype) {
        this.stObjecttype = stObjecttype;
    }

    public String getStIfreview() {
        return stIfreview;
    }

    public void setStIfreview(String stIfreview) {
        this.stIfreview = stIfreview;
    }

    public Integer getStIfjoind() {
        return stIfjoind;
    }

    public void setStIfjoind(Integer stIfjoind) {
        this.stIfjoind = stIfjoind;
    }

    public Character getStState() {
        return stState;
    }

    public void setStState(Character stState) {
        this.stState = stState;
    }

    public Organno getOnNo() {
        return onNo;
    }

    public void setOnNo(Organno onNo) {
        this.onNo = onNo;
    }

    @XmlTransient
    public List<Salvationstatus> getSalvationstatusList() {
        return salvationstatusList;
    }

    public void setSalvationstatusList(List<Salvationstatus> salvationstatusList) {
        this.salvationstatusList = salvationstatusList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stId != null ? stId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salvationtype)) {
            return false;
        }
        Salvationtype other = (Salvationtype) object;
        if ((this.stId == null && other.stId != null) || (this.stId != null && !this.stId.equals(other.stId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.shengcs.Salvationtype[ stId=" + stId + " ]";
    }
    
}
