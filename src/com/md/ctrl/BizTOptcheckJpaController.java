/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.ctrl;

import com.md.ctrl.exceptions.NonexistentEntityException;
import com.md.ctrl.exceptions.PreexistingEntityException;
import com.md.model.shengnc.BizTOptcheck;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.md.model.shengnc.DoperTPolicy;
import com.md.model.shengnc.InfoTFamily;
import com.md.model.shengnc.InfoTMember;
import com.md.model.shengnc.BizTOptcheckidea;
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
public class BizTOptcheckJpaController implements Serializable {

    public BizTOptcheckJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BizTOptcheck bizTOptcheck) throws PreexistingEntityException, Exception {
        if (bizTOptcheck.getBizTOptcheckideaSet() == null) {
            bizTOptcheck.setBizTOptcheckideaSet(new HashSet<BizTOptcheckidea>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DoperTPolicy policyId = bizTOptcheck.getPolicyId();
            if (policyId != null) {
                policyId = em.getReference(policyId.getClass(), policyId.getPolicyId());
                bizTOptcheck.setPolicyId(policyId);
            }
            InfoTFamily familyId = bizTOptcheck.getFamilyId();
            if (familyId != null) {
                familyId = em.getReference(familyId.getClass(), familyId.getFamilyId());
                bizTOptcheck.setFamilyId(familyId);
            }
            InfoTMember memberId = bizTOptcheck.getMemberId();
            if (memberId != null) {
                memberId = em.getReference(memberId.getClass(), memberId.getMemberId());
                bizTOptcheck.setMemberId(memberId);
            }
            Set<BizTOptcheckidea> attachedBizTOptcheckideaSet = new HashSet<BizTOptcheckidea>();
            for (BizTOptcheckidea bizTOptcheckideaSetBizTOptcheckideaToAttach : bizTOptcheck.getBizTOptcheckideaSet()) {
                bizTOptcheckideaSetBizTOptcheckideaToAttach = em.getReference(bizTOptcheckideaSetBizTOptcheckideaToAttach.getClass(), bizTOptcheckideaSetBizTOptcheckideaToAttach.getOptcheckideaId());
                attachedBizTOptcheckideaSet.add(bizTOptcheckideaSetBizTOptcheckideaToAttach);
            }
            bizTOptcheck.setBizTOptcheckideaSet(attachedBizTOptcheckideaSet);
            em.persist(bizTOptcheck);
            if (policyId != null) {
                policyId.getBizTOptcheckSet().add(bizTOptcheck);
                policyId = em.merge(policyId);
            }
            if (familyId != null) {
                familyId.getBizTOptcheckSet().add(bizTOptcheck);
                familyId = em.merge(familyId);
            }
            if (memberId != null) {
                memberId.getBizTOptcheckSet().add(bizTOptcheck);
                memberId = em.merge(memberId);
            }
            for (BizTOptcheckidea bizTOptcheckideaSetBizTOptcheckidea : bizTOptcheck.getBizTOptcheckideaSet()) {
                BizTOptcheck oldOptcheckIdOfBizTOptcheckideaSetBizTOptcheckidea = bizTOptcheckideaSetBizTOptcheckidea.getOptcheckId();
                bizTOptcheckideaSetBizTOptcheckidea.setOptcheckId(bizTOptcheck);
                bizTOptcheckideaSetBizTOptcheckidea = em.merge(bizTOptcheckideaSetBizTOptcheckidea);
                if (oldOptcheckIdOfBizTOptcheckideaSetBizTOptcheckidea != null) {
                    oldOptcheckIdOfBizTOptcheckideaSetBizTOptcheckidea.getBizTOptcheckideaSet().remove(bizTOptcheckideaSetBizTOptcheckidea);
                    oldOptcheckIdOfBizTOptcheckideaSetBizTOptcheckidea = em.merge(oldOptcheckIdOfBizTOptcheckideaSetBizTOptcheckidea);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBizTOptcheck(bizTOptcheck.getOptcheckId()) != null) {
                throw new PreexistingEntityException("BizTOptcheck " + bizTOptcheck + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BizTOptcheck bizTOptcheck) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            BizTOptcheck persistentBizTOptcheck = em.find(BizTOptcheck.class, bizTOptcheck.getOptcheckId());
            DoperTPolicy policyIdOld = persistentBizTOptcheck.getPolicyId();
            DoperTPolicy policyIdNew = bizTOptcheck.getPolicyId();
            InfoTFamily familyIdOld = persistentBizTOptcheck.getFamilyId();
            InfoTFamily familyIdNew = bizTOptcheck.getFamilyId();
            InfoTMember memberIdOld = persistentBizTOptcheck.getMemberId();
            InfoTMember memberIdNew = bizTOptcheck.getMemberId();
            Set<BizTOptcheckidea> bizTOptcheckideaSetOld = persistentBizTOptcheck.getBizTOptcheckideaSet();
            Set<BizTOptcheckidea> bizTOptcheckideaSetNew = bizTOptcheck.getBizTOptcheckideaSet();
            if (policyIdNew != null) {
                policyIdNew = em.getReference(policyIdNew.getClass(), policyIdNew.getPolicyId());
                bizTOptcheck.setPolicyId(policyIdNew);
            }
            if (familyIdNew != null) {
                familyIdNew = em.getReference(familyIdNew.getClass(), familyIdNew.getFamilyId());
                bizTOptcheck.setFamilyId(familyIdNew);
            }
            if (memberIdNew != null) {
                memberIdNew = em.getReference(memberIdNew.getClass(), memberIdNew.getMemberId());
                bizTOptcheck.setMemberId(memberIdNew);
            }
            Set<BizTOptcheckidea> attachedBizTOptcheckideaSetNew = new HashSet<BizTOptcheckidea>();
            for (BizTOptcheckidea bizTOptcheckideaSetNewBizTOptcheckideaToAttach : bizTOptcheckideaSetNew) {
                bizTOptcheckideaSetNewBizTOptcheckideaToAttach = em.getReference(bizTOptcheckideaSetNewBizTOptcheckideaToAttach.getClass(), bizTOptcheckideaSetNewBizTOptcheckideaToAttach.getOptcheckideaId());
                attachedBizTOptcheckideaSetNew.add(bizTOptcheckideaSetNewBizTOptcheckideaToAttach);
            }
            bizTOptcheckideaSetNew = attachedBizTOptcheckideaSetNew;
            bizTOptcheck.setBizTOptcheckideaSet(bizTOptcheckideaSetNew);
            bizTOptcheck = em.merge(bizTOptcheck);
            if (policyIdOld != null && !policyIdOld.equals(policyIdNew)) {
                policyIdOld.getBizTOptcheckSet().remove(bizTOptcheck);
                policyIdOld = em.merge(policyIdOld);
            }
            if (policyIdNew != null && !policyIdNew.equals(policyIdOld)) {
                policyIdNew.getBizTOptcheckSet().add(bizTOptcheck);
                policyIdNew = em.merge(policyIdNew);
            }
            if (familyIdOld != null && !familyIdOld.equals(familyIdNew)) {
                familyIdOld.getBizTOptcheckSet().remove(bizTOptcheck);
                familyIdOld = em.merge(familyIdOld);
            }
            if (familyIdNew != null && !familyIdNew.equals(familyIdOld)) {
                familyIdNew.getBizTOptcheckSet().add(bizTOptcheck);
                familyIdNew = em.merge(familyIdNew);
            }
            if (memberIdOld != null && !memberIdOld.equals(memberIdNew)) {
                memberIdOld.getBizTOptcheckSet().remove(bizTOptcheck);
                memberIdOld = em.merge(memberIdOld);
            }
            if (memberIdNew != null && !memberIdNew.equals(memberIdOld)) {
                memberIdNew.getBizTOptcheckSet().add(bizTOptcheck);
                memberIdNew = em.merge(memberIdNew);
            }
            for (BizTOptcheckidea bizTOptcheckideaSetOldBizTOptcheckidea : bizTOptcheckideaSetOld) {
                if (!bizTOptcheckideaSetNew.contains(bizTOptcheckideaSetOldBizTOptcheckidea)) {
                    bizTOptcheckideaSetOldBizTOptcheckidea.setOptcheckId(null);
                    bizTOptcheckideaSetOldBizTOptcheckidea = em.merge(bizTOptcheckideaSetOldBizTOptcheckidea);
                }
            }
            for (BizTOptcheckidea bizTOptcheckideaSetNewBizTOptcheckidea : bizTOptcheckideaSetNew) {
                if (!bizTOptcheckideaSetOld.contains(bizTOptcheckideaSetNewBizTOptcheckidea)) {
                    BizTOptcheck oldOptcheckIdOfBizTOptcheckideaSetNewBizTOptcheckidea = bizTOptcheckideaSetNewBizTOptcheckidea.getOptcheckId();
                    bizTOptcheckideaSetNewBizTOptcheckidea.setOptcheckId(bizTOptcheck);
                    bizTOptcheckideaSetNewBizTOptcheckidea = em.merge(bizTOptcheckideaSetNewBizTOptcheckidea);
                    if (oldOptcheckIdOfBizTOptcheckideaSetNewBizTOptcheckidea != null && !oldOptcheckIdOfBizTOptcheckideaSetNewBizTOptcheckidea.equals(bizTOptcheck)) {
                        oldOptcheckIdOfBizTOptcheckideaSetNewBizTOptcheckidea.getBizTOptcheckideaSet().remove(bizTOptcheckideaSetNewBizTOptcheckidea);
                        oldOptcheckIdOfBizTOptcheckideaSetNewBizTOptcheckidea = em.merge(oldOptcheckIdOfBizTOptcheckideaSetNewBizTOptcheckidea);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = bizTOptcheck.getOptcheckId();
                if (findBizTOptcheck(id) == null) {
                    throw new NonexistentEntityException("The bizTOptcheck with id " + id + " no longer exists.");
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
            BizTOptcheck bizTOptcheck;
            try {
                bizTOptcheck = em.getReference(BizTOptcheck.class, id);
                bizTOptcheck.getOptcheckId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bizTOptcheck with id " + id + " no longer exists.", enfe);
            }
            DoperTPolicy policyId = bizTOptcheck.getPolicyId();
            if (policyId != null) {
                policyId.getBizTOptcheckSet().remove(bizTOptcheck);
                policyId = em.merge(policyId);
            }
            InfoTFamily familyId = bizTOptcheck.getFamilyId();
            if (familyId != null) {
                familyId.getBizTOptcheckSet().remove(bizTOptcheck);
                familyId = em.merge(familyId);
            }
            InfoTMember memberId = bizTOptcheck.getMemberId();
            if (memberId != null) {
                memberId.getBizTOptcheckSet().remove(bizTOptcheck);
                memberId = em.merge(memberId);
            }
            Set<BizTOptcheckidea> bizTOptcheckideaSet = bizTOptcheck.getBizTOptcheckideaSet();
            for (BizTOptcheckidea bizTOptcheckideaSetBizTOptcheckidea : bizTOptcheckideaSet) {
                bizTOptcheckideaSetBizTOptcheckidea.setOptcheckId(null);
                bizTOptcheckideaSetBizTOptcheckidea = em.merge(bizTOptcheckideaSetBizTOptcheckidea);
            }
            em.remove(bizTOptcheck);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BizTOptcheck> findBizTOptcheckEntities() {
        return findBizTOptcheckEntities(true, -1, -1);
    }

    public List<BizTOptcheck> findBizTOptcheckEntities(int maxResults, int firstResult) {
        return findBizTOptcheckEntities(false, maxResults, firstResult);
    }

    private List<BizTOptcheck> findBizTOptcheckEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BizTOptcheck.class));
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

    public BizTOptcheck findBizTOptcheck(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BizTOptcheck.class, id);
        } finally {
            em.close();
        }
    }

    public int getBizTOptcheckCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BizTOptcheck> rt = cq.from(BizTOptcheck.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
