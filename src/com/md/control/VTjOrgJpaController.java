/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.control;

import com.md.control.exceptions.NonexistentEntityException;
import com.md.control.exceptions.PreexistingEntityException;
import com.md.model.VTjOrg;
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
public class VTjOrgJpaController implements Serializable {

    public VTjOrgJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VTjOrg VTjOrg) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(VTjOrg);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVTjOrg(VTjOrg.getOrgid()) != null) {
                throw new PreexistingEntityException("VTjOrg " + VTjOrg + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VTjOrg VTjOrg) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            VTjOrg = em.merge(VTjOrg);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = VTjOrg.getOrgid();
                if (findVTjOrg(id) == null) {
                    throw new NonexistentEntityException("The vTjOrg with id " + id + " no longer exists.");
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
            VTjOrg VTjOrg;
            try {
                VTjOrg = em.getReference(VTjOrg.class, id);
                VTjOrg.getOrgid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The VTjOrg with id " + id + " no longer exists.", enfe);
            }
            em.remove(VTjOrg);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<VTjOrg> findVTjOrgEntities() {
        return findVTjOrgEntities(true, -1, -1);
    }

    public List<VTjOrg> findVTjOrgEntities(int maxResults, int firstResult) {
        return findVTjOrgEntities(false, maxResults, firstResult);
    }

    private List<VTjOrg> findVTjOrgEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VTjOrg.class));
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

    public VTjOrg findVTjOrg(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VTjOrg.class, id);
        } finally {
            em.close();
        }
    }

    public int getVTjOrgCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VTjOrg> rt = cq.from(VTjOrg.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
