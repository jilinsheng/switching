/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.ctrl;

import com.md.ctrl.exceptions.NonexistentEntityException;
import com.md.ctrl.exceptions.PreexistingEntityException;
import com.md.model.shengcs.Familyinfo;
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
public class FamilyinfoJpaController implements Serializable {

    public FamilyinfoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Familyinfo familyinfo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(familyinfo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFamilyinfo(familyinfo.getFamilyid()) != null) {
                throw new PreexistingEntityException("Familyinfo " + familyinfo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Familyinfo familyinfo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            familyinfo = em.merge(familyinfo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = familyinfo.getFamilyid();
                if (findFamilyinfo(id) == null) {
                    throw new NonexistentEntityException("The familyinfo with id " + id + " no longer exists.");
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
            Familyinfo familyinfo;
            try {
                familyinfo = em.getReference(Familyinfo.class, id);
                familyinfo.getFamilyid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The familyinfo with id " + id + " no longer exists.", enfe);
            }
            em.remove(familyinfo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Familyinfo> findFamilyinfoEntities() {
        return findFamilyinfoEntities(true, -1, -1);
    }

    public List<Familyinfo> findFamilyinfoEntities(int maxResults, int firstResult) {
        return findFamilyinfoEntities(false, maxResults, firstResult);
    }

    private List<Familyinfo> findFamilyinfoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Familyinfo.class));
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

    public Familyinfo findFamilyinfo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Familyinfo.class, id);
        } finally {
            em.close();
        }
    }

    public int getFamilyinfoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Familyinfo> rt = cq.from(Familyinfo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
