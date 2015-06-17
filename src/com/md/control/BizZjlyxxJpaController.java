/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.control;

import com.md.control.exceptions.NonexistentEntityException;
import com.md.control.exceptions.PreexistingEntityException;
import com.md.model.BizZjlyxx;
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
public class BizZjlyxxJpaController implements Serializable {

    public BizZjlyxxJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BizZjlyxx bizZjlyxx) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bizZjlyxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBizZjlyxx(bizZjlyxx.getZjkm()) != null) {
                throw new PreexistingEntityException("BizZjlyxx " + bizZjlyxx + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BizZjlyxx bizZjlyxx) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bizZjlyxx = em.merge(bizZjlyxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = bizZjlyxx.getZjkm();
                if (findBizZjlyxx(id) == null) {
                    throw new NonexistentEntityException("The bizZjlyxx with id " + id + " no longer exists.");
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
            BizZjlyxx bizZjlyxx;
            try {
                bizZjlyxx = em.getReference(BizZjlyxx.class, id);
                bizZjlyxx.getZjkm();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bizZjlyxx with id " + id + " no longer exists.", enfe);
            }
            em.remove(bizZjlyxx);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BizZjlyxx> findBizZjlyxxEntities() {
        return findBizZjlyxxEntities(true, -1, -1);
    }

    public List<BizZjlyxx> findBizZjlyxxEntities(int maxResults, int firstResult) {
        return findBizZjlyxxEntities(false, maxResults, firstResult);
    }

    private List<BizZjlyxx> findBizZjlyxxEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BizZjlyxx.class));
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

    public BizZjlyxx findBizZjlyxx(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BizZjlyxx.class, id);
        } finally {
            em.close();
        }
    }

    public int getBizZjlyxxCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BizZjlyxx> rt = cq.from(BizZjlyxx.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
