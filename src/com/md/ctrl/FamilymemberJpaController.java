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
import com.md.model.shengcs.Family;
import com.md.model.shengcs.Familymember;
import com.md.model.shengcs.Usercompanyinfo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Administrator
 */
public class FamilymemberJpaController implements Serializable {

    public FamilymemberJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Familymember familymember) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Family FFamilyid = familymember.getFFamilyid();
            if (FFamilyid != null) {
                FFamilyid = em.getReference(FFamilyid.getClass(), FFamilyid.getFFamilyid());
                familymember.setFFamilyid(FFamilyid);
            }
            Usercompanyinfo uciId = familymember.getUciId();
            if (uciId != null) {
                uciId = em.getReference(uciId.getClass(), uciId.getUciId());
                familymember.setUciId(uciId);
            }
            em.persist(familymember);
            if (FFamilyid != null) {
                FFamilyid.getFamilymemberList().add(familymember);
                FFamilyid = em.merge(FFamilyid);
            }
            if (uciId != null) {
                uciId.getFamilymemberList().add(familymember);
                uciId = em.merge(uciId);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFamilymember(familymember.getFmId()) != null) {
                throw new PreexistingEntityException("Familymember " + familymember + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Familymember familymember) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Familymember persistentFamilymember = em.find(Familymember.class, familymember.getFmId());
            Family FFamilyidOld = persistentFamilymember.getFFamilyid();
            Family FFamilyidNew = familymember.getFFamilyid();
            Usercompanyinfo uciIdOld = persistentFamilymember.getUciId();
            Usercompanyinfo uciIdNew = familymember.getUciId();
            if (FFamilyidNew != null) {
                FFamilyidNew = em.getReference(FFamilyidNew.getClass(), FFamilyidNew.getFFamilyid());
                familymember.setFFamilyid(FFamilyidNew);
            }
            if (uciIdNew != null) {
                uciIdNew = em.getReference(uciIdNew.getClass(), uciIdNew.getUciId());
                familymember.setUciId(uciIdNew);
            }
            familymember = em.merge(familymember);
            if (FFamilyidOld != null && !FFamilyidOld.equals(FFamilyidNew)) {
                FFamilyidOld.getFamilymemberList().remove(familymember);
                FFamilyidOld = em.merge(FFamilyidOld);
            }
            if (FFamilyidNew != null && !FFamilyidNew.equals(FFamilyidOld)) {
                FFamilyidNew.getFamilymemberList().add(familymember);
                FFamilyidNew = em.merge(FFamilyidNew);
            }
            if (uciIdOld != null && !uciIdOld.equals(uciIdNew)) {
                uciIdOld.getFamilymemberList().remove(familymember);
                uciIdOld = em.merge(uciIdOld);
            }
            if (uciIdNew != null && !uciIdNew.equals(uciIdOld)) {
                uciIdNew.getFamilymemberList().add(familymember);
                uciIdNew = em.merge(uciIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = familymember.getFmId();
                if (findFamilymember(id) == null) {
                    throw new NonexistentEntityException("The familymember with id " + id + " no longer exists.");
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
            Familymember familymember;
            try {
                familymember = em.getReference(Familymember.class, id);
                familymember.getFmId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The familymember with id " + id + " no longer exists.", enfe);
            }
            Family FFamilyid = familymember.getFFamilyid();
            if (FFamilyid != null) {
                FFamilyid.getFamilymemberList().remove(familymember);
                FFamilyid = em.merge(FFamilyid);
            }
            Usercompanyinfo uciId = familymember.getUciId();
            if (uciId != null) {
                uciId.getFamilymemberList().remove(familymember);
                uciId = em.merge(uciId);
            }
            em.remove(familymember);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Familymember> findFamilymemberEntities() {
        return findFamilymemberEntities(true, -1, -1);
    }

    public List<Familymember> findFamilymemberEntities(int maxResults, int firstResult) {
        return findFamilymemberEntities(false, maxResults, firstResult);
    }

    private List<Familymember> findFamilymemberEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Familymember.class));
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

    public Familymember findFamilymember(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Familymember.class, id);
        } finally {
            em.close();
        }
    }

    public int getFamilymemberCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Familymember> rt = cq.from(Familymember.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
