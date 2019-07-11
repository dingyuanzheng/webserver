package upload;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import utils.CommentUtil;
import utils.SendMsgUtil;
import utils.StringUtil;

public class SendWXServlet extends HttpServlet {
	
	private String msgtype = "";
	private String key = "";
	private String content = "";
	private String mentioned_list = "";
	private String mentioned_mobile_list = "";
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html");
		resp.setHeader("Content-type", "text/json;charset=UTF-8");  
		req.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		try {
			 DiskFileItemFactory factory = new DiskFileItemFactory();
			 ServletFileUpload upload = new ServletFileUpload(factory);
			 upload.setHeaderEncoding("UTF-8"); 
			 if(!ServletFileUpload.isMultipartContent(req)){
				 System.out.println("参数异常1");
				 out.append(CommentUtil.respErrorTeacher("参数异常"));
           	     out.flush();
         		 out.close();
				 return;
			 }
			 mentioned_list = "";
			 msgtype = "";
			 List<FileItem> list = upload.parseRequest(req);
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
	                  if("key".equals(name)) {
	                	  key = value;
	                  }else if("content".equals(name)) {
	                	  content = value;
	                  }else if("msgtype".equals(name)) {
	                	  msgtype = value;
	                  }else if("mentioned_list".equals(name)) {
	                	  mentioned_list = value;
	                  }
	             }
	           }
			 String postResult = ""; 
			 if("text".equals(msgtype)) {
				 if(StringUtil.isBlank(mentioned_list)) {
					 postResult = SendMsgUtil.sendText(key, content);
				 }else {
					 final String[] mentioneds = mentioned_list.split(",");
					 postResult = SendMsgUtil.sendText(key, content, mentioneds);
				 }
			 }
			 System.out.println(postResult);
    		 out.append(CommentUtil.respSuccessTeacher(new Object() , "发送成功"));
		}catch (Exception e) {
			e.printStackTrace();
			out.append(CommentUtil.respErrorTeacher("参数异常"));
		}
		out.flush();
		out.close();
	}
}