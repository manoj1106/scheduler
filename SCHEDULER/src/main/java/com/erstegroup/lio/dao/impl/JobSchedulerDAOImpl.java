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
import com.erstegroup.lio.dao.JobSchedulerDAO;
import com.erstegroup.lio.db.model.SchedulerJobGroup;
import com.erstegroup.lio.enums.ErrorCodes;
import com.erstegroup.lio.exception.SchedulerException;

@Repository
public class JobSchedulerDAOImpl implements JobSchedulerDAO {

	private static final Logger log = LoggerFactory.getLogger(JobSchedulerDAOImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public SchedulerJobGroup getSchedulerJobGroup(String jobGroupName) {
		log.debug("getting SchedulerJobGroup from jobGroupName {}" , jobGroupName);
		SchedulerJobGroup schedulerJobGroup = null;
		StringBuilder hql = new StringBuilder();
		Session session = entityManager.unwrap(Session.class);
		try {
			hql.append("from SchedulerJobGroup where schJobGroupName=:schJobGroupName");
			Query<SchedulerJobGroup> query = session.createQuery(hql.toString() , SchedulerJobGroup.class);
			query.setParameter(DAOConstants.SCH_JOBGROUP_NAME, jobGroupName);
			schedulerJobGroup = (SchedulerJobGroup)query.uniqueResult();
		} catch(HibernateException e) {
			log.error("exception occurred while retrieving data from database",e);
			throw new SchedulerException(ErrorCodes.HIBERNATE_EXCEPTION);
		} finally {
			session.flush();
		}
		log.debug("returning SchedulerJobGroup from jobGroupName {}" , jobGroupName);
		return schedulerJobGroup;
	}
	
	@Override
	public Long saveSchedulerJobGroup(SchedulerJobGroup schedulerJobGroup) {
		log.debug("saving SchedulerJobGroup in the database. JobGroupName to create is {}" , schedulerJobGroup.getSchJobGroupName());
		Session session = entityManager.unwrap(Session.class);
		try {
			session.save(schedulerJobGroup);
		} catch(HibernateException e) {
			log.error("exception occurred while retrieving data from database",e);
			throw new SchedulerException(ErrorCodes.HIBERNATE_EXCEPTION);
		}
		log.debug("SchedulerJobGroup saved in the database. JobGroupName id created is {}" , schedulerJobGroup.getSchJobGroupId());
		return schedulerJobGroup.getSchJobGroupId();
	}
	
}
