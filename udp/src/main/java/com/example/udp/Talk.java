package com.example.udp;
/**
 * 聊天的测试
 * @author Administrator
 *
 */
public class Talk {
	public static void main(String[] args) {
		Demo2Sender sender=new Demo2Sender();
		Demo2Reciver reciver=new Demo2Reciver();
		sender.start();
		reciver.start();
	}
}

