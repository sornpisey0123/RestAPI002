package org.mybatis._13_sorn_pisey_spring_homework003.service;

import org.mybatis._13_sorn_pisey_spring_homework003.model.entity.Attendee;
import org.mybatis._13_sorn_pisey_spring_homework003.model.request.AttendeeRequest;

import java.util.List;

public interface AttendeeService {
    List<Attendee> getAllAttendee(Integer page , Integer size);

    Attendee getOneAttendee(Integer attendeeId);

    Integer addNewAttendee(AttendeeRequest attendeeRequest);

    boolean deleteAttendeeById(Integer attendeeId);

    Integer updateAttendeeById(AttendeeRequest attendeeRequest, Integer attendeeId);
}
