package com.cineplex.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午4:23:22  
*
 */
public class BaseAction extends ActionSupport {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	public HttpServletRequest request() {
		return ServletActionContext.getRequest();
	}

	public Map<String, Object> session() {
		return ActionContext.getContext().getSession();
	}

	public ServletContext application() {
		return ServletActionContext.getServletContext();
	}

	public HttpServletResponse response() {
		return ServletActionContext.getResponse();
	}

}
