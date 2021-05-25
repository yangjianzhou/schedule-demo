package com.iwill.schedule.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestTask {

    @Scheduled(cron = "0 0/10 * * * *")
    public void task1(){
        System.out.println("task1");
    }

    @Scheduled(fixedDelay = 4000)
    public void task2(){
        System.out.println("task2");
    }
}
