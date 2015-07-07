/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.ctrl;

import com.md.ctrl.exceptions.NonexistentEntityException;
import com.md.ctrl.exceptions.PreexistingEntityException;
import com.md.model.shengcs.Familymemberinfo;
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
public class FamilymemberinfoJpaController implements Serializable {

    public FamilymemberinfoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Familymemberinfo familymemberinfo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(familymemberinfo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFamilymemberinfo(familymemberinfo.getFmId()) != null) {
                throw new PreexistingEntityException("Familymemberinfo " + familymemberinfo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Familymemberinfo familymemberinfo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            familymemberinfo = em.merge(familymemberinfo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = familymemberinfo.getFmId();
                if (findFamilymemberinfo(id) == null) {
                    throw new NonexistentEntityException("The familymemberinfo with id " + id + " no longer exists.");
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
            Familymemberinfo familymemberinfo;
            try {
                familymemberinfo = em.getReference(Familymemberinfo.class, id);
                familymemberinfo.getFmId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The familymemberinfo with id " + id + " no longer exists.", enfe);
            }
            em.remove(familymemberinfo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Familymemberinfo> findFamilymemberinfoEntities() {
        return findFamilymemberinfoEntities(true, -1, -1);
    }

    public List<Familymemberinfo> findFamilymemberinfoEntities(int maxResults, int firstResult) {
        return findFamilymemberinfoEntities(false, maxResults, firstResult);
    }

    private List<Familymemberinfo> findFamilymemberinfoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Familymemberinfo.class));
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

    public Familymemberinfo findFamilymemberinfo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Familymemberinfo.class, id);
        } finally {
            em.close();
        }
    }

    public int getFamilymemberinfoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Familymemberinfo> rt = cq.from(Familymemberinfo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
