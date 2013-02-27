package com.rickwebstudy.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rickwebstudy.entity.Comment;
import com.rickwebstudy.repository.custom.CommentRepositoryCustom;

public class CommentRepositoryImpl implements CommentRepositoryCustom{

	static final Logger LOGGER = LoggerFactory
			.getLogger(CommentRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Comment> getByCommentId(Long commentId) {
		String querystr = "FROM Comment WHERE commentId=?";
		Query query = entityManager.createQuery(querystr);
		query.setParameter(1, commentId);
		@SuppressWarnings("unchecked")
		List<Comment> result = query.getResultList();
		return result;
	}

	@Override
	public List<Comment> getByJobId(Long jobId) {
		String querystr = "FROM Comment WHERE jobId=?";
		Query query = entityManager.createQuery(querystr);
		query.setParameter(1, jobId);
		@SuppressWarnings("unchecked")
		List<Comment> result = query.getResultList();
		return result;
	}

	@Override
	public List<Comment> getByUserId(Long userId) {
		String querystr = "FROM Comment WHERE userId=?";
		Query query = entityManager.createQuery(querystr);
		query.setParameter(1, userId);
		@SuppressWarnings("unchecked")
		List<Comment> result = query.getResultList();
		return result;
	}

	@Override
	public List<Comment> getByJobIdAndStatus(Long jobId, String status) {
		String querystr = "FROM Comment WHERE jobId=? and status=?";
		Query query = entityManager.createQuery(querystr);
		query.setParameter(1, jobId);
		query.setParameter(2, status);
		@SuppressWarnings("unchecked")
		List<Comment> result = query.getResultList();
		return result;
	}
	
}
