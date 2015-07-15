package com.eagle.community.annoucement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.eagle.community.annoucement.entity.Annoucement;
import com.eagle.community.dao.BaseDaoImpl;

@Repository("annoucementDao")
public class AnnoucementDaoImpl extends BaseDaoImpl<Annoucement, Long>
		implements AnnoucementDao {

	@Override
	public List<Annoucement> getAnnoucements(int size) {
		Criteria criteria=createCriteria();
		orderDesc(criteria, "releaseTime", true);
		criteria.setFirstResult(0);
		criteria.setMaxResults(size);
		return criteria.list();
	}

}
