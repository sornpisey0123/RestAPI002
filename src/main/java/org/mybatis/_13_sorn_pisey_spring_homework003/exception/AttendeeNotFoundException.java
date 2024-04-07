package org.mybatis._13_sorn_pisey_spring_homework003.exception;

public class AttendeeNotFoundException extends RuntimeException{
    private Integer id;
    public AttendeeNotFoundException(Integer attendeeId){
        super("attendeeId" + attendeeId + "not found!");
        this.id  = attendeeId;
    }
    public Integer getAttendeeId(){
        return id;
    }

}
