package org.mybatis._13_sorn_pisey_spring_homework003.repository;

import org.apache.ibatis.annotations.*;
import org.mybatis._13_sorn_pisey_spring_homework003.model.entity.Attendee;
import org.mybatis._13_sorn_pisey_spring_homework003.model.request.AttendeeRequest;

import java.util.List;

@Mapper
public interface AttendeeRepository {
    @Select("SELECT  *  FROM  attendees " +
            "LIMIT #{size} " +
            "OFFSET #{size} * ( #{page} - 1 )")
    @Results(
            id = "AttendeeMapper",
            value = {
                    @Result(property = "attendeeId" , column = "attendee_id"),
                    @Result(property = "attendeeName" , column = "attendee_name"),
                    @Result(property = "email" , column = "email")
            }
    )
    List<Attendee> findAllAttendee(Integer page , Integer size);


    @Select("SELECT * FROM  attendees " +
            "WHERE attendee_id = #{attendeeId}")
    @ResultMap("AttendeeMapper")
    Attendee findOneAttendee(Integer attendeeId);

    @Select("INSERT INTO  attendees ( attendee_name, email) " +
            "VALUES( #{request.attendeeName}, #{request.email} ) " +
            "RETURNING attendee_id")
    Integer saveAttendee(@Param("request")AttendeeRequest attendeeRequest);

    @Delete("DELETE FROM attendees WHERE attendee_id = #{attendeeId}")
    @ResultMap("authorMapper")
    boolean removeAuthorById(Integer attendeeId);

   @Select("UPDATE attendees " +
           "SET  attendee_name = #{request.attendeeName} ," +
           " email = #{request.email} " +
           "WHERE attendee_id = #{attendeeId}  " +
           " RETURNING attendee_id ")
    Integer editAttendeeById(@Param("request") AttendeeRequest attendeeRequest, Integer attendeeId);
}
