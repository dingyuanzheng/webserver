package gitlog;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.CommentUtil;
import utils.StringUtil;

public class GetCommitLogFromServlet extends HttpServlet {
	
	
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
		
		out.append(CommentUtil.respSuccessTeacher(LogData.logs , "日志获取成功"));
		out.close();
		
	}
}
