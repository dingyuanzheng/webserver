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
	      <a href="${pageContext.request.contextPath}/gitLogList.jsp" target="_Blank"><font size="4">查看git提交日志</font></a>&nbsp&nbsp&nbsp&nbsp
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
      
      <div>
      
      	<h2>发送邮件</h2>
      	<font>地址：http://10.39.3.239:8080/mockserver/sendMail</font></br>
      	<font>参数：subject（标题，必填），emailMsg（消息，必填），email（消息接收人，必填，多个接收人用逗号隔开）</font></br>
      	
        <h2>发送企业邮件</h2>
      	<font>地址：http://10.39.3.239:8080/mockserver/sendWxMsg</font></br>
      	<font>参数：key（机器人key，必填），content（消息内容，必填），msgtype（消息类型，必填，支持text）</font></br>
      	
      	
        <h2>文件上传</h2>
      	<font>地址：http://10.39.3.239:8080/mockserver/uploadFile</font></br>
      	<font>参数：username（组名，必填），file1（文件，必填）</font></br>
      	
      	<h2>文件查询</h2>
      	<font>地址：http://10.39.3.8:8080/mockserver/getFiles?group=student</font></br>
      	<font>参数：group（组名，必填）</font></br>
      		
      	<h2>git日志上传</h2>
      	<font>地址：http://10.39.3.8:8080/mockserver/commitlog?project=项目&branch=分支&msg=提交日志</font></br>
      	<font>参数：project（项目，必填），branch（分支，必填），msg（提交日志，必填）</font></br>
      	
      </div>
      
  </body>
</html>
