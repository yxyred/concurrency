package com.mmal.concurrency.singleton;


import com.mmal.concurrency.annotation.ThreadSafe;

/*
* 饿汉模式，实例在类装载的时候创建*/
@ThreadSafe
public class singleton_ehan2 {
    //私有构造函数
    private singleton_ehan2(){

    }
    //单例对象
    private static singleton_ehan2 singletonexample = null;
    static {
        singletonexample = new singleton_ehan2();
    }
    //
    public static singleton_ehan2 getinstance(){

        return singletonexample;
    }

    public static void main(String[] args) {
        System.out.println(getinstance().hashCode());
        System.out.println(getinstance().hashCode());
    }
}
