/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.ctrl;

import com.md.ctrl.exceptions.NonexistentEntityException;
import com.md.ctrl.exceptions.PreexistingEntityException;
import com.md.model.shengcs.Salvationbatch;
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
public class SalvationbatchJpaController implements Serializable {

    public SalvationbatchJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Salvationbatch salvationbatch) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(salvationbatch);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSalvationbatch(salvationbatch.getSbId()) != null) {
                throw new PreexistingEntityException("Salvationbatch " + salvationbatch + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Salvationbatch salvationbatch) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            salvationbatch = em.merge(salvationbatch);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = salvationbatch.getSbId();
                if (findSalvationbatch(id) == null) {
                    throw new NonexistentEntityException("The salvationbatch with id " + id + " no longer exists.");
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
            Salvationbatch salvationbatch;
            try {
                salvationbatch = em.getReference(Salvationbatch.class, id);
                salvationbatch.getSbId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The salvationbatch with id " + id + " no longer exists.", enfe);
            }
            em.remove(salvationbatch);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Salvationbatch> findSalvationbatchEntities() {
        return findSalvationbatchEntities(true, -1, -1);
    }

    public List<Salvationbatch> findSalvationbatchEntities(int maxResults, int firstResult) {
        return findSalvationbatchEntities(false, maxResults, firstResult);
    }

    private List<Salvationbatch> findSalvationbatchEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Salvationbatch.class));
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

    public Salvationbatch findSalvationbatch(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Salvationbatch.class, id);
        } finally {
            em.close();
        }
    }

    public int getSalvationbatchCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Salvationbatch> rt = cq.from(Salvationbatch.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
