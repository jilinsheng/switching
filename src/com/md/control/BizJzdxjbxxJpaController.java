/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.control;

import com.md.control.exceptions.NonexistentEntityException;
import com.md.control.exceptions.PreexistingEntityException;
import com.md.model.BizJzdxjbxx;
import com.md.model.BizJzdxjbxxPK;
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
public class BizJzdxjbxxJpaController implements Serializable {

    public BizJzdxjbxxJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BizJzdxjbxx bizJzdxjbxx) throws PreexistingEntityException, Exception {
        if (bizJzdxjbxx.getBizJzdxjbxxPK() == null) {
            bizJzdxjbxx.setBizJzdxjbxxPK(new BizJzdxjbxxPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bizJzdxjbxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBizJzdxjbxx(bizJzdxjbxx.getBizJzdxjbxxPK()) != null) {
                throw new PreexistingEntityException("BizJzdxjbxx " + bizJzdxjbxx + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BizJzdxjbxx bizJzdxjbxx) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bizJzdxjbxx = em.merge(bizJzdxjbxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BizJzdxjbxxPK id = bizJzdxjbxx.getBizJzdxjbxxPK();
                if (findBizJzdxjbxx(id) == null) {
                    throw new NonexistentEntityException("The bizJzdxjbxx with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(BizJzdxjbxxPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            BizJzdxjbxx bizJzdxjbxx;
            try {
                bizJzdxjbxx = em.getReference(BizJzdxjbxx.class, id);
                bizJzdxjbxx.getBizJzdxjbxxPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bizJzdxjbxx with id " + id + " no longer exists.", enfe);
            }
            em.remove(bizJzdxjbxx);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BizJzdxjbxx> findBizJzdxjbxxEntities() {
        return findBizJzdxjbxxEntities(true, -1, -1);
    }

    public List<BizJzdxjbxx> findBizJzdxjbxxEntities(int maxResults, int firstResult) {
        return findBizJzdxjbxxEntities(false, maxResults, firstResult);
    }

    private List<BizJzdxjbxx> findBizJzdxjbxxEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BizJzdxjbxx.class));
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

    public BizJzdxjbxx findBizJzdxjbxx(BizJzdxjbxxPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BizJzdxjbxx.class, id);
        } finally {
            em.close();
        }
    }

    public int getBizJzdxjbxxCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BizJzdxjbxx> rt = cq.from(BizJzdxjbxx.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
