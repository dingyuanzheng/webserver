package voice.bean.submitenglishstudenthomewrok;

import java.io.Serializable;
import java.util.ArrayList;

import voice.bean.EnglishVoiceStudentEnglishHomeworkResultsBean;


/**
 * Created by test on 2018/7/10.
 */
public class SubmitEnglishStudentHomewrokDataBean implements Serializable {

    /** 是否需要砸蛋 **/
    private int smashingEgg;

    /** 答题结果 **/
    private int answerResult;

    /** 每个音标的结果状态 **/
    private ArrayList<EnglishVoiceStudentEnglishHomeworkResultsBean> studentEnglishHomeworkResults;
    
    /** 学生答案 **/
    private String studentAnswerParsing;
    
    /** 获得的积分 **/
    private int score;

    /** 获得的金币 **/
    private int gold;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
    
    public String getStudentAnswerParsing() {
        return studentAnswerParsing;
    }

    public void setStudentAnswerParsing(String studentAnswerParsing) {
        this.studentAnswerParsing = studentAnswerParsing;
    }
    

    public int isSmashingEgg() {
        return smashingEgg;
    }

    public void setSmashingEgg(int smashingEgg) {
        this.smashingEgg = smashingEgg;
    }

    public int getAnswerResult() {
        return answerResult;
    }

    public void setAnswerResult(int answerResult) {
        this.answerResult = answerResult;
    }

    public ArrayList<EnglishVoiceStudentEnglishHomeworkResultsBean> getStudentEnglishHomeworkResults() {
        return studentEnglishHomeworkResults;
    }

    public void setStudentEnglishHomeworkResults(ArrayList<EnglishVoiceStudentEnglishHomeworkResultsBean> studentEnglishHomeworkResults) {
        this.studentEnglishHomeworkResults = studentEnglishHomeworkResults;
    }
}
