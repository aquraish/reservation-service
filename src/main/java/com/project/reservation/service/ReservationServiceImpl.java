package com.project.reservation.service;

import com.project.reservation.dao.ReservationDao;
import com.project.reservation.entity.Reservation;
import com.project.reservation.mapper.ReservationMapper;
import com.project.reservation.model.ReservationDates;
import com.project.reservation.model.ReservationRequest;
import com.project.reservation.model.UpdateReservationRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Data
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationDao reservationDao;
    private final ReservationMapper reservationMapper;

    @Override
    public Boolean checkAvailability(@Valid ReservationDates reservationDates) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Date arrivalDate = null;
        try {
            arrivalDate = simpleDateFormat.parse(reservationDates.getStartDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date departureDate = null;
        try {
            departureDate = simpleDateFormat.parse(reservationDates.getEndDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Reservation> reservations =
            reservationDao.findByArrivalDateAndDepartureDate(arrivalDate, departureDate);
        return CollectionUtils.isEmpty(reservations);
    }

    @Override
    public void cancelReservation(Long id) {
        reservationDao.deleteById(id);
    }

    @Override
    public Long makeReservation(@Valid ReservationRequest body) {
        Reservation reservation = reservationMapper.mapReservation(body);
        return reservationDao.save(reservation).getId();
    }

    @Override
    public void modifyReservation(UpdateReservationRequest body) {
        Reservation reservation =
            reservationDao.findById(body.getId()).orElseThrow(IllegalArgumentException::new);
        Reservation updateReservation = reservationMapper.mapUpdateReservation(reservation);
        reservationDao.save(updateReservation);
    }
}
