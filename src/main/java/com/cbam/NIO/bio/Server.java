package com.cbam.NIO.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	final static int PROT = 8765;
	
	public static void main(String[] args) {
		
		ServerSocket server = null;
		try {
			server = new ServerSocket(PROT);
			System.out.println(" server start .. ");
			//进行阻塞
		while(true) {
			Socket socket = server.accept();
			System.out.println("开始睡眠");
			//睡眠 我想看看多个客户端连接 在前一个客户端没有处理完成之前  当前客户端连接是否会阻塞
			Thread.sleep(10000);
			//新建一个线程执行客户端的任务
			new Thread(new ServerHandler(socket)).start();
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(server != null){
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			server = null;
		}
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
