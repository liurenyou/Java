package se;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import entity.Point;

/**
 * java.util.Collection接口
 * 集合：用于保存一组元素，提供维护相关元素的方法
 * 其中包括两个子接口：
 * java.util.List：可重复，且有序
 * java.util.Set：不可重复，大部分实现是无序的
 * 
 * List:
 * 需要保存存储顺序，并保留重复元素，使用List
 * 查询较多，使用ArrayList
 * 存取较多，使用LinkedList
 * 需要线程安全，使用Vector
 * 
 * Set:
 * 不需要保留存储顺序，保留重复元素，使用Set
 * 需要将元素排序，使用TreeSet
 * 不需要排序，使用HashSet
 * 需要保留存储顺序，又要过滤重复元素，使用LinkedHashSet
 * 
 * 元素的重复判定是依靠元素自身的equals方法来判定
 * 
 * @author liurenyou
 *
 */
public class CollectionDemo {
	public static void main(String[] args) {
		/*
		 * Collection接口共性方法：
		 * 
		 * boolean add(Collcetion c) 向当前集合中添加给定的元素
		 *（集合只能存放引用类型，并且存放的是地址，基本类型存放需要包装类）
		 */
		Collection<String> list = new ArrayList<String>(); //集合中的泛型可以约束元素类型
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		System.out.println("ArrayList:"+list);
		
		/*
		 * boolean addAll(Collection c) 向当前集合中添加给定集合中的所有元素
		 */
		Collection<String> set = new HashSet<String>();
		set.addAll(list);
		System.out.println("HashSet:"+set);
				
		/*
		 * int size() 返回当前集合容器的大小
		 */
		System.out.println("共有"+list.size()+"个元素");
		System.out.println("共有"+set.size()+"个元素");
		
		/*
		 * boolean isEmpty() 判断当前集合是否不含有元素 注意：相反的
		 */
		System.out.println("是否含有元素："+list.isEmpty());
		
		/*
		 * void clear() 清空集合内元素
		 */
		list.clear();
		System.out.println("list集合："+list+" "+list.size()+" "+list.isEmpty());
		
		/*
		 * boolean contains() 判断集合是否包含给定元素
		 */
		Collection<Point> list2 = new ArrayList<Point>();
		Collection<Point> set2 = new HashSet<Point>();
		Point p1 = new Point();//使用了包中的Point对象
		p1.setX(2);
		p1.setY(2);
		list2.add(p1);
		System.out.println("Point:"+list2);
		Point p2 = new Point();
		p2.setX(1);
		p2.setY(2);
		System.out.println("判断是否包含："+list2.contains(p2));
		
		/*
		 * boolean containsAll() 判断当前集合中是否包含给定集合的所有元素
		 */
		set2.add(p1);
		boolean b2 = list2.containsAll(set2);
		System.out.println("判断："+b2+" set集合："+set2+" list集合："+list2);
		
		/*
		 * boolean removeAll(Collection c) 删除当前合中与给定集合的共有元素
		 */
		set2.add(p1);
		boolean b3 = set2.removeAll(list2);
		System.out.println("判断："+b3+" set集合："+set2+" list集合："+list2);//set中的p1元素被删除了
		
		/*
		 * boolean remove(Object o) 删除当前集合内的给定元素
		 */
		boolean b = list2.remove(p1);
		System.out.println("是否删除："+b+" 删除后集合内元素："+list2);
		
		/*
		 *List集合特有方法：
		 *List由于是有序集，且元素可以重复，所提可以通过下标来操作元素
		 *
		 * void add(int index, E e) 指定位置添加元素
		 * boolean addAll(int index, Collection c) 指定位置添加集合
		 */
		List<String> orderly = new ArrayList<String>();
		orderly.add("one");
		orderly.add("two");
		orderly.add("three");
		orderly.add("four");
		
		System.out.println("添加前(元素)："+orderly);
		orderly.add(0, "1");
		System.out.println("添加后(元素)："+orderly);
		
		List<String> orderly2 = new ArrayList<String>();
		orderly2.add("1");
		orderly2.add("2");
		orderly2.add("3");
		orderly2.add("4");
		System.out.println("添加前(集合)："+orderly);
		boolean b4 = orderly.addAll(5, orderly2);
		System.out.println("添加前(集合)："+orderly+b4);
		
		/*
		 * E remove(int index) 删除指定位置元素，并返回被删除的元素
		 */
		String str = orderly.remove(0);
		System.out.println("被删除元素："+str);
		System.out.println("删除后："+orderly);
		
		/*
		 * E set(int index,E e) 将给定元素设置到指定位置，返回值为原位置对应的元素，元素替换操作
		 * 注意：下标不可越界，否则会报下标越界错误：IndexOutOfBoundsException
		 */
		 System.out.println("初始集合："+orderly);
		 System.out.println("被替换元素："+orderly.set(1,"2"));
		 System.out.println("替换后集合："+orderly);
		 
		 /*
		  * E get(int index) 获取指定下标对应的元素
		  * int indexOf(Object o) 获取指定元素的下标，未找到则返回-1
		  * lastIndexOf(Object o) 获取集合中最后一个指定元素的下标，未找到则返回-1
		  * 注意：下标不可越界，否则会报下标越界错误：IndexOutOfBoundsException
		  */
		 System.out.println("获取替换后集合中第2个元素："+orderly.get(1));
		 System.out.println("获取替换后集合中\"four\"元素的下标："+orderly.indexOf("four"));
		 System.out.println("获取替换后集合中最后一个\"2\"元素的下标："+orderly.lastIndexOf("2"));
		 
		 /*
		  * List subList(int start,int end) 获取当前集合中指定范围内的子集
		  * 此时修改子集的元素就是修改原集合的元素
		  */
		 System.out.println("获取2-4："+orderly.subList(2, 5));
		 orderly.subList(2, 5).clear();//删除1-4
		 System.out.println("删除后集合："+orderly);
	}
}
