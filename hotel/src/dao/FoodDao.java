package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import utils.Condition;
import utils.JdbcUtils;
import utils.PageBean;
import entity.Food;

public class FoodDao implements IFoodDao {

	@Override
	public void getAll(PageBean<Food> pb) {
		// TODO Auto-generated method stub
		//��ȡ��װ��������
		Condition condition = pb.getCondition();
		//��ѯ���� ��Ʒ����
		String foodName = condition.getFoodName();
//		System.out.println(foodName);
		//��ѯ���� ��ϵid
		int typeId = condition.getFoodTypeId();
		StringBuffer sb = new StringBuffer();
		//ƴ�Ӳ�ѯ���
		sb.append("select");
		sb.append("		f.id,");
		sb.append("		f.foodName,");
		sb.append("		f.price,");
		sb.append("		f.mprice,");
		sb.append("		f.remark,");
		sb.append("		f.img,");
		sb.append("		f.foodType_id,");
		sb.append("		t.typeName ");
		sb.append("from ");
		sb.append("		food f, ");
		sb.append("		foodType t ");
		sb.append("where 1=1");
		sb.append("		and f.foodType_id=t.id ");
		//���ڴ洢��ѯ����
		ArrayList<Object> list = new ArrayList<Object>();
		//���ݲ�ϵ����ѯ
		if(typeId > 0){
			sb.append("  and f.foodType_id=? ");
			list.add(typeId);
		}
		//���ݲ�����ѯ
		if(foodName != null&&!"".equals(foodName.trim())){
			sb.append("   AND f.foodName LIKE ? ");
			list.add(foodName);
		}
		/********��ҳ����******************/
		sb.append(" limit ?,? " );
		//ҳ������
		/*****�жϣ�����ǰҳ< 1�� ���õ�ǰҳΪ1��  ����ǰҳ>��ҳ�������õ�ǰҳΪ��ҳ��******/
		int totalCount = getTotalCount(pb);
		pb.setTotalCount(totalCount);
		if(pb.getCurrentPage() < 1){
			pb.setCurrentPage(1);
		}
		else if(pb.getCurrentPage() > pb.getTotalPage()){
			pb.setCurrentPage(pb.getTotalPage());
		}
		//��÷�ҳ����ʼ����ÿҳ����
		int index = (pb.getCurrentPage()-1) * pb.getPageCount();
		int count = pb.getPageCount();
		
		list.add(index);
		list.add(count);
		
		try{
			//ִ�в�ѯ������ѯ�������list�����У������õ�PageBean��
			List<Food> pageData = JdbcUtils.getQueryRunner().query(sb.toString(), new BeanListHandler<Food>(Food.class),list.toArray());
			pb.setPageData(pageData);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getTotalCount(PageBean<Food> pb) {
		// TODO Auto-generated method stub
		// ��ȡ��������
		Condition condition = pb.getCondition();
		// ����֮���id
		int typeId = condition.getFoodTypeId();
		// ����֮��Ʒ����
		String foodName = condition.getFoodName();
		
		StringBuffer sb = new StringBuffer();
		sb.append("select");
		sb.append("		count(*) ");
		sb.append("from ");
		sb.append("		food f, ");
		sb.append("		foodType t ");
		sb.append("where 1=1");
		sb.append("		and f.foodType_id=t.id ");
		// �洢��ѯ������Ӧ��ֵ
		List<Object> list = new ArrayList<Object>();
		/*******ƴ�Ӳ�ѯ����*********/
		// ���id����
		if (typeId > 0) {
			sb.append("	and f.foodType_id=?");
			list.add(typeId);  // ��װ����ֵ
		}
		// ��Ʒ����
		if (foodName != null && !"".equals(foodName.trim())) {
			sb.append("  and f.foodName like ?");
			list.add(foodName);    // ��װ����ֵ
		}
		
		try {
			// ��ѯ
			Long num = JdbcUtils.getQueryRunner().query(sb.toString(), new ScalarHandler<Long>(),list.toArray());
			return num.intValue();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Food findById(int id) {
		// TODO Auto-generated method stub
		//���ݲ�ϵ��ѯ
		StringBuffer sb = new StringBuffer();
		sb.append(" select");
		sb.append("		f.id,");
		sb.append("		f.foodName,");
		sb.append("		f.price,");
		sb.append("		f.mprice,");
		sb.append("		f.remark,");
		sb.append("		f.img,");
		sb.append("		f.foodType_id,");
		sb.append("		t.typeName ");
		sb.append(" from ");
		sb.append("		food f, ");
		sb.append("		foodType t ");
		sb.append(" where 1=1");
		sb.append("		and f.foodType_id=t.id ");
		
		try {
			return JdbcUtils.getQueryRunner().query(sb.toString(), new BeanHandler<Food>(Food.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	

}
