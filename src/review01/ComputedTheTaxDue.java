package review01;

import java.util.Scanner;

public class ComputedTheTaxDue {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入您的工资数额:");
		double salary = scan.nextDouble();
		double taxSalary = salary-3500;
		double tax = 0.0;
		if(taxSalary<=0){
			tax = 0.0; //不需要纳税
		}
		else if(taxSalary<=1500){
			tax = taxSalary*0.03-0; //5000工资
		}
		else if(taxSalary<=4500){
			tax = taxSalary*0.1-105; //8000工资
		}
		else if(taxSalary<=9000){
			tax = taxSalary*0.2-555; //12500工资
		}
		else if(taxSalary>35000){
			tax = taxSalary*0.25-1005; //31500工资
		}
		System.out.println("纳税金额为:"+tax);
	}
}
