package com.my.java.util.transfer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.formula.functions.T;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.my.java.util.tuofeng.CustomWrapper;
import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * 1。java环境的话需要的包：
 *    dozer-5.5.1.jar
 *    slf4j-api-1.7.5.jar
 *    commons-lang3-3.9.jar
 *    commons-logging-1.2.jar
 *    commons-beanutils-1.9.1.jar
 *    
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Sep 24, 2019 4:22:02 PM
 */
public class DozerUtil {

	private static Mapper mapper = new DozerBeanMapper();
	 
    public static <T> List<T> transforList(List<?> sources, Class<T> clazz) {
        List<T> list = new ArrayList<>();
        if (sources == null) {
            return list;
        }
        for (Object o : sources) {
            T t = transfor(o, clazz);
            list.add(t);
        }
        return list;
    }
 
    public static void transfor(Object source, Object target) {
        if (source == null || target == null) {
            return;
        }
        mapper.map(source, target);
    }
 
    public static <T> T transfor(Object source, Class<T> target) {
        if (source == null) {
            return null;
        }
        return mapper.map(source, target);
    }
    
    public static <T> T JSONObjectToModel(JSONObject jSONObject,Class<T> clz,boolean isWrapper){
    	Object target = null;
		try {
			target = clz.newInstance();
			Field[] fields = target.getClass().getDeclaredFields();
			for (Field field : fields) {
				//设置可见性
				field.setAccessible(true);
				// 获取属性名
				String fieldName = field.getName();
				// 根据属性名称获取setter/getter方法名,myChineseName 对应的方法只需要set+m大写+尾部即可
				String set = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				// 根据方法名称获取方法对象，getMethod的参数是方法名称，方法形参
				Method method_set = clz.getMethod(set, field.getType());
				// 执行源对象的get方法，获取返回值
				Object returnVal = null;
				//是否需要下划线转驼峰
				if(isWrapper) {
					fieldName = CustomWrapper.underlineToCamelhump(fieldName);
				}
				//根据jsonobject的参数类型获取值
				if(field.getType().equals(java.lang.String.class)) {
					returnVal = jSONObject.getString(fieldName);
				}else if(field.getType().equals(java.lang.Long.class)) {
					returnVal = jSONObject.getLong(fieldName);
				}else if(field.getType().equals(java.lang.Double.class)) {
					returnVal = jSONObject.getDouble(fieldName);
				}else if(field.getType().equals(java.lang.Float.class)) {
					returnVal = jSONObject.getFloat(fieldName);
				}
				if(returnVal != null) {
					method_set.invoke(target, returnVal);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T) target;
	}
 
	
    public static void main(String[] args) {
    	//{"thirdPartyTradeNo":"4200000388201907170437541444","totalFee":"444","successTime":"1564565985000","status":"2"}
    	//1.map转java实体
    	Map<String, String> receiverData = new HashMap<String, String>();
    	receiverData.put("thirdPartyTradeNo", "4200000388201907170437541444");
    	receiverData.put("totalFee", "444");
    	receiverData.put("successTime", "1564565985000");
    	receiverData.put("status", "2");
    	DiffDataModel result = DozerUtil.transfor(receiverData, DiffDataModel.class);
    	System.out.println(JSONObject.toJSONString(result));
    	
    	//2.model实体转dto实体
    	DiffDataDTO diffDataDTO = DozerUtil.transfor(result, DiffDataDTO.class);
    	System.out.println(JSONObject.toJSONString(diffDataDTO));
    	
    	//3.json字符串转java对象方式一：适用于没有下划线
    	String str = "{\"thirdPartyTradeNo\":\"4200000388201907170437541444\",\"totalFee\":\"444\",\"successTime\":\"1564565985000\",\"status\":\"2\"}";
    	DiffDataModel diffDataModel = JSONObject.parseObject(str, DiffDataModel.class);
    	System.out.println(JSONObject.toJSONString(diffDataModel));
    	
    	//4.json字符串转java对象方式二：适用于有下划线
    	str = "{\"third_party_tradeNo\":\"4200000388201907170437541444\",\"total_fee\":\"444\",\"success_time\":\"1564565985000\",\"status\":\"2\"}";
    	JSONObject jSONObject = JSON.parseObject(str);
    	DiffDataModel diffDataModel2 = JSONObjectToModel(jSONObject,DiffDataModel.class,true);
    	System.out.println(JSONObject.toJSONString(diffDataModel2));
    	
//    	Map maps = (Map)JSON.parse("{\"thirdPartyTradeNo\":\"4200000388201907170437541444\",\"totalFee\":\"444\",\"successTime\":\"1564565985000\",\"status\":\"2\"}"); 
//    	System.out.println(JSONObject.toJSONString(maps));
	}
}
