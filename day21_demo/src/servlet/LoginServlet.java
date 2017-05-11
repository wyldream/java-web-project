package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Admin;

import service.AdminService;
import service.IAdminService;
/**
 * 用户管理servlet
 * 登陆、退出功能
 * @author weiyongle
 *
 */
public class LoginServlet extends HttpServlet {

	// Service实例
	private IAdminService adminService = new AdminService();
	// 跳转资源
	private String uri;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		if("login".equals(method)){
			login(request,response);
		}
		if("out".equals(method)){
			out(request,response);
		}
	}
	//推出功能
	private void out(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		1、获取session
		HttpSession session = request.getSession();
		System.out.println(1);
//		2、销毁session
		if(session!=null){
			session.invalidate();
			System.out.println(2);
		}
//		3、跳转到登陆界面（getContextPath得到当前web应用名称）
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//1. 获取参数
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		// 封装
		Admin admin = new Admin();
		admin.setUserName(userName);
		admin.setPwd(pwd);
		try {
			//2. 调用service处理业务
			Admin loginInfo = adminService.findByNameAndPwd(admin);
//			System.out.println(loginInfo);
			// 判断:
			if (loginInfo == null){
				// 登陆失败
				uri = "/login.jsp";
			} else {
				// 登陆成功
				// 先，保存数据到session(把数据保存到session域中)
				request.getSession().setAttribute("loginInfo", loginInfo);
				//在线列表集合，先从servletContext中获取在线列表集合，在把当前用户放入其中
				ServletContext sc = getServletContext();/**/
				List<Admin> onlineList = (List<Admin>)sc.getAttribute("onlineList");
				if(onlineList != null){
					onlineList.add(loginInfo);
				}
				// 再，跳转到首页显示servlet(/index)
				uri = "/IndexServlet";
			}
		} catch (Exception e) {
			// 测试
			e.printStackTrace();
			// 错误
			uri = "/error/error.jsp";
		}
		
		//3. 跳转
		request.getRequestDispatcher(uri).forward(request, response);
		
		
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
}
