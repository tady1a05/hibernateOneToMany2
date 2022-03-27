package com.toby.saveJdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.toby.model.Course;
import com.toby.model.Instructor;
import com.toby.model.InstructorDetail;
import com.toby.model.Review;

public class JdbcSave {

	public static void main(String args[]) {
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
			Course course = new Course("Hist2 course");
			Instructor instructor = session.get(Instructor.class, "2");
			Review review1 = new Review("Bullshit");
			Review review2 = new Review("This course is good");
			
			course.setInstructor(instructor);
			course.add(review1);
			course.add(review2);
			session.save(course);
			session.getTransaction().commit();
			session.close();

		}finally {
			factory.close();
		}
	}

}
