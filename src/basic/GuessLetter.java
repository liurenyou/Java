package basic;

import java.util.Scanner;

public class GuessLetter {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] chs = generate();
		System.out.println(chs);//作弊
		int count = 0;
		System.out.println("猜字游戏,总共5个不重复的字母,不区分大小写,退出游戏请输入EXIT");
		while(true){
			String str = scan.next().toUpperCase();
			if(str.equals("EXIT")){
				System.out.println("下次再来吧!");
				break;
			}
			char[] input = str.toCharArray();
			int[] result = check(chs,input);
			if(result[1]==chs.length){
				int score = 100-count*10;
				System.out.println("恭喜您猜对了,您的总得分为:"+score);
			}else{
				count++;
				System.out.println("您猜对了"+result[0]+"个字母,其中"+result[1]+"个字母的位置正确"+",继续加油!");
			}
		}
	}
	public static int[] check(char[] chs,char[] input){
		int[] result = new int[2];
		for(int i=0;i<chs.length;i++){
			for(int j=0;j<input.length;j++){
				if(chs[i] == input[j]){
					result[0]++;
					if(i==j){
						result[1]++;
					}
				}
			}
		}
		return result;
	}
	public static char[] generate() {
		char[] chs = new char[5];
		char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R','S', 'T', 'U', 'V', 
				'W', 'X', 'Y', 'Z' };
		boolean[] flags = new boolean[letters.length];
		for(int i=0;i<chs.length;i++){
			int index;
			do{
				index = (int)(Math.random()*letters.length);
			} while(flags[index]);
			chs[i] = letters[index];
			flags[index] = true;
		}
		return chs;
	}
}
