package com.mmal.concurrency.product_consumer;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Product implements Runnable{
    private Boolean isrunning  = true;
    private BlockingDeque<PCData> deque;
    private PCData pcData;
    private static AtomicInteger atomicInteger = new AtomicInteger();
    private static final int Sleep = 1000;
    public Product(BlockingDeque<PCData> queue){
        deque = queue;
    }

    @Override
    public void run() {
        PCData pcData = null;
        Random random = new Random();
        log.info("Product id ：{}",Thread.currentThread().getId());
        try {
            while(isrunning){
                Thread.sleep(random.nextInt(Sleep));
                pcData = new PCData(atomicInteger.incrementAndGet());
                if (!deque.offer(pcData,2,TimeUnit.SECONDS)){
                    log.error("failed to put data :{}", pcData);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupted();
        }

    }
    public void stop(){
        isrunning = false;
    }
}
