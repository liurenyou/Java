package se;
/**
 * String正则表达式：
 * 正则表达式的类在：java.util.regex包中，包括三个类：Pattern Matcher PatternSyntaxException
 *   Pattern：已编译版本，没有任何公共构造器，通过传递一个正则表达式参数给公共静态方法compile
 * 来创建一个Pattern对象
 *   Matcher：用来匹配输入字符串和创建pattern对象的正则引擎对象，没有公共构造器，需要通过pattern对象的
 * matcher方法，使用输入字符串作为参数来获得一个Matcher对象，然后使用matches方法，通过返回的布尔值判
 * 断输入字符串是否与正则表达式匹配
 *   PatternSyntaxException：正则语法出现错误将抛出异常
 * 
 * 基本通配符：
 * .  -可匹配任意字符
 * \s -代表一个任意空白（空格、Tab）:[\t\n\x0B\f\r]
 * \S -代表任意一个非空白:[^\s]
 * \d -代表一个任意数字:[0-9]
 * \D -代表任意一个非数字:[^0-9]
 * \w -代表一个单词字符:[a-zA-Z_0-9]
 * \W -代表任意一个非单词字符:[^\w]
 * 注意：特殊字符使用时需要转义
 * 
 * 取值范围：
 * ? -代表它前面的东西可以出现0~1次
 * * -代表它前面的东西可以出现0~N次
 * + -代表它前面的东西可以出现1~N次
 * {n,m} -可以出现n~m次
 * {n,} -至少出现n次
 * {,m} -最多出现m次
 * {n} -必须出现n次
 * 
 * 边界匹配器：
 * ^ -行的开头
 * $ -行的结尾
 * \b -单词边界
 * \B -非单词边界
 * \A -输入的开头
 * \G -上一个匹配的结尾
 * \Z -输入的结尾，仅用于最后的结束符
 * \z -输入的结尾
 * @author liurenyou
 *
 */
public class Regex {
	public static void main(String[] args) {
		/*
		 * 使用给定的正则表达式验证当前字符串的格式是否正确
		 * [a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\.[a-zA-Z]+)+
		 */
		String mail = "1234@qq.com";
		String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z]+)+";
		boolean match = mail.matches(regex);
		if(match) {
			System.out.println("格式正确");
		}else {
			System.out.println("格式有误");
		}
		System.out.println("".matches("a+"));
		
		/*
		 *将给定字符串中按照满足给定正则表达式的补分进行拆分，
		 *然后将拆分的内容以一个数组的形式返回（保留所有字母部分）
		 */
		String str = "abc123def56ghi789jml";
		String[] array = str.split("[0-9]+");
		System.out.println("共拆分出："+array.length+"项");
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
		
		String imgName = "1.jpg";//将照片按系统时间加照片格式的格式储存起来，方便区分
		String[] name = imgName.split("\\.");
		imgName = System.currentTimeMillis()+"."+name[1];
		System.out.println(imgName);
		
		/*
		 * 将当前字符串中满足给定正则表达式的部分替换掉
		 * 还可以按照给定字符串替换：
		 * String regex = "(xxxx|xx|xxxxx|XXX)"
		 */
		String str2 = "123hhk241kvv4f14g1h2g4";
		str2 = str2.replaceAll("\\d+", "#NUMBER#");
		System.out.println(str2);
	}
}
