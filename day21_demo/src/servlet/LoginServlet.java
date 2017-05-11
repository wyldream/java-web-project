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
 * �û�����servlet
 * ��½���˳�����
 * @author weiyongle
 *
 */
public class LoginServlet extends HttpServlet {

	// Serviceʵ��
	private IAdminService adminService = new AdminService();
	// ��ת��Դ
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
	//�Ƴ�����
	private void out(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		1����ȡsession
		HttpSession session = request.getSession();
		System.out.println(1);
//		2������session
		if(session!=null){
			session.invalidate();
			System.out.println(2);
		}
//		3����ת����½���棨getContextPath�õ���ǰwebӦ�����ƣ�
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//1. ��ȡ����
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		// ��װ
		Admin admin = new Admin();
		admin.setUserName(userName);
		admin.setPwd(pwd);
		try {
			//2. ����service����ҵ��
			Admin loginInfo = adminService.findByNameAndPwd(admin);
//			System.out.println(loginInfo);
			// �ж�:
			if (loginInfo == null){
				// ��½ʧ��
				uri = "/login.jsp";
			} else {
				// ��½�ɹ�
				// �ȣ��������ݵ�session(�����ݱ��浽session����)
				request.getSession().setAttribute("loginInfo", loginInfo);
				//�����б��ϣ��ȴ�servletContext�л�ȡ�����б��ϣ��ڰѵ�ǰ�û���������
				ServletContext sc = getServletContext();/**/
				List<Admin> onlineList = (List<Admin>)sc.getAttribute("onlineList");
				if(onlineList != null){
					onlineList.add(loginInfo);
				}
				// �٣���ת����ҳ��ʾservlet(/index)
				uri = "/IndexServlet";
			}
		} catch (Exception e) {
			// ����
			e.printStackTrace();
			// ����
			uri = "/error/error.jsp";
		}
		
		//3. ��ת
		request.getRequestDispatcher(uri).forward(request, response);
		
		
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
}
