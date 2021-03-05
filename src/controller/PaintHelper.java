package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Paint;

/**
 * 
 * @author Jeremy Brannen - jrbrannen CIS175 Feb 11, 2021
 */
public class PaintHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebPaintList");

	public void insertPaint(Paint toAdd) {

		// create entity manager object and add it to the database
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();

	}

	public void deletePaint(Paint toDelete) {

		// create a entity manager object using persistence
		EntityManager em = emfactory.createEntityManager();

		// queries the database for matching search criteria and stores any matches as
		// variables in a list
		em.getTransaction().begin();
		TypedQuery<Paint> typedQuery = em.createQuery(
				"select li from Paint li where li.brand = :selectedBrand and li.color = :selectedColor and li.medium = :selectedMedium", Paint.class);

		// sub parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedBrand", toDelete.getBrand());
		typedQuery.setParameter("selectedColor", toDelete.getColor());
		typedQuery.setParameter("selectedMedium", toDelete.getMedium());

		// single result
		typedQuery.setMaxResults(1);

		// save result into a new list item
		Paint result = typedQuery.getSingleResult();

		// remove the result
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public List<Paint> showAllItems() {

		// users entity manager object to query data and puts the data in a list
		EntityManager em = emfactory.createEntityManager();
		List<Paint> allItems = em.createQuery("SELECT i FROM Paint i").getResultList();
		return allItems;
	}

	public List<Paint> searchForPaintByBrand(String brandName) {

		// uses entity manager object to search database for a brand and
		// saves all paints that match with the brand
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Paint> typedQuery = em.createQuery("select li from Paint li where li.brand = :selectedBrand",
				Paint.class);
		typedQuery.setParameter("selectedBrand", brandName);

		List<Paint> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<Paint> searchForPaintByColor(String colorName) {

		// uses entity manager object to search database for a color and
		// saves all paints that match with the color
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Paint> typedQuery = em.createQuery("select li from Paint li where li.color = :selectedColor",
				Paint.class);
		typedQuery.setParameter("selectedColor", colorName);

		List<Paint> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<Paint> searchForPaintByMedium(String mediumType) {

		// uses entity manager object to search database for a medium and
		// saves all paints that match with the medium
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Paint> typedQuery = em.createQuery("select li from Paint li where li.medium = :selectedMedium",
				Paint.class);
		typedQuery.setParameter("selectedMedium", mediumType);

		List<Paint> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public Paint searchForPaintById(int idToEdit) {

		// uses entity manager object to search database for an id
		// and returns it in a variable
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Paint found = em.find(Paint.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(Paint toEdit) {

		// uses entity object to merge(update) brand, color, or medium depending on
		// user input and saves it to the database using the id number
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public void cleanUp() {
		// TODO Auto-generated method stub
		emfactory.close();

	}

}
