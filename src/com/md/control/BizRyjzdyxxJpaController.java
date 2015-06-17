/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.control;

import com.md.control.exceptions.NonexistentEntityException;
import com.md.control.exceptions.PreexistingEntityException;
import com.md.model.BizRyjzdyxx;
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
public class BizRyjzdyxxJpaController implements Serializable {

    public BizRyjzdyxxJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BizRyjzdyxx bizRyjzdyxx) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bizRyjzdyxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBizRyjzdyxx(bizRyjzdyxx.getRylsid()) != null) {
                throw new PreexistingEntityException("BizRyjzdyxx " + bizRyjzdyxx + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BizRyjzdyxx bizRyjzdyxx) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bizRyjzdyxx = em.merge(bizRyjzdyxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = bizRyjzdyxx.getRylsid();
                if (findBizRyjzdyxx(id) == null) {
                    throw new NonexistentEntityException("The bizRyjzdyxx with id " + id + " no longer exists.");
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
            BizRyjzdyxx bizRyjzdyxx;
            try {
                bizRyjzdyxx = em.getReference(BizRyjzdyxx.class, id);
                bizRyjzdyxx.getRylsid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bizRyjzdyxx with id " + id + " no longer exists.", enfe);
            }
            em.remove(bizRyjzdyxx);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BizRyjzdyxx> findBizRyjzdyxxEntities() {
        return findBizRyjzdyxxEntities(true, -1, -1);
    }

    public List<BizRyjzdyxx> findBizRyjzdyxxEntities(int maxResults, int firstResult) {
        return findBizRyjzdyxxEntities(false, maxResults, firstResult);
    }

    private List<BizRyjzdyxx> findBizRyjzdyxxEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BizRyjzdyxx.class));
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

    public BizRyjzdyxx findBizRyjzdyxx(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BizRyjzdyxx.class, id);
        } finally {
            em.close();
        }
    }

    public int getBizRyjzdyxxCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BizRyjzdyxx> rt = cq.from(BizRyjzdyxx.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
