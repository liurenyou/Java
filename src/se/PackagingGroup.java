package se;
/**
 * 包装类
 * 由于基本类型不能直接参与面向对象开发，所以Java为基本类型分别定义
 * 了一个类，使得基本类型可以以对象形式参与面向对象开发。
 * 其中6个数字类型的包装类继承自Number，剩下两个集成Object。
 * Number是一个抽象类，其中抽象方法要求每一个具体的包装类可以将其表
 * 示的数字以所有基本数字类型返回
 * 
 * @author liurenyou
 *
 */
public class PackagingGroup {
	public static void main(String[] args) {
		//基本类型-->包装类
		Integer i1 = new Integer(1);
		//推荐使用静态方法valueOf转换
		Integer i2 = Integer.valueOf(2);
		
		int i = i1.intValue();
		double d = i1.doubleValue();
		float f = i1.floatValue();
		System.out.println(i2+","+i+","+d+","+f);
		
		/*
		 * 数字类型包装类有两个常量：MAX_VALUE,MIN_VALUE
		 * 分别表示该包装类对应的基本类型取值的最大值与最小值
		 */
		int imax = Integer.MAX_VALUE;
		int imin = Integer.MIN_VALUE;
		long lmax = Long.MAX_VALUE;
		System.out.println(imax+","+imin+","+lmax);
		
		/*
		 * 包装类提供了一个静态方法：parseXXX(String str)
		 * 允许将给定的字符串转换成基本类型值
		 * 例如：Integer有parseInt方法
		 * 		Double有parseDouble方法...
		 * 注意：给定的字符串必须能正确描述需要转换的基本类型可
		 * 以表示的值，否则会抛出异常
		 */
		String iStr = "123";
		int n = Integer.parseInt(iStr);
		System.out.println(iStr+1);
		System.out.println(n+1);
		
		double m = Double.parseDouble(iStr);
		System.out.println(m);
		
		/*
		 * String str = "123.3";
		 * int l = Integer.parseInt(str);
		 * System.out.println(l);//会报错
		 */
		
		/*
		 * JDK1.5之后推出新特性：自动拆装箱
		 * 此特性为编译器真可而不是虚拟机认可，也就是说该特性是编译器
		 * 在编译源程序时帮我们补充代码自动完成包装类与基本类型的转换
		 */
		Integer in = 1;//编译器自动补全代码：Integer in = Integer.valueOf(1);
		int p = in;
		dosome(p);
	}
	
	public static void dosome(Object o) {
		System.out.println(o);
	}
}
