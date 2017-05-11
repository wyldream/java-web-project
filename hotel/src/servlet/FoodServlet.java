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
 * 进入主页，显示菜品以及菜系
 * @author weiyongle
 *
 */
public class FoodServlet extends BaseServlet {

	public Object foodDetail(HttpServletRequest request,HttpServletResponse response){
		//1.1 获取餐桌ID,根据ID查询，再把查询到的结果保存到session （生成订单用）
		//只需要执行一次即可: 先从session获取看有没有餐桌对象； 如果没有，就执行根据主键查询；
		response.setContentType("text/html;charset=UTF-8");
		//如果sesison中已经有餐桌对象，就不执行主键查询
		ServletContext sc = getServletContext();
		Object obj = sc.getAttribute("dinnerTable");
		// 判断
		if (obj == null){
			// 只在第一次执行的时候，查询餐桌对象
			String tableId = request.getParameter("tableId");
			DinnerTable dt = dinnerTableService.findById(Integer.parseInt(tableId));
			// 保存到session
			sc.setAttribute("dinnerTable", dt);
		
		}
		//1.2 查询所有的“菜品信息”, 保存
		PageBean<Food> pb = new PageBean<Food>();
		String curPage = request.getParameter("currentPage");
		if(curPage == null||"".equals(curPage.trim())){
			pb.setCurrentPage(1);
		}else{
			pb.setCurrentPage(Integer.parseInt(curPage));
		}
		Condition condition = new Condition();
		String foodTypeId = request.getParameter("foodTypeId");
		if (foodTypeId != null) {  // 如果类别为null,不作为条件，那就查询全部
			// 设置条件
			condition.setFoodTypeId(Integer.parseInt(foodTypeId));
		}
		// 分页参数： 菜名称
		String foodName = request.getParameter("foodName");
//		System.out.println(foodName);
		//设置菜品参数
		condition.setFoodName(foodName);
		// 【设置条件对象到pb中】
	    pb.setCondition(condition);
	    // ---->分页查询
	 	foodService.getAll(pb);
	 	// 保存查询后的pb对象
	 	request.setAttribute("pb", pb);
	 	
	 	//1.3 查询所有的“菜系信息”， 保存
	 	List<FoodType> listFoodType = foodTypeService.getAll();
	 	request.setAttribute("listFoodType", listFoodType);
	 	
	 	//1.4 跳转(转发)
	 	return request.getRequestDispatcher("/app/caidan.jsp");
	}
}
