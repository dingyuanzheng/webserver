package upload;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.StringUtil;

public class SingleFileInfoServlet extends HttpServlet {
	
	private String baseUrl = StringUtil.ip + "/aixuexiapp/res/";
	
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
		resp.setHeader("Content-type", "text/html;charset=UTF-8");  
		req.setCharacterEncoding("UTF-8");
		
		
	    String name = new String(req.getParameter("name").getBytes("iso-8859-1"), "utf-8");
	    String group = new String(req.getParameter("group").getBytes("iso-8859-1"), "utf-8");
		
	    
	    
        PrintWriter out = resp.getWriter();
        out.append("<html>");
        out.append("<head>");
        out.append("<base href=" + StringUtil.ip + ">");
        out.append("<title>爱学习android客户端下载</title>");
        out.append("<meta http-equiv='refresh' content='10'>");
        out.append("</head>");
        out.append("<body align='center'>");
        
        String[] files = null;
        if(StringUtil.isBlank(name) && StringUtil.isBlank(group)) {
        	files = StringUtil.getWebRootAiXueXiResStrAbsolutePath(this , "");
        }else if(!StringUtil.isBlank(name) && !StringUtil.isBlank(group)) {
        	files = new String[1];
        	files[0] = group + "/" + name;
        }else if(!StringUtil.isBlank(name) && StringUtil.isBlank(group)) {
        	files = new String[1];
        	files[0] = name;
        }else if(StringUtil.isBlank(name) && !StringUtil.isBlank(group)) {
        	files = StringUtil.getWebRootAiXueXiResStrAbsolutePath(this , group);
        }
		
		if(files != null && files.length > 0) {
			for(int i = 0 ; i < files.length ; i ++) {
				System.out.println(files[i] + "文件名字");
				out.append("<h1>"+ files[i] +"</h1>");
				out.append("<h5>下载地址："+ baseUrl + files[i] +"</h5>");
				out.append("<img align='center' style='height:280px;width:280px' src= '" +  StringUtil.ip + "/qcode.jspx?url="+ baseUrl + files[i] +"' />");
			}
		}else {
			out.append("<h1>暂时没有文件，请返回查看</h1>");
		}
		out.append("</html>");
		out.append("</body>");
		out.flush();
        out.close();
	}

}
