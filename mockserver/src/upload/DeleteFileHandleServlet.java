package upload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import upload.bean.FileInfo;
import utils.Analyze;
import utils.StringUtil;

public class DeleteFileHandleServlet extends HttpServlet {
	
	
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
		
		 String name = new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8");
		 String group = new String(request.getParameter("group").getBytes("iso-8859-1"), "utf-8");
		
		System.out.println("name:" + name + "==group==" + group);
		
		if(StringUtil.isBlank(group)) {
			findAndDeleteFile("" , name);
		}else {
			findAndDeleteFile(group , name);
		}
		resp.sendRedirect("./fileList");
	}
	
	/**
	 * 查找文件并且删除
	 * @param folder
	 */
	private void findAndDeleteFile(String folder , String name) {
		File[] files = StringUtil.getWebRootAiXueXiResAbsolutePath(this , folder);
		if(files != null && files.length > 0) {
			for(int i = 0 ; i < files.length ; i ++) {
				if(files[i].exists()) {
					if(files[i].isFile()) {
						if(files[i].getName().equals(name)) {
							files[i].delete();
							break;
						}
					}else {
						findAndDeleteFile(files[i].getName() , name);
					}
				}else {
					continue;
				}
			}
		}
	}
}
