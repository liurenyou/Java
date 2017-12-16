package basic;

public class PrimeNumber {
	public static void main(String[] args) {
		int count = 0;
		for(int num=2;num<=100;num++){
			boolean f = true;
			for(int i=2;i<=Math.sqrt(num);i++){
				if(num%i==0){
					f = false;
					break;
				}
			}
			if(f){
				count++;
				System.out.print(num+"\t");
				if(count%10==0){
					System.out.println();
				}
			}
		}
	}
}
