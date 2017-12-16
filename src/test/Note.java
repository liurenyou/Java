package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * 简易记事本 
 * 要求: 
 * 程序启动后要求用户输入文件名，然后在当前文件目录中创建该文件
 * 之后用户输入的每一行字符串都写入到该文件中，当输入"exit"时退出，
 * 还要求有续写功能
 * 
 * @author liurenyou
 *
 */
public class Note {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入文件名(xxxx.xxx):");
		/*
		 * PrintWriter的第一个参数为流时，则第二个参数为"true"时可以
		 * 自动刷新，每当println写出时自动"flush"，但print时不刷新
		 */
		try {
			String fileName = scan.nextLine();
			File f = new File(fileName);
			if (f.exists()) { 	// 确认输入的文件名是否存在，并提醒用户
				System.out.println("请继续写作(退出请输入\"exit\"):");
			} else {
				System.out.println("已创建新文件:" + fileName + " 请开始写作(退出请输入\"exit\"):");
			}
			PrintWriter pw = new PrintWriter(
					new OutputStreamWriter(
							new FileOutputStream(fileName, true	// 如果文件名相同则增加续写功能
									), "UTF-8" 
							), true	//增加自动刷新功能
					);
			String line = null;
			while(true) {
				line = scan.nextLine();
				if("exit".equals(line)) {
					System.out.println("已退出!");
					break;
				}
				pw.println(line);
			}
			pw.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
