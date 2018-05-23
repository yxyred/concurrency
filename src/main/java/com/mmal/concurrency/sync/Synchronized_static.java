package com.mmal.concurrency.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Slf4j
public class Synchronized_static {

    public void test1(int j){
       synchronized (Synchronized_static.class){
           for (int i = 0 ;i <10 ;i++){

               log.info("count:{} - {}",j,i);

           }
       }
    }
    public static synchronized void test2(int j){
        for (int i = 0 ;i <10 ;i++){

            log.info("count:{} - {} ",j,i);
        }
    }

    public static void main(String[] args) {
        Synchronized_static example1 = new Synchronized_static();
        Synchronized_static example2 = new Synchronized_static();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() ->{
            example1.test2(1);
        });
        executorService.execute(() ->{
            example2.test2(2);
        });
    }
}
