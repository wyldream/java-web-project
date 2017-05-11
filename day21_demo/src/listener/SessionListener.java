package listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import entity.Admin;

/**
 * ����Session���ٵĶ�����
 *  ������������session��ʱ�򣬴������б������Ƴ����׵ĵ�½�û�
 *
 */
public class SessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
	}
    //������������session��ʱ�򣬴������б������Ƴ���ǰ�ĵ�½�û�
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HttpSession session = se.getSession();
		ServletContext sc = session.getServletContext();
		//��ȡsession�д洢�ĵ�ǰ��¼�û�
		Object obj = session.getAttribute("loginInfo");
		//��ȡservletContext�����д洢�������û��б���
		List<Admin> list = (List<Admin>)sc.getAttribute("onlineList");
		if(obj!=null){
			//�ѵ�ǰ��¼�û��������б�����ȥ��
		   list.remove(obj);
		}
	}

}
