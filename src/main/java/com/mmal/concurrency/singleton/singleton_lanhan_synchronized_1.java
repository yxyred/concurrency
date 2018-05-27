package com.mmal.concurrency.singleton;


import com.mmal.concurrency.annotation.NotThreadSafe;

/*
* 懒汉模式，实例在类第一次使用的时候创建
* 双重同步锁单例模式*/
/*线程不安全：24行在cpu中有3步：1.分配内存memory = allocated()
2.对象初始化
3.将对象指给对象名
在jvm中会发生指令重排，在多并发情况下可能会发生132的情况，此时当线程A到了28步，而B线程到了25，则B会发现已经有了对象singletonexam而直接返回
当此时A还没进行初始化，则会报错
* */
@NotThreadSafe
public class singleton_lanhan_synchronized_1 {
    //私有构造函数
    private singleton_lanhan_synchronized_1(){

    }
    //单例对象
    private static singleton_lanhan_synchronized_1 singletonexample = null;
    //
    public static synchronized singleton_lanhan_synchronized_1 getinstance(){
        if(singletonexample == null){
            synchronized (singleton_lanhan_synchronized_1.class){
                if(singletonexample == null){
                    singletonexample = new singleton_lanhan_synchronized_1();
                }

            }

        }
        return singletonexample;
    }
}
