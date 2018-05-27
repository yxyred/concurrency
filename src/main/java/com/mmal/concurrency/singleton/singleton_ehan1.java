package com.mmal.concurrency.singleton;


import com.mmal.concurrency.annotation.ThreadSafe;

/*
* 饿汉模式，实例在类装载的时候创建*/
@ThreadSafe
public class singleton_ehan1 {
    //私有构造函数
    private singleton_ehan1(){

    }
    //单例对象
    private static singleton_ehan1 singletonexample = new singleton_ehan1();
    //
    public static singleton_ehan1 getinstance(){
        return singletonexample;
    }
}
