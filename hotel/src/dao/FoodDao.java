package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import utils.Condition;
import utils.JdbcUtils;
import utils.PageBean;
import entity.Food;

public class FoodDao implements IFoodDao {

	@Override
	public void getAll(PageBean<Food> pb) {
		// TODO Auto-generated method stub
		//获取封装条件对象
		Condition condition = pb.getCondition();
		//查询参数 菜品名称
		String foodName = condition.getFoodName();
//		System.out.println(foodName);
		//查询参数 菜系id
		int typeId = condition.getFoodTypeId();
		StringBuffer sb = new StringBuffer();
		//拼接查询语句
		sb.append("select");
		sb.append("		f.id,");
		sb.append("		f.foodName,");
		sb.append("		f.price,");
		sb.append("		f.mprice,");
		sb.append("		f.remark,");
		sb.append("		f.img,");
		sb.append("		f.foodType_id,");
		sb.append("		t.typeName ");
		sb.append("from ");
		sb.append("		food f, ");
		sb.append("		foodType t ");
		sb.append("where 1=1");
		sb.append("		and f.foodType_id=t.id ");
		//用于存储查询参数
		ArrayList<Object> list = new ArrayList<Object>();
		//根据菜系类别查询
		if(typeId > 0){
			sb.append("  and f.foodType_id=? ");
			list.add(typeId);
		}
		//根据菜名查询
		if(foodName != null&&!"".equals(foodName.trim())){
			sb.append("   AND f.foodName LIKE ? ");
			list.add(foodName);
		}
		/********分页条件******************/
		sb.append(" limit ?,? " );
		//页数设置
		/*****判断：当当前页< 1， 设置当前页为1；  当当前页>总页数，设置当前页为总页数******/
		int totalCount = getTotalCount(pb);
		pb.setTotalCount(totalCount);
		if(pb.getCurrentPage() < 1){
			pb.setCurrentPage(1);
		}
		else if(pb.getCurrentPage() > pb.getTotalPage()){
			pb.setCurrentPage(pb.getTotalPage());
		}
		//获得分页的起始行与每页行数
		int index = (pb.getCurrentPage()-1) * pb.getPageCount();
		int count = pb.getPageCount();
		
		list.add(index);
		list.add(count);
		
		try{
			//执行查询，将查询结果放入list集合中，在设置到PageBean中
			List<Food> pageData = JdbcUtils.getQueryRunner().query(sb.toString(), new BeanListHandler<Food>(Food.class),list.toArray());
			pb.setPageData(pageData);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getTotalCount(PageBean<Food> pb) {
		// TODO Auto-generated method stub
		// 获取条件对象
		Condition condition = pb.getCondition();
		// 条件之类别id
		int typeId = condition.getFoodTypeId();
		// 条件之菜品名称
		String foodName = condition.getFoodName();
		
		StringBuffer sb = new StringBuffer();
		sb.append("select");
		sb.append("		count(*) ");
		sb.append("from ");
		sb.append("		food f, ");
		sb.append("		foodType t ");
		sb.append("where 1=1");
		sb.append("		and f.foodType_id=t.id ");
		// 存储查询条件对应的值
		List<Object> list = new ArrayList<Object>();
		/*******拼接查询条件*********/
		// 类别id条件
		if (typeId > 0) {
			sb.append("	and f.foodType_id=?");
			list.add(typeId);  // 组装条件值
		}
		// 菜品名称
		if (foodName != null && !"".equals(foodName.trim())) {
			sb.append("  and f.foodName like ?");
			list.add(foodName);    // 组装条件值
		}
		
		try {
			// 查询
			Long num = JdbcUtils.getQueryRunner().query(sb.toString(), new ScalarHandler<Long>(),list.toArray());
			return num.intValue();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Food findById(int id) {
		// TODO Auto-generated method stub
		//根据菜系查询
		StringBuffer sb = new StringBuffer();
		sb.append(" select");
		sb.append("		f.id,");
		sb.append("		f.foodName,");
		sb.append("		f.price,");
		sb.append("		f.mprice,");
		sb.append("		f.remark,");
		sb.append("		f.img,");
		sb.append("		f.foodType_id,");
		sb.append("		t.typeName ");
		sb.append(" from ");
		sb.append("		food f, ");
		sb.append("		foodType t ");
		sb.append(" where 1=1");
		sb.append("		and f.foodType_id=t.id ");
		
		try {
			return JdbcUtils.getQueryRunner().query(sb.toString(), new BeanHandler<Food>(Food.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	

}
