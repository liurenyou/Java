package test;

/**
 * 1块钱1瓶水，2个瓶子换1瓶水，3个瓶盖换1瓶水，20块钱能买多少瓶水
 * 
 * @author liurenyou
 *
 */

public class BottleCap {
	public static void main(String[] args) {
		int m = 20;
		System.out.println(test(m, 0, 0));
	}

	public static int test(int m, int b, int c) {
		if (b < 2 && c < 3 && m == 0) {
			return 0;
		}
		return m + test(b / 2 + c / 3, m + b % 2, m + c % 3);
	}
}
