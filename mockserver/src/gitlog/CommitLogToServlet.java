package gitlog;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		
		String project = new String(request.getParameter("project").getBytes("iso-8859-1"), "utf-8");
		String branch = new String(request.getParameter("branch").getBytes("iso-8859-1"), "utf-8");
		String msg = new String(request.getParameter("msg").getBytes("iso-8859-1"), "utf-8");
		PrintWriter out = resp.getWriter();
		
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
