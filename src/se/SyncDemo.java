package se;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 多线程并发安全问题
 * 当多个线程访问同一资源时，由于线程切换时机不确定，可能
 * 会导致多个线程执行代码出现混乱，导致程序执行出现问题，
 * 严重可能会导致系统瘫痪，所以为解决并发安全问题，就要
 * 将多个线程的执行进行排队
 * @author liurenyou
 *
 */
public class SyncDemo {
	public static void main(String[] args) {
		Table t = new Table();
		/*
		 * 两个线程轮流执行拿豆
		 */
		Thread t1 = new Thread() {
			@Override
			public void run() {
				while(true) {
					int bean = t.getBean();
					Thread.yield();	//模拟CPU执行到这里没有时间
					System.out.println(getName()+":"+bean);
				}
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				while(true) {
					int bean = t.getBean();
					Thread.yield();	//模拟CPU执行到这里没有时间
					System.out.println(getName()+":"+bean);
				}
			}
		};
		
		t1.start();
		t2.start();
	}
}
class Table {
	private int beans = 20;
	/*
	 * 当一个方法被Synchronized修饰后，那么该方法称为
	 * "同步方法"，即:多个线程无法同时进入方法内部执行
	 * 方法上使用synchronize，那么锁对象就是当前方法
	 * 所属对象，this
	 */
	public synchronized int getBean() {
		if(beans==0) {
			throw new RuntimeException("没有了");
		}
		Thread.yield();	//模拟CPU执行到这里没有时间
		return beans--;
	}
}

class Shopping {
	public static void main(String[] args) {
		final Shop s = new Shop();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				s.buy();
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				s.buy();
			}
		};
		
		t1.start();
		t2.start();
	}
}

class Shop {
	public void buy() {
		Thread t = Thread.currentThread();
		/*
		 * 同步块
		 * 有效缩小同步范围可以保证安全的前提下提高并发率
		 * 使用同步块要注意同步监事对象(上锁对象)的选取:
		 * 1.通常使用this即可
		 * 2.若多个线程调用同一个对象的某些方法时，也可以将这个
		 * 对象上锁，比如:多个线程调用同一个集合的方法list.add()，
		 * 这时可以将list作为上锁对象
		 * 原则:多个线程看到的上锁对象是同一个时才有同步效果
		 */
		try {
			System.out.println(t.getName()+"正在挑选衣服");
			Thread.sleep(3000);
			synchronized(this) {
				System.out.println(t.getName()+"正在试衣服");
				Thread.sleep(3000);
				System.out.println(t.getName()+"结账离开");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class SyncDemo2 {
	public static void main(String[] args) {
		Thread t1 = new Thread(){
			@Override
			public void run() {
				Aoo.dosome();
			}
		};
		Thread t2 = new Thread(){
			@Override
			public void run() {
				Aoo.dosome();
			}
		};
		t1.start();
		t2.start();
	}
}

class Aoo {
	/*
	 * 静态方法被synchronize修饰后变成同步静态方法，任何时候都有同步效果
	 * 静态方法上锁的对象是当前类的类对象(class类型实例)，每个类在JVM加载
	 * 时，JVM都会实例化一个class类型的实例用于描述加载的这个类，而JVM内
	 * 部每个类都有且只有一个class类型的实例与之对应，静态方法锁就是锁的这个
	 * 对象
	 */
	public synchronized static void dosome() {
		Thread t = Thread.currentThread();
		try {
			System.out.println(t.getName()+":正在执行");
			Thread.sleep(5000);
			System.out.println(t.getName()+":执行完毕");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class SyncDemo3 {
	public static void main(String[] args) {
		final Boo b = new Boo();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				b.methodA();
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				b.methodB();
			}
		};
		t1.start();
		t2.start();
	}
}

class Boo {
	/*
	 * 互斥锁
	 * 当synchronize修饰两段不同代码，但是同步监视器对象相同时，这两段代码就
	 * 有了互斥性，多段代码也是
	 */
	public synchronized void methodA() {
		Thread t = Thread.currentThread();
		try {
			System.out.println(t.getName()+":正在执行A方法");
			Thread.sleep(3000);
			System.out.println(t.getName()+":A方法执行完毕");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public synchronized void methodB() {
		Thread t = Thread.currentThread();
		try {
			System.out.println(t.getName()+":正在执行B方法");
			Thread.sleep(3000);
			System.out.println(t.getName()+":B方法执行完毕");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class SyncDemo4 {
	public static void main(String[] args) {
		final Coo c = new Coo();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				c.methodA();
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				c.methodB();
			}
		};
		t1.start();
		t2.start();
	}
}

class Coo {
	private Object oa = new Object();
	private Object ob = new Object();
	/*
	 * 死锁
	 * 避免出现死锁情况，都在等对方先执行而导致程序卡死
	 */
	public void methodA() {
		Thread t = Thread.currentThread();
		synchronized (oa) {
			System.out.println(t.getName()+"正在执行A方法");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			methodB();
			System.out.println(t.getName()+"A方法执行完毕");
		}
	}
	public void methodB() {
		Thread t = Thread.currentThread();
		synchronized (ob) {
			System.out.println(t.getName()+"正在执行B方法");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			methodA();
			System.out.println(t.getName()+"B方法执行完毕");
		}
	}
}

/*
 * 将集合转换为线程安全
 * List中的ArrayList与LinkedList、Set中的HashSet、Map中的HashMap
 * 都是线程不安全，可以使用集合的工具类Collections
 */
class SyncDemo5 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		System.out.println(list);
		/*
		 * 所有线程安全的集合都要注意一个事项:
		 * 使用迭代器遍历集合不与集合增删元素等操作互斥，所以多
		 * 线程情况下需要自己维护互斥关系
		 * 
		 * 将给定的集合转换为线程安全
		 */
		list = Collections.synchronizedList(list);
		System.out.println(list);
		
		Set<String> set = new HashSet<String>(list);
		System.out.println(set);
		set = Collections.synchronizedSet(set);
		System.out.println(set);
		
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		System.out.println(map);
		map = Collections.synchronizedMap(map);
		System.out.println(map);
	}
}
