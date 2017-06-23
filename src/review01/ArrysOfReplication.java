package review01;

import java.util.Arrays;

public class ArrysOfReplication {
	public static void main(String[] args) {
		int[] arr1 = new int[5];
		for(int i=0;i<arr1.length;i++){
			arr1[i] = (int)(Math.random()*100);
			System.out.println("原数组:"+arr1[i]);
		}
		
		int[] arr2 = Arrays.copyOf(arr1, arr1.length+1);
		for(int i=0;i<arr1.length;i++){
			System.out.println("第一次复制(扩容):"+arr2[i]);
		}
		
		int[] arr3 = Arrays.copyOf(arr1, 4);
		for(int i=0;i<arr3.length;i++){
			System.out.println("第二次复制(只复制前四个):"+arr3[i]);
		}
		
		System.arraycopy(arr1, 0, arr2, 1, 5);
		for(int i=0;i<arr2.length;i++){
			System.out.println("第三次复制(按要求复制):"+arr2[i]);
		}
	}
}
