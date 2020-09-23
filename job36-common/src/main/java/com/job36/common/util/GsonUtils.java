package com.job36.common.util;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

/**
 * gson json转换工具类
 * @author dengzw
 * 2017-4-19 下午6:23:16
 *
 */
public class GsonUtils {

	/**
	 * 将对象转换为json数据(必须带有注解 @Expose 才可以转换)
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(obj);
	}
	
	/**
	 * 将对象转换为json数据,无需带注解就可以转换
	 * @param obj
	 * @return
	 */
	public static String toJsonAll(Object obj) {
		return new Gson().toJson(obj);
	}
	
	/***
	 * 对象转换
	 * @param list
	 * @return
	 */
	public static String getJsonData(List<?> list) {
	    Gson gson = new Gson();
	    String jsonstring = gson.toJson(list);
	    return jsonstring;
	}
	
	/**
	 * json字符串转bean对象
	 * @param json 
	 * @param beanClass 目标类型
	 * @return
	 * @author dengzw
	 * 2017-6-22 下午3:52:03
	 * @param <T>
	 */
	public static <T> T jsonToBean(String json,Class<T> beanClass) {
		Gson gson = new Gson();
		T res = gson.fromJson(json, beanClass);
		return res;
	}
	
	/**
     * json字符串转成List对象
     * @param json
     * @param clazz bean类型
     * @return
     * @author dengzw
     * 2017-7-20 下午1:37:15
     */
    public static <T> ArrayList<T> jsonToArrayList(String json, Class<T> clazz){
        Type type = new TypeToken<ArrayList<JsonObject>>(){}.getType();
        ArrayList<JsonObject> jsonObjects = new Gson().fromJson(json, type);

        ArrayList<T> arrayList = new ArrayList<T>();
        for (JsonObject jsonObject : jsonObjects){
            arrayList.add(new Gson().fromJson(jsonObject, clazz));
        }
        return arrayList;
    }
    

}
