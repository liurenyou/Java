package se;

import java.util.Calendar;
import java.util.Date;

/**
 * Calendar是一个抽象类，规定了操作时间的相关方法
 * 常用实现类为：GregorianCalendar（阳历）
 * 在实例化时可以使用静态方法：getInstance,并且会根据当前系统所在地区
 * 返回一个常用的实现类，大部分地区都是阳历，且默认表示当前系统时间
 * @author liurenyou
 *
 */
public class CalendarDemo {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);//toString内容较多，不能看出具体时间
		Date date = calendar.getTime();//Calendar --> Date
		System.out.println("date:"+date);
		calendar.setTime(date);//可以利用calendar的setTime方法来设置Calendar时间 Date-->Calendar
		
		/*
		 * void set(int field,int value)
		 * 将给定时间分量以及对应的值设置到当前calendar中
		 */
		//输出2008年8月8日
		System.out.println("now:"+calendar.getTime());
		calendar.set(Calendar.YEAR, 2008);
		calendar.set(Calendar.MONTH, Calendar.AUGUST);
		calendar.set(Calendar.DAY_OF_MONTH, 8);
		System.out.println("after:"+calendar.getTime());
		//输出当周的周二
		calendar.set(Calendar.DAY_OF_WEEK, 3);//当周的周二（默认国外每周第一天是周日）
		System.out.println("当周的周二："+calendar.getTime());
		calendar.setTime(date);//还原设置的时间
		
		/*
		 * 利用：int get(int field)方法可以获取给定时间分量的对应时间
		 */
		int year = calendar.get(Calendar.YEAR);//获取年
		int month = calendar.get(Calendar.MONTH)+1;//月份是从0开始计算的 0-11
		int day = calendar.get(Calendar.DAY_OF_YEAR);//一年中的第几天
		System.out.println(year+"年"+month+"月第"+day+"天");

		int hour = calendar.get(Calendar.HOUR_OF_DAY);//获取小时（24小时制）
		int min = calendar.get(Calendar.MINUTE);//获取分钟
		int sec = calendar.get(Calendar.SECOND);//获取秒
		System.out.println(hour+":"+min+":"+sec);
		//输出当前日期是周几
		int dow = calendar.get(Calendar.DAY_OF_WEEK)-1;
		String[] week = {"日","一","二","三","四","五","六"};
		System.out.println("今天周"+week[dow]);
		
		/*
		 * int getActualMaximum(int field)
		 * 获取给定时间分量所允许的最大值
		 */
		int days = calendar.getActualMaximum(Calendar.DATE);//当月共有多少天
		System.out.println("当月共有："+days+"天");
		days = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);//当年共有多少天
		System.out.println("今年共有："+days+"天");
		
		/*
		 * void add(int field,int value)
		 * 使当前Calendar对给定的时间分量累加减给定的值
		 */
		//看10年10个月10天后的今天是哪一天
		calendar.add(Calendar.YEAR, 10);
		calendar.add(Calendar.MONTH, 10);
		calendar.add(Calendar.DAY_OF_YEAR, 10);
		System.out.println("10年10个月10日后的今天："+calendar.getTime());
	}
}
