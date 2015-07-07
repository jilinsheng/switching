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
public class BizJzdxjbxxPK implements Serializable {
    @Basic(optional = false)
    @Column(nullable = false, length = 32)
    private String jtlsid;
    @Basic(optional = false)
    @Column(nullable = false, length = 32)
    private String rylsid;

    public BizJzdxjbxxPK() {
    }

    public BizJzdxjbxxPK(String jtlsid, String rylsid) {
        this.jtlsid = jtlsid;
        this.rylsid = rylsid;
    }

    public String getJtlsid() {
        return jtlsid;
    }

    public void setJtlsid(String jtlsid) {
        this.jtlsid = jtlsid;
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
        hash += (jtlsid != null ? jtlsid.hashCode() : 0);
        hash += (rylsid != null ? rylsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BizJzdxjbxxPK)) {
            return false;
        }
        BizJzdxjbxxPK other = (BizJzdxjbxxPK) object;
        if ((this.jtlsid == null && other.jtlsid != null) || (this.jtlsid != null && !this.jtlsid.equals(other.jtlsid))) {
            return false;
        }
        if ((this.rylsid == null && other.rylsid != null) || (this.rylsid != null && !this.rylsid.equals(other.rylsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BizJzdxjbxxPK[ jtlsid=" + jtlsid + ", rylsid=" + rylsid + " ]";
    }
    
}
