package review01;

import java.util.Scanner;

public class NumericSorting {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入三个整数，并用\",\"隔开");
		String input = scan.nextLine();
		String[] nums = input.split(",");
		int a = Integer.parseInt(nums[0]);
		int b = Integer.parseInt(nums[1]);
		int c = Integer.parseInt(nums[2]);
		if(a>b){
			int t = a;
			a = b;
			b = t;
		}
		if(a>c){
			int t = a;
			a = c;
			c = t;
		}
		if(b>c){
			int t = b;
			b = c;
			c = t;
		}
		System.out.println("大小顺序为:"+a+"<"+b+"<"+c);
	}
}
