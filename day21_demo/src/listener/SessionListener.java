package listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import entity.Admin;

/**
 * 监听Session销毁的动作：
 *  当服务器销毁session的时候，从在线列表集合中移除当亲的登陆用户
 *
 */
public class SessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
	}
    //当服务器销毁session的时候，从在线列表集合中移除当前的登陆用户
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HttpSession session = se.getSession();
		ServletContext sc = session.getServletContext();
		//获取session中存储的当前登录用户
		Object obj = session.getAttribute("loginInfo");
		//获取servletContext对象中存储的在线用户列表集合
		List<Admin> list = (List<Admin>)sc.getAttribute("onlineList");
		if(obj!=null){
			//把当前登录用户从在线列表集合中去除
		   list.remove(obj);
		}
	}

}
