package com.panghu.CountDownLatch.RocketLaunch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: 胖虎
 * @date: 2019/8/10 23:31
 **/
public class RocketDown implements Runnable{

    static final CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(10);

    static final RocketDown ROCKET_DOWN = new RocketDown();

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        COUNT_DOWN_LATCH.countDown();
        System.out.println("check complete");
    }

}
