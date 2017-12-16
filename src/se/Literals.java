package se;
/**
 * java创建字符串推荐使用字面量形式
 * 因为Java对字面量的相同字符串内容会重用对象，而不是创建新的
 * @author liurenyou
 *
 */
public class Literals {
	public static void main(String[] args) {
		String s1 = "123hello";
		String s2 = "123hello";
		System.out.println(s1==s2);
		String s3 = "123hello";
		System.out.println(s1==s3);
		//new会创建新对象
		String s4 = new String("123hello");
		System.out.println(s1==s4);
		/*
		 * 编译器的一个优化措施：
		 * 当编译器编译源程序时，发现一个计算表达式的计算两边都是字面量时，
		 * 会直接进行计算，并将结果编译到class（字节码）文件中
		 * 所以虚拟机在运行下面代码时看到的结果是：
		 * String s5 = "123hello";
		 */
		String s5 = "123"+"hello";
		System.out.println(s1==s5);
		
		String str = "123";
		String s6 = str+"hello";
		System.out.println(s6==s1);
	}
}
