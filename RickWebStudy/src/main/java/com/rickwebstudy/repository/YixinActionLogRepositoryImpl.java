package com.rickwebstudy.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rickwebstudy.repository.custom.YixinActionLogRepositoryCustom;

public class YixinActionLogRepositoryImpl implements YixinActionLogRepositoryCustom{
	static final Logger LOGGER = LoggerFactory
			.getLogger(CommentRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;
}
