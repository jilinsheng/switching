/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.ctrl;

import com.md.ctrl.exceptions.NonexistentEntityException;
import com.md.ctrl.exceptions.PreexistingEntityException;
import com.md.model.BizJzjtxx;
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
public class BizJzjtxxJpaController implements Serializable {

    public BizJzjtxxJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BizJzjtxx bizJzjtxx) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bizJzjtxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBizJzjtxx(bizJzjtxx.getJtlsid()) != null) {
                throw new PreexistingEntityException("BizJzjtxx " + bizJzjtxx + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BizJzjtxx bizJzjtxx) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bizJzjtxx = em.merge(bizJzjtxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = bizJzjtxx.getJtlsid();
                if (findBizJzjtxx(id) == null) {
                    throw new NonexistentEntityException("The bizJzjtxx with id " + id + " no longer exists.");
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
            BizJzjtxx bizJzjtxx;
            try {
                bizJzjtxx = em.getReference(BizJzjtxx.class, id);
                bizJzjtxx.getJtlsid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bizJzjtxx with id " + id + " no longer exists.", enfe);
            }
            em.remove(bizJzjtxx);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BizJzjtxx> findBizJzjtxxEntities() {
        return findBizJzjtxxEntities(true, -1, -1);
    }

    public List<BizJzjtxx> findBizJzjtxxEntities(int maxResults, int firstResult) {
        return findBizJzjtxxEntities(false, maxResults, firstResult);
    }

    private List<BizJzjtxx> findBizJzjtxxEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BizJzjtxx.class));
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

    public BizJzjtxx findBizJzjtxx(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BizJzjtxx.class, id);
        } finally {
            em.close();
        }
    }

    public int getBizJzjtxxCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BizJzjtxx> rt = cq.from(BizJzjtxx.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
