package review01;

import java.util.Scanner;

public class Cashiner {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入单价:");
		double unitPrice = scan.nextDouble();
		System.out.println("请输入数量:");
		double amount = scan.nextDouble();
		System.out.println("请输入收款总额:");
		double money = scan.nextDouble();
		double totalPrice = unitPrice*amount;
		if(totalPrice>=500){
			totalPrice*=0.8;
		}
		if(totalPrice<=money){
			double change = money-totalPrice;
			System.out.println("谢谢光临,找零:"+(change));
		}else{
			System.out.println("您的付款金额不够!");
		}
	}
	
}
