package com.project.reservation.service;

import com.project.reservation.dao.ReservationDao;
import com.project.reservation.entity.Reservation;
import com.project.reservation.mapper.ReservationMapper;
import com.project.reservation.model.ReservationDates;
import com.project.reservation.model.ReservationRequest;
import com.project.reservation.model.UpdateReservationRequest;
import com.project.reservation.util.DateGenerator;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    private final ReservationDao reservationDao;
    private final ReservationMapper reservationMapper;
    private final DateGenerator dateGenerator;
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);

    @Override
    public List<LocalDate> checkAvailability(@Valid ReservationDates reservationDates) {

        Date arrivalDate = getArrivalDate(reservationDates);
        Date departureDate = getDepartureDate(reservationDates);

        List<Reservation> reservations =
                reservationDao.findExistingBookings();

        List<Date> bookedDates = reservations.stream()
                .map(Reservation::getArrivalDate)
                .collect(Collectors.toList());


        List<LocalDate> generatedDates = dateGenerator.getDates(arrivalDate, departureDate, bookedDates);

        return generatedDates;
    }

    private Date getDepartureDate(@Valid ReservationDates reservationDates) {

        Date departureDate;
        String endDate = reservationDates.getEndDate();

        if (endDate == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_YEAR, 31);
            departureDate = calendar.getTime();
        } else {
            try {
                departureDate = simpleDateFormat.parse(endDate);
            } catch (ParseException e) {
                throw new IllegalArgumentException("Invalid date " + endDate + ". Expected format - " + DATE_FORMAT);
            }
        }
        return departureDate;
    }

    private Date getArrivalDate(@Valid ReservationDates reservationDates) {

        Date arrivalDate;
        String startDate = reservationDates.getStartDate();

        if (startDate == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            arrivalDate = calendar.getTime();
        } else {
            try {
                arrivalDate = simpleDateFormat.parse(startDate);
            } catch (ParseException e) {
                throw new IllegalArgumentException("Invalid date " + startDate + ". Expected format - " + DATE_FORMAT);
            }
        }
        return arrivalDate;
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
