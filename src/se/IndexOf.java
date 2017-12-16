package se;
/**
 * int indexOf(String str)
 * 查询给定字符串在当前字符串中的位置
 * @author liurenyou
 *
 */
public class IndexOf {
	public static void main(String[] args) {
		String str = "thinking in java";
		//查找in的位置
		int index = str.indexOf("in");
		System.out.println("index:"+index);
		//从指定位置开始找
		index = str.indexOf("in", 3);
		System.out.println("index:"+index);
		//找最后一次出现的位置
		index = str.lastIndexOf("in");
		System.out.println("index:"+index);
		/*
		 * 若找不到则返回值-1
		 */
		index = str.indexOf("o");
		System.out.println("index:"+index);
	}
}
