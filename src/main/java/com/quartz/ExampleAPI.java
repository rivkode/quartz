package com.quartz;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEvent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName    : com.quartz
 * fileName       : ExampleAPI
 * author         : jongh
 * date           : 2024-10-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-11           jongh          최초 생성
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/job")
public class ExampleAPI {

    private final ExampleApplicationListener exampleApplicationListener;

    @GetMapping
    public ResponseEntity<String> jobExample() {
        ApplicationEvent event = new ApplicationEvent(this) {};
        exampleApplicationListener.onEvent(event); // ApplicationEvent 전달

        return ResponseEntity.ok("success");
    }



}
