package com.cineplex.service;

import java.util.List;

import com.cineplex.common.enums.Address;
import com.cineplex.common.enums.Gender;
import com.cineplex.entity.Member;

/**
 * the interface of services of member manage
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年1月25日 下午7:54:27
 *
 */

public interface MemberManageService {
	/**
	 * save information of a member
	 * @param member: the object of member
	 * @return void:
	 * @throws
	 */
	public void saveMember(Member member);

	/**
	 * update information of a member
	 * @param member: the object of member
	 * @return void:
	 * @throws
	 */
	public void updateMember(Member member);

	/**
	 * find a member by its id
	 * @param id: the wanted id
	 * @return Member: the object of the member
	 * @throws
	 */
	public Member findMemberById(int id);

	/**
	 * delete information of a member
	 * @param member: the object of member
	 * @return void:
	 * @throws
	 */
	public void deleteMember(Member member);

	/**
	 * get all member information
	 * @return List<Member>: the list of members
	 * @throws
	 */
	public List<Member> findAllList();

	/**
	 * get count of all members who have registered
	 * @return int:
	 * @throws
	 */
	public int getMemberCount();

	/**
	 * check if there is an account like
	 * @param accountName
	 * @param accountName: account of member
	 * @return boolean:
	 * @throws
	 */
	public boolean hasAccount(String accountName);

	/**
	 * TODO get count of all members
	 * @return int:
	 * @throws
	 */
	public int getCount();

	/**
	 * get count of members by their gender type
	 * @param gender
	 * @return int:
	 * @throws
	 */
	public int getCountByType(Gender gender);

	/**
	 * get count of members whose birthday between
	 * @param ageStart
	 *            and
	 * @param ageEnd
	 * @param ageStart: age starts
	 * @param ageEnd: age ends
	 * @return int:
	 * @throws
	 */
	public int getCountByAge(int ageStart, int ageEnd);

	/**
	 * get count of members by their address
	 * @param address
	 * @return int:
	 * @throws
	 */
	public int getCountByAddress(Address address);
}
