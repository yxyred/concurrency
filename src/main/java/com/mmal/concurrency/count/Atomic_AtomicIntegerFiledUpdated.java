package com.mmal.concurrency.count;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Slf4j
public class Atomic_AtomicIntegerFiledUpdated {
    private static AtomicIntegerFieldUpdater<Atomic_AtomicIntegerFiledUpdated> updater = AtomicIntegerFieldUpdater.newUpdater(Atomic_AtomicIntegerFiledUpdated.class,"count");
   @Getter
    public  volatile int count = 100;

    public static void main(String[] args) {
        Atomic_AtomicIntegerFiledUpdated atomic_atomicIntegerFiledUpdated = new Atomic_AtomicIntegerFiledUpdated();
        if(updater.compareAndSet(atomic_atomicIntegerFiledUpdated,100,120)){
            log.info("update success 1,count:{}",atomic_atomicIntegerFiledUpdated.getCount());
        }
        if (updater.compareAndSet(atomic_atomicIntegerFiledUpdated,100,200)){
            log.info("update succcess 2,{}",atomic_atomicIntegerFiledUpdated.getCount());
        }else{
            log.info("undate failed,{}",atomic_atomicIntegerFiledUpdated.getCount());
        }

    }
}
