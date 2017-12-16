package se;
/**
 * char charAt(int index)
 * 返回给定位置上的字符
 * @author liurenyou
 *
 */
public class CharAt {
	public static void main(String[] args) {
		String str = "helloword";
		//第5个字符
		char c = str.charAt(4);
		System.out.println(c);
		
		/*
		 * 检查回文：
		 * 检查正数位置上的字符是否与倒数上的字符一致
		 */
		String s = "上海自来水来自海上";
		for(int i=0;i<s.length()/2;i++) {
			if(s.charAt(i)!=s.charAt(s.length()-i-1)) {
				System.out.println("不是回文");
				/*
				 * 方法返回值为void时，return可作为结束方法单独使用
				 */
				return;
			}
		}
		System.out.println("是回文");
	}
}
