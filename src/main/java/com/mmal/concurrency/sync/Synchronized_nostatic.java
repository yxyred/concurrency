package com.mmal.concurrency.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Slf4j
public class Synchronized_nostatic {

    public void test1(int j){
       synchronized (this){
           for (int i = 0 ;i <10 ;i++){

               log.info("count:{} - {}",j,i);

           }
       }
    }
    public  synchronized void test2(int j){
        for (int i = 0 ;i <10 ;i++){

            log.info("count:{} - {} ",j,i);
        }
    }

    public static void main(String[] args) {
        Synchronized_nostatic example1 = new Synchronized_nostatic();
        Synchronized_nostatic example2 = new Synchronized_nostatic();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() ->{
            example1.test1(1);
        });
        executorService.execute(() ->{
            example1.test2(2);
        });
    }
}
