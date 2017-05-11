package listener;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import entity.Admin;
/**
 * 在线列表监听器(监听servletContext对象的创建)
 * @author weiyongle
 *
 */
public class OnlineAdminListener implements ServletContextListener {
	//一个web应用只有一个servletContext对象
	//servletContext对象创建时创建在线列表集合
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		//创建一个集合用于存放当前登录者
		//创建集合，将集合添加到servletContext中
		ArrayList<Admin> onlinelist = new ArrayList<Admin>();
		//将在线列表集合放入servletContext域中
		sce.getServletContext().setAttribute("onlineList", onlinelist);
	}
	//当servletContext对象销毁时移除在线列表集合
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContext sc = sce.getServletContext();
		Object obj = sc.getAttribute("onlineList");
		if(obj!=null){
			sc.removeAttribute("onlineList");
		}
	}



}
