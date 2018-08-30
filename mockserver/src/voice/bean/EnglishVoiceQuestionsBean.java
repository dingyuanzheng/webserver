package voice.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by test on 2018/7/9.
 */

public class EnglishVoiceQuestionsBean implements Serializable {

    /** 题干 html **/
    private String contentHtml;

    /** 题干 text **/
    private String contentText;

    /** 题ID **/
    private int topicId;

    /** 类型(8单词 9短句 10段落) **/
    private int topicType;

    /** 题下标 **/
    private int questionsIndex;

    /** 题下标 **/
    private String questionsIndexString;
    

    /** 是否提交(0:没有，1:有) **/
    private int submitStatus;

    /** 答题结果（0:优，1:良，2:中，3:差）**/
    private int answerResult;

    /** 是否是订正(0:不是，1:是) **/
    private int corrected;
    
    /** 是否点击订正提交按钮（0点击过， 1没有点击） **/
    private int correctSubmit;

    /** 静态化路径 **/
    private String staticUrl;

    /** 学生答案 **/
    private String studentAnswerParsing;

    /** 音标 **/
    private String phoneticSymbol;

    /** 语音答案 **/
    private ArrayList<EnglishVoiceAnswerParsingBean> answerParsing;

    /** 每个音标的结果状态 **/
    private ArrayList<EnglishVoiceStudentEnglishHomeworkResultsBean> studentEnglishHomeworkResults;

    public String getQuestionsIndexString() {
        return questionsIndexString;
    }

    public void setQuestionsIndexString(String questionsIndexString) {
        this.questionsIndexString = questionsIndexString;
    }
    
    public int getCorrectSubmit() {
        return correctSubmit;
    }

    public void setCorrectSubmit(int correctSubmit) {
        this.correctSubmit = correctSubmit;
    }
    
    public String getContentHtml() {
        return contentHtml;
    }

    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public int getTopicType() {
        return topicType;
    }

    public void setTopicType(int topicType) {
        this.topicType = topicType;
    }

    public int getQuestionsIndex() {
        return questionsIndex;
    }

    public void setQuestionsIndex(int questionsIndex) {
        this.questionsIndex = questionsIndex;
    }

    public int getSubmitStatus() {
        return submitStatus;
    }

    public void setSubmitStatus(int submitStatus) {
        this.submitStatus = submitStatus;
    }

    public int getAnswerResult() {
        return answerResult;
    }

    public void setAnswerResult(int answerResult) {
        this.answerResult = answerResult;
    }

    public int getCorrected() {
        return corrected;
    }

    public void setCorrected(int corrected) {
        this.corrected = corrected;
    }

    public String getStaticUrl() {
        return staticUrl;
    }

    public void setStaticUrl(String staticUrl) {
        this.staticUrl = staticUrl;
    }

    public String getStudentAnswerParsing() {
        return studentAnswerParsing;
    }

    public void setStudentAnswerParsing(String studentAnswerParsing) {
        this.studentAnswerParsing = studentAnswerParsing;
    }

    public String getPhoneticSymbol() {
        return phoneticSymbol;
    }

    public void setPhoneticSymbol(String phoneticSymbol) {
        this.phoneticSymbol = phoneticSymbol;
    }

    public ArrayList<EnglishVoiceAnswerParsingBean> getAnswerParsing() {
        return answerParsing;
    }

    public void setAnswerParsing(ArrayList<EnglishVoiceAnswerParsingBean> answerParsing) {
        this.answerParsing = answerParsing;
    }

    public ArrayList<EnglishVoiceStudentEnglishHomeworkResultsBean> getStudentEnglishHomeworkResults() {
        return studentEnglishHomeworkResults;
    }

    public void setStudentEnglishHomeworkResults(ArrayList<EnglishVoiceStudentEnglishHomeworkResultsBean> studentEnglishHomeworkResults) {
        this.studentEnglishHomeworkResults = studentEnglishHomeworkResults;
    }
}
