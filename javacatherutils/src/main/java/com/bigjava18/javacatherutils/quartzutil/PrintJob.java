package com.bigjava18.javacatherutils.quartzutil;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @Author zgp
 * @Since 2021 -09 -07 10 :30
 * @Description 需要定时任务执行调用的接口
 */
public class PrintJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(new Date() + " : 任务「PrintJob」被执行。");
    }
}
