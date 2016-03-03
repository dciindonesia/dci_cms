package org.spring.dao;

import java.util.List;

import org.spring.model.Registration;
import org.spring.model.Users;

public abstract interface RegistrationDao
{
  public abstract void persist(Registration paramRegistration);

  public abstract void delete(Registration paramRegistration);

  public abstract Registration findById(Long paramLong);

  public abstract Registration findByEmail(String paramString);

  public abstract List<Registration> getAllRegistration();
}

/* Location:           /Users/rahadhitya/Downloads/DCI/WEB-INF/classes/
 * Qualified Name:     org.spring.dao.RegistrationDao
 * JD-Core Version:    0.6.2
 */