package com.mmal.concurrency.Atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class Atomic_AtomicBoolean {
    private static AtomicBoolean isHappened = new AtomicBoolean(false);
    public static int ClientTotal = 5000;
    public static int ThreadTotal =200;

    public static void main(String[] args)  throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(ThreadTotal);
        final CountDownLatch countDownLatch =new CountDownLatch(ClientTotal);
        for(int i = 0;i<ClientTotal;i++){
            executorService.execute(() ->{
                try {
                    semaphore.acquire();
                    test();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("ishappen:{}",isHappened.get());
    }
    private  static void test(){
        if(isHappened.compareAndSet(false,true)){
            log.info("excute");
        }
    }
}
