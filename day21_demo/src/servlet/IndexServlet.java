package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmployeeService;
import service.IEmployeeService;
import entity.Employee;

public class IndexServlet extends HttpServlet {


	// Service实例
	private IEmployeeService employeeService = new EmployeeService();
	// 跳转资源
	private String uri;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			// 调用service查询所有
			List<Employee> list = employeeService.getAll();
			request.setAttribute("listEmp", list);
			// 进入首页jsp
			uri = "/list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}
		// 转发
		request.getRequestDispatcher(uri).forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
