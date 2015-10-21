package com.cineplex.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.cineplex.entity.BankCard;
import com.cineplex.entity.MemberCard;
import com.cineplex.service.MemberCardService;
import com.cineplex.service.MemberService;

/**
 * actions for bank card
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年3月4日 下午5:07:25
 *
 */

@Controller
public class MemberCardAction extends BaseAction {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	private int money;
	private long bankCardId;
	private int memberCardId;

	private String errorMessage;

	@Resource
	private MemberService memberService;
	@Resource
	private MemberCardService memberCardService;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public long getBankCardId() {
		return bankCardId;
	}

	public void setBankCardId(long bankCardId) {
		this.bankCardId = bankCardId;
	}

	public int getMemberCardId() {
		return memberCardId;
	}

	public void setMemberCardId(int memberCardId) {
		this.memberCardId = memberCardId;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * 
	* recharge money into member card from bank card
	* @return
	* String  
	* @throws
	 */
	public String recharge() {
		boolean isRechargeSuccess = memberCardService.rechargeByBank(
				memberCardId, bankCardId, money);
		if (isRechargeSuccess) {
			// inform browser recharge succeed
			return SUCCESS;
		} else {
			// inform fail
			errorMessage = "余额不足";
			return ERROR;
		}
	}

	/**
	 * 
	* check bank card and member card information of a member
	* @return
	* String  
	* @throws
	 */
	public String checkCards() {
		int id = (Integer) session().get("id");
		BankCard bankCard = memberService.checkBankAccount(id);
		if (bankCard == null) {
			errorMessage="找不到银行卡";
			return ERROR;
		}
		bankCardId = bankCard.getId();

		MemberCard memberCard = memberCardService.getMemberCardByMemberId(id);
		if (memberCard == null) {
			errorMessage = "找不到会员卡";
			return ERROR;
		}
		memberCardId = memberCard.getId();
		return SUCCESS;
	}

	/**
	 * 
	* disqualificate a member card 
	* @return
	* String  
	* @throws
	 */
	public String unbind() {
		memberCardService.disQualificate(memberCardId);
		return SUCCESS;
	}
}
