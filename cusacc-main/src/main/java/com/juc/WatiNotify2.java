package com.juc;

import lombok.Data;

@Data
public class WatiNotify2 {

      volatile int c = 0;

    public static void main(String[] args) {

        WatiNotify2 o = new WatiNotify2();

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {

                System.out.println("thread1 ");

                synchronized (o) {
                    try {

                        while (o.getC() > 0) {
                            o.setC( o.getC() -1 );
                            System.out.println("消费c"+ o.getC());
                            if(o.getC()==0){
                                o.notify();
                                o.wait();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }


            }
        });

        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {

                System.out.println("thread12 ");

                synchronized (o) {
                    try {

                        while (o.getC()  <=  99) {
                            o.setC( o.getC() +1 );
                            System.out.println("thread12 ++"+o.getC());
                            if(o.getC() ==100){
                                o.notify();
                                o.wait();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("sync12");
                }

            }
        });

        thread2.start();
        thread.start();
    }


}
