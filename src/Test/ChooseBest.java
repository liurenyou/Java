package Test;

import java.util.Scanner;

/**
 * 判断两个年龄大小
 * 
 * @author liurenyou
 *
 */
public class ChooseBest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请依次输入两个整数(以空格隔开)");
		int a = scan.nextInt();
		int b = scan.nextInt();
		int result = a > b ? a : b;
		System.out.println("最大值为：" + result);
	}
}
