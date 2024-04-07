package org.mybatis._13_sorn_pisey_spring_homework003.service.AttendeeServiceImp;

import lombok.Data;
import org.mybatis._13_sorn_pisey_spring_homework003.model.entity.Attendee;
import org.mybatis._13_sorn_pisey_spring_homework003.model.request.AttendeeRequest;
import org.mybatis._13_sorn_pisey_spring_homework003.repository.AttendeeRepository;
import org.mybatis._13_sorn_pisey_spring_homework003.service.AttendeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class AttendeeServiceImp implements AttendeeService {
    private final AttendeeRepository attendeeRepository;
    @Override
    public List<Attendee> getAllAttendee(Integer page, Integer size) {
        return attendeeRepository.findAllAttendee(page, size);
    }

    @Override
    public Attendee getOneAttendee(Integer attendeeId) {
        return attendeeRepository.findOneAttendee( attendeeId);
    }

    @Override
    public Integer addNewAttendee(AttendeeRequest attendeeRequest) {
        return attendeeRepository.saveAttendee(attendeeRequest);
    }

    @Override
    public boolean deleteAttendeeById(Integer attendeeId) {
        return attendeeRepository.removeAuthorById(attendeeId);
    }


    @Override
    public Integer updateAttendeeById(AttendeeRequest attendeeRequest, Integer attendeeId) {
        return attendeeRepository.editAttendeeById(attendeeRequest, attendeeId);
    }

}
