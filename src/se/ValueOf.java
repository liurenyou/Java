package se;
/**
 * String提供一组静态方法
 * static String valueOf()
 * 将其他类型转换为字符串，常用于基本类型转换成字符串
 * @author liurenyou
 *
 */
public class ValueOf {
	public static void main(String[] args) {
		int i =123;
		String iStr = String.valueOf(i);
		String iStr2 = i+"";
		System.out.println(iStr+4);
		System.out.println(iStr2);
		double d = 123.123;
		String dStr = String.valueOf(d);
		System.out.println(dStr);
	}
}
