package com.my.java.util.exportjar;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

/**
 *  构造excel标题头
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Sep 29, 2019 11:36:33 AM
 */
public class ExtractFileHeader {

	public static <T> List<String> generator(Class<T> modelClazz) {
		//1.检查是否有字段
		Field[] fields = modelClazz.getDeclaredFields();
		if (ArrayUtils.isEmpty(fields)) {
			return new ArrayList<String>(0);
		}

		//2.构造excel标题头
		List<String> headers = new ArrayList<String>(ArrayUtils.getLength(fields));
		for (Field field : fields) {
			boolean isPresent = field.isAnnotationPresent(Comment.class);
			if (!isPresent) {
				continue;
			}
			//3.获取实体中需要放到excel中的注解，顺序就是书写顺序
			Comment comment = field.getAnnotation(Comment.class);
			if(comment.isNeedComment()) {
				String headerInfo = field.getAnnotation(Comment.class).value();
				headers.add(headerInfo);
			}
		}
		return headers;
	}
}
