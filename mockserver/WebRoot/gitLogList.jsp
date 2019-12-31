<%@ page language="java" import="java.util.*,gitlog.LogBean,gitlog.LogData" pageEncoding="utf-8"%>
<%@ page import="gitlog.LogData" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>爱学习日志服务</title>
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
        
        .index {
            height: 40px;
            width: 200px;
        }
        
        .name {
            height: 40px;
            width: 320px;
        }

        .group {
            height: 40px;
            width: 320px;
        }

         .time {
            height: 40px;
            width: 320px;
        }
    </style>
	
  </head>
  
  <body>
  <%
      Map<String , ArrayList<LogBean>> logs = LogData.logs;
  %>
  	<div id="container">
  	
  		<%
  			for(Map.Entry<String , ArrayList<LogBean>> log: logs.entrySet()){
  			ArrayList<LogBean> logMsgs = log.getValue();
		%>
			<h2>项目：<%=log.getKey() %></h2>
			<table>
		        <tr class="mockItem">
		        	<td class="index">    序号  </td>
		            <td class="name">    分支  </td>
		            <td class="group">  提交日志    </td>
		            <td class="time">   提交时间     </td>
		        </tr>
	        	
	        	<%
	       			for(int i=0 ; i < logMsgs.size() ; i++) {
	       		%>
       			<tr class="mockItem">
       				<td class="index"><%=i%></td>
				    <td class="name"><%=logMsgs.get(i).getBranch()%></td>
				    <td class="group"><%=logMsgs.get(i).getMsg()%></td>
				    <td class="time"><%=logMsgs.get(i).getTime()%>  </td>
				</tr>
				<%
				    }
		        %> 
	        </table>
		<%
			}
  		 %>
	</div>
  </body>
</html>
