package com.mmal.concurrency.product_consumer;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
@Slf4j
public class Consumer implements Runnable{
private BlockingDeque<PCData> deque;
private static final int Sleep = 1000;

public Consumer(BlockingDeque<PCData> deque){
    this.deque =deque;
}
    @Override
    public void run() {
        log.info("Consumer thread id:{}",Thread.currentThread().getId());
        Random random = new Random();
        try {
            while(true) {
                PCData pcData = deque.take();
                if(pcData != null){
                    int count = pcData.getData() * pcData.getData();
                    log.info("count's :{}",count);
                    Thread.sleep(random.nextInt(Sleep));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
