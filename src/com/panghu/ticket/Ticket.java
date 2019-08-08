package com.panghu.ticket;

import java.util.concurrent.TimeUnit;

/**
 * @author: 胖虎
 * @date: 2019/8/8 17:37
 **/
public class Ticket implements Runnable{

    /**
     * 剩余票数
     */
    private int stock = 10;

    /**
     * 票编号
     */
    private int id = 0;


    @Override
    public void run() {
        while(true){
            synchronized(this){
                if (stock <= 0){
                    break;
                }
                stock--;
                id++;
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +
                        "抢到第" + id + "张票，" + "剩余" + stock + "张票");
            }

        }

    }
}
