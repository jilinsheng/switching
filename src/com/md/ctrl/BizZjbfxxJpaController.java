/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.ctrl;

import com.md.ctrl.exceptions.NonexistentEntityException;
import com.md.ctrl.exceptions.PreexistingEntityException;
import com.md.model.BizZjbfxx;
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
public class BizZjbfxxJpaController implements Serializable {

    public BizZjbfxxJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BizZjbfxx bizZjbfxx) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bizZjbfxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBizZjbfxx(bizZjbfxx.getJgid()) != null) {
                throw new PreexistingEntityException("BizZjbfxx " + bizZjbfxx + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BizZjbfxx bizZjbfxx) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bizZjbfxx = em.merge(bizZjbfxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = bizZjbfxx.getJgid();
                if (findBizZjbfxx(id) == null) {
                    throw new NonexistentEntityException("The bizZjbfxx with id " + id + " no longer exists.");
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
            BizZjbfxx bizZjbfxx;
            try {
                bizZjbfxx = em.getReference(BizZjbfxx.class, id);
                bizZjbfxx.getJgid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bizZjbfxx with id " + id + " no longer exists.", enfe);
            }
            em.remove(bizZjbfxx);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BizZjbfxx> findBizZjbfxxEntities() {
        return findBizZjbfxxEntities(true, -1, -1);
    }

    public List<BizZjbfxx> findBizZjbfxxEntities(int maxResults, int firstResult) {
        return findBizZjbfxxEntities(false, maxResults, firstResult);
    }

    private List<BizZjbfxx> findBizZjbfxxEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BizZjbfxx.class));
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

    public BizZjbfxx findBizZjbfxx(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BizZjbfxx.class, id);
        } finally {
            em.close();
        }
    }

    public int getBizZjbfxxCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BizZjbfxx> rt = cq.from(BizZjbfxx.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
