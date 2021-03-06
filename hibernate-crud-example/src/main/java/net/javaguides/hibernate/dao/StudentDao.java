package net.javaguides.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.*;

import net.javaguides.hibernate.model.Student;
import net.javaguides.hibernate.util.HibernateUtil;

public class StudentDao {
	
	public void saveStudent(Student student) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//Begin Transaction
			transaction = session.beginTransaction();
			
			//Save Student Object
			session.save(student);
			
			//Commit Transaction
			transaction.commit();
		}
		catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
		}
	}
	
	public void updateStudent(Student student) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//Begin Transaction
			transaction = session.beginTransaction();
			
			//Save Student Object
			session.saveOrUpdate(student);
			
			//Commit Transaction
			transaction.commit();
		}
		catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
		}
	}	
	
	public Student getStudentById(long id) {
		Transaction transaction = null;
		Student student = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//Begin Transaction
			transaction = session.beginTransaction();
			
			//Get Student Object
			student = session.get(Student.class, id);
			
			//Commit Transaction
			transaction.commit();
		}
		catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
		}
		return student;
	}	

	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents() {
		Transaction transaction = null;
		List<Student> students = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//Begin Transaction
			transaction = session.beginTransaction();
			
			//Get Students
			students = session.createQuery("from Student").list();
			
			//Commit Transaction
			transaction.commit();
		}
		catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
		}
		return students;
	}	

	public Student deleteStudent(long id) {
		Transaction transaction = null;
		Student student = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//Begin Transaction
			transaction = session.beginTransaction();
			
			//Get Student Object
			student = session.get(Student.class, id);
			session.delete(student);
			//Commit Transaction
			transaction.commit();
		}
		catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
		}
		return student;
	}	
	
}
