/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import GestionModelo.FormulaMatematica;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Utilidades.NonexistentEntityException;
import Utilidades.PreexistingEntityException;

/**
 *
 * @author Ryzen 5
 */
public class FormulaMatematicaJpaController implements Serializable {

    public FormulaMatematicaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(FormulaMatematica formulaMatematica) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(formulaMatematica);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFormulaMatematica(formulaMatematica.getIdFormulaMatematica()) != null) {
                throw new PreexistingEntityException("FormulaMatematica " + formulaMatematica + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(FormulaMatematica formulaMatematica) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            formulaMatematica = em.merge(formulaMatematica);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = formulaMatematica.getIdFormulaMatematica();
                if (findFormulaMatematica(id) == null) {
                    throw new NonexistentEntityException("The formulaMatematica with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FormulaMatematica formulaMatematica;
            try {
                formulaMatematica = em.getReference(FormulaMatematica.class, id);
                formulaMatematica.getIdFormulaMatematica();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The formulaMatematica with id " + id + " no longer exists.", enfe);
            }
            em.remove(formulaMatematica);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<FormulaMatematica> findFormulaMatematicaEntities() {
        return findFormulaMatematicaEntities(true, -1, -1);
    }

    public List<FormulaMatematica> findFormulaMatematicaEntities(int maxResults, int firstResult) {
        return findFormulaMatematicaEntities(false, maxResults, firstResult);
    }

    private List<FormulaMatematica> findFormulaMatematicaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FormulaMatematica.class));
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

    public FormulaMatematica findFormulaMatematica(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FormulaMatematica.class, id);
        } finally {
            em.close();
        }
    }

    public int getFormulaMatematicaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<FormulaMatematica> rt = cq.from(FormulaMatematica.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
