/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.ctrl;

import com.md.ctrl.exceptions.IllegalOrphanException;
import com.md.ctrl.exceptions.NonexistentEntityException;
import com.md.ctrl.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.md.model.shengcs.Salvationtype;
import java.util.ArrayList;
import java.util.List;
import com.md.model.shengcs.Salvationstatus;
import com.md.model.shengcs.Family;
import com.md.model.shengcs.Organno;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Administrator
 */
public class OrgannoJpaController implements Serializable {

    public OrgannoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Organno organno) throws PreexistingEntityException, Exception {
        if (organno.getSalvationtypeList() == null) {
            organno.setSalvationtypeList(new ArrayList<Salvationtype>());
        }
        if (organno.getSalvationstatusList() == null) {
            organno.setSalvationstatusList(new ArrayList<Salvationstatus>());
        }
        if (organno.getFamilyList() == null) {
            organno.setFamilyList(new ArrayList<Family>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Salvationtype> attachedSalvationtypeList = new ArrayList<Salvationtype>();
            for (Salvationtype salvationtypeListSalvationtypeToAttach : organno.getSalvationtypeList()) {
                salvationtypeListSalvationtypeToAttach = em.getReference(salvationtypeListSalvationtypeToAttach.getClass(), salvationtypeListSalvationtypeToAttach.getStId());
                attachedSalvationtypeList.add(salvationtypeListSalvationtypeToAttach);
            }
            organno.setSalvationtypeList(attachedSalvationtypeList);
            List<Salvationstatus> attachedSalvationstatusList = new ArrayList<Salvationstatus>();
            for (Salvationstatus salvationstatusListSalvationstatusToAttach : organno.getSalvationstatusList()) {
                salvationstatusListSalvationstatusToAttach = em.getReference(salvationstatusListSalvationstatusToAttach.getClass(), salvationstatusListSalvationstatusToAttach.getSsId());
                attachedSalvationstatusList.add(salvationstatusListSalvationstatusToAttach);
            }
            organno.setSalvationstatusList(attachedSalvationstatusList);
            List<Family> attachedFamilyList = new ArrayList<Family>();
            for (Family familyListFamilyToAttach : organno.getFamilyList()) {
                familyListFamilyToAttach = em.getReference(familyListFamilyToAttach.getClass(), familyListFamilyToAttach.getFFamilyid());
                attachedFamilyList.add(familyListFamilyToAttach);
            }
            organno.setFamilyList(attachedFamilyList);
            em.persist(organno);
            for (Salvationtype salvationtypeListSalvationtype : organno.getSalvationtypeList()) {
                Organno oldOnNoOfSalvationtypeListSalvationtype = salvationtypeListSalvationtype.getOnNo();
                salvationtypeListSalvationtype.setOnNo(organno);
                salvationtypeListSalvationtype = em.merge(salvationtypeListSalvationtype);
                if (oldOnNoOfSalvationtypeListSalvationtype != null) {
                    oldOnNoOfSalvationtypeListSalvationtype.getSalvationtypeList().remove(salvationtypeListSalvationtype);
                    oldOnNoOfSalvationtypeListSalvationtype = em.merge(oldOnNoOfSalvationtypeListSalvationtype);
                }
            }
            for (Salvationstatus salvationstatusListSalvationstatus : organno.getSalvationstatusList()) {
                Organno oldOnNoOfSalvationstatusListSalvationstatus = salvationstatusListSalvationstatus.getOnNo();
                salvationstatusListSalvationstatus.setOnNo(organno);
                salvationstatusListSalvationstatus = em.merge(salvationstatusListSalvationstatus);
                if (oldOnNoOfSalvationstatusListSalvationstatus != null) {
                    oldOnNoOfSalvationstatusListSalvationstatus.getSalvationstatusList().remove(salvationstatusListSalvationstatus);
                    oldOnNoOfSalvationstatusListSalvationstatus = em.merge(oldOnNoOfSalvationstatusListSalvationstatus);
                }
            }
            for (Family familyListFamily : organno.getFamilyList()) {
                Organno oldOnNoOfFamilyListFamily = familyListFamily.getOnNo();
                familyListFamily.setOnNo(organno);
                familyListFamily = em.merge(familyListFamily);
                if (oldOnNoOfFamilyListFamily != null) {
                    oldOnNoOfFamilyListFamily.getFamilyList().remove(familyListFamily);
                    oldOnNoOfFamilyListFamily = em.merge(oldOnNoOfFamilyListFamily);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOrganno(organno.getOnNo()) != null) {
                throw new PreexistingEntityException("Organno " + organno + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Organno organno) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Organno persistentOrganno = em.find(Organno.class, organno.getOnNo());
            List<Salvationtype> salvationtypeListOld = persistentOrganno.getSalvationtypeList();
            List<Salvationtype> salvationtypeListNew = organno.getSalvationtypeList();
            List<Salvationstatus> salvationstatusListOld = persistentOrganno.getSalvationstatusList();
            List<Salvationstatus> salvationstatusListNew = organno.getSalvationstatusList();
            List<Family> familyListOld = persistentOrganno.getFamilyList();
            List<Family> familyListNew = organno.getFamilyList();
            List<String> illegalOrphanMessages = null;
            for (Salvationstatus salvationstatusListOldSalvationstatus : salvationstatusListOld) {
                if (!salvationstatusListNew.contains(salvationstatusListOldSalvationstatus)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Salvationstatus " + salvationstatusListOldSalvationstatus + " since its onNo field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Salvationtype> attachedSalvationtypeListNew = new ArrayList<Salvationtype>();
            for (Salvationtype salvationtypeListNewSalvationtypeToAttach : salvationtypeListNew) {
                salvationtypeListNewSalvationtypeToAttach = em.getReference(salvationtypeListNewSalvationtypeToAttach.getClass(), salvationtypeListNewSalvationtypeToAttach.getStId());
                attachedSalvationtypeListNew.add(salvationtypeListNewSalvationtypeToAttach);
            }
            salvationtypeListNew = attachedSalvationtypeListNew;
            organno.setSalvationtypeList(salvationtypeListNew);
            List<Salvationstatus> attachedSalvationstatusListNew = new ArrayList<Salvationstatus>();
            for (Salvationstatus salvationstatusListNewSalvationstatusToAttach : salvationstatusListNew) {
                salvationstatusListNewSalvationstatusToAttach = em.getReference(salvationstatusListNewSalvationstatusToAttach.getClass(), salvationstatusListNewSalvationstatusToAttach.getSsId());
                attachedSalvationstatusListNew.add(salvationstatusListNewSalvationstatusToAttach);
            }
            salvationstatusListNew = attachedSalvationstatusListNew;
            organno.setSalvationstatusList(salvationstatusListNew);
            List<Family> attachedFamilyListNew = new ArrayList<Family>();
            for (Family familyListNewFamilyToAttach : familyListNew) {
                familyListNewFamilyToAttach = em.getReference(familyListNewFamilyToAttach.getClass(), familyListNewFamilyToAttach.getFFamilyid());
                attachedFamilyListNew.add(familyListNewFamilyToAttach);
            }
            familyListNew = attachedFamilyListNew;
            organno.setFamilyList(familyListNew);
            organno = em.merge(organno);
            for (Salvationtype salvationtypeListOldSalvationtype : salvationtypeListOld) {
                if (!salvationtypeListNew.contains(salvationtypeListOldSalvationtype)) {
                    salvationtypeListOldSalvationtype.setOnNo(null);
                    salvationtypeListOldSalvationtype = em.merge(salvationtypeListOldSalvationtype);
                }
            }
            for (Salvationtype salvationtypeListNewSalvationtype : salvationtypeListNew) {
                if (!salvationtypeListOld.contains(salvationtypeListNewSalvationtype)) {
                    Organno oldOnNoOfSalvationtypeListNewSalvationtype = salvationtypeListNewSalvationtype.getOnNo();
                    salvationtypeListNewSalvationtype.setOnNo(organno);
                    salvationtypeListNewSalvationtype = em.merge(salvationtypeListNewSalvationtype);
                    if (oldOnNoOfSalvationtypeListNewSalvationtype != null && !oldOnNoOfSalvationtypeListNewSalvationtype.equals(organno)) {
                        oldOnNoOfSalvationtypeListNewSalvationtype.getSalvationtypeList().remove(salvationtypeListNewSalvationtype);
                        oldOnNoOfSalvationtypeListNewSalvationtype = em.merge(oldOnNoOfSalvationtypeListNewSalvationtype);
                    }
                }
            }
            for (Salvationstatus salvationstatusListNewSalvationstatus : salvationstatusListNew) {
                if (!salvationstatusListOld.contains(salvationstatusListNewSalvationstatus)) {
                    Organno oldOnNoOfSalvationstatusListNewSalvationstatus = salvationstatusListNewSalvationstatus.getOnNo();
                    salvationstatusListNewSalvationstatus.setOnNo(organno);
                    salvationstatusListNewSalvationstatus = em.merge(salvationstatusListNewSalvationstatus);
                    if (oldOnNoOfSalvationstatusListNewSalvationstatus != null && !oldOnNoOfSalvationstatusListNewSalvationstatus.equals(organno)) {
                        oldOnNoOfSalvationstatusListNewSalvationstatus.getSalvationstatusList().remove(salvationstatusListNewSalvationstatus);
                        oldOnNoOfSalvationstatusListNewSalvationstatus = em.merge(oldOnNoOfSalvationstatusListNewSalvationstatus);
                    }
                }
            }
            for (Family familyListOldFamily : familyListOld) {
                if (!familyListNew.contains(familyListOldFamily)) {
                    familyListOldFamily.setOnNo(null);
                    familyListOldFamily = em.merge(familyListOldFamily);
                }
            }
            for (Family familyListNewFamily : familyListNew) {
                if (!familyListOld.contains(familyListNewFamily)) {
                    Organno oldOnNoOfFamilyListNewFamily = familyListNewFamily.getOnNo();
                    familyListNewFamily.setOnNo(organno);
                    familyListNewFamily = em.merge(familyListNewFamily);
                    if (oldOnNoOfFamilyListNewFamily != null && !oldOnNoOfFamilyListNewFamily.equals(organno)) {
                        oldOnNoOfFamilyListNewFamily.getFamilyList().remove(familyListNewFamily);
                        oldOnNoOfFamilyListNewFamily = em.merge(oldOnNoOfFamilyListNewFamily);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = organno.getOnNo();
                if (findOrganno(id) == null) {
                    throw new NonexistentEntityException("The organno with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Organno organno;
            try {
                organno = em.getReference(Organno.class, id);
                organno.getOnNo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The organno with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Salvationstatus> salvationstatusListOrphanCheck = organno.getSalvationstatusList();
            for (Salvationstatus salvationstatusListOrphanCheckSalvationstatus : salvationstatusListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Organno (" + organno + ") cannot be destroyed since the Salvationstatus " + salvationstatusListOrphanCheckSalvationstatus + " in its salvationstatusList field has a non-nullable onNo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Salvationtype> salvationtypeList = organno.getSalvationtypeList();
            for (Salvationtype salvationtypeListSalvationtype : salvationtypeList) {
                salvationtypeListSalvationtype.setOnNo(null);
                salvationtypeListSalvationtype = em.merge(salvationtypeListSalvationtype);
            }
            List<Family> familyList = organno.getFamilyList();
            for (Family familyListFamily : familyList) {
                familyListFamily.setOnNo(null);
                familyListFamily = em.merge(familyListFamily);
            }
            em.remove(organno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Organno> findOrgannoEntities() {
        return findOrgannoEntities(true, -1, -1);
    }

    public List<Organno> findOrgannoEntities(int maxResults, int firstResult) {
        return findOrgannoEntities(false, maxResults, firstResult);
    }

    private List<Organno> findOrgannoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Organno.class));
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

    public Organno findOrganno(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Organno.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrgannoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Organno> rt = cq.from(Organno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
