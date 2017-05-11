package service;

import utils.PageBean;
import entity.Food;

public interface IFoodService {
	/**
	 * 主键查询
	 */
	Food findById(int id);

	/**
	 * 分页查询
	 */
	void getAll(PageBean<Food> pb);
}
