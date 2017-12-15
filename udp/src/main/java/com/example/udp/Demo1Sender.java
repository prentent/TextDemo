package com.example.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import com.sun.org.apache.bcel.internal.classfile.InnerClass;

/**
 研究下UDP通讯
 UDP数据传输的特点
 1:因为无连接所以速度快
 2:无连接
 3:每次能够发送的数据最大是64k
 4：因为无连接所以不安全、
 5：UDP的传输是依靠数据包进行传输的
 生活中的运输货物
 1:把货物装入集装箱放到码头等货运船
 2:把集装箱装入船上
 3:船运输货物
 4:开着车去码头取货物
 5:拿到货物
 */
public class Demo1Sender {
	public static void main(String[] args) {
		try {
			DatagramSocket socket=new DatagramSocket();  //码头
			String data="哈哈哈哈!!!!";    //货物
			DatagramPacket packet=new DatagramPacket(data.getBytes(),data.getBytes().length,InetAddress.getLocalHost(),9000);  //装货物贴标签
			socket.send(packet);
			socket.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

