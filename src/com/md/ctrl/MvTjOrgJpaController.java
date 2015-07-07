/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.ctrl;

import com.md.ctrl.exceptions.NonexistentEntityException;
import com.md.ctrl.exceptions.PreexistingEntityException;
import com.md.model.MvTjOrg;
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
public class MvTjOrgJpaController implements Serializable {

    public MvTjOrgJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MvTjOrg mvTjOrg) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mvTjOrg);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMvTjOrg(mvTjOrg.getOrgid()) != null) {
                throw new PreexistingEntityException("MvTjOrg " + mvTjOrg + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MvTjOrg mvTjOrg) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mvTjOrg = em.merge(mvTjOrg);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = mvTjOrg.getOrgid();
                if (findMvTjOrg(id) == null) {
                    throw new NonexistentEntityException("The mvTjOrg with id " + id + " no longer exists.");
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
            MvTjOrg mvTjOrg;
            try {
                mvTjOrg = em.getReference(MvTjOrg.class, id);
                mvTjOrg.getOrgid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mvTjOrg with id " + id + " no longer exists.", enfe);
            }
            em.remove(mvTjOrg);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MvTjOrg> findMvTjOrgEntities() {
        return findMvTjOrgEntities(true, -1, -1);
    }

    public List<MvTjOrg> findMvTjOrgEntities(int maxResults, int firstResult) {
        return findMvTjOrgEntities(false, maxResults, firstResult);
    }

    private List<MvTjOrg> findMvTjOrgEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MvTjOrg.class));
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

    public MvTjOrg findMvTjOrg(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MvTjOrg.class, id);
        } finally {
            em.close();
        }
    }

    public int getMvTjOrgCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MvTjOrg> rt = cq.from(MvTjOrg.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
