package se;
/**
 * 字符串内容不可改变，若改变则会创建新的字符串对象
 * @author liurenyou
 *
 */
public class StringDemo {
	public static void main(String[] args) {
		String s1 = "helloword";
		String s2 = s1;
		System.out.println(s1==s2);
		s1 = s1 + "!";//修改内容会创建新对象
		System.out.println(s1);
		System.out.println(s1==s2);
	
	}
}
