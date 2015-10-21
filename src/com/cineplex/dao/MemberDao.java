package com.cineplex.dao;

import java.sql.Date;
import java.util.List;

import com.cineplex.common.enums.Address;
import com.cineplex.common.enums.Gender;
import com.cineplex.entity.Member;

/**
 * DAO interface of member entity
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年2月6日 下午8:39:12
 *
 */

public interface MemberDao extends BaseDao<Member> {
	/**
	 * find a member info by his account and password
	 * @param account
	 * @param password
	 * @return Member:
	 * @throws
	 */
	public Member findMemberByAccountAndPswd(String account, String password);

	/**
	 * find a member info by his account
	 * @param account
	 * @return Member:
	 * @throws
	 */
	public Member findMemberByAccount(String account);

	/**
	 * get count of all members
	 * @return int:
	 * @throws
	 */
	public int getCount();

	/**
	 * get count of members whose birthday between
	 * @param dateStart
	 *            and
	 * @param dateEnd
	 * @return int:
	 * @throws
	 */
	public int getCountByAge(Date dateStart, Date dateEnd);

	/**
	 * get count of members whose address is
	 * @param address
	 * @return int:
	 * @throws
	 */
	public int getCountByAddress(Address address);

	/**
	 * get count of members by their gender type
	 * @param gender
	 * @return int:
	 * @throws
	 */
	public int getCountByGender(Gender gender);

	/**
	 * find all members have registered
	 * @return List<Member>:
	 * @throws
	 */
	public List<Member> findAllMembers();
}
