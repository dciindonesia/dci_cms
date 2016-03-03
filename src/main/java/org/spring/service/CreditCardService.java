package org.spring.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.spring.model.CreditCard;
import org.spring.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for processing Credit Cards
 * 
 * @author Krams at {@link http://krams915@blogspot.com
 */
@Service("creditCardService")
@Transactional
public class CreditCardService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="personService")
	private PersonService personService;
	
	@Autowired
	SessionFactory sessionFactory;

    	/**
	 * Retrieves all credit cards
	 */
	public List<CreditCard> getAll(Integer personId) {
		logger.debug("Retrieving all credit cards");
		
		// Create a Hibernate query (HQL)
		
		Person person = (Person) this.sessionFactory.getCurrentSession().createQuery("FROM Person as p LEFT JOIN FETCH  p.creditCards WHERE p.id="+personId).uniqueResult();
		
		// Retrieve all
		return  new ArrayList<CreditCard>(person.getCreditCards());
	}
	
	/**
	 * Retrieves all credit cards
	 */
	public List<CreditCard> getAll() {
		logger.debug("Retrieving all credit cards");
		
		// Create a JPA query
		return this.sessionFactory.getCurrentSession().createQuery("FROM  CreditCard").list();
		
		// Retrieve all
		//return  query.getResultList();
	}
	
	/**
	 * Retrieves a single credit card
	 */
	public CreditCard get( Integer id ) {
		
		// Retrieve existing credit card
		CreditCard creditCard = (CreditCard) this.sessionFactory.getCurrentSession().createQuery("FROM CreditCard p WHERE p.id = :id")
		.setParameter("id", id).uniqueResult();
		
		// Persists to db
		return creditCard;
	}
	
	/**
	 * Adds a new credit card
	 */
	public void add(Integer personId, CreditCard creditCard) {
		logger.debug("Adding new credit card");
	
		// Persists to db
		this.sessionFactory.getCurrentSession().persist(creditCard);
		
		// Add to person as well
		// Retrieve existing person via id
		Person existingPerson = personService.get(personId);
		
		// Assign updated values to this person
		existingPerson.getCreditCards().add(creditCard);

		// Save updates
		personService.edit(existingPerson);
	}
	
	/**
	 * Deletes an existing credit card
	 */
	public void delete(Integer id) {
		logger.debug("Deleting existing credit card");
		
    	// Delete reference to foreign key credit card first
		// We need a SQL query instead of HQL query here to access the third table
    	this.sessionFactory.getCurrentSession().createQuery("DELETE FROM PERSON_CREDIT_CARD " +
    			"WHERE creditCards_ID="+id);
    	
    	//query.executeUpdate();
    	
		// Retrieve existing credit card
		CreditCard creditCard = this.get(id);
		
		// Delete 
		this.sessionFactory.getCurrentSession().delete(creditCard);
	}
	
	/**
	 * Edits an existing credit card
	 */
	public void edit(CreditCard creditCard) {
		logger.debug("Editing existing creditCard");
		
		// Retrieve existing credit card via id
		CreditCard existingCreditCard = this.get(creditCard.getId());
		
		// Assign updated values to this credit card
		existingCreditCard.setNumber(creditCard.getNumber());
		existingCreditCard.setType(creditCard.getType());

		// Save updates
		this.sessionFactory.getCurrentSession().merge(existingCreditCard);
	}
}
