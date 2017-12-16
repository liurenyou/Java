package se;
/**
 * 聊天室服务端
 * @author liurenyou
 *
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	/*
	 * ServerSocket是用来向系统申请服务端口
	 * 监听服务端口，以接受客户端的连接
	 */
	private ServerSocket server;
	
	public Server() throws Exception {
		/*
		 * 创建时申请服务端口，不能与系统中的其它应用程序已使用的
		 * 端口发生冲突，否则会抛出AddressAlreadyInUser的错误
		 */
		try {
			server = new ServerSocket(8088);
		} catch (Exception e) {
			System.out.println("服务端初始化失败");
			throw e;
		}
	}
	public void start() {
		/*
		 * ServerSocket的accept方法是一个阻塞方法，作用是监听申请
		 * 的服务端口直到一个客户端通过该端口与服务器建立连接，accept
		 * 方法才会执行完毕，并返回一个Socket实例，通过这个Socket可以
		 * 与刚刚建立连接的客户端进行交互
		 */
		System.out.println("等待客户点连接...");
		try {
			Socket socket = server.accept();
			System.out.println("一个客户端连接了");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		try {
			Server server = new Server();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
