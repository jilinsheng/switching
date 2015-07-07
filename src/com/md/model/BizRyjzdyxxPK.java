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
public class BizRyjzdyxxPK implements Serializable {
    @Basic(optional = false)
    @Column(nullable = false)
    private long xh;
    @Basic(optional = false)
    @Column(nullable = false, length = 32)
    private String rylsid;

    public BizRyjzdyxxPK() {
    }

    public BizRyjzdyxxPK(long xh, String rylsid) {
        this.xh = xh;
        this.rylsid = rylsid;
    }

    public long getXh() {
        return xh;
    }

    public void setXh(long xh) {
        this.xh = xh;
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
        hash += (int) xh;
        hash += (rylsid != null ? rylsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BizRyjzdyxxPK)) {
            return false;
        }
        BizRyjzdyxxPK other = (BizRyjzdyxxPK) object;
        if (this.xh != other.xh) {
            return false;
        }
        if ((this.rylsid == null && other.rylsid != null) || (this.rylsid != null && !this.rylsid.equals(other.rylsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BizRyjzdyxxPK[ xh=" + xh + ", rylsid=" + rylsid + " ]";
    }
    
}
