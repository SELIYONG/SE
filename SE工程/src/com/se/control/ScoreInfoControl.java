package com.se.control;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.se.dao.CourseInfoTableDAO;
import com.se.dao.ScoreInfoTableDAO;
import com.se.dao.StudentInfoTableDAO;
import com.se.factory.HibernateSessionFactory;
import com.se.model.CourseInfoTable;
import com.se.model.ScoreInfoTable;
import com.se.model.StudentCourseScore;
import com.se.model.StudentInfoTable;

public class ScoreInfoControl {
	
	private static ScoreInfoControl siControl = null;
	public static ScoreInfoControl getScoreInfoControl(){
		if(siControl == null){
			siControl = new ScoreInfoControl();
		}
		return siControl;
	}
	
	private ScoreInfoTableDAO scoreDao = null;
	private StudentInfoTableDAO studentDao = null;
	private CourseInfoTableDAO courseDao = null;
	private Session session = null;
	
	private ScoreInfoControl(){
		scoreDao = new ScoreInfoTableDAO();
		studentDao = new StudentInfoTableDAO();
		courseDao = new CourseInfoTableDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	public void saveScore(ScoreInfoTable score){
		Transaction transaction = session.beginTransaction();
		scoreDao.save(score);
		transaction.commit();
		session.flush();
	}
	
	public ArrayList<StudentCourseScore> findStudentScore(String studentNumber){
		Transaction transaction = session.beginTransaction();
		String stuNo;
		String stuName;
		String courseNo;
		String courseName;
		double score;
		ArrayList<StudentCourseScore> arrayList = new ArrayList<StudentCourseScore>();
		
		String sql = "select * from ScoreInfoTable where stuNo = "+studentNumber;
		List<ScoreInfoTable> list = session.createSQLQuery(sql).addEntity(ScoreInfoTable.class).list();
		//System.out.println(list.get(0).getId().getCourseNo()+list.get(0).getId().getStuNo()+list.get(0).getScore());
		
		StudentInfoTable student = studentDao.findById(studentNumber);
		
		for(int i = 0;i < list.size();i++){
			stuNo = student.getStuNo();
			stuName = student.getStuName();
			courseNo = list.get(i).getId().getCourseNo();
			CourseInfoTable course = courseDao.findById(courseNo);
			courseName = course.getCourseName();
			score = list.get(i).getScore();
			//System.out.println(stuNo+'\t'+stuName+'\t'+ courseNo +'\t'+courseName+'\t'+ score);
			
			StudentCourseScore e = new StudentCourseScore(stuNo,stuName,courseNo,courseName,score);		
			arrayList.add(e);
		}
		
		transaction.commit();
		session.flush();
		session.clear();
		session.close();
		return arrayList;
	}
	
}
