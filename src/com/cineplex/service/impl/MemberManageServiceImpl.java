package com.cineplex.service.impl;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.cineplex.common.enums.Address;
import com.cineplex.common.enums.Gender;
import com.cineplex.dao.MemberDao;
import com.cineplex.entity.Member;
import com.cineplex.service.MemberManageService;
import com.cineplex.util.DateUtil;

/**
 * the implement of services of member manage
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年1月25日 下午7:57:07
 *
 */

@Service("memberManageService")
public class MemberManageServiceImpl implements MemberManageService {
	private static final Logger LOGGER = LogManager.getLogger(MemberManageServiceImpl.class); 
	
	public static final int[] AGE_LIST = {0,18,30,50,100};
	
	/**
	 * Dao of member
	 */
	@Resource
	private MemberDao memberDao;

	@Override
	public void saveMember(Member member) {
		memberDao.save(member);
	}

	@Override
	public void updateMember(Member member) {
		memberDao.update(member);
	}

	@Override
	public Member findMemberById(int id) {
		return memberDao.get(Member.class, id);
	}

	@Override
	public void deleteMember(Member member) {
		memberDao.delete(member);
	}

	@Override
	public List<Member> findAllList() {
		// return baseDAO.find(" from Member m order by m.createTime");
		List<Member> members = memberDao.findAllMembers();
		return members;
	}



	@Override
	public int getMemberCount() {
		// TODO Auto-generated method stub
		int count = memberDao.getCount();
		return count;
	}

	@Override
	public boolean hasAccount(String accountName) {
		// TODO Auto-generated method stub
		Member member = memberDao.findMemberByAccount(accountName);
		LOGGER.info("member info: "+member);
		boolean result = member==null?false:true;
		return result;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		int count = memberDao.getCount();
		return count;
	}

	@Override
	public int getCountByType(Gender gender) {
		// TODO Auto-generated method stub
		int count = memberDao.getCountByGender(gender);
		return count;
	}

	@Override
	public int getCountByAge(int ageStart, int ageEnd) {
		// TODO Auto-generated method stub
		Date dateStart = DateUtil.getYearsBefore(DateUtil.getCurrentDate(), ageEnd);
		Date dateEnd = DateUtil.getYearsBefore(DateUtil.getCurrentDate(), ageStart);
		int count = memberDao.getCountByAge(dateStart, dateEnd);
		return count;
	}

	@Override
	public int getCountByAddress(Address address) {
		// TODO Auto-generated method stub
		int count = memberDao.getCountByAddress(address);
		return count;
	}

	
}
