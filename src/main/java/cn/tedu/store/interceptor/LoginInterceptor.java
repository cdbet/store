package cn.tedu.store.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//1.获取session
		//2.从session中获取user，返回object obj
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("user");
		//3.obj==null，重定向到showLogin.do;return false
		if(obj==null) {
			String path=request.getContextPath()+"/user/showLogin.do";
			response.sendRedirect(path);
			return false;
		}
			//4.obj!=null，返回true
			return true;	
		
		
		
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
