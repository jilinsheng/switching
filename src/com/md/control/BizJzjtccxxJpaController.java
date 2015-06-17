/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.control;

import com.md.control.exceptions.NonexistentEntityException;
import com.md.control.exceptions.PreexistingEntityException;
import com.md.model.BizJzjtccxx;
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
public class BizJzjtccxxJpaController implements Serializable {

    public BizJzjtccxxJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BizJzjtccxx bizJzjtccxx) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bizJzjtccxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBizJzjtccxx(bizJzjtccxx.getJtcclsid()) != null) {
                throw new PreexistingEntityException("BizJzjtccxx " + bizJzjtccxx + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BizJzjtccxx bizJzjtccxx) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bizJzjtccxx = em.merge(bizJzjtccxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = bizJzjtccxx.getJtcclsid();
                if (findBizJzjtccxx(id) == null) {
                    throw new NonexistentEntityException("The bizJzjtccxx with id " + id + " no longer exists.");
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
            BizJzjtccxx bizJzjtccxx;
            try {
                bizJzjtccxx = em.getReference(BizJzjtccxx.class, id);
                bizJzjtccxx.getJtcclsid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bizJzjtccxx with id " + id + " no longer exists.", enfe);
            }
            em.remove(bizJzjtccxx);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BizJzjtccxx> findBizJzjtccxxEntities() {
        return findBizJzjtccxxEntities(true, -1, -1);
    }

    public List<BizJzjtccxx> findBizJzjtccxxEntities(int maxResults, int firstResult) {
        return findBizJzjtccxxEntities(false, maxResults, firstResult);
    }

    private List<BizJzjtccxx> findBizJzjtccxxEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BizJzjtccxx.class));
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

    public BizJzjtccxx findBizJzjtccxx(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BizJzjtccxx.class, id);
        } finally {
            em.close();
        }
    }

    public int getBizJzjtccxxCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BizJzjtccxx> rt = cq.from(BizJzjtccxx.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
