package qcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.CreateQRCode;

public class ApkQcodeServlet extends HttpServlet {
	
	private String baseUrl = "http://10.39.2.203:8080/mock/aixuexiapp/apk/";
	
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
		String url = req.getParameter("url");
		String content = baseUrl + url;  
		CreateQRCode encoder = new CreateQRCode();
        encoder.encoderQRCoder(content, resp);
	}

}
