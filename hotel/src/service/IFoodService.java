package service;

import utils.PageBean;
import entity.Food;

public interface IFoodService {
	/**
	 * ������ѯ
	 */
	Food findById(int id);

	/**
	 * ��ҳ��ѯ
	 */
	void getAll(PageBean<Food> pb);
}
