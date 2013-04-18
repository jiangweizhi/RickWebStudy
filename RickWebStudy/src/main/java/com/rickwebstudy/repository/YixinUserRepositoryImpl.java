package com.rickwebstudy.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rickwebstudy.entity.YixinUser;
import com.rickwebstudy.repository.custom.YixinUserRepositoryCustom;

public class YixinUserRepositoryImpl implements YixinUserRepositoryCustom{
	static final Logger LOGGER = LoggerFactory
			.getLogger(CommentRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<YixinUser> getYixinUserByDeviceId(Long deviceId) {
		String querystr = "FROM YixinUser WHERE deviceId=?";
		Query query = entityManager.createQuery(querystr);
		query.setParameter(1, deviceId);
		@SuppressWarnings("unchecked")
		List<YixinUser> result = query.getResultList();
		return result;
	}
	
}
