package basic;

public class ForDemo {
	public static void main(String[] args) {
		int sum = 0;
		int num = 1;
		for(;num<=100;num++){
			sum+=num;
		}
		System.out.println(sum);
		
		int sum2 = 0;
		for(int num2=1;num<=100;){
			sum+=num;
			num++;
		}
		System.out.println(sum);
		
		int sum3 = 0;
		for(int num3=1;num3<=100;num3++){
			if(num3%3==0){
				continue;
			}
			sum3+=num3;
		}
		System.out.println(sum3);
		
		for(int num4=1;num4<=9;num4++){
			System.out.println(num4+"*9="+num4*9);
		}
	}
}
