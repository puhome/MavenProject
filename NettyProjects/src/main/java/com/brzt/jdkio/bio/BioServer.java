package com.brzt.jdkio.bio;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * 缺点：
 * 每个请求都会创建一个线程，请求多了非常消耗cpu资源
 * @author puhome
 * @data 2020/7/31
 */
public class BioServer {

    private static final  int PORT=8090;
    public static  void  main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("等待客户端发送请求");
            Socket socket = null;
            while (true) {
                socket = serverSocket.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if(serverSocket!=null){
                try{
                    serverSocket.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
