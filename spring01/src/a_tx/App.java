package a_tx;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	@Test
	public void testApp(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("a_tx/bean.xml");
		
		Dept dept = new Dept();
		dept.setDeptName("������");
		
		//���deptService����
		DeptService deptService = (DeptService) ac.getBean("deptService");
		deptService.save(dept);
	}
}
