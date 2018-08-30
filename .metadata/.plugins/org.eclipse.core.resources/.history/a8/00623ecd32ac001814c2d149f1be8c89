package qcode;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.CreateQRCode;
import utils.StringUtil;

public class ApkServlet extends HttpServlet {
	
	private String baseUrl = StringUtil.ip + "/aixuexiapp/apk/";
	
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
        PrintWriter out = resp.getWriter();
        out.append("<html>");
        out.append("<head>");
        out.append("<base href='http://10.39.2.203:8080/mock/'>");
        out.append("<title>爱学习android客户端下载</title>");
        out.append("<meta http-equiv='refresh' content='10'>");
        out.append("</head>");
        out.append("<body align='center'>");
        
		String[] files = StringUtil.getWebRootAiXueXiAppAbsolutePath(this);
		if(files != null && files.length > 0) {
			for(int i = 0 ; i < files.length ; i ++) {
				out.append("<h1>"+ files[i] +"</h1>");
				out.append("<h5>下载地址："+ baseUrl + files[i] +"</h5>");
				out.append("<img align='center' style='height:280px;width:280px' src='qcode.jspx?url="+ files[i] +"' />");
			}
		}else {
			out.append("<h1>打包中，请稍后...</h1>");
		}
		out.append("</html>");
		out.append("</body>");
		out.flush();
        out.close();
	}

}
