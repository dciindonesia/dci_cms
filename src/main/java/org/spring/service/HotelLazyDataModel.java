/**
 * 
 */
package org.spring.service;

import java.util.List;
import java.util.Map;

import org.spring.dao.ContactPersonDao;
import org.spring.model.ContactPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelLazyDataModel {// extends LazyDataModel<Hotel> {

    private static final long serialVersionUID = -8832831134966938627L;

    SearchCriteria searchCriteria;
    @Autowired
    ContactPersonDao contactPersonDao;

    private ContactPerson selected;
    
    public HotelLazyDataModel(){}

    public HotelLazyDataModel(SearchCriteria searchCriteria, ContactPersonDao contactPersonDao) {
	this.searchCriteria = searchCriteria;
	this.contactPersonDao = contactPersonDao;
    }
    
    
    public List<ContactPerson> load(int first, int pageSize, String sortField, boolean ascending, Map<String, String> filters) {
	searchCriteria.setCurrentPage(first / pageSize + 1);
	return contactPersonDao.findHotels(searchCriteria, first, sortField, ascending);
    }
    
    
    public int getRowCount() {
	return contactPersonDao.getNumberOfHotels(searchCriteria);
    }
	
    public ContactPerson getSelected() {
	return selected;
    }

    public void setSelected(ContactPerson selected) {
	this.selected = selected;
    }

    public int getCurrentPage() {
	return this.searchCriteria.getCurrentPage();
    }

    public int getPageSize() {
	return this.searchCriteria.getPageSize();
    }

}