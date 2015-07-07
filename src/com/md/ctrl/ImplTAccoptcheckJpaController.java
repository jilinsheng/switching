/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.ctrl;

import com.md.ctrl.exceptions.NonexistentEntityException;
import com.md.ctrl.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.md.model.shengnc.DoperTPolicy;
import com.md.model.shengnc.ImplTAccoptcheck;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Administrator
 */
public class ImplTAccoptcheckJpaController implements Serializable {

    public ImplTAccoptcheckJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ImplTAccoptcheck implTAccoptcheck) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DoperTPolicy policyId = implTAccoptcheck.getPolicyId();
            if (policyId != null) {
                policyId = em.getReference(policyId.getClass(), policyId.getPolicyId());
                implTAccoptcheck.setPolicyId(policyId);
            }
            em.persist(implTAccoptcheck);
            if (policyId != null) {
                policyId.getImplTAccoptcheckSet().add(implTAccoptcheck);
                policyId = em.merge(policyId);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findImplTAccoptcheck(implTAccoptcheck.getAccoptcheckId()) != null) {
                throw new PreexistingEntityException("ImplTAccoptcheck " + implTAccoptcheck + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ImplTAccoptcheck implTAccoptcheck) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ImplTAccoptcheck persistentImplTAccoptcheck = em.find(ImplTAccoptcheck.class, implTAccoptcheck.getAccoptcheckId());
            DoperTPolicy policyIdOld = persistentImplTAccoptcheck.getPolicyId();
            DoperTPolicy policyIdNew = implTAccoptcheck.getPolicyId();
            if (policyIdNew != null) {
                policyIdNew = em.getReference(policyIdNew.getClass(), policyIdNew.getPolicyId());
                implTAccoptcheck.setPolicyId(policyIdNew);
            }
            implTAccoptcheck = em.merge(implTAccoptcheck);
            if (policyIdOld != null && !policyIdOld.equals(policyIdNew)) {
                policyIdOld.getImplTAccoptcheckSet().remove(implTAccoptcheck);
                policyIdOld = em.merge(policyIdOld);
            }
            if (policyIdNew != null && !policyIdNew.equals(policyIdOld)) {
                policyIdNew.getImplTAccoptcheckSet().add(implTAccoptcheck);
                policyIdNew = em.merge(policyIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = implTAccoptcheck.getAccoptcheckId();
                if (findImplTAccoptcheck(id) == null) {
                    throw new NonexistentEntityException("The implTAccoptcheck with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(BigDecimal id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ImplTAccoptcheck implTAccoptcheck;
            try {
                implTAccoptcheck = em.getReference(ImplTAccoptcheck.class, id);
                implTAccoptcheck.getAccoptcheckId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The implTAccoptcheck with id " + id + " no longer exists.", enfe);
            }
            DoperTPolicy policyId = implTAccoptcheck.getPolicyId();
            if (policyId != null) {
                policyId.getImplTAccoptcheckSet().remove(implTAccoptcheck);
                policyId = em.merge(policyId);
            }
            em.remove(implTAccoptcheck);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ImplTAccoptcheck> findImplTAccoptcheckEntities() {
        return findImplTAccoptcheckEntities(true, -1, -1);
    }

    public List<ImplTAccoptcheck> findImplTAccoptcheckEntities(int maxResults, int firstResult) {
        return findImplTAccoptcheckEntities(false, maxResults, firstResult);
    }

    private List<ImplTAccoptcheck> findImplTAccoptcheckEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ImplTAccoptcheck.class));
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

    public ImplTAccoptcheck findImplTAccoptcheck(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ImplTAccoptcheck.class, id);
        } finally {
            em.close();
        }
    }

    public int getImplTAccoptcheckCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ImplTAccoptcheck> rt = cq.from(ImplTAccoptcheck.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
