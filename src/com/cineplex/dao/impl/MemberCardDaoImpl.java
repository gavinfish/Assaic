package com.cineplex.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cineplex.dao.MemberCardDao;
import com.cineplex.entity.MemberCard;

/**
 * implements of DAO interface of member card entity
* @author Andy 1993sj19993@gmail.com  
* @date 2015年2月6日 下午8:44:59  
*
 */

@Repository("memberCardDao")
public class MemberCardDaoImpl extends BaseDaoImpl<MemberCard> implements MemberCardDao{

	@Override
	public MemberCard findByMemberId(int id) {
		// TODO Auto-generated method stub
		String hql = "from member_card m where m.memberId=?";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, id);
		@SuppressWarnings("unchecked")
		List<MemberCard> memberCards = query.list();
		if(memberCards!=null&&!memberCards.isEmpty()){
			return memberCards.get(0);
		}
		else{
			return null;
		}
	}

	@Override
	public int getCountByState(char state) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from member_card mc where mc.live = ?";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, state);
		int result = ((Long) query.uniqueResult()).intValue();
		return result;
	}


}
