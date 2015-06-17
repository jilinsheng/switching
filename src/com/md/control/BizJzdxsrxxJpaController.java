/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.control;

import com.md.control.exceptions.NonexistentEntityException;
import com.md.control.exceptions.PreexistingEntityException;
import com.md.model.BizJzdxsrxx;
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
public class BizJzdxsrxxJpaController implements Serializable {

    public BizJzdxsrxxJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BizJzdxsrxx bizJzdxsrxx) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bizJzdxsrxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBizJzdxsrxx(bizJzdxsrxx.getJzdxsrlsid()) != null) {
                throw new PreexistingEntityException("BizJzdxsrxx " + bizJzdxsrxx + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BizJzdxsrxx bizJzdxsrxx) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bizJzdxsrxx = em.merge(bizJzdxsrxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = bizJzdxsrxx.getJzdxsrlsid();
                if (findBizJzdxsrxx(id) == null) {
                    throw new NonexistentEntityException("The bizJzdxsrxx with id " + id + " no longer exists.");
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
            BizJzdxsrxx bizJzdxsrxx;
            try {
                bizJzdxsrxx = em.getReference(BizJzdxsrxx.class, id);
                bizJzdxsrxx.getJzdxsrlsid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bizJzdxsrxx with id " + id + " no longer exists.", enfe);
            }
            em.remove(bizJzdxsrxx);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BizJzdxsrxx> findBizJzdxsrxxEntities() {
        return findBizJzdxsrxxEntities(true, -1, -1);
    }

    public List<BizJzdxsrxx> findBizJzdxsrxxEntities(int maxResults, int firstResult) {
        return findBizJzdxsrxxEntities(false, maxResults, firstResult);
    }

    private List<BizJzdxsrxx> findBizJzdxsrxxEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BizJzdxsrxx.class));
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

    public BizJzdxsrxx findBizJzdxsrxx(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BizJzdxsrxx.class, id);
        } finally {
            em.close();
        }
    }

    public int getBizJzdxsrxxCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BizJzdxsrxx> rt = cq.from(BizJzdxsrxx.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
