package Test;

import java.util.Scanner;

/**
 * 猜字符游戏
 * 
 * @author liurenyou
 *
 */
public class GuessingGame {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] chs = generate();
		System.out.println(chs);
		int count = 0;
		while (true) {
			System.out.println("猜吧！");
			String str = scan.next().toUpperCase();
			if (str.equals("EXIT")) {
				System.out.println("下次再来吧！");
				break;
			}
			char[] input = str.toCharArray();
			int[] result = check(chs, input);
			if (result[1] == chs.length) {
				int score = 100 * chs.length - 10 * count;
				System.out.println("恭喜猜对了！得分是：" + score);
				break;
			} else {
				count++;
				System.out.println("字符对个数：" + result[0] + "位置对个数：" + result[1]);
			}
		}
	}

	public static char[] generate() {
		char[] chs = new char[5];
		char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'G', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
				'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		boolean[] flags = new boolean[letters.length];
		for (int i = 0; i < chs.length; i++) {
			int index;
			do {
				index = (int) (Math.random() * letters.length);
			} while (flags[index]);
			chs[i] = letters[index];
			flags[index] = true;
		}
		return chs;
	}

	public static int[] check(char[] chs, char[] input) {
		int[] result = new int[2];
		for (int i = 0; i < chs.length; i++) {
			for (int j = 0; j < input.length; j++) {
				if (chs[i] == input[j]) {
					result[0]++;
					if (i == j) {
						result[1]++;
					}
					break;
				}
			}
		}
		return result;
	}
}
