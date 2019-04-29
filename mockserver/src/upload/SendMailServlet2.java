package upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import utils.Analyze;
import utils.CommentUtil;
import utils.MailUtils;
import utils.StringUtil;

import com.google.gson.reflect.TypeToken;

public class SendMailServlet2 extends HttpServlet {
	
	private String subject = "";
	private String emailMsg = "";
	private String email = "";
	
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
				 //如果fileitem中封装的是普通输入项的数据
				 if(item.isFormField()){
	                  String name = item.getFieldName();
	                  //解决普通输入项的数据的中文乱码问题
	                  String value = item.getString("UTF-8");
	                  System.out.println(name + "=" + value);
	                  if(StringUtil.isBlank(name) || StringUtil.isBlank(value)) {
	                	  out.append(CommentUtil.respErrorTeacher("参数异常"));
	                	  out.flush();
	              		  out.close();
	                	  return;
	                  }
	                  if("subject".equals(name)) {
	                	  subject = value;
	                  }else if("emailMsg".equals(name)) {
	                	  emailMsg = value;
	                  }else if("email".equals(name)) {
	                	  email = value;
	                  }
	             }
	           }
			 final String[] emails = email.split(",");
    		 for(int i = 0 ; i < emails.length ; i++) {
				MailUtils.sendMail(emails[i] , subject , emailMsg);
    		 }
    		 out.append(CommentUtil.respSuccessTeacher(new Object() , "发送成功"));
		}catch (Exception e) {
			e.printStackTrace();
			out.append(CommentUtil.respErrorTeacher("参数异常"));
		}
		out.flush();
		out.close();
	}
}