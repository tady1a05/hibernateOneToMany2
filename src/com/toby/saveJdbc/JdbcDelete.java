package com.toby.saveJdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.toby.model.Course;
import com.toby.model.Instructor;
import com.toby.model.InstructorDetail;
import com.toby.model.Review;

public class JdbcDelete {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = null;
		
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			Review review = session.get(Review.class, "8");
			session.delete(review);
			session.getTransaction().commit();
			session.close();
		}finally {
			factory.close();
		}

	}

}
