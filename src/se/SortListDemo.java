package se;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import entity.Point;

/**
 * 排序集合
 * 排序集合只可以对List集合进行排序
 * 使用集合工具类Collections的静态方法sort对集合排序
 * @author liurenyou
 *
 */

public class SortListDemo {
	public static void main(String[] args) {
		Random random = new Random();
		
		/*
		 * 集合中元素可以直接进行比较时，使用Collections的静态方法sort即可
		 */
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<10;i++) {
			list.add(random.nextInt(100));
		}
		System.out.println("排序前(Integer):"+list);
		Collections.sort(list);
		System.out.println("排序后(Integer):"+list);
		
		/*
		 * 集合中元素不可直接比较时：
		 * 方法一：需要实体类继承Comparable接口，并实现大小比较规则的
		 * 方法详见实体类Point
		 */
		List<Point> p = new ArrayList<Point>();
		for(int i=0;i<5;i++) {
			p.add(new Point(random.nextInt(10),random.nextInt(10)));
		}
		System.out.println("排序前(Point):"+p);
		Collections.sort(p);
		System.out.println("排序前(Point):"+p);
		
		/*
		 * 方法二：重载sort方法，根据比较器的比较规则来从小到大排序集合中的元素
		 * 更推荐使用比较器，两大好处：
		 * 1.不依靠元素自身比较规则，可以更好的用于需要的比较方式排序
		 * 2.集合元素不需要实现Comparable接口，减少对元素的"侵入性",利于
		 * 程序的扩展
		 */
		List<String> s = new ArrayList<String>();
		s.add("橡皮");
		s.add("量角器");
		s.add("笔");
		s.add("笔记本");
		s.add("Iphone");
		System.out.println("排序前(String):"+s);
		MyComparator com = new MyComparator();
		Collections.sort(s,com);
		System.out.println("排序前(String):"+s);
	}
}
class MyComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		/*
		 * 规定字符多的大
		 */
		return o1.length()-o2.length();
	}
	
}
