package voice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.CommentUtil;
import utils.StringUtil;
import voice.bean.RevisingSubmitBean;

public class CorrectSubmit extends HttpServlet {
	
	private int count = 0;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setHeader("Content-type", "text/json;charset=UTF-8");  
        PrintWriter out = resp.getWriter();
        
        System.out.println("请求来了LastTopic");
        
        String studentId = req.getParameter("studentId");
		String lessonId = req.getParameter("lessonId");
		String classId = req.getParameter("classId");
		String version = req.getParameter("version");
		String topicId = req.getParameter("topicId");
		
		count ++;
		
		if(StringUtil.isBlank(studentId) || StringUtil.isBlank(lessonId) || StringUtil.isBlank(classId) || StringUtil.isBlank(topicId)) {
			out.append(CommentUtil.respError("参数异常"));
		}else {
			RevisingSubmitBean mRevisingSubmitBean = new RevisingSubmitBean();
			mRevisingSubmitBean.setCorrectSubmit(count % 2);
			out.append(CommentUtil.respSuccess(mRevisingSubmitBean));
		}
		out.flush();
        out.close();
	}
}
