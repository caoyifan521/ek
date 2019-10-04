package com.qfedu.ek.utils;


import com.qfedu.ek.common.JsonResult;

public class JsonUtils {

	public static JsonResult createJsonResult(int code, Object info){
		JsonResult result = new JsonResult();
		result.setCode(code);
		result.setInfo(info);
		
		return result;
	}
}
