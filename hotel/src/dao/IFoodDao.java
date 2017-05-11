package dao;

import utils.PageBean;
import entity.Food;

/**
 * 菜品管理
 * @author weiyongle
 *
 */
public interface IFoodDao {
	/**
	 * 分页且按条件查询所有的菜品
	 */
	void getAll(PageBean<Food> pb);
	
	/**
	 * 按条件统计菜品的总记录数
	 */
	int getTotalCount(PageBean<Food> pb);
	
	/**
	 * 根据id查询
	 */
	Food findById(int id);
}
