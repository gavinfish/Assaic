package com.cineplex.listener;

import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cineplex.service.WaiterService;

/**
 * 
* @author Andy 1993sj19993@gmail.com  
* @date 2015年4月16日 下午4:06:44  
*
 */
public class MyContextListener implements ServletContextListener {

	private WaiterService waiterService;

	private Timer timer;

	public MyContextListener() {
		super();
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(arg0.getServletContext());
		waiterService = ctx.getBean(WaiterService.class);
		timer = new Timer();
		timer.schedule(new ActivityTask(), 0, // initial delay
				24 * 60 * 60 * 1000); // subsequent rate

	}

	class ActivityTask extends TimerTask {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			waiterService.endActivity();
		}

	}
}
