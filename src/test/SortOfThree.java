package test;

import java.util.Scanner;

/**
 * 数字大小排序
 * 
 * @author liurenyou
 *
 */
public class SortOfThree {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(" 请依次输入三个整数：a，b，c（以空格隔开）");
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		System.out.println("您输入的是：a=" + a + "，b=" + b + ",c=" + c);
		int temp = 0;
		if (a > b) {
			temp = a;
			a = b;
			b = temp;
		}
		if (a > c) {
			temp = a;
			a = c;
			c = temp;
		}
		if (b > c) {
			temp = b;
			b = c;
			c = temp;
		}
		System.out.println("生序排列后，结果为：");
		System.out.println("a=" + a + ",b=" + b + ",c=" + c);
	}
}
