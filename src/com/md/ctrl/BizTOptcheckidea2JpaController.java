/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.ctrl;

import com.md.ctrl.exceptions.NonexistentEntityException;
import com.md.ctrl.exceptions.PreexistingEntityException;
import com.md.model.shengnc.BizTOptcheckidea2;
import java.io.Serializable;
import java.math.BigDecimal;
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
public class BizTOptcheckidea2JpaController implements Serializable {

    public BizTOptcheckidea2JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BizTOptcheckidea2 bizTOptcheckidea2) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bizTOptcheckidea2);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBizTOptcheckidea2(bizTOptcheckidea2.getOptcheckideaId()) != null) {
                throw new PreexistingEntityException("BizTOptcheckidea2 " + bizTOptcheckidea2 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BizTOptcheckidea2 bizTOptcheckidea2) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bizTOptcheckidea2 = em.merge(bizTOptcheckidea2);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = bizTOptcheckidea2.getOptcheckideaId();
                if (findBizTOptcheckidea2(id) == null) {
                    throw new NonexistentEntityException("The bizTOptcheckidea2 with id " + id + " no longer exists.");
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
            BizTOptcheckidea2 bizTOptcheckidea2;
            try {
                bizTOptcheckidea2 = em.getReference(BizTOptcheckidea2.class, id);
                bizTOptcheckidea2.getOptcheckideaId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bizTOptcheckidea2 with id " + id + " no longer exists.", enfe);
            }
            em.remove(bizTOptcheckidea2);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BizTOptcheckidea2> findBizTOptcheckidea2Entities() {
        return findBizTOptcheckidea2Entities(true, -1, -1);
    }

    public List<BizTOptcheckidea2> findBizTOptcheckidea2Entities(int maxResults, int firstResult) {
        return findBizTOptcheckidea2Entities(false, maxResults, firstResult);
    }

    private List<BizTOptcheckidea2> findBizTOptcheckidea2Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BizTOptcheckidea2.class));
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

    public BizTOptcheckidea2 findBizTOptcheckidea2(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BizTOptcheckidea2.class, id);
        } finally {
            em.close();
        }
    }

    public int getBizTOptcheckidea2Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BizTOptcheckidea2> rt = cq.from(BizTOptcheckidea2.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
