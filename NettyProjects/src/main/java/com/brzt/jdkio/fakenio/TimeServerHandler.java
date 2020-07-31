package com.brzt.jdkio.fakenio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * @author puhome
 * @data 2020/7/31
 */
public class TimeServerHandler implements Runnable {

    private Socket socket;

    public TimeServerHandler(Socket socket)
    {
        this.socket=socket;
    }

    public void run() {
        BufferedReader in=null;
        PrintWriter out=null;

        try {
            in= new BufferedReader(new InputStreamReader(this.socket.getInputStream())) ;
            out=new PrintWriter(this.socket.getOutputStream(),true);

            String msg=null;

            while ((msg=in.readLine())!=null && msg.length()!=0){
                System.out.println("接收到的客户端消息为："+msg);
                out.println(new Date().toString());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            if(in!=null) {
                try{
                    in.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            if(out!=null){
                try {
                    out.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            if(socket!=null){
                try{
                    socket.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

    }
}
