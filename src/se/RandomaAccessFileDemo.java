package se;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 基于指针的形式读写文件数据
 * 
 * @author liurenyou
 *
 */
public class RandomaAccessFileDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 两种常用模式:1.只读模式 "r" 2.读写模式 "rw"
		 * 常用构造方法:
		 * RandomAccessFile(String path,String mode)
		 * RandomAccessFile(File file,String mode)
		 */
		RandomAccessFile raf = new RandomAccessFile("raf.dat","rw");
		
		/*
		 * void write(int d)
		 * 向硬盘写出数据只能是2进制信息,该方法只能写出1个字节，
		 * 会将int值对应的2进制的"低八位"写出
		 */
		raf.write(66);
		System.out.println("写出完毕");
		/*
		 * 每次使用完文件流后都需要关闭，否则会一直开启占并增加系统负担
		 */
		raf.close();
		
		/*
		 * 读取文件数据
		 * int read()
		 * 从文件中读取第一个字节，并以10进制int值返回，
		 * 当返回值为"-1"时表示读取到了文件末尾
		 */
		RandomAccessFile rafd = new RandomAccessFile("raf.dat","r");
		int d = rafd.read();
		System.out.println(d);
		rafd.close();
		System.out.println();
		
		/*
		 * RandomAccessFile提供了便于读写基本类型数据的相关方法
		 * 以及指针操作
		 */
		RandomAccessFile rafp = new RandomAccessFile("raf.dat","rw");
		System.out.println("pos:"+rafp.getFilePointer());
		/*
		 * 写出int最大值
		 */
		int max = Integer.MAX_VALUE;
		System.out.println(max);
		rafp.write(max>>>24);
		System.out.println("pos:"+rafp.getFilePointer());
		rafp.write(max>>>16);
		rafp.write(max>>>8);
		rafp.write(max);
		System.out.println("pos:"+rafp.getFilePointer());
		rafp.writeInt(max);
		System.out.println("pos:"+rafp.getFilePointer());
		rafp.writeLong(123L);
		System.out.println("pos:"+rafp.getFilePointer());
		rafp.writeDouble(123.123);
		System.out.println("pos:"+rafp.getFilePointer());
		System.out.println();
		/*
		 * void seek(long pos)
		 * 将指针移动到指定位置
		 */
		rafp.seek(0);
		System.out.println("pos:"+rafp.getFilePointer());
		int i = rafp.readInt();
		System.out.println(i);
		System.out.println("pos:"+rafp.getFilePointer());
		i = rafp.readInt();
		System.out.println(i);
		System.out.println("pos:"+rafp.getFilePointer());
		Long l = rafp.readLong();
		System.out.println(l);
		System.out.println("pos:"+rafp.getFilePointer());
		rafp.seek(16);
		double db = rafp.readDouble();
		System.out.println(db);
		System.out.println("pos:"+rafp.getFilePointer());
		rafp.seek(0);
		l = rafp.readLong();
		System.out.println(l);
		
		rafp.close();
	}
}
