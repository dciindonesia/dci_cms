package org.spring.dao;

import java.util.List;

import org.spring.model.Company;

public interface CompanyDao {
	
	Long persist(Company company);
	
	void update(Company company);

	void delete(Long companyId);

	Company findById(Long companyId);

	Company findByName(String companyName);

	List<Company> getAllCompany();

	List<Company> getAllCompSearch(String searching);

	Company findByAdmin(String adminName);
}
