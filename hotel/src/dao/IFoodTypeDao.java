package dao;

import java.util.List;

import entity.FoodType;

/**
 * 菜系模块dao接口设计
 * @author weiyongle
 *
 */
public interface IFoodTypeDao {
	/**
	 * 添加
	 */
	void save(FoodType foodType);
	/**
	 * 更新
	 * @param foodType
	 */
	void update(FoodType foodType);
	/**
	 * 删除
	 * @param id
	 */
	void delete(int id);
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 */
	FoodType findById(int id);
	/**
	 * 查询所有
	 * @return
	 */
	List<FoodType> getAll();
	/**
	 * 根据名称查询
	 * @param name
	 * @return
	 */
	List<FoodType> getAll(String name);
}
