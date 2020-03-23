package com.basics.common.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @CreateDate: 2020-03-23 16:22
 * @Version: 1.0
 * @Description: Gson 转化
 * @Author: xueshijie
 */
public class GsonUtils {

    /**
     * json转换成对象
     *
     * @param json  json数据
     * @param clazz 对象
     * @return 转换的对象
     */
    public static <T> T jsonToEntity(String json, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(json, clazz);
    }

    /**
     * JsonArray转换为List数据
     *
     * @param json  json数据
     * @param clazz 对象
     * @return 列表对象
     */
    public static <T> List<T> jsonToList(String json, Class<T> clazz) {
        Type type = new TypeToken<List<JsonObject>>() {
        }.getType();
        List<JsonObject> jsonObjects = new Gson().fromJson(json, type);
        List<T> arrayList = new ArrayList<>();
        for (JsonObject jsonObject : jsonObjects) {
            arrayList.add(new Gson().fromJson(jsonObject, clazz));
        }
        return arrayList;
    }

    /**
     * 对象转换成JSON类型
     *
     * @param bean 对象
     * @return json数据
     */
    public static String objToJson(Object bean) {
        Gson gson = new Gson();
        return gson.toJson(bean);
    }

    /**
     * 实体类转map
     * @param obj
     * @return
     */
    public static Map<String, Object> beanToMap(Object obj) {
        Map<String, Object> map = new HashMap<>();
        if (obj == null) {
            return map;
        }
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(obj));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * List 转 String字符串
     * @param list
     * @param separator
     * @return
     */
    public static String listToString(List list, char separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }

    public static List<String> toStringJson(String json,Class cls){
        TypeToken<?> array = TypeToken.getArray(cls);
        Gson gson = new Gson();
        List<String> objects = gson.fromJson(json, array.getType());
        return objects;
    }


//     okhttp 转化成body 对象
//    public static RequestBody mapToJson(Map map) {
//        Gson gson = new Gson();
//        String json = gson.toJson(map);
//        RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), json);
//        return requestBody;
//    }
//
//    public static RequestBody beanToJson(Object bean) {
//        Gson gson = new Gson();
//        String json = gson.toJson(bean);
//        RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), json);
//        return requestBody;
//    }
//
//    public static RequestBody strToBody(String str) {
//        RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), str);
//        return requestBody;
//    }
//
//    public static RequestBody listToBody(List<String> list) {
//        RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), list.toString());
//        return requestBody;
//    }
}
