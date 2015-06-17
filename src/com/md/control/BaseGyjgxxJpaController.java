/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.control;

import com.md.control.exceptions.NonexistentEntityException;
import com.md.control.exceptions.PreexistingEntityException;
import com.md.model.BaseGyjgxx;
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
public class BaseGyjgxxJpaController implements Serializable {

    public BaseGyjgxxJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BaseGyjgxx baseGyjgxx) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(baseGyjgxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBaseGyjgxx(baseGyjgxx.getJgid()) != null) {
                throw new PreexistingEntityException("BaseGyjgxx " + baseGyjgxx + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BaseGyjgxx baseGyjgxx) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            baseGyjgxx = em.merge(baseGyjgxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = baseGyjgxx.getJgid();
                if (findBaseGyjgxx(id) == null) {
                    throw new NonexistentEntityException("The baseGyjgxx with id " + id + " no longer exists.");
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
            BaseGyjgxx baseGyjgxx;
            try {
                baseGyjgxx = em.getReference(BaseGyjgxx.class, id);
                baseGyjgxx.getJgid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The baseGyjgxx with id " + id + " no longer exists.", enfe);
            }
            em.remove(baseGyjgxx);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BaseGyjgxx> findBaseGyjgxxEntities() {
        return findBaseGyjgxxEntities(true, -1, -1);
    }

    public List<BaseGyjgxx> findBaseGyjgxxEntities(int maxResults, int firstResult) {
        return findBaseGyjgxxEntities(false, maxResults, firstResult);
    }

    private List<BaseGyjgxx> findBaseGyjgxxEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BaseGyjgxx.class));
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

    public BaseGyjgxx findBaseGyjgxx(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BaseGyjgxx.class, id);
        } finally {
            em.close();
        }
    }

    public int getBaseGyjgxxCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BaseGyjgxx> rt = cq.from(BaseGyjgxx.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
