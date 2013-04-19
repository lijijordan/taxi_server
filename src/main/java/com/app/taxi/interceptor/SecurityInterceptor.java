package com.app.taxi.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.app.taxi.po.User;
import com.app.taxi.service.UserService;

/**
 * @author lijib
 *
 */
public class SecurityInterceptor implements HandlerInterceptor{

	private UserService userService;

	
	/**
	 */
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		return true;
		/*String id = request.getParameter("id");
		if(id == null){
			return false;
		}else{
			return isRightUser(id);
		}*/
	}
	
	/**
	 * 验证用户是否合法
	 * @param id
	 * @return true ： 合法； false ： 非法
 	 */
	@SuppressWarnings("unused")
	private boolean isRightUser(String id){
		User user = userService.getUser(id);
		return user != null;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
