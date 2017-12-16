package se;
/**
 * boolean startsWith(String str)
 * boolean endsWith(String str)
 * 判断当前字符串是否以给定字符串开始或结束的
 * @author liurenyou
 *
 */
public class StartsWith {
	public static void main(String[] args) {
		String str = "thinking in java";
		boolean starts = str.startsWith("thi");
		System.out.println(starts);
		boolean ends = str.endsWith("java");
		System.out.println(ends);
	}
}
