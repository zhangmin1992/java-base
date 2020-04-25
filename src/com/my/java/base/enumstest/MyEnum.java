package com.my.java.base.enumstest;

public enum MyEnum {
    ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN;

    public static String getNameById(int id) {
        for (MyEnum myEnum2 : MyEnum.values()) {
            if(id == myEnum2.ordinal()) {
                return myEnum2.name();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MyEnum test = MyEnum.TWO;
        System.out.println(test == MyEnum.TWO);
        System.out.println(MyEnum.valueOf("ONE"));
        System.out.println(MyEnum.getNameById(2));

        for (MyEnum s : MyEnum.values()) {
            System.out.println(s.ordinal() + "-" + s.name() + "-直接的s：" + s);
            System.out.println(s.equals(MyEnum.ONE));
            System.out.println(s == MyEnum.ONE);
        }
    }
}
