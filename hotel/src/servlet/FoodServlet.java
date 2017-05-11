package servlet;



import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.Condition;
import utils.PageBean;
import entity.DinnerTable;
import entity.Food;
import entity.FoodType;
/**
 * ������ҳ����ʾ��Ʒ�Լ���ϵ
 * @author weiyongle
 *
 */
public class FoodServlet extends BaseServlet {

	public Object foodDetail(HttpServletRequest request,HttpServletResponse response){
		//1.1 ��ȡ����ID,����ID��ѯ���ٰѲ�ѯ���Ľ�����浽session �����ɶ����ã�
		//ֻ��Ҫִ��һ�μ���: �ȴ�session��ȡ����û�в������� ���û�У���ִ�и���������ѯ��
		response.setContentType("text/html;charset=UTF-8");
		//���sesison���Ѿ��в������󣬾Ͳ�ִ��������ѯ
		ServletContext sc = getServletContext();
		Object obj = sc.getAttribute("dinnerTable");
		// �ж�
		if (obj == null){
			// ֻ�ڵ�һ��ִ�е�ʱ�򣬲�ѯ��������
			String tableId = request.getParameter("tableId");
			DinnerTable dt = dinnerTableService.findById(Integer.parseInt(tableId));
			// ���浽session
			sc.setAttribute("dinnerTable", dt);
		
		}
		//1.2 ��ѯ���еġ���Ʒ��Ϣ��, ����
		PageBean<Food> pb = new PageBean<Food>();
		String curPage = request.getParameter("currentPage");
		if(curPage == null||"".equals(curPage.trim())){
			pb.setCurrentPage(1);
		}else{
			pb.setCurrentPage(Integer.parseInt(curPage));
		}
		Condition condition = new Condition();
		String foodTypeId = request.getParameter("foodTypeId");
		if (foodTypeId != null) {  // ������Ϊnull,����Ϊ�������ǾͲ�ѯȫ��
			// ��������
			condition.setFoodTypeId(Integer.parseInt(foodTypeId));
		}
		// ��ҳ������ ������
		String foodName = request.getParameter("foodName");
//		System.out.println(foodName);
		//���ò�Ʒ����
		condition.setFoodName(foodName);
		// ��������������pb�С�
	    pb.setCondition(condition);
	    // ---->��ҳ��ѯ
	 	foodService.getAll(pb);
	 	// �����ѯ���pb����
	 	request.setAttribute("pb", pb);
	 	
	 	//1.3 ��ѯ���еġ���ϵ��Ϣ���� ����
	 	List<FoodType> listFoodType = foodTypeService.getAll();
	 	request.setAttribute("listFoodType", listFoodType);
	 	
	 	//1.4 ��ת(ת��)
	 	return request.getRequestDispatcher("/app/caidan.jsp");
	}
}
