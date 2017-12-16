package Test;

import java.util.Scanner;

/**
 * 猜数字游戏
 * 
 * @author liurenyou
 *
 */
public class GuessNum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int guess = (int) (Math.random() * 1000 + 1);
		int n;

		do {
			System.out.println("猜吧！");
			n = scan.nextInt();
			if (n == 0) {
				break;
			} else if (n > guess) {
				System.out.println("猜大了");
			} else if (n < guess) {
				System.out.println("猜小了");
			}
		} while (n != guess);
		if (n != 0) {
			System.out.println("恭喜猜对了");
		} else {
			System.out.println("下次再来吧");
		}
	}
}
