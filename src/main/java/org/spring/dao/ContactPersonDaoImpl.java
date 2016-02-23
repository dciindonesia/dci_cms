/**
 * 
 */
package org.spring.dao;

import org.hibernate.SessionFactory;
import org.spring.model.ContactPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author rahadhitya
 *
 */
@Repository
public class ContactPersonDaoImpl implements ContactPersonDao {

	@Autowired
	SessionFactory sessionFactory;
	
	/* (non-Javadoc)
	 * @see org.spring.dao.ContactPersonDao#persist(org.spring.model.ContactPerson)
	 */
	@Transactional
	@Override
	public void persist(ContactPerson contactPerson) {
		sessionFactory.getCurrentSession().persist(contactPerson);
	}

}
