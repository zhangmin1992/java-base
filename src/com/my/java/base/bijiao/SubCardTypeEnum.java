package com.my.java.base.bijiao;

import java.util.TreeMap;

/**
 * Created by luozhihuan on 17/6/6.
 */
public enum SubCardTypeEnum {

    Dim2(2, "2D", "2D"),
    Dim2_3(4, "2D3D", "2D/3D"),
    Dim3(3, "3D", "3D"),
    DimImax(12, "imax", "IMAX"),
    DimDmax(13, "dmax", "中国巨幕"),
    ALL(Integer.MAX_VALUE, "all", "全场");

    private static final TreeMap<Integer, SubCardTypeEnum> map = new TreeMap<Integer, SubCardTypeEnum>();
    private static final TreeMap<String, SubCardTypeEnum> nameMap = new TreeMap<String, SubCardTypeEnum>();

    static {
        for(SubCardTypeEnum subCardTypeEnum : SubCardTypeEnum.values()){
            map.put(subCardTypeEnum.getValue(),subCardTypeEnum);
            nameMap.put(subCardTypeEnum.getName(),subCardTypeEnum);
        }
    }

    private final int value;
    private final String desc;
    private final String name;

    SubCardTypeEnum(int value, String name, String desc) {
        this.value = value;
        this.name = name;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }

    public static boolean isValid(int i) {
        return map.containsKey(i);
    }

    public static boolean isValidName(String name) {
        return nameMap.containsKey(name);
    }

    public static SubCardTypeEnum get(int i) {
        return map.get(i);
    }

    public static SubCardTypeEnum getByName(String name) {
        return nameMap.get(name);
    }

}
