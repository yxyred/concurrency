package com.mmal.concurrency.singleton;


import com.mmal.concurrency.annotation.NotThreadSafe;

/*
* 懒汉模式，实例在类第一次使用的时候创建*/
@NotThreadSafe
public class singleton_lanhan {
    //私有构造函数
    private singleton_lanhan(){

    }
    //单例对象
    private static singleton_lanhan singletonexample = null;
    //
    public static singleton_lanhan getinstance(){
        if(singletonexample == null){
            singletonexample = new singleton_lanhan();
        }
        return singletonexample;
    }
}
