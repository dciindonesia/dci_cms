package org.spring.service;

import java.io.Serializable;
import java.util.List;

import org.spring.dao.ContactPersonDao;
import org.spring.model.ContactPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * A backing bean for the main hotel search form. Encapsulates the criteria needed to perform a hotel search.
 */
@Service
public class SearchCriteria implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Autowired
    ContactPersonDao contactPersonDao;

    /**
     * The user-provided search criteria for finding Hotels.
     */
    private String searchString = "";

    /**
     * The maximum page size of the Hotel result list
     */
    private int pageSize = 5;

    /**
     * The page the user is currently on.
     */
    private int currentPage = 1;

    /**
     * Returns a {@link DataModel} based on the search criteria.
     * @param bookingService the service to use to retrieve hotels.
     */
    /*
    public List<ContactPerson> getDataModel(ContactPersonDao contactPersonDao) {
	return new HotelLazyDataModel(this, contactPersonDao);
    }
	*/
    public String getSearchString() {
	return searchString;
    }

    public void setSearchString(String searchString) {
	this.searchString = searchString;
    }

    public int getPageSize() {
	return pageSize;
    }

    public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
    }

    public int getCurrentPage() {
	return currentPage;
    }

    public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
    }

    public String toString() {
	return "[Search Criteria searchString = '" + searchString + "'";
    }

}