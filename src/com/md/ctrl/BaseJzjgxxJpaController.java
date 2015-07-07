/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.ctrl;

import com.md.ctrl.exceptions.NonexistentEntityException;
import com.md.ctrl.exceptions.PreexistingEntityException;
import com.md.model.BaseJzjgxx;
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
public class BaseJzjgxxJpaController implements Serializable {

    public BaseJzjgxxJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BaseJzjgxx baseJzjgxx) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(baseJzjgxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBaseJzjgxx(baseJzjgxx.getJgid()) != null) {
                throw new PreexistingEntityException("BaseJzjgxx " + baseJzjgxx + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BaseJzjgxx baseJzjgxx) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            baseJzjgxx = em.merge(baseJzjgxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = baseJzjgxx.getJgid();
                if (findBaseJzjgxx(id) == null) {
                    throw new NonexistentEntityException("The baseJzjgxx with id " + id + " no longer exists.");
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
            BaseJzjgxx baseJzjgxx;
            try {
                baseJzjgxx = em.getReference(BaseJzjgxx.class, id);
                baseJzjgxx.getJgid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The baseJzjgxx with id " + id + " no longer exists.", enfe);
            }
            em.remove(baseJzjgxx);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BaseJzjgxx> findBaseJzjgxxEntities() {
        return findBaseJzjgxxEntities(true, -1, -1);
    }

    public List<BaseJzjgxx> findBaseJzjgxxEntities(int maxResults, int firstResult) {
        return findBaseJzjgxxEntities(false, maxResults, firstResult);
    }

    private List<BaseJzjgxx> findBaseJzjgxxEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BaseJzjgxx.class));
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

    public BaseJzjgxx findBaseJzjgxx(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BaseJzjgxx.class, id);
        } finally {
            em.close();
        }
    }

    public int getBaseJzjgxxCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BaseJzjgxx> rt = cq.from(BaseJzjgxx.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
