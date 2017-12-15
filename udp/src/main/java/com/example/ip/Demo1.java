package com.example.ip;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 网络通信
 CS--->client/server  客户端和服务端架构
 手机QQ  feiQ  微信    陌陌     所有银行的客户端
 CS 结构的特点:一定有一个特定的客户端和一个服务端   这种模式下的架构就称为CS结构
 Android应用级的开发就是一个典型的CS结构
 CS架构的通讯就称为网络通讯  宏观的角度上来说
 UDP叫的不是客户端和服务端是叫的     发送方和接收方
 网页通讯
 BS---->浏览器服务器的架构模型
 BS架构下是没有特定的客户端软件，但是都要基于浏览器来发送请求
 如果将浏览器看成是一个特定的客户端的话那么BS结构也是一个特殊的CS架构
 简单点说，左右的网页之间数据的通讯都是网页通讯
 百合网   考试系统   百度贴吧    ------>基于网页的

 疑问：		两台电脑之间如何通讯



 IP:可以在网络中唯一的标识一台电脑
 IP地址的分类
 IP地址是由32位的2进制数来表示IP地址的------->00000000---000000000---00000000----00000000
 每一位上能够表示范围是:0-255   0和255是保留的 其余可以使用
 A类的IP地址      一个网络号     三个主机号     一共四个    它能够标识的主机数是:2的24次方  ------>这部分是政府部门在使用
 B类的IP地址     两个网络号     两个主机号      .....  他能标识的主机数是：2的16次方-------->事业单位
 C类的IP地址    三个网络号    一个主机号        .....  公司
 端口号
 端口号的范围:0-65535
 0-1023这个范围是系统紧密占用的范围
 1024-65535这个范围才是我们使用的范围

 协议:
 UDP----->速度
 TCP----->数据安全
 HTTP1.0/HTTP1.1---->传输数据的封装问题

 InetAddress:IP地址的获取的一个封装类
 常用的方法:
 getAllByName(String host)  返回IP地址的集合组
 getByName(String host)   在给定主机的情况下返回哪个IP地址  还可以跟IP地址  还可以跟域名
 getHostAddress()   返回 IP 地址字符串（以文本表现形式）。
 getLocalHost()  返回本地主机。
 */
public class Demo1 {
	public static void main(String[] args) throws UnknownHostException {
		try {

		InetAddress[] allByName = InetAddress.getAllByName("www.baidu.com");
		System.out.println(Arrays.toString(allByName));
		InetAddress byName = InetAddress.getByName("www.baidu.com");
		System.out.println("获取到的那个IP地址是："+byName.getHostAddress());
		InetAddress allByName2 = InetAddress.getByName("10.10.4.196");
		System.out.println(allByName2.getHostName());
		InetAddress localHost = InetAddress.getLocalHost();
		System.out.println("IP："+localHost.getHostAddress());
		System.out.println("主机："+localHost.getHostName());

		}catch (UnknownHostException e){

		}
	}
}
