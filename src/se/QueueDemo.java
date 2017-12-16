package se;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列
 * 用于存储一组元素，必须遵守先进先出原则
 * @author liurenyou
 *
 */
public class QueueDemo {
	public static void main(String[] args) {
		Queue<String> q = new LinkedList<String>();
		/*
		 * 入队操作(向队尾追加元素):boolean offer(E e)
		 */
		q.offer("one");
		q.offer("two");
		q.offer("three");
		q.offer("four");
		System.out.println("Queue:"+q);
		/*
		 * 出队操作(从队首获取元素并移除):E poll()
		 */
		String str = q.poll();
		System.out.println("移除元素:"+str);
		System.out.println(q);
		while(q.size()>0) {
			System.out.println("移除:"+q.poll());
		}
		System.out.println("移除后:"+q);
	}
}
