package com.erstegroup.lio.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.erstegroup.lio.constants.DAOConstants;
import com.erstegroup.lio.dao.UserDAO;
import com.erstegroup.lio.db.model.UserLogin;
import com.erstegroup.lio.enums.ErrorCodes;
import com.erstegroup.lio.exception.SchedulerException;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public UserLogin getUserLoginDetailsByUsername(String userName) {
		log.debug("getting the user informatioin from database for userName {}",userName);
		Session session = entityManager.unwrap(Session.class);
		try {
			String hql = "from UserLogin where ulUserName=:userName";
			Query<UserLogin> query = session.createQuery(hql , UserLogin.class);
			query.setParameter(DAOConstants.USER_NAME, userName);
			return query.getSingleResult();
		} catch(HibernateException e) {
			log.error("exception occurred while retrieving user information from database." , e);
			throw new SchedulerException(ErrorCodes.HIBERNATE_EXCEPTION);
		} finally {
			session.flush();
		}
	}
	
	
	
}
