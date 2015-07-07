/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.ctrl;

import com.md.ctrl.exceptions.NonexistentEntityException;
import com.md.ctrl.exceptions.PreexistingEntityException;
import com.md.model.BizJzjtzfxx;
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
public class BizJzjtzfxxJpaController implements Serializable {

    public BizJzjtzfxxJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BizJzjtzfxx bizJzjtzfxx) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bizJzjtzfxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBizJzjtzfxx(bizJzjtzfxx.getJtzflsid()) != null) {
                throw new PreexistingEntityException("BizJzjtzfxx " + bizJzjtzfxx + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BizJzjtzfxx bizJzjtzfxx) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bizJzjtzfxx = em.merge(bizJzjtzfxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = bizJzjtzfxx.getJtzflsid();
                if (findBizJzjtzfxx(id) == null) {
                    throw new NonexistentEntityException("The bizJzjtzfxx with id " + id + " no longer exists.");
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
            BizJzjtzfxx bizJzjtzfxx;
            try {
                bizJzjtzfxx = em.getReference(BizJzjtzfxx.class, id);
                bizJzjtzfxx.getJtzflsid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bizJzjtzfxx with id " + id + " no longer exists.", enfe);
            }
            em.remove(bizJzjtzfxx);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BizJzjtzfxx> findBizJzjtzfxxEntities() {
        return findBizJzjtzfxxEntities(true, -1, -1);
    }

    public List<BizJzjtzfxx> findBizJzjtzfxxEntities(int maxResults, int firstResult) {
        return findBizJzjtzfxxEntities(false, maxResults, firstResult);
    }

    private List<BizJzjtzfxx> findBizJzjtzfxxEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BizJzjtzfxx.class));
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

    public BizJzjtzfxx findBizJzjtzfxx(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BizJzjtzfxx.class, id);
        } finally {
            em.close();
        }
    }

    public int getBizJzjtzfxxCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BizJzjtzfxx> rt = cq.from(BizJzjtzfxx.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
