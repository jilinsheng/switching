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
import com.md.model.shengnc.BizTOptacc;
import com.md.model.shengnc.BizTOptcheck2;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Administrator
 */
public class BizTOptcheck2JpaController implements Serializable {

    public BizTOptcheck2JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BizTOptcheck2 bizTOptcheck2) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            BizTOptacc optaccId = bizTOptcheck2.getOptaccId();
            if (optaccId != null) {
                optaccId = em.getReference(optaccId.getClass(), optaccId.getOptaccId());
                bizTOptcheck2.setOptaccId(optaccId);
            }
            em.persist(bizTOptcheck2);
            if (optaccId != null) {
                optaccId.getBizTOptcheck2Set().add(bizTOptcheck2);
                optaccId = em.merge(optaccId);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBizTOptcheck2(bizTOptcheck2.getOptcheck2Id()) != null) {
                throw new PreexistingEntityException("BizTOptcheck2 " + bizTOptcheck2 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BizTOptcheck2 bizTOptcheck2) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            BizTOptcheck2 persistentBizTOptcheck2 = em.find(BizTOptcheck2.class, bizTOptcheck2.getOptcheck2Id());
            BizTOptacc optaccIdOld = persistentBizTOptcheck2.getOptaccId();
            BizTOptacc optaccIdNew = bizTOptcheck2.getOptaccId();
            if (optaccIdNew != null) {
                optaccIdNew = em.getReference(optaccIdNew.getClass(), optaccIdNew.getOptaccId());
                bizTOptcheck2.setOptaccId(optaccIdNew);
            }
            bizTOptcheck2 = em.merge(bizTOptcheck2);
            if (optaccIdOld != null && !optaccIdOld.equals(optaccIdNew)) {
                optaccIdOld.getBizTOptcheck2Set().remove(bizTOptcheck2);
                optaccIdOld = em.merge(optaccIdOld);
            }
            if (optaccIdNew != null && !optaccIdNew.equals(optaccIdOld)) {
                optaccIdNew.getBizTOptcheck2Set().add(bizTOptcheck2);
                optaccIdNew = em.merge(optaccIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = bizTOptcheck2.getOptcheck2Id();
                if (findBizTOptcheck2(id) == null) {
                    throw new NonexistentEntityException("The bizTOptcheck2 with id " + id + " no longer exists.");
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
            BizTOptcheck2 bizTOptcheck2;
            try {
                bizTOptcheck2 = em.getReference(BizTOptcheck2.class, id);
                bizTOptcheck2.getOptcheck2Id();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bizTOptcheck2 with id " + id + " no longer exists.", enfe);
            }
            BizTOptacc optaccId = bizTOptcheck2.getOptaccId();
            if (optaccId != null) {
                optaccId.getBizTOptcheck2Set().remove(bizTOptcheck2);
                optaccId = em.merge(optaccId);
            }
            em.remove(bizTOptcheck2);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BizTOptcheck2> findBizTOptcheck2Entities() {
        return findBizTOptcheck2Entities(true, -1, -1);
    }

    public List<BizTOptcheck2> findBizTOptcheck2Entities(int maxResults, int firstResult) {
        return findBizTOptcheck2Entities(false, maxResults, firstResult);
    }

    private List<BizTOptcheck2> findBizTOptcheck2Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BizTOptcheck2.class));
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

    public BizTOptcheck2 findBizTOptcheck2(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BizTOptcheck2.class, id);
        } finally {
            em.close();
        }
    }

    public int getBizTOptcheck2Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BizTOptcheck2> rt = cq.from(BizTOptcheck2.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
