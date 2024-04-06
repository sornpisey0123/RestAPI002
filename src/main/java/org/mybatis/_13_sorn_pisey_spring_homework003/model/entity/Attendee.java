package org.mybatis._13_sorn_pisey_spring_homework003.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Attendee {
    private Integer attendeeId;
    private String attendeeName;
    private String email;
}
