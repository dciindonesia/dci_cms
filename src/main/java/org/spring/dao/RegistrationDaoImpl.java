/*     */ package org.spring.dao;
/*     */ 
/*     */ import java.util.List;

/*     */ import org.apache.log4j.Logger;
/*     */ import org.hibernate.Query;
/*     */ import org.hibernate.SessionFactory;
/*     */ import org.hibernate.classic.Session;
/*     */ import org.spring.model.Registration;
import org.spring.model.Users;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Repository;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ 
/*     */ @Repository
/*     */ public class RegistrationDaoImpl
/*     */   implements RegistrationDao
/*     */ {
/*  22 */   protected static Logger log = Logger.getLogger(RegistrationDaoImpl.class);
/*     */ 
/*     */   @Autowired
/*     */   private SessionFactory sessionFactory;
/*     */ 
/*     */   @Transactional
/*     */   public void persist(Registration registration)
/*     */   {
/*  33 */     log.debug("save/update Registration instance " + registration.getEmail());
/*     */     try {
/*  35 */       this.sessionFactory.getCurrentSession().persist(registration);
/*  36 */       log.debug("persist successful");
/*     */     } catch (RuntimeException re) {
/*  38 */       log.error("persist failed", re);
/*  39 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   @Transactional
/*     */   public void delete(Registration registration)
/*     */   {
/*  50 */     log.debug("deleting Registration instance " + registration.getEmail());
/*     */     try {
/*  52 */       this.sessionFactory.getCurrentSession().delete(registration);
/*  53 */       log.debug("delete successful");
/*     */     } catch (RuntimeException re) {
/*  55 */       log.error("delete failed", re);
/*  56 */       throw re;
/*     */     }
/*     */   }
/*     */ 
/*     */   @Transactional(readOnly=true)
/*     */   public Registration findById(Long id)
/*     */   {
/*  67 */     log.debug("getting Registration instance with id: " + id);
/*  68 */     return (Registration)this.sessionFactory.getCurrentSession().get(Registration.class, id);
/*     */   }
/*     */ 
/*     */   @Transactional(readOnly=true)
/*     */   public Registration findByEmail(String email)
/*     */   {
/*  77 */     log.debug("getting Registration instance with email: " + email);
/*     */     try {
/*  79 */       Registration instance = (Registration)this.sessionFactory.getCurrentSession().createQuery("from " + Registration.class.getName() + " r where r.email='" + email + "'").uniqueResult();
/*     */ 
/*  81 */       if (instance == null)
/*  82 */         log.debug("get successful, no instance found");
/*     */       else {
/*  84 */         log.debug("get successful, instance found");
/*     */       }
/*  86 */       return instance;
/*     */     } catch (RuntimeException re) {
/*  88 */       log.error("get failed", re);
/*  89 */       throw re;
/*     */     }
/*     */   }
/*     */ 
	@Transactional(readOnly=true)
	public List<Registration> getAllRegistration()
	{
	/*
	List instance = (List<Registration>)this.sessionFactory.getCurrentSession().find("from " + Registration.class.getName());
	//List<Users> instance = (List<Users>) session
	//		.find("from " + Users.class.getName());
	return instance;
	*/
	log.debug("getting All Registration instance");
	try
	{
		List instance = this.sessionFactory.getCurrentSession().find("from " + Registration.class.getName());
		if (instance == null)
			log.debug("get successful, no instance found");
		else
			log.debug("get successful, instance found");
		return instance;
	} catch (RuntimeException re) {
		log.error("get failed", re);
		throw re;
	}
	}

}

/* Location:           /Users/rahadhitya/Downloads/DCI/WEB-INF/classes/
 * Qualified Name:     org.spring.dao.RegistrationDaoImpl
 * JD-Core Version:    0.6.2
 */