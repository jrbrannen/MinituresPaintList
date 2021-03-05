/**
 * 
 */
package controller;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Painter;

/**
 * @author Jeremy Brannen - jrbrannen
 *CIS175
 * Mar 3, 2021
 */
public class PainterHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebPaintList");
	
	public void insertPainter(Painter p) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Painter> showAllPainters(){
		EntityManager em = emfactory.createEntityManager();
		List<Painter> allPainters = em.createQuery("SELECT p FROM Painter p").getResultList();
		return allPainters;
	}

	/**
	 * @param tempId
	 * @return
	 */
	public Painter searchForPainterById(Integer idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Painter found = em.find(Painter.class, idToEdit);
		em.close();
		return found;
	}

	/**
	 * @param painterToDelete
	 */
	public void deletePainter(Painter toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Painter> typedQuery = em.createQuery("select p from Painter p where p.name = :selectedName and p.age = :selectedAge and p.technique = :selectedTechnique", Painter.class);
		
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedAge", toDelete.getAge());
		typedQuery.setParameter("selectedTechnique", toDelete.getTechnique());
		
		typedQuery.setMaxResults(1);
		
		Painter result	= typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}

	/**
	 * @param painterToUpdate
	 */
	public void updatePainter(Painter toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void cleanUp() {
		emfactory.close();
	}

}
