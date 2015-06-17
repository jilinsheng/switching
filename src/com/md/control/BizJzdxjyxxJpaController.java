/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.control;

import com.md.control.exceptions.NonexistentEntityException;
import com.md.control.exceptions.PreexistingEntityException;
import com.md.model.BizJzdxjyxx;
import com.md.model.BizJzdxjyxxPK;
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
public class BizJzdxjyxxJpaController implements Serializable {

    public BizJzdxjyxxJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BizJzdxjyxx bizJzdxjyxx) throws PreexistingEntityException, Exception {
        if (bizJzdxjyxx.getBizJzdxjyxxPK() == null) {
            bizJzdxjyxx.setBizJzdxjyxxPK(new BizJzdxjyxxPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bizJzdxjyxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBizJzdxjyxx(bizJzdxjyxx.getBizJzdxjyxxPK()) != null) {
                throw new PreexistingEntityException("BizJzdxjyxx " + bizJzdxjyxx + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BizJzdxjyxx bizJzdxjyxx) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bizJzdxjyxx = em.merge(bizJzdxjyxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BizJzdxjyxxPK id = bizJzdxjyxx.getBizJzdxjyxxPK();
                if (findBizJzdxjyxx(id) == null) {
                    throw new NonexistentEntityException("The bizJzdxjyxx with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(BizJzdxjyxxPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            BizJzdxjyxx bizJzdxjyxx;
            try {
                bizJzdxjyxx = em.getReference(BizJzdxjyxx.class, id);
                bizJzdxjyxx.getBizJzdxjyxxPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bizJzdxjyxx with id " + id + " no longer exists.", enfe);
            }
            em.remove(bizJzdxjyxx);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BizJzdxjyxx> findBizJzdxjyxxEntities() {
        return findBizJzdxjyxxEntities(true, -1, -1);
    }

    public List<BizJzdxjyxx> findBizJzdxjyxxEntities(int maxResults, int firstResult) {
        return findBizJzdxjyxxEntities(false, maxResults, firstResult);
    }

    private List<BizJzdxjyxx> findBizJzdxjyxxEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BizJzdxjyxx.class));
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

    public BizJzdxjyxx findBizJzdxjyxx(BizJzdxjyxxPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BizJzdxjyxx.class, id);
        } finally {
            em.close();
        }
    }

    public int getBizJzdxjyxxCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BizJzdxjyxx> rt = cq.from(BizJzdxjyxx.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
