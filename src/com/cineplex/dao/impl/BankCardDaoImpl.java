package com.cineplex.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cineplex.dao.BankCardDao;
import com.cineplex.entity.BankCard;

/**
 * implements of DAO interface of bank card entity
* @author Andy 1993sj19993@gmail.com  
* @date 2015年2月6日 下午8:46:18  
*
 */

@Repository("bankCardDao")
public class BankCardDaoImpl extends BaseDaoImpl<BankCard> implements BankCardDao{
	@Override
	public BankCard findByMemberId(int memberId) {
		// TODO Auto-generated method stub
		String hql = "from bank_card bc where bc.memberId = ?";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, memberId);
		@SuppressWarnings("unchecked")
		List<BankCard> bankCards = query.list();
		if(bankCards!=null&&!bankCards.isEmpty()){
			return bankCards.get(0);
		}
		else{
			return null;
		}

	}

}
