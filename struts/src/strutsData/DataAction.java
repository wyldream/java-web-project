package strutsData;


import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionChainResult;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

// 开发action： 处理请求
/**
 * 三种数据处理的方式
 * 1、调用servlet对象用servlet API
 * 2、用struts中的API
 * 3、实现接口的方式
 * @author weiyongle
 *
 */
public class DataAction extends ActionSupport {
	
	// 处理请求
	public String execute() throws Exception {
		//1、第一种方式。servlet API
/*		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		ServletContext application = ServletActionContext.getServletContext();
		request.setAttribute("requestData", "requestData1");
		session.setAttribute("sessionData", "sessionData1");
		application.setAttribute("applicationData", "applicationData1");*/
		// 【推荐：解耦的方式实现对数据的操作】
		// Struts中对数据操作，方式2： 通过ActionContext类 
		ActionContext ac = ActionContext.getContext();
		// 得到Struts对HttpServletRequest对象进行了封装，封装为一个map
		Map<String, Object> request = ac.getContextMap();
		Map<String, Object> session = ac.getSession();
		Map<String, Object> application = ac.getApplication();
		request.put("requestData", "request_data1_actionContext");
		session.put("sessionData", "session_data1_actionContext");
		application.put("applicationData", "application_data1_actionContext");
		return "success";
	}
}