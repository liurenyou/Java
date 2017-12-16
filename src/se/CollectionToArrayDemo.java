package se;

import java.util.Collection;
import java.util.LinkedList;

/**
 * 集合转换成数组
 * 使用Collection提供的方法：toArray()
 * @author liurenyou
 *
 */
public class CollectionToArrayDemo {
	public static void main(String[] args) {
		Collection<String> c = new LinkedList<String>();
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		System.out.println("集合："+c);
		//Object[] array = c.toArray(); 不常用
		/*
		 * toArray有两种方法：
		 * 1.不带参数的方法，构造并返回一个Object数组对象，这时候向下转型为String
		 * 数组对象，导致类型不兼容，报错ClassCastException
		 * 2.带参数的方法，构造的数组对象类型和参数的类型一致，故不存在转型
		 */
		String[] array = c.toArray(new String[c.size()]);
		System.out.println("len:"+array.length);
		for(String str : array) {
			System.out.println(str);
		}
	}
}
