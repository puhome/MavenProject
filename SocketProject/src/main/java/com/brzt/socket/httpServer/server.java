package com.brzt.socket.httpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author puhome
 * @data 2020/7/29
 */
public class server {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket=new ServerSocket(8888);
       //一直监听
        while (true)
        {
            Socket socket=null;
            try {
                System.out.println("等待客户端发送请求");
                socket = serverSocket.accept();//如果没有请求，则一直在这里等待
                System.out.println("客户端正在发送请求");
                //获取请求流
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line = null;
                //获取请求内容
                while ((line = bufferedReader.readLine()) != null && !line.equals("")) {
                    stringBuilder.append(line).append("<br>");
                }
                String result = stringBuilder.toString();
                System.out.println(result);

                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                //将信息输出到浏览器
//                printWriter.println("服务器打印：HTTP/1.1 200 OK");
//                printWriter.println("服务器打印：Content-type:text/html;charset=utf-8");
//                printWriter.println();
//                printWriter.println("客户端发送请求数据为：</br>");
                printWriter.write(result);

                printWriter.close();
                bufferedReader.close();
                socket.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
