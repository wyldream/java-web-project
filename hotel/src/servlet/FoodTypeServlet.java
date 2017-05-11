package servlet;

import java.io.IOException;
/**
 * ctrl+shift+R 查看当前项目中的类
 * ctrl+shift+T 查看jar包中的类
 */
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.GotoInstruction;

import service.IFoodTypeService;
import entity.FoodType;
import factory.BeanFactory;
/**
 * 菜系管理servlet
 *  a. 添加菜系 
 * b. 菜系列表展示
 * c. 进入更新页面
 * d. 删除
 * e. 更新
 * 
 * @author weiyongle
 *
 */
public class FoodTypeServlet extends BaseServlet {
	//调用菜系service
/*	private IFoodTypeService foodTypeService = BeanFactory.getInstance("foodTypeService",IFoodTypeService.class);
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//获取操作类型
		String method = request.getParameter("method");
		if ("addFoodType".equals(method)) {
			// 添加
			addFoodType(request, response);
		}

		else if ("list".equals(method)) {
			// 列表展示
			list(request, response);
		}
		
		else if ("viewUpdate".equals(method)) {
			// 进入更新页面
			viewUpdate(request, response);
		}
		
		else if ("delete".equals(method)) {
			// 删除
			delete(request, response);
		}
		
		else if ("update".equals(method)) {
			// 更新
			update(request, response);
		}
		
	}*/
	private Object uri = null;
	//保存更新内容（获取跟新id，设置更新内容，根据id进行更新）
	public Object update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String foodTypeName = request.getParameter("foodTypeName");
		int id = Integer.parseInt(request.getParameter("id"));
		FoodType ft = new FoodType();
		ft.setTypeName(foodTypeName);
		ft.setId(id);
		foodTypeService.update(ft);
		uri = "/foodType?method=list";
	    return uri;
		//goTo(request, response, uri);
	}
	public Object delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id"));
		foodTypeService.delete(id);
		uri = "/foodType?method=list";
	    return uri;
		//goTo(request, response, uri);
	}
	//跳转到更新页面，并向其中填充数据(要更新的是哪一行，为更新做准备)
	public Object viewUpdate(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
	    // TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		FoodType ft = new FoodType();
		ft.setId(id);
		request.setAttribute("foodType", ft);
		uri = request.getRequestDispatcher("/sys/type/foodtype_update.jsp");
		return uri;
		//goTo(request, response, uri);
	}
	//菜系列表展示
	public Object list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 调用Service查询所有的类别
		List<FoodType> list = foodTypeService.getAll();
		// 保存
//			request.setAttribute("listFoodType", list);
		getServletContext().setAttribute("listFoodType", list);
		// 跳转的菜系列表页面
		uri = request.getRequestDispatcher("/sys/type/foodtype_list.jsp");
		return uri;
		
		// 跳转
		//goTo(request, response, uri);
	}
	//添加菜系
	public Object addFoodType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1. 获取请求数据封装
		String foodTypeName = request.getParameter("foodTypeName");
		FoodType ft = new FoodType();
		ft.setTypeName(foodTypeName);
		// 2. 调用service处理业务逻辑
		foodTypeService.save(ft);
		// 3. 跳转
		uri = request.getRequestDispatcher("/foodType?method=list");
		return uri;
		
		//goTo(request, response, uri);
			
	}
/*	private void goTo(HttpServletRequest request, HttpServletResponse response, Object uri)
			throws ServletException, IOException {
		if (uri instanceof RequestDispatcher){
			((RequestDispatcher)uri).forward(request, response);
		} else if (uri instanceof String) {
			response.sendRedirect(request.getContextPath() + uri);
		} 
	}*/
/*	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/

}
