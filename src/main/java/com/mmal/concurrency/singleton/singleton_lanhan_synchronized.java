package com.mmal.concurrency.singleton;


import com.mmal.concurrency.annotation.NotRecommend;
import com.mmal.concurrency.annotation.ThreadSafe;

/*
* 懒汉模式，实例在类第一次使用的时候创建*/
@ThreadSafe
@NotRecommend
public class singleton_lanhan_synchronized {
    //私有构造函数
    private singleton_lanhan_synchronized(){

    }
    //单例对象
    private static singleton_lanhan_synchronized singletonexample = null;
    //
    public static synchronized  singleton_lanhan_synchronized getinstance(){
        if(singletonexample == null){
            singletonexample = new singleton_lanhan_synchronized();
        }
        return singletonexample;
    }
}
