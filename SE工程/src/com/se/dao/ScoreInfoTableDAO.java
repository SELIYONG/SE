package com.se.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.se.model.ScoreInfoTable;

/**
 * A data access object (DAO) providing persistence and search support for
 * ScoreInfoTable entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.se.dao.ScoreInfoTable
 * @author MyEclipse Persistence Tools
 */
public class ScoreInfoTableDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ScoreInfoTableDAO.class);
	// property constants
	public static final String SCORE = "score";

	public void save(ScoreInfoTable transientInstance) {
		log.debug("saving ScoreInfoTable instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ScoreInfoTable persistentInstance) {
		log.debug("deleting ScoreInfoTable instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ScoreInfoTable findById(com.se.model.ScoreInfoTableId id) {
		log.debug("getting ScoreInfoTable instance with id: " + id);
		try {
			ScoreInfoTable instance = (ScoreInfoTable) getSession().get(
					"com.se.model.ScoreInfoTable", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ScoreInfoTable instance) {
		log.debug("finding ScoreInfoTable instance by example");
		try {
			List results = getSession()
					.createCriteria("com.se.model.ScoreInfoTable")
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
		log.debug("finding ScoreInfoTable instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ScoreInfoTable as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByScore(Object score) {
		return findByProperty(SCORE, score);
	}

	public List findAll() {
		log.debug("finding all ScoreInfoTable instances");
		try {
			String queryString = "from ScoreInfoTable";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ScoreInfoTable merge(ScoreInfoTable detachedInstance) {
		log.debug("merging ScoreInfoTable instance");
		try {
			ScoreInfoTable result = (ScoreInfoTable) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ScoreInfoTable instance) {
		log.debug("attaching dirty ScoreInfoTable instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ScoreInfoTable instance) {
		log.debug("attaching clean ScoreInfoTable instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}