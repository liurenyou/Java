package se;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 线程(Thread)
 * 是进程中负责程序执行的执行单元，线程本身是靠程序进行运行，
 * 是程序中的顺序控制流，只能使用分配给程序的资源和环境
 * 
 * 创建线程的两种方式:
 * 1.继承Thread并重写run方法
 * 2.单独定义线程任务，实现Runnable接口
 * @author liurenyou
 *
 */

/*
 * 第一种方式:
 * 有两点不足:
 * 1.由于需要继承Thread，而java又是单继承原则，所以会导致只能
 * 继承当前类而不能继承其它类，实际中会有继承冲突问题
 * 2.由于线程内部重写了run方法定义当前线程的执行任务，导致线程
 * 与任务存在强耦合关系，不利于线程的重用 
 */
public class ThreadDemo extends Thread {
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println("李来来，收来费了!");
		}
	}
}
class ThreadDemo2 extends Thread {
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println("你谁啊?");
		}
	}
}
class ThreadTest {
	public static void main(String[] args) {
		Thread t1 = new ThreadDemo();
		Thread t2 = new ThreadDemo2();
		/*
		 * 启动线程要调用start方法，不要直接调用线程的run方法，
		 * 当线程启动后，run方法会自动被执行
		 */
		t1.start();
		t2.start();
		/*
		 * 线程在启动后，调动工作是不可被控制的，即:线程何时被分配
		 * CPU时间不可控，分配时长不可控，全由线程调度管理，线程调
		 * 度会尽可能将CPU时间均匀的分配给所有线程，但无具体规律
		 */
	}
}

/*
 * 第二种方式:
 * 单独定义线程任务，实现Runnable接口
 */
class ThreadDemo3 implements Runnable {
	@Override
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println("李来来，收来费了!");
		}
	}
}

/*
 * 运用匿名内部类完成线程的两种创建
 */

class ThreadDemo4 {
	public static void main(String[] args) {
		Thread t1 = new Thread() {	//方式一
			public void run() {
				for(int i=0;i<1000;i++) {
					System.out.println("李来来，收来费了!"+i);
					dosome();
				}
			}
		};
		
		Runnable r = new Runnable() {	//方式二
			@Override
			public void run() {
				for(int i=0;i<1000;i++) {
					System.out.println("你是谁啊?"+i);
					dosome();
				}
			}
		};
		Thread t2 = new Thread(r);
		/*
		 * 线程优先级
		 * 线程优先级有1-10十个等级，1最低，10最高，5为默认值
		 * 理论上优先级越高的线程获取CPU时间片的次数越多
		 */
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(1);
		/*
		 * 守护线程
		 * 线程分用户线程(UserThread)与守护线程(DaemonThread)，
		 * 在JVM实例中，只要非守护线程结束，那么守护线程也会结束，非守护线程如果不结束，
		 * 那么守护线程也不会结束
		 */
		t2.setDaemon(true);		//守护线程的设置必须在线程启动前
		
		t1.start();
		t2.start();
	}
	/*
	 * 线程提供的静态方法currentThread()
	 * 该方法可以获取运行当前的线程
	 */
	public static void dosome() {
		Thread t = Thread.currentThread();
		System.out.println("当前的线程是"+t);
		/*
		 * 获取相关信息的一系列方法
		 */
		System.out.println("ID:"+t.getId());	//获取线程的ID
		System.out.println("Name:"+t.getName());	//获取线程的名字
		System.out.println("Priority:"+t.getPriority());	//获取线程的优先级
		System.out.println("isAlive:"+t.isAlive());		//判断线程是否还活着
		System.out.println("isDaemon:"+t.isDaemon());	//判断线程是否是守护线程
		System.out.println("isInterrupted:"+t.isInterrupted());		//判断线程是否已中断
	}
}

/*
 * sleep阻塞
 * 线程提供了静态方法:static void sleep(long ms)
 * 该方法可以将调用该方法的线程阻塞指定毫秒，指定时间过后线程会自动回到runnable状态
 * 等待分配CPU时间片段并继续运行
 */
class ThreadDemo5 {
	public static void main(String[] args) {
		/*
		 * 制作一个读秒器，每过一秒输出一次系统时间
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		try {
				System.out.println(sdf.format(new Date()));
				Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

/*
 * 线程提供了一个方法:join()
 * 该方法是用来协调线程间同步的，当一个线程调用另一个线程的join方法时，
 * 该线程会进入阻塞状态，直到另一个线程工作完毕才会解除阻塞继续工作
 */
class ThreadDemo6 {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					Thread t = Thread.currentThread();
					System.out.println(sdf.format(new Date()));
					System.out.println(t);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread t1 = new Thread(r1);
		
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				try {
					t1.join();	//该方法放在哪里就从哪里开始阻塞
					for(int i=0;i<10;i++) {
						Thread t = Thread.currentThread();
						System.out.println(sdf.format(new Date()));
						System.out.println(t);
						Thread.sleep(1000);
					}
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		};
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
	}
}

