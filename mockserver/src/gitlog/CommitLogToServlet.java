package gitlog;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import utils.CommentUtil;
import utils.DateUtils;
import utils.StringUtil;

public class CommitLogToServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html");
		resp.setHeader("Content-type", "text/json;charset=UTF-8");  
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		String project = "";
		String branch = "";
		String msg = "";
		DiskFileItemFactory factory = new DiskFileItemFactory();
		 ServletFileUpload upload = new ServletFileUpload(factory);
		 upload.setHeaderEncoding("UTF-8"); 
		 if(!ServletFileUpload.isMultipartContent(request)){
			 out.append(CommentUtil.respErrorTeacher("参数异常"));
      	     out.flush();
    		 out.close();
			 return;
		 }
		 List<FileItem> list;
		try {
			list = upload.parseRequest(request);
			for(FileItem item : list) {
				 if(item.isFormField()){
	                 String name = item.getFieldName();
	                 String value = item.getString("UTF-8");
	                 System.out.println(name + "=" + value);
	                 if(StringUtil.isBlank(name) || StringUtil.isBlank(value)) {
	               	  out.append(CommentUtil.respErrorTeacher("参数异常"));
	               	  out.flush();
	             		  out.close();
	               	  return;
	                 }
	                 if("project".equals(name)) {
	                	 project = value;
	                 }else if("branch".equals(name)) {
	                	 branch = value;
	                 }else if("msg".equals(name)) {
	                	 msg = value;
	                 }
	            }
	          }
		} catch (FileUploadException e1) {
			e1.printStackTrace();
		}
		System.out.println("project:" + project + "==branch==" + branch + "==msg==" + msg);
		if(StringUtil.isBlank(project) || StringUtil.isBlank(branch) || StringUtil.isBlank(msg)) {
			out.append(CommentUtil.respErrorTeacher("日志保存失败"));
		}else {
			if(LogData.logs.containsKey(project)) {//项目已经建立
				ArrayList<LogBean> logBeans = LogData.logs.get(project);
				if(logBeans.size() >= 256) {
					logBeans.remove(0);
				}
				LogBean logBean = new LogBean();
				logBean.setBranch(branch);
				logBean.setMsg(msg);
				try {
					logBean.setTime(DateUtils.dateFormat(new Date() , DateUtils.DATE_TIME_PATTERN));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				logBeans.add(logBean);
			}else {
				ArrayList<LogBean> logBeans = new ArrayList<LogBean>();
				LogBean logBean = new LogBean();
				logBean.setBranch(branch);
				logBean.setMsg(msg);
				try {
					logBean.setTime(DateUtils.dateFormat(new Date() , DateUtils.DATE_TIME_PATTERN));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				logBeans.add(logBean);
				LogData.logs.put(project, logBeans);
			}
			out.append(CommentUtil.respSuccessTeacher(LogData.logs , "日志保存成功"));
		}
		out.flush();
		out.close();
		
	}
}
