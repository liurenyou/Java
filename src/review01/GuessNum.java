package review01;

import java.util.Scanner;

public class GuessNum {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int guess = (int)(Math.random()*1000);
		System.out.println("猜吧!(输入\"0\"退出)");
		int input = scan.nextInt();
		while(input!=guess){
			if(input==0){
				break;
			}
			if(input>guess){
				System.out.println("猜大了!");
			}
			if(input<guess){
				System.out.println("猜小了!");
			}
			System.out.println("猜吧!(输入\"0\"退出)");
			input = scan.nextInt();
		}
		if(input==0){
			System.out.println("没关系，下次再来吧!");
		}
		else{
			System.out.println("恭喜你猜对了!");
		}
	}
}
