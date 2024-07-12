package com.chenyue.experiment.basic.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/13
 * @description 测试NIO(new io/非阻塞io)
 *
 * 核心组件
 * Channel（通道）：类似于传统 I/O 中的流，但更强大。不同类型的通道可以连接不同类型的实体（如文件或网络套接字）。
 * Buffer（缓冲区）：用于在通道和应用程序之间传输数据。可以直接在缓冲区中读取或写入数据。
 * Selector（选择器）：允许单个线程处理多个通道。它可以用于检查多个通道是否准备好进行读取或写入操作。
 * 工作原理
 * 程序通过将 Channel 注册到 Selector 上，并指定感兴趣的 I/O 事件（如连接、接受、读取、写入），然后通过 Selector 的 select() 方法阻塞等待就绪的通道。
 * 一旦有通道准备好进行操作，Selector 就会返回就绪的 SelectionKey，应用程序可以通过 SelectionKey 获取通道并进行操作。
 */
public class NioServerTest {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new NioServer()).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(new NioClient()).start();
    }

    private static class NioServer implements Runnable {
        @Override
        public void run() {
            try {
                // 创建 Selector
                Selector selector = Selector.open();

                // 创建 ServerSocketChannel 并绑定端口
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                serverSocketChannel.socket().bind(new InetSocketAddress(8080));
                serverSocketChannel.configureBlocking(false);

                // 将 ServerSocketChannel 注册到 Selector 上，监听 OP_ACCEPT 事件
                serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

                System.out.println("Server started on port 8080...");

                while (true) {
                    // 选择准备就绪的通道
                    selector.select();

                    // 获取所有准备就绪的选择键
                    Set<SelectionKey> selectedKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectedKeys.iterator();

                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();

                        if (key.isAcceptable()) {
                            // 接受新的客户端连接
                            ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
                            SocketChannel clientChannel = serverChannel.accept();
                            clientChannel.configureBlocking(false);
                            clientChannel.register(selector, SelectionKey.OP_READ);
                            System.out.println("Accepted new connection from " + clientChannel.getRemoteAddress());
                        } else if (key.isReadable()) {
                            // 读取客户端数据
                            SocketChannel clientChannel = (SocketChannel) key.channel();
                            ByteBuffer buffer = ByteBuffer.allocate(1024);
                            int bytesRead = clientChannel.read(buffer);

                            if (bytesRead == -1) {
                                clientChannel.close();
                                System.out.println("Connection closed by client");
                            } else {
                                buffer.flip();
                                byte[] data = new byte[buffer.remaining()];
                                buffer.get(data);
                                System.out.println("Received data: " + new String(data));
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class NioClient implements Runnable {
        @Override
        public void run() {
            try {
                // 创建一个新的SocketChannel
                SocketChannel socketChannel = SocketChannel.open();
                socketChannel.configureBlocking(false);

                // 连接服务器
                socketChannel.connect(new InetSocketAddress("localhost", 8080));

                while (!socketChannel.finishConnect()) {
                    // 等待连接完成
                    System.out.println("Connecting to server...");
                }

                System.out.println("Connected to server.");

                // 发送数据到服务器
                String message = "Hello, NIO Server!";
                ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
                socketChannel.write(buffer);

                // 关闭连接
                socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
