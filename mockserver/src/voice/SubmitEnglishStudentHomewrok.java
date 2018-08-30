package voice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.CommentUtil;
import utils.StringUtil;
import voice.bean.EnglishVoiceStudentEnglishHomeworkResultsBean;
import voice.bean.submitenglishstudenthomewrok.SubmitEnglishStudentHomewrokDataBean;

public class SubmitEnglishStudentHomewrok extends HttpServlet {
	
	private String[] contentYinChar = new String[]{"ɪk" , "s" , "t" , "en" , "d" , "ɪd"};
	private String[] contentSentChar = new String[]{"Hi" , "May" , "I" , "kiss" , "you" , "Fuck" , "Fine" , "you" , "And" , "you" , "what" , "are" , "you" , "doing" 
			, "Hi" , "May" , "I" , "kiss" , "you" , "Fuck" , "Fine" , "you" , "And" , "you" , "what" , "are" , "you" , "doing" 
			, "Hi" , "May" , "I" , "kiss" , "you" , "Fuck" , "Fine" , "you" , "And" , "you" , "what" , "are" , "you" , "doing" 
			, "Hi" , "May" , "I" , "kiss" , "you" , "Fuck" , "Fine" , "you" , "And" , "you" , "what" , "are" , "you" , "doing" 
			, "Hi" , "May" , "I" , "kiss" , "you" , "Fuck" , "Fine" , "you" , "And" , "you" , "what" , "are" , "you" , "doing" 
			, "Hi" , "May" , "I" , "kiss" , "you" , "Fuck" , "Fine" , "you" , "And" , "you" , "what" , "are" , "you" , "doing" 
			, "Hi" , "May" , "I" , "kiss" , "you" , "Fuck" , "Fine" , "you" , "And" , "you" , "what" , "are" , "you" , "doing" 
			, "Hi" , "May" , "I" , "kiss" , "you" , "Fuck" , "Fine" , "you" , "And" , "you" , "what" , "are" , "you" , "doing"};
	private int[] score = new int[]{0 , 1 , 2 , 3};//优 良 中 差
	private int sent = 9;
	private int work = 8;
	private String[] music = new String[]{"http://10.39.2.92:8080/mock/images/testVoice.mp3" , "http://10.39.2.92:8080/mock/images/testVoice2.mp3" , "http://10.39.2.92:8080/mock/images/testVoice3.mp3"};
	
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
        
        System.out.println("请求来了SubmitEnglishStudentHomewrok");
        
        
        String studentId = req.getParameter("studentId");
		String lessonId = req.getParameter("lessonId");
		String classId = req.getParameter("classId");
		String paperId = req.getParameter("paperId");
		String version = req.getParameter("version");
		String answer = req.getParameter("answer");
		String topicId = req.getParameter("topicId");
		String questionIndex = req.getParameter("questionIndex");
		String corrected = req.getParameter("corrected");
		String chiShengParams = req.getParameter("chiShengParams");
		String topicType = req.getParameter("topicType");
		String phoneticSymbol = req.getParameter("phoneticSymbol");
		String refText = req.getParameter("refText");
		
		
		if(StringUtil.isBlank(studentId) 
				|| StringUtil.isBlank(lessonId) 
				|| StringUtil.isBlank(classId) 
				|| StringUtil.isBlank(paperId) 
				|| StringUtil.isBlank(version) 
				|| StringUtil.isBlank(answer) 
				|| StringUtil.isBlank(topicId) 
				|| StringUtil.isBlank(questionIndex) 
				|| StringUtil.isBlank(corrected) 
				|| StringUtil.isBlank(chiShengParams) 
				|| StringUtil.isBlank(topicType) 
				|| StringUtil.isBlank(refText)) {
			out.append(CommentUtil.respError("参数异常"));
		}else {
			System.out.println("studentId:" + studentId);
			System.out.println("lessonId:" + lessonId);
			System.out.println("classId:" + classId);
			System.out.println("paperId:" + paperId);
			System.out.println("version:" + version);
			System.out.println("answer:" + answer);
			System.out.println("topicId:" + topicId);
			System.out.println("questionIndex:" + questionIndex);
			System.out.println("corrected:" + corrected);
			System.out.println("chiShengParams:" + chiShengParams);
			System.out.println("topicType:" + topicType);
			System.out.println("phoneticSymbol:" + phoneticSymbol);
			System.out.println("refText:" + refText);
			SubmitEnglishStudentHomewrokDataBean mSubmitEnglishStudentHomewrokDataBean = new SubmitEnglishStudentHomewrokDataBean();
			mSubmitEnglishStudentHomewrokDataBean.setAnswerResult(score[new Random().nextInt(score.length)]);
			mSubmitEnglishStudentHomewrokDataBean.setStudentAnswerParsing(music[new Random().nextInt(music.length)]);
			mSubmitEnglishStudentHomewrokDataBean.setSmashingEgg(0);
			mSubmitEnglishStudentHomewrokDataBean.setGold(10);
			mSubmitEnglishStudentHomewrokDataBean.setScore(20);
			ArrayList<EnglishVoiceStudentEnglishHomeworkResultsBean> mEnglishVoiceStudentEnglishHomeworkResultsBeans = new ArrayList<EnglishVoiceStudentEnglishHomeworkResultsBean>();
			
			if(Integer.parseInt(topicType) == work) {
				for(int j = 0 ; j < contentYinChar.length ; j ++) {
					EnglishVoiceStudentEnglishHomeworkResultsBean mEnglishVoiceStudentEnglishHomeworkResultsBean = new EnglishVoiceStudentEnglishHomeworkResultsBean();
					mEnglishVoiceStudentEnglishHomeworkResultsBean.setCharResult(score[new Random().nextInt(score.length)]);
					mEnglishVoiceStudentEnglishHomeworkResultsBean.setEnglishChar(contentYinChar[j]);
					mEnglishVoiceStudentEnglishHomeworkResultsBeans.add(mEnglishVoiceStudentEnglishHomeworkResultsBean);
				}
			}else if (Integer.parseInt(topicType) == sent) {
				for(int j = 0 ; j < contentSentChar.length ; j ++) {
					EnglishVoiceStudentEnglishHomeworkResultsBean mEnglishVoiceStudentEnglishHomeworkResultsBean = new EnglishVoiceStudentEnglishHomeworkResultsBean();
					mEnglishVoiceStudentEnglishHomeworkResultsBean.setCharResult(score[new Random().nextInt(score.length)]);
					mEnglishVoiceStudentEnglishHomeworkResultsBean.setEnglishChar(contentSentChar[j]);
					mEnglishVoiceStudentEnglishHomeworkResultsBeans.add(mEnglishVoiceStudentEnglishHomeworkResultsBean);
				}
			}
			
			
			mSubmitEnglishStudentHomewrokDataBean.setStudentEnglishHomeworkResults(mEnglishVoiceStudentEnglishHomeworkResultsBeans);
			out.append(CommentUtil.respSuccess(mSubmitEnglishStudentHomewrokDataBean));
		}
		out.flush();
        out.close();
	}
}
