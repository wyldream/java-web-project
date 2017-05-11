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
 * ǰ̨servlet�Ż���������servlet��doGet��doPost������ȡ����ͳһ���ڴ˴�
 * @author weiyongle
 *ͨ�õ�servlet�࣬����servlet�̳��ڴ�
 */
public abstract class BaseServlet extends HttpServlet {


	// ����Service
	protected IDinnerTableService dinnerTableService = 
		BeanFactory.getInstance("dinnerTableService", IDinnerTableService.class);
	protected IFoodTypeService foodTypeService = 
		BeanFactory.getInstance("foodTypeService",IFoodTypeService.class);
	protected IFoodService foodService = 
		BeanFactory.getInstance("foodService",IFoodService.class);
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;utf-8");
		request.setCharacterEncoding("UTF-8");					// POST�ύ��Ч
		//Լ��method��д���Ƿ�����
	    String methodName = request.getParameter("method");
	    if (methodName == null) { 
	    	// Ĭ��ִ�еķ����� ����ǰ̨�б����ҳ 
	    	methodName = "listTable"; 
	    }
	    //������ת��Դ
	    Object returnValue = null;
	    try {
	        //��õ�ǰ��������ֽ������
	        Class clazz = this.getClass();
	        //��ȡ��ǰ���з�����Method����
			Method method = clazz.getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			//ִ�з���
			returnValue = method.invoke(this, request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //��ת
	    WebUtils.goTo(request, response, returnValue);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		
	}

}
