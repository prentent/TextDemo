package com.example.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


/**
 想和feiQ通个信
 UDP这个协议中规定了如果IP的结尾是255的话那么就会向当前网段的所有计算机发送消息
 */
public class FeiQ {
	public static void main(String[] args) {
		DatagramSocket socket=null;
		try {
			socket=new DatagramSocket();   //码头
			String data=appendData("习大大来电");
			DatagramPacket packet=new DatagramPacket(data.getBytes(),data.getBytes().length,InetAddress.getByName("10.7.156.255"),2425);
			socket.send(packet);
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			socket.close();
		}
	}
	/**
	 * 构建feiQ格式的数据
	 * @param string
	 * @return
	 */
	private static String appendData(String content) {
		StringBuilder builder=new StringBuilder();
		builder.append("1.0:");
		builder.append(System.currentTimeMillis()+":");
		builder.append("习大大:");
		builder.append("10.7.156.11:");
		builder.append("32:");
		builder.append(content);
		return builder.toString();
	}
}
