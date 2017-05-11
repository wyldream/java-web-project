package service;

import java.util.List;

import dao.IDinnerTableDao;
import dao.TableStatus;
import entity.DinnerTable;
import factory.BeanFactory;

public class DinnerTableService implements IDinnerTableService {

	// 调用的Dao, 通常工厂创建实例
    private IDinnerTableDao dinnerTableDao = BeanFactory.getInstance(
				"dinnerTableDao", IDinnerTableDao.class);
//	DinnerTableDao dinnerTableDao = new DinnerTableDao();
	@Override
	public List<DinnerTable> findNoUseTable() {
		try {
			return dinnerTableDao.findByStatus(TableStatus.Free);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	@Override
	public DinnerTable findById(int id) {
		// TODO Auto-generated method stub
		try {
			return dinnerTableDao.findById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}

}
