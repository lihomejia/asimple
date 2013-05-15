package com.company.gap.base.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.company.gap.base.GapConstants;
import com.company.gap.system.model.User;


public class RequestFilter implements Filter {

	private long requestCount = 0;

	private synchronized String nextThreadId() {
		return "Request-" + ++requestCount;
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		Thread.currentThread().setName(nextThreadId());
		
		HttpServletRequest request = (HttpServletRequest) req;
		
		HttpSession session = request.getSession(true);
		
		User user = (User) session.getAttribute(GapConstants.USER_BEAN);
		
		if (user != null) {
			
		}
		
		try {
			chain.doFilter(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
	@Override
	public void destroy() {
	}
}