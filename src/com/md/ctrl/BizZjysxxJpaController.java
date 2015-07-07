/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.ctrl;

import com.md.ctrl.exceptions.NonexistentEntityException;
import com.md.ctrl.exceptions.PreexistingEntityException;
import com.md.model.BizZjysxx;
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
public class BizZjysxxJpaController implements Serializable {

    public BizZjysxxJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BizZjysxx bizZjysxx) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bizZjysxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBizZjysxx(bizZjysxx.getZjkm()) != null) {
                throw new PreexistingEntityException("BizZjysxx " + bizZjysxx + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BizZjysxx bizZjysxx) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bizZjysxx = em.merge(bizZjysxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = bizZjysxx.getZjkm();
                if (findBizZjysxx(id) == null) {
                    throw new NonexistentEntityException("The bizZjysxx with id " + id + " no longer exists.");
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
            BizZjysxx bizZjysxx;
            try {
                bizZjysxx = em.getReference(BizZjysxx.class, id);
                bizZjysxx.getZjkm();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bizZjysxx with id " + id + " no longer exists.", enfe);
            }
            em.remove(bizZjysxx);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BizZjysxx> findBizZjysxxEntities() {
        return findBizZjysxxEntities(true, -1, -1);
    }

    public List<BizZjysxx> findBizZjysxxEntities(int maxResults, int firstResult) {
        return findBizZjysxxEntities(false, maxResults, firstResult);
    }

    private List<BizZjysxx> findBizZjysxxEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BizZjysxx.class));
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

    public BizZjysxx findBizZjysxx(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BizZjysxx.class, id);
        } finally {
            em.close();
        }
    }

    public int getBizZjysxxCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BizZjysxx> rt = cq.from(BizZjysxx.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
