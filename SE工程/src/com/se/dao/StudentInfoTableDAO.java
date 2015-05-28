package com.se.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.se.model.StudentInfoTable;

/**
 * A data access object (DAO) providing persistence and search support for
 * StudentInfoTable entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.se.dao.StudentInfoTable
 * @author MyEclipse Persistence Tools
 */
public class StudentInfoTableDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(StudentInfoTableDAO.class);
	// property constants
	public static final String STU_NAME = "stuName";
	public static final String STU_IDNUMBER = "stuIdnumber";
	public static final String STU_SEX = "stuSex";
	public static final String STU_DEPARTMENT = "stuDepartment";
	public static final String STU_CLASS_NO = "stuClassNo";
	public static final String STU_NATIVE_PLACE = "stuNativePlace";
	public static final String STU_TELEPHONE = "stuTelephone";

	public void save(StudentInfoTable transientInstance) {
		log.debug("saving StudentInfoTable instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(StudentInfoTable persistentInstance) {
		log.debug("deleting StudentInfoTable instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StudentInfoTable findById(java.lang.String id) {
		log.debug("getting StudentInfoTable instance with id: " + id);
		try {
			StudentInfoTable instance = (StudentInfoTable) getSession().get(
					"com.se.model.StudentInfoTable", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(StudentInfoTable instance) {
		log.debug("finding StudentInfoTable instance by example");
		try {
			List results = getSession()
					.createCriteria("com.se.model.StudentInfoTable")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding StudentInfoTable instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from StudentInfoTable as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStuName(Object stuName) {
		return findByProperty(STU_NAME, stuName);
	}

	public List findByStuIdnumber(Object stuIdnumber) {
		return findByProperty(STU_IDNUMBER, stuIdnumber);
	}

	public List findByStuSex(Object stuSex) {
		return findByProperty(STU_SEX, stuSex);
	}

	public List findByStuDepartment(Object stuDepartment) {
		return findByProperty(STU_DEPARTMENT, stuDepartment);
	}

	public List findByStuClassNo(Object stuClassNo) {
		return findByProperty(STU_CLASS_NO, stuClassNo);
	}

	public List findByStuNativePlace(Object stuNativePlace) {
		return findByProperty(STU_NATIVE_PLACE, stuNativePlace);
	}

	public List findByStuTelephone(Object stuTelephone) {
		return findByProperty(STU_TELEPHONE, stuTelephone);
	}

	public List findAll() {
		log.debug("finding all StudentInfoTable instances");
		try {
			String queryString = "from StudentInfoTable";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public StudentInfoTable merge(StudentInfoTable detachedInstance) {
		log.debug("merging StudentInfoTable instance");
		try {
			StudentInfoTable result = (StudentInfoTable) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(StudentInfoTable instance) {
		log.debug("attaching dirty StudentInfoTable instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StudentInfoTable instance) {
		log.debug("attaching clean StudentInfoTable instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}