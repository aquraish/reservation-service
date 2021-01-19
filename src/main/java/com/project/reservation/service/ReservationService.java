package com.project.reservation.service;

import com.project.reservation.model.ReservationDates;
import com.project.reservation.model.ReservationRequest;
import com.project.reservation.model.UpdateReservationRequest;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ReservationService {

    List<LocalDate> checkAvailability(@Valid ReservationDates reservationDates);

    void cancelReservation(Long id);

    Long makeReservation(@Valid ReservationRequest body);

    void modifyReservation(UpdateReservationRequest body);
}
