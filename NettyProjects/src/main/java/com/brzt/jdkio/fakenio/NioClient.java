package com.brzt.jdkio.fakenio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author puhome
 * @data 2020/7/31
 */
public class NioClient {

    private static final  int PORT=8090;
    private static final  String HOST="127.0.0.1";

    public static void main(String[] args)
    {

        Socket socket=null;
        BufferedReader in=null;
        PrintWriter out=null;

        try{
            socket=new Socket(HOST,PORT);
            in= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(socket.getOutputStream(),true);
            out.println("我是客户端");
            String rmsg=in.readLine();
            System.out.println("服务器当前时间为："+rmsg);
        }
        catch (Exception e){
            e.printStackTrace();

        }finally {
            if(socket!=null){
                try {
                    socket.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            if(in!=null){
                try{
                    in.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            if(out!=null){
                try{
                    out.close();;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

    }
}
