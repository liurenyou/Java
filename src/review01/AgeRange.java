package review01;

import java.util.Scanner;

public class AgeRange {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入年龄:");
		int age = scan.nextInt();
		System.out.println(age>=18 && age<=50);
		
	}
}
