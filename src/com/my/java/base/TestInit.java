package com.my.java.base;


/**
 * 功能描述: boolean 默认false，Boolean默认为空，byte默认为0，Byte空,obj.getBytes() == 0 为true
 *         char默认为0，Character空,obj.getChars() == 0 为true
 *         float 默认为0.0, System.out.println(obj.getaFloat() == 0);为true
 *         double 默认为0.0, System.out.println(obj.getaDouble() == 0);为true
 * @Author: zhangmin
 * @Date: 2020/4/21 9:27 AM
 */
public class TestInit {
    public static  void main(String[] args) {
        Init obj = new Init();
        System.out.println(obj.getaInt());
        System.out.println(obj.getaLong());
        System.out.println(obj.getaFloat());
        System.out.println(obj.getaFloat() == 0.0);
        System.out.println(obj.getaFloat() + 5);
        System.out.println(obj.getaDouble());
        System.out.println(obj.getaDouble() == 0);
        System.out.println(obj.getaDouble() + 5);

        System.out.println(obj.getChars());
        System.out.println(obj.getCharacter());
        System.out.println(obj.getaByte());
        System.out.println(obj.getBytes());
        System.out.println(obj.isaBoolean());
        System.out.println(obj.getBooleans());
        System.out.println(obj.getBytes() == 0);
        System.out.println(obj.getChars() == 0);

        System.out.println(obj.getChars() + 5);
    }
}

class Init {
    private char chars;
    private byte bytes;
    private boolean aBoolean;
    private Character character;
    private Byte aByte;
    private Boolean booleans;

    private int aInt;
    private long aLong;
    private float aFloat;
    private double aDouble;

    public int getaInt() {
        return aInt;
    }

    public void setaInt(int aInt) {
        this.aInt = aInt;
    }

    public long getaLong() {
        return aLong;
    }

    public void setaLong(long aLong) {
        this.aLong = aLong;
    }

    public float getaFloat() {
        return aFloat;
    }

    public void setaFloat(float aFloat) {
        this.aFloat = aFloat;
    }

    public double getaDouble() {
        return aDouble;
    }

    public void setaDouble(double aDouble) {
        this.aDouble = aDouble;
    }

    public char getChars() {
        return chars;
    }

    public void setChars(char chars) {
        this.chars = chars;
    }

    public byte getBytes() {
        return bytes;
    }

    public void setBytes(byte bytes) {
        this.bytes = bytes;
    }

    public boolean isaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Byte getaByte() {
        return aByte;
    }

    public void setaByte(Byte aByte) {
        this.aByte = aByte;
    }

    public Boolean getBooleans() {
        return booleans;
    }

    public void setBooleans(Boolean booleans) {
        this.booleans = booleans;
    }
}
