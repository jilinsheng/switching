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
import com.md.model.shengcs.Familymember;
import com.md.model.shengcs.Usercompanyinfo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Administrator
 */
public class UsercompanyinfoJpaController implements Serializable {

    public UsercompanyinfoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usercompanyinfo usercompanyinfo) throws PreexistingEntityException, Exception {
        if (usercompanyinfo.getFamilymemberList() == null) {
            usercompanyinfo.setFamilymemberList(new ArrayList<Familymember>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Familymember> attachedFamilymemberList = new ArrayList<Familymember>();
            for (Familymember familymemberListFamilymemberToAttach : usercompanyinfo.getFamilymemberList()) {
                familymemberListFamilymemberToAttach = em.getReference(familymemberListFamilymemberToAttach.getClass(), familymemberListFamilymemberToAttach.getFmId());
                attachedFamilymemberList.add(familymemberListFamilymemberToAttach);
            }
            usercompanyinfo.setFamilymemberList(attachedFamilymemberList);
            em.persist(usercompanyinfo);
            for (Familymember familymemberListFamilymember : usercompanyinfo.getFamilymemberList()) {
                Usercompanyinfo oldUciIdOfFamilymemberListFamilymember = familymemberListFamilymember.getUciId();
                familymemberListFamilymember.setUciId(usercompanyinfo);
                familymemberListFamilymember = em.merge(familymemberListFamilymember);
                if (oldUciIdOfFamilymemberListFamilymember != null) {
                    oldUciIdOfFamilymemberListFamilymember.getFamilymemberList().remove(familymemberListFamilymember);
                    oldUciIdOfFamilymemberListFamilymember = em.merge(oldUciIdOfFamilymemberListFamilymember);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsercompanyinfo(usercompanyinfo.getUciId()) != null) {
                throw new PreexistingEntityException("Usercompanyinfo " + usercompanyinfo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usercompanyinfo usercompanyinfo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usercompanyinfo persistentUsercompanyinfo = em.find(Usercompanyinfo.class, usercompanyinfo.getUciId());
            List<Familymember> familymemberListOld = persistentUsercompanyinfo.getFamilymemberList();
            List<Familymember> familymemberListNew = usercompanyinfo.getFamilymemberList();
            List<Familymember> attachedFamilymemberListNew = new ArrayList<Familymember>();
            for (Familymember familymemberListNewFamilymemberToAttach : familymemberListNew) {
                familymemberListNewFamilymemberToAttach = em.getReference(familymemberListNewFamilymemberToAttach.getClass(), familymemberListNewFamilymemberToAttach.getFmId());
                attachedFamilymemberListNew.add(familymemberListNewFamilymemberToAttach);
            }
            familymemberListNew = attachedFamilymemberListNew;
            usercompanyinfo.setFamilymemberList(familymemberListNew);
            usercompanyinfo = em.merge(usercompanyinfo);
            for (Familymember familymemberListOldFamilymember : familymemberListOld) {
                if (!familymemberListNew.contains(familymemberListOldFamilymember)) {
                    familymemberListOldFamilymember.setUciId(null);
                    familymemberListOldFamilymember = em.merge(familymemberListOldFamilymember);
                }
            }
            for (Familymember familymemberListNewFamilymember : familymemberListNew) {
                if (!familymemberListOld.contains(familymemberListNewFamilymember)) {
                    Usercompanyinfo oldUciIdOfFamilymemberListNewFamilymember = familymemberListNewFamilymember.getUciId();
                    familymemberListNewFamilymember.setUciId(usercompanyinfo);
                    familymemberListNewFamilymember = em.merge(familymemberListNewFamilymember);
                    if (oldUciIdOfFamilymemberListNewFamilymember != null && !oldUciIdOfFamilymemberListNewFamilymember.equals(usercompanyinfo)) {
                        oldUciIdOfFamilymemberListNewFamilymember.getFamilymemberList().remove(familymemberListNewFamilymember);
                        oldUciIdOfFamilymemberListNewFamilymember = em.merge(oldUciIdOfFamilymemberListNewFamilymember);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = usercompanyinfo.getUciId();
                if (findUsercompanyinfo(id) == null) {
                    throw new NonexistentEntityException("The usercompanyinfo with id " + id + " no longer exists.");
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
            Usercompanyinfo usercompanyinfo;
            try {
                usercompanyinfo = em.getReference(Usercompanyinfo.class, id);
                usercompanyinfo.getUciId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usercompanyinfo with id " + id + " no longer exists.", enfe);
            }
            List<Familymember> familymemberList = usercompanyinfo.getFamilymemberList();
            for (Familymember familymemberListFamilymember : familymemberList) {
                familymemberListFamilymember.setUciId(null);
                familymemberListFamilymember = em.merge(familymemberListFamilymember);
            }
            em.remove(usercompanyinfo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usercompanyinfo> findUsercompanyinfoEntities() {
        return findUsercompanyinfoEntities(true, -1, -1);
    }

    public List<Usercompanyinfo> findUsercompanyinfoEntities(int maxResults, int firstResult) {
        return findUsercompanyinfoEntities(false, maxResults, firstResult);
    }

    private List<Usercompanyinfo> findUsercompanyinfoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usercompanyinfo.class));
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

    public Usercompanyinfo findUsercompanyinfo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usercompanyinfo.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsercompanyinfoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usercompanyinfo> rt = cq.from(Usercompanyinfo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
