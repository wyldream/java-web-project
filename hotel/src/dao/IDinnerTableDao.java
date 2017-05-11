package dao;

import java.util.List;

import entity.DinnerTable;

public interface IDinnerTableDao {
	/**
	 * 根据预定状态查询
	 */
	List<DinnerTable> findByStatus(TableStatus ts);

	/**
	 * 主键查询
	 */
	DinnerTable findById(int id);
}
