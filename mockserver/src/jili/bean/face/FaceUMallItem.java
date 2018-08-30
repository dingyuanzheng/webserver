package jili.bean.face;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by test on 2018/5/29.
 */

public class FaceUMallItem implements Serializable {

	/** 某种类下的count **/
    private int myItemCount;

    /** id **/
    private String categoryId;

    /** 是否是默认 **/
    private String defaultCategory;

    /** 总数 **/
    private int itemCount;

    /** 编码 **/
    private String code;

    /** 序号 **/
    private int num;

    /** iconUrl **/
    private String iconUrl;
    
    /** iconUrl **/
    private String iconLightUrl;

    /** 道具列表 **/
    private ArrayList<FaceUMyItem> faceUMyItem;

    /** 备注 **/
    private String remark;

    public int getMyItemCount() {
        return myItemCount;
    }

    public void setMyItemCount(int myItemCount) {
        this.myItemCount = myItemCount;
    }

    public String getDefaultCategory() {
        return defaultCategory;
    }

    public void setDefaultCategory(String defaultCategory) {
        this.defaultCategory = defaultCategory;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public ArrayList<FaceUMyItem> getFaceUMyItem() {
        return faceUMyItem;
    }

    public void setFaceUMyItem(ArrayList<FaceUMyItem> faceUMyItem) {
        this.faceUMyItem = faceUMyItem;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getiD() {
        return categoryId;
    }

    public void setiD(String categoryId) {
        this.categoryId = categoryId;
    }
    
    public String getIconUrlPress() {
        return iconLightUrl;
    }

    public void setIconUrlPress(String iconLightUrl) {
        this.iconLightUrl = iconLightUrl;
    }
}
