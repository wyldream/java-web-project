package service;

import utils.PageBean;
import dao.IFoodDao;
import entity.Food;
import factory.BeanFactory;

public class FoodService implements IFoodService{
	// ´´½¨dao
	private IFoodDao foodDao = BeanFactory.getInstance("foodDao", IFoodDao.class);
	
	public Food findById(int id) {
		try {
			return foodDao.findById(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void getAll(PageBean<Food> pb) {
		try {
			foodDao.getAll(pb);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
