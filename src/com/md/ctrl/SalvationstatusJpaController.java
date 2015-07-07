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
import com.md.model.shengcs.Organno;
import com.md.model.shengcs.Salvationstatus;
import com.md.model.shengcs.Salvationtype;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Administrator
 */
public class SalvationstatusJpaController implements Serializable {

    public SalvationstatusJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Salvationstatus salvationstatus) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Organno onNo = salvationstatus.getOnNo();
            if (onNo != null) {
                onNo = em.getReference(onNo.getClass(), onNo.getOnNo());
                salvationstatus.setOnNo(onNo);
            }
            Salvationtype stId = salvationstatus.getStId();
            if (stId != null) {
                stId = em.getReference(stId.getClass(), stId.getStId());
                salvationstatus.setStId(stId);
            }
            em.persist(salvationstatus);
            if (onNo != null) {
                onNo.getSalvationstatusList().add(salvationstatus);
                onNo = em.merge(onNo);
            }
            if (stId != null) {
                stId.getSalvationstatusList().add(salvationstatus);
                stId = em.merge(stId);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSalvationstatus(salvationstatus.getSsId()) != null) {
                throw new PreexistingEntityException("Salvationstatus " + salvationstatus + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Salvationstatus salvationstatus) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Salvationstatus persistentSalvationstatus = em.find(Salvationstatus.class, salvationstatus.getSsId());
            Organno onNoOld = persistentSalvationstatus.getOnNo();
            Organno onNoNew = salvationstatus.getOnNo();
            Salvationtype stIdOld = persistentSalvationstatus.getStId();
            Salvationtype stIdNew = salvationstatus.getStId();
            if (onNoNew != null) {
                onNoNew = em.getReference(onNoNew.getClass(), onNoNew.getOnNo());
                salvationstatus.setOnNo(onNoNew);
            }
            if (stIdNew != null) {
                stIdNew = em.getReference(stIdNew.getClass(), stIdNew.getStId());
                salvationstatus.setStId(stIdNew);
            }
            salvationstatus = em.merge(salvationstatus);
            if (onNoOld != null && !onNoOld.equals(onNoNew)) {
                onNoOld.getSalvationstatusList().remove(salvationstatus);
                onNoOld = em.merge(onNoOld);
            }
            if (onNoNew != null && !onNoNew.equals(onNoOld)) {
                onNoNew.getSalvationstatusList().add(salvationstatus);
                onNoNew = em.merge(onNoNew);
            }
            if (stIdOld != null && !stIdOld.equals(stIdNew)) {
                stIdOld.getSalvationstatusList().remove(salvationstatus);
                stIdOld = em.merge(stIdOld);
            }
            if (stIdNew != null && !stIdNew.equals(stIdOld)) {
                stIdNew.getSalvationstatusList().add(salvationstatus);
                stIdNew = em.merge(stIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = salvationstatus.getSsId();
                if (findSalvationstatus(id) == null) {
                    throw new NonexistentEntityException("The salvationstatus with id " + id + " no longer exists.");
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
            Salvationstatus salvationstatus;
            try {
                salvationstatus = em.getReference(Salvationstatus.class, id);
                salvationstatus.getSsId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The salvationstatus with id " + id + " no longer exists.", enfe);
            }
            Organno onNo = salvationstatus.getOnNo();
            if (onNo != null) {
                onNo.getSalvationstatusList().remove(salvationstatus);
                onNo = em.merge(onNo);
            }
            Salvationtype stId = salvationstatus.getStId();
            if (stId != null) {
                stId.getSalvationstatusList().remove(salvationstatus);
                stId = em.merge(stId);
            }
            em.remove(salvationstatus);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Salvationstatus> findSalvationstatusEntities() {
        return findSalvationstatusEntities(true, -1, -1);
    }

    public List<Salvationstatus> findSalvationstatusEntities(int maxResults, int firstResult) {
        return findSalvationstatusEntities(false, maxResults, firstResult);
    }

    private List<Salvationstatus> findSalvationstatusEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Salvationstatus.class));
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

    public Salvationstatus findSalvationstatus(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Salvationstatus.class, id);
        } finally {
            em.close();
        }
    }

    public int getSalvationstatusCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Salvationstatus> rt = cq.from(Salvationstatus.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
