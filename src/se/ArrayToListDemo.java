package se;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组转换为集合
 * import java.util.Arrays
 * 静态方法：Arrays.asList();
 * 数组只能转换List集合，因为Set集合不能存放重复元素
 * @author liurenyou
 *
 */
public class ArrayToListDemo {
	public static void main(String[] args) {
		String[] array = {"one","two","three","four","five"};
		List<String> list = Arrays.asList(array);
		System.out.println("list:"+list);
		
		/*
		 * 如果对集合内的元素进行操作就是对原数组对应的元素进行操作
		 */
		list.set(1, "2");
		System.out.println("修改后："+list);
		for(String str : array) {
			System.out.println(str);
		}
		
		/*
		 * 此时不可以使用add方法添加元素，因为是arrays.aslist中，看代码可以
		 * 看到这里返回的ArrayList不是原来的传统意义上的java.util.arraylist，
		 * 而是自己工具类的一个静态私有内部类，没有add方法
		 */
		//list.add("six");
		/*
		 * 所有集合都有一个含有Collection作为参数的构造方法
		 * 这个构造方法在创建当前集合的同时将给定集合中的所有
		 * 元素包含进来。所以这种构造方法称为“复制构造器”
		 */
		List<String> list2 = new ArrayList<String>(list);
		list2.add("six");
		System.out.println(list2);
	}
}
