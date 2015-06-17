/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.control;

import com.md.control.exceptions.NonexistentEntityException;
import com.md.control.exceptions.PreexistingEntityException;
import com.md.model.BizJzbzxx;
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
public class BizJzbzxxJpaController implements Serializable {

    public BizJzbzxxJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BizJzbzxx bizJzbzxx) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bizJzbzxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBizJzbzxx(bizJzbzxx.getJgid()) != null) {
                throw new PreexistingEntityException("BizJzbzxx " + bizJzbzxx + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BizJzbzxx bizJzbzxx) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bizJzbzxx = em.merge(bizJzbzxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = bizJzbzxx.getJgid();
                if (findBizJzbzxx(id) == null) {
                    throw new NonexistentEntityException("The bizJzbzxx with id " + id + " no longer exists.");
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
            BizJzbzxx bizJzbzxx;
            try {
                bizJzbzxx = em.getReference(BizJzbzxx.class, id);
                bizJzbzxx.getJgid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bizJzbzxx with id " + id + " no longer exists.", enfe);
            }
            em.remove(bizJzbzxx);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BizJzbzxx> findBizJzbzxxEntities() {
        return findBizJzbzxxEntities(true, -1, -1);
    }

    public List<BizJzbzxx> findBizJzbzxxEntities(int maxResults, int firstResult) {
        return findBizJzbzxxEntities(false, maxResults, firstResult);
    }

    private List<BizJzbzxx> findBizJzbzxxEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BizJzbzxx.class));
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

    public BizJzbzxx findBizJzbzxx(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BizJzbzxx.class, id);
        } finally {
            em.close();
        }
    }

    public int getBizJzbzxxCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BizJzbzxx> rt = cq.from(BizJzbzxx.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
