package org.spring.dao;

import java.util.List;

import org.spring.model.Company;

public interface CompanyDao {
	
	void persist(Company company);
	
	void update(Company company);

	void delete(Company company);

	Company findById(Long companyId);

	Company findByName(String companyName);

	List<Company> getAllCompany();

}