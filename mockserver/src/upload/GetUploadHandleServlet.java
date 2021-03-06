package upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import upload.bean.FileInfo;
import utils.CommentUtil;
import utils.StringUtil;

public class GetUploadHandleServlet extends HttpServlet {
	
	private String baseUrl = "";
	
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
		
		String folder = request.getParameter("group");
		
        PrintWriter out = resp.getWriter();
        File[] files;
        if(StringUtil.isBlank(folder)) {
        	baseUrl = StringUtil.getIp() + "/aixuexiapp/res/";
        	files = StringUtil.getWebRootAiXueXiResAbsolutePath(this , "");
        }else {
        	baseUrl = StringUtil.getIp() + "/aixuexiapp/res/" + folder + "/";
        	files = StringUtil.getWebRootAiXueXiResAbsolutePath(this , folder);
        }
		
		ArrayList<FileInfo> fileInfos = new ArrayList<FileInfo>();
		if(files != null && files.length > 0) {
			for(int i = 0 ; i < files.length ; i ++) {
				if(files[i].exists() && files[i].isFile()) {
					FileInfo fileInfo = new FileInfo();
					fileInfo.setUrl(baseUrl + files[i].getName());
					fileInfo.setSize(files[i].length());
					fileInfo.setUpdatedAt(files[i].lastModified());
					fileInfo.setName(files[i].getName());
					fileInfos.add(fileInfo);
				}
			}
		}
		out.append(CommentUtil.respSuccessTeacher(fileInfos , "查询成功"));
		System.out.println(CommentUtil.respSuccessTeacher(fileInfos , "查询成功"));
		out.flush();
		out.close();
	}
}
