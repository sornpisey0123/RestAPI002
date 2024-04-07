package org.mybatis._13_sorn_pisey_spring_homework003.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
        @ExceptionHandler(AttendeeNotFoundException.class)
        public ProblemDetail handleUserNotFoundException(AttendeeNotFoundException e) {
            ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
            problemDetail.setType(URI.create("about:blank"));
            problemDetail.setTitle("Not Found");
            problemDetail.setStatus(HttpStatus.NOT_FOUND.value());
            problemDetail.setDetail(e.getMessage());
            problemDetail.setInstance(URI.create("/api/v1/attendees/"+e.getAttendeeId())); // Assuming you have a getUserId() method in UserNotFoundException
            problemDetail.setProperty("time",Instant.now());
            return problemDetail;
        }

        @ExceptionHandler(FieldEmptyException.class)
        public ProblemDetail handlerFieldEmptyException(FieldEmptyException e){
            ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
            problemDetail.setType(URI.create("about:blank"));
            problemDetail.setTitle("Bad Request");
            problemDetail.setStatus(HttpStatus.BAD_REQUEST.value());
            problemDetail.setInstance(URI.create("/api/v1/attendees"));
            problemDetail.setProperty("time",Instant.now());

            Map<String, String> errors = new HashMap<>();
            errors.put("message", e.getMessage());
            problemDetail.setProperty("errors" , errors);

            return problemDetail;
        }


    }

