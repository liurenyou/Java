package se;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 增强for循环：用来遍历集合或数组
 * 
 * 注意：JDK1.5后才出现的新特性，该语法只被编译器认可，并不被
 * 虚拟机认可，所以编译器在编译源程序时发现增强for循环在遍历数
 * 组时会自动将代码改成传统for循环，发现遍历集合时会自动修改成
 * 迭代器遍历
 * @author liurenyou
 *
 */
public class NewForDemo {
	public static void main(String[] args) {
		/*
		 * 遍历数组
		 */
		String[] arr = {"one","two","three","four"};
		for(String str : arr) { //前面是遍历元素的类型，后面是需要遍历的对象
			System.out.println(str);
		}
		/*
		 * 遍历集合
		 */
		Collection c = new ArrayList();
		c.add("1");
		c.add("2");
		c.add("3");
		c.add("4");
		for(Object o : c) {
			String str = (String) o;
			System.out.println(str);
		}
	}
}
