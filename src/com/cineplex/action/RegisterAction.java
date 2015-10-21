package com.cineplex.action;

import java.sql.Date;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.cineplex.entity.Member;
import com.cineplex.service.MemberManageService;
import com.cineplex.service.MemberService;
import com.cineplex.util.DateUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * action for registering an account
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年3月4日 下午5:07:49
 *
 */

@Controller
public class RegisterAction extends ActionSupport {
	private static final Logger LOGGER = LogManager
			.getLogger(RegisterAction.class);

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	private long BANK_CARD_BASE = 320000000;
	private int MEMBER_CARD_BASE = 1000000;

	@Resource
	MemberService memberService;
	@Resource
	MemberManageService memberManageService;

	private String account;
	private String password;
	private String gender;
	private int memberCardId;
	private long bankCardId;
	private String birthday;
	private String address;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getMemberCardId() {
		return memberCardId;
	}

	public void setMemberCardId(int memberCardId) {
		this.memberCardId = memberCardId;
	}

	public long getBankCardId() {
		return bankCardId;
	}

	public void setBankCardId(long bankCardId) {
		this.bankCardId = bankCardId;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 
	* register a member
	* @return
	* String  
	* @throws
	 */
	public String register() {
		// transform date to sql Date
		Date sqlBirthday = DateUtil.getSQLDate(birthday);

		int memberCount = memberManageService.getMemberCount();
		Member member = new Member();
		member.setAccountName(account);
		member.setAddress(address);
		// set member id for a member
		member.setBankCardId(BANK_CARD_BASE + memberCount);
		member.setBirthday(sqlBirthday);
		member.setGender(gender);
		// set bank card id for a member
		member.setMemberCardId(MEMBER_CARD_BASE + memberCount);
		member.setPassword(password);

		LOGGER.info(member);

		boolean isSuccess = memberService.register(member);
		if (isSuccess) {

			return SUCCESS;
		} else {
			return ERROR;
		}
	}
}
