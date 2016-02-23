package org.spring.dao;

import java.util.List;

import org.spring.model.Countries;

public interface CountryDao {
	void persist(Countries country);
	void update(Countries country);
	void delete(Countries country);
	Countries findById(int countryId);
	Countries findByName(String countryName);
	List<Countries> getAllCountry();
}
