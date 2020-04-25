package com.my.java.base.enumstest;
/**
 * 功能描述: 所有枚举需要的根据 id获取name的方法
 * @Author:
 * @Date:
 */
public class BaseEnums {
    public static <T extends  Enum<T> > String getValueById(Class<T> obj,int id) {
        T[] enums = obj.getEnumConstants();
        for (T myEnum2 : enums) {
            if(id == myEnum2.ordinal()) {
                return myEnum2.name();
            }
        }
        return  null;
    }

}
