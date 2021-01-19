package com.project.reservation.dao;

import com.project.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationDao extends CrudRepository<Reservation, Long> {

    @Query(value = "SELECT r FROM Reservation r WHERE r.arrivalDate > CURRENT_DATE OR r.departureDate > CURRENT_DATE")
    List<Reservation> findExistingBookings();

}
