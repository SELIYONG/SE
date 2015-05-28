package com.se.control;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.se.dao.CourseInfoTableDAO;
import com.se.factory.HibernateSessionFactory;
import com.se.model.CourseInfoTable;

public class CourseInfoControl {
	
	private static CourseInfoControl ciControl = null;
	public static CourseInfoControl getCourseControl(){
		if(ciControl == null){
			ciControl = new CourseInfoControl();
		}
		return ciControl;
	}
	
	
	private CourseInfoTableDAO courseDao = null;
	private Session session = null;
	private CourseInfoControl(){
		courseDao = new CourseInfoTableDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	public void saveCourse(CourseInfoTable course){
		Transaction transaction = session.beginTransaction();
		courseDao.save(course);
		transaction.commit();
		session.flush();
	}
	
	//找到所有课程
	public List<CourseInfoTable> getAllCourse(){
		List<CourseInfoTable> list = courseDao.findAll();
		return list;
	}

}
