package dao;

import java.util.List;

import entity.FoodType;

/**
 * ��ϵģ��dao�ӿ����
 * @author weiyongle
 *
 */
public interface IFoodTypeDao {
	/**
	 * ���
	 */
	void save(FoodType foodType);
	/**
	 * ����
	 * @param foodType
	 */
	void update(FoodType foodType);
	/**
	 * ɾ��
	 * @param id
	 */
	void delete(int id);
	/**
	 * ����������ѯ
	 * @param id
	 * @return
	 */
	FoodType findById(int id);
	/**
	 * ��ѯ����
	 * @return
	 */
	List<FoodType> getAll();
	/**
	 * �������Ʋ�ѯ
	 * @param name
	 * @return
	 */
	List<FoodType> getAll(String name);
}
