package com.cineplex.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * grant authorization of resource of waiter 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午4:08:23  
*
 */
public class WaiterFilter implements Filter {
	private static String LOGIN_PAGE = "/cineplex/login.jsp";
	// private static String WAITER_INDEX = "/cineplex/waiter/waiter-index.jsp";
	private static String MEMBER_INDEX = "/cineplex/user/member-index.jsp";
	private static String MANAGER_INDEX = "/cineplex/manager/manager-index.jsp";
	protected FilterConfig filterConfig;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String accountType = (String) request.getSession().getAttribute(
				"account_type");
		if (accountType == null) {
			response.sendRedirect(LOGIN_PAGE);
		} else if ("member".equals(accountType)) {
			response.sendRedirect(MEMBER_INDEX);
		} else if ("manager".equals(accountType)) {
			response.sendRedirect(MANAGER_INDEX);
		} else {
			chain.doFilter(req, resp);
			return;
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
