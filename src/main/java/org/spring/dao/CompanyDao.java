package org.spring.dao;

import java.util.List;

import org.spring.model.Company;

public interface CompanyDao {
	
	int persist(Company company);
	
	void update(Company company);

	void delete(Company company);

	Company findById(int companyId);

	Company findByName(String companyName);

	List<Company> getAllCompany();

}
