package com.se.control;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.se.dao.AdminInfoTableDAO;
import com.se.factory.HibernateSessionFactory;
import com.se.model.AdminInfoTable;







public class AdminControl {
	
	private static AdminControl control = null;
	public static AdminControl getAdminControl(){
		if(control == null){
			control = new AdminControl();
		}
		return control;
	}
	
	private AdminInfoTableDAO adminDao = null;
	private Session session = null;
	private AdminControl(){
		adminDao = new AdminInfoTableDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	public void save(AdminInfoTable admin){
		Transaction transaction = session.beginTransaction();
		adminDao.save(admin);
		transaction.commit();
		session.flush();
	}
	
	//得到统一类型管理员的信息
	
	public List<AdminInfoTable> getAdmin(String adminTypeId){
		return adminDao.findByAdminTypeId(adminTypeId);
	}
	
	public String getPassword(String adminId){
		return adminDao.findById(adminId).getAdminPassword();
	}
	
	//得到所有员工的信息
	public List<AdminInfoTable> getAllAdmin(){
		return adminDao.findAll();
	}
	
	//保存一个员工的信息
	public void saveAdmin(AdminInfoTable admin){
		Transaction tr = session.beginTransaction();
		adminDao.save(admin);
		tr.commit();
		session.flush();
	}
	
	
}
