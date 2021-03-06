package net.javaguides.hibernate;

import java.util.List;

import net.javaguides.hibernate.dao.StudentDao;
import net.javaguides.hibernate.model.Student;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentDao studentDao = new StudentDao();
		
		//SAVE STUDENT
		Student student = new Student("Tuhinadri","Banerjee","tuhiniris@gmail.com");
		studentDao.saveStudent(student);
		
		//UPDATE STUDENT
		student.setFirstName("Banu");
		studentDao.updateStudent(student);
		
		//GET STUDENT BY ID
		//Student student2 = studentDao.getStudentById(student.getId());
		
		//GET ALL STUDENT
		List<Student> students = studentDao.getAllStudents();
		students.forEach(student1 -> System.out.println(student1.getId()));
		
		//DELETE STUDENT
		//studentDao.deleteStudent(student.getId());
	}

}
