package se;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import entity.Person;

/**
 * 流 
 * 根据方向:可分为输入流与输出流 输入流用来读取数据 输出流用来写出数据
 * 流的方向基于程序作为参照方向，输入是从外界进入程序的方向，所以是读操作，而写操作则相反
 * 
 * 根据处理的数据单位:可分为字节流(低级流)与字符流(高级流)
 * 
 * 根据功能:可分为节点流(低级流)与处理流(高级流) 读写一定要有节点流 节点流是实际负责搬运数据的流，数据源明确
 * 处理流是用来处理其它流的，可以基于其处理的流对数据进行加工，从而简化我们的读写操作
 * 
 * 所有内存中的流都是高端流(InputStreamReader...),所有的外界的设备中的流都是低端流(InputStream...)
 * @author liurenyou
 *
 */
public class StreamDemo {
	public static void main(String[] args) throws IOException, Exception {
		/*
		 * 文件流(字节流)(节点流)
		 * 文件流是一对低级流，数据源为文件 
		 * 文件输出流FileOutputStream继承自OutputStream 作用是向文件中写出数据
		 * 文件输入流FileInputStream继承自InputStream 作用是从文件中读取数据
		 * 
		 * 文件输出流(FileOutputStream)
		 * 创建有两种方式: 
		 * 1.覆盖写操作:创建针对文件的输出流后，会先将该文件中的所有数据清除， 然后通过该流写出数据
		 * 2.追加写操作:多传入一个boolean值参数，当该参数为true时，则追加写操作，false则还是覆盖
		 * 写操作(追加写操作是接着文件末尾开始本次写操作)
		 */
		// FileOutputStream fos = new FileOutputStream("fos.dat"); //覆盖写操作
		FileOutputStream fos = new FileOutputStream("fos.dat", true); // 追加写操作
		String str = "今晚吃火锅!";
		/*
		 * String提供了将当前字符串内容转换成一组字节的方法 byte[] getBytes(String csn)
		 * 根据指定的字符集将字符串转换为一组字节
		 */
		byte[] data = str.getBytes("UTF-8");
		fos.write(data);
		System.out.println("写出完毕");

		fos.close(); // 使用完流一定记得关闭，释放底层资源
		/*
		 * 文件输入流(FileInputStream)
		 */
		FileInputStream fis = new FileInputStream("fos.dat");
		data = new byte[100];
		int len = fis.read(data);	//用于保存读取的每个字节
		str = new String(data, 0, len, "UTF-8");
		System.out.println(str);

		fis.close();
		
		/*
		 * 字符流(节点流)
		 * Reader与Write
		 * 特点是以字符为单位读写数据，但由于底层读写还是字节，所以字符流只是简化了
		 * 我们在字符串与字节之间的转换工作
		 * 
		 * 字符输出流(OutputStreamWrite) 
		 */
		FileOutputStream fos2 = new FileOutputStream("osw.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos2, "GBK");
		osw.write("不想吃火锅!");
		osw.write("吃铁板烧吧!");
		System.out.println("写出完毕");
		
		osw.close();	//嵌套关系流只需要关闭最外层流，会自动调放法关闭内层流
		/*
		 * 字符输入流(InputStreamReader)
		 */
		FileInputStream fis2 = new FileInputStream("osw.txt");
		InputStreamReader isr = new InputStreamReader(fis2,"GBK");
		int len2 = -1;
		while((len2=isr.read())!=-1) {
			System.out.print((char)len2);	//需要把返回的int值转换成对应的字符
		}
		
		isr.close();
		
		/*
		 * 缓冲流(处理流)
		 * 对读写数的数据提供了缓冲功能，每次读或写都先存入缓存区，存满后再将数据写入最
		 * 终介质中，也可以利用flush()方法提前写入，减少了读写次数，提高了读写速率，要
		 * 套接在相对应的节点流上使用
		 * 
		 *缓冲字节输出流(BufferedOutputStream)
		 */
		FileOutputStream fos3 = new FileOutputStream("bos.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos3);
		str = "那就吃铁板烧吧!";
		bos.write(str.getBytes("UTF-8"));
		/*
		 * flush()方法会强制将当前缓存区中的数据一次性写出
		 */
		bos.flush();
		System.out.println("写出完毕");

		bos.close();
		/*
		 * 缓冲字节输入流(BufferedInputStream)
		 */
		FileInputStream fis3 = new FileInputStream("bos.txt");
		BufferedInputStream bis = new BufferedInputStream(fis3);
		byte[] data2 = new byte[100];
		int len3 = bis.read(data2);
		str = new String(data2,0,len3,"UTF-8");
		System.out.println(str);
		
		bis.close();
		
		/*
		 * 缓冲字符输出流(PrintWrite)
		 * 可以按行写出字符串，并且具有自动刷新功能，但并没有续写功能，
		 * 每次运行都将删除内容重新写入
		 * 其内部的缓冲效果是靠BufferedWriter实现的
		 */
		PrintWriter pw = new PrintWriter("pw.txt","UTF-8");
		pw.println("就决定铁板烧了?");
		pw.println("恩!");
		System.out.println("写出完毕");
		
		pw.close();
		/*
		 * 如需要续写功能，可以用PrintWrite处理其它流完成
		 */
		FileOutputStream fos4 = new FileOutputStream("pw.txt",true);
		OutputStreamWriter osw2 = new OutputStreamWriter(fos4, "UTF-8");
		PrintWriter pw2 = new PrintWriter(osw2);
		pw2.println("我又想吃火锅了!");
		System.out.println("写出完毕");
		
		pw2.close();
		
		/*
		 * 缓冲字符输入流(BufferedReader)
		 * 可以按行读取字符串
		 */
		InputStream is = StreamDemo.class.getClassLoader()
				.getResourceAsStream("se/pw.txt");	//使用类加载器不能读取原程序
		//FileInputStream fis4 = new FileInputStream("pw.txt");
		InputStreamReader isr2 = new InputStreamReader(is,"UTF-8");
		BufferedReader br = new BufferedReader(isr2);
		/*
		 * String readLine()
		 * 一次性读取若干字符，直到读取换行符为止，然后将这些字符
		 * 以一个字符串返回，返回的字符串中不含有最后的换行符。
		 * 如果读取时发现是文件末尾则返回null
		 */
		String line = null;
		while((line=br.readLine())!=null) {
			System.out.println(line);
		}
		
		br.close();
		
		/*
		 * 对象流(处理流)
		 * 用于直接将对象写出
		 * 
		 * 对象输出流(ObjectOutputStream)
		 * 可以将任意对象写出，先将对象按照其结构转换为一组字节，然后通过其处理流的流写出
		 * 但要求对象必须实现Serializable接口来声明其是否可以序列化，否则不可使用
		 */
		Person p = new Person();
		p.setName("盖伦");
		p.setAge(25);
		p.setGender("男");
		
		List<String> otherInfo = new ArrayList<String>();
		otherInfo.add("草丛原住民");
		otherInfo.add("会旋转");
		otherInfo.add("大保健");
		p.setOtherInfo(otherInfo);
		FileOutputStream fos5 = new FileOutputStream("person.obj");
		ObjectOutputStream oos = new ObjectOutputStream(fos5);
		/*
		 * writeObject()
		 * 将给定d额对象先转换为一组字节，这个过程是对象序列化，然后将这一组字节
		 * 通过oos处理的流fos最终写入到目标文件中(硬盘上)，这个过程成为持久化
		 */
		oos.writeObject(p);
		System.out.println("写出完毕");
		
		oos.close();
		/*
		 * 对象输入流(ObjectInputStream)
		 * 将一组字节还原为对象，前提是读取的这一组字节应当是通过oos将一个对象
		 * 转换的，将一组字节还原成对象的过程叫:对象反序列化
		 */
		FileInputStream fis4 = new FileInputStream("person.obj");
		ObjectInputStream ois = new ObjectInputStream(fis4);
		Person p2 = (Person)ois.readObject();
		System.out.println(p2);
		
		ois.close();
	}
}
