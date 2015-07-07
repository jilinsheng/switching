/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.ctrl;

import com.md.ctrl.exceptions.NonexistentEntityException;
import com.md.ctrl.exceptions.PreexistingEntityException;
import com.md.model.BizRydyzjbhxx;
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
public class BizRydyzjbhxxJpaController implements Serializable {

    public BizRydyzjbhxxJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BizRydyzjbhxx bizRydyzjbhxx) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bizRydyzjbhxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBizRydyzjbhxx(bizRydyzjbhxx.getRylsid()) != null) {
                throw new PreexistingEntityException("BizRydyzjbhxx " + bizRydyzjbhxx + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BizRydyzjbhxx bizRydyzjbhxx) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bizRydyzjbhxx = em.merge(bizRydyzjbhxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = bizRydyzjbhxx.getRylsid();
                if (findBizRydyzjbhxx(id) == null) {
                    throw new NonexistentEntityException("The bizRydyzjbhxx with id " + id + " no longer exists.");
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
            BizRydyzjbhxx bizRydyzjbhxx;
            try {
                bizRydyzjbhxx = em.getReference(BizRydyzjbhxx.class, id);
                bizRydyzjbhxx.getRylsid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bizRydyzjbhxx with id " + id + " no longer exists.", enfe);
            }
            em.remove(bizRydyzjbhxx);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BizRydyzjbhxx> findBizRydyzjbhxxEntities() {
        return findBizRydyzjbhxxEntities(true, -1, -1);
    }

    public List<BizRydyzjbhxx> findBizRydyzjbhxxEntities(int maxResults, int firstResult) {
        return findBizRydyzjbhxxEntities(false, maxResults, firstResult);
    }

    private List<BizRydyzjbhxx> findBizRydyzjbhxxEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BizRydyzjbhxx.class));
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

    public BizRydyzjbhxx findBizRydyzjbhxx(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BizRydyzjbhxx.class, id);
        } finally {
            em.close();
        }
    }

    public int getBizRydyzjbhxxCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BizRydyzjbhxx> rt = cq.from(BizRydyzjbhxx.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
