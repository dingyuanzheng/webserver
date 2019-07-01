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

import com.alibaba.fastjson.JSONObject;

import utils.CommentUtil;
import utils.HttpUtil;
import utils.MailUtils;
import utils.StringUtil;

public class SendWXServlet extends HttpServlet {
	
	private String msgtype = "";
	private String key = "";
	private String content = "";
	
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
	                  }
	             }
	           }
			 String url = "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=";
			 url += key;
			 JSONObject json = new JSONObject();
			 json.put("msgtype", "text");
			 JSONObject contentJson = new JSONObject();
			 contentJson.put("content", content);
			 json.put("text", contentJson);
			 System.out.println(json.toString());
			 String postResult = HttpUtil.doPost(url, json.toString());
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