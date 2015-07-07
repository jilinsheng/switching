/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.ctrl;

import com.md.ctrl.exceptions.NonexistentEntityException;
import com.md.ctrl.exceptions.PreexistingEntityException;
import com.md.model.BizJtjzdyxx;
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
public class BizJtjzdyxxJpaController implements Serializable {

    public BizJtjzdyxxJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BizJtjzdyxx bizJtjzdyxx) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bizJtjzdyxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBizJtjzdyxx(bizJtjzdyxx.getJtlsid()) != null) {
                throw new PreexistingEntityException("BizJtjzdyxx " + bizJtjzdyxx + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BizJtjzdyxx bizJtjzdyxx) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bizJtjzdyxx = em.merge(bizJtjzdyxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = bizJtjzdyxx.getJtlsid();
                if (findBizJtjzdyxx(id) == null) {
                    throw new NonexistentEntityException("The bizJtjzdyxx with id " + id + " no longer exists.");
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
            BizJtjzdyxx bizJtjzdyxx;
            try {
                bizJtjzdyxx = em.getReference(BizJtjzdyxx.class, id);
                bizJtjzdyxx.getJtlsid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bizJtjzdyxx with id " + id + " no longer exists.", enfe);
            }
            em.remove(bizJtjzdyxx);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BizJtjzdyxx> findBizJtjzdyxxEntities() {
        return findBizJtjzdyxxEntities(true, -1, -1);
    }

    public List<BizJtjzdyxx> findBizJtjzdyxxEntities(int maxResults, int firstResult) {
        return findBizJtjzdyxxEntities(false, maxResults, firstResult);
    }

    private List<BizJtjzdyxx> findBizJtjzdyxxEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BizJtjzdyxx.class));
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

    public BizJtjzdyxx findBizJtjzdyxx(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BizJtjzdyxx.class, id);
        } finally {
            em.close();
        }
    }

    public int getBizJtjzdyxxCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BizJtjzdyxx> rt = cq.from(BizJtjzdyxx.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
