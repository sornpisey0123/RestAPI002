package org.mybatis._13_sorn_pisey_spring_homework003.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Event {
    private Integer eventId;
    private String eventName;
    private Timestamp eventDate;
    private Integer venueId;

}