/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.ctrl;

import com.md.ctrl.exceptions.NonexistentEntityException;
import com.md.ctrl.exceptions.PreexistingEntityException;
import com.md.model.shengcs.Family;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.md.model.shengcs.Organno;
import com.md.model.shengcs.Familymember;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Administrator
 */
public class FamilyJpaController implements Serializable {

    public FamilyJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Family family) throws PreexistingEntityException, Exception {
        if (family.getFamilymemberList() == null) {
            family.setFamilymemberList(new ArrayList<Familymember>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Organno onNo = family.getOnNo();
            if (onNo != null) {
                onNo = em.getReference(onNo.getClass(), onNo.getOnNo());
                family.setOnNo(onNo);
            }
            List<Familymember> attachedFamilymemberList = new ArrayList<Familymember>();
            for (Familymember familymemberListFamilymemberToAttach : family.getFamilymemberList()) {
                familymemberListFamilymemberToAttach = em.getReference(familymemberListFamilymemberToAttach.getClass(), familymemberListFamilymemberToAttach.getFmId());
                attachedFamilymemberList.add(familymemberListFamilymemberToAttach);
            }
            family.setFamilymemberList(attachedFamilymemberList);
            em.persist(family);
            if (onNo != null) {
                onNo.getFamilyList().add(family);
                onNo = em.merge(onNo);
            }
            for (Familymember familymemberListFamilymember : family.getFamilymemberList()) {
                Family oldFFamilyidOfFamilymemberListFamilymember = familymemberListFamilymember.getFFamilyid();
                familymemberListFamilymember.setFFamilyid(family);
                familymemberListFamilymember = em.merge(familymemberListFamilymember);
                if (oldFFamilyidOfFamilymemberListFamilymember != null) {
                    oldFFamilyidOfFamilymemberListFamilymember.getFamilymemberList().remove(familymemberListFamilymember);
                    oldFFamilyidOfFamilymemberListFamilymember = em.merge(oldFFamilyidOfFamilymemberListFamilymember);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFamily(family.getFFamilyid()) != null) {
                throw new PreexistingEntityException("Family " + family + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Family family) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Family persistentFamily = em.find(Family.class, family.getFFamilyid());
            Organno onNoOld = persistentFamily.getOnNo();
            Organno onNoNew = family.getOnNo();
            List<Familymember> familymemberListOld = persistentFamily.getFamilymemberList();
            List<Familymember> familymemberListNew = family.getFamilymemberList();
            if (onNoNew != null) {
                onNoNew = em.getReference(onNoNew.getClass(), onNoNew.getOnNo());
                family.setOnNo(onNoNew);
            }
            List<Familymember> attachedFamilymemberListNew = new ArrayList<Familymember>();
            for (Familymember familymemberListNewFamilymemberToAttach : familymemberListNew) {
                familymemberListNewFamilymemberToAttach = em.getReference(familymemberListNewFamilymemberToAttach.getClass(), familymemberListNewFamilymemberToAttach.getFmId());
                attachedFamilymemberListNew.add(familymemberListNewFamilymemberToAttach);
            }
            familymemberListNew = attachedFamilymemberListNew;
            family.setFamilymemberList(familymemberListNew);
            family = em.merge(family);
            if (onNoOld != null && !onNoOld.equals(onNoNew)) {
                onNoOld.getFamilyList().remove(family);
                onNoOld = em.merge(onNoOld);
            }
            if (onNoNew != null && !onNoNew.equals(onNoOld)) {
                onNoNew.getFamilyList().add(family);
                onNoNew = em.merge(onNoNew);
            }
            for (Familymember familymemberListOldFamilymember : familymemberListOld) {
                if (!familymemberListNew.contains(familymemberListOldFamilymember)) {
                    familymemberListOldFamilymember.setFFamilyid(null);
                    familymemberListOldFamilymember = em.merge(familymemberListOldFamilymember);
                }
            }
            for (Familymember familymemberListNewFamilymember : familymemberListNew) {
                if (!familymemberListOld.contains(familymemberListNewFamilymember)) {
                    Family oldFFamilyidOfFamilymemberListNewFamilymember = familymemberListNewFamilymember.getFFamilyid();
                    familymemberListNewFamilymember.setFFamilyid(family);
                    familymemberListNewFamilymember = em.merge(familymemberListNewFamilymember);
                    if (oldFFamilyidOfFamilymemberListNewFamilymember != null && !oldFFamilyidOfFamilymemberListNewFamilymember.equals(family)) {
                        oldFFamilyidOfFamilymemberListNewFamilymember.getFamilymemberList().remove(familymemberListNewFamilymember);
                        oldFFamilyidOfFamilymemberListNewFamilymember = em.merge(oldFFamilyidOfFamilymemberListNewFamilymember);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = family.getFFamilyid();
                if (findFamily(id) == null) {
                    throw new NonexistentEntityException("The family with id " + id + " no longer exists.");
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
            Family family;
            try {
                family = em.getReference(Family.class, id);
                family.getFFamilyid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The family with id " + id + " no longer exists.", enfe);
            }
            Organno onNo = family.getOnNo();
            if (onNo != null) {
                onNo.getFamilyList().remove(family);
                onNo = em.merge(onNo);
            }
            List<Familymember> familymemberList = family.getFamilymemberList();
            for (Familymember familymemberListFamilymember : familymemberList) {
                familymemberListFamilymember.setFFamilyid(null);
                familymemberListFamilymember = em.merge(familymemberListFamilymember);
            }
            em.remove(family);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Family> findFamilyEntities() {
        return findFamilyEntities(true, -1, -1);
    }

    public List<Family> findFamilyEntities(int maxResults, int firstResult) {
        return findFamilyEntities(false, maxResults, firstResult);
    }

    private List<Family> findFamilyEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Family.class));
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

    public Family findFamily(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Family.class, id);
        } finally {
            em.close();
        }
    }

    public int getFamilyCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Family> rt = cq.from(Family.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
