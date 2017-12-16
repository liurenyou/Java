package se;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈
 * 用于存储一组元素，必须遵循先进后出原则
 * @author liurenyou
 *
 */
public class StackDemo {
	public static void main(String[] args) {
		/*
		 * 栈使用双端队列实现：Deque
		 */
		Deque<String> stack = new LinkedList<String>();
		/*
		 * 入栈操作：void push(E e)
		 */
		stack.push("one");
		stack.push("two");
		stack.push("three");
		stack.push("four");
		System.out.println("stack:"+stack);
		/*
		 * 出栈操作：void pop(E e)
		 * 获取顶端元素并移除
		 */
		String str = stack.pop();
		System.out.println("顶端元素："+str);
		System.out.println("移除后："+stack);
		while(stack.size()>0) {
			System.out.println("移除元素："+stack.pop());
		}
		System.out.println("全部移除后："+stack);
	}
}
