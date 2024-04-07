package org.mybatis._13_sorn_pisey_spring_homework003.service.AttendeeServiceImp;

import lombok.Data;
import org.mybatis._13_sorn_pisey_spring_homework003.exception.AttendeeNotFoundException;
import org.mybatis._13_sorn_pisey_spring_homework003.exception.FieldEmptyException;
import org.mybatis._13_sorn_pisey_spring_homework003.model.entity.Attendee;
import org.mybatis._13_sorn_pisey_spring_homework003.model.request.AttendeeRequest;
import org.mybatis._13_sorn_pisey_spring_homework003.repository.AttendeeRepository;
import org.mybatis._13_sorn_pisey_spring_homework003.service.AttendeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

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
        String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

        if (attendeeRequest.getAttendeeName().isBlank() || attendeeRequest.getAttendeeName().contains("string")){
            throw new FieldEmptyException("AttendeeName should not empty");
        }
        if (attendeeRequest.getEmail().isBlank() || attendeeRequest.getEmail().contains("string")
                || !(EMAIL_PATTERN.matcher(attendeeRequest.getEmail()).matches())
        ){
            throw new FieldEmptyException("Email can not empty");
        }

        Integer storeId = attendeeRepository.saveAttendee(attendeeRequest);
        if (storeId != null){
            return storeId;
        }
        return null;
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
