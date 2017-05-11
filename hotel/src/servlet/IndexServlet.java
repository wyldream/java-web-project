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
	//创建Service
/*	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
	    String method = request.getParameter("method");
		// 获取操作的类型 String method = request.getParameter("method"); 
	    if (method == null) { 
	    	// 默认执行的方法： 进入前台列表的首页 
	    	method = "listTable"; 
	    }
	    if("listTable".equals(method)){
	    	listTable(request,response);
	    }
	}*/

	
	// 1. 前台首页：显示所有未预定的餐桌
	public Object listTable(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		DinnerTableService dinnerTableService = new DinnerTableService();
		// 保存跳转资源(转发/重定向)
		Object uri = null;
		// 查询所有未预定餐桌
		List<DinnerTable> list = dinnerTableService.findNoUseTable();
		// 保存到request
		request.setAttribute("listDinnerTable", list);
		// 跳转到首页显示
//		request.getRequestDispatcher("/app/index.jsp").forward(request, response);
		uri = request.getRequestDispatcher("/app/index.jsp");
		return uri;
		// 跳转
		// WebUtils.goTo(request, response, uri);
	}


/*	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
        doGet(request, response);
	}*/

}
