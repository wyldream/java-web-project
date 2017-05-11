package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;

public class LoginFilter implements Filter{
	private String uri ;

	/**
	 * ������
	 * 
		1. ��ָ�����е���Դ����Щ��Դ����Ҫ���أ�
		      login.jsp   +    /login  (request������Ի�ȡ)
		2. ��ȡsession����session�л�ȡ��½�û�
		3. �ж��Ƿ�Ϊ�գ�
		      Ϊ�գ� ˵��û�е�½�� ��ת����½
		       ��Ϊ�գ� �Ѿ���½�����У�
	 */
/*	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		//0. ת��
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		//1. ��ȡ������Դ����ȡ  
		String uri = request.getRequestURI();   // /emp_sys/login.jsp
		// ��ȡ ��login.jsp��login��
		String requestPath = uri.substring(uri.lastIndexOf("/") + 1, uri.length());
		System.out.println(requestPath);
		
		//2. �жϣ� �ȷ���һЩ��Դ��/login.jsp��/login
//		if ("login".equals(requestPath) || "login.jsp".equals(requestPath)) {
			// ����
			chain.doFilter(request, response);
		}
		else {
			//3. ��������Դ��������
			//3.1 �Ȼ�ȡSession����ȡsession�еĵ�½�û�(loginInfo)
			HttpSession session = request.getSession(false);
			// �ж�
			if (session != null) {
				
				Object obj = session.getAttribute("loginInfo");
				
				//3.2�����ȡ�����ݲ�Ϊ�գ�˵���Ѿ���½������
				if (obj != null) {
					// ����
					chain.doFilter(request, response);
				} else {
					//3.3�����ȡ������Ϊ�գ�˵��û�е�½�� ��ת����½
					uri = "/login.jsp";
				}
				
			} else {
				// �϶�û�е�½
				uri = "/login.jsp";
			}
			request.getRequestDispatcher(uri).forward(request, response);
		}
	}*/
	String requestPath;
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		//0. ת��
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		//1. ��ȡ������Դ����ȡ  
		uri = request.getRequestURI();   // /emp_sys/login.jsp
		// ��ȡ ��login.jsp��login��
		requestPath = uri.substring(uri.lastIndexOf("/") + 1, uri.length());
		//2. �жϣ� �ȷ���һЩ��Դ��/login.jsp��/login
		if ("login".equals(requestPath) || "login.jsp".equals(requestPath)) {
			// ����
			chain.doFilter(request, response);
		}
		else {
			//3. ��������Դ��������
			//3.1 �Ȼ�ȡSession����ȡsession�еĵ�½�û�(loginInfo)
			HttpSession session = request.getSession(false);
			// �ж�
			if (session != null) {
				
				Object obj = session.getAttribute("loginInfo");
				
				//3.2�����ȡ�����ݲ�Ϊ�գ�˵���Ѿ���½������
				if (obj != null) {
					// ���У���                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             ��
					chain.doFilter(request, response);
					//����return�����б�ҳ�Ҳ���������
					return;//������return�ȷ��У����Ǽ�����servlet�󻹻����ִ��filter�������ֻ�ת����ֻ����Ϊִ���ٶȿ����Կ�����servlet���棿
//					uri="/login.jsp";
				} else {
					//3.3�����ȡ������Ϊ�գ�˵��û�е�½�� ��ת����½
					uri = "/login.jsp";
				}
				
			} else {
				// �϶�û�е�½
				uri = "/login.jsp";
			}
			request.getRequestDispatcher(uri).forward(request, response);
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}


	public void destroy() {
		
	}
}
