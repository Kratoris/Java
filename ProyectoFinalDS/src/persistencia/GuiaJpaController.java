/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import GestionModelo.Guia;
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
public class GuiaJpaController implements Serializable {

    public GuiaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Guia guia) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(guia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findGuia(guia.getCodigoGuia()) != null) {
                throw new PreexistingEntityException("Guia " + guia + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Guia guia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            guia = em.merge(guia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = guia.getCodigoGuia();
                if (findGuia(id) == null) {
                    throw new NonexistentEntityException("The guia with id " + id + " no longer exists.");
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
            Guia guia;
            try {
                guia = em.getReference(Guia.class, id);
                guia.getCodigoGuia();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The guia with id " + id + " no longer exists.", enfe);
            }
            em.remove(guia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Guia> findGuiaEntities() {
        return findGuiaEntities(true, -1, -1);
    }

    public List<Guia> findGuiaEntities(int maxResults, int firstResult) {
        return findGuiaEntities(false, maxResults, firstResult);
    }

    private List<Guia> findGuiaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Guia.class));
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

    public Guia findGuia(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Guia.class, id);
        } finally {
            em.close();
        }
    }

    public int getGuiaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Guia> rt = cq.from(Guia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
