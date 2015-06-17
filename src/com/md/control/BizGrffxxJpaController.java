/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.control;

import com.md.control.exceptions.NonexistentEntityException;
import com.md.control.exceptions.PreexistingEntityException;
import com.md.model.BizGrffxx;
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
public class BizGrffxxJpaController implements Serializable {

    public BizGrffxxJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BizGrffxx bizGrffxx) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bizGrffxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBizGrffxx(bizGrffxx.getGrffxxid()) != null) {
                throw new PreexistingEntityException("BizGrffxx " + bizGrffxx + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BizGrffxx bizGrffxx) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bizGrffxx = em.merge(bizGrffxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = bizGrffxx.getGrffxxid();
                if (findBizGrffxx(id) == null) {
                    throw new NonexistentEntityException("The bizGrffxx with id " + id + " no longer exists.");
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
            BizGrffxx bizGrffxx;
            try {
                bizGrffxx = em.getReference(BizGrffxx.class, id);
                bizGrffxx.getGrffxxid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bizGrffxx with id " + id + " no longer exists.", enfe);
            }
            em.remove(bizGrffxx);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BizGrffxx> findBizGrffxxEntities() {
        return findBizGrffxxEntities(true, -1, -1);
    }

    public List<BizGrffxx> findBizGrffxxEntities(int maxResults, int firstResult) {
        return findBizGrffxxEntities(false, maxResults, firstResult);
    }

    private List<BizGrffxx> findBizGrffxxEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BizGrffxx.class));
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

    public BizGrffxx findBizGrffxx(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BizGrffxx.class, id);
        } finally {
            em.close();
        }
    }

    public int getBizGrffxxCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BizGrffxx> rt = cq.from(BizGrffxx.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
