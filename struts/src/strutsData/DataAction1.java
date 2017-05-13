package strutsData;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class DataAction1 extends ActionSupport implements RequestAware, SessionAware, ApplicationAware{

	private Map<String, Object> request;
	private Map<String, Object> session;
	private Map<String, Object> application;
	
	public void setApplication(Map<String, Object> application) {
		// TODO Auto-generated method stub
		this.application = application;
	}

	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request = request;		
	}
	
	@Override
	public String execute() throws Exception {
		
	 	// Êý¾Ý
	 	request.put("requestData", "request_data1_actionAware");
		session.put("sessionData", "session_data1_actionAware");
		application.put("applicationData", "application_data1_actionAware");
//		
		return SUCCESS;
	}
	
}
