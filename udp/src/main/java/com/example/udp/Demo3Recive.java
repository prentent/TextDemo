package com.example.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Demo3Recive {
  static int i=1;
  public static void main(String[] args) throws SocketException {
	  DatagramSocket socket=new DatagramSocket(7777);
	while(true){
		try {
			byte[] buf=new byte[1024];
			DatagramPacket packet=new DatagramPacket(buf,buf.length);
			socket.receive(packet);
			System.out.println(new String(buf,0,packet.getLength())+"  "+i);
			i++;
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
  }
}
