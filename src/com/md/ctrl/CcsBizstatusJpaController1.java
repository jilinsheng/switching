/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.ctrl;

import com.md.ctrl.exceptions.NonexistentEntityException;
import com.md.ctrl.exceptions.PreexistingEntityException;
import com.md.model.CcsBizstatus;
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
public class CcsBizstatusJpaController1 implements Serializable {

    public CcsBizstatusJpaController1(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CcsBizstatus ccsBizstatus) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ccsBizstatus);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCcsBizstatus(ccsBizstatus.getZrowid()) != null) {
                throw new PreexistingEntityException("CcsBizstatus " + ccsBizstatus + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CcsBizstatus ccsBizstatus) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ccsBizstatus = em.merge(ccsBizstatus);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = ccsBizstatus.getZrowid();
                if (findCcsBizstatus(id) == null) {
                    throw new NonexistentEntityException("The ccsBizstatus with id " + id + " no longer exists.");
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
            CcsBizstatus ccsBizstatus;
            try {
                ccsBizstatus = em.getReference(CcsBizstatus.class, id);
                ccsBizstatus.getZrowid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ccsBizstatus with id " + id + " no longer exists.", enfe);
            }
            em.remove(ccsBizstatus);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CcsBizstatus> findCcsBizstatusEntities() {
        return findCcsBizstatusEntities(true, -1, -1);
    }

    public List<CcsBizstatus> findCcsBizstatusEntities(int maxResults, int firstResult) {
        return findCcsBizstatusEntities(false, maxResults, firstResult);
    }

    private List<CcsBizstatus> findCcsBizstatusEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CcsBizstatus.class));
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

    public CcsBizstatus findCcsBizstatus(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CcsBizstatus.class, id);
        } finally {
            em.close();
        }
    }

    public int getCcsBizstatusCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CcsBizstatus> rt = cq.from(CcsBizstatus.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
