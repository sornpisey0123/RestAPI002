package org.mybatis._13_sorn_pisey_spring_homework003.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mybatis._13_sorn_pisey_spring_homework003.model.entity.Attendee;

import java.sql.Timestamp;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AttendeeRequest {
     private String attendeeName;
     private String email;
}
