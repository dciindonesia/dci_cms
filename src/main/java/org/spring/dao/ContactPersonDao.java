/**
 * 
 */
package org.spring.dao;

import java.util.List;

import org.spring.model.ContactPerson;
import org.spring.service.SearchCriteria;

/**
 * @author rahadhitya
 *
 */
public interface ContactPersonDao {
	void persist (ContactPerson contactPerson, Long companyId);
	void delete(int contactId);
	void update(ContactPerson contactPerson);
	ContactPerson findById(int contactId);
	List<ContactPerson> getAllContactPerson(Long companyId);
	List<ContactPerson> getAllContactPerson();
	String getSearchPattern(SearchCriteria criteria);
	ContactPerson findContactPerson(String username);
	int getNumberOfHotels(SearchCriteria criteria);
	List<ContactPerson> findHotels(SearchCriteria searchCriteria, int first,
			String sortField, boolean ascending);
}
