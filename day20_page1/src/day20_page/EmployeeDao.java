package day20_page;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;



/**
 * ���ݷ��ʲ�ʵ��
 * ��װ�����ݿ��л�ȡ���ݵķ���
 * @author weiyongle
 *
 */
public class EmployeeDao implements IEmployeeDao{

/*	public void getAll(PageBean<Employee> pb) {
		// TODO Auto-generated method stub
		//2. ��ѯ�ܼ�¼��;  ���õ�pb������
		int totalCount = this.getTotalCount();
		pb.setTotalCount(totalCount);
		*//**
		 * Ϊ�˱���ҳ��������Χ��Ҫ�Ե�ǰҳ�����ж�
		 * ��ǰҳС�ڵ���0ʱΪһ
		 * �������ҳʱΪ���ҳ
		 *//*
		if(pb.getCurrentPage() <= 0){
			pb.setCurrentPage(1);
		}
		if(pb.getCurrentPage() > pb.getTotalPage()){
			pb.setCurrentPage(pb.getTotalPage());
		}
		//1. ��ȡ��ǰҳ�� �����ѯ����ʼ�С����ص�����
		int currentPage = pb.getCurrentPage();
		int index = (currentPage -1 ) * pb.getPageCount();		// ��ѯ����ʼ��
		int count = pb.getPageCount();// ��ѯ���ص�����
		
		//3. ��ҳ��ѯ����;  �Ѳ�ѯ�����������õ�pb������
	    String sql = "select * from employee limit ?,?";
	    
	    try {
			QueryRunner qr = JdbcUtils.queryRunner();
			//��ѯ��������
			List<Employee> pageData = qr.query(sql, new BeanListHandler<Employee>(Employee.class),index,count);
			//����ѯ�����������õ�pb��
			pb.setPageData(pageData);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
				
	}
    @Test
	public int getTotalCount() {
		//��ѯemployee���ж�����
		String sql = "select count(*) from employee";
		System.out.println(1);
		try {
			// ����QueryRunner����
			QueryRunner qr = JdbcUtils.queryRunner();
			// ִ�в�ѯ�� ���ؽ���ĵ�һ�еĵ�һ�У����ֻ��һ��һ�У�
			Long count = qr.query(sql, new ScalarHandler<Long>());
			System.out.println(count);
			return count.intValue();//�� int ��ʽ���ش� Long ��ֵ��
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}*/
	/**
	 * ��junit��������Ҫע�������
	��Ԫ���Է��������в�����Ҳ�����з���ֵ������void�������Եķ��������Ǿ�̬�ķ�����
	 */
	public void getAll(PageBean<Employee> pb) {
		
		//2. ��ѯ�ܼ�¼��;  ���õ�pb������
		int totalCount =1 ;//= this.getTotalCount();
		pb.setTotalCount(totalCount);
		
		
	/*	 * ���⣺ jspҳ�棬�����ǰҳΪ��ҳ���ٵ����һҳ����
		 *              �����ǰҳΪĩҳ���ٵ���һҳ��ʾ�����⣡
		 * �����
		 * 	   1. �����ǰҳ <= 0;       ��ǰҳ���õ�ǰҳΪ1;
		 * 	   2. �����ǰҳ > ���ҳ����  ��ǰҳ����Ϊ���ҳ��*/
		 
		// �ж�
		if (pb.getCurrentPage() <=0) {
			pb.setCurrentPage(1);					    // �ѵ�ǰҳ����Ϊ1
		} else if (pb.getCurrentPage() > pb.getTotalPage()){
			pb.setCurrentPage(pb.getTotalPage());		// �ѵ�ǰҳ����Ϊ���ҳ��
		}
		
		//1. ��ȡ��ǰҳ�� �����ѯ����ʼ�С����ص�����
		int currentPage = pb.getCurrentPage();
		int index = (currentPage -1 ) * pb.getPageCount();		// ��ѯ����ʼ��
		int count = pb.getPageCount();							// ��ѯ���ص�����
		
		
		//3. ��ҳ��ѯ����;  �Ѳ�ѯ�����������õ�pb������
		String sql = "select * from employee limit ?,?";
		try {
			// �õ�Queryrunner����
			QueryRunner qr = JdbcUtils.queryRunner();
			// ���ݵ�ǰҳ����ѯ��ǰҳ����(һҳ����)
			List<Employee> pageData = qr.query(sql, new BeanListHandler<Employee>(Employee.class), index, count);
			// ���õ�pb������
			pb.setPageData(pageData);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
    @Test
	public void getTotalCount() {
		String sql = "select count(*) from employee";
		System.out.println(1);
		try {
			// ����QueryRunner����
			QueryRunner qr = JdbcUtils.queryRunner();
			// ִ�в�ѯ�� ���ؽ���ĵ�һ�еĵ�һ��
			System.out.println(12);
			Long count = qr.query(sql, new ScalarHandler<Long>());
			System.out.println(count);
//			return count.intValue();
			return ;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}















