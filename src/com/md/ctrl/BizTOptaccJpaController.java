/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.ctrl;

import com.md.ctrl.exceptions.NonexistentEntityException;
import com.md.ctrl.exceptions.PreexistingEntityException;
import com.md.model.shengnc.BizTOptacc;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.md.model.shengnc.DoperTPolicy;
import com.md.model.shengnc.SysTOrganization;
import com.md.model.shengnc.BizTOptcheck2;
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
public class BizTOptaccJpaController implements Serializable {

    public BizTOptaccJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BizTOptacc bizTOptacc) throws PreexistingEntityException, Exception {
        if (bizTOptacc.getBizTOptcheck2Set() == null) {
            bizTOptacc.setBizTOptcheck2Set(new HashSet<BizTOptcheck2>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DoperTPolicy policyId = bizTOptacc.getPolicyId();
            if (policyId != null) {
                policyId = em.getReference(policyId.getClass(), policyId.getPolicyId());
                bizTOptacc.setPolicyId(policyId);
            }
            SysTOrganization organizationId = bizTOptacc.getOrganizationId();
            if (organizationId != null) {
                organizationId = em.getReference(organizationId.getClass(), organizationId.getOrganizationId());
                bizTOptacc.setOrganizationId(organizationId);
            }
            Set<BizTOptcheck2> attachedBizTOptcheck2Set = new HashSet<BizTOptcheck2>();
            for (BizTOptcheck2 bizTOptcheck2SetBizTOptcheck2ToAttach : bizTOptacc.getBizTOptcheck2Set()) {
                bizTOptcheck2SetBizTOptcheck2ToAttach = em.getReference(bizTOptcheck2SetBizTOptcheck2ToAttach.getClass(), bizTOptcheck2SetBizTOptcheck2ToAttach.getOptcheck2Id());
                attachedBizTOptcheck2Set.add(bizTOptcheck2SetBizTOptcheck2ToAttach);
            }
            bizTOptacc.setBizTOptcheck2Set(attachedBizTOptcheck2Set);
            em.persist(bizTOptacc);
            if (policyId != null) {
                policyId.getBizTOptaccSet().add(bizTOptacc);
                policyId = em.merge(policyId);
            }
            if (organizationId != null) {
                organizationId.getBizTOptaccSet().add(bizTOptacc);
                organizationId = em.merge(organizationId);
            }
            for (BizTOptcheck2 bizTOptcheck2SetBizTOptcheck2 : bizTOptacc.getBizTOptcheck2Set()) {
                BizTOptacc oldOptaccIdOfBizTOptcheck2SetBizTOptcheck2 = bizTOptcheck2SetBizTOptcheck2.getOptaccId();
                bizTOptcheck2SetBizTOptcheck2.setOptaccId(bizTOptacc);
                bizTOptcheck2SetBizTOptcheck2 = em.merge(bizTOptcheck2SetBizTOptcheck2);
                if (oldOptaccIdOfBizTOptcheck2SetBizTOptcheck2 != null) {
                    oldOptaccIdOfBizTOptcheck2SetBizTOptcheck2.getBizTOptcheck2Set().remove(bizTOptcheck2SetBizTOptcheck2);
                    oldOptaccIdOfBizTOptcheck2SetBizTOptcheck2 = em.merge(oldOptaccIdOfBizTOptcheck2SetBizTOptcheck2);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBizTOptacc(bizTOptacc.getOptaccId()) != null) {
                throw new PreexistingEntityException("BizTOptacc " + bizTOptacc + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BizTOptacc bizTOptacc) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            BizTOptacc persistentBizTOptacc = em.find(BizTOptacc.class, bizTOptacc.getOptaccId());
            DoperTPolicy policyIdOld = persistentBizTOptacc.getPolicyId();
            DoperTPolicy policyIdNew = bizTOptacc.getPolicyId();
            SysTOrganization organizationIdOld = persistentBizTOptacc.getOrganizationId();
            SysTOrganization organizationIdNew = bizTOptacc.getOrganizationId();
            Set<BizTOptcheck2> bizTOptcheck2SetOld = persistentBizTOptacc.getBizTOptcheck2Set();
            Set<BizTOptcheck2> bizTOptcheck2SetNew = bizTOptacc.getBizTOptcheck2Set();
            if (policyIdNew != null) {
                policyIdNew = em.getReference(policyIdNew.getClass(), policyIdNew.getPolicyId());
                bizTOptacc.setPolicyId(policyIdNew);
            }
            if (organizationIdNew != null) {
                organizationIdNew = em.getReference(organizationIdNew.getClass(), organizationIdNew.getOrganizationId());
                bizTOptacc.setOrganizationId(organizationIdNew);
            }
            Set<BizTOptcheck2> attachedBizTOptcheck2SetNew = new HashSet<BizTOptcheck2>();
            for (BizTOptcheck2 bizTOptcheck2SetNewBizTOptcheck2ToAttach : bizTOptcheck2SetNew) {
                bizTOptcheck2SetNewBizTOptcheck2ToAttach = em.getReference(bizTOptcheck2SetNewBizTOptcheck2ToAttach.getClass(), bizTOptcheck2SetNewBizTOptcheck2ToAttach.getOptcheck2Id());
                attachedBizTOptcheck2SetNew.add(bizTOptcheck2SetNewBizTOptcheck2ToAttach);
            }
            bizTOptcheck2SetNew = attachedBizTOptcheck2SetNew;
            bizTOptacc.setBizTOptcheck2Set(bizTOptcheck2SetNew);
            bizTOptacc = em.merge(bizTOptacc);
            if (policyIdOld != null && !policyIdOld.equals(policyIdNew)) {
                policyIdOld.getBizTOptaccSet().remove(bizTOptacc);
                policyIdOld = em.merge(policyIdOld);
            }
            if (policyIdNew != null && !policyIdNew.equals(policyIdOld)) {
                policyIdNew.getBizTOptaccSet().add(bizTOptacc);
                policyIdNew = em.merge(policyIdNew);
            }
            if (organizationIdOld != null && !organizationIdOld.equals(organizationIdNew)) {
                organizationIdOld.getBizTOptaccSet().remove(bizTOptacc);
                organizationIdOld = em.merge(organizationIdOld);
            }
            if (organizationIdNew != null && !organizationIdNew.equals(organizationIdOld)) {
                organizationIdNew.getBizTOptaccSet().add(bizTOptacc);
                organizationIdNew = em.merge(organizationIdNew);
            }
            for (BizTOptcheck2 bizTOptcheck2SetOldBizTOptcheck2 : bizTOptcheck2SetOld) {
                if (!bizTOptcheck2SetNew.contains(bizTOptcheck2SetOldBizTOptcheck2)) {
                    bizTOptcheck2SetOldBizTOptcheck2.setOptaccId(null);
                    bizTOptcheck2SetOldBizTOptcheck2 = em.merge(bizTOptcheck2SetOldBizTOptcheck2);
                }
            }
            for (BizTOptcheck2 bizTOptcheck2SetNewBizTOptcheck2 : bizTOptcheck2SetNew) {
                if (!bizTOptcheck2SetOld.contains(bizTOptcheck2SetNewBizTOptcheck2)) {
                    BizTOptacc oldOptaccIdOfBizTOptcheck2SetNewBizTOptcheck2 = bizTOptcheck2SetNewBizTOptcheck2.getOptaccId();
                    bizTOptcheck2SetNewBizTOptcheck2.setOptaccId(bizTOptacc);
                    bizTOptcheck2SetNewBizTOptcheck2 = em.merge(bizTOptcheck2SetNewBizTOptcheck2);
                    if (oldOptaccIdOfBizTOptcheck2SetNewBizTOptcheck2 != null && !oldOptaccIdOfBizTOptcheck2SetNewBizTOptcheck2.equals(bizTOptacc)) {
                        oldOptaccIdOfBizTOptcheck2SetNewBizTOptcheck2.getBizTOptcheck2Set().remove(bizTOptcheck2SetNewBizTOptcheck2);
                        oldOptaccIdOfBizTOptcheck2SetNewBizTOptcheck2 = em.merge(oldOptaccIdOfBizTOptcheck2SetNewBizTOptcheck2);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = bizTOptacc.getOptaccId();
                if (findBizTOptacc(id) == null) {
                    throw new NonexistentEntityException("The bizTOptacc with id " + id + " no longer exists.");
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
            BizTOptacc bizTOptacc;
            try {
                bizTOptacc = em.getReference(BizTOptacc.class, id);
                bizTOptacc.getOptaccId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bizTOptacc with id " + id + " no longer exists.", enfe);
            }
            DoperTPolicy policyId = bizTOptacc.getPolicyId();
            if (policyId != null) {
                policyId.getBizTOptaccSet().remove(bizTOptacc);
                policyId = em.merge(policyId);
            }
            SysTOrganization organizationId = bizTOptacc.getOrganizationId();
            if (organizationId != null) {
                organizationId.getBizTOptaccSet().remove(bizTOptacc);
                organizationId = em.merge(organizationId);
            }
            Set<BizTOptcheck2> bizTOptcheck2Set = bizTOptacc.getBizTOptcheck2Set();
            for (BizTOptcheck2 bizTOptcheck2SetBizTOptcheck2 : bizTOptcheck2Set) {
                bizTOptcheck2SetBizTOptcheck2.setOptaccId(null);
                bizTOptcheck2SetBizTOptcheck2 = em.merge(bizTOptcheck2SetBizTOptcheck2);
            }
            em.remove(bizTOptacc);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BizTOptacc> findBizTOptaccEntities() {
        return findBizTOptaccEntities(true, -1, -1);
    }

    public List<BizTOptacc> findBizTOptaccEntities(int maxResults, int firstResult) {
        return findBizTOptaccEntities(false, maxResults, firstResult);
    }

    private List<BizTOptacc> findBizTOptaccEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BizTOptacc.class));
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

    public BizTOptacc findBizTOptacc(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BizTOptacc.class, id);
        } finally {
            em.close();
        }
    }

    public int getBizTOptaccCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BizTOptacc> rt = cq.from(BizTOptacc.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
