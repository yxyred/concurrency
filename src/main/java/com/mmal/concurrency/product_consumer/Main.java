package com.mmal.concurrency.product_consumer;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //建立缓存区
        BlockingDeque<PCData> pcData =new LinkedBlockingDeque<>(10) ;
        Product product1 =new Product(pcData);
        Product product2 = new Product(pcData);
        Product product3 = new Product(pcData);
        Consumer consumer1 =new Consumer(pcData);
        Consumer consumer2 =new Consumer(pcData);
        Consumer consumer3 =new Consumer(pcData);
        ExecutorService threadPool = Executors.newCachedThreadPool();
        threadPool.execute(product1);
        threadPool.execute(product2);
        threadPool.execute(product3);
        threadPool.execute(consumer1);
        threadPool.execute(consumer2);
        threadPool.execute(consumer3);
        Thread.sleep(10 * 1000);
        product1.stop();
        product2.stop();
        product3.stop();
    }
}
