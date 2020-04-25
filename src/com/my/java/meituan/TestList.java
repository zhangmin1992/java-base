package com.my.java.meituan;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TestList {

	private int i = 0;
	
	public static void main(String[] args) {
		List<student> users = new ArrayList<student>();
		student tempStudent = new student(1, 1, "cc");
		student tempStudent2 = new  student(2, 2, "hh");
		users.add(tempStudent);
		
		tempStudent.setName("ww");
		users.add(tempStudent);
		
		tempStudent2 = tempStudent;
		tempStudent2.setName("88");
		users.add(tempStudent2);
 		System.out.println("ffffff");
		
		System.out.println(JSONObject.toJSONString(users));
		
//		List<student> users = student.getList();
		//获取id大于16的数据列表
		/**List<student> list = users.parallelStream()
				.filter(studentTemp -> studentTemp.getId() > 16) 
	            .collect(Collectors.toList()); 
	    System.out.println(JSONObject.toJSONString(list));**/
		
//	   //按照getName计算list中的个数：{"cc":1,"ww":1,"yy":3,"xx":1}
//	   Map<String, Integer> map = users.parallelStream()
//			   .collect(Collectors.groupingBy(student::getName,Collectors.summingInt(p -> 1)));
//	   System.out.println(JSONObject.toJSONString(map));
//	   
//	   //按照name获取id集合 {"cc":[16],"yy":[15,17,18],"ww":[5],"xx":[19]}
//	   Map<String, List<Integer>> map3 = users.stream() 
//            .collect(Collectors.groupingBy(student::getName,Collectors.mapping(student::getId, Collectors.toList()))); 
//	   System.out.println(JSONObject.toJSONString(map3));
	   
	   //遍历数组
	   //users.forEach(matchDataMode -> {System.out.println(JSONObject.toJSONString(matchDataMode));});
	  
//	    users.parallelStream()
//		.collect(Collectors.groupingBy(collectTemp ->
//				collectTemp.getId() % 5))
//		.forEach((partition, matchDataModelList) -> System.out.println("==="+JSONObject.toJSONString(matchDataModelList)));
		
		//串行执行会等待每一个方法执行完毕后在继续执行下一个
        //List<String> names = ids.stream().map(id -> getStudentName(id)).collect(Collectors.toList());
//		TestList testList = new TestList();
//        users.parallelStream().forEach((user)->{
//        	testList.showName(user);
//		});
//		users.parallelStream().forEach((user)->{
//			testList.showTaskId(user);
//		});
//		System.out.println("执行结束"+testList.i);
		
//		try {
//			List<String> list = null;
//			System.out.println(list.size());
//		} catch (Exception e) {
//			System.out.println(e);
//			System.out.println(e.getMessage());
//		}
	}
	
	void showName(student student) {
		try {
			i++;
			System.out.println("showName------"+student.getName());
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	void showTaskId(student student) {
		try {
			i++;
			System.out.println("showTaskId---------------"+student.getTaskId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	static class HashPartitioner {

	    /**
	     * 使用{@link Object#hashCode()}做分区
	     * @param id            需要分区的id
	     * @param numPartitions 分区个数
	     * @return key的分区
	     */
	    public static int getPartition(String id, int numPartitions) {
	        return (id.hashCode() & Integer.MAX_VALUE) % numPartitions;
	    }
	}

}
