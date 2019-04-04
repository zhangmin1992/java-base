package com.my.java.suanfa;

/**
 * 字符串反转 1234变成4321
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Apr 1, 2019 2:52:33 PM
 */
public class WordsReverse {

	public static void main(String[] args) {
		System.out.println(reverse("1234"));
	}
	
	public static String reverse(String str) {
		String result = "";
		if(str == null || str.equals("")) {
			return result;
		}
		int length = str.length();
		int max = (length + 1)/2;
		char[] chars = str.toCharArray();
		for(int i = 0;i < max; i++) {
			char temp = chars[i];
			char newChar = chars[length -1 - i];
			chars[i] = newChar;
			chars[length -1 - i] = temp;
			
		}
		result = String.valueOf(chars);
		return result;
	}

}
