package com.chenyue.experiment.basic.io;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/13
 * @description 测试异步IO, 异步IO相对于在主线程，开启一个任务交给子线程去执行，发布这个任务后，主线程就可以干其他事情了，
 * 等到合适的时机，主线程在通过 Future.get()方法阻塞的获得这个任务的结果，如果这个任务在此时已经执行完成了，那么get看起来就没有一样，
 * 如果此时，任务还在执行，那么get就会阻塞等待任务的结束，获得任务的结果（返回值）。
 *
 * BIO：简单直观，适合少量并发连接和每个连接数据量较小的场景。
 * NIO：非阻塞 I/O，高扩展性和性能，适合大量并发连接和每个连接数据量较小的场景。
 * AIO：异步 I/O，适合大量并发连接和每个连接数据量较大的场景，通过回调机制处理异步操作。
 */
public class AioFileReadTest {
    public static void main(String[] args) throws IOException {
        File file = new File("example.txt");
        if (!file.exists()) {
            System.out.println("创建新文件" + file.createNewFile());
        }
        // 文件路径
        Path filePath = Paths.get("example.txt");

        // 创建异步文件通道
        try (AsynchronousFileChannel asyncFileChannel = AsynchronousFileChannel.open(filePath, StandardOpenOption.READ)) {
            // 文件大小
            long fileSize = asyncFileChannel.size();
            // 创建一个容量为1024字节的字节缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            // 偏移量
            long position = 0;

            while (position < fileSize) {
                // 异步读取文件内容到缓冲区
                Future<Integer> result = asyncFileChannel.read(buffer, position);

                // 在读取文件的同时可以进行其他操作
                while (!result.isDone()) {
                    System.out.println("Doing other work while reading the file...");
                }

                // 获取读取的字节数
                int bytesRead = result.get();

                // 如果读取到的字节数是-1，说明已经到达文件末尾
                if (bytesRead == -1) {
                    break;
                }

                position += bytesRead;

                buffer.flip(); // 切换缓冲区为读取模式
                byte[] data = new byte[bytesRead];
                buffer.get(data);
                System.out.println("File content: " + new String(data));
                buffer.clear(); // 清空缓冲区，为下一次读取做准备
            }
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }finally {
            if (file.exists()) {
                System.out.println("删除文件: " + file.delete());
            }
        }
    }
}
