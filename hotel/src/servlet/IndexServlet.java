package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DinnerTableService;
import service.IDinnerTableService;

import entity.DinnerTable;
import factory.BeanFactory;

public class IndexServlet extends BaseServlet {

//	IDinnerTableService dinnerTableService = BeanFactory.getInstance("dinnerTableService", IDinnerTableService.class);
	//����Service
/*	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
	    String method = request.getParameter("method");
		// ��ȡ���������� String method = request.getParameter("method"); 
	    if (method == null) { 
	    	// Ĭ��ִ�еķ����� ����ǰ̨�б����ҳ 
	    	method = "listTable"; 
	    }
	    if("listTable".equals(method)){
	    	listTable(request,response);
	    }
	}*/

	
	// 1. ǰ̨��ҳ����ʾ����δԤ���Ĳ���
	public Object listTable(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		DinnerTableService dinnerTableService = new DinnerTableService();
		// ������ת��Դ(ת��/�ض���)
		Object uri = null;
		// ��ѯ����δԤ������
		List<DinnerTable> list = dinnerTableService.findNoUseTable();
		// ���浽request
		request.setAttribute("listDinnerTable", list);
		// ��ת����ҳ��ʾ
//		request.getRequestDispatcher("/app/index.jsp").forward(request, response);
		uri = request.getRequestDispatcher("/app/index.jsp");
		return uri;
		// ��ת
		// WebUtils.goTo(request, response, uri);
	}


/*	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
        doGet(request, response);
	}*/

}
