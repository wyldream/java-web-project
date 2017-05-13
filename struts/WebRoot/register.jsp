<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     <%@taglib uri="/struts-tags" prefix="s" %>
  	 <form method="post" action="${pageContext.request.contextPath }/data_register.action" enctype=“multipart/form-data”>
  	 	用户名：<input type="text" name="user.userName">
  	 	        <!-- struts在运行期间在屏幕上显示验证的错误信息 -->
 	 		    <s:fielderror fieldName="user.userName"></s:fielderror>
  	 	<br/>
  	 	密码：<input type="text" name="user.pwd">
  	 			<s:fielderror fieldName="user.pwd"></s:fielderror>
  	 	<br/>
  	 	邮箱：<input type="text" name="user.email"><br/>
  	 	生日：<input type="text" name="user.birth"><br/>
  	 	<input type="submit" value="注册"><br/>
  	 </form>
  	  <s:debug></s:debug>
  </body>
</html>
