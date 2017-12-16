package se;

import java.awt.AWTException;
import java.io.IOException;

/**
 * Throwable类是java语言中所有错误或异常的超类，他有两个子类：Error与Exception
 * 
 * Error
 * 合理的应用程序不应该试图捕获的严重问题，例如:VirtualMachineError 一般不用处理
 * 交给JVM即可
 * 
 * Exception(java.lang.Exception)
 * 合理应用程序想要捕获的条件，是Java中所有异常的直接或间接的父类,Exception还分两类:
 * 1.CheckedException:从语法角度讲要必须处理的异常，一般需要用try-catch捕获或通过throw
 * 直接抛出，否则程序无法编译通过(可以被Java编译器检查)
 * 2.UncheckedException(RuntimeException):一般是由程序逻辑错误导致的，一般会选择捕获，但如果
 * 不捕获也可以通过编译(无法被Java编译器检查)
 * 
 * @author liurenyou
 *
 */
public class ExceptionDemo {
	public static void main(String[] args) {
		System.out.println("程序开始!");
		/*
		 * 异常捕获(try-catch)
		 */
		try {	
			/*
			 * try这部分称为监控区域，若在该区域运行过程中出现异常，JVM则会自动创建异常对象，并抛出
			 * 监控区并试图寻找与之相匹配的catch子句，运行其中的异常处理，若未找到则会直接抛到控
			 * 制台显示
			 * (直接抛到控制台的显示内容是代码开始到出现错误的全部执行过程，相当于错误报告)
			 */
			String s = "a";
			String s2 = null;
			System.out.println(s.length());
			//System.out.println(s2.charAt(0));
			System.out.println(Integer.parseInt(s2));	//NumberFormatException
			/*
			 * try中若出现错误，则下面的代码将不会被执行，try外代码可以继续执行
			 */
			System.out.println("不会被执行");
		} catch (NullPointerException e) {
			/*
			 * catch用来匹配try中出现异常后定义解决异常的代码，catch可以定义多个，针对不同的异常
			 * 有多种解决方案，当捕获的异常中存在父子关系时，应当先捕获子类异常，后捕获父类异常，
			 * 并养成一个习惯，在最后一个catch中捕获Exception，这样可以避免try中代码出现未捕获异
			 * 常而中断
			 */
			e.printStackTrace();	//输出错误堆栈信息，有助于调整错误
			System.out.println(e.getMessage());
			System.out.println("空指针异常");
		} catch (StringIndexOutOfBoundsException e) {
			e.printStackTrace();	
			System.out.println(e.getMessage());
			System.out.println("字符串下标越界异常");
		} catch (Exception e) {
			e.printStackTrace();	
			System.out.println(e.getMessage());
			System.out.println("反正就是还有错");
		}
		/*
		 * finally块
		 * 必须定义在异常捕获机制的最后，finally可以保证无论try中是否有异常，一定会执行其中的代码
		 * 通常定义释放资源等操作，注意:finally中不要出现返回值(return)，否则程序抛出的异常将会被
		 * 吞噬，影响排错
		 */
		finally {
			System.out.println("finally块");
		}
		
		System.out.println("程序结束");
	}
}

/*
 * 异常抛出(throws)
 * 任何Java代码都可以通过throw语句抛出，如果一个方法可能会出现异常，但没有能力处理这种异常，可以在
 * 方法处用throws子句声明抛出异常，而该方法的调用者如果也没有能力处理异常则应该继续抛出
 * 
 * 
 * 重写父类含有throws的方法时必须遵循的规则: 
 * 1.重写时可以不再抛出任何异常
 * 2.可以仅抛出父类方法中的部分异常
 * 3.可以抛出父类方法中抛出异常的子类型异常
 * 4.不许抛出额外异常
 * 5.不许抛出父类抛出异常的父类异常
 */
class ThrowDemo {
	public void dosome() throws IOException,AWTException{
	}
	void method4() throws Exception{	//合法，IOException是Exception的子类
	}
}
class Son extends ThrowDemo {
//	public void dosome() {		//合法，重写时可以不再抛出任何异常
//	}
	public void dosome() throws IOException{	//合法，可以仅抛出父类方法中的部分异常
	}
//	public void dosome() throws FileNotFoundException{	//合法，可以抛出父类方法中抛出异常的子类型异常
//	}
//	public void dosome() throws SQLException{	//不合法，不许抛出额外异常
//	}
//	public void dosome() throws Exception {		//不合法，不许抛出父类抛出异常的父类异常
//	}
	
	/*
	 * 调用含有throws的方法时必须遵循的规则: 
	 * 1.如果是UncheckedException异常，即Error、RuntimeException或它们的子类，那么可以不使
	 * 用throws关键字来声明要抛出的异常，编译仍能顺利通过，但在运行时会被系统抛出
	 * 2.如果是CheckedException异常，则必须抛出或捕获，否则会编译错误
	 * 3.该方法的调用者必须处理或重新抛出该异常
	 * 4.调用方法必须遵循任何可查异常的处理和声明规则。若覆盖一个方法，则不能声明与覆盖方法不同的
	 * 异常。声明的任何异常必须是被覆盖方法所声明异常的同类或子类
	 */
//	void method() {		//编译错误，必须捕获或抛出
//		dosome();	
//	}
	void method2() throws IOException{	//合法，抛出同类异常
		dosome();
	}
	void method3() throws Exception {	//合法，IOException是Exception的子类
		dosome();
	}
	void method4() {	//合法，捕获了IOException
		try {
			dosome();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	void method5() {	//编译错误，必须捕获或声明抛出Exception
//		try {
//			dosome();
//		} catch (IOException e) {
//			throw new Exception();
//		}
//	}
	void method6() throws Exception{	//合法，声明抛出了Exception
		try {
			dosome();
		} catch (IOException e) {
			throw new Exception();
		}
	}
}

/*
 * 自定义异常
 * 通常用来说明业务逻辑的错误等，只需要继承Exception类即可
 * 大致分为以下几个步骤:
 * 1.创建自定义异常类
 * 2.在方法中通过throw关键字抛出异常对象
 * 3.如果在当前抛出异常的方法中处理异常，可以使用try-catch语句捕获并处理
 * 否则在方法的声明处通过throws关键字指明要抛出给方法调用者的异常
 * 4.在出现异常方法的调用者中捕获并处理异常
 */
class IllegalAgeException extends Exception	{
	private static final long serialVersionUID = 1L;
	/*
	 * 自动生成父类方法
	 */
	public IllegalAgeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
class Person {
	private int age;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws IllegalAgeException {	//方法中使用throw抛出异常时，该方法就要使用throws进行声明
		if(age<0||age>100) {								
			throw new IllegalAgeException("年龄不符");
		}
	}
	
	public static void main(String[] args) {
		Person p = new Person();
		try {
			p.setAge(101);
		} catch (IllegalAgeException e) {
			e.printStackTrace();
		}
		System.out.println("age:"+p.getAge());
	}
}
