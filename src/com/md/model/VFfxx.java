/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "V_FFXX", catalog = "", schema = "SWITCHING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VFfxx.findAll", query = "SELECT v FROM VFfxx v"),
    @NamedQuery(name = "VFfxx.findByXh", query = "SELECT v FROM VFfxx v WHERE v.xh = :xh"),
    @NamedQuery(name = "VFfxx.findByZjzhid", query = "SELECT v FROM VFfxx v WHERE v.zjzhid = :zjzhid"),
    @NamedQuery(name = "VFfxx.findByFfny", query = "SELECT v FROM VFfxx v WHERE v.ffny = :ffny"),
    @NamedQuery(name = "VFfxx.findByFfrs", query = "SELECT v FROM VFfxx v WHERE v.ffrs = :ffrs"),
    @NamedQuery(name = "VFfxx.findByFfje", query = "SELECT v FROM VFfxx v WHERE v.ffje = :ffje"),
    @NamedQuery(name = "VFfxx.findByFflx", query = "SELECT v FROM VFfxx v WHERE v.fflx = :fflx"),
    @NamedQuery(name = "VFfxx.findByJbr", query = "SELECT v FROM VFfxx v WHERE v.jbr = :jbr"),
    @NamedQuery(name = "VFfxx.findBySpr", query = "SELECT v FROM VFfxx v WHERE v.spr = :spr"),
    @NamedQuery(name = "VFfxx.findByFfzt", query = "SELECT v FROM VFfxx v WHERE v.ffzt = :ffzt"),
    @NamedQuery(name = "VFfxx.findByFffs", query = "SELECT v FROM VFfxx v WHERE v.fffs = :fffs"),
    @NamedQuery(name = "VFfxx.findByJzywbm", query = "SELECT v FROM VFfxx v WHERE v.jzywbm = :jzywbm"),
    @NamedQuery(name = "VFfxx.findByBz", query = "SELECT v FROM VFfxx v WHERE v.bz = :bz"),
    @NamedQuery(name = "VFfxx.findByCzy", query = "SELECT v FROM VFfxx v WHERE v.czy = :czy"),
    @NamedQuery(name = "VFfxx.findByJbjg", query = "SELECT v FROM VFfxx v WHERE v.jbjg = :jbjg"),
    @NamedQuery(name = "VFfxx.findByXzqhbm", query = "SELECT v FROM VFfxx v WHERE v.xzqhbm = :xzqhbm"),
    @NamedQuery(name = "VFfxx.findByZllx", query = "SELECT v FROM VFfxx v WHERE v.zllx = :zllx"),
    @NamedQuery(name = "VFfxx.findByCzsj", query = "SELECT v FROM VFfxx v WHERE v.czsj = :czsj")})
public class VFfxx implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(length = 0)
    private String xh;
    @Lob
    private byte[] ffxxid;
    @Column(length = 0)
    private String zjzhid;
    @Column(length = 6)
    private String ffny;
    private BigInteger ffrs;
    @Column(length = 13)
    private String ffje;
    @Column(length = 2)
    private String fflx;
    @Column(length = 0)
    private String jbr;
    @Column(length = 0)
    private String spr;
    private Character ffzt;
    @Column(length = 2)
    private String fffs;
    @Column(length = 3)
    private String jzywbm;
    @Column(length = 0)
    private String bz;
    @Column(length = 0)
    private String czy;
    @Column(length = 0)
    private String jbjg;
    @Column(length = 12)
    private String xzqhbm;
    private Character zllx;
    @Column(length = 19)
    private String czsj;

    public VFfxx() {
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public byte[] getFfxxid() {
        return ffxxid;
    }

    public void setFfxxid(byte[] ffxxid) {
        this.ffxxid = ffxxid;
    }

    public String getZjzhid() {
        return zjzhid;
    }

    public void setZjzhid(String zjzhid) {
        this.zjzhid = zjzhid;
    }

    public String getFfny() {
        return ffny;
    }

    public void setFfny(String ffny) {
        this.ffny = ffny;
    }

    public BigInteger getFfrs() {
        return ffrs;
    }

    public void setFfrs(BigInteger ffrs) {
        this.ffrs = ffrs;
    }

    public String getFfje() {
        return ffje;
    }

    public void setFfje(String ffje) {
        this.ffje = ffje;
    }

    public String getFflx() {
        return fflx;
    }

    public void setFflx(String fflx) {
        this.fflx = fflx;
    }

    public String getJbr() {
        return jbr;
    }

    public void setJbr(String jbr) {
        this.jbr = jbr;
    }

    public String getSpr() {
        return spr;
    }

    public void setSpr(String spr) {
        this.spr = spr;
    }

    public Character getFfzt() {
        return ffzt;
    }

    public void setFfzt(Character ffzt) {
        this.ffzt = ffzt;
    }

    public String getFffs() {
        return fffs;
    }

    public void setFffs(String fffs) {
        this.fffs = fffs;
    }

    public String getJzywbm() {
        return jzywbm;
    }

    public void setJzywbm(String jzywbm) {
        this.jzywbm = jzywbm;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getCzy() {
        return czy;
    }

    public void setCzy(String czy) {
        this.czy = czy;
    }

    public String getJbjg() {
        return jbjg;
    }

    public void setJbjg(String jbjg) {
        this.jbjg = jbjg;
    }

    public String getXzqhbm() {
        return xzqhbm;
    }

    public void setXzqhbm(String xzqhbm) {
        this.xzqhbm = xzqhbm;
    }

    public Character getZllx() {
        return zllx;
    }

    public void setZllx(Character zllx) {
        this.zllx = zllx;
    }

    public String getCzsj() {
        return czsj;
    }

    public void setCzsj(String czsj) {
        this.czsj = czsj;
    }
    
}
