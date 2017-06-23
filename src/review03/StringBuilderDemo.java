package review03;

public class StringBuilderDemo {
	public static void main(String[] args) {

		String str = "好好复习";
		StringBuilder builder = new StringBuilder(str);
		str = builder.toString();

		builder.append(",为了尽快找到好工作");
		System.out.println(builder.toString());//添加

		builder.replace(5, 14, "为了面试");
		System.out.println(builder.toString());//替换

		builder.insert(0, "赶快");
		System.out.println(builder.toString());//插入
		
		builder.reverse();
		System.out.println(builder.toString());//反转

	}
}
