package com.chenyue.experiment.net;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenyue7@foxmail.com
 *
 * java new io
 */


@SuppressWarnings("all")
public class SocketNIOTest {
    public static void main(String[] args) throws Exception {
        List<SocketChannel> clients = new LinkedList<>();
        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress(9090));
        ss.configureBlocking(false);  // OS指的是nonblock的io

        while(true){
            Thread.sleep(1000);
            SocketChannel client =ss.accept(); // 不会阻塞 两者情况:正常client or 返回null

            if (client == null){
                System.out.println("null...");
            }else {
                client.configureBlocking(false);
                int port = client.socket().getPort();
                System.out.println("client... port"+port);
                clients.add(client);
            }
            ByteBuffer buffer = ByteBuffer.allocateDirect(4096); //

            for (SocketChannel c: clients){
                int num = c.read(buffer);
                if (num > 0){
                    buffer.flip();
                    byte[] aaa = new byte[buffer.limit()];
                    buffer.get(aaa);

                    String b = new String(aaa);
                    System.out.println(c.socket().getPort() +" :" + b);
                    buffer.clear();
                }
            }
        }


    }
}
