package voice.bean;

import java.io.Serializable;

/**
 * 每个音标的结果状态
 * Created by test on 2018/7/9.
 */
public class EnglishVoiceStudentEnglishHomeworkResultsBean implements Serializable {

    /** 结果（0.优，1.良，2.中，3.差） **/
    private int charResult;

    /** 每个单词或音标 **/
    private String englishChar;

    /** 下标 **/
    private int index;

    public int getCharResult() {
        return charResult;
    }

    public void setCharResult(int charResult) {
        this.charResult = charResult;
    }

    public String getEnglishChar() {
        return englishChar;
    }

    public void setEnglishChar(String englishChar) {
        this.englishChar = englishChar;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
