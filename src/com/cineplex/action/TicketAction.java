package com.cineplex.action;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.cineplex.entity.BankCard;
import com.cineplex.entity.Film;
import com.cineplex.entity.FilmRecord;
import com.cineplex.entity.Member;
import com.cineplex.entity.MemberCard;
import com.cineplex.entity.Ticket;
import com.cineplex.service.FilmRecordService;
import com.cineplex.service.FilmService;
import com.cineplex.service.MemberCardService;
import com.cineplex.service.MemberManageService;
import com.cineplex.service.MemberService;
import com.cineplex.service.WaiterService;
import com.cineplex.service.impl.MemberCardServiceImpl;
import com.cineplex.util.DateUtil;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午4:37:10  
*
 */
@Controller
public class TicketAction extends BaseAction {
	private static final Logger LOGGER = LogManager
			.getLogger(TicketAction.class);

	@Resource
	private MemberCardService memberCardService;
	@Resource
	private FilmRecordService filmRecordService;
	@Resource
	private MemberManageService memberManageService;
	@Resource
	private FilmService filmService;
	@Resource
	private WaiterService waiterService;
	@Resource
	private MemberService memberService;

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	private Member member;
	private int recordId;
	private String seatChosen;
	private Film film;
	private BankCard bankCard;
	private MemberCard memberCard;
	private FilmRecord filmRecord;
	private int totalMoney;

	private int filmId;
	private int memberId;
	private int memberCardId;

	private String payType;
	private String accountName;
	private String password;

	private String hall;
	
	private String errorMessage;

	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public String getSeatChosen() {
		return seatChosen;
	}

