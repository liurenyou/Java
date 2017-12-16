package basic;

import java.util.Scanner;

public class MaxOfArray {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请分别输入数组的值(正整数)，并用\",\"分开");
		String input = scan.nextLine();
		String[] nums = input.split(",");
		int[] arr = new int[nums.length];
		for(int i=0;i<nums.length;i++){
			arr[i] = Integer.parseInt(nums[i]);
			System.out.print(arr[i]+" ");
		}
		int max = arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i]>arr[0]){
				max = arr[i];
			}
		}
		System.out.println("数组最大值为:"+max);
	}
}
