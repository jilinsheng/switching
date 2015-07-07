/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Administrator
 */
@Embeddable
public class BizJzdxjyxxPK implements Serializable {
    @Basic(optional = false)
    @Column(nullable = false, length = 32)
    private String jylsid;
    @Basic(optional = false)
    @Column(nullable = false, length = 32)
    private String rylsid;

    public BizJzdxjyxxPK() {
    }

    public BizJzdxjyxxPK(String jylsid, String rylsid) {
        this.jylsid = jylsid;
        this.rylsid = rylsid;
    }

    public String getJylsid() {
        return jylsid;
    }

    public void setJylsid(String jylsid) {
        this.jylsid = jylsid;
    }

    public String getRylsid() {
        return rylsid;
    }

    public void setRylsid(String rylsid) {
        this.rylsid = rylsid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jylsid != null ? jylsid.hashCode() : 0);
        hash += (rylsid != null ? rylsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BizJzdxjyxxPK)) {
            return false;
        }
        BizJzdxjyxxPK other = (BizJzdxjyxxPK) object;
        if ((this.jylsid == null && other.jylsid != null) || (this.jylsid != null && !this.jylsid.equals(other.jylsid))) {
            return false;
        }
        if ((this.rylsid == null && other.rylsid != null) || (this.rylsid != null && !this.rylsid.equals(other.rylsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BizJzdxjyxxPK[ jylsid=" + jylsid + ", rylsid=" + rylsid + " ]";
    }
    
}
