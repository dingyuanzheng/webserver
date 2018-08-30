package utils;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.google.gson.JsonObject;

import bean.BaseBean;

public class CommentUtil {

	/**
	 * 回复成功请求
	 * @param obj
	 * @return
	 */
	public static String respSuccess(Object obj){
		HashMap<Object , Object> linkHashMap = new HashMap<Object , Object>();
		linkHashMap.put("errorCode", "");
		linkHashMap.put("message", "");
		linkHashMap.put("status", 1);
		linkHashMap.put("data", obj);
		return Analyze.analyzeToJson(linkHashMap);
	}
	
	/**
	 * 回复失败请求
	 * @param obj
	 * @return
	 */
	public static String respError(String message){
		HashMap<Object , Object> linkHashMap = new HashMap<Object , Object>();
		linkHashMap.put("errorCode", "400");
		linkHashMap.put("message", message);
		linkHashMap.put("status", 0);
		linkHashMap.put("data", null);
		return Analyze.analyzeToJson(linkHashMap);
	}
	
	/**
	 * 回复成功请求
	 * @param obj
	 * @return
	 */
	public static String respSuccessTeacher(Object obj){
		HashMap<Object , Object> linkHashMap = new HashMap<Object , Object>();
		linkHashMap.put("errorCode", 1);
		linkHashMap.put("errorMessage", "查询成功");
		linkHashMap.put("status", 1);
		linkHashMap.put("body", obj);
		return Analyze.analyzeToJson(linkHashMap);
	}
	
	/**
	 * 回复失败请求
	 * @param obj
	 * @return
	 */
	public static String respErrorTeacher(String message){
		HashMap<Object , Object> linkHashMap = new HashMap<Object , Object>();
		linkHashMap.put("errorCode", -1);
		linkHashMap.put("errorMessage", message);
		linkHashMap.put("status", 0);
		linkHashMap.put("body", null);
		return Analyze.analyzeToJson(linkHashMap);
	}
}
