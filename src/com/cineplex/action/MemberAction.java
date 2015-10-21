package com.cineplex.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.cineplex.entity.BankCard;
import com.cineplex.entity.FeeRecord;
import com.cineplex.entity.Member;
import com.cineplex.entity.MemberCard;
import com.cineplex.service.MemberCardService;
import com.cineplex.service.MemberManageService;
import com.cineplex.service.MemberService;
import com.cineplex.util.DateUtil;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午4:27:46  
*
 */
@Controller
public class MemberAction extends BaseAction {
	private static final Logger LOGGER = LogManager
			.getLogger(MemberAction.class);

	@Resource
	private MemberService memberService;
	@Resource
	private MemberCardService memberCardService;
	@Resource
	private MemberManageService memberManageService;

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	private Member member;
	private BankCard bankCard;
	private MemberCard memberCard;
	private String birthday;
	private String gender;
	private String address;

	private List<FeeRecord> consumptions;
	private List<FeeRecord> recharges;
	private String historyType;

	private List<Member> members;

	private int memberId;

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public BankCard getBankCard() {
		return bankCard;
	}

	public void setBankCard(BankCard bankCard) {
		this.bankCard = bankCard;
	}

	public MemberCard getMemberCard() {
		return memberCard;
	}

	public void setMemberCard(MemberCard memberCard) {
		this.memberCard = memberCard;
	}

	public List<FeeRecord> getConsumptions() {
		return consumptions;
	}

	public void setConsumptions(List<FeeRecord> consumptions) {
		this.consumptions = consumptions;
	}

	public List<FeeRecord> getRecharges() {
		return recharges;
	}

	public void setRecharges(List<FeeRecord> recharges) {
		this.recharges = recharges;
	}

	public String getHistoryType() {
		return historyType;
	}

	public void setHistoryType(String historyType) {
		this.historyType = historyType;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	/**
	 * get personal information to show in personal info page
	 * @return String:
	 * @throws
	 */
	public String getInfo() {
		int id = (Integer) session().get("id");
		bankCard = memberService.checkBankAccount(id);
		member = memberManageService.findMemberById(id);
		memberCard = memberCardService.getMemberCardByMemberId(id);
		return SUCCESS;
	}

	/**
	 * get personal information to show in change personal
	 *               info page
	 * @return String:
	 * @throws
	 */
	public String checkInfo() {
		int id = (Integer) session().get("id");
		bankCard = memberService.checkBankAccount(id);
		member = memberManageService.findMemberById(id);
		memberCard = memberCardService.getMemberCardByMemberId(id);
		birthday = DateUtil.transformFormat(member.getBirthday().toString());
		return SUCCESS;
	}

	/**
	 * change personal information
	 * @return String:
	 * @throws
	 */
	public String changeInfo() {
		int id = (Integer) session().get("id");
		member = memberManageService.findMemberById(id);
		member.setBirthday(DateUtil.getSQLDate(birthday));
		member.setAddress(address);
		member.setGender(gender);
		memberManageService.updateMember(member);
		return SUCCESS;
	}

	/**
	 * change password
	 * @return String:
	 * @throws
	 */
	public String changePassword() {
		return SUCCESS;
	}

	/**
	 * 
	* get consumption records of a member
	* @return
	* String  
	* @throws
	 */
	public String getConsumption() {
		int id = (Integer) session().get("id");
		consumptions = memberService.getConsumption(id);
		LOGGER.info("consumption count: " + consumptions.size());
		historyType = "consumption";
		return SUCCESS;
	}

	/**
	 * 
	* get recharge records of a member
	* @return
	* String  
	* @throws
	 */
	public String getRecharge() {
		int id = (Integer) session().get("id");
		recharges = memberService.getRecharge(id);
		historyType = "recharge";
		return SUCCESS;
	}

	/**
	 * 
	* get all members information
	* @return
	* String  
	* @throws
	 */
	public String getAllMembers() {
		members = memberManageService.findAllList();
		return SUCCESS;
	}

	/**
	 * 
	* get all information of a member, including member card info and bank card info
	* @return
	* String  
	* @throws
	 */
	public String getMemberInfo() {
		bankCard = memberService.checkBankAccount(memberId);
		member = memberManageService.findMemberById(memberId);
		memberCard = memberCardService.getMemberCardByMemberId(memberId);
		birthday = DateUtil.transformFormat(member.getBirthday().toString());

		consumptions = memberService.getConsumption(memberId);
		recharges = memberService.getRecharge(memberId);
		return SUCCESS;
	}
}
