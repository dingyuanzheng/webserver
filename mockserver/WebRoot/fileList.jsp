<%@ page language="java" import="java.util.*,upload.bean.FileInfo,utils.DateUtils" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>爱学习资源服务</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<style type="text/css">
        #container {
            width: 1200px;
            margin-left: auto;
            margin-right: auto;
        }
        
        .name {
            height: 40px;
            width: 200px;
        }

        .group {
            height: 40px;
            width: 200px;
        }

         .time {
            height: 40px;
            width: 280px;
        }
        

        .size {
            height: 40px;
            width: 200px;
        }
        
        .opert{
            height: 40px;
            width: 200px;
        }
    </style>
	
  </head>
  
  <body>
  <% 
  	List<FileInfo> fileList = (List<FileInfo>)session.getAttribute("fileList");
  %>
  
  	<div id="container">
	    <table>
	        <tr class="mockItem">
	            <td class="name">    文件名    </td>
	            <td class="group">    组名    </td>
	            <td class="time">    创建时间     </td>
	            <td class="size">    文件大小    </td>
	            <td class="opert">    操  作    </td>
	        </tr>
	        
	       <%
	       		for(int i=0 ; i < fileList.size() ; i++) {
	       	%>
       			<tr class="mockItem">
				     <td class="name"><%=fileList.get(i).getName()%></td>
				     <td class="group"><%=fileList.get(i).getGroup()%></td>
				     <td class="time"><%=DateUtils.dateFormat(new Date(fileList.get(i).getUpdatedAt()), DateUtils.DATE_TIME_PATTERN)%>  </td>
				     <td class="size"><%=fileList.get(i).getSize()%>KB</td>
				     <td class="opert">
					     <a href="${pageContext.request.contextPath}<%="/fileDetail?name=" + fileList.get(i).getName() + "&group=" + fileList.get(i).getGroup()%>">查看详情</a>
					     <a href="${pageContext.request.contextPath}<%="/deleteFile?name=" + fileList.get(i).getName() + "&group=" + fileList.get(i).getGroup()%>">删除</a>
					 </td>
				</tr>
			<%
			    }
	        %> 
	    </table>
	</div>
  </body>
</html>
