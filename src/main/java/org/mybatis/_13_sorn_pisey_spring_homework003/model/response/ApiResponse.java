package org.mybatis._13_sorn_pisey_spring_homework003.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ApiResponse<T>{
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL) // ignore the field when null
    private T payload;
    private HttpStatus httpStatus;
    private Timestamp timestamp;
}
