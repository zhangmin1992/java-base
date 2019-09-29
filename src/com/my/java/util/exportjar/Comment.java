package com.my.java.util.exportjar;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 导出文件的字段业务注释
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Comment {
	//excel文件标题名
    String value() default "";
    
    //是否需要放到excel标题中
    boolean isNeedComment() default true;
  
    //日期格式样式
    String dateStyle() default constant.FULL_TIME_STRING;
}
