package com.quartz;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Trigger;
import org.quartz.TriggerKey;

/**
 * packageName    : com.quartz
 * fileName       : ExampleJobServiceSchedulerService
 * author         : jongh
 * date           : 2024-10-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-11           jongh          최초 생성
 */

public class ExampleJobServiceSchedulerService {

    // 생성자
    public ExampleJobServiceSchedulerService() {
        JobDetail exampleMatchJob = newJob(ExampleJob.class)
                .withIdentity(buildJobKey("example-match"))
                .build();

        Trigger exampleTrigger = newTrigger()
                .withIdentity(buildTriggerKey("example-match"))
                .withSchedule(cronSchedule("example-schedule"))
                .build();

        /**
         * 아래와 같이 여러개의 jobClass들을 정의하여 원하는 job 들을 definedJobs 를 통해 job에 추가할 수 있다.
         */
//        JobDetail exampleMatchJob = newJob(ExampleJob.class)
//                .withIdentity(buildJobKey("example-match"))
//                .build();
//
//        Trigger exampleTrigger = newTrigger()
//                .withIdentity(buildTriggerKey("example-match"))
//                .withSchedule(cronSchedule("example-schedule"))
//                .build();


        definedJobs.put(exampleMatchJob, exampleTrigger);
    }

    private TriggerKey buildTriggerKey(String job) {
        return new TriggerKey("trigger".concat(job), "groupTrigger".concat(job).concat("history"));
    }

    private JobKey buildJobKey(String job) {
        return new JobKey("id".concat(job), "group".concat(job).concat("history"));
    }
}
