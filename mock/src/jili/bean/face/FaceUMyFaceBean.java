package jili.bean.face;

import java.io.Serializable;

/**
 * Created by test on 2018/5/29.
 */

public class FaceUMyFaceBean implements Serializable {

	/**  已经装备的item **/
    private String myItem;

    public String getMyItem() {
        return myItem;
    }

    public void setMyItem(String myItem) {
        this.myItem = myItem;
    }
}
