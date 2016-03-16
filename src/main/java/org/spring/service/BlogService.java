package org.spring.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.spring.model.Blog;
import org.spring.model.Item;
import org.spring.model.Pers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BlogService {
	
	@Autowired
	SessionFactory sessionFactory;

//	
//	public void saveItems(Blog blog) {
//		try {
//			List<Item> items = rssService.getItems(blog.getUrl());
//			for (Item item : items) {
//				Item savedItem = itemRepository.findByBlogAndLink(blog, item.getLink());
//				if(savedItem == null) {
//					item.setBlog(blog);
//					itemRepository.save(item);
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	// 1 hour = 60 seconds * 60 minutes * 1000
	@Scheduled(fixedDelay=3600000)
	public void reloadBlogs() {
		List<Blog> blogs = (List<Blog>) this.sessionFactory.getCurrentSession().createQuery("FROM Blog").list();
//		for (Blog blog : blogs) {
//			saveItems(blog);
//		}
	}

	@Transactional
	public void save(Blog blog, String name) {
		//Pers user = (Pers) this.sessionFactory.getCurrentSession().createQuery("FROM Blog").uniqueResult();
		Pers pers = new Pers();
		pers.setEmail("aa");
		pers.setEnabled(true);
		pers.setName("Joni");
		pers.setPassword("rahapsia");
		this.sessionFactory.getCurrentSession().save(pers);
		blog.setUser(pers);
		this.sessionFactory.getCurrentSession().save(blog);
//		saveItems(blog);
	}
//
//	@PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
//	public void delete(@P("blog") Blog blog) {
//		blogRepository.delete(blog);
//	}
//
//	public Blog findOne(int id) {
//		return blogRepository.findOne(id);
//	}

}
