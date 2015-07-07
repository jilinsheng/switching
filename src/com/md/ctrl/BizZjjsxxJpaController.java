/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.ctrl;

import com.md.ctrl.exceptions.NonexistentEntityException;
import com.md.ctrl.exceptions.PreexistingEntityException;
import com.md.model.BizZjjsxx;
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
public class BizZjjsxxJpaController implements Serializable {

    public BizZjjsxxJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BizZjjsxx bizZjjsxx) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bizZjjsxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBizZjjsxx(bizZjjsxx.getZjjsxxid()) != null) {
                throw new PreexistingEntityException("BizZjjsxx " + bizZjjsxx + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BizZjjsxx bizZjjsxx) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bizZjjsxx = em.merge(bizZjjsxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = bizZjjsxx.getZjjsxxid();
                if (findBizZjjsxx(id) == null) {
                    throw new NonexistentEntityException("The bizZjjsxx with id " + id + " no longer exists.");
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
            BizZjjsxx bizZjjsxx;
            try {
                bizZjjsxx = em.getReference(BizZjjsxx.class, id);
                bizZjjsxx.getZjjsxxid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bizZjjsxx with id " + id + " no longer exists.", enfe);
            }
            em.remove(bizZjjsxx);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BizZjjsxx> findBizZjjsxxEntities() {
        return findBizZjjsxxEntities(true, -1, -1);
    }

    public List<BizZjjsxx> findBizZjjsxxEntities(int maxResults, int firstResult) {
        return findBizZjjsxxEntities(false, maxResults, firstResult);
    }

    private List<BizZjjsxx> findBizZjjsxxEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BizZjjsxx.class));
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

    public BizZjjsxx findBizZjjsxx(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BizZjjsxx.class, id);
        } finally {
            em.close();
        }
    }

    public int getBizZjjsxxCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BizZjjsxx> rt = cq.from(BizZjjsxx.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
