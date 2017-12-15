package com.example.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/**
 模拟一个聊天的例子
 发送线程

 */
public class Demo2Sender extends Thread{
	boolean tag=true;
	@Override
	public void run() {
		DatagramSocket socket=null;
		try {
			while(tag){
				String data=getData();   //发送的数据
				socket=new DatagramSocket();   //整个码头
				DatagramPacket packet=new DatagramPacket(data.getBytes(),data.getBytes().length,InetAddress.getLocalHost(),9000);  //打包
				socket.send(packet);
				if(data.equals("拜拜")){
					tag=false;
				}
			}
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取控制台的那个数据
	 * @return
	 * @throws IOException
	 */
	private String getData() throws IOException {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		String line;
		line=reader.readLine();
		return line;
	}
}
