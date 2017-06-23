package review01;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = {12,42,55,1};
		for(int i=0;i<arr.length-1;i++){	//控制轮
			for(int j=0;j<arr.length-1-i;j++){	//控制次数
				if(arr[j]>arr[j+1]){
					int t = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = t;
				}
			}
		}
		for(int i=0;i<arr.length;i++){	//输出排序后解
			System.out.println(arr[i]);
		}
	}
}
