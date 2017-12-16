package se;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 线程池主要解决两个问题:
 * 1.控制线程数量
 * 线程过多会导致CPU过度切换，资源消耗大，影响系统效率，严重可能会导致系统崩溃
 * 2.重用线程
 * 不需要频繁的创建与销毁线程，重复利用线程可以减轻系统负担
 * @author liurenyou
 *
 */
public class ThreadPoolDemo {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(2);	//固定大小线程池
		for(int i=0;i<5;i++) {
			Runnable r = new Runnable() {
				@Override
				public void run() {
					Thread t = Thread.currentThread();
					System.out.println(t+"正在执行");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(t+"执行完毕");
				}
			};
			System.out.println("任务交给了线程池");
			threadPool.execute(r);
		}
		System.out.println("停止线程池");
		threadPool.shutdown();	//线程池需要关闭
	}
}
