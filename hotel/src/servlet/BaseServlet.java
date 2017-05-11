package servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.IDinnerTableService;
import service.IFoodService;
import service.IFoodTypeService;
import utils.WebUtils;
import factory.BeanFactory;
/**
 * 前台servlet优化，将各个servlet的doGet和doPost方法抽取出来统一放在此处
 * @author weiyongle
 *通用的servlet类，其他servlet继承于此
 */
public abstract class BaseServlet extends HttpServlet {


	// 创建Service
	protected IDinnerTableService dinnerTableService = 
		BeanFactory.getInstance("dinnerTableService", IDinnerTableService.class);
	protected IFoodTypeService foodTypeService = 
		BeanFactory.getInstance("foodTypeService",IFoodTypeService.class);
	protected IFoodService foodService = 
		BeanFactory.getInstance("foodService",IFoodService.class);
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;utf-8");
		request.setCharacterEncoding("UTF-8");					// POST提交有效
		//约定method中写的是方法名
	    String methodName = request.getParameter("method");
	    if (methodName == null) { 
	    	// 默认执行的方法： 进入前台列表的首页 
	    	methodName = "listTable"; 
	    }
	    //保存跳转资源
	    Object returnValue = null;
	    try {
	        //获得当前运行类的字节码对象
	        Class clazz = this.getClass();
	        //获取当前运行方法的Method对象
			Method method = clazz.getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			//执行方法
			returnValue = method.invoke(this, request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //跳转
	    WebUtils.goTo(request, response, returnValue);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		
	}

}
