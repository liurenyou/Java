package se;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Iterator iterator()
 * java.util.Iterator
 * 迭代器：一般用作遍历集合元素使用
 * 迭代器遍历集合遵循：问，取，删的遍历过程，其中删除不是必须操作
 * @author liurenyou
 *
 */
public class IteratorDemo {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add("four");
		System.out.println("start:"+c);
		Iterator iterator = c.iterator();
		/*
		 * boolean hasNext()
		 * 判断当前集合中是否还有元素可以取出
		 */
		while(iterator.hasNext()) {
			/*
			 * 从集合中开始取出元素
			 */
			String str = (String)iterator.next();
			System.out.println(str);
			if("#".equals(str)) {
				iterator.remove();//删掉集合中的所有"#"
				//c.remove(str) 迭代过程中无法通过集合方法删除取出的元素
			}
		}
		System.out.println("end:"+c);
	}
}
