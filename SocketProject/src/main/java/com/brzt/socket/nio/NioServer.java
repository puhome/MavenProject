package com.brzt.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * NonBlocking I/O
 * 缺点：
 * 每来一个请求则创建一个线程，非常消耗资源
 * @author puhome
 * @data 2020/7/30
 */
public class NioServer {
    public static void main(String[] args) throws IOException
    {
        final byte[] bytes=new byte[1024];
        ServerSocket serverSocket=new ServerSocket();
        serverSocket.bind(new InetSocketAddress(8881));
        ExecutorService executorService= Executors.newCachedThreadPool();//创建一个线程池
        while (true) {
            System.out.println("正在等待接收请求");
            final Socket socket = serverSocket.accept();//一直等待客户端发送请求
            //接到请求后，多线程处理，避免阻塞
            executorService.execute(new Runnable() {
                public void run() {
                    try {
                        int read = socket.getInputStream().read(bytes);
                        String result = new String(bytes);
                        System.out.println("服务器获取的数据为:" + result);
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
