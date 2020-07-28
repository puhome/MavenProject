package com.brzt.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author puhome
 * @data 2020/7/28
 */
public class UdpClient {

    public  static  void  main(String[] args) throws IOException{
        //定义服务端地址
        InetAddress inetAddress=InetAddress.getByName("localhost");
        int port=8082;
        byte[] sendMsg="请问服务器：1+1等于多少".getBytes();
        //创建数据报 发送数据报
        DatagramPacket datagramPacket=new DatagramPacket(sendMsg,sendMsg.length,inetAddress,port);
        DatagramSocket datagramSocket=new DatagramSocket();
        datagramSocket.send(datagramPacket);

        //接收服务端响应数据
        byte[] reMsg=new byte[1024];
        DatagramPacket datagramPacket1=new DatagramPacket(reMsg,reMsg.length);
        datagramSocket.receive(datagramPacket1);

        String reMsgStr=new String(reMsg,0,reMsg.length);
        System.out.println("服务器回复为："+reMsgStr);
        datagramSocket.close();
    }
}
