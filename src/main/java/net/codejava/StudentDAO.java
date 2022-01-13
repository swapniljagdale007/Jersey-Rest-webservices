package net.codejava;

import java.util.ArrayList;
import java.util.List;


public class StudentDAO {
	private static StudentDAO instance;
	private static List<Student> data = new ArrayList<>();
	
	static {
		data.add(new Student(1, "swapnil", 1999-12-11, 2021-12-20));
		data.add(new Student(2, "Krushna", 1999-8-21, 2021-12-20));
	}
	
	private StudentDAO() {
		
		}
	
	public static StudentDAO getInstance() {
		if (instance == null) {
			instance = new StudentDAO();
		}
		
		return instance;
	}
	
	public List<Student> listAll(){
		return new ArrayList<Student>(data);
	}
	
	public int add(Student student) {
		
		int newId = data.size() + 1;
		student.setId(newId);
		data.add(student);
		
		return newId;
	}
	
	public Student get(int studno) {
		Student studentToFind = new Student(studno);
		int index = data.indexOf(studentToFind);
		if(index >= 0) {
			return data.remove(index);

		}
		return null;
	}
	
	public boolean delete(int studno) {
		Student studentToFind = new Student(studno);
		int index = data.indexOf(studentToFind);
		if (index >=  0) {
			data.remove(index);
			return true;
			
		}
		return false;
	}
	
	public boolean update(Student student) {
		int index= data.indexOf(student);
		if (index >= 0) {
			data.set(index, student);
			return true;
		}
		return false;
	}
	}


