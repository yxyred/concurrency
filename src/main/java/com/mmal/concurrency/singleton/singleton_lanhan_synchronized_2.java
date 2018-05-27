package com.mmal.concurrency.singleton;


import com.mmal.concurrency.annotation.ThreadSafe;

/*
* 懒汉模式，实例在类第一次使用的时候创建
* 双重同步锁单例模式*/
@ThreadSafe
public class singleton_lanhan_synchronized_2 {
    //私有构造函数
    private singleton_lanhan_synchronized_2(){

    }
    //单例对象
    private volatile static singleton_lanhan_synchronized_2 singletonexample = null;
    //
    public static synchronized singleton_lanhan_synchronized_2 getinstance(){
        if(singletonexample == null){
            synchronized (singleton_lanhan_synchronized_2.class){
                if(singletonexample == null){
                    singletonexample = new singleton_lanhan_synchronized_2();
                }

            }

        }
        return singletonexample;
    }
}
