package com.example.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
public class Demo3Sender {
  public static void main(String[] args) {
	try {
		DatagramSocket socket=new DatagramSocket();
		String data="hello";
		DatagramPacket packet=new DatagramPacket(data.getBytes(),data.getBytes().length,InetAddress.getLocalHost(),7777);
		for(int i=0;i<10;i++){ 
		  socket.send(packet);	    
		}
		socket.close();
	} catch (SocketException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
  }
}
