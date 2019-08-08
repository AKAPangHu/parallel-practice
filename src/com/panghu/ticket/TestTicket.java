package com.panghu.ticket;

/**
 * @author: 胖虎
 * @date: 2019/8/8 17:44
 **/
public class TestTicket {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        Thread t1 = new Thread(ticket, "西西卡");
        Thread t2 = new Thread(ticket, "孙笑川");

        t1.start(); t2.start();
    }


}
