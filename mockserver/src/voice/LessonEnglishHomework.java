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
import voice.bean.EnglishVoiceAnswerParsingBean;
import voice.bean.EnglishVoiceDataBean;
import voice.bean.EnglishVoiceQuestionsBean;
import voice.bean.EnglishVoiceStudentEnglishHomeworkResultsBean;

public class LessonEnglishHomework extends HttpServlet {
	
	private String[] contentText = new String[]{"extended" , "Hi, May I kiss you? Fuck. Fine you, And you, what are you doing? \n\r\n\r" +
			"Hi, May I kiss you? Fuck. Fine you, And you, what are you doing? \n\r\n\r" +
			"Hi, May I kiss you? Fuck. Fine you, And you, what are you doing? \n\r\n\r" +
			"Hi, May I kiss you? Fuck. Fine you, And you, what are you doing? \n\r\n\r" +
			"Hi, May I kiss you? Fuck. Fine you, And you, what are you doing? \n\r\n\r" +
			"Hi, May I kiss you? Fuck. Fine you, And you, what are you doing? \n\r\n\r" +
			"Hi, May I kiss you? Fuck. Fine you, And you, what are you doing? \n\r\n\r" +
			"Hi, May I kiss you? Fuck. Fine you, And you, what are you doing?"};
	private String[] contentYin = new String[]{"ɪkˈstendɪd"};
	private String[] contentYinChar = new String[]{"ɪk" , "s" , "t" , "en" , "d" , "ɪd"};
	
	private String[] contentSentChar = new String[]{"Hi" , "May" , "I" , "kiss" , "you" , "Fuck" , "Fine" , "you" , "And" , "you" , "what" , "are" , "you" , "doing" 
			, "Hi" , "May" , "I" , "kiss" , "you" , "Fuck" , "Fine" , "you" , "And" , "you" , "what" , "are" , "you" , "doing" 
			, "Hi" , "May" , "I" , "kiss" , "you" , "Fuck" , "Fine" , "you" , "And" , "you" , "what" , "are" , "you" , "doing" 
			, "Hi" , "May" , "I" , "kiss" , "you" , "Fuck" , "Fine" , "you" , "And" , "you" , "what" , "are" , "you" , "doing" 
			, "Hi" , "May" , "I" , "kiss" , "you" , "Fuck" , "Fine" , "you" , "And" , "you" , "what" , "are" , "you" , "doing" 
			, "Hi" , "May" , "I" , "kiss" , "you" , "Fuck" , "Fine" , "you" , "And" , "you" , "what" , "are" , "you" , "doing" 
			, "Hi" , "May" , "I" , "kiss" , "you" , "Fuck" , "Fine" , "you" , "And" , "you" , "what" , "are" , "you" , "doing" 
			, "Hi" , "May" , "I" , "kiss" , "you" , "Fuck" , "Fine" , "you" , "And" , "you" , "what" , "are" , "you" , "doing"};
	
	private int mQuestionsCount = 3;
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
        
