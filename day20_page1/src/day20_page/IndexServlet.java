package day20_page;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ���Ʋ㿪��
 * 1�����ղ���
 * 2������ҵ���߼�
 * 4����תҳ��
 * ��3����ʾ���ݣ���jspʵ�֣�
 * @author weiyongle
 *
 */
public class IndexServlet extends HttpServlet {
	// ����Serviceʵ��
	private IEmployeeService employeeService = new EmployeeService();
	// ��ת��Դ
	private String uri;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//1. ��ȡ����ǰҳ��������  (��һ�η��ʵ�ǰҳΪnull) 
			String currPage = request.getParameter("currentPage");
			// �ж�
			if (currPage == null || "".equals(currPage.trim())){
				currPage = "1";  	// ��һ�η��ʣ����õ�ǰҳΪ1;
			}
			// ת��
			int currentPage = Integer.parseInt(currPage);
			
			//2. ����PageBean�������õ�ǰҳ������ ����service��������
			PageBean<Employee> pageBean = new PageBean<Employee>();
			pageBean.setCurrentPage(currentPage);
			
			//3. ����service  
			employeeService.getAll(pageBean);    // ��pageBean�Ѿ���dao��������ݡ�
			
			//4. ����pageBean���󣬵�request����
			request.setAttribute("pageBean", pageBean);
			
			//5. ��ת 
			uri = "/WEB-INF/list.jsp";
		} catch (Exception e) {
			e.printStackTrace();  // ����ʹ��
			// ���ִ�����ת������ҳ�棻���û��Ѻ���ʾ
			uri = "/error/error.jsp";
		}
		request.getRequestDispatcher(uri).forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
