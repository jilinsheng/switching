/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.ctrl;

import com.md.ctrl.exceptions.NonexistentEntityException;
import com.md.ctrl.exceptions.PreexistingEntityException;
import com.md.model.VFfxx;
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
public class VFfxxJpaController implements Serializable {

    public VFfxxJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VFfxx VFfxx) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(VFfxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVFfxx(VFfxx.getXh()) != null) {
                throw new PreexistingEntityException("VFfxx " + VFfxx + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VFfxx VFfxx) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            VFfxx = em.merge(VFfxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = VFfxx.getXh();
                if (findVFfxx(id) == null) {
                    throw new NonexistentEntityException("The vFfxx with id " + id + " no longer exists.");
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
            VFfxx VFfxx;
            try {
                VFfxx = em.getReference(VFfxx.class, id);
                VFfxx.getXh();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The VFfxx with id " + id + " no longer exists.", enfe);
            }
            em.remove(VFfxx);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<VFfxx> findVFfxxEntities() {
        return findVFfxxEntities(true, -1, -1);
    }

    public List<VFfxx> findVFfxxEntities(int maxResults, int firstResult) {
        return findVFfxxEntities(false, maxResults, firstResult);
    }

    private List<VFfxx> findVFfxxEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VFfxx.class));
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

    public VFfxx findVFfxx(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VFfxx.class, id);
        } finally {
            em.close();
        }
    }

    public int getVFfxxCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VFfxx> rt = cq.from(VFfxx.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
