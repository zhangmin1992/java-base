package com.my.java.base.deepclone;

public class TestIsWrapClass {

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

	public static void main(String[] args) {
		System.out.println(isWrapClass(int.class));
		System.out.println(isWrapClass(Integer.class));
		
	}

}
