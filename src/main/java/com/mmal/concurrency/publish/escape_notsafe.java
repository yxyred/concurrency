package com.mmal.concurrency.publish;

import com.mmal.concurrency.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
public class escape_notsafe {
    private int esca = 2;
    public escape_notsafe(){
        new inner();
    }
    private class inner{
         public inner(){
             log.info("{}",escape_notsafe.this.esca);
         }
    }

    public static void main(String[] args) {
        new   escape_notsafe();

    }
}
