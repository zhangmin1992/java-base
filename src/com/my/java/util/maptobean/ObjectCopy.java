package com.my.java.util.maptobean;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 深拷贝的工具类
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Feb 21, 2019 10:30:19 AM
 */
public class ObjectCopy {

	/**
	 *  是否是基本类型和包装类型
		* @Description: TODO(这里用一句话描述这个方法的作用) 
		* @param @param className
		* @param @return
		* @return boolean    返回类型 
		* @throws
	 */
	public static boolean isWrapClass(Class className) {
		if(className.isPrimitive()) {
			return true;
		}
	    if (className.equals(java.lang.Integer.class) ||
	        className.equals(java.lang.Byte.class) ||
	        className.equals(java.lang.Long.class) ||
	        className.equals(java.lang.Double.class) ||
	        className.equals(java.lang.Float.class) ||
	        className.equals(java.lang.Character.class) ||
	        className.equals(java.lang.Short.class) ||
	        className.equals(java.lang.String.class) ||
	        className.equals(java.lang.Boolean.class)) {
	        return true;
	    }
	    return false;
	}
	
	public static Object copy(Object source) {
		// 创建一个新的对象(空对象)
		Object target = null;

		try {
			// 获取源对象的class对象
			Class clz = source.getClass();
			// 源对象必须有空的构造器，否则会报错
			target = clz.newInstance();
			// 获取类中的所有属性
			Field[] fields = clz.getDeclaredFields();
			//变量类的所有属性
			for (Field field : fields) {
				/**
				 * 如果是静态的成员，则不需要深层克隆，因为静态成员属于类，对所有实例都共享，不能改变现有静态成员的引用指向
				 * 如果是final类型变量，则不能深层克隆，即使复制一份后也不能将它赋值给final类型变量
				 */
			    if (Modifier.isStatic(field.getModifiers()) || Modifier.isFinal(field.getModifiers())) {  
                    continue;  
                }
			    // 获取属性名
				String fieldName = field.getName();
				
				// 根据属性名称获取setter/getter方法名,myChineseName 对应的方法只需要set+m大写+尾部即可
				String set = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				String get = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				
				// 根据方法名称获取方法对象，getMethod的参数是方法名称，方法形参
				Method method_set = clz.getMethod(set, field.getType());
				Method method_get = clz.getMethod(get);
				
				// 执行源对象的get方法，获取返回值
				Object returnVal = method_get.invoke(source);
			    
				//判断返回值的对象是否是基本类型和包装类型
				if(isWrapClass(field.getType())) {
					// 执行目标对象的set方法，将源对象方法的返回值作为参数设置给目标对象
					method_set.invoke(target, returnVal);
			    }else {
			    	System.out.println("非基本类型和包装类型"+ field.getType());
			    	//递归处理返回filedValue
			    	Object filedValue = copy(returnVal);
			    	method_set.invoke(target, filedValue);
			    }
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return target;
	}
}
