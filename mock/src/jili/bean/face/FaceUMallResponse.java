package jili.bean.face;

import java.util.ArrayList;

/**
 * Created by test on 2018/5/29.
 */
public class FaceUMallResponse{

	/**  自己的形象 **/
    private FaceUMyFaceBean faceUMyFace;

    /**  形象图片url **/
    private String faceUMyFaceImageUrl;

    /**  自己拥有的道具 **/
    private ArrayList<FaceUMallItem> faceUMyItemCategory;

    public FaceUMyFaceBean getFaceUMyFace() {
        return faceUMyFace;
    }

    public void setFaceUMyFace(FaceUMyFaceBean faceUMyFace) {
        this.faceUMyFace = faceUMyFace;
    }

    public String getFaceUMyFaceImageUrl() {
        return faceUMyFaceImageUrl;
    }

    public void setFaceUMyFaceImageUrl(String faceUMyFaceImageUrl) {
        this.faceUMyFaceImageUrl = faceUMyFaceImageUrl;
    }

    public ArrayList<FaceUMallItem> getFaceUMyItemCategory() {
        return faceUMyItemCategory;
    }

    public void setFaceUMyItemCategory(ArrayList<FaceUMallItem> faceUMyItemCategory) {
        this.faceUMyItemCategory = faceUMyItemCategory;
    }
}
