/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.md.ctrl;

import com.md.ctrl.exceptions.NonexistentEntityException;
import com.md.ctrl.exceptions.PreexistingEntityException;
import com.md.model.BizRktjxx;
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
public class BizRktjxxJpaController implements Serializable {

    public BizRktjxxJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BizRktjxx bizRktjxx) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bizRktjxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBizRktjxx(bizRktjxx.getQxxzqhbm()) != null) {
                throw new PreexistingEntityException("BizRktjxx " + bizRktjxx + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BizRktjxx bizRktjxx) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bizRktjxx = em.merge(bizRktjxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = bizRktjxx.getQxxzqhbm();
                if (findBizRktjxx(id) == null) {
                    throw new NonexistentEntityException("The bizRktjxx with id " + id + " no longer exists.");
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
            BizRktjxx bizRktjxx;
            try {
                bizRktjxx = em.getReference(BizRktjxx.class, id);
                bizRktjxx.getQxxzqhbm();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bizRktjxx with id " + id + " no longer exists.", enfe);
            }
            em.remove(bizRktjxx);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BizRktjxx> findBizRktjxxEntities() {
        return findBizRktjxxEntities(true, -1, -1);
    }

    public List<BizRktjxx> findBizRktjxxEntities(int maxResults, int firstResult) {
        return findBizRktjxxEntities(false, maxResults, firstResult);
    }

    private List<BizRktjxx> findBizRktjxxEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BizRktjxx.class));
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

    public BizRktjxx findBizRktjxx(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BizRktjxx.class, id);
        } finally {
            em.close();
        }
    }

    public int getBizRktjxxCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BizRktjxx> rt = cq.from(BizRktjxx.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
