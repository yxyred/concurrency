package com.mmal.concurrency.product_consumer;

import java.util.Random;

public final class PCData {
    private final int inidata;
    public PCData(int data){
        inidata = data;
    }
    public PCData(String data){
        inidata = Integer.valueOf(data);
    }
    public int getData(){
        return inidata;
    }
}
