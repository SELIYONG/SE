package com.se.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.se.model.CourseInfoTable;

/**
 * A data access object (DAO) providing persistence and search support for
 * CourseInfoTable entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.se.dao.CourseInfoTable
 * @author MyEclipse Persistence Tools
 */
public class CourseInfoTableDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CourseInfoTableDAO.class);
	// property constants
	public static final String COURSE_NAME = "courseName";
	public static final String COURSE_CREDIT = "courseCredit";
	public static final String COURSE_YEAR = "courseYear";
	public static final String COURSE_TERM = "courseTerm";

	public void save(CourseInfoTable transientInstance) {
		log.debug("saving CourseInfoTable instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CourseInfoTable persistentInstance) {
		log.debug("deleting CourseInfoTable instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CourseInfoTable findById(java.lang.String id) {
		log.debug("getting CourseInfoTable instance with id: " + id);
		try {
			CourseInfoTable instance = (CourseInfoTable) getSession().get(
					"com.se.model.CourseInfoTable", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CourseInfoTable instance) {
		log.debug("finding CourseInfoTable instance by example");
		try {
			List results = getSession()
					.createCriteria("com.se.model.CourseInfoTable")
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
		log.debug("finding CourseInfoTable instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CourseInfoTable as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCourseName(Object courseName) {
		return findByProperty(COURSE_NAME, courseName);
	}

	public List findByCourseCredit(Object courseCredit) {
		return findByProperty(COURSE_CREDIT, courseCredit);
	}

	public List findByCourseYear(Object courseYear) {
		return findByProperty(COURSE_YEAR, courseYear);
	}

	public List findByCourseTerm(Object courseTerm) {
		return findByProperty(COURSE_TERM, courseTerm);
	}

	public List findAll() {
		log.debug("finding all CourseInfoTable instances");
		try {
			String queryString = "from CourseInfoTable";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CourseInfoTable merge(CourseInfoTable detachedInstance) {
		log.debug("merging CourseInfoTable instance");
		try {
			CourseInfoTable result = (CourseInfoTable) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CourseInfoTable instance) {
		log.debug("attaching dirty CourseInfoTable instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CourseInfoTable instance) {
		log.debug("attaching clean CourseInfoTable instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}