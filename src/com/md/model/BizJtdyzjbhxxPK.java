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
public class BizJtdyzjbhxxPK implements Serializable {
    @Basic(optional = false)
    @Column(nullable = false)
    private long xh;
    @Basic(optional = false)
    @Column(nullable = false, length = 32)
    private String jtlsid;

    public BizJtdyzjbhxxPK() {
    }

    public BizJtdyzjbhxxPK(long xh, String jtlsid) {
        this.xh = xh;
        this.jtlsid = jtlsid;
    }

    public long getXh() {
        return xh;
    }

    public void setXh(long xh) {
        this.xh = xh;
    }

    public String getJtlsid() {
        return jtlsid;
    }

    public void setJtlsid(String jtlsid) {
        this.jtlsid = jtlsid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) xh;
        hash += (jtlsid != null ? jtlsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BizJtdyzjbhxxPK)) {
            return false;
        }
        BizJtdyzjbhxxPK other = (BizJtdyzjbhxxPK) object;
        if (this.xh != other.xh) {
            return false;
        }
        if ((this.jtlsid == null && other.jtlsid != null) || (this.jtlsid != null && !this.jtlsid.equals(other.jtlsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.md.model.BizJtdyzjbhxxPK[ xh=" + xh + ", jtlsid=" + jtlsid + " ]";
    }
    
}
