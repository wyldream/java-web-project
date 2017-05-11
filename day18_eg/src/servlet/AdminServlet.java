package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;
import service.IAdminService;

import entity.Admin;
import exception.UserExistsException;

public class AdminServlet extends HttpServlet {


	// ���õ�service
	private IAdminService adminService = new AdminService();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ��ȡ��������
		String method = request.getParameter("method");
		if ("register".equals(method)) {
			register(request,response);
		}
	}

	/**
	 * ע�ᴦ����
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void register(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		//1. ��ȡ�������
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		// ��װ
		Admin admin = new Admin();
		admin.setUserName(userName);
		admin.setPwd(pwd);
		
		//2. ����Service����ע���ҵ���߼�
		try {
			adminService.register(admin);
			
			// ע��ɹ�����ת����ҳ
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		} catch (UserExistsException e) {
			// �û������ڣ�ע��ʧ��(��ת��ע��ҳ��)
			request.setAttribute("message", "�û����Ѿ�����");
			// ת��
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		} catch (Exception e) {
			//e.printStackTrace();  // ����ʱ����
			// ��������, ��ת������ҳ��
			response.sendRedirect(request.getContextPath() + "/error/error.jsp");
		}
	}
}
