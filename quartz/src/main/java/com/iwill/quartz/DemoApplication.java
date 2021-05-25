package com.iwill.quartz;

import com.iwill.quartz.job.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

//@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws Exception{
       // SpringApplication.run(DemoApplication.class);

        // Grab the Scheduler instance from the Factory
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        // and start it off
        scheduler.start();

        JobDataMap dataMap = new JobDataMap();
        dataMap.putAsString("age",2);
        // define the job and tie it to our HelloJob class
        JobDetail job = JobBuilder.newJob(HelloJob.class)
                .withIdentity("job1", "group1")
                .setJobData(dataMap)
                .build();

        // Trigger the job to run now, and then repeat every 40 seconds
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                 .withIntervalInSeconds(1)
                 .repeatForever())
                .build();

        // Tell quartz to schedule the job using our trigger
        scheduler.scheduleJob(job, trigger);
        Thread.sleep(10000000L);
        scheduler.shutdown();
    }
}
