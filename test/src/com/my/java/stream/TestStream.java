package com.my.java.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestStream {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("1", "3", "1","5");
		List<Entity> list2 = Arrays.asList(new Entity("name1",1),new Entity("name3",3),new Entity("name1",1),new Entity("name5",5));
		/**
		 * jdk1.8可以直接打印集合的内容了(list map)
		 * 但是还是没法直接打印数组的内容
		 */
		System.out.println(list);
		
		/**
		 * distinct 去重
		 * sorted 排序
		 * skip(2) 跳过前2个
		 * limit(2) 只选取前2个
		 * filter(i-> i.equals("1")) 过滤元素等于某个值的
		 * filter(i-> i.compareTo("3")>=0) >=3的
		 * mapToInt 转成map
		 * findFirst第一个首元素
		 * 流的中指操作有：forEach、 forEachOrdered、 toArray、 reduce、 collect、 min、 max、 count、 
		 * anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 iterator
		 */
		list.stream().distinct().forEach(user -> System.out.print(user));
		System.out.println("");
		
		list.stream().sorted().forEach(user -> System.out.print(user));
		System.out.println("");
		
		list.stream().sorted((i,j)->{
			if(i.compareTo(j) == 0) {
				return 0;
			}else if(i.compareTo(j)==-1) {
				return -1;
			}else {
				return 1;
			}
			}).forEach(user -> System.out.print(user));
		System.out.println("sorted自定义排序结束");
		
		list.stream().skip(2).forEach(user->System.out.print(user));
		System.out.println("");
		
		list.stream().limit(2).forEach(user->System.out.print(user));
		System.out.println("");
		
		list.stream().filter(i-> i.equals("1")).forEach(user->System.out.print(user));
		System.out.println("");
		
		list.stream().filter(i-> !i.equals("1")).forEach(user->System.out.print(user));
		System.out.println("");
		
		list.stream().filter(i-> i.compareTo("3")>=0).forEach(user->System.out.print(user));
		System.out.println("");
		
		/**
		 * 找到最大最小平均和第一个值和任意一个元素
		 */
		IntSummaryStatistics num = list.stream().mapToInt(i->Integer.valueOf(i)).summaryStatistics();
		System.out.println(num.getMax());
		System.out.println(num.getSum());
		System.out.println(num.getCount());
		System.out.println(num.getAverage());
		System.out.println(list.stream().findFirst().get());
		System.out.println(list.stream().findAny().get());
		
		/**
		 * IntStream的创建
		 */
		IntStream.of(new int[]{1, 2, 3}).forEach(System.out::print);
		System.out.println("");
		
		/**
		 * list转数组
		 */
		String[] arrayStrings = (String[]) list.toArray();
		for (String string : arrayStrings) {
			System.out.print(string);
		}
		System.out.println("");
		
		/**
		 * 拼接字符串，-表示起始元素
		 */
		String concat = list.stream().reduce("-", String::concat);
		System.out.println(concat);
		/**
		 * reduce求和
		 */
		int sum = list.stream().mapToInt(i -> Integer.valueOf(i)).reduce(Integer::sum).getAsInt();
		System.out.println("----"+sum);
		
		/**
		 * 只打印list中的某个元素
		 */
		list2.stream().map(Entity::getAge).forEach(System.out::print);
		System.out.println("");
		
		/**
		 * allMatch 全部满足，返回true
		 * allMatch 只要一个满足，返回true
		 * noMatch 全部不满足，返回true
		 */
		boolean isAllAdult = list2.stream().allMatch(p -> p.getAge() > 3);
		System.out.println("All are adult? " + isAllAdult);
		
		/**
		 * 按照年龄分组{1=2, 3=1, 5=1}
		 */
		Map<Integer, Integer> map = list2.parallelStream().collect(Collectors.groupingBy(Entity::getAge,Collectors.summingInt(p -> 1)));
		System.out.println(map);
		
		/**
		 * 按照姓名分组，键值对中只对应的是list
		 */
		Map<String, List<Entity>> map2 = list2.parallelStream().collect(Collectors.groupingBy(Entity::getName));
		System.out.println(map2);
		
		/**
		 * 年龄求和
		 */
		IntSummaryStatistics num2 = list2.parallelStream().mapToInt(Entity::getAge).summaryStatistics();
		System.out.println(num2.getSum());
		
		/**
		 * 留下偶数，数组和流的转换
		 */
		Integer[] sixNums = {1, 2, 3, 4, 5, 6};
		Integer[] evens =Stream.of(sixNums).filter(n -> n%2 == 0).toArray(Integer[]::new);
		
		/**
		 * 把单词挑出来
		 */
		List<String> list3 = Arrays.asList("hello worild", "my name is ", "zhang","min hello");
		List<String> output = list3.stream().flatMap(line -> Stream.of(line.split(" "))).filter(word -> word.length() > 0).collect(Collectors.toList());
		System.out.println(output);
		
		/**
		 * peek
		 */
		Stream.of("one", "two", "three", "four")
		 .filter(e -> e.length() > 3)
		 .peek(e -> System.out.println("Filtered value: " + e))
		 .map(String::toUpperCase)
		 .peek(e -> System.out.println("Mapped value: " + e))
		 .collect(Collectors.toList());
	}

}
class Entity{
	private String name;
	
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Entity(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
}
