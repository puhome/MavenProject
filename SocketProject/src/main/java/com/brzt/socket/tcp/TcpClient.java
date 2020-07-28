package com.brzt.socket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

/**
 * @author puhome
 * @data 2020/7/28
 */
public class TcpClient {
    public static void main(String[] args) throws  IOException {
        //创建socket
        final Socket socket = new Socket();
        //创建socket地址
        SocketAddress socketAddress = null;
        socketAddress = new InetSocketAddress(InetAddress.getLocalHost(), 8081);
        socket.connect(socketAddress);
        //创建PrintWriter
        PrintWriter socketOut = new PrintWriter(socket.getOutputStream());
        BufferedReader socketIn=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //向服务端发送内容
        String str="请问服务器1+1=多少";
        socketOut.write(str);
        socketOut.flush();
        //等待服务器响应
        String reMsg=socketIn.readLine();
        System.out.println("服务器端回复为："+reMsg);

        //关闭连接
        socketOut.close();
        socketIn.close();
        socket.close();
    }
}

