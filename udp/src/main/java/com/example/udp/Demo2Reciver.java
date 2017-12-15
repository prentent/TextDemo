package com.example.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 接受线程
 */
public class Demo2Reciver extends Thread{
	boolean tag=true;
	@Override
	public void run() {
		DatagramSocket socket=null;
		while(tag){
			try {
				socket=new DatagramSocket(9000);
				byte[] buf=new byte[1024];
				DatagramPacket packet=new DatagramPacket(buf,buf.length);
				socket.receive(packet);
				String data=new String(buf,0,packet.getLength());
				System.out.println(packet.getAddress().getHostAddress()+"说:"+data);
				if(data.equals("拜拜")){
					tag=false;
				}
			} catch (SocketException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				socket.close();
			}
		}
	}
}
