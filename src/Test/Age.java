package Test;

import java.util.Scanner;

/**
 * 判断年龄是否符合规定
 * 
 * @author liurenyou
 *
 */
public class Age {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入年龄：");
		int age = scan.nextInt();
		System.out.println(age >= 18 && age <= 50);
	}
}
