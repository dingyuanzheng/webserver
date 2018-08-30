package jili;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jili.bean.gender.GenderConfirmResponse;
import utils.CommentUtil;

/**
 * 是否确认过性别
 * @author test
 *
 */
public class GenderConfirmServlet extends HttpServlet {
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
        PrintWriter out = resp.getWriter();
        
        String strdentId = req.getParameter("studentId");
        
        System.out.println("请求来了GenderConfirmServlet" + strdentId);
        
        if(strdentId == null || "".equals(strdentId)){
        	out.append(CommentUtil.respError("参数错误"));
        }else{
        	GenderConfirmResponse genderConfirmResponse = new GenderConfirmResponse();
            genderConfirmResponse.setWheConfirmGender(true);
            out.append(CommentUtil.respSuccess(genderConfirmResponse));
        }
        out.flush();
        out.close();
	}
}
