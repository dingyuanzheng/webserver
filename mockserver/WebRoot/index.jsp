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
	<!-- <meta http-equiv="refresh" content="10"> -->
  </head>
  
  <body align="center">
  
	  <table border=0 cellspacing=1 cellpadding=0 width=’98%’>
			  <tr>
		  	    <div align="center">
					<iframe src="http://www.cctv.com/homepage/46/index.shtml"; name="express"
						width="354" height="16" marginwidth="0" marginheight="0" frameborder="0"
						scrolling="no">
						</iframe>
				</div>
			  </tr>
			  <tr>
				  <div align="center">
				  		<iframe width="700" scrolling="no" height="60" frameborder="0" allowtransparency="true" src="http://i.tianqi.com/index.php?c=code&id=12&icon=1&num=5"></iframe>
				  </div>
			  </tr>
		</table>
		
		</br>
	  <div>
		  <a href="${pageContext.request.contextPath}/upload.jsp" target="_Blank"><font size="4">上传文件</font></a>&nbsp&nbsp&nbsp&nbsp
	      <a href="${pageContext.request.contextPath}/fileList.jsp" target="_Blank"><font size="4">资源列表</font></a>&nbsp&nbsp&nbsp&nbsp
	      <a href="${pageContext.request.contextPath}/bejson.html" target="_Blank"><font size="4">json解析</font></a>&nbsp&nbsp&nbsp&nbsp
	      <a href="http://jira.dev.aixuexi.com" target="_Blank"><font size="4">jira地址</font></a>&nbsp&nbsp&nbsp&nbsp
	      <a href="http://iwork.gaosiedu.com" target="_Blank"><font size="4">iwork地址</font></a>&nbsp&nbsp&nbsp&nbsp
	      <a href="http://192.168.5.129:10000/html/web/controller/console/console.html" target="_Blank"><font size="4">DOClever地址</font></a>&nbsp&nbsp&nbsp&nbsp
	      <a href="http://gitlab.ops.aixuexi.com" target="_Blank"><font size="4">GITLAB地址</font></a>&nbsp&nbsp&nbsp&nbsp
	      <a href="https://tinypng.com/" target="_Blank"><font size="4">图片压缩地址</font></a>&nbsp&nbsp&nbsp&nbsp
	      <a href="https://tool.lu/coderunner/" target="_Blank"><font size="4">在线代码运行</font></a>&nbsp&nbsp&nbsp&nbsp
	      <a href="https://tool.lu/hexconvert/" target="_Blank"><font size="4">进制转换</font></a></br>
	      <a href="${pageContext.request.contextPath}/ios/index.html" target="_Blank"><font size="4">ios资源面板</font></a>&nbsp&nbsp&nbsp&nbsp
	  </div>
      
  </body>
</html>
