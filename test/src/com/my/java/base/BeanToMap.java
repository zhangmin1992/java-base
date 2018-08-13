package com.my.java.base;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * java对象和map的相互转换
 * @author yp-tc-m-7129
 *
 */
public class BeanToMap {

	/**
	 * 实体转map
	 * 需要引用两个jar包：commons-beanutils-1.9.2.jar   commons-logging-1.2.jar
	 * @param obj
	 * @return
	 */
	public static HashMap<String, Object> beanToMap(Object obj) { 
    	HashMap<String, Object> params = new HashMap<String, Object>(0); 
            try { 
                BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());    
                PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();    
                for (PropertyDescriptor property : propertyDescriptors) {    
                    String key = property.getName();    
                    if (key.compareToIgnoreCase("class") == 0) {   
                        continue;  
                    }
                    Method getter = property.getReadMethod();  
                    Object value = getter!=null ? getter.invoke(obj) : null;  
                    params.put(key, value);  
                }    
          
                return params;
            } catch (Exception e) { 
                e.printStackTrace(); 
            } 
            return params; 
    }
	
	public static HashMap<String,Object> beanToMap2(Object obj) {
		HashMap<String, Object> map = new HashMap<>();
		return null;
	}
	
	/**
	 * map转实体
	 * @param map
	 * @param beanClass
	 * @return
	 * @throws Exception
	 */
	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {    
        if (map == null)   
            return null;    
        Object obj = beanClass.newInstance();  
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());    
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();    
        for (PropertyDescriptor property : propertyDescriptors) {  
            Method setter = property.getWriteMethod();    
            if (setter != null) {  
                setter.invoke(obj, map.get(property.getName()));   
            }  
        }  
        return obj;  
    }    
	
	/**
	 * map转list，只取值
	 * @param obj
	 * @return
	 */
	public static ArrayList ConvertObjToList(Object obj) {
		if(obj == null) {
			return null;
		}
		ArrayList<String> list = new ArrayList<String>();
		Field[] fields = obj.getClass().getDeclaredFields();
		try {
			for (int i = 0; i < fields.length; i++) {
				try {
					Field f = obj.getClass().getDeclaredField(fields[i].getName());
					f.setAccessible(true);
					Object o = f.get(obj);
					list.add(o.toString());
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) throws Exception {
		/*ArrayList<String> list = new ArrayList<String>();
		TestModel testmodel = new TestModel("zhangmin","nv",18);
		list = ConvertObjToList(testmodel);
		System.out.println(list);*/
		
		TestModel testmodel = new TestModel();
		testmodel.setAge(11);
		testmodel.setCourse("cc");
		testmodel.setName("name");
		Map<String, Object> map = new HashMap<String, Object>();
		map = beanToMap(testmodel);
		System.out.println(map);
		
		TestModel beanModel = (TestModel) mapToObject(map, TestModel.class);
		System.out.println(JSONObject.toJSONString(beanModel));
	}

}
class TestModel{
	public String name;
	public String course;
	public int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public TestModel() {
		
	}
	public TestModel(String name, String course, int age) {
		super();
		this.name = name;
		this.course = course;
		this.age = age;
	}
	
}
