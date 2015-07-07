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
import com.md.model.shengnc.ImplTAccoptcheck;
import java.util.HashSet;
import java.util.Set;
import com.md.model.shengnc.BizTOptacc;
import com.md.model.shengnc.BizTOptcheck;
import com.md.model.shengnc.DoperTPolicy;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Administrator
 */
public class DoperTPolicyJpaController implements Serializable {

    public DoperTPolicyJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DoperTPolicy doperTPolicy) throws PreexistingEntityException, Exception {
        if (doperTPolicy.getImplTAccoptcheckSet() == null) {
            doperTPolicy.setImplTAccoptcheckSet(new HashSet<ImplTAccoptcheck>());
        }
        if (doperTPolicy.getBizTOptaccSet() == null) {
            doperTPolicy.setBizTOptaccSet(new HashSet<BizTOptacc>());
        }
        if (doperTPolicy.getBizTOptcheckSet() == null) {
            doperTPolicy.setBizTOptcheckSet(new HashSet<BizTOptcheck>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Set<ImplTAccoptcheck> attachedImplTAccoptcheckSet = new HashSet<ImplTAccoptcheck>();
            for (ImplTAccoptcheck implTAccoptcheckSetImplTAccoptcheckToAttach : doperTPolicy.getImplTAccoptcheckSet()) {
                implTAccoptcheckSetImplTAccoptcheckToAttach = em.getReference(implTAccoptcheckSetImplTAccoptcheckToAttach.getClass(), implTAccoptcheckSetImplTAccoptcheckToAttach.getAccoptcheckId());
                attachedImplTAccoptcheckSet.add(implTAccoptcheckSetImplTAccoptcheckToAttach);
            }
            doperTPolicy.setImplTAccoptcheckSet(attachedImplTAccoptcheckSet);
            Set<BizTOptacc> attachedBizTOptaccSet = new HashSet<BizTOptacc>();
            for (BizTOptacc bizTOptaccSetBizTOptaccToAttach : doperTPolicy.getBizTOptaccSet()) {
                bizTOptaccSetBizTOptaccToAttach = em.getReference(bizTOptaccSetBizTOptaccToAttach.getClass(), bizTOptaccSetBizTOptaccToAttach.getOptaccId());
                attachedBizTOptaccSet.add(bizTOptaccSetBizTOptaccToAttach);
            }
            doperTPolicy.setBizTOptaccSet(attachedBizTOptaccSet);
            Set<BizTOptcheck> attachedBizTOptcheckSet = new HashSet<BizTOptcheck>();
            for (BizTOptcheck bizTOptcheckSetBizTOptcheckToAttach : doperTPolicy.getBizTOptcheckSet()) {
                bizTOptcheckSetBizTOptcheckToAttach = em.getReference(bizTOptcheckSetBizTOptcheckToAttach.getClass(), bizTOptcheckSetBizTOptcheckToAttach.getOptcheckId());
                attachedBizTOptcheckSet.add(bizTOptcheckSetBizTOptcheckToAttach);
            }
            doperTPolicy.setBizTOptcheckSet(attachedBizTOptcheckSet);
            em.persist(doperTPolicy);
            for (ImplTAccoptcheck implTAccoptcheckSetImplTAccoptcheck : doperTPolicy.getImplTAccoptcheckSet()) {
                DoperTPolicy oldPolicyIdOfImplTAccoptcheckSetImplTAccoptcheck = implTAccoptcheckSetImplTAccoptcheck.getPolicyId();
                implTAccoptcheckSetImplTAccoptcheck.setPolicyId(doperTPolicy);
                implTAccoptcheckSetImplTAccoptcheck = em.merge(implTAccoptcheckSetImplTAccoptcheck);
                if (oldPolicyIdOfImplTAccoptcheckSetImplTAccoptcheck != null) {
                    oldPolicyIdOfImplTAccoptcheckSetImplTAccoptcheck.getImplTAccoptcheckSet().remove(implTAccoptcheckSetImplTAccoptcheck);
                    oldPolicyIdOfImplTAccoptcheckSetImplTAccoptcheck = em.merge(oldPolicyIdOfImplTAccoptcheckSetImplTAccoptcheck);
                }
            }
            for (BizTOptacc bizTOptaccSetBizTOptacc : doperTPolicy.getBizTOptaccSet()) {
                DoperTPolicy oldPolicyIdOfBizTOptaccSetBizTOptacc = bizTOptaccSetBizTOptacc.getPolicyId();
                bizTOptaccSetBizTOptacc.setPolicyId(doperTPolicy);
                bizTOptaccSetBizTOptacc = em.merge(bizTOptaccSetBizTOptacc);
                if (oldPolicyIdOfBizTOptaccSetBizTOptacc != null) {
                    oldPolicyIdOfBizTOptaccSetBizTOptacc.getBizTOptaccSet().remove(bizTOptaccSetBizTOptacc);
                    oldPolicyIdOfBizTOptaccSetBizTOptacc = em.merge(oldPolicyIdOfBizTOptaccSetBizTOptacc);
                }
            }
            for (BizTOptcheck bizTOptcheckSetBizTOptcheck : doperTPolicy.getBizTOptcheckSet()) {
                DoperTPolicy oldPolicyIdOfBizTOptcheckSetBizTOptcheck = bizTOptcheckSetBizTOptcheck.getPolicyId();
                bizTOptcheckSetBizTOptcheck.setPolicyId(doperTPolicy);
                bizTOptcheckSetBizTOptcheck = em.merge(bizTOptcheckSetBizTOptcheck);
                if (oldPolicyIdOfBizTOptcheckSetBizTOptcheck != null) {
                    oldPolicyIdOfBizTOptcheckSetBizTOptcheck.getBizTOptcheckSet().remove(bizTOptcheckSetBizTOptcheck);
                    oldPolicyIdOfBizTOptcheckSetBizTOptcheck = em.merge(oldPolicyIdOfBizTOptcheckSetBizTOptcheck);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDoperTPolicy(doperTPolicy.getPolicyId()) != null) {
                throw new PreexistingEntityException("DoperTPolicy " + doperTPolicy + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DoperTPolicy doperTPolicy) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DoperTPolicy persistentDoperTPolicy = em.find(DoperTPolicy.class, doperTPolicy.getPolicyId());
            Set<ImplTAccoptcheck> implTAccoptcheckSetOld = persistentDoperTPolicy.getImplTAccoptcheckSet();
            Set<ImplTAccoptcheck> implTAccoptcheckSetNew = doperTPolicy.getImplTAccoptcheckSet();
            Set<BizTOptacc> bizTOptaccSetOld = persistentDoperTPolicy.getBizTOptaccSet();
            Set<BizTOptacc> bizTOptaccSetNew = doperTPolicy.getBizTOptaccSet();
            Set<BizTOptcheck> bizTOptcheckSetOld = persistentDoperTPolicy.getBizTOptcheckSet();
            Set<BizTOptcheck> bizTOptcheckSetNew = doperTPolicy.getBizTOptcheckSet();
            Set<ImplTAccoptcheck> attachedImplTAccoptcheckSetNew = new HashSet<ImplTAccoptcheck>();
            for (ImplTAccoptcheck implTAccoptcheckSetNewImplTAccoptcheckToAttach : implTAccoptcheckSetNew) {
                implTAccoptcheckSetNewImplTAccoptcheckToAttach = em.getReference(implTAccoptcheckSetNewImplTAccoptcheckToAttach.getClass(), implTAccoptcheckSetNewImplTAccoptcheckToAttach.getAccoptcheckId());
                attachedImplTAccoptcheckSetNew.add(implTAccoptcheckSetNewImplTAccoptcheckToAttach);
            }
            implTAccoptcheckSetNew = attachedImplTAccoptcheckSetNew;
            doperTPolicy.setImplTAccoptcheckSet(implTAccoptcheckSetNew);
            Set<BizTOptacc> attachedBizTOptaccSetNew = new HashSet<BizTOptacc>();
            for (BizTOptacc bizTOptaccSetNewBizTOptaccToAttach : bizTOptaccSetNew) {
                bizTOptaccSetNewBizTOptaccToAttach = em.getReference(bizTOptaccSetNewBizTOptaccToAttach.getClass(), bizTOptaccSetNewBizTOptaccToAttach.getOptaccId());
                attachedBizTOptaccSetNew.add(bizTOptaccSetNewBizTOptaccToAttach);
            }
            bizTOptaccSetNew = attachedBizTOptaccSetNew;
            doperTPolicy.setBizTOptaccSet(bizTOptaccSetNew);
            Set<BizTOptcheck> attachedBizTOptcheckSetNew = new HashSet<BizTOptcheck>();
            for (BizTOptcheck bizTOptcheckSetNewBizTOptcheckToAttach : bizTOptcheckSetNew) {
                bizTOptcheckSetNewBizTOptcheckToAttach = em.getReference(bizTOptcheckSetNewBizTOptcheckToAttach.getClass(), bizTOptcheckSetNewBizTOptcheckToAttach.getOptcheckId());
                attachedBizTOptcheckSetNew.add(bizTOptcheckSetNewBizTOptcheckToAttach);
            }
            bizTOptcheckSetNew = attachedBizTOptcheckSetNew;
            doperTPolicy.setBizTOptcheckSet(bizTOptcheckSetNew);
            doperTPolicy = em.merge(doperTPolicy);
            for (ImplTAccoptcheck implTAccoptcheckSetOldImplTAccoptcheck : implTAccoptcheckSetOld) {
                if (!implTAccoptcheckSetNew.contains(implTAccoptcheckSetOldImplTAccoptcheck)) {
                    implTAccoptcheckSetOldImplTAccoptcheck.setPolicyId(null);
                    implTAccoptcheckSetOldImplTAccoptcheck = em.merge(implTAccoptcheckSetOldImplTAccoptcheck);
                }
            }
            for (ImplTAccoptcheck implTAccoptcheckSetNewImplTAccoptcheck : implTAccoptcheckSetNew) {
                if (!implTAccoptcheckSetOld.contains(implTAccoptcheckSetNewImplTAccoptcheck)) {
                    DoperTPolicy oldPolicyIdOfImplTAccoptcheckSetNewImplTAccoptcheck = implTAccoptcheckSetNewImplTAccoptcheck.getPolicyId();
                    implTAccoptcheckSetNewImplTAccoptcheck.setPolicyId(doperTPolicy);
                    implTAccoptcheckSetNewImplTAccoptcheck = em.merge(implTAccoptcheckSetNewImplTAccoptcheck);
                    if (oldPolicyIdOfImplTAccoptcheckSetNewImplTAccoptcheck != null && !oldPolicyIdOfImplTAccoptcheckSetNewImplTAccoptcheck.equals(doperTPolicy)) {
                        oldPolicyIdOfImplTAccoptcheckSetNewImplTAccoptcheck.getImplTAccoptcheckSet().remove(implTAccoptcheckSetNewImplTAccoptcheck);
                        oldPolicyIdOfImplTAccoptcheckSetNewImplTAccoptcheck = em.merge(oldPolicyIdOfImplTAccoptcheckSetNewImplTAccoptcheck);
                    }
                }
            }
            for (BizTOptacc bizTOptaccSetOldBizTOptacc : bizTOptaccSetOld) {
                if (!bizTOptaccSetNew.contains(bizTOptaccSetOldBizTOptacc)) {
                    bizTOptaccSetOldBizTOptacc.setPolicyId(null);
                    bizTOptaccSetOldBizTOptacc = em.merge(bizTOptaccSetOldBizTOptacc);
                }
            }
            for (BizTOptacc bizTOptaccSetNewBizTOptacc : bizTOptaccSetNew) {
                if (!bizTOptaccSetOld.contains(bizTOptaccSetNewBizTOptacc)) {
                    DoperTPolicy oldPolicyIdOfBizTOptaccSetNewBizTOptacc = bizTOptaccSetNewBizTOptacc.getPolicyId();
                    bizTOptaccSetNewBizTOptacc.setPolicyId(doperTPolicy);
                    bizTOptaccSetNewBizTOptacc = em.merge(bizTOptaccSetNewBizTOptacc);
                    if (oldPolicyIdOfBizTOptaccSetNewBizTOptacc != null && !oldPolicyIdOfBizTOptaccSetNewBizTOptacc.equals(doperTPolicy)) {
                        oldPolicyIdOfBizTOptaccSetNewBizTOptacc.getBizTOptaccSet().remove(bizTOptaccSetNewBizTOptacc);
                        oldPolicyIdOfBizTOptaccSetNewBizTOptacc = em.merge(oldPolicyIdOfBizTOptaccSetNewBizTOptacc);
                    }
                }
            }
            for (BizTOptcheck bizTOptcheckSetOldBizTOptcheck : bizTOptcheckSetOld) {
                if (!bizTOptcheckSetNew.contains(bizTOptcheckSetOldBizTOptcheck)) {
                    bizTOptcheckSetOldBizTOptcheck.setPolicyId(null);
                    bizTOptcheckSetOldBizTOptcheck = em.merge(bizTOptcheckSetOldBizTOptcheck);
                }
            }
            for (BizTOptcheck bizTOptcheckSetNewBizTOptcheck : bizTOptcheckSetNew) {
                if (!bizTOptcheckSetOld.contains(bizTOptcheckSetNewBizTOptcheck)) {
                    DoperTPolicy oldPolicyIdOfBizTOptcheckSetNewBizTOptcheck = bizTOptcheckSetNewBizTOptcheck.getPolicyId();
                    bizTOptcheckSetNewBizTOptcheck.setPolicyId(doperTPolicy);
                    bizTOptcheckSetNewBizTOptcheck = em.merge(bizTOptcheckSetNewBizTOptcheck);
                    if (oldPolicyIdOfBizTOptcheckSetNewBizTOptcheck != null && !oldPolicyIdOfBizTOptcheckSetNewBizTOptcheck.equals(doperTPolicy)) {
                        oldPolicyIdOfBizTOptcheckSetNewBizTOptcheck.getBizTOptcheckSet().remove(bizTOptcheckSetNewBizTOptcheck);
                        oldPolicyIdOfBizTOptcheckSetNewBizTOptcheck = em.merge(oldPolicyIdOfBizTOptcheckSetNewBizTOptcheck);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = doperTPolicy.getPolicyId();
                if (findDoperTPolicy(id) == null) {
                    throw new NonexistentEntityException("The doperTPolicy with id " + id + " no longer exists.");
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
            DoperTPolicy doperTPolicy;
            try {
                doperTPolicy = em.getReference(DoperTPolicy.class, id);
                doperTPolicy.getPolicyId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The doperTPolicy with id " + id + " no longer exists.", enfe);
            }
            Set<ImplTAccoptcheck> implTAccoptcheckSet = doperTPolicy.getImplTAccoptcheckSet();
            for (ImplTAccoptcheck implTAccoptcheckSetImplTAccoptcheck : implTAccoptcheckSet) {
                implTAccoptcheckSetImplTAccoptcheck.setPolicyId(null);
                implTAccoptcheckSetImplTAccoptcheck = em.merge(implTAccoptcheckSetImplTAccoptcheck);
            }
            Set<BizTOptacc> bizTOptaccSet = doperTPolicy.getBizTOptaccSet();
            for (BizTOptacc bizTOptaccSetBizTOptacc : bizTOptaccSet) {
                bizTOptaccSetBizTOptacc.setPolicyId(null);
                bizTOptaccSetBizTOptacc = em.merge(bizTOptaccSetBizTOptacc);
            }
            Set<BizTOptcheck> bizTOptcheckSet = doperTPolicy.getBizTOptcheckSet();
            for (BizTOptcheck bizTOptcheckSetBizTOptcheck : bizTOptcheckSet) {
                bizTOptcheckSetBizTOptcheck.setPolicyId(null);
                bizTOptcheckSetBizTOptcheck = em.merge(bizTOptcheckSetBizTOptcheck);
            }
            em.remove(doperTPolicy);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DoperTPolicy> findDoperTPolicyEntities() {
        return findDoperTPolicyEntities(true, -1, -1);
    }

    public List<DoperTPolicy> findDoperTPolicyEntities(int maxResults, int firstResult) {
        return findDoperTPolicyEntities(false, maxResults, firstResult);
    }

    private List<DoperTPolicy> findDoperTPolicyEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DoperTPolicy.class));
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

    public DoperTPolicy findDoperTPolicy(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DoperTPolicy.class, id);
        } finally {
            em.close();
        }
    }

    public int getDoperTPolicyCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DoperTPolicy> rt = cq.from(DoperTPolicy.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
