package com.quartz;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * packageName    : com.quartz
 * fileName       : ExampleJob
 * author         : jongh
 * date           : 2024-10-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-11           jongh          최초 생성
 */

@Slf4j
@RequiredArgsConstructor
public class ExampleJob extends AbstractJob {

    private final ExampleSessionService exampleSessionService;

    @Override
    public void onException(JobExecutionContext context) {
        // Job 실행 중 예외가 발생했을 때 처리할 로직
        log.error("Job Execution Exception", context.getJobDetail().getKey().getName());
    }

    @Override
    public void runJob(JobExecutionContext context) {
        try {
            exampleSessionService.excuteLog();
        } catch (Exception e) {
            log.error("Job failed");

            // JobExecutionException을 발생시키고 Job을 중단
            JobExecutionException jobExecutionException = new JobExecutionException(e);
            jobExecutionException.setUnscheduleFiringTrigger(true); // 현재 트리거 중단
        }
    }
}
