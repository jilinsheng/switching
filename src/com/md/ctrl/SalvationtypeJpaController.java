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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Administrator
 */
public class SalvationtypeJpaController implements Serializable {

    public SalvationtypeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Salvationtype salvationtype) throws PreexistingEntityException, Exception {
        if (salvationtype.getSalvationstatusList() == null) {
            salvationtype.setSalvationstatusList(new ArrayList<Salvationstatus>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Organno onNo = salvationtype.getOnNo();
            if (onNo != null) {
                onNo = em.getReference(onNo.getClass(), onNo.getOnNo());
                salvationtype.setOnNo(onNo);
            }
            List<Salvationstatus> attachedSalvationstatusList = new ArrayList<Salvationstatus>();
            for (Salvationstatus salvationstatusListSalvationstatusToAttach : salvationtype.getSalvationstatusList()) {
                salvationstatusListSalvationstatusToAttach = em.getReference(salvationstatusListSalvationstatusToAttach.getClass(), salvationstatusListSalvationstatusToAttach.getSsId());
                attachedSalvationstatusList.add(salvationstatusListSalvationstatusToAttach);
            }
            salvationtype.setSalvationstatusList(attachedSalvationstatusList);
            em.persist(salvationtype);
            if (onNo != null) {
                onNo.getSalvationtypeList().add(salvationtype);
                onNo = em.merge(onNo);
            }
            for (Salvationstatus salvationstatusListSalvationstatus : salvationtype.getSalvationstatusList()) {
                Salvationtype oldStIdOfSalvationstatusListSalvationstatus = salvationstatusListSalvationstatus.getStId();
                salvationstatusListSalvationstatus.setStId(salvationtype);
                salvationstatusListSalvationstatus = em.merge(salvationstatusListSalvationstatus);
                if (oldStIdOfSalvationstatusListSalvationstatus != null) {
                    oldStIdOfSalvationstatusListSalvationstatus.getSalvationstatusList().remove(salvationstatusListSalvationstatus);
                    oldStIdOfSalvationstatusListSalvationstatus = em.merge(oldStIdOfSalvationstatusListSalvationstatus);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSalvationtype(salvationtype.getStId()) != null) {
                throw new PreexistingEntityException("Salvationtype " + salvationtype + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Salvationtype salvationtype) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Salvationtype persistentSalvationtype = em.find(Salvationtype.class, salvationtype.getStId());
            Organno onNoOld = persistentSalvationtype.getOnNo();
            Organno onNoNew = salvationtype.getOnNo();
            List<Salvationstatus> salvationstatusListOld = persistentSalvationtype.getSalvationstatusList();
            List<Salvationstatus> salvationstatusListNew = salvationtype.getSalvationstatusList();
            if (onNoNew != null) {
                onNoNew = em.getReference(onNoNew.getClass(), onNoNew.getOnNo());
                salvationtype.setOnNo(onNoNew);
            }
            List<Salvationstatus> attachedSalvationstatusListNew = new ArrayList<Salvationstatus>();
            for (Salvationstatus salvationstatusListNewSalvationstatusToAttach : salvationstatusListNew) {
                salvationstatusListNewSalvationstatusToAttach = em.getReference(salvationstatusListNewSalvationstatusToAttach.getClass(), salvationstatusListNewSalvationstatusToAttach.getSsId());
                attachedSalvationstatusListNew.add(salvationstatusListNewSalvationstatusToAttach);
            }
            salvationstatusListNew = attachedSalvationstatusListNew;
            salvationtype.setSalvationstatusList(salvationstatusListNew);
            salvationtype = em.merge(salvationtype);
            if (onNoOld != null && !onNoOld.equals(onNoNew)) {
                onNoOld.getSalvationtypeList().remove(salvationtype);
                onNoOld = em.merge(onNoOld);
            }
            if (onNoNew != null && !onNoNew.equals(onNoOld)) {
                onNoNew.getSalvationtypeList().add(salvationtype);
                onNoNew = em.merge(onNoNew);
            }
            for (Salvationstatus salvationstatusListOldSalvationstatus : salvationstatusListOld) {
                if (!salvationstatusListNew.contains(salvationstatusListOldSalvationstatus)) {
                    salvationstatusListOldSalvationstatus.setStId(null);
                    salvationstatusListOldSalvationstatus = em.merge(salvationstatusListOldSalvationstatus);
                }
            }
            for (Salvationstatus salvationstatusListNewSalvationstatus : salvationstatusListNew) {
                if (!salvationstatusListOld.contains(salvationstatusListNewSalvationstatus)) {
                    Salvationtype oldStIdOfSalvationstatusListNewSalvationstatus = salvationstatusListNewSalvationstatus.getStId();
                    salvationstatusListNewSalvationstatus.setStId(salvationtype);
                    salvationstatusListNewSalvationstatus = em.merge(salvationstatusListNewSalvationstatus);
                    if (oldStIdOfSalvationstatusListNewSalvationstatus != null && !oldStIdOfSalvationstatusListNewSalvationstatus.equals(salvationtype)) {
                        oldStIdOfSalvationstatusListNewSalvationstatus.getSalvationstatusList().remove(salvationstatusListNewSalvationstatus);
                        oldStIdOfSalvationstatusListNewSalvationstatus = em.merge(oldStIdOfSalvationstatusListNewSalvationstatus);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = salvationtype.getStId();
                if (findSalvationtype(id) == null) {
                    throw new NonexistentEntityException("The salvationtype with id " + id + " no longer exists.");
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
            Salvationtype salvationtype;
            try {
                salvationtype = em.getReference(Salvationtype.class, id);
                salvationtype.getStId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The salvationtype with id " + id + " no longer exists.", enfe);
            }
            Organno onNo = salvationtype.getOnNo();
            if (onNo != null) {
                onNo.getSalvationtypeList().remove(salvationtype);
                onNo = em.merge(onNo);
            }
            List<Salvationstatus> salvationstatusList = salvationtype.getSalvationstatusList();
            for (Salvationstatus salvationstatusListSalvationstatus : salvationstatusList) {
                salvationstatusListSalvationstatus.setStId(null);
                salvationstatusListSalvationstatus = em.merge(salvationstatusListSalvationstatus);
            }
            em.remove(salvationtype);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Salvationtype> findSalvationtypeEntities() {
        return findSalvationtypeEntities(true, -1, -1);
    }

    public List<Salvationtype> findSalvationtypeEntities(int maxResults, int firstResult) {
        return findSalvationtypeEntities(false, maxResults, firstResult);
    }

    private List<Salvationtype> findSalvationtypeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Salvationtype.class));
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

    public Salvationtype findSalvationtype(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Salvationtype.class, id);
        } finally {
            em.close();
        }
    }

    public int getSalvationtypeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Salvationtype> rt = cq.from(Salvationtype.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
