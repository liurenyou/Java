package se;

import java.util.Date;

/**
 * java.util.Date
 * Date的每一个实例用于表示一个时间，其内部维护一个long值，
 * 该值表示自1970年元旦到当前Date表示的时间中间所经过的毫秒差，
 * 由于Date设计存在缺陷，所以大部分的时间相关操作都为过时的，
 * 现在Date通常仅用作表示一个时间，不做其他操作
 * @author liurenyou
 *
 */
public class DateDemo {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		//获取当前Date内部维护的long值，并增加一天的毫秒数之后输出
		long time = date.getTime();
		time += 1000*60*60*24;//增加1天的毫秒数
		date.setTime(time);
		System.out.println(date);
	}
}
