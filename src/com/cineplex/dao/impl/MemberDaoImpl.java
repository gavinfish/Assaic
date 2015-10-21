package com.cineplex.dao.impl;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cineplex.common.enums.Address;
import com.cineplex.common.enums.Gender;
import com.cineplex.dao.MemberDao;
import com.cineplex.entity.Member;

/**
 * implements of DAO interface of member entity
* @author Andy 1993sj19993@gmail.com  
* @date 2015年2月6日 下午8:44:43  
*
 */

@Repository("memberDao")
public class MemberDaoImpl extends BaseDaoImpl<Member> implements MemberDao{

	@Override
	public Member findMemberByAccountAndPswd(String account, String password) {
		// TODO Auto-generated method stub
		String hql = "from Member m where m.accountName = ? and m.password = ? ";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, account);
		query.setParameter(1, password);
		@SuppressWarnings("unchecked")
		List<Member> members = query.list();
		if(members != null && !members.isEmpty()){
			return members.get(0);
		}
		else{
			return null;
		}
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Member m";
		Query query = this.getCurrentSession().createQuery(hql);
		int result = ((Long) query.uniqueResult()).intValue();
		return result;
	}

	@Override
	public Member findMemberByAccount(String account) {
		// TODO Auto-generated method stub
		String hql = "from Member m where m.accountName = ?";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, account);
		@SuppressWarnings("unchecked")
		List<Member> members = query.list();
		if(members != null && !members.isEmpty()){
			return members.get(0);
		}
		else{
			return null;
		}
	}

	@Override
	public int getCountByAddress(Address address) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Member m where m.address = ?";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, address.toString());
		int result = ((Long) query.uniqueResult()).intValue();
		return result;
	}

	@Override
	public int getCountByGender(Gender gender) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Member m where m.gender = ?";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, gender.toString());
		int result = ((Long) query.uniqueResult()).intValue();
		return result;
	}

	@Override
	public int getCountByAge(Date dateStart, Date dateEnd) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Member m where m.birthday >= ? and m.birthday < ?";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, dateStart);
		query.setParameter(1, dateEnd);
		int result = ((Long) query.uniqueResult()).intValue();
		return result;
	}

	@Override
	public List<Member> findAllMembers() {
		// TODO Auto-generated method stub
		String hql = "from Member m";
		Query query = this.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Member> members = query.list();
		return members;
	}

}
