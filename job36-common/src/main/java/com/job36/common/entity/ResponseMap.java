package com.job36.common.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回对象
 * @author dengzw
 * 2019-9-30 上午10:40:13
 *
 */
public class ResponseMap {
	private static final String SUCCESS = "200";
	private static final String ERROR = "500";
	
	private String code;//code ==0 成功；非0：失败
	private String msg;//返回描述
	private Map<String,Object> data;//返回map对象，对于app接口来说比较方便新增返回字段
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	
	/**
	 * 成功
	 * @author dengzw
	 * 2016-11-23 上午10:47:26
	 */
	public ResponseMap success(){
		this.code = SUCCESS;
		this.msg = "请求成功！";
		
		return this;
	}
	public ResponseMap success(String key,Object value){
		success();
		this.put(key, value);
		
		return this;
	}
	/**
	 * 成功
	 * @param msg
	 */
	public ResponseMap success(String msg){
		success();
		this.msg = msg;
		
		return this;
	}
	/**
	 * 成功
	 * @param msg
	 * @author dengzw
	 * 2017-8-17 上午10:42:30
	 */
	public ResponseMap success(String msg,String key,Object value){
		success();
		this.msg = msg;
		
		
		this.put(key, value);
		
		return this;
	}
	/**
	 * 失败
	 * @author dengzw
	 * 2016-11-23 上午10:47:36
	 */
	public ResponseMap failure(){
		this.code = ERROR;
		this.msg = "请求失败！";
		
		return this;
	}
	public ResponseMap failure(String msg){
		failure();
		this.msg = msg;
		
		return this;
	}
	/**
	 * 判断结果是否成功
	 * @return
	 * @author dengzw
	 * 2017-7-10 上午10:42:42
	 */
	public boolean isSuccess(){
		return null != this.code && SUCCESS.equals(this.code);
	}
	/**
	 * 判断结果是否失败
	 * @return
	 * @author dengzw
	 * 2017-7-10 上午10:43:24
	 */
	public boolean isFaliure(){
		return !isSuccess();
	}
	
	/**
	 * 赋值到data
	 * @param key
	 * @param value
	 * @author dengzw
	 * 2019-9-30 上午10:35:33
	 */
	public void put(String key,Object value){
		if(null == this.data){
			this.data = new HashMap<String,Object>();
		}
		this.data.put(key, value);
	}
	
}