	public void setSeatChosen(String seatchosen) {
		this.seatChosen = seatchosen;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
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

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public FilmRecord getFilmRecord() {
		return filmRecord;
	}

	public void setFilmRecord(FilmRecord filmRecord) {
		this.filmRecord = filmRecord;
	}

	public int getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getMemberCardId() {
		return memberCardId;
	}

	public void setMemberCardId(int memberCardId) {
		this.memberCardId = memberCardId;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHall() {
		return hall;
	}

	public void setHall(String hall) {
		this.hall = hall;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * heck pay type: if there is no input for accountName,
	 *               take that condition for that custom doesn't have a member
	 *               card and pay in cash if there is input for accountName but
	 *               not password, take that condition for that custom has a
	 *               memberCard but will pay in cash if there is input for both
	 *               accountName and password, check if its password is right,
	 *               if it is right, the bill will be paid by member card
	 * @return String:
	 * @throws
	 */
	public String buyTicket() {
		Ticket ticket = new Ticket();
		ticket.setFilmId(filmId);
		Film filmWanted = filmService.getFilmById(filmId);
		ticket.setRecordId(recordId);
		ticket.setMemberId(memberId);
		ticket.setPayType(filmWanted.getType());
		String[] seats = seatChosen.split(",");
		ticket.setPrice(filmWanted.getPrice()*seats.length);
		ticket.setPricePaid(totalMoney);
		ticket.setTime(DateUtil.getCurrentDate());
		ticket.setHall(hall);


		// update member card
		boolean cardEnough = memberService.buyTicketsByCard(memberCardId, totalMoney);
		if(!cardEnough){
			errorMessage = "余额不足";
			return ERROR;
		}
		
		// record ticket sell information
		waiterService.sellTicket(ticket,
				MemberCardServiceImpl.FEE_RECORD_TYPE_CARD);
		// change seat information in film record
		filmRecordService.takeSeat(recordId, seatChosen);

		// add integral
		memberCardService.addIntegral(memberCardId, totalMoney);
		return SUCCESS;
	}

	public String choosePayType() {
		filmRecord = filmRecordService.getFilmRecordById(recordId);
		film = filmService.getFilmById(filmRecord.getFilmId());
		String[] seats = seatChosen.split(",");
		@SuppressWarnings("unused")
		int moneyShouldPaid = seats.length * film.getPrice();

//		switch (payType) {
//		case "无卡":
//			accountName = "散客";
//			totalMoney = moneyShouldPaid;
//			break;
//		case "现金":
//
//		case "会员卡":
//		case "积分":
//			member = memberService.login(accountName, password);
//			if (member == null) {
//				errorMessage="账号或密码错误";
//				return ERROR;
//			}
//			memberCard = memberCardService.getMemberCardByMemberId(member
//					.getId());
//			member = memberManageService.findMemberById(member.getId());
//			memberCardId = memberCard.getId();
//			totalMoney = memberCardService.discount(memberCardId,
//					moneyShouldPaid);
//			break;
//		default:
//			break;
//		}

		return SUCCESS;
	}

	/**
	 * 
	* sell a ticket
	* @return
	* String  
	* @throws
	 */
	public String sellTicket() {
		Ticket ticket = new Ticket();
		ticket.setFilmId(filmId);
		Film filmWanted = filmService.getFilmById(filmId);
		ticket.setRecordId(recordId);
		ticket.setMemberId(memberId);
		ticket.setPayType(filmWanted.getType());
		String[] seats = seatChosen.split(",");
		ticket.setPrice(filmWanted.getPrice()*seats.length);
		ticket.setPricePaid(totalMoney);
		ticket.setTime(DateUtil.getCurrentDate());
		ticket.setHall(hall);

		filmRecordService.takeSeat(recordId, seatChosen);
		// update member card
		// memberService.buyTicketsByCard(memberCardId, totalMoney);
//		switch (payType) {
//		case "无卡":
//			waiterService.sellTicket(ticket,
//					MemberCardServiceImpl.FEE_RECORD_TYPE_CASH);
//			break;
//		case "现金":
//			waiterService.sellTicket(ticket,
//					MemberCardServiceImpl.FEE_RECORD_TYPE_CASH_CARD);
//			break;
//		case "会员卡":
//			boolean cardEnough = memberService.buyTicketsByCard(memberCardId, totalMoney);
//			if(!cardEnough){
//				errorMessage = "卡内余额不足";
//				return ERROR;
//			}
//			waiterService.sellTicket(ticket,
//					MemberCardServiceImpl.FEE_RECORD_TYPE_CARD);
//			memberCardService.addIntegral(memberCardId, totalMoney);
//			break;
//		case "积分":
//			boolean integralEnough = memberService.buyTicketByIntegral(memberId, totalMoney);
//			waiterService.sellTicket(ticket,
//					MemberCardServiceImpl.FEE_RECORD_TYPE_INTEGRAL);
//			if(!integralEnough){
//				errorMessage="会员积分不足";
//				return ERROR;
//			}
//			memberCardService.addIntegral(memberCardId, totalMoney);
//			break;
//		default:
//			break;
//		}
		return SUCCESS;
	}

	public String idle() {
		return SUCCESS;
	}

	/**
	 * 
	* confirm a ticket information
	* @return
	* String  
	* @throws
	 */
	public String confirm() {

		filmRecord = filmRecordService.getFilmRecordById(recordId);
		film = filmService.getFilmById(filmRecord.getFilmId());
		LOGGER.info("seat chosen: " + seatChosen);
		String[] seats = seatChosen.split(",");
		int moneyShouldPaid = seats.length * film.getPrice();

		String accountType = (String) session().get("account_type");
		// if(accountType.equals(LoginAction.ACCOUNT_TYPE_MEMBER)){
		int id = (Integer) session().get("id");
		memberCard = memberCardService.getMemberCardByMemberId(id);
		member = memberManageService.findMemberById(id);
		memberCardId = memberCard.getId();
		totalMoney = memberCardService.discount(memberCardId, moneyShouldPaid);
		// }
		// else{
		// totalMoney = moneyShouldPaid;
		// }
		if (accountType.equals(LoginAction.ACCOUNT_TYPE_MEMBER)) {
			return LoginAction.MEMBER_SUCCESS;
		} else if (accountType.equals(LoginAction.ACCOUNT_TYPE_WAITER)) {
			return LoginAction.WAITER_SUCCESS;
		}
		return ERROR;
	}

}
