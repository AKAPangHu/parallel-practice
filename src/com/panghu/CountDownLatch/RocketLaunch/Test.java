package com.panghu.CountDownLatch.RocketLaunch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: 胖虎
 * @date: 2019/8/10 23:36
 **/
public class Test {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++){
            executorService.submit(RocketDown.ROCKET_DOWN);
        }
        //要求等待所有线程完毕后，再进行主线程
        RocketDown.COUNT_DOWN_LATCH.await();
        System.out.println("发射火箭");
        executorService.shutdown();
    }

}