        System.out.println("请求来了LessonEnglishHomework");
        
        
        String studentId = req.getParameter("studentId");
		String lessonId = req.getParameter("lessonId");
		String classId = req.getParameter("classId");
		String version = req.getParameter("version");
		if(StringUtil.isBlank(studentId) || StringUtil.isBlank(lessonId) || StringUtil.isBlank(classId)) {
			out.append(CommentUtil.respError("参数异常"));
		}else {
			EnglishVoiceDataBean mEnglishVoiceDataBean = makeEnglishVoiceDataBean(version);//制作语音作业
			ArrayList<EnglishVoiceQuestionsBean> mEnglishVoiceQuestionsBeans = new ArrayList<EnglishVoiceQuestionsBean>();
			for(int i = 0 ; i < mEnglishVoiceDataBean.getQuestionsCount() ;i ++) {
				mEnglishVoiceQuestionsBeans.add(makeEnglishVoiceQuestionsBean(i));//制作问题
			}
			mEnglishVoiceDataBean.setQuestions(mEnglishVoiceQuestionsBeans);
			out.append(CommentUtil.respSuccess(mEnglishVoiceDataBean));
		}
		out.flush();
        out.close();
	}
	
	/**
	 * 制作语音作业
	 * @param version
	 * @return
	 */
	private EnglishVoiceDataBean makeEnglishVoiceDataBean(String version) {
		EnglishVoiceDataBean mEnglishVoiceDataBean = new EnglishVoiceDataBean();
		mEnglishVoiceDataBean.setPaperId(12345678);
		mEnglishVoiceDataBean.setUploadToken("WR5JtPxdsdYOgladSBDXZl3idmqjBzqkX5E-UDfG:8BkoBBrSjtLbMrnLMZkWXVaDm4c=:eyJzY29wZSI6ImF4eC1xaXVyaWRlc2l5dSIsImRlYWRsaW5lIjoxNTMxODkxOTE0fQ==");
		mEnglishVoiceDataBean.setQuestionsCount(mQuestionsCount);
		mEnglishVoiceDataBean.setVersion(StringUtil.isBlank(version) ? "1.0.0" : version);
		mEnglishVoiceDataBean.setCommitLastOne(new Random().nextInt(2) == 1 ? 1 : 0);
		return mEnglishVoiceDataBean;
	}
	
	/**
	 * 制作问题
	 * @param i
	 * @return
	 */
	private EnglishVoiceQuestionsBean makeEnglishVoiceQuestionsBean(int i) {
		EnglishVoiceQuestionsBean mEnglishVoiceQuestionsBean = new EnglishVoiceQuestionsBean();
		
		
		mEnglishVoiceQuestionsBean.setTopicId(i);
		mEnglishVoiceQuestionsBean.setTopicType(i == 2 ? sent : work);
		mEnglishVoiceQuestionsBean.setQuestionsIndex(i + 1);
		mEnglishVoiceQuestionsBean.setQuestionsIndexString("俺" + (i + 1) + "题");
		mEnglishVoiceQuestionsBean.setSubmitStatus(i == 0 ? 1 : 0);
		mEnglishVoiceQuestionsBean.setAnswerResult(i == 0 ? score[new Random().nextInt(score.length)] : 100);
		//是否订正过
		mEnglishVoiceQuestionsBean.setCorrected(0);
		//是否可以订正
		mEnglishVoiceQuestionsBean.setCorrectSubmit(i == 0 ? (mEnglishVoiceQuestionsBean.getAnswerResult() == score[3] ? 1 : 0) : 1);
		
		mEnglishVoiceQuestionsBean.setStaticUrl("啦啦啦啦呀！啦啦啦，打不过我吧！就是这么强大，啦啦啦啦，啦啦啦，可欣你来了？");
		mEnglishVoiceQuestionsBean.setStudentAnswerParsing(i == 0 ? music[1] : "");
		
		//语音答案
		ArrayList<EnglishVoiceAnswerParsingBean> mEnglishVoiceAnswerParsingBeans = new ArrayList<EnglishVoiceAnswerParsingBean>();
		EnglishVoiceAnswerParsingBean mEnglishVoiceAnswerParsingBean = new EnglishVoiceAnswerParsingBean();
		if(mEnglishVoiceQuestionsBean.getTopicType() == sent) {
			mEnglishVoiceQuestionsBean.setContentHtml("<html>"+ contentText[1] +"</html>");
			mEnglishVoiceQuestionsBean.setContentText(contentText[1]);
			mEnglishVoiceQuestionsBean.setPhoneticSymbol("");
			
			mEnglishVoiceAnswerParsingBean.setContentHtml("<html>"+ music[new Random().nextInt(mQuestionsCount)] +"</html>");
			mEnglishVoiceAnswerParsingBean.setContentText(music[0]);
			mEnglishVoiceAnswerParsingBean.setOption("option");
		}else if(mEnglishVoiceQuestionsBean.getTopicType() == work) {
			mEnglishVoiceQuestionsBean.setContentHtml("<html>"+ contentText[0] +"</html>");
			mEnglishVoiceQuestionsBean.setContentText(contentText[0]);
			mEnglishVoiceQuestionsBean.setPhoneticSymbol(contentYin[0]);
			
			mEnglishVoiceAnswerParsingBean.setContentHtml("<html>"+ music[new Random().nextInt(mQuestionsCount)] +"</html>");
			mEnglishVoiceAnswerParsingBean.setContentText(music[0]);
			mEnglishVoiceAnswerParsingBean.setOption("option");
		}
		mEnglishVoiceAnswerParsingBeans.add(mEnglishVoiceAnswerParsingBean);
		mEnglishVoiceQuestionsBean.setAnswerParsing(mEnglishVoiceAnswerParsingBeans);
		
		//每个音标的结果状态
		ArrayList<EnglishVoiceStudentEnglishHomeworkResultsBean> mEnglishVoiceStudentEnglishHomeworkResultsBeans = new ArrayList<EnglishVoiceStudentEnglishHomeworkResultsBean>();
		if(mEnglishVoiceQuestionsBean.getTopicType() == work) {
			if(i == 0) {
				for(int j = 0 ; j < contentYinChar.length ; j ++) {
					EnglishVoiceStudentEnglishHomeworkResultsBean mEnglishVoiceStudentEnglishHomeworkResultsBean = new EnglishVoiceStudentEnglishHomeworkResultsBean();
					mEnglishVoiceStudentEnglishHomeworkResultsBean.setCharResult(score[new Random().nextInt(score.length)]);
					mEnglishVoiceStudentEnglishHomeworkResultsBean.setEnglishChar(contentYinChar[j]);
					mEnglishVoiceStudentEnglishHomeworkResultsBeans.add(mEnglishVoiceStudentEnglishHomeworkResultsBean);
				}
			}
		}else if(mEnglishVoiceQuestionsBean.getTopicType() == sent) {
		}
		mEnglishVoiceQuestionsBean.setStudentEnglishHomeworkResults(mEnglishVoiceStudentEnglishHomeworkResultsBeans);
		return mEnglishVoiceQuestionsBean;
	}
}
