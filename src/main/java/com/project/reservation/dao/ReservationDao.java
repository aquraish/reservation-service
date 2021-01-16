package com.project.reservation.dao;

import com.project.reservation.entity.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ReservationDao extends CrudRepository<Reservation, Long> {

    List<Reservation> findByArrivalDateAndDepartureDate(Date arrivalDate, Date departureDate);

}
