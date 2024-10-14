package com.quartz;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * packageName    : com.quartz
 * fileName       : ApplicationListener
 * author         : jongh
 * date           : 2024-10-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-11           jongh          최초 생성
 */

@Component
@RequiredArgsConstructor
public class ExampleApplicationListener {
    private final ExampleJobServiceSchedulerService exampleJobSchedulerService;

    public void onEvent(ApplicationEvent event) {
        exampleJobSchedulerService.initializeDefinedJobs();
    }
}
