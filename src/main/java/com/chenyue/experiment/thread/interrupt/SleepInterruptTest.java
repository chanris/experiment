package com.chenyue.experiment.thread.interrupt;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/10
 * @description
 * 守护线程 与 用户线程的区别：jvm会等待所有用户线程的结束才结束，而jvm不会等待守护线程的结束而关闭。
 *
 */
public class SleepInterruptTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if (Thread.currentThread().isInterrupted()){
                        System.out.println("Interrupted");
                        break;
                    }

                    try {
                        Thread.sleep(1000);// 在睡眠时,产生了中断,会终止睡眠,并抛出中断异常,我们需要处理
                    }catch (InterruptedException e){
                        System.out.println("Interrupted in Sleep");
                        Thread.currentThread().interrupt(); //由于睡眠吃掉了中断信号,必须再次设置中断信息
                    }
                    Thread.yield();
                }
            }
        });
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
    }
}
