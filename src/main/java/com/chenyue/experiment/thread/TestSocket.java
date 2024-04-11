package com.chenyue.experiment.thread;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chenyue7@foxmail.com
 *
 *
 * strace netstat -netp
 *
 * liunx strace命令:
 * 安装strace:yum -y isntall strace
 * strace -ff -o out java TestSocket
 * 安装nc: yum install -y nc
 * tail -f 文件名:刷新查看文件最后十行
 *
 * New IO (java的io)
 * NIO not block io
 *
 */
public class TestSocket {

    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(8090);
        System.out.println("setp1:new ServerSocket(8090) ");
        while(true){
            Socket client =  server.accept(); //阻塞
            System.out.println("step2: client\t"+client.getPort());

            new Thread(new Runnable() {
                Socket ss;
                public Runnable setSs(Socket s){
                    this.ss = s;
                    return this;
                }
                @Override
                public void run() {
                    try {
                        InputStream is = ss.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                        while(true){
                            System.out.println(reader.readLine());
                        }
                    }catch (Exception e){

                    }
                }
            }.setSs(client)).start();
        }
    }
}














