package service;

import java.util.List;

import dao.IFoodTypeDao;
import entity.FoodType;
import factory.BeanFactory;

public class FoodTypeService implements IFoodTypeService{

	// 调用dao
		//private IFoodTypeDao foodTypeDao = new FoodTypeDao();// 对象的创建，不能写死。
		// 工厂创建对象
		private IFoodTypeDao foodTypeDao = BeanFactory.getInstance("foodtypeDao", IFoodTypeDao.class);
	@Override
	public void save(FoodType foodType) {
		// TODO Auto-generated method stub
		try {
			foodTypeDao.save(foodType);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(FoodType foodType) {
		// TODO Auto-generated method stub
		try {
			foodTypeDao.update(foodType);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		try {
			foodTypeDao.delete(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public FoodType findById(int id) {
		// TODO Auto-generated method stub
		try {
			return foodTypeDao.findById(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<FoodType> getAll() {
		// TODO Auto-generated method stub
		try {
			return foodTypeDao.getAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<FoodType> getAll(String typeName) {
		// TODO Auto-generated method stub

		try {
			return foodTypeDao.getAll(typeName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
