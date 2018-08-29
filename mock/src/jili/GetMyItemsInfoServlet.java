package jili;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jili.bean.face.FaceUMallItem;
import jili.bean.face.FaceUMallResponse;
import jili.bean.face.FaceUMyFaceBean;
import jili.bean.face.FaceUMyItem;
import jili.bean.face.FaceUMyItemBean;
import utils.CommentUtil;
import utils.Word;

/**
 * 学生拥有的道具
 * @author test
 *
 */
public class GetMyItemsInfoServlet extends HttpServlet {

	private String[] strUrl = new String[]{"http://192.168.3.197:8080/mock/images/tab1.png" 
			, "http://192.168.3.197:8080/mock/images/tab2.png" 
			, "http://192.168.3.197:8080/mock/images/tab3.png" 
			, "http://192.168.3.197:8080/mock/images/tab4.png" 
			, "http://192.168.3.197:8080/mock/images/tab5.png" 
			, "http://192.168.3.197:8080/mock/images/tab6.png"};
	
	private String[] strUrlPress = new String[]{"http://192.168.3.197:8080/mock/images/tab1_press.png" 
			, "http://192.168.3.197:8080/mock/images/tab2_press.png" 
			, "http://192.168.3.197:8080/mock/images/tab3_press.png" 
			, "http://192.168.3.197:8080/mock/images/tab4_press.png" 
			, "http://192.168.3.197:8080/mock/images/tab5_press.png" 
			, "http://192.168.3.197:8080/mock/images/tab6_press.png"};
	
	private String[] url = new String[]{"BG001.png" 
			, "BG002.png"
			, "E001.png"
			, "E002.png"
			, "GL001.png"
			, "HA001.png" 
			, "HS001.png" 
			, "HS002.png"
			, "MO001.png"
			, "NO001.png"};
	
	
	private String[] level = new String[]{"A" , "B" , "S"};
	private String[] levelName = new String[]{"稀有" , "精良" , "传说"};
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setHeader("Content-type", "text/json;charset=UTF-8");  
        PrintWriter out = resp.getWriter();
        
        System.out.println("请求来了getMyItemsInfo");
        
        FaceUMallResponse mFaceUMallResponse = new FaceUMallResponse();
        mFaceUMallResponse.setFaceUMyFaceImageUrl(null);
        FaceUMyFaceBean faceUMyFaceBean = new FaceUMyFaceBean();
        faceUMyFaceBean.setMyItem("123");
        mFaceUMallResponse.setFaceUMyFace(faceUMyFaceBean);
        
        ArrayList<FaceUMallItem> faceUMallItems = new ArrayList<FaceUMallItem>();
        for(int i = 0 ; i < 6 ; i ++){
            FaceUMallItem faceUMallItem = new FaceUMallItem();
            faceUMallItem.setMyItemCount(i + 10);
            faceUMallItem.setiD(i + "");
            faceUMallItem.setDefaultCategory(null);
            faceUMallItem.setItemCount(i + 15);
            faceUMallItem.setCode(null);
            faceUMallItem.setNum(i + 1);
            faceUMallItem.setIconUrl(strUrl[i]);
            faceUMallItem.setIconUrlPress(strUrlPress[i]);
            
            ArrayList<FaceUMyItem> faceUMyItems = new ArrayList<FaceUMyItem>();
            for(int j = 0 ; j < i + 10 ; j ++){
                FaceUMyItem faceUMyItem = new FaceUMyItem();
                faceUMyItem.setCount(j);
                faceUMyItem.setCountStr(j == 0 ? "未召唤" : "已经召唤：" + j + "次");
                faceUMyItem.setToBeUsed(j % 3);
                faceUMyItem.setLevelSort(j + 1);
                faceUMyItem.setiD(j + 1);
                faceUMyItem.setName(Word.getInstance().randomWord(5));
                faceUMyItem.setCode(url[j % 10]);
                faceUMyItem.setLevel(level[j % 3]);
                faceUMyItem.setLevelName(j % 3);
                faceUMyItem.setCategory("种类" + i);
                faceUMyItem.setDescription(Word.getInstance().randomWord(20 * (j + 1)));
                faceUMyItem.setSex(0);
                faceUMyItem.setSubstituteCode("代替编码");
                faceUMyItem.setDefaultDress(1);
                faceUMyItem.setCancelDress(0);
                faceUMyItem.setUrl(url[j % 10]);
                faceUMyItem.setVersion("1.0");
                faceUMyItem.setRate(10);
                faceUMyItems.add(faceUMyItem);
            }
            faceUMallItem.setFaceUMyItem(faceUMyItems);
            faceUMallItem.setRemark(Word.getInstance().randomWord(5));
            faceUMallItems.add(faceUMallItem);
        }
        mFaceUMallResponse.setFaceUMyItemCategory(faceUMallItems);
        out.append(CommentUtil.respSuccess(mFaceUMallResponse));
        out.flush();
        out.close();
	}
}
