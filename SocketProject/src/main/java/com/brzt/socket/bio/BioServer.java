package com.brzt.socket.bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Blocking I/O
 * 缺点：
 * 服务端只能接受一次请求
 * 且会因为处理请求耗时，而导致出现阻塞
 * @author puhome
 * @data 2020/7/30
 */
public class BioServer {
    public static void main(String[] args) throws IOException
    {
        byte[] bytes=new byte[1024];
        ServerSocket serverSocket=new ServerSocket();
        serverSocket.bind(new InetSocketAddress(8881));
        System.out.println("正在等待接收请求");
        Socket socket=serverSocket.accept();//一直等待客户端发送请求

        //接到请求后，处理如下逻辑，以下如果非常耗时 会出现阻塞，此即为BIO
        int read=socket.getInputStream().read(bytes);
        String result=new String(bytes);
        System.out.println("服务器获取的数据为:"+result);
        socket.close();
    }
}
