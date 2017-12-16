package Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 要求：输入员工入职日期（yyyy-MM-dd） 计算转正日期：入职后3个月后当周的星期5 输出转正日期（yyyy-MM-dd）
 * 
 * @author liurenyou
 *
 */
public class RegularWorker {
	public static void main(String[] args) {
		while (true) {
			System.out.println("请输入员工的入职日期（xxxx-xx-xx）：");
			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date entry = sdf.parse(input);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(entry);
				calendar.add(Calendar.MONTH, 3);
				calendar.set(Calendar.DAY_OF_WEEK, 6);
				Date regular = calendar.getTime();
				String output = sdf.format(regular);
				System.out.println("转正日期：" + output);
			} catch (ParseException e) {
				System.out.println("请按正确格式输入！");
			}
		}
	}
}
