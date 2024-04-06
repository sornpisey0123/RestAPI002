CREATE DATABASE spring_homework003_db;


CREATE TABLE IF NOT EXISTS attendees(
                                        attendee_id  SERIAL PRIMARY KEY ,
                                        attendee_name VARCHAR(50),
                                        email VARCHAR(50)
);
CREATE TABLE IF NOT EXISTS venues(
                                     venue_id SERIAL PRIMARY KEY ,
                                     venue_name VARCHAR(50),
                                     location VARCHAR(50)
);
CREATE TABLE IF NOT EXISTS events(
                                     event_id SERIAL PRIMARY KEY,
                                     event_name VARCHAR(50),
                                     event_date timestamptz,
                                     venue_id INTEGER,
                                     CONSTRAINT fk_events_venue_id FOREIGN KEY (venue_id) REFERENCES venues(venue_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE IF NOT EXISTS event_attendee(
                                             id SERIAL PRIMARY KEY,
                                             event_id INTEGER,
                                             attendee_id INTEGER,
                                             CONSTRAINT fk_event_attendee_event_id FOREIGN KEY (event_id) REFERENCES events(event_id) ON DELETE CASCADE ON UPDATE CASCADE,
                                             CONSTRAINT fk_event_attendee_attendee_id FOREIGN KEY (attendee_id) REFERENCES attendees(attendee_id) ON DELETE CASCADE ON UPDATE CASCADE

);
