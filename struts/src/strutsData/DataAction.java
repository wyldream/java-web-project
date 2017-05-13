package strutsData;


import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionChainResult;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

// ����action�� ��������
/**
 * �������ݴ���ķ�ʽ
 * 1������servlet������servlet API
 * 2����struts�е�API
 * 3��ʵ�ֽӿڵķ�ʽ
 * @author weiyongle
 *
 */
public class DataAction extends ActionSupport {
	
	// ��������
	public String execute() throws Exception {
		//1����һ�ַ�ʽ��servlet API
/*		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		ServletContext application = ServletActionContext.getServletContext();
		request.setAttribute("requestData", "requestData1");
		session.setAttribute("sessionData", "sessionData1");
		application.setAttribute("applicationData", "applicationData1");*/
		// ���Ƽ�������ķ�ʽʵ�ֶ����ݵĲ�����
		// Struts�ж����ݲ�������ʽ2�� ͨ��ActionContext�� 
		ActionContext ac = ActionContext.getContext();
		// �õ�Struts��HttpServletRequest��������˷�װ����װΪһ��map
		Map<String, Object> request = ac.getContextMap();
		Map<String, Object> session = ac.getSession();
		Map<String, Object> application = ac.getApplication();
		request.put("requestData", "request_data1_actionContext");
		session.put("sessionData", "session_data1_actionContext");
		application.put("applicationData", "application_data1_actionContext");
		return "success";
	}
}