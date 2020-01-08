package com.my.java.meituan;

import java.util.ArrayList;
import java.util.List;

public class student {

	private int id;
    private int taskId;
    private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public student(int id, int taskId, String name) {
		super();
		this.id = id;
		this.taskId = taskId;
		this.name = name;
	}
	@Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;//地址相等
        }

        if(obj == null){
            return false;//非空性：对于任意非空引用x，x.equals(null)应该返回false。
        }

        if(obj instanceof student){
        	student other = (student) obj;
            //需要比较的字段相等，则这两个对象相等
            return ((student) obj).getName().equals(other.getName());
        }
        return false;
    }
	
	@Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (name == null ? 0 : name.hashCode());
        return result;
    }
	
	public static List<student> getList() {
		List<student> list = new ArrayList<student>();
		list.add(new student(19,1,"xx"));
		list.add(new student(5,2,"ww"));
		list.add(new student(15,3,"yy"));
		list.add(new student(16,3,"cc"));
		list.add(new student(17,3,"yy"));
		list.add(new student(18,3,"yy"));
		return list;
	}
}
