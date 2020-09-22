package upload;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import upload.bean.FileInfo;
import utils.Analyze;
import utils.StringUtil;

public class FileListHandleServlet extends HttpServlet {
	
	
	private ArrayList<FileInfo> fileInfos = new ArrayList<FileInfo>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		fileInfos.clear();
		findFile("");
		HttpSession session = request.getSession();
		session.setAttribute("fileList", fileInfos);
		resp.sendRedirect("./fileList.jsp");
		System.out.println(Analyze.analyzeToJson(fileInfos));
	}
	
	/**
	 * 查找文件
	 * @param folder
	 */
	private void findFile(String folder) {
		File[] files = StringUtil.getWebRootAiXueXiResAbsolutePath(this , folder);
		if(files != null && files.length > 0) {
			for(int i = 0 ; i < files.length ; i ++) {
				if(files[i].exists()) {
					if(files[i].isFile()) {
						makeFileList(folder, fileInfos, files[i],this.getServletContext());
					}else {
						findFile(files[i].getName());
					}
				}else {
					continue;
				}
			}
		}
	}

	private static void setFileVerison(File file, FileInfo fileInfo) {
		try {
			String path = file.getPath();
			ZipFile zf = new ZipFile(path);
			InputStream in = null;
			in = new BufferedInputStream(new FileInputStream(path));
			Charset gbk = Charset.forName("gbk");
			ZipInputStream zin = new ZipInputStream(in,gbk);
			ZipEntry ze;
			while((ze = zin.getNextEntry()) != null){
				if(ze.toString().endsWith("json")){
					BufferedReader br = new BufferedReader(
							new InputStreamReader(zf.getInputStream(ze)));
					String line;
					while((line = br.readLine()) != null){
						fileInfo.setVersion(line);
						System.out.println(line.toString());
					}
					br.close();
				}
				System.out.println("=====");
			}
			zin.closeEntry();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查找文件
	 * @param servlet
	 * @param folder
	 */
	public static ArrayList<FileInfo> findFiles(ServletContext servlet, String folder,ArrayList<FileInfo> fileInfos) {

		File[] files = StringUtil.getWebRootAiXueXiResAbsolutePath(servlet , folder);
		if(files != null && files.length > 0) {
			for(int i = 0 ; i < files.length ; i ++) {
				if(files[i].exists()) {
					if(files[i].isFile()) {
						makeFileList(folder, fileInfos, files[i],servlet);
					}else {
						findFiles(servlet,files[i].getName(),fileInfos);
					}
				}else {
					continue;
				}
			}
		}
		return fileInfos;
	}

	private static void makeFileList(String folder, ArrayList<FileInfo> fileInfos, File file,ServletContext servlet) {
		FileInfo fileInfo = new FileInfo();
		fileInfo.setSize(file.length());
		fileInfo.setUpdatedAt(file.lastModified());
		fileInfo.setName(file.getName());
		fileInfo.setGroup(folder + "");
		try {
			String [] files = SingleFileInfoServlet.getFileUrl(file.getName() , folder + "",servlet);
			fileInfo.setUrl(SingleFileInfoServlet.baseUrl+files[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setFileVerison(file, fileInfo);
		fileInfos.add(fileInfo);
	}
}
