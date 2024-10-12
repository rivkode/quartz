package com.quartz;

import lombok.RequiredArgsConstructor;
import org.quartz.JobExecutionContext;

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

@RequiredArgsConstructor
public class ExampleJob extends AbstractJob {

    private final ExampleSessionService exampleSessionService;

    @Override
    public void onException(JobExecutionContext context) {

    }

    @Override
    public void runJob(JobExecutionContext context) throws Exception {
        exampleSessionService.excuteLog();
    }
}
