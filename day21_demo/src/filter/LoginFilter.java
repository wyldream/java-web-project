package filter;

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

import org.junit.Test;

public class LoginFilter implements Filter{
	private String uri ;

	/**
	 * 分析：
	 * 
		1. 先指定放行的资源，哪些资源不需要拦截：
		      login.jsp   +    /login  (request对象可以获取)
		2. 获取session，从session中获取登陆用户
		3. 判断是否为空：
		      为空， 说明没有登陆， 跳转到登陆
		       不为空， 已经登陆，放行！
	 */
/*	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		//0. 转换
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		//1. 获取请求资源，截取  
		String uri = request.getRequestURI();   // /emp_sys/login.jsp
		// 截取 【login.jsp或login】
		String requestPath = uri.substring(uri.lastIndexOf("/") + 1, uri.length());
		System.out.println(requestPath);
		
		//2. 判断： 先放行一些资源：/login.jsp、/login
//		if ("login".equals(requestPath) || "login.jsp".equals(requestPath)) {
			// 放行
			chain.doFilter(request, response);
		}
		else {
			//3. 对其他资源进行拦截
			//3.1 先获取Session、获取session中的登陆用户(loginInfo)
			HttpSession session = request.getSession(false);
			// 判断
			if (session != null) {
				
				Object obj = session.getAttribute("loginInfo");
				
				//3.2如果获取的内容不为空，说明已经登陆，放行
				if (obj != null) {
					// 放行
					chain.doFilter(request, response);
				} else {
					//3.3如果获取的内容为空，说明没有登陆； 跳转到登陆
					uri = "/login.jsp";
				}
				
			} else {
				// 肯定没有登陆
				uri = "/login.jsp";
			}
			request.getRequestDispatcher(uri).forward(request, response);
		}
	}*/
	String requestPath;
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		//0. 转换
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		//1. 获取请求资源，截取  
		uri = request.getRequestURI();   // /emp_sys/login.jsp
		// 截取 【login.jsp或login】
		requestPath = uri.substring(uri.lastIndexOf("/") + 1, uri.length());
		//2. 判断： 先放行一些资源：/login.jsp、/login
		if ("login".equals(requestPath) || "login.jsp".equals(requestPath)) {
			// 放行
			chain.doFilter(request, response);
		}
		else {
			//3. 对其他资源进行拦截
			//3.1 先获取Session、获取session中的登陆用户(loginInfo)
			HttpSession session = request.getSession(false);
			// 判断
			if (session != null) {
				
				Object obj = session.getAttribute("loginInfo");
				
				//3.2如果获取的内容不为空，说明已经登陆，放行
				if (obj != null) {
					// 放行（）                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             ）
					chain.doFilter(request, response);
					//不加return在线列表页找不到。。。
					return;//若不加return先放行，但是加载完servlet后还会继续执行filter，所以又会转发。只是因为执行速度快所以看不到servlet界面？
//					uri="/login.jsp";
				} else {
					//3.3如果获取的内容为空，说明没有登陆； 跳转到登陆
					uri = "/login.jsp";
				}
				
			} else {
				// 肯定没有登陆
				uri = "/login.jsp";
			}
			request.getRequestDispatcher(uri).forward(request, response);
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}


	public void destroy() {
		
	}
}
