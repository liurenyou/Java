package Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 复制文件
 * @author liurenyou
 *
 */
public class CopyDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 利用随机读写流复制文件:
		 * 1.实例化原文件
		 * 2.实例化一个新文件等待复制原文件
		 * 3.循环将原文件中每个字节读取出来并写入到复制文件中
		 * 4.关闭所有流完成复制操作
		 */
		RandomAccessFile src = new RandomAccessFile("raf.dat","r");
		RandomAccessFile dsrc = new RandomAccessFile("draf.dat", "rw");
		
		int i = -1; //用于保存读取的每个字节	
		long start = System.currentTimeMillis();
		while((i=src.read())!=-1) {
			dsrc.write(i);
		}
		long end =	System.currentTimeMillis();
		System.out.println("复制完毕,用时"+(end-start)+"ms");
		/*
		 * 可以通过提高每次读取数据量来减少读取次数，提高读取速度
		 */
		RandomAccessFile desc2 = new RandomAccessFile("draf2.dat", "rw");
		/*
		 * int read(byte[] d)
		 * 一次性长度读取给定字节数组lengthd的字节量并存入到数组中，
		 * 返回值为实际读取到的字节量，直到-1结束
		 */
		byte[] buf = new byte[1024*10];	//10k
		start = System.currentTimeMillis();
		while((i=src.read(buf))!=-1) {
			/*
			 * void write(byte[] b)
			 * 将给定的字节数组中所有字节一次性写出
			 * 
			 * void write(byte[] b,int offset,int len)
			 * 将给定数组从下标为offset处的字节开始连续的len个字节写出
			 */
			desc2.write(buf,0,i);
		}
		end =	System.currentTimeMillis();
		System.out.println("复制完毕,用时"+(end-start)+"ms");
		
		src.close();
		dsrc.close();
		desc2.close();
		
		/*
		 * 利用文件流复制文件:
		 * 1.创建文件输入流读取原文件
		 * 2.创建文件输出流写入复制文件
		 * 3.循环将原文件中每个字节读取出来写入到复制文件中
		 * 4.关闭所有流完成复制操作
		 */
		FileInputStream fis = new FileInputStream("fos.dat");
		FileOutputStream fos = new FileOutputStream("dfos.dat");
		int len = -1;
		byte[] data2 = new byte[1024*10];	//10倍
		while((len=fis.read(data2))!=-1) {
			fos.write(data2,0,len);
		}
		System.out.println("复制完毕");
		
		fis.close();
		fos.close();
	}
}
