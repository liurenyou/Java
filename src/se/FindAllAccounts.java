package se;

import java.io.IOException;
import java.util.regex.Pattern;

/*
 * 找出文件中的所有email账号
 */
public class FindAllAccounts {
	private final static Pattern emailer = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+");
	
	public static void main(String[] args) throws IOException {
		
	}
}
