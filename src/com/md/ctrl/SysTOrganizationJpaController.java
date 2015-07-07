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
import com.md.model.shengnc.InfoTFamily;
import java.util.HashSet;
import java.util.Set;
import com.md.model.shengnc.BizTOptacc;
import com.md.model.shengnc.SysTOrganization;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Administrator
 */
public class SysTOrganizationJpaController implements Serializable {

    public SysTOrganizationJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SysTOrganization sysTOrganization) throws PreexistingEntityException, Exception {
        if (sysTOrganization.getInfoTFamilySet() == null) {
            sysTOrganization.setInfoTFamilySet(new HashSet<InfoTFamily>());
        }
        if (sysTOrganization.getBizTOptaccSet() == null) {
            sysTOrganization.setBizTOptaccSet(new HashSet<BizTOptacc>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Set<InfoTFamily> attachedInfoTFamilySet = new HashSet<InfoTFamily>();
            for (InfoTFamily infoTFamilySetInfoTFamilyToAttach : sysTOrganization.getInfoTFamilySet()) {
                infoTFamilySetInfoTFamilyToAttach = em.getReference(infoTFamilySetInfoTFamilyToAttach.getClass(), infoTFamilySetInfoTFamilyToAttach.getFamilyId());
                attachedInfoTFamilySet.add(infoTFamilySetInfoTFamilyToAttach);
            }
            sysTOrganization.setInfoTFamilySet(attachedInfoTFamilySet);
            Set<BizTOptacc> attachedBizTOptaccSet = new HashSet<BizTOptacc>();
            for (BizTOptacc bizTOptaccSetBizTOptaccToAttach : sysTOrganization.getBizTOptaccSet()) {
                bizTOptaccSetBizTOptaccToAttach = em.getReference(bizTOptaccSetBizTOptaccToAttach.getClass(), bizTOptaccSetBizTOptaccToAttach.getOptaccId());
                attachedBizTOptaccSet.add(bizTOptaccSetBizTOptaccToAttach);
            }
            sysTOrganization.setBizTOptaccSet(attachedBizTOptaccSet);
            em.persist(sysTOrganization);
            for (InfoTFamily infoTFamilySetInfoTFamily : sysTOrganization.getInfoTFamilySet()) {
                SysTOrganization oldOrganizationIdOfInfoTFamilySetInfoTFamily = infoTFamilySetInfoTFamily.getOrganizationId();
                infoTFamilySetInfoTFamily.setOrganizationId(sysTOrganization);
                infoTFamilySetInfoTFamily = em.merge(infoTFamilySetInfoTFamily);
                if (oldOrganizationIdOfInfoTFamilySetInfoTFamily != null) {
                    oldOrganizationIdOfInfoTFamilySetInfoTFamily.getInfoTFamilySet().remove(infoTFamilySetInfoTFamily);
                    oldOrganizationIdOfInfoTFamilySetInfoTFamily = em.merge(oldOrganizationIdOfInfoTFamilySetInfoTFamily);
                }
            }
            for (BizTOptacc bizTOptaccSetBizTOptacc : sysTOrganization.getBizTOptaccSet()) {
                SysTOrganization oldOrganizationIdOfBizTOptaccSetBizTOptacc = bizTOptaccSetBizTOptacc.getOrganizationId();
                bizTOptaccSetBizTOptacc.setOrganizationId(sysTOrganization);
                bizTOptaccSetBizTOptacc = em.merge(bizTOptaccSetBizTOptacc);
                if (oldOrganizationIdOfBizTOptaccSetBizTOptacc != null) {
                    oldOrganizationIdOfBizTOptaccSetBizTOptacc.getBizTOptaccSet().remove(bizTOptaccSetBizTOptacc);
                    oldOrganizationIdOfBizTOptaccSetBizTOptacc = em.merge(oldOrganizationIdOfBizTOptaccSetBizTOptacc);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSysTOrganization(sysTOrganization.getOrganizationId()) != null) {
                throw new PreexistingEntityException("SysTOrganization " + sysTOrganization + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SysTOrganization sysTOrganization) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SysTOrganization persistentSysTOrganization = em.find(SysTOrganization.class, sysTOrganization.getOrganizationId());
            Set<InfoTFamily> infoTFamilySetOld = persistentSysTOrganization.getInfoTFamilySet();
            Set<InfoTFamily> infoTFamilySetNew = sysTOrganization.getInfoTFamilySet();
            Set<BizTOptacc> bizTOptaccSetOld = persistentSysTOrganization.getBizTOptaccSet();
            Set<BizTOptacc> bizTOptaccSetNew = sysTOrganization.getBizTOptaccSet();
            Set<InfoTFamily> attachedInfoTFamilySetNew = new HashSet<InfoTFamily>();
            for (InfoTFamily infoTFamilySetNewInfoTFamilyToAttach : infoTFamilySetNew) {
                infoTFamilySetNewInfoTFamilyToAttach = em.getReference(infoTFamilySetNewInfoTFamilyToAttach.getClass(), infoTFamilySetNewInfoTFamilyToAttach.getFamilyId());
                attachedInfoTFamilySetNew.add(infoTFamilySetNewInfoTFamilyToAttach);
            }
            infoTFamilySetNew = attachedInfoTFamilySetNew;
            sysTOrganization.setInfoTFamilySet(infoTFamilySetNew);
            Set<BizTOptacc> attachedBizTOptaccSetNew = new HashSet<BizTOptacc>();
            for (BizTOptacc bizTOptaccSetNewBizTOptaccToAttach : bizTOptaccSetNew) {
                bizTOptaccSetNewBizTOptaccToAttach = em.getReference(bizTOptaccSetNewBizTOptaccToAttach.getClass(), bizTOptaccSetNewBizTOptaccToAttach.getOptaccId());
                attachedBizTOptaccSetNew.add(bizTOptaccSetNewBizTOptaccToAttach);
            }
            bizTOptaccSetNew = attachedBizTOptaccSetNew;
            sysTOrganization.setBizTOptaccSet(bizTOptaccSetNew);
            sysTOrganization = em.merge(sysTOrganization);
            for (InfoTFamily infoTFamilySetOldInfoTFamily : infoTFamilySetOld) {
                if (!infoTFamilySetNew.contains(infoTFamilySetOldInfoTFamily)) {
                    infoTFamilySetOldInfoTFamily.setOrganizationId(null);
                    infoTFamilySetOldInfoTFamily = em.merge(infoTFamilySetOldInfoTFamily);
                }
            }
            for (InfoTFamily infoTFamilySetNewInfoTFamily : infoTFamilySetNew) {
                if (!infoTFamilySetOld.contains(infoTFamilySetNewInfoTFamily)) {
                    SysTOrganization oldOrganizationIdOfInfoTFamilySetNewInfoTFamily = infoTFamilySetNewInfoTFamily.getOrganizationId();
                    infoTFamilySetNewInfoTFamily.setOrganizationId(sysTOrganization);
                    infoTFamilySetNewInfoTFamily = em.merge(infoTFamilySetNewInfoTFamily);
                    if (oldOrganizationIdOfInfoTFamilySetNewInfoTFamily != null && !oldOrganizationIdOfInfoTFamilySetNewInfoTFamily.equals(sysTOrganization)) {
                        oldOrganizationIdOfInfoTFamilySetNewInfoTFamily.getInfoTFamilySet().remove(infoTFamilySetNewInfoTFamily);
                        oldOrganizationIdOfInfoTFamilySetNewInfoTFamily = em.merge(oldOrganizationIdOfInfoTFamilySetNewInfoTFamily);
                    }
                }
            }
            for (BizTOptacc bizTOptaccSetOldBizTOptacc : bizTOptaccSetOld) {
                if (!bizTOptaccSetNew.contains(bizTOptaccSetOldBizTOptacc)) {
                    bizTOptaccSetOldBizTOptacc.setOrganizationId(null);
                    bizTOptaccSetOldBizTOptacc = em.merge(bizTOptaccSetOldBizTOptacc);
                }
            }
            for (BizTOptacc bizTOptaccSetNewBizTOptacc : bizTOptaccSetNew) {
                if (!bizTOptaccSetOld.contains(bizTOptaccSetNewBizTOptacc)) {
                    SysTOrganization oldOrganizationIdOfBizTOptaccSetNewBizTOptacc = bizTOptaccSetNewBizTOptacc.getOrganizationId();
                    bizTOptaccSetNewBizTOptacc.setOrganizationId(sysTOrganization);
                    bizTOptaccSetNewBizTOptacc = em.merge(bizTOptaccSetNewBizTOptacc);
                    if (oldOrganizationIdOfBizTOptaccSetNewBizTOptacc != null && !oldOrganizationIdOfBizTOptaccSetNewBizTOptacc.equals(sysTOrganization)) {
                        oldOrganizationIdOfBizTOptaccSetNewBizTOptacc.getBizTOptaccSet().remove(bizTOptaccSetNewBizTOptacc);
                        oldOrganizationIdOfBizTOptaccSetNewBizTOptacc = em.merge(oldOrganizationIdOfBizTOptaccSetNewBizTOptacc);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = sysTOrganization.getOrganizationId();
                if (findSysTOrganization(id) == null) {
                    throw new NonexistentEntityException("The sysTOrganization with id " + id + " no longer exists.");
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
            SysTOrganization sysTOrganization;
            try {
                sysTOrganization = em.getReference(SysTOrganization.class, id);
                sysTOrganization.getOrganizationId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sysTOrganization with id " + id + " no longer exists.", enfe);
            }
            Set<InfoTFamily> infoTFamilySet = sysTOrganization.getInfoTFamilySet();
            for (InfoTFamily infoTFamilySetInfoTFamily : infoTFamilySet) {
                infoTFamilySetInfoTFamily.setOrganizationId(null);
                infoTFamilySetInfoTFamily = em.merge(infoTFamilySetInfoTFamily);
            }
            Set<BizTOptacc> bizTOptaccSet = sysTOrganization.getBizTOptaccSet();
            for (BizTOptacc bizTOptaccSetBizTOptacc : bizTOptaccSet) {
                bizTOptaccSetBizTOptacc.setOrganizationId(null);
                bizTOptaccSetBizTOptacc = em.merge(bizTOptaccSetBizTOptacc);
            }
            em.remove(sysTOrganization);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SysTOrganization> findSysTOrganizationEntities() {
        return findSysTOrganizationEntities(true, -1, -1);
    }

    public List<SysTOrganization> findSysTOrganizationEntities(int maxResults, int firstResult) {
        return findSysTOrganizationEntities(false, maxResults, firstResult);
    }

    private List<SysTOrganization> findSysTOrganizationEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SysTOrganization.class));
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

    public SysTOrganization findSysTOrganization(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SysTOrganization.class, id);
        } finally {
            em.close();
        }
    }

    public int getSysTOrganizationCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SysTOrganization> rt = cq.from(SysTOrganization.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
