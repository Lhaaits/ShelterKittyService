package com.lau.kittyShelter.schedule;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;

@Service
public class CallScheduler {

    Scheduler scheduler;

    {
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
