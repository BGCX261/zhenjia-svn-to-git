package com.evan.zj.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.evan.zj.util.ReflectionUtils;




/**
 * Data access object (DAO) for domain model
 * 
 */
@Repository
public class BaseDao<E> extends HibernateDaoSupport {

	private static final Logger log = LoggerFactory.getLogger(BaseDao.class);

	protected Class<E> entityClass = ReflectionUtils.getSuperClassGenricType(getClass());;
	/**
	 * 
	 * @param E
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Long countAll() {
		BaseDao.log.debug("counting all Domain instances");
		try {
			Criteria criteria = getSession().createCriteria(entityClass).setProjection(
					Projections.rowCount());
			criteria.setCacheable(true);
			Long result = (Long) criteria.uniqueResult();
			BaseDao.log.debug("count all Domain instances, result size: "
					+ result);
			return result;
		} catch (RuntimeException re) {
			BaseDao.log.error("count all Domain instances failed", re);
			throw re;
		}
	}

	/**
	 * 
	 * @param dc
	 * @return
	 */
	public Long countByCriteria(DetachedCriteria dc) {
		BaseDao.log.debug("counting by Criteria");
		try {
			dc.setProjection(Projections.rowCount());
			Criteria criteria = dc.getExecutableCriteria(getSession());
			criteria.setCacheable(true);
			Long result = (Long) criteria.uniqueResult();
			BaseDao.log.debug("count by Criteria, result: " + result);
			return result;
		} catch (RuntimeException re) {
			BaseDao.log.debug("count by Criteria failed");
			throw re;
		}
	}

	/**
	 * 
	 * @param instance
	 * @return
	 */
	public Long countbyExample(E instance) {
		BaseDao.log.debug("counting Domain instance by example");
		try {
			Criteria criteria = getSession()
					.createCriteria(instance.getClass()).add(
							Example.create(instance)).setProjection(
							Projections.rowCount());
			criteria.setCacheable(true);
			Long result = (Long) criteria.uniqueResult();
			BaseDao.log
					.debug("count by example successful, result : " + result);
			return result;
		} catch (RuntimeException re) {
			BaseDao.log.error("count by example failed", re);
			throw re;
		}
	}

	/**
	 * 
	 * @param persistentInstance
	 */
	public void delete(E persistentInstance) {
		BaseDao.log.debug("deleting Domain instance");
		try {
			getSession().delete(persistentInstance);
			BaseDao.log.debug("delete successful");
		} catch (RuntimeException re) {
			BaseDao.log.error("delete failed", re);
			throw re;
		}
	}

	/**
	 * 
	 * @param E
	 * @param firstResult
	 * @param maxResult
	 * @param orders
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<E> findAll(int firstResult, int maxResults,
			Order[] orders) {
		BaseDao.log.debug("finding all Domain instances");
		try {
			Criteria criteria = getSession().createCriteria(entityClass);
			criteria.setCacheable(true);
			if (firstResult > 0) {
				criteria.setFirstResult(firstResult);
			}
			if (maxResults > 0) {
				criteria.setMaxResults(maxResults);
			}
			if (orders != null && orders.length > 0) {
				for (Order order : orders) {
					criteria.addOrder(order);
				}
			}
			List<E> results = criteria.list();
			BaseDao.log.debug("find all Domain instances, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			BaseDao.log.error("find all failed", re);
			throw re;
		}
	}

	/**
	 * 
	 * @param criteria
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<E> findByCriteria(DetachedCriteria dc, int firstResult,
			int maxResults, Order[] orders) {
		BaseDao.log.debug("finding by Criteria");
		try {
			Criteria criteria = dc.getExecutableCriteria(getSession());
			criteria.setCacheable(true);
			List<E> result;
			if (firstResult >= 0 && maxResults > 0) {
				criteria.setFirstResult(firstResult);
				criteria.setMaxResults(maxResults);
			}
			if (orders != null && orders.length > 0) {
				for (Order order : orders) {
					criteria.addOrder(order);
				}
			}
			result = criteria.list();
			BaseDao.log
					.debug("find by Criteria, result size: " + result.size());
			return result;
		} catch (RuntimeException re) {
			BaseDao.log.debug("finding by Criteria failed");
			throw re;
		}
	}

	/**
	 * 
	 * @param instance
	 * @param firstResult
	 * @param maxResult
	 * @param orders
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<E> findByExample(E instance, int firstResult, int maxResult,
			Order[] orders) {
		BaseDao.log.debug("finding Domain instance by example");
		try {
			Criteria criteria = getSession()
					.createCriteria(entityClass).add(
							Example.create(instance));
			criteria.setCacheable(true);
			if (firstResult > 0 && maxResult > 0) {
				criteria.setFirstResult(firstResult);
				criteria.setMaxResults(maxResult);
			}
			if (orders != null && orders.length > 0) {
				for (Order order : orders) {
					criteria.addOrder(order);
				}
			}
			List<E> results = criteria.list();
			BaseDao.log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			BaseDao.log.error("find by example failed", re);
			throw re;
		}
	}

	/**
	 * 
	 * @param instance
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public E getByExample(E instance) {
		BaseDao.log.debug("getting Domain instance by example");
		try {
			Criteria criteria = getSession()
					.createCriteria(instance.getClass()).add(
							Example.create(instance));
			criteria.setCacheable(true);
			E result = (E) criteria.uniqueResult();
			BaseDao.log.debug("get by example successful");
			return result;
		} catch (RuntimeException re) {
			BaseDao.log.error("get by example failed", re);
			throw re;
		}
	}

	/**
	 * 
	 * @param instanceClass
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public E getById(Integer id) {
		BaseDao.log.debug("getting Domain instance with id: " + id);
		try {
			E instance = (E) getSession().get(entityClass, id);
			if (instance != null) {
				BaseDao.log.debug("getting Domain instance successful");
			}
			return instance;
		} catch (RuntimeException re) {
			BaseDao.log.error("get failed", re);
			throw re;
		}
	}

	/**
	 * 
	 * @param detachedInstance
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public E merge(E detachedInstance) {
		BaseDao.log.debug("merging Domain instance");
		try {
			E result = (E) getSession().merge(detachedInstance);
			BaseDao.log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			BaseDao.log.error("merge failed", re);
			throw re;
		}
	}

	/**
	 * 
	 * @param transientInstance
	 */
	public void save(E transientInstance) {
		BaseDao.log.debug("saving Domain instance");
		try {
			getSession().save(transientInstance);
			BaseDao.log.debug("save successful");
		} catch (RuntimeException re) {
			BaseDao.log.error("save failed", re);
			throw re;
		}
	}

	/**
	 * 
	 * @param transientInstance
	 */
	public void update(E transientInstance) {
		BaseDao.log.debug("updateing Domain instance");
		try {
			getSession().update(transientInstance);
			BaseDao.log.debug("update successful");
		} catch (RuntimeException re) {
			BaseDao.log.error("update failed", re);
			throw re;
		}
	}
}