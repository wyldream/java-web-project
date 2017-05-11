package servlet;

import java.io.IOException;
/**
 * ctrl+shift+R �鿴��ǰ��Ŀ�е���
 * ctrl+shift+T �鿴jar���е���
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
 * ��ϵ����servlet
 *  a. ��Ӳ�ϵ 
 * b. ��ϵ�б�չʾ
 * c. �������ҳ��
 * d. ɾ��
 * e. ����
 * 
 * @author weiyongle
 *
 */
public class FoodTypeServlet extends BaseServlet {
	//���ò�ϵservice
/*	private IFoodTypeService foodTypeService = BeanFactory.getInstance("foodTypeService",IFoodTypeService.class);
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//��ȡ��������
		String method = request.getParameter("method");
		if ("addFoodType".equals(method)) {
			// ���
			addFoodType(request, response);
		}

		else if ("list".equals(method)) {
			// �б�չʾ
			list(request, response);
		}
		
		else if ("viewUpdate".equals(method)) {
			// �������ҳ��
			viewUpdate(request, response);
		}
		
		else if ("delete".equals(method)) {
			// ɾ��
			delete(request, response);
		}
		
		else if ("update".equals(method)) {
			// ����
			update(request, response);
		}
		
	}*/
	private Object uri = null;
	//����������ݣ���ȡ����id�����ø������ݣ�����id���и��£�
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
	//��ת������ҳ�棬���������������(Ҫ���µ�����һ�У�Ϊ������׼��)
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
	//��ϵ�б�չʾ
	public Object list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// ����Service��ѯ���е����
		List<FoodType> list = foodTypeService.getAll();
		// ����
//			request.setAttribute("listFoodType", list);
		getServletContext().setAttribute("listFoodType", list);
		// ��ת�Ĳ�ϵ�б�ҳ��
		uri = request.getRequestDispatcher("/sys/type/foodtype_list.jsp");
		return uri;
		
		// ��ת
		//goTo(request, response, uri);
	}
	//��Ӳ�ϵ
	public Object addFoodType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1. ��ȡ�������ݷ�װ
		String foodTypeName = request.getParameter("foodTypeName");
		FoodType ft = new FoodType();
		ft.setTypeName(foodTypeName);
		// 2. ����service����ҵ���߼�
		foodTypeService.save(ft);
		// 3. ��ת
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
