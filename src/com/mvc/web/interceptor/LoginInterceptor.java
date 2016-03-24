package com.mvc.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mvc.web.exception.SessionTimeoutException;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private String[] noInterceptorUrls = { "/login" };

	private Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String requestUrl = request.getRequestURI().replace(
				request.getContextPath(), "");
		log.info("requestUrl:"+requestUrl);
//		for (String url : noInterceptorUrls) {
//			if (requestUrl.contains(url)) {
//				return true;
//			}
//		}
		String user = null;
		if (requestUrl.contains("admin")) {
			user = (String) request.getSession().getAttribute("admin");
		} else {
			user = (String) request.getSession().getAttribute("user");
		}

		// String user=(String) session.getAttribute("user");
		String requestType = request.getHeader("X-Requested-With");
		if (requestType != null
				&& "XMLHttpRequest".equalsIgnoreCase(requestType)) {
			log.info("ajax请求");
			if (user == null) {
				// 未登录 跳转到登录页面
				response.setHeader("sessionstatus", "timeout");
				return false;
			}
		} else {
			// //普通请求拦截
			if (user == null) {
				log.info("Interceptor：跳转到login页面！");
				if (requestUrl.contains("admin")) {
//					throw new SessionTimeoutException();
					response.sendRedirect(request.getContextPath() + "/admin");
				} else {
//					throw new SessionTimeoutException();
					response.sendRedirect(request.getContextPath());
				}
			}
		}
		return true;
	}

}
