package com.mmal.concurrency.singleton;


import com.mmal.concurrency.annotation.Recommend;
import com.mmal.concurrency.annotation.ThreadSafe;


/*
* 枚举方法*/
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
        single(){
            singletonEnum = new singleton_enum();
        }
        public singleton_enum getSingletonEnum(){
            return singletonEnum;
        }
    }
}
