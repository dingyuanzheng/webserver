package voice.bean;

import java.io.Serializable;


/**
 * 每道题订正提交按钮
 * Created by test on 2018/7/18.
 */
public class RevisingSubmitBean implements Serializable {

    /** true是已经点击过，false没有点击 **/
    private int correctSubmit;

    public int isCorrectSubmit() {
        return correctSubmit;
    }

    public void setCorrectSubmit(int correctSubmit) {
        this.correctSubmit = correctSubmit;
    }
}
