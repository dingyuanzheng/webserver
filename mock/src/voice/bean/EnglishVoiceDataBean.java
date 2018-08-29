package voice.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by test on 2018/7/9.
 */

public class EnglishVoiceDataBean implements Serializable {

    /** 作业Id **/
    private int paperId;

    /** 题数量 **/
    private int questionsCount;

    /** 版本 **/
    private String version;

    /** 问题 **/
    private ArrayList<EnglishVoiceQuestionsBean> questions;

    /** 七牛上传token **/
    private String uploadToken;
    
    /** 是否点击过提交(0:false没有点击过，1:true点击过) **/
    private int commitLastOne;

    public int isCommitLastOne() {
        return commitLastOne;
    }

    public void setCommitLastOne(int commitLastOne) {
        this.commitLastOne = commitLastOne;
    }
    
    public String getUploadToken() {
        return uploadToken;
    }

    public void setUploadToken(String uploadToken) {
        this.uploadToken = uploadToken;
    }
    
    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public int getQuestionsCount() {
        return questionsCount;
    }

    public void setQuestionsCount(int questionsCount) {
        this.questionsCount = questionsCount;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public ArrayList<EnglishVoiceQuestionsBean> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<EnglishVoiceQuestionsBean> questions) {
        this.questions = questions;
    }
}
