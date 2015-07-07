/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.util;

import com.md.ctrl.FamilyJpaController;
import com.md.ctrl.InfoTFamilyJpaController;
import com.md.model.CcsBizstatus;
import com.md.model.CcsFamilyinfo;
import com.md.model.CcsMemberinfo;
import com.md.model.shengcs.Familyinfo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
public class GenCcs {

    final EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("switchPU");
    final EntityManagerFactory emf1 = javax.persistence.Persistence.createEntityManagerFactory("shengcsPU");
    final EntityManagerFactory emf2 = javax.persistence.Persistence.createEntityManagerFactory("shengncPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public EntityManager getEntityManager1() {
        return emf1.createEntityManager();
    }

    public EntityManager getEntityManager2() {
        return emf2.createEntityManager();
    }

    public GenCcs() {
    }

    public List<CcsBizstatus> getCcsCity() {
        List<CcsBizstatus> rs = null;
        try {
            String sql = "SELECT c FROM CcsBizstatus c WHERE c.jzyw = :jzyw";
            Query q = this.getEntityManager().createQuery(sql).setParameter("jzyw", "100");
            rs = q.getResultList();
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            this.getEntityManager().close();
        }
        return rs;
    }

    public List<CcsBizstatus> getCcsTown() {
        List<CcsBizstatus> rs = null;
        try {
            String sql = "SELECT c FROM CcsBizstatus c WHERE c.jzyw = :jzyw";
            Query q = this.getEntityManager().createQuery(sql).setParameter("jzyw", "200");
            rs = q.getResultList();
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            this.getEntityManager().close();
        }
        return rs;
    }

    public List<CcsFamilyinfo> getFamilyinfoByNo(String jtbm) {
        List<CcsFamilyinfo> rs = null;
        try {
            String sql = "SELECT c FROM CcsFamilyinfo c WHERE c.jtbm = :jtbm";
            Query q = this.getEntityManager().createQuery(sql).setParameter("jtbm", jtbm);
            rs = q.getResultList();
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            this.getEntityManager().close();
        }
        return rs;
    }

    public List<CcsMemberinfo> getMemberinfoByNo(String jtbm) {
        List<CcsMemberinfo> rs = null;
        try {
            String sql = "SELECT c FROM CcsMemberinfo c WHERE c.jtbm = :jtbm";
            Query q = this.getEntityManager().createQuery(sql).setParameter("jtbm", jtbm);
            rs = q.getResultList();
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            this.getEntityManager().close();
        }
        return rs;
    }

    public void operbaseinfo(List<CcsFamilyinfo> fs, List<CcsMemberinfo> ms) {
        try {
            CcsFamilyinfo f = fs.get(0);
            String hzid = f.getHzsfzh();
            List<Familyinfo> firs = (List<Familyinfo>) this.getEntityManager1().createNamedQuery("Familyinfo.findByPaperid").setParameter("paperid", hzid).getResultList();
            if (null != firs && firs.size() > 0) {
                Familyinfo fi = firs.get(0);

            } else {
                //新建家庭
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            this.getEntityManager().close();
        }
    }

    public void operateinfo() {
        //处理城市数据
        List<CcsBizstatus> bizs = this.getCcsCity();
        for (CcsBizstatus biz : bizs) {
            String jtbm = biz.getJtbm();
            List<CcsFamilyinfo> fs = this.getFamilyinfoByNo(jtbm);
            List<CcsMemberinfo> ms = this.getMemberinfoByNo(jtbm);
            this.operbaseinfo(fs, ms);
        }
    }

    public void test() {
        FamilyJpaController f1 = new FamilyJpaController(emf1);
        System.out.println(f1.getFamilyCount());
        InfoTFamilyJpaController ifctrl = new InfoTFamilyJpaController(emf2);
        System.out.println(ifctrl.getInfoTFamilyCount());
    }

    public static void main(String args[]) {
        GenCcs g = new GenCcs();
        g.test();
    }
}
