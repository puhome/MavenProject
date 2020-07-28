package com.brzt.socket.tcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;

/**
 * @author puhome
 * @data 2020/7/28
 */
public class TcpServer {
    public static void main(String[] args) throws IOException{
        //创建serversocket
        ServerSocket serverSocket=new ServerSocket();
        //创建监听地址
        SocketAddress socketAddress=new InetSocketAddress(InetAddress.getLocalHost(),8081);
        serverSocket.bind(socketAddress);
        //等待客户端发送请求
        System.out.println("客户端我在等待你发送请求");
        Socket accept=serverSocket.accept();
        PrintWriter socketOut=new PrintWriter(accept.getOutputStream());
        byte buf[]=new byte[1024];
        if(accept.getInputStream().read(buf)>0)
        {
            System.out.println("服务器端接收到了客户端的请求："+new String(buf));
        }
        //向客户端响应消息
        String sendStr="1+1=2";
        socketOut.write(sendStr);
        socketOut.flush();

        socketOut.close();
        accept.close();
        serverSocket.close();
    }
}
