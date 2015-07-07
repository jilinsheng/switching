/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.ctrl;

import com.md.ctrl.exceptions.NonexistentEntityException;
import com.md.ctrl.exceptions.PreexistingEntityException;
import com.md.model.BizFfxx;
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
public class BizFfxxJpaController implements Serializable {

    public BizFfxxJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BizFfxx bizFfxx) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bizFfxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBizFfxx(bizFfxx.getFfxxid()) != null) {
                throw new PreexistingEntityException("BizFfxx " + bizFfxx + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BizFfxx bizFfxx) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bizFfxx = em.merge(bizFfxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = bizFfxx.getFfxxid();
                if (findBizFfxx(id) == null) {
                    throw new NonexistentEntityException("The bizFfxx with id " + id + " no longer exists.");
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
            BizFfxx bizFfxx;
            try {
                bizFfxx = em.getReference(BizFfxx.class, id);
                bizFfxx.getFfxxid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bizFfxx with id " + id + " no longer exists.", enfe);
            }
            em.remove(bizFfxx);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BizFfxx> findBizFfxxEntities() {
        return findBizFfxxEntities(true, -1, -1);
    }

    public List<BizFfxx> findBizFfxxEntities(int maxResults, int firstResult) {
        return findBizFfxxEntities(false, maxResults, firstResult);
    }

    private List<BizFfxx> findBizFfxxEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BizFfxx.class));
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

    public BizFfxx findBizFfxx(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BizFfxx.class, id);
        } finally {
            em.close();
        }
    }

    public int getBizFfxxCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BizFfxx> rt = cq.from(BizFfxx.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
