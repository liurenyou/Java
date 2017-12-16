package Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 要求按照给定格式(yyyy-MM-dd)输入自己的生日，然后经过运算算出迄今为止自己活了多少天，
 * 距离10000天的纪念日还差多少天，并输出该纪念日的日期，格式为：xxxx年xx月xx日
 * 
 * @author liurenyou
 *
 */
public class MemorialDay {
	public static void main(String[] args) {
		while (true) {
			// 输入生日
			System.out.println("请输入自己的生日，中间用'-'隔开（xxxx-xx-xx）：");
			Scanner scan = new Scanner(System.in);
			String birthday = scan.nextLine();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date now = new Date();// 现在的时间
			try {
				// 计算存活天数
				Date birth = sdf.parse(birthday);
				long survival = (now.getTime() - birth.getTime()) / 1000 / 60 / 60 / 24;
				System.out.println("祝贺，迄今为止您已经存活了" + survival + "天！");
				System.out.println("距离10000天纪念日还有" + (10000 - survival) + "天！");
				// 计算纪念日日期
				Date mem = new Date();
				mem.setTime(birth.getTime() + 1000 * 60 * 60 * 24 * 10000L);// 此处计算不加L会因溢出而计算出错
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
				String output = sdf2.format(mem);
				System.out.println("您的10000天纪念日在 " + output);
				break;
			} catch (ParseException e) {
				System.out.println("请按正确格式输入!");
			}
		}
	}
}
