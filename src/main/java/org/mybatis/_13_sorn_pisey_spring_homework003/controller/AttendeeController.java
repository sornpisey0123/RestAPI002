package org.mybatis._13_sorn_pisey_spring_homework003.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.Data;
import org.mybatis._13_sorn_pisey_spring_homework003.model.entity.Attendee;
import org.mybatis._13_sorn_pisey_spring_homework003.model.request.AttendeeRequest;
import org.mybatis._13_sorn_pisey_spring_homework003.model.response.ApiResponse;
import org.mybatis._13_sorn_pisey_spring_homework003.service.AttendeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@Data
@RequestMapping("api/v1/attendees")
public class AttendeeController {
    private final AttendeeService attendeeService;
    @GetMapping()
    @Operation(summary = "Get all attendees ")
    public ResponseEntity<ApiResponse<List<Attendee>>> getAllAttendee
            (@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "3") Integer size ){
        ApiResponse<List<Attendee>> response = ApiResponse.<List<Attendee>>builder()
                .message("All attendees have been successfully fetch")
                .payload(attendeeService.getAllAttendee(page, size))
                .httpStatus(HttpStatus.OK)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get attendee with id  ")
    public ResponseEntity<ApiResponse<Attendee>> getOneAttendee
            (@PathVariable("id") Integer attendeeId){
        ApiResponse<Attendee> response = ApiResponse.<Attendee>builder()
                .message("The attendee has been successfully founded")
                .payload(attendeeService.getOneAttendee(attendeeId))
                .httpStatus(HttpStatus.OK)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
        return ResponseEntity.ok(response);

    }
    @PostMapping()
    @Operation(summary = "Add new Attendee")
    public ResponseEntity<ApiResponse<Attendee>> addNewAttendee
            (@RequestBody AttendeeRequest attendeeRequest){
        Integer storeAttendeeId = attendeeService.addNewAttendee(attendeeRequest);
        ApiResponse<Attendee> response = ApiResponse.<Attendee>builder()
                .message("The attendee has been successfully added ")
                .payload(attendeeService.getOneAttendee(storeAttendeeId))
                .httpStatus(HttpStatus.CREATED)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Attendee>> deleteAttendee
            (@PathVariable("id") Integer attendeeId){
        boolean storeRemoveAttendee = attendeeService.deleteAttendeeById(attendeeId);
        ApiResponse<Attendee> response = null;
        if (storeRemoveAttendee){
            response =ApiResponse.<Attendee>builder()
                    .message("delete data success")
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
        }else{
            response =ApiResponse.<Attendee>builder()
                    .message("delete data not success")
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Attendee>> updateAttendeeById
            (@RequestBody AttendeeRequest attendeeRequest, @RequestParam("id") Integer attendeeId){
        Integer storeUpdate = attendeeService.updateAttendeeById(attendeeRequest,attendeeId);
        ApiResponse<Attendee> response = null;
        if(storeUpdate != null){
            response =  ApiResponse.<Attendee>builder()
                    .message("The attendee has been successfully updated")
                    .payload(attendeeService.getOneAttendee(attendeeId))
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
        } else{
                return ResponseEntity.ok(null);
        }

        return ResponseEntity.ok(response);
    }

}
