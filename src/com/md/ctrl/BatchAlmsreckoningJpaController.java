/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.ctrl;

import com.md.ctrl.exceptions.NonexistentEntityException;
import com.md.ctrl.exceptions.PreexistingEntityException;
import com.md.model.shengcs.BatchAlmsreckoning;
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
public class BatchAlmsreckoningJpaController implements Serializable {

    public BatchAlmsreckoningJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BatchAlmsreckoning batchAlmsreckoning) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(batchAlmsreckoning);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBatchAlmsreckoning(batchAlmsreckoning.getBarId()) != null) {
                throw new PreexistingEntityException("BatchAlmsreckoning " + batchAlmsreckoning + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BatchAlmsreckoning batchAlmsreckoning) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            batchAlmsreckoning = em.merge(batchAlmsreckoning);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = batchAlmsreckoning.getBarId();
                if (findBatchAlmsreckoning(id) == null) {
                    throw new NonexistentEntityException("The batchAlmsreckoning with id " + id + " no longer exists.");
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
            BatchAlmsreckoning batchAlmsreckoning;
            try {
                batchAlmsreckoning = em.getReference(BatchAlmsreckoning.class, id);
                batchAlmsreckoning.getBarId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The batchAlmsreckoning with id " + id + " no longer exists.", enfe);
            }
            em.remove(batchAlmsreckoning);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BatchAlmsreckoning> findBatchAlmsreckoningEntities() {
        return findBatchAlmsreckoningEntities(true, -1, -1);
    }

    public List<BatchAlmsreckoning> findBatchAlmsreckoningEntities(int maxResults, int firstResult) {
        return findBatchAlmsreckoningEntities(false, maxResults, firstResult);
    }

    private List<BatchAlmsreckoning> findBatchAlmsreckoningEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BatchAlmsreckoning.class));
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

    public BatchAlmsreckoning findBatchAlmsreckoning(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BatchAlmsreckoning.class, id);
        } finally {
            em.close();
        }
    }

    public int getBatchAlmsreckoningCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BatchAlmsreckoning> rt = cq.from(BatchAlmsreckoning.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
