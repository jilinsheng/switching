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
import com.md.model.shengnc.BizTOptcheck;
import com.md.model.shengnc.InfoTMember;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Administrator
 */
public class InfoTMemberJpaController implements Serializable {

    public InfoTMemberJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(InfoTMember infoTMember) throws PreexistingEntityException, Exception {
        if (infoTMember.getBizTOptcheckSet() == null) {
            infoTMember.setBizTOptcheckSet(new HashSet<BizTOptcheck>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            InfoTFamily familyId = infoTMember.getFamilyId();
            if (familyId != null) {
                familyId = em.getReference(familyId.getClass(), familyId.getFamilyId());
                infoTMember.setFamilyId(familyId);
            }
            Set<BizTOptcheck> attachedBizTOptcheckSet = new HashSet<BizTOptcheck>();
            for (BizTOptcheck bizTOptcheckSetBizTOptcheckToAttach : infoTMember.getBizTOptcheckSet()) {
                bizTOptcheckSetBizTOptcheckToAttach = em.getReference(bizTOptcheckSetBizTOptcheckToAttach.getClass(), bizTOptcheckSetBizTOptcheckToAttach.getOptcheckId());
                attachedBizTOptcheckSet.add(bizTOptcheckSetBizTOptcheckToAttach);
            }
            infoTMember.setBizTOptcheckSet(attachedBizTOptcheckSet);
            em.persist(infoTMember);
            if (familyId != null) {
                familyId.getInfoTMemberSet().add(infoTMember);
                familyId = em.merge(familyId);
            }
            for (BizTOptcheck bizTOptcheckSetBizTOptcheck : infoTMember.getBizTOptcheckSet()) {
                InfoTMember oldMemberIdOfBizTOptcheckSetBizTOptcheck = bizTOptcheckSetBizTOptcheck.getMemberId();
                bizTOptcheckSetBizTOptcheck.setMemberId(infoTMember);
                bizTOptcheckSetBizTOptcheck = em.merge(bizTOptcheckSetBizTOptcheck);
                if (oldMemberIdOfBizTOptcheckSetBizTOptcheck != null) {
                    oldMemberIdOfBizTOptcheckSetBizTOptcheck.getBizTOptcheckSet().remove(bizTOptcheckSetBizTOptcheck);
                    oldMemberIdOfBizTOptcheckSetBizTOptcheck = em.merge(oldMemberIdOfBizTOptcheckSetBizTOptcheck);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findInfoTMember(infoTMember.getMemberId()) != null) {
                throw new PreexistingEntityException("InfoTMember " + infoTMember + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(InfoTMember infoTMember) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            InfoTMember persistentInfoTMember = em.find(InfoTMember.class, infoTMember.getMemberId());
            InfoTFamily familyIdOld = persistentInfoTMember.getFamilyId();
            InfoTFamily familyIdNew = infoTMember.getFamilyId();
            Set<BizTOptcheck> bizTOptcheckSetOld = persistentInfoTMember.getBizTOptcheckSet();
            Set<BizTOptcheck> bizTOptcheckSetNew = infoTMember.getBizTOptcheckSet();
            if (familyIdNew != null) {
                familyIdNew = em.getReference(familyIdNew.getClass(), familyIdNew.getFamilyId());
                infoTMember.setFamilyId(familyIdNew);
            }
            Set<BizTOptcheck> attachedBizTOptcheckSetNew = new HashSet<BizTOptcheck>();
            for (BizTOptcheck bizTOptcheckSetNewBizTOptcheckToAttach : bizTOptcheckSetNew) {
                bizTOptcheckSetNewBizTOptcheckToAttach = em.getReference(bizTOptcheckSetNewBizTOptcheckToAttach.getClass(), bizTOptcheckSetNewBizTOptcheckToAttach.getOptcheckId());
                attachedBizTOptcheckSetNew.add(bizTOptcheckSetNewBizTOptcheckToAttach);
            }
            bizTOptcheckSetNew = attachedBizTOptcheckSetNew;
            infoTMember.setBizTOptcheckSet(bizTOptcheckSetNew);
            infoTMember = em.merge(infoTMember);
            if (familyIdOld != null && !familyIdOld.equals(familyIdNew)) {
                familyIdOld.getInfoTMemberSet().remove(infoTMember);
                familyIdOld = em.merge(familyIdOld);
            }
            if (familyIdNew != null && !familyIdNew.equals(familyIdOld)) {
                familyIdNew.getInfoTMemberSet().add(infoTMember);
                familyIdNew = em.merge(familyIdNew);
            }
            for (BizTOptcheck bizTOptcheckSetOldBizTOptcheck : bizTOptcheckSetOld) {
                if (!bizTOptcheckSetNew.contains(bizTOptcheckSetOldBizTOptcheck)) {
                    bizTOptcheckSetOldBizTOptcheck.setMemberId(null);
                    bizTOptcheckSetOldBizTOptcheck = em.merge(bizTOptcheckSetOldBizTOptcheck);
                }
            }
            for (BizTOptcheck bizTOptcheckSetNewBizTOptcheck : bizTOptcheckSetNew) {
                if (!bizTOptcheckSetOld.contains(bizTOptcheckSetNewBizTOptcheck)) {
                    InfoTMember oldMemberIdOfBizTOptcheckSetNewBizTOptcheck = bizTOptcheckSetNewBizTOptcheck.getMemberId();
                    bizTOptcheckSetNewBizTOptcheck.setMemberId(infoTMember);
                    bizTOptcheckSetNewBizTOptcheck = em.merge(bizTOptcheckSetNewBizTOptcheck);
                    if (oldMemberIdOfBizTOptcheckSetNewBizTOptcheck != null && !oldMemberIdOfBizTOptcheckSetNewBizTOptcheck.equals(infoTMember)) {
                        oldMemberIdOfBizTOptcheckSetNewBizTOptcheck.getBizTOptcheckSet().remove(bizTOptcheckSetNewBizTOptcheck);
                        oldMemberIdOfBizTOptcheckSetNewBizTOptcheck = em.merge(oldMemberIdOfBizTOptcheckSetNewBizTOptcheck);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = infoTMember.getMemberId();
                if (findInfoTMember(id) == null) {
                    throw new NonexistentEntityException("The infoTMember with id " + id + " no longer exists.");
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
            InfoTMember infoTMember;
            try {
                infoTMember = em.getReference(InfoTMember.class, id);
                infoTMember.getMemberId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The infoTMember with id " + id + " no longer exists.", enfe);
            }
            InfoTFamily familyId = infoTMember.getFamilyId();
            if (familyId != null) {
                familyId.getInfoTMemberSet().remove(infoTMember);
                familyId = em.merge(familyId);
            }
            Set<BizTOptcheck> bizTOptcheckSet = infoTMember.getBizTOptcheckSet();
            for (BizTOptcheck bizTOptcheckSetBizTOptcheck : bizTOptcheckSet) {
                bizTOptcheckSetBizTOptcheck.setMemberId(null);
                bizTOptcheckSetBizTOptcheck = em.merge(bizTOptcheckSetBizTOptcheck);
            }
            em.remove(infoTMember);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<InfoTMember> findInfoTMemberEntities() {
        return findInfoTMemberEntities(true, -1, -1);
    }

    public List<InfoTMember> findInfoTMemberEntities(int maxResults, int firstResult) {
        return findInfoTMemberEntities(false, maxResults, firstResult);
    }

    private List<InfoTMember> findInfoTMemberEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(InfoTMember.class));
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

    public InfoTMember findInfoTMember(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(InfoTMember.class, id);
        } finally {
            em.close();
        }
    }

    public int getInfoTMemberCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<InfoTMember> rt = cq.from(InfoTMember.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
