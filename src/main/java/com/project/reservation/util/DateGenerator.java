package com.project.reservation.util;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DateGenerator {

        public List<LocalDate> getDates(Date startDate, Date endDate, List<Date> bookedDates) {

        long numOfDays = ChronoUnit.DAYS.between(startDate.toInstant(), endDate.toInstant());

        List<Date> listOfDates =
                Stream.iterate(
                        startDate.toInstant(),
                        date -> date.plus(1, ChronoUnit.DAYS)
                )
                        .limit(numOfDays)
                        .map(Date::from)
                        .collect(Collectors.toList());

        if (CollectionUtils.isEmpty(bookedDates)) {
            return listOfDates.stream().map(x -> x.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()).collect(Collectors.toList());
        } else {
            //Logic to determine available dates
            return null;
        }
    }
}
