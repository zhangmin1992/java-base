package com.my.java.meituan;

import static java.util.Optional.ofNullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestOptional {
	
	public static void main(String[] args) {
		List<student> list = new ArrayList<student>();
//		list.add(new student(1,1,"xx"));
//		list.add(new student(2,2,"ww"));
//		list.add(new student(1,3,"yy"));
//		list = null;
//		Optional<List<student>> opList = ofNullable(list);
//		opList.ifPresent(studentList -> studentList.forEach(temp ->{
//			System.out.println(temp.getId() + "--" + temp.getName() + "--" + temp.getTaskId());
//		}));
		
		list = null;
		Optional<List<student>> opList = ofNullable(list);
		System.out.println(opList.isPresent());
		if (!opList.isPresent()) {
			System.out.println("oo");
		}
	}

}
