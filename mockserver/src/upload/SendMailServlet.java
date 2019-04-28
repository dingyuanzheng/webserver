package upload;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.Analyze;
import utils.CommentUtil;
import utils.MailUtils;
import utils.StringUtil;

import com.google.gson.reflect.TypeToken;

public class SendMailServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html");
		resp.setHeader("Content-type", "text/html;charset=UTF-8");  
		req.setCharacterEncoding("UTF-8");
		
		final String subject = new String(req.getParameter("subject").getBytes("iso-8859-1"), "utf-8");
		final String emailMsg = new String(req.getParameter("emailMsg").getBytes("iso-8859-1"), "utf-8");
	    String email = new String(req.getParameter("email").getBytes("iso-8859-1"), "utf-8");
	    
	    
		//dingyuanzheng@gaosiedu.com,huangshan0@gaosiedu.com
	    PrintWriter out = resp.getWriter();
        try {
        	 if(StringUtil.isBlank(subject) || StringUtil.isBlank(emailMsg) || StringUtil.isBlank(email)) {
        		 out.append(CommentUtil.respErrorTeacher("参数异常"));
        	 }else {
        		 final String[] emails = email.split(",");
        		 for(int i = 0 ; i < emails.length ; i++) {
					MailUtils.sendMail(emails[i] , subject , emailMsg);
        		 }
        		 out.append(CommentUtil.respSuccessTeacher(new Object() , "发送成功"));
        	 }
		} catch (Exception e) {
			e.printStackTrace();
			out.append(CommentUtil.respErrorTeacher("参数异常"));
		}
        out.flush();
		out.close();
	}
}