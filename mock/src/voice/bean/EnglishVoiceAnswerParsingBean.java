package voice.bean;

import java.io.Serializable;

/**
 * 语音答案
 * Created by test on 2018/7/9.
 */
public class EnglishVoiceAnswerParsingBean implements Serializable {

    private String option;

    private String contentHtml;

    private String contentText;

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
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
}
