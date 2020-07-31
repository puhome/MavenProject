package com.brzt.jdkio.fakenio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 通过线程池 来实现伪NIO
 * 缺点：
 * 如1000个请求，线程池数量上限为300，等待队列300，那还会有400的请求直接被拒绝
 * @author puhome
 * @data 2020/7/31
 */
public class NioServer {

    private static final  int PORT=8090;
    public static  void  main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("等待客户端发送请求");
            Socket socket = null;
            ExecutorService executorService= Executors.newCachedThreadPool();//创建一个线程池
            while (true) {
                socket = serverSocket.accept();
                final Socket finalSocket = socket;
                /**
                 *线程池
                 */
                executorService.execute(new TimeServerHandler(finalSocket));
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
