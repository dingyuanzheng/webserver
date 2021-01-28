<%@ page language="java" import="java.util.*,upload.bean.FileInfo,utils.DateUtils,utils.MathUtils" pageEncoding="utf-8"%>
<%@ page import="utils.MathUtils" %>
<%@ page import="upload.FileListHandleServlet" %>
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
  <%  long beginTime = System.currentTimeMillis();
	  FileListHandleServlet.currentKeySet.clear();
      ArrayList<FileInfo> fileInfos = new ArrayList<FileInfo>();
      List<FileInfo> fileList = FileListHandleServlet.findFiles(request.getServletContext(),"",fileInfos);
//  	List<FileInfo> fileList = (List<FileInfo>)session.getAttribute("fileList");
	  FileListHandleServlet.removeRedundantCache();
	  long endTime = System.currentTimeMillis()-beginTime;
	  FileListHandleServlet.pageViewCount++;
	  System.out.println("FileListHandleServlet+pageViewCount="+FileListHandleServlet.pageViewCount+"duration="+endTime);
	  System.out.println("FileListHandleServlet+currentKeySet.Size="+FileListHandleServlet.currentKeySet.size()+"fileVersionCache.size="+FileListHandleServlet.fileVersionCache.size());
  %>
  
  	<div id="container">
	    <table>
	        <tr class="mockItem">
	            <td class="name">    文件名    </td>
	            <td class="group">    组名    </td>
				<td class="version">    版本    </td>
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
				     <td class="version"><%=fileList.get(i).getVersion()%></td>
				     <td class="time"><%=DateUtils.dateFormat(new Date(fileList.get(i).getUpdatedAt()), DateUtils.DATE_TIME_PATTERN)%>  </td>

				     <td class="size"><%=MathUtils.getScaleNumber(fileList.get(i).getSize(),1024*1024)%> MB</td>
				     <td class="opert">
					     <a href="${pageContext.request.contextPath}<%="/fileDetail?name=" + fileList.get(i).getName() + "&group=" + fileList.get(i).getGroup()+ "&size=" + fileList.get(i).getSize()+ "&updateAt=" + fileList.get(i).getUpdatedAt()%>">查看详情</a>
					     <a href="${pageContext.request.contextPath}<%="/deleteFile?name=" + fileList.get(i).getName() + "&group=" + fileList.get(i).getGroup()%>">删除</a>
					     <a href="<%=fileList.get(i).getUrl()%>">下载</a>
					 </td>
				</tr>
			<%
			    }
	        %> 
	    </table>
	</div>
  </body>
</html>
