package jili;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.CommentUtil;
import utils.StringUtil;
import utils.datacenter.BaseDataCenter;
import jili.bean.gender.GenderConfirmResponse;
import jili.bean.student.student_studentInfoBean;

/**
 * 学生信息
 * @author test
 *
 */
public class StudentInfoServlet extends HttpServlet {
	
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
        
        System.out.println("请求来了StudentInfoServlet" + strdentId);
        
        if(StringUtil.isBlank(strdentId)){
        	out.append(CommentUtil.respError("参数错误"));
        }else{
        	student_studentInfoBean stu = new student_studentInfoBean();
        	stu.setAvatarUrl("http://img-test.aixuexi.com/810553/2e5f17e0-a700-49aa-950b-537816e50874.jpeg");
        	stu.setCoinCount("534");
        	stu.setMedalCount(1);
        	stu.setName("我是整顆心");
        	stu.setSchoolName("郑朝凤测试机构");
        	stu.setSex(1);
        	stu.setGrade(-1);
        	stu.setCode("");
        	stu.setDoubleTeacher(true);
        	stu.setFashionUrl("http://192.168.3.197:8080/mock/images/dressv1/icon_default_boy.png");
        	stu.setWheConfirmGender(!BaseDataCenter.userSex.containsKey(strdentId));
        	stu.setCountDown(10000);
        	stu.setFreeExtractingChance(1);
            out.append(CommentUtil.respSuccess(stu));
        }
        out.flush();
        out.close();
	}
}
