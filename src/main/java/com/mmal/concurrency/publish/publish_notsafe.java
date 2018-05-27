package com.mmal.concurrency.publish;

import com.mmal.concurrency.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@NotThreadSafe
public class publish_notsafe {
    private String [] pub ={"a","b","c"};
    public String[] getPub(){
        return pub;
    }

    public static void main(String[] args) {
        publish_notsafe notsafe = new publish_notsafe();
        log.info("{}",Arrays.toString(notsafe.getPub()));
        notsafe.getPub()[0]="d";
        log.info("{}",Arrays.toString(notsafe.getPub()));
    }
}
