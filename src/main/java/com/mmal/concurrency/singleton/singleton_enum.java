package com.mmal.concurrency.singleton;


import com.mmal.concurrency.annotation.Recommend;
import com.mmal.concurrency.annotation.ThreadSafe;


/*
* 枚举模式，最安全的，不需要其他的方式去维护*/
@ThreadSafe
@Recommend
public class singleton_enum {
    //私有构造函数
    private singleton_enum(){

    }

    public singleton_enum getinstance(){
            return single.INSTANCE.getSingletonEnum();
    }
    private enum single{
        INSTANCE;
        private singleton_enum singletonEnum;
        /*jvm保证这个方法只使用了一次*/
        single(){
            singletonEnum = new singleton_enum();
        }
        public singleton_enum getSingletonEnum(){
            return singletonEnum;
        }
    }
}
