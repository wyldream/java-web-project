package dao;

import utils.PageBean;
import entity.Food;

/**
 * ��Ʒ����
 * @author weiyongle
 *
 */
public interface IFoodDao {
	/**
	 * ��ҳ�Ұ�������ѯ���еĲ�Ʒ
	 */
	void getAll(PageBean<Food> pb);
	
	/**
	 * ������ͳ�Ʋ�Ʒ���ܼ�¼��
	 */
	int getTotalCount(PageBean<Food> pb);
	
	/**
	 * ����id��ѯ
	 */
	Food findById(int id);
}
