package com.se.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.se.model.AdminInfoTable;

/**
 * A data access object (DAO) providing persistence and search support for
 * AdminInfoTable entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.sims.dao.AdminInfoTable
 * @author MyEclipse Persistence Tools
 */
public class AdminInfoTableDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AdminInfoTableDAO.class);
	// property constants
	public static final String ADMIN_PASSWORD = "adminPassword";
	public static final String ADMIN_TYPE_ID = "adminTypeId";

	public void save(AdminInfoTable transientInstance) {
		log.debug("saving AdminInfoTable instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AdminInfoTable persistentInstance) {
		log.debug("deleting AdminInfoTable instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AdminInfoTable findById(java.lang.String id) {
		log.debug("getting AdminInfoTable instance with id: " + id);
		try {
			AdminInfoTable instance = (AdminInfoTable) getSession().get(
					"com.se.model.AdminInfoTable", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AdminInfoTable instance) {
		log.debug("finding AdminInfoTable instance by example");
		try {
			List results = getSession()
					.createCriteria("com.se.model.AdminInfoTable")
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
		log.debug("finding AdminInfoTable instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AdminInfoTable as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAdminPassword(Object adminPassword) {
		return findByProperty(ADMIN_PASSWORD, adminPassword);
	}

	public List findByAdminTypeId(Object adminTypeId) {
		return findByProperty(ADMIN_TYPE_ID, adminTypeId);
	}

	public List findAll() {
		log.debug("finding all AdminInfoTable instances");
		try {
			String queryString = "from AdminInfoTable";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AdminInfoTable merge(AdminInfoTable detachedInstance) {
		log.debug("merging AdminInfoTable instance");
		try {
			AdminInfoTable result = (AdminInfoTable) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AdminInfoTable instance) {
		log.debug("attaching dirty AdminInfoTable instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AdminInfoTable instance) {
		log.debug("attaching clean AdminInfoTable instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}