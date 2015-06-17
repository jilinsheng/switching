/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.control;

import com.md.control.exceptions.NonexistentEntityException;
import com.md.control.exceptions.PreexistingEntityException;
import com.md.model.BizJtdyzjbhxx;
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
public class BizJtdyzjbhxxJpaController implements Serializable {

    public BizJtdyzjbhxxJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BizJtdyzjbhxx bizJtdyzjbhxx) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bizJtdyzjbhxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBizJtdyzjbhxx(bizJtdyzjbhxx.getJtlsid()) != null) {
                throw new PreexistingEntityException("BizJtdyzjbhxx " + bizJtdyzjbhxx + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BizJtdyzjbhxx bizJtdyzjbhxx) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bizJtdyzjbhxx = em.merge(bizJtdyzjbhxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = bizJtdyzjbhxx.getJtlsid();
                if (findBizJtdyzjbhxx(id) == null) {
                    throw new NonexistentEntityException("The bizJtdyzjbhxx with id " + id + " no longer exists.");
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
            BizJtdyzjbhxx bizJtdyzjbhxx;
            try {
                bizJtdyzjbhxx = em.getReference(BizJtdyzjbhxx.class, id);
                bizJtdyzjbhxx.getJtlsid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bizJtdyzjbhxx with id " + id + " no longer exists.", enfe);
            }
            em.remove(bizJtdyzjbhxx);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BizJtdyzjbhxx> findBizJtdyzjbhxxEntities() {
        return findBizJtdyzjbhxxEntities(true, -1, -1);
    }

    public List<BizJtdyzjbhxx> findBizJtdyzjbhxxEntities(int maxResults, int firstResult) {
        return findBizJtdyzjbhxxEntities(false, maxResults, firstResult);
    }

    private List<BizJtdyzjbhxx> findBizJtdyzjbhxxEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BizJtdyzjbhxx.class));
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

    public BizJtdyzjbhxx findBizJtdyzjbhxx(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BizJtdyzjbhxx.class, id);
        } finally {
            em.close();
        }
    }

    public int getBizJtdyzjbhxxCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BizJtdyzjbhxx> rt = cq.from(BizJtdyzjbhxx.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
