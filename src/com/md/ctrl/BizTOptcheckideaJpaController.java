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
import com.md.model.shengnc.BizTOptcheck;
import com.md.model.shengnc.BizTOptcheckidea;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Administrator
 */
public class BizTOptcheckideaJpaController implements Serializable {

    public BizTOptcheckideaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BizTOptcheckidea bizTOptcheckidea) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            BizTOptcheck optcheckId = bizTOptcheckidea.getOptcheckId();
            if (optcheckId != null) {
                optcheckId = em.getReference(optcheckId.getClass(), optcheckId.getOptcheckId());
                bizTOptcheckidea.setOptcheckId(optcheckId);
            }
            em.persist(bizTOptcheckidea);
            if (optcheckId != null) {
                optcheckId.getBizTOptcheckideaSet().add(bizTOptcheckidea);
                optcheckId = em.merge(optcheckId);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBizTOptcheckidea(bizTOptcheckidea.getOptcheckideaId()) != null) {
                throw new PreexistingEntityException("BizTOptcheckidea " + bizTOptcheckidea + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BizTOptcheckidea bizTOptcheckidea) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            BizTOptcheckidea persistentBizTOptcheckidea = em.find(BizTOptcheckidea.class, bizTOptcheckidea.getOptcheckideaId());
            BizTOptcheck optcheckIdOld = persistentBizTOptcheckidea.getOptcheckId();
            BizTOptcheck optcheckIdNew = bizTOptcheckidea.getOptcheckId();
            if (optcheckIdNew != null) {
                optcheckIdNew = em.getReference(optcheckIdNew.getClass(), optcheckIdNew.getOptcheckId());
                bizTOptcheckidea.setOptcheckId(optcheckIdNew);
            }
            bizTOptcheckidea = em.merge(bizTOptcheckidea);
            if (optcheckIdOld != null && !optcheckIdOld.equals(optcheckIdNew)) {
                optcheckIdOld.getBizTOptcheckideaSet().remove(bizTOptcheckidea);
                optcheckIdOld = em.merge(optcheckIdOld);
            }
            if (optcheckIdNew != null && !optcheckIdNew.equals(optcheckIdOld)) {
                optcheckIdNew.getBizTOptcheckideaSet().add(bizTOptcheckidea);
                optcheckIdNew = em.merge(optcheckIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = bizTOptcheckidea.getOptcheckideaId();
                if (findBizTOptcheckidea(id) == null) {
                    throw new NonexistentEntityException("The bizTOptcheckidea with id " + id + " no longer exists.");
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
            BizTOptcheckidea bizTOptcheckidea;
            try {
                bizTOptcheckidea = em.getReference(BizTOptcheckidea.class, id);
                bizTOptcheckidea.getOptcheckideaId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bizTOptcheckidea with id " + id + " no longer exists.", enfe);
            }
            BizTOptcheck optcheckId = bizTOptcheckidea.getOptcheckId();
            if (optcheckId != null) {
                optcheckId.getBizTOptcheckideaSet().remove(bizTOptcheckidea);
                optcheckId = em.merge(optcheckId);
            }
            em.remove(bizTOptcheckidea);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BizTOptcheckidea> findBizTOptcheckideaEntities() {
        return findBizTOptcheckideaEntities(true, -1, -1);
    }

    public List<BizTOptcheckidea> findBizTOptcheckideaEntities(int maxResults, int firstResult) {
        return findBizTOptcheckideaEntities(false, maxResults, firstResult);
    }

    private List<BizTOptcheckidea> findBizTOptcheckideaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BizTOptcheckidea.class));
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

    public BizTOptcheckidea findBizTOptcheckidea(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BizTOptcheckidea.class, id);
        } finally {
            em.close();
        }
    }

    public int getBizTOptcheckideaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BizTOptcheckidea> rt = cq.from(BizTOptcheckidea.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
