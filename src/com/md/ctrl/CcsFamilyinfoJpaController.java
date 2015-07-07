/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.ctrl;

import com.md.ctrl.exceptions.NonexistentEntityException;
import com.md.ctrl.exceptions.PreexistingEntityException;
import com.md.model.CcsFamilyinfo;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Administrator
 */
public class CcsFamilyinfoJpaController implements Serializable {

    public CcsFamilyinfoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CcsFamilyinfo ccsFamilyinfo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ccsFamilyinfo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCcsFamilyinfo(ccsFamilyinfo.getZrowid()) != null) {
                throw new PreexistingEntityException("CcsFamilyinfo " + ccsFamilyinfo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CcsFamilyinfo ccsFamilyinfo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ccsFamilyinfo = em.merge(ccsFamilyinfo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = ccsFamilyinfo.getZrowid();
                if (findCcsFamilyinfo(id) == null) {
                    throw new NonexistentEntityException("The ccsFamilyinfo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CcsFamilyinfo ccsFamilyinfo;
            try {
                ccsFamilyinfo = em.getReference(CcsFamilyinfo.class, id);
                ccsFamilyinfo.getZrowid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ccsFamilyinfo with id " + id + " no longer exists.", enfe);
            }
            em.remove(ccsFamilyinfo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CcsFamilyinfo> findCcsFamilyinfoEntities() {
        return findCcsFamilyinfoEntities(true, -1, -1);
    }

    public List<CcsFamilyinfo> findCcsFamilyinfoEntities(int maxResults, int firstResult) {
        return findCcsFamilyinfoEntities(false, maxResults, firstResult);
    }

    private List<CcsFamilyinfo> findCcsFamilyinfoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CcsFamilyinfo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public CcsFamilyinfo findCcsFamilyinfo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CcsFamilyinfo.class, id);
        } finally {
            em.close();
        }
    }

    public int getCcsFamilyinfoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CcsFamilyinfo> rt = cq.from(CcsFamilyinfo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
