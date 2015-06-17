/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.control;

import com.md.control.exceptions.NonexistentEntityException;
import com.md.control.exceptions.PreexistingEntityException;
import com.md.model.BizJzdxgzdwxx;
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
public class BizJzdxgzdwxxJpaController implements Serializable {

    public BizJzdxgzdwxxJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BizJzdxgzdwxx bizJzdxgzdwxx) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bizJzdxgzdwxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBizJzdxgzdwxx(bizJzdxgzdwxx.getGzdwlsid()) != null) {
                throw new PreexistingEntityException("BizJzdxgzdwxx " + bizJzdxgzdwxx + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BizJzdxgzdwxx bizJzdxgzdwxx) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bizJzdxgzdwxx = em.merge(bizJzdxgzdwxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = bizJzdxgzdwxx.getGzdwlsid();
                if (findBizJzdxgzdwxx(id) == null) {
                    throw new NonexistentEntityException("The bizJzdxgzdwxx with id " + id + " no longer exists.");
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
            BizJzdxgzdwxx bizJzdxgzdwxx;
            try {
                bizJzdxgzdwxx = em.getReference(BizJzdxgzdwxx.class, id);
                bizJzdxgzdwxx.getGzdwlsid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bizJzdxgzdwxx with id " + id + " no longer exists.", enfe);
            }
            em.remove(bizJzdxgzdwxx);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BizJzdxgzdwxx> findBizJzdxgzdwxxEntities() {
        return findBizJzdxgzdwxxEntities(true, -1, -1);
    }

    public List<BizJzdxgzdwxx> findBizJzdxgzdwxxEntities(int maxResults, int firstResult) {
        return findBizJzdxgzdwxxEntities(false, maxResults, firstResult);
    }

    private List<BizJzdxgzdwxx> findBizJzdxgzdwxxEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BizJzdxgzdwxx.class));
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

    public BizJzdxgzdwxx findBizJzdxgzdwxx(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BizJzdxgzdwxx.class, id);
        } finally {
            em.close();
        }
    }

    public int getBizJzdxgzdwxxCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BizJzdxgzdwxx> rt = cq.from(BizJzdxgzdwxx.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
