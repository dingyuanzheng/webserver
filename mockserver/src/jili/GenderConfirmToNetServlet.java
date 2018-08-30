package jili;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.CommentUtil;
import utils.StringUtil;
import utils.datacenter.BaseDataCenter;
import jili.bean.gender.GenderConfirmResponse;

/**
 * 确认性别
 * @author test
 *
 */
public class GenderConfirmToNetServlet extends HttpServlet {
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
		
		String studentId = req.getParameter("studentId");
		String gender = req.getParameter("gender");
		
		//告诉数据库我修改好性别了
		//SexData.getInstance().updateIfExist(studentId, false);
		
        PrintWriter out = resp.getWriter();
        
        System.out.println("请求来了GenderConfirmToNetServlet==" + studentId  + "====" + gender);
        if(StringUtil.isBlank(studentId) || StringUtil.isBlank(gender)){
        	out.append(CommentUtil.respError("参数异常"));
        }else{
        	BaseDataCenter.userSex.put(studentId, Integer.parseInt(gender));
        	out.append(CommentUtil.respSuccess(new Object()));
        }
        out.flush();
        out.close();
	}
}
