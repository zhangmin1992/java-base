package com.my.java.suanfa;

import com.alibaba.fastjson.JSONObject;

import java.util.LinkedHashMap;

/**
 * 一句话对单词计数，句子包括，。空格等
 * 输入一个英文句子，把句子中的单词(不区分大小写)按出现次数按从多到少把单词和次数在屏幕上输出来，
 * 要求能识别英文句号和逗号，即是说单词由空格、句号和逗号隔开
 * 
 * 
 * [ ,.，。] 表示句子中的满足这些的都显示为"",
 * toLowerCase 忽略大小写
 * count++ 先使用count，再对count赋值加1
 * 
 */
public class CountWrods {
	
	public static LinkedHashMap<String, Integer> CountMyWrods(String str) {
		LinkedHashMap<String, Integer> resultHashMap = new LinkedHashMap<String, Integer>();
		if(str == null || "".equals(str)) {
			return resultHashMap;
		}
		String[] strArray = str.split("[ ,.，。]");
		for(int i=0;i<strArray.length;i++) {
			String tempString = strArray[i].toLowerCase();
			if(!tempString.equals("")) {
				Integer count = resultHashMap.get(tempString);
				if(count == null) {
					resultHashMap.put(tempString, 1);
				}else {
//					count = count + 1;
//					resultHashMap.put(tempString,count++);
					resultHashMap.put(tempString,++count);
				}
			}
		}
		return resultHashMap;
	}
	public static void main(String[] args) {
		String str = "Hi, this is first line. This is second line. hi，i am zhangmin。";
		String[] array = str.split("[ ,.，。]");
		System.out.println(array.length  + "--" + JSONObject.toJSONString(array));
		
		System.out.println(JSONObject.toJSONString(CountMyWrods(str)));
	}
}
