<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>爱学习资源上传</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body align="center">
  		 <br/><br/>
  		 <p>组名：student 或者 teacher 其它文件可以用other</p>
	     <form action="${pageContext.request.contextPath}/uploadFile" enctype="multipart/form-data" method="post">
	                组 名:   <input type="text" name="username" size="36" , style="width:200px;"><br/><br/>
	    	 prod:   <input type="file" name="file1" , style="width:200px;"><br/><br/>
	    		     <input type="submit" value="提交" , style="width:100px;">
	     </form>
	     <br/><br/>
	     <a href="${pageContext.request.contextPath}/fileList"><font size="45">资源服务器</font></a>
  </body>
</html>
