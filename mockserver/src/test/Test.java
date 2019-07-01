package test;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.alibaba.fastjson.JSONObject;

import utils.HttpUtil;
import utils.MailUtils;
import utils.StringUtil;


public class Test {

	public static void main(String[] args) {
		System.out.println(StringUtil.getIp());
//		try {
//			MailUtils.sendMail("huangshan0@gaosiedu.com" , "apk打包成功了" , "放假had会计师过的痕迹开始干");
//		} catch (AddressException e) {
//			e.printStackTrace();
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
		
		
		
		String url = "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=";
		 url += "22354165-c0e0-40ab-8280-3fafe5da61a9";
		 JSONObject json = new JSONObject();
		 json.put("msgtype", "text");
		 JSONObject contentJson = new JSONObject();
		 contentJson.put("content", "学生端Android出新包了, 赶快去下载吧！\n下载地址：https://www.pgyer.com/xsd-android");
		 json.put("text", contentJson);
		 System.out.println(json.toString());
		 String postResult = HttpUtil.doPost(url, json.toString());
		 System.out.println(postResult);
	}
	
}
