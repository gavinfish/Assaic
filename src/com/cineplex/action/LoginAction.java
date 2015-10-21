package com.cineplex.action;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.cineplex.entity.Member;
import com.cineplex.service.ManagerService;
import com.cineplex.service.MemberService;
import com.cineplex.service.WaiterService;
import com.opensymphony.xwork2.ActionContext;

/**
 * he action of login
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年1月25日 下午7:52:03
 *
 */

@Controller
public class LoginAction extends BaseAction {
	private static final Logger LOGGER = LogManager
			.getLogger(LoginAction.class);

	private static final long serialVersionUID = 1L;

	public final static String MEMBER_SUCCESS = "member";
	public final static String MANAGER_SUCCESS = "manager";
	public final static String WAITER_SUCCESS = "waiter";

	public final static String ACCOUNT_TYPE_MEMBER = "member";
	public final static String ACCOUNT_TYPE_MANAGER = "manager";
	public final static String ACCOUNT_TYPE_WAITER = "waiter";

	@Resource
	private MemberService memberService;
	@Resource
	private ManagerService managerService;
	@Resource
	private WaiterService waiterService;

	private String account;
	private String password;

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

	/**
	 * 
	* login for all users
	* @return
	* String  
	* @throws
	 */
	public String login() {
		LOGGER.info("user info:" + account + "," + password);
		// HttpServletRequest session = ServletActionContext.getRequest();
		ActionContext context = ActionContext.getContext();

		// check if it is a member
		Member member = memberService.login(account, password);
		if (member != null) {
			LOGGER.info("member id:" + member.getId());
			context.getSession().put("id", member.getId());
			context.getSession().put("account", account);
			context.getSession().put("account_type", ACCOUNT_TYPE_MEMBER);
			return MEMBER_SUCCESS;
		}

		// check if it is manager
		boolean isManager = managerService.login(account, password);
		if (isManager) {
			context.getSession().put("account", account);
			context.getSession().put("account_type", ACCOUNT_TYPE_MANAGER);
			return MANAGER_SUCCESS;
		}

		// check if it is waiter
		boolean isWaiter = waiterService.login(account, password);
		if (isWaiter) {
			context.getSession().put("account", account);
			context.getSession().put("account_type", ACCOUNT_TYPE_WAITER);
			return WAITER_SUCCESS;
		}

		return ERROR;
	}

	/**
	 * log out for all users
	*
	* @return
	* String  
	* @throws
	 */
	public String logOut() {

		return SUCCESS;
	}

	/**
	 * 
	* login again, using when there is some error
	* @return
	* String  
	* @throws
	 */
	public String reLogin() {
		session().remove("account_type");
		if (session().get("id") != null) {
			session().remove("id");
		}
		return SUCCESS;
	}

	/**
	 * 
	* recover from an error
	* @return
	* String  
	* @throws
	 */
	public String errorBack() {
		return (String) session().get("account_type");
	}
}
