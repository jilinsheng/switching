/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.ctrl;

import com.md.ctrl.exceptions.NonexistentEntityException;
import com.md.ctrl.exceptions.PreexistingEntityException;
import com.md.model.CcsMemberinfo;
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
public class CcsMemberinfoJpaController1 implements Serializable {

    public CcsMemberinfoJpaController1(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CcsMemberinfo ccsMemberinfo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ccsMemberinfo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCcsMemberinfo(ccsMemberinfo.getZrowid()) != null) {
                throw new PreexistingEntityException("CcsMemberinfo " + ccsMemberinfo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CcsMemberinfo ccsMemberinfo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ccsMemberinfo = em.merge(ccsMemberinfo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = ccsMemberinfo.getZrowid();
                if (findCcsMemberinfo(id) == null) {
                    throw new NonexistentEntityException("The ccsMemberinfo with id " + id + " no longer exists.");
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
            CcsMemberinfo ccsMemberinfo;
            try {
                ccsMemberinfo = em.getReference(CcsMemberinfo.class, id);
                ccsMemberinfo.getZrowid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ccsMemberinfo with id " + id + " no longer exists.", enfe);
            }
            em.remove(ccsMemberinfo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CcsMemberinfo> findCcsMemberinfoEntities() {
        return findCcsMemberinfoEntities(true, -1, -1);
    }

    public List<CcsMemberinfo> findCcsMemberinfoEntities(int maxResults, int firstResult) {
        return findCcsMemberinfoEntities(false, maxResults, firstResult);
    }

    private List<CcsMemberinfo> findCcsMemberinfoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CcsMemberinfo.class));
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

    public CcsMemberinfo findCcsMemberinfo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CcsMemberinfo.class, id);
        } finally {
            em.close();
        }
    }

    public int getCcsMemberinfoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CcsMemberinfo> rt = cq.from(CcsMemberinfo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
