package com.brzt.socket.bio;

import java.io.IOException;
import java.net.*;

/**
 * @author puhome
 * @data 2020/7/30
 */
public class BioClient {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket();
        SocketAddress socketAddress=new InetSocketAddress(InetAddress.getLocalHost(),8881);
        socket.connect(socketAddress);
        socket.getOutputStream().write("服务器你好，我是客户端1111111111".getBytes());
        socket.close();
    }
}
