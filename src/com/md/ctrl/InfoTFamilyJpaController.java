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
import com.md.model.shengnc.SysTOrganization;
import com.md.model.shengnc.InfoTMember;
import java.util.HashSet;
import java.util.Set;
import com.md.model.shengnc.BizTOptcheck;
import com.md.model.shengnc.InfoTFamily;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Administrator
 */
public class InfoTFamilyJpaController implements Serializable {

    public InfoTFamilyJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(InfoTFamily infoTFamily) throws PreexistingEntityException, Exception {
        if (infoTFamily.getInfoTMemberSet() == null) {
            infoTFamily.setInfoTMemberSet(new HashSet<InfoTMember>());
        }
        if (infoTFamily.getBizTOptcheckSet() == null) {
            infoTFamily.setBizTOptcheckSet(new HashSet<BizTOptcheck>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SysTOrganization organizationId = infoTFamily.getOrganizationId();
            if (organizationId != null) {
                organizationId = em.getReference(organizationId.getClass(), organizationId.getOrganizationId());
                infoTFamily.setOrganizationId(organizationId);
            }
            Set<InfoTMember> attachedInfoTMemberSet = new HashSet<InfoTMember>();
            for (InfoTMember infoTMemberSetInfoTMemberToAttach : infoTFamily.getInfoTMemberSet()) {
                infoTMemberSetInfoTMemberToAttach = em.getReference(infoTMemberSetInfoTMemberToAttach.getClass(), infoTMemberSetInfoTMemberToAttach.getMemberId());
                attachedInfoTMemberSet.add(infoTMemberSetInfoTMemberToAttach);
            }
            infoTFamily.setInfoTMemberSet(attachedInfoTMemberSet);
            Set<BizTOptcheck> attachedBizTOptcheckSet = new HashSet<BizTOptcheck>();
            for (BizTOptcheck bizTOptcheckSetBizTOptcheckToAttach : infoTFamily.getBizTOptcheckSet()) {
                bizTOptcheckSetBizTOptcheckToAttach = em.getReference(bizTOptcheckSetBizTOptcheckToAttach.getClass(), bizTOptcheckSetBizTOptcheckToAttach.getOptcheckId());
                attachedBizTOptcheckSet.add(bizTOptcheckSetBizTOptcheckToAttach);
            }
            infoTFamily.setBizTOptcheckSet(attachedBizTOptcheckSet);
            em.persist(infoTFamily);
            if (organizationId != null) {
                organizationId.getInfoTFamilySet().add(infoTFamily);
                organizationId = em.merge(organizationId);
            }
            for (InfoTMember infoTMemberSetInfoTMember : infoTFamily.getInfoTMemberSet()) {
                InfoTFamily oldFamilyIdOfInfoTMemberSetInfoTMember = infoTMemberSetInfoTMember.getFamilyId();
                infoTMemberSetInfoTMember.setFamilyId(infoTFamily);
                infoTMemberSetInfoTMember = em.merge(infoTMemberSetInfoTMember);
                if (oldFamilyIdOfInfoTMemberSetInfoTMember != null) {
                    oldFamilyIdOfInfoTMemberSetInfoTMember.getInfoTMemberSet().remove(infoTMemberSetInfoTMember);
                    oldFamilyIdOfInfoTMemberSetInfoTMember = em.merge(oldFamilyIdOfInfoTMemberSetInfoTMember);
                }
            }
            for (BizTOptcheck bizTOptcheckSetBizTOptcheck : infoTFamily.getBizTOptcheckSet()) {
                InfoTFamily oldFamilyIdOfBizTOptcheckSetBizTOptcheck = bizTOptcheckSetBizTOptcheck.getFamilyId();
                bizTOptcheckSetBizTOptcheck.setFamilyId(infoTFamily);
                bizTOptcheckSetBizTOptcheck = em.merge(bizTOptcheckSetBizTOptcheck);
                if (oldFamilyIdOfBizTOptcheckSetBizTOptcheck != null) {
                    oldFamilyIdOfBizTOptcheckSetBizTOptcheck.getBizTOptcheckSet().remove(bizTOptcheckSetBizTOptcheck);
                    oldFamilyIdOfBizTOptcheckSetBizTOptcheck = em.merge(oldFamilyIdOfBizTOptcheckSetBizTOptcheck);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findInfoTFamily(infoTFamily.getFamilyId()) != null) {
                throw new PreexistingEntityException("InfoTFamily " + infoTFamily + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(InfoTFamily infoTFamily) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            InfoTFamily persistentInfoTFamily = em.find(InfoTFamily.class, infoTFamily.getFamilyId());
            SysTOrganization organizationIdOld = persistentInfoTFamily.getOrganizationId();
            SysTOrganization organizationIdNew = infoTFamily.getOrganizationId();
            Set<InfoTMember> infoTMemberSetOld = persistentInfoTFamily.getInfoTMemberSet();
            Set<InfoTMember> infoTMemberSetNew = infoTFamily.getInfoTMemberSet();
            Set<BizTOptcheck> bizTOptcheckSetOld = persistentInfoTFamily.getBizTOptcheckSet();
            Set<BizTOptcheck> bizTOptcheckSetNew = infoTFamily.getBizTOptcheckSet();
            if (organizationIdNew != null) {
                organizationIdNew = em.getReference(organizationIdNew.getClass(), organizationIdNew.getOrganizationId());
                infoTFamily.setOrganizationId(organizationIdNew);
            }
            Set<InfoTMember> attachedInfoTMemberSetNew = new HashSet<InfoTMember>();
            for (InfoTMember infoTMemberSetNewInfoTMemberToAttach : infoTMemberSetNew) {
                infoTMemberSetNewInfoTMemberToAttach = em.getReference(infoTMemberSetNewInfoTMemberToAttach.getClass(), infoTMemberSetNewInfoTMemberToAttach.getMemberId());
                attachedInfoTMemberSetNew.add(infoTMemberSetNewInfoTMemberToAttach);
            }
            infoTMemberSetNew = attachedInfoTMemberSetNew;
            infoTFamily.setInfoTMemberSet(infoTMemberSetNew);
            Set<BizTOptcheck> attachedBizTOptcheckSetNew = new HashSet<BizTOptcheck>();
            for (BizTOptcheck bizTOptcheckSetNewBizTOptcheckToAttach : bizTOptcheckSetNew) {
                bizTOptcheckSetNewBizTOptcheckToAttach = em.getReference(bizTOptcheckSetNewBizTOptcheckToAttach.getClass(), bizTOptcheckSetNewBizTOptcheckToAttach.getOptcheckId());
                attachedBizTOptcheckSetNew.add(bizTOptcheckSetNewBizTOptcheckToAttach);
            }
            bizTOptcheckSetNew = attachedBizTOptcheckSetNew;
            infoTFamily.setBizTOptcheckSet(bizTOptcheckSetNew);
            infoTFamily = em.merge(infoTFamily);
            if (organizationIdOld != null && !organizationIdOld.equals(organizationIdNew)) {
                organizationIdOld.getInfoTFamilySet().remove(infoTFamily);
                organizationIdOld = em.merge(organizationIdOld);
            }
            if (organizationIdNew != null && !organizationIdNew.equals(organizationIdOld)) {
                organizationIdNew.getInfoTFamilySet().add(infoTFamily);
                organizationIdNew = em.merge(organizationIdNew);
            }
            for (InfoTMember infoTMemberSetOldInfoTMember : infoTMemberSetOld) {
                if (!infoTMemberSetNew.contains(infoTMemberSetOldInfoTMember)) {
                    infoTMemberSetOldInfoTMember.setFamilyId(null);
                    infoTMemberSetOldInfoTMember = em.merge(infoTMemberSetOldInfoTMember);
                }
            }
            for (InfoTMember infoTMemberSetNewInfoTMember : infoTMemberSetNew) {
                if (!infoTMemberSetOld.contains(infoTMemberSetNewInfoTMember)) {
                    InfoTFamily oldFamilyIdOfInfoTMemberSetNewInfoTMember = infoTMemberSetNewInfoTMember.getFamilyId();
                    infoTMemberSetNewInfoTMember.setFamilyId(infoTFamily);
                    infoTMemberSetNewInfoTMember = em.merge(infoTMemberSetNewInfoTMember);
                    if (oldFamilyIdOfInfoTMemberSetNewInfoTMember != null && !oldFamilyIdOfInfoTMemberSetNewInfoTMember.equals(infoTFamily)) {
                        oldFamilyIdOfInfoTMemberSetNewInfoTMember.getInfoTMemberSet().remove(infoTMemberSetNewInfoTMember);
                        oldFamilyIdOfInfoTMemberSetNewInfoTMember = em.merge(oldFamilyIdOfInfoTMemberSetNewInfoTMember);
                    }
                }
            }
            for (BizTOptcheck bizTOptcheckSetOldBizTOptcheck : bizTOptcheckSetOld) {
                if (!bizTOptcheckSetNew.contains(bizTOptcheckSetOldBizTOptcheck)) {
                    bizTOptcheckSetOldBizTOptcheck.setFamilyId(null);
                    bizTOptcheckSetOldBizTOptcheck = em.merge(bizTOptcheckSetOldBizTOptcheck);
                }
            }
            for (BizTOptcheck bizTOptcheckSetNewBizTOptcheck : bizTOptcheckSetNew) {
                if (!bizTOptcheckSetOld.contains(bizTOptcheckSetNewBizTOptcheck)) {
                    InfoTFamily oldFamilyIdOfBizTOptcheckSetNewBizTOptcheck = bizTOptcheckSetNewBizTOptcheck.getFamilyId();
                    bizTOptcheckSetNewBizTOptcheck.setFamilyId(infoTFamily);
                    bizTOptcheckSetNewBizTOptcheck = em.merge(bizTOptcheckSetNewBizTOptcheck);
                    if (oldFamilyIdOfBizTOptcheckSetNewBizTOptcheck != null && !oldFamilyIdOfBizTOptcheckSetNewBizTOptcheck.equals(infoTFamily)) {
                        oldFamilyIdOfBizTOptcheckSetNewBizTOptcheck.getBizTOptcheckSet().remove(bizTOptcheckSetNewBizTOptcheck);
                        oldFamilyIdOfBizTOptcheckSetNewBizTOptcheck = em.merge(oldFamilyIdOfBizTOptcheckSetNewBizTOptcheck);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = infoTFamily.getFamilyId();
                if (findInfoTFamily(id) == null) {
                    throw new NonexistentEntityException("The infoTFamily with id " + id + " no longer exists.");
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
            InfoTFamily infoTFamily;
            try {
                infoTFamily = em.getReference(InfoTFamily.class, id);
                infoTFamily.getFamilyId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The infoTFamily with id " + id + " no longer exists.", enfe);
            }
            SysTOrganization organizationId = infoTFamily.getOrganizationId();
            if (organizationId != null) {
                organizationId.getInfoTFamilySet().remove(infoTFamily);
                organizationId = em.merge(organizationId);
            }
            Set<InfoTMember> infoTMemberSet = infoTFamily.getInfoTMemberSet();
            for (InfoTMember infoTMemberSetInfoTMember : infoTMemberSet) {
                infoTMemberSetInfoTMember.setFamilyId(null);
                infoTMemberSetInfoTMember = em.merge(infoTMemberSetInfoTMember);
            }
            Set<BizTOptcheck> bizTOptcheckSet = infoTFamily.getBizTOptcheckSet();
            for (BizTOptcheck bizTOptcheckSetBizTOptcheck : bizTOptcheckSet) {
                bizTOptcheckSetBizTOptcheck.setFamilyId(null);
                bizTOptcheckSetBizTOptcheck = em.merge(bizTOptcheckSetBizTOptcheck);
            }
            em.remove(infoTFamily);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<InfoTFamily> findInfoTFamilyEntities() {
        return findInfoTFamilyEntities(true, -1, -1);
    }

    public List<InfoTFamily> findInfoTFamilyEntities(int maxResults, int firstResult) {
        return findInfoTFamilyEntities(false, maxResults, firstResult);
    }

    private List<InfoTFamily> findInfoTFamilyEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(InfoTFamily.class));
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

    public InfoTFamily findInfoTFamily(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(InfoTFamily.class, id);
        } finally {
            em.close();
        }
    }

    public int getInfoTFamilyCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<InfoTFamily> rt = cq.from(InfoTFamily.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
