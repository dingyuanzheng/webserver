package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 * Created by dingyz on 2017/3/14.
 */
public class Analyze {
    /**
     * 将json数据解析成为一个对象
     * @param json
     * @param cla
     * @return
     */
    public static <T> T analyzeJson(String json , Class<T> cla){
        Gson mGson = new Gson();
        return mGson.fromJson(json, cla);
    }
    /**
     * 将对象生成一个字符串
     * @param cla
     * @return
     */
    public static String analyzeToJson(Object cla){
        Gson mGson = new Gson();
        return mGson.toJson(cla);
    }

    /**
     * 将生成对象
     * @return
     */
    public static <T> T analyzeToObject(String responseStr , Type objectType){
        Gson mGson = new Gson();
        return mGson.fromJson(
                responseStr, objectType);
    }

    public static String toJsonWithExpose(Object src){
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(src);
    }
}
