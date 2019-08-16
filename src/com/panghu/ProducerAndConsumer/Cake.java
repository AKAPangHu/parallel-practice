package com.panghu.ProducerAndConsumer;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: 胖虎
 * @date: 2019/8/13 23:25
 **/
public class Cake {

    /**
     * 控制阻塞队列开启
     */
    private volatile boolean flag = true;

    private BlockingQueue<String> blockingQueue;

    /**
     * 蛋糕编号
     */
    private AtomicInteger id = new AtomicInteger();

    public Cake(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void productCake() throws InterruptedException {
        String data;
        while (flag) {
            data = id.incrementAndGet() + "";
            System.out.println(Thread.currentThread().getName() + "\t" + data + "号蛋糕放入货架");
            boolean success = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (!success) {
                System.out.println(Thread.currentThread().getName() + "\t" + data + "号蛋糕放入货架失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("店员们停止所有动作，今天要关店了~！");
    }

    public void consumeCake() throws InterruptedException {
        String data;
        while (flag) {
            data = blockingQueue.poll(2L, TimeUnit.SECONDS);
            //判断是否取到蛋糕
            if (data == null || "".equalsIgnoreCase(data)) {
                System.out.println(Thread.currentThread().getName() + "超过两秒没有取到蛋糕，消费退出");
                flag = false;
                return;
            }
            else {
                System.out.println(Thread.currentThread().getName() + "\t" + data + "号蛋糕被取走");
            }
        }
        System.out.println("顾客们都走了，货架上没东西了");
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue storage = new ArrayBlockingQueue(3);
        Cake cake = new Cake(storage);
        new Thread(()->{
            try {
                System.out.println("生产者线程已创建");
                cake.productCake();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "producer").start();
        new Thread(()->{
            try {
                System.out.println("消费者线程已创建");
                cake.consumeCake();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "consumer").start();
        TimeUnit.SECONDS.sleep(5);
        cake.flag = false;
        System.out.println("下达关店指令");
    }

}
