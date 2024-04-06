package org.mybatis._13_sorn_pisey_spring_homework003.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/attendees ")
public class AttendeeController {
    @GetMapping
    @Operation(summary = "Get venues with id")
    public  String get(){
        return "hello";
    }
}
