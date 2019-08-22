package com.panghu.MyThreadPool;

import java.util.concurrent.*;

/**
 * 手写线程池
 * @author: 胖虎
 * @date: 2019/8/22 14:11
 **/
public class MyThreadPool {

    public static void main(String[] args) {
        ThreadPoolExecutor myThreadPool = new ThreadPoolExecutor(
                3,
                6,
                0L,
                TimeUnit.MICROSECONDS,
                new LinkedBlockingDeque<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        try {
            for (int i = 0; i < 10; i++) {
                myThreadPool.execute(() ->{
                    System.out.println(Thread.currentThread().getName() + "init");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            myThreadPool.shutdown();
        }

    }

}
