package com.bharat.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bharat.hibernate.demo.entity.Instructor;
import com.bharat.hibernate.demo.entity.InstructorDetails;

public class CreateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				                                    .addAnnotatedClass(InstructorDetails.class)
				                                    .addAnnotatedClass(Instructor.class)
				                                    .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			InstructorDetails tempInstructorsDetail = new InstructorDetails("www.youtube.com/faang", "dance");
			Instructor tempInstructor = new Instructor("Mark", "Zcrberg", "faang@spring.com");
			tempInstructor.setInstructorDetail(tempInstructorsDetail);
			session.beginTransaction();
			session.save(tempInstructor);
			session.getTransaction().commit();
		}
		finally {
			session.close();
		}
	}
}


