package org.spring.service;

import java.util.List;
import java.util.Set;

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
 * Service for processing Persons
 * 
 * @author Krams at {@link http://krams915@blogspot.com
 */
@Service("personService")
@Transactional
public class PersonService {

	protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	SessionFactory sessionFactory;
	
	/**
	 * Retrieves all persons
	 * 
	 * @return a list of persons
	 */
	public List<Person> getAll() {
		logger.debug("Retrieving all persons");
		
		// Create a JPA query
		return this.sessionFactory.getCurrentSession().createQuery("FROM Person").list();
		
		// Retrieve all
		//return query.getResultList();
	}
	
	/**
	 * Retrieves a single person
	 */
	public Person get( Integer id ) {
		
		// Retrieve existing person
		// Create a JPA query
		return (Person) this.sessionFactory.getCurrentSession().createQuery("FROM Person as p LEFT JOIN FETCH  p.creditCards WHERE p.id="+id).uniqueResult();
		
	}
	
	/**
	 * Adds a new person
	 */
	public void add(Person person) {
		logger.debug("Adding new person");
		
		// Persists to db
		this.sessionFactory.getCurrentSession().persist(person);
	}
	
	/**
	 * Deletes an existing person
	 * @param id the id of the existing person
	 */
	public void delete(Integer id) {
		logger.debug("Deleting existing person");
		
		// Create a Hibernate query (HQL)
		
	
		// Retrieve record
		Person person = (Person) this.sessionFactory.getCurrentSession().createQuery("FROM Person as p LEFT JOIN FETCH  p.creditCards WHERE p.id="+id).uniqueResult();
		
		Set<CreditCard> creditCards =person.getCreditCards();
		
		// Delete person
		this.sessionFactory.getCurrentSession().delete(person);
		
		// Delete associated credit cards
		for (CreditCard creditCard: creditCards) {
			this.sessionFactory.getCurrentSession().delete(creditCard);
		}
	}
	
	/**
	 * Edits an existing person
	 */
	public void edit(Person person) {
		logger.debug("Editing existing person");
		
		// Retrieve existing person via id
		Person existingPerson = this.get(person.getId());
		
		// Assign updated values to this person
		existingPerson.setFirstName(person.getFirstName());
		existingPerson.setLastName(person.getLastName());
		existingPerson.setMoney(person.getMoney());

		// Save updates
		this.sessionFactory.getCurrentSession().merge(existingPerson);
	}
}
