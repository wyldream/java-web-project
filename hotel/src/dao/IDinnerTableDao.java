package dao;

import java.util.List;

import entity.DinnerTable;

public interface IDinnerTableDao {
	/**
	 * ����Ԥ��״̬��ѯ
	 */
	List<DinnerTable> findByStatus(TableStatus ts);

	/**
	 * ������ѯ
	 */
	DinnerTable findById(int id);
}
