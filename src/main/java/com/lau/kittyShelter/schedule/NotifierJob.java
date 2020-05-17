package com.lau.kittyShelter.schedule;

import com.lau.kittyShelter.service.NotifierService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotifierJob implements Job {
    @Autowired
    NotifierService notifierService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.info("Job ** {} ** fired @ {}", context.getJobDetail().getKey().getName(), context.getFireTime());

        notifierService.checkForNewKitty();

        logger.info("Next job scheduled @ {}", context.getNextFireTime());


    }
}
