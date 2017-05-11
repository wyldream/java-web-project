package listener;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import entity.Admin;
/**
 * �����б������(����servletContext����Ĵ���)
 * @author weiyongle
 *
 */
public class OnlineAdminListener implements ServletContextListener {
	//һ��webӦ��ֻ��һ��servletContext����
	//servletContext���󴴽�ʱ���������б���
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		//����һ���������ڴ�ŵ�ǰ��¼��
		//�������ϣ���������ӵ�servletContext��
		ArrayList<Admin> onlinelist = new ArrayList<Admin>();
		//�������б��Ϸ���servletContext����
		sce.getServletContext().setAttribute("onlineList", onlinelist);
	}
	//��servletContext��������ʱ�Ƴ������б���
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContext sc = sce.getServletContext();
		Object obj = sc.getAttribute("onlineList");
		if(obj!=null){
			sc.removeAttribute("onlineList");
		}
	}



}
