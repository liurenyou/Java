package se;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

/**
 * File
 * File的每一个实例用于表示文件系统中的一个文件或目录
 * @author liurenyou
 *
 */
public class FileDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 访问其表示的文件或目录的属性(名字、大小、权限等)
		 * 操作文件或目录(创建、删除)
		 * 访问目录的所有子项
		 * 
		 * 系统默认文件分割符号，避免系统差异
		 * File.separator()
		 */
		String address = "."+File.separator+"demo.txt";
		File file = new File(address);
		
		String name = file.getName();
		System.out.println("文件名:"+name);
		
		long length = file.length();
		System.out.println("大小:"+length);
		
		boolean cr = file.canRead();
		System.out.println("是否可读:"+cr);
		
		boolean cw = file.canWrite();
		System.out.println("是否可写:"+cw);
		
		boolean ih = file.isHidden();
		System.out.println("是否隐藏:"+ih);
		
		/*
		 * 创建新文件
		 * boolean createNewFile()
		 * 若在当前目录下创建文件，可以忽略"./"
		 */
		address = "./test.txt";
		File file2 = new File(address);
		/*
		 * boolean exists()
		 * 判断当前File表示d额文件或目录是否真实存在，存在则返回true
		 */
		if(!file2.exists()) {
			file2.createNewFile();
			System.out.println("创建新文件");
		}else {
			System.out.println("该文件已存在");	
		}
		
		/*
		 * 删除文件
		 * boolean delete()
		 */
		if(file2.exists()) {
			file2.delete();
			System.out.println("已删除该文件");
		}else {
			System.out.println("未找到该文件");
		}
		
		/*
		 * 创建一个目录
		 * boolean mkdir()
		 */
		address = "demo";
		File dir = new File(address);
		if(!dir.exists()) {
			dir.mkdirs();
			System.out.println("创建新目录");
		}else {
			System.out.println("该目录已存在");
		}
		/*
		 * 可以创建多级目录
		 */
		address = "a"+File.separator+
					"b"+File.separator+
					"c"+File.separator+
					"d"+File.separator;
		File dir2 = new File(address);
		if(!dir2.exists()) {
			dir2.mkdirs();
			System.out.println("创建新目录");
		}else {
			System.out.println("该目录已存在");
		}
		
		/*
		 * 删除目录
		 * 前提必须是空目录
		 */
		if(dir.exists()) {
			dir.delete();
			System.out.println("已删除");
		}
		if(dir2.exists()) {
			dir2.delete();
			System.out.println("已删除");//其实未删除
		}
		
		/*
		 * 获取当前目录中的所有子项
		 * File[] lastFiles()
		 */
		address = ".";
		File dirs = new File(address);
		/*
		 * 判断当前File是文件还是目录
		 * boolean isDirectory()
		 * boolean isFile()
		 */
		if(dirs.isDirectory()) {
			File[] subs = dirs.listFiles();
			for(File sub : subs) {
				System.out.print(sub.isDirectory() ? "目录:" : "文件:");
				System.out.println(sub.getName());
			}
		}
		/*
		 * FileFilter
		 * 文件过滤器，是一个接口,使用匿名内部类实现文件的过滤
		 */
		if(dirs.isDirectory()) {
			FileFilter filter = new FileFilter(){
				@Override
				public boolean accept(File f) {
					System.out.println("正在过滤:"+f.getName());
					return f.isFile();
				}
			};
			File[] subs = dirs.listFiles(filter);
			for(File sub : subs) {
				System.out.println("文件:"+sub.getName());
			}
		}
		
		/*
		 * 利用递归法将给定的文件或目录删除
		 */
		address = "a";
		File dfile = new File(address);
		delete(dfile);
	}
	public static void delete(File f) {
		if(f.isDirectory()) {
			File[] subs = f.listFiles();
			for(File sub : subs) {
				delete(sub);	//利用递归进入目录搜寻所有子项
			}
		}
		f.delete();
	}
}