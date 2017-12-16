package se;
/**
 * 聊天客户端
 * @author liurenyou
 *
 */

import java.net.Socket;

public class Client {
	/*
	 * 套接字 底层封装TCP协议，使用其进行网络通讯
	 */
	private Socket socket;

	/*
	 * 构造方法，用来初始化客户端
	 */
	public Client() throws Exception {
		/*
		 * 实例化Sockte时需要传入两个参数 
		 * 参数一:服务端的IP地址 参数二:服务端的端口号
		 * 通过IP可以连接到服务端计算机，通过端口连接到运行在服务端计算机的 服务应用程序
		 * 创建Socket的过程就是连接过程，所以服务器没有响应时这里会抛出异常
		 */
		try {
			System.out.println("正在连接服务器...");
			socket = new Socket("localhost", 8088); // "localhost"是默认IP地址为本地计算机的意思
			System.out.println("已连接服务器");
		} catch (Exception e) {
			System.out.println("连接失败");
			throw e;
		}
	}

	/*
	 * 启动客户端
	 */
	public void start() {
	}

	public static void main(String[] args) {
		try {
			Client c = new Client();
			c.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
