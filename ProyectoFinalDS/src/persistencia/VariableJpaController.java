/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import GestionModelo.Variable;
import Utilidades.NonexistentEntityException;
import Utilidades.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Ryzen 5
 */
public class VariableJpaController implements Serializable {

    public VariableJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Variable variable) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(variable);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVariable(variable.getIdVariable()) != null) {
                throw new PreexistingEntityException("Variable " + variable + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Variable variable) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            variable = em.merge(variable);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = variable.getIdVariable();
                if (findVariable(id) == null) {
                    throw new NonexistentEntityException("The variable with id " + id + " no longer exists.");
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
            Variable variable;
            try {
                variable = em.getReference(Variable.class, id);
                variable.getIdVariable();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The variable with id " + id + " no longer exists.", enfe);
            }
            em.remove(variable);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Variable> findVariableEntities() {
        return findVariableEntities(true, -1, -1);
    }

    public List<Variable> findVariableEntities(int maxResults, int firstResult) {
        return findVariableEntities(false, maxResults, firstResult);
    }

    private List<Variable> findVariableEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Variable.class));
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

    public Variable findVariable(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Variable.class, id);
        } finally {
            em.close();
        }
    }

    public int getVariableCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Variable> rt = cq.from(Variable.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
