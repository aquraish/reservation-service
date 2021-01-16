package com.project.reservation.service;

import com.project.reservation.model.ReservationDates;
import com.project.reservation.model.ReservationRequest;
import com.project.reservation.model.UpdateReservationRequest;
import javax.validation.Valid;

public interface ReservationService {

    Boolean checkAvailability(@Valid ReservationDates reservationDates);

    void cancelReservation(Long id);

    Long makeReservation(@Valid ReservationRequest body);

    void modifyReservation(UpdateReservationRequest body);
}
