package org.mybatis._13_sorn_pisey_spring_homework003.model.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VenueRequest {
    private String venueName;
    private String location;
}
