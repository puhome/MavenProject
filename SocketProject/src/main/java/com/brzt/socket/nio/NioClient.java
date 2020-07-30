package com.brzt.socket.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @author puhome
 * @data 2020/7/30
 */
public class NioClient {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket();
        SocketAddress socketAddress=new InetSocketAddress(InetAddress.getLocalHost(),8881);
        socket.connect(socketAddress);
        socket.getOutputStream().write("服务器你好，我是客户端22222222".getBytes());
        socket.close();
    }
}
