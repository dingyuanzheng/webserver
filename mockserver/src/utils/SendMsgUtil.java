package utils;

import com.alibaba.fastjson.JSONObject;

public class SendMsgUtil {

	public static String url = "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=";
	
	/**
	 * 发送普通文本
	 * @param key
	 * @param content
	 * @return
	 */
	public static String sendText(String key , String content) {
		String newUrl = url + key;
		JSONObject json = new JSONObject();
		json.put("msgtype", "text");
		JSONObject contentJson = new JSONObject();
		contentJson.put("content", content);
		json.put("text", contentJson);
		System.out.println(json.toString());
		return HttpUtil.doPost(newUrl, json.toString());
	}
	
	/**
	 * 发送普通文本并且@人
	 * @param key
	 * @param content
	 * @param mentioned_list
	 * @return
	 */
	public static String sendText(String key , String content , String[] mentioned_list) {
		String newUrl = url + key;
		JSONObject json = new JSONObject();
		json.put("msgtype", "text");
		JSONObject contentJson = new JSONObject();
		contentJson.put("content", content);
		contentJson.put("mentioned_list" , mentioned_list);
		json.put("text", contentJson);
		System.out.println(json.toString());
		return HttpUtil.doPost(newUrl, json.toString());
	}
	
	/**
	 * 发送普通文本并且@人
	 * @param key
	 * @param content
	 * @param mentioned_list
	 * @param mentioned_mobile_list
	 * @return
	 */
	public static String sendText(String key , String content , String[] mentioned_list , String[] mentioned_mobile_list) {
		String newUrl = url + key;
		JSONObject json = new JSONObject();
		json.put("msgtype", "text");
		JSONObject contentJson = new JSONObject();
		contentJson.put("content", content);
		contentJson.put("mentioned_list" , mentioned_list);
		contentJson.put("mentioned_mobile_list" , mentioned_mobile_list);
		json.put("text", contentJson);
		System.out.println(json.toString());
		return HttpUtil.doPost(newUrl, json.toString());
	}
	
}
