package com.my.java.util.FSTSeriazle;

import com.alibaba.fastjson.JSONObject;

/**
 *  需要引入jar包：
 *  fst-2.04.jar
 *  
 *  需要分别测试时间和大小
 *  fst序列化方案[序列化10000次]耗时：414ms size:=680000
 *  jdk序列化方案[序列化10000次]耗时：579ms size:=1290000
	* @author zhangmin 
	* @date Oct 11, 2019 2:34:56 PM
 */
public class App {

	public static void main(String[] args) {
        MUser bean = new MUser();
        bean.setUsername("xxxxx");
        bean.setPassword("123456");  
        bean.setAge(1000000);  
        System.out.println("序列化 ， 反序列化 对比测试：");  
        long size = 0;  
        long time1 = System.currentTimeMillis();  
        for (int i = 0; i < 10000; i++) {  
            byte[] serialize = FSTSerializationUtils.serialize(bean);  
            size += serialize.length;
            MUser u = (MUser) FSTSerializationUtils.unserialize(serialize);
            System.out.println(JSONObject.toJSONString(u));
        }  
        System.out.println("fst序列化方案[序列化10000次]耗时：" + (System.currentTimeMillis() - time1) + "ms size:=" + size);
        
        size = 0;  
        long time2 = System.currentTimeMillis();  
        for (int i = 0; i < 10000; i++) {  
            byte[] serialize = FSTSerializationUtils.jdkserialize(bean);  
            size += serialize.length;
            MUser u = (MUser) FSTSerializationUtils.jdkdeserialize(serialize);
            System.out.println(JSONObject.toJSONString(u));
        }  
        System.out.println("jdk序列化方案[序列化10000次]耗时：" + (System.currentTimeMillis() - time2) + "ms size:=" + size);

	}

}



class myThread extends Thread {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	}
}
