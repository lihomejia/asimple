package com.company.gap.base.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.gap.base.GapConstants;
import com.company.gap.base.LocalContext;
import com.company.gap.base.util.LocalHelper;
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
		HttpServletResponse response = (HttpServletResponse) resp;
		
		HttpSession session = request.getSession(true);
		
		User user = (User) session.getAttribute(GapConstants.USER_BEAN);
		
		String uri = request.getRequestURI().toLowerCase();
		int userType = uri.indexOf("/backend") > -1 ? 1 : 2;
		
		if (user != null && userType == user.getUserType()) {
			LocalContext.setUser(user);
		}
		else if (uri.indexOf("login.html") > 0
				|| uri.indexOf("register.html") > 0
				|| uri.indexOf("registersave.html") > 0) {
		} 
		else {
			response.sendRedirect(request.getContextPath() + "/web/index.html");
			return;
		}
		
		try {
			chain.doFilter(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			LocalHelper.clearContexts();
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
	@Override
	public void destroy() {
	}
}