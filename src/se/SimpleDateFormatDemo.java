package se;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * java.text.SimpleDateFormat
 * 该类可以使Date类型与String类型之间相互转换，而Calendar类型想要与
 * String类型转换只需要借助Date类型即可
 * @author liurenyou
 *
 */
public class SimpleDateFormatDemo {
	public static void main(String[] args) throws ParseException {
		Date now = new Date();//当前系统时间
		System.out.println("当前系统时间："+now);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//转换时间的格式
		/**
		 * Date与String之间转换
		 */
		//String format(Date date) Date --> String
		String str = sdf.format(now);
		System.out.println("Date-->String:"+str);
		
		//Date parse(String str) String --> Date
		String str2 = "2008-08-08 20:08:08";
		Date date = sdf.parse(str2);//为避免字符串不符合时间格式，此处需要抛异常
		System.out.println("String-->Date:"+date);
		
		/**
		 * Calendar与String之间转换
		 */
		//String format(Date date) Calendar --> String
		Calendar calendar = Calendar.getInstance();
		String str3 = sdf.format(calendar.getTime());//括号里为Date类型
		System.out.println("Calendar-->String:"+str3);
		
		//Date parse(String str) String --> Calendar
		String str4 = "2008-08-08 20:08:08";
		Date date2 = sdf.parse(str4);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date2);
		System.out.println("String-->Calendar:"+calendar2.getTime());
	}
}
