package com.eagle.community.message.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.eagle.community.dao.BaseDaoImpl;
import com.eagle.community.message.entity.Message;
import com.eagle.community.user.entity.User;

//MessageDao的实现类
@Repository("messageDao")
public class MessageDaoImpl extends BaseDaoImpl<Message, Long> implements
		MessageDao {

	@Override
	public List<Message> getMSGS(int size) {
		Criteria criteria = createCriteria();
		orderDesc(criteria, "date", true);
		criteria.setFirstResult(0);
		criteria.setMaxResults(size);
		return (List<Message>) criteria.list();
	}

	@Override
	public int coutUserMsg(User user) {
		Query query = getSession().createSQLQuery(
				"select count(*) from hbc_messages where user_id =?");
		query.setParameter(0, user.getId());
		List<BigInteger> totalCount = query.list();
		// ((Long) query.list().get(0)).intValue();
		return totalCount.get(0).intValue();
	}

	@Override
	public List<Message> getALlMsg(String userId) {
		Query query = getSession().createSQLQuery(
				"select * from hbc_messages where user_id=?").addEntity(
				Message.class);
		query.setParameter(0, userId);

		return query.list();
	}

	@Override
	public List<Message> getUserMsg(String userId, int currentPage,
			int pageSize, int pageCount, boolean desc) {
		Query query = getSession().createSQLQuery(
				"select * from hbc_messages where user_id=? limit ?,?")
				.addEntity(Message.class);
		query.setParameter(0, userId);
		query.setParameter(1, getOffset(pageSize, currentPage, pageCount));
		query.setParameter(2, pageSize);
		
		return query.list();
	}

	// 根据当前页面计算浮标
	public int getOffset(int pageSize, int nowPage, int pageCount) {
		int offSet = 0;
		int targetPage = 1;

		if (nowPage < 1)
			targetPage = 1;
		else if (nowPage > pageCount)
			targetPage = pageCount;
		else
			targetPage = nowPage;

		offSet = (targetPage - 1) * pageSize;
		return offSet;
	}
}
