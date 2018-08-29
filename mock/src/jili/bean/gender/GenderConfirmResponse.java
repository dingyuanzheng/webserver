package jili.bean.gender;

import java.io.Serializable;

public class GenderConfirmResponse implements Serializable {
	/** true是弹窗去确认性别，false是不弹窗已经确认过性别 **/
    private boolean wheConfirmGender;

    public boolean getWheConfirmGender() {
        return wheConfirmGender;
    }

    public void setWheConfirmGender(boolean wheConfirmGender) {
        this.wheConfirmGender = wheConfirmGender;
    }
}
