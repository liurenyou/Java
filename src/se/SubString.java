package se;
/**
 * String substring(int start,int end)
 * 截取字符串
 * 从start开始，一直截取到end，但不包含end处对应的字符
 * （Java api的一个特点：通常用两个数字表示一个范围，都是“含头不含尾”）
 * @author liurenyou
 *
 */
public class SubString {
	public static void main(String[] args) {
		String str = "http://www.oracle.com";
		//截取oracle
		String sub = str.substring(11, 17);
		System.out.println(sub);
		
		sub = str.substring(11);
		System.out.println(sub);
		
		String url = "www.baidu.com";
		int start = url.indexOf(".")+1;
		int end = url.indexOf(".",start);
		//获取域名
		String name = url.substring(start,end);
		System.out.println(name);
	}
}
