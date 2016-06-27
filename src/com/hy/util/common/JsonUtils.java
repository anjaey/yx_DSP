package com.hy.util.common;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

@Component
@Scope("singleton")
public class JsonUtils {

	private static Gson gson = new Gson();

	public static String toJson(Object o) {
		return gson.toJson(o);
	}
	

	public static <T> T fromJson(String jsonStr, Class<T> t) {
		return gson.fromJson(jsonStr, t);
	}

	public static void main(String[] params) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 3);
		System.out.println(toJsonString(map));
	}

	public static <T> ArrayList toArrayList(String json, Type typeOfT) {
		return (ArrayList) new Gson().fromJson(json, typeOfT);
	}

	public static <T> T toType(String json, Type typeOfT) {
		try {
			return new Gson().fromJson(json, typeOfT);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String toJsonString(Object src) {
		return new Gson().toJson(src);
	}

	public static Map toMap(String json) {
		return new Gson().fromJson(json, Map.class);
	}

	public static <T> T toObject(String json, Class<T> classOfT) {
		return new Gson().fromJson(json, classOfT);
	}

	public static <T> T toObjectNoExp(String json, Class<T> classOfT) {
		try {
			return toObject(json, classOfT);
		} catch (Exception localException) {
			localException.printStackTrace();
		}
		return null;
	}

}
