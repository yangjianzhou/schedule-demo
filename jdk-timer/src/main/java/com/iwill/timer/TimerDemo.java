package com.iwill.timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {

    public static void main(String[] args) throws Exception{
        TimerTask task = new TimerTask(){

            @Override
            public void run() {
                System.out.println("task execute");
            }
        };

        Timer timer = new Timer();
        timer.schedule(task , 0,10000);

        Thread.sleep(100000L);
    }
}
