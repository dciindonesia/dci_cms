package org.spring.dao;

import java.util.List;
import org.spring.model.Industry;

public interface IndustryDao {
	void persist(Industry industry);
	void update(Industry industry);
	void delete(Industry industry);
	Industry findById(int industryId);
	Industry findByName(String industryName);
	List<Industry> getAllindustry();
}
