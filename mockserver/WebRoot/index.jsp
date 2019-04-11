<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>爱学习</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta http-equiv="refresh" content="10">
  </head>
  
  <body align="center">
      <a href="${pageContext.request.contextPath}/upload.jsp" target="_Blank"><font size="45">上传文件</font></a>
      </br>
      <a href="${pageContext.request.contextPath}/fileList" target="_Blank"><font size="45">资源列表</font></a>
      </br>
      <a href="${pageContext.request.contextPath}/bejson.html" target="_Blank"><font size="45">json解析</font></a>
      </br>
      <a href="http://jira.dev.aixuexi.com" target="_Blank"><font size="45">jira地址</font></a>&nbsp&nbsp&nbsp&nbsp
      <a href="http://iwork.gaosiedu.com" target="_Blank"><font size="45">iwork地址</font></a>&nbsp&nbsp&nbsp&nbsp
      <a href="http://192.168.5.129:10000/html/web/controller/console/console.html" target="_Blank"><font size="45">DOClever地址</font></a>&nbsp&nbsp&nbsp&nbsp
      <a href="http://gitlab.ops.aixuexi.com" target="_Blank"><font size="45">GITLAB地址</font></a>
      </br>
      <a href="https://tinypng.com/" target="_Blank"><font size="45">图片压缩地址</font></a>&nbsp&nbsp&nbsp&nbsp
      <a href="https://tool.lu/coderunner/" target="_Blank"><font size="45">在线代码运行</font></a>&nbsp&nbsp&nbsp&nbsp
      <a href="https://tool.lu/hexconvert/" target="_Blank"><font size="45">进制转换</font></a>
     
  </body>
</html>
