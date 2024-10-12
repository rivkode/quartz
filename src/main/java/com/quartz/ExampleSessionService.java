package com.quartz;

import java.util.Date;
import lombok.extern.slf4j.Slf4j;

/**
 * packageName    : com.quartz
 * fileName       : SessionService
 * author         : jongh
 * date           : 2024-10-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-11           jongh          최초 생성
 */

@Slf4j
public class ExampleSessionService {

    public void excuteLog() {
        Date date = new Date();
        log.info("excuteLog: " + date.toString());
    }
}
