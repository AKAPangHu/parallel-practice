package com.panghu.CountDownLatch.Empire;

import java.util.concurrent.CountDownLatch;

/**
 * @author: 胖虎
 * @date: 2019/8/11 17:57
 **/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "国被灭");
                countDownLatch.countDown();
            }, CountryEnum.get(i).getRetMessage()).start();
        }
        countDownLatch.await();
        System.out.println("秦国统一华夏");
    }
}
