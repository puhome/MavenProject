package com.brzt.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author puhome
 * @data 2020/7/28
 */
public class UdpServer {
    public static  void main(String[] args) throws IOException
    {
        DatagramSocket datagramSocket=new DatagramSocket(8082);
        //接收客户端数据
        byte[] reMsg=new byte[1024];
        DatagramPacket datagramPacket=new DatagramPacket(reMsg,reMsg.length);
        System.out.println("我在等待客户端发送消息");
        datagramSocket.receive(datagramPacket);
        String reMsgStr=new String(reMsg,0,reMsg.length);
        System.out.println("我是服务器，客户端说："+reMsgStr);

        //响应客户端
        InetAddress inetAddress=datagramPacket.getAddress();
        int port=datagramPacket.getPort();
        byte[] sendMsg="1+1=2".getBytes();
        DatagramPacket datagramPacket1=new DatagramPacket(sendMsg,sendMsg.length,inetAddress,port);
        datagramSocket.send(datagramPacket1);
        datagramSocket.close();
    }
}
