package org.mybatis._13_sorn_pisey_spring_homework003.model.response;

import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

public class PostSucceedResponse<T> {
    private String message;
    private T payload;
    private HttpStatus httpStatus;
    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());

}
