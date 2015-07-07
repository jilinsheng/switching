/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.ctrl;

import com.md.ctrl.exceptions.NonexistentEntityException;
import com.md.ctrl.exceptions.PreexistingEntityException;
import com.md.model.VMemberbaseinfo;
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
public class VMemberbaseinfoJpaController implements Serializable {

    public VMemberbaseinfoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VMemberbaseinfo VMemberbaseinfo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(VMemberbaseinfo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVMemberbaseinfo(VMemberbaseinfo.getMemberId()) != null) {
                throw new PreexistingEntityException("VMemberbaseinfo " + VMemberbaseinfo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VMemberbaseinfo VMemberbaseinfo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            VMemberbaseinfo = em.merge(VMemberbaseinfo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = VMemberbaseinfo.getMemberId();
                if (findVMemberbaseinfo(id) == null) {
                    throw new NonexistentEntityException("The vMemberbaseinfo with id " + id + " no longer exists.");
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
            VMemberbaseinfo VMemberbaseinfo;
            try {
                VMemberbaseinfo = em.getReference(VMemberbaseinfo.class, id);
                VMemberbaseinfo.getMemberId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The VMemberbaseinfo with id " + id + " no longer exists.", enfe);
            }
            em.remove(VMemberbaseinfo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<VMemberbaseinfo> findVMemberbaseinfoEntities() {
        return findVMemberbaseinfoEntities(true, -1, -1);
    }

    public List<VMemberbaseinfo> findVMemberbaseinfoEntities(int maxResults, int firstResult) {
        return findVMemberbaseinfoEntities(false, maxResults, firstResult);
    }

    private List<VMemberbaseinfo> findVMemberbaseinfoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VMemberbaseinfo.class));
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

    public VMemberbaseinfo findVMemberbaseinfo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VMemberbaseinfo.class, id);
        } finally {
            em.close();
        }
    }

    public int getVMemberbaseinfoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VMemberbaseinfo> rt = cq.from(VMemberbaseinfo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
