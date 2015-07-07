/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.ctrl;

import com.md.ctrl.exceptions.NonexistentEntityException;
import com.md.ctrl.exceptions.PreexistingEntityException;
import com.md.model.BizYljztjxx;
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
public class BizYljztjxxJpaController implements Serializable {

    public BizYljztjxxJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BizYljztjxx bizYljztjxx) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bizYljztjxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBizYljztjxx(bizYljztjxx.getQxxzqhbm()) != null) {
                throw new PreexistingEntityException("BizYljztjxx " + bizYljztjxx + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BizYljztjxx bizYljztjxx) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bizYljztjxx = em.merge(bizYljztjxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = bizYljztjxx.getQxxzqhbm();
                if (findBizYljztjxx(id) == null) {
                    throw new NonexistentEntityException("The bizYljztjxx with id " + id + " no longer exists.");
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
            BizYljztjxx bizYljztjxx;
            try {
                bizYljztjxx = em.getReference(BizYljztjxx.class, id);
                bizYljztjxx.getQxxzqhbm();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bizYljztjxx with id " + id + " no longer exists.", enfe);
            }
            em.remove(bizYljztjxx);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BizYljztjxx> findBizYljztjxxEntities() {
        return findBizYljztjxxEntities(true, -1, -1);
    }

    public List<BizYljztjxx> findBizYljztjxxEntities(int maxResults, int firstResult) {
        return findBizYljztjxxEntities(false, maxResults, firstResult);
    }

    private List<BizYljztjxx> findBizYljztjxxEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BizYljztjxx.class));
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

    public BizYljztjxx findBizYljztjxx(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BizYljztjxx.class, id);
        } finally {
            em.close();
        }
    }

    public int getBizYljztjxxCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BizYljztjxx> rt = cq.from(BizYljztjxx.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
