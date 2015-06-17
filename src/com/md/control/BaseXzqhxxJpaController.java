/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.control;

import com.md.control.exceptions.NonexistentEntityException;
import com.md.control.exceptions.PreexistingEntityException;
import com.md.model.BaseXzqhxx;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

/**
 *
 * @author Administrator
 */
public class BaseXzqhxxJpaController implements Serializable {

    public BaseXzqhxxJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BaseXzqhxx baseXzqhxx) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(baseXzqhxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBaseXzqhxx(baseXzqhxx.getXzqhid()) != null) {
                throw new PreexistingEntityException("BaseXzqhxx " + baseXzqhxx + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BaseXzqhxx baseXzqhxx) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            baseXzqhxx = em.merge(baseXzqhxx);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = baseXzqhxx.getXzqhid();
                if (findBaseXzqhxx(id) == null) {
                    throw new NonexistentEntityException("The baseXzqhxx with id " + id + " no longer exists.");
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
            BaseXzqhxx baseXzqhxx;
            try {
                baseXzqhxx = em.getReference(BaseXzqhxx.class, id);
                baseXzqhxx.getXzqhid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The baseXzqhxx with id " + id + " no longer exists.", enfe);
            }
            em.remove(baseXzqhxx);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BaseXzqhxx> findBaseXzqhxxEntities() {
        return findBaseXzqhxxEntities(true, -1, -1);
    }

    public List<BaseXzqhxx> findBaseXzqhxxEntities(int maxResults, int firstResult) {
        return findBaseXzqhxxEntities(false, maxResults, firstResult);
    }

    private List<BaseXzqhxx> findBaseXzqhxxEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BaseXzqhxx.class));
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

    public List<BaseXzqhxx> findBaseXzqhxxEntities(boolean all, int maxResults, int firstResult, String[] op, String[] oq) {
        EntityManager em;
        em = getEntityManager();
        List<Order> orders = new ArrayList<Order>();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            int i = 0;
            for (String p : op) {
                System.out.println(p + ">>>>>" + oq[i]);
                if (oq[i].equalsIgnoreCase("asc")) {
                    orders.add(
                            em.getCriteriaBuilder().asc(cq.from(BaseXzqhxx.class).get(p)));
                }
                if (oq[i].equalsIgnoreCase("desc")) {
                    orders.add(em.getCriteriaBuilder().desc(cq.from(BaseXzqhxx.class).get(p)));
                }
                i++;
            }
            cq.orderBy(orders);
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

    public BaseXzqhxx findBaseXzqhxx(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BaseXzqhxx.class, id);
        } finally {
            em.close();
        }
    }

    public int getBaseXzqhxxCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BaseXzqhxx> rt = cq.from(BaseXzqhxx.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
