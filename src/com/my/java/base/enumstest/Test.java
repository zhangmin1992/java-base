package com.my.java.base.enumstest;


import java.util.EnumMap;
import java.util.EnumSet;

public class Test {
    public static void main(String[] args) {
        /**
         * 功能描述: 测试所有枚举需要的根据 id获取name的方法
         */
        System.out.println(BaseEnums.getValueById(MyEnum.class,1));

        /**
         * 功能描述: 测试EnumSet基本功能：操作枚举类型
         */
        EnumSet<MyEnum> points = EnumSet.allOf(MyEnum.class);
        System.out.println(points);
        System.out.println(EnumSet.range(MyEnum.THREE,MyEnum.SIX));
        points = EnumSet.noneOf(MyEnum.class);
        System.out.println(points);
        points.addAll(EnumSet.of(MyEnum.ONE,MyEnum.THREE,MyEnum.TEN));
        System.out.println(points);
        points.add(MyEnum.FIVE);
        System.out.println(points);

        EnumMap map = new EnumMap(MyEnum.class);
        System.out.println(map);
        map.put(MyEnum.THREE,null);
        System.out.println(map);


    }
}
